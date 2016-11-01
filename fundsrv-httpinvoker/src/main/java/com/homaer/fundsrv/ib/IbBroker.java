package com.homaer.fundsrv.ib;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.net.SocketException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Semaphore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.homaer.cif.module.finance.HmStockInfo;
import com.homaer.common.cache.CacheManager;
import com.homaer.fundsrv.dataobject.BrokerOrderDto;
import com.homaer.fundsrv.module.ib.BrokerOrder;
import com.homaer.fundsrv.module.ib.InitContants;
import com.homaer.fundsrv.module.ib.MarketData;
import com.homaer.fundsrv.module.ib.PositionsInfo;
import com.homaer.fundsrv.service.AccountCapitalService;
import com.homaer.fundsrv.service.BrokerOrderService;
import com.ib.client.Contract;
import com.ib.client.EClientSocket;
import com.ib.client.EWrapper;
import com.ib.client.ExecutionFilter;
import com.ib.client.Order;
import com.ib.client.TagValue;
import com.ib.controller.NewContract;


@Service(value = "ibBroker")
public class IbBroker
{
  /**
   * tws部署服务器ip
   */
  public static final String TWS_HOST = InitContants.TWS_HOST;
  /**
   * 股价查询TWS配置
   */
  public static final String TWS_HOST_QUERY = InitContants.TWS_HOST_QUERY;
  public static int reqId = InitContants.TWS_HOST_REQID;
  public static int tickerId = InitContants.TWS_HOST_TICKERID;
  /**
   * tws指定端口
   */
  public static final int TWS_PORT = InitContants.TWS_PORT;
  @Autowired
  private BrokerOrderService brokerOrderService;
  @Autowired
  private CacheManager cacheManager;
  @Autowired
  private AccountCapitalService accountCapitalService;
  @SuppressWarnings("unused")
  private static Semaphore apiAccessSemaphore;
  @SuppressWarnings("unused")
  private static Double lastBalance = null;
  private Random rand = new Random();
  private ConcurrentHashMap<String, String> accountValues = new ConcurrentHashMap<String, String>();
  private ConcurrentHashMap<String, Integer> portfolio = new ConcurrentHashMap<String, Integer>();
  private String accountUpdateTime;
  private ConcurrentHashMap<Integer, Double> lastPrices = new ConcurrentHashMap<Integer, Double>();
  public ConcurrentHashMap<String, Double> portfolioPnl = new ConcurrentHashMap<String, Double>();
  // 委托交易、交易记录EClientSocket
  private static ConcurrentHashMap<Integer, EClientSocket> csMap = new ConcurrentHashMap<Integer, EClientSocket>();
  private static ConcurrentHashMap<Integer, IbBrokerWrapper> bwMap = new ConcurrentHashMap<Integer, IbBrokerWrapper>();
  // 即时股价查询EClientSocket
  private static ConcurrentHashMap<Integer, EClientSocket> csQueryMap = new ConcurrentHashMap<Integer, EClientSocket>();
  private static ConcurrentHashMap<Integer, IbBrokerWrapper> bwQueryMap = new ConcurrentHashMap<Integer, IbBrokerWrapper>();
  private static ConcurrentHashMap<String, Boolean> initializedMap = new ConcurrentHashMap<String, Boolean>();
  private static Map<String, Integer> accountClientIdMap = new HashMap<String, Integer>();
  // private static final int MAX_SLEEP_MILLIS = 30000;
  private static final int MAX_SLEEP_MILLIS = 15000;
  /**
   * client id 最小数
   */
  @SuppressWarnings("unused")
  private static final int MIN_CLIEN_ID = 1;
  /**
   * client id 最大数
   */
  @SuppressWarnings("unused")
  private static final int MAX_CLIENT_ID = 5;


  /**
   * 判断此账户是否初始化执行了获取账户信息接口
   * 
   * @param account
   *          账户
   * @return
   */
  public boolean isInitialized(String account)
  {
    Boolean result = initializedMap.get(account);
    if (result == null)
    {
      result = false;
    }
    return result;
  }


  /**
   * 随机获取client id号
   * 
   * @return
   * @throws SocketException
   */
  public int randomClientId() throws SocketException
  {
    int ipNum = 0;
    // 配置文件读取clientid
    ipNum = InitContants.TWS_CLIENTID;
    return ipNum;
  }


  /**
   * 获取socket连接。
   * 
   * @param account
   * @return
   * @throws SocketException
   */
  public EClientSocket getEClientSocket() throws SocketException
  {
    Integer cid = null;
    if (cid == null)
    {
      cid = randomClientId();
    }
    EClientSocket temp = csMap.get(cid);
    if (temp == null || !temp.isConnected())
    {
      IbBrokerWrapper wrapperTemp = new IbBrokerWrapper(accountValues, portfolio, accountUpdateTime, lastPrices, portfolioPnl);
      temp = new EClientSocket(wrapperTemp);
      temp.eDisconnect();
      temp.eConnect(TWS_HOST, TWS_PORT, cid);
      csMap.put(cid, temp);
      bwMap.put(cid, wrapperTemp);
    }
    return temp;
  }


  /**
   * 获取股价socket连接。
   * 
   * @param account
   * @return
   * @throws SocketException
   */
  public EClientSocket getQueryEClientSocket(String account) throws SocketException
  {
    Integer cid = null;
    if (cid == null)
    {
      cid = randomClientId();
    }
    EClientSocket temp = csQueryMap.get(cid);
    if (temp == null || !temp.isConnected())
    {
      IbBrokerWrapper wrapperTemp = new IbBrokerWrapper(accountValues, portfolio, accountUpdateTime, lastPrices, portfolioPnl);
      temp = new EClientSocket(wrapperTemp);
      temp.eDisconnect();
      temp.eConnect(TWS_HOST_QUERY, TWS_PORT, cid);
      csQueryMap.put(cid, temp);
      bwQueryMap.put(cid, wrapperTemp);
    }
    return temp;
  }


  public IbBrokerWrapper getBrokerWrapper(int cId)
  {
    return bwMap.get(cId);
  }


  public IbBroker() throws SocketException
  {
    apiAccessSemaphore = new Semaphore(1, true);
  }


  public void initialize(String account) throws SocketException
  {
    getEClientSocket().reqAccountUpdates(true, account);
    // initialized = true;
    initializedMap.put(account, true);
  }


  public void wrapUp(String account) throws SocketException
  {
    getEClientSocket().reqAccountUpdates(false, account);
    getEClientSocket().eDisconnect();
  }


  public Float getAvailableFunds() throws InterruptedException
  {
    while (accountValues.get("AvailableFunds") == null)
    {
      // System.out.println("value is " +
      // accountValues.get("AvailableFunds") + "; sleeping...");
      Thread.sleep(1000);
    }
    return Float.valueOf(accountValues.get("AvailableFunds"));
  }


  public Float getNetLiquidationValue() throws InterruptedException
  {
    while (accountValues.get("NetLiquidation") == null)
    {
      Thread.sleep(1000);
    }
    return Float.valueOf(accountValues.get("NetLiquidation"));
  }


  public Float getCashBalance() throws InterruptedException
  {
    while (accountValues.get("TotalCashValue") == null)
    {
      Thread.sleep(1000);
    }
    return Float.valueOf(accountValues.get("TotalCashValue"));
  }


  public Double getContractPrice(BrokerOrder order, int tickType) throws InterruptedException
  {
    Integer id = rand.nextInt();
    lastPrices.put(id, -1.0);
    // int clientId = accountClientIdMap.get(order.getAccount());
    int clientId = InitContants.TWS_CLIENTID;
    bwMap.get(clientId).setTickType(tickType);
    // clientSocket.reqMktData(id, c, "", true);
    long sleepTime = 0;
    while (lastPrices.get(id) == -1.0)
    {
      System.out.println("waiting for price for request id " + id);
      Thread.sleep(1000);
      sleepTime += 1000;
      if (sleepTime > MAX_SLEEP_MILLIS)
      {
        System.out.println("timed out while waiting for price from request id " + id);
        break;
      }
    }
    Double price = lastPrices.get(id);
    lastPrices.remove(id);
    return price;
  }


  /*
   * public Contract getContract(String symbol){ Contract c = new Contract();
   * c.m_exchange = "SMART"; //c.m_primaryExch = "NASDAQ"; c.m_localSymbol =
   * symbol; c.m_currency = "USD"; c.m_secType = "STK"; return c; }
   */
  /*
   * public Contract getContract(String symbol){ Contract c = new Contract();
   * 
   * //hong kong c.m_exchange = "SEHK"; c.m_primaryExch = "SEHK";
   * 
   * //singapore c.m_exchange = "SGX"; c.m_primaryExch = "SGX";
   * 
   * c.m_localSymbol = symbol; c.m_currency = "SGD"; c.m_secType = "STK"; return
   * c; }
   */
  public Contract getContract(BrokerOrder order)
  {
    Contract c = new Contract();
    c.m_exchange = order.getExchange();
    if (!order.getExchange().equals("SMART"))
    {
      c.m_primaryExch = order.getExchange();
    }
    // c.m_primaryExch = "SGX";
    c.m_localSymbol = order.getSymbol();
    c.m_currency = order.getCurrency();
    c.m_secType = order.getType();
    System.out.println("symbol: " + c.m_localSymbol);
    System.out.println("exchange: " + c.m_exchange);
    System.out.println("primary exchange: " + c.m_primaryExch);
    System.out.println("currency: " + c.m_currency);
    return c;
  }


  /**
   * 取消委托订单。
   * 
   * @param orderId
   * @param account
   * @throws InterruptedException
   * @throws SocketException
   *           2016年3月10日
   * @author changhai.wang
   */
  public void cancelOrder(int orderId, String account) throws InterruptedException, SocketException
  {
    getEClientSocket().cancelOrder(orderId);
  }


  /**
   * 查询未完成交易记录。
   * 
   * @param account
   * @throws InterruptedException
   * @throws SocketException
   */
  public void reqAllOpenOrders() throws SocketException
  {
    getEClientSocket().reqAllOpenOrders();
  }


  /**
   * 买入委托交易。
   * 
   * @param buyOrder
   * @throws InterruptedException
   * @throws SocketException
   */
  public void buyOrder(BrokerOrder buyOrder) throws InterruptedException, SocketException
  {
    double price = buyOrder.getLimitPrice();
    int numShares = buyOrder.getTotalQuantity();
    String orderType = buyOrder.getOrderType();
    if (numShares > 0)
    {
      Order order = getOrder(1, numShares, price, buyOrder.getAccount(), buyOrder.getTimeForce(), orderType);
      order.m_orderId = buyOrder.getOrderId();
      Contract contract = getContract(buyOrder);
      // 设置时间格式
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      Calendar calendar = Calendar.getInstance();
      sdf.setTimeZone(TimeZone.getTimeZone("America/New_York"));
      // 保存到库，先占orderId位
      BrokerOrderDto orderDto = new BrokerOrderDto();
      orderDto.setOrderId(buyOrder.getOrderId() + "");
      orderDto.setClientid(order.m_clientId + "");
      orderDto.setPermid(order.m_permId);
      orderDto.setSymbol(buyOrder.getSymbol());
      orderDto.setAccount(buyOrder.getAccount());
      orderDto.setTotalquantity(buyOrder.getTotalQuantity());
      orderDto.setSentTime(sdf.format(calendar.getTime()));
      orderDto.setLimitprice(buyOrder.getLimitPrice());
      orderDto.setTimeForce(buyOrder.getTimeForce());
      orderDto.setActionIndex("BUY");
      orderDto.setStatus("MyStatus");
      orderDto.setFilled(0);
      orderDto.setOrderType(buyOrder.getOrderType());
      orderDto.setUserId(buyOrder.getUserId());
      brokerOrderService.doCreate(orderDto);
      getEClientSocket().placeOrder(order.m_orderId, contract, order);
      buyOrder.setNumContracts(numShares);
      // 20160322 16:53:37
      buyOrder.setSentTime(sdf.format(calendar.getTime()));
      buyOrder.setOpeningPrice(price);
      System.out.println("placed buy order for " + numShares + " of " + buyOrder.getSymbol());
    }
    else
    {
      System.out.println("buy order not placed (0 shares requested)");
    }
  }


  public Order getOrder(String account, int actionIndex, int numShares) throws InterruptedException
  {
    Order order = new Order();
    int clientId = accountClientIdMap.get(account);
    order.m_clientId = clientId;
    order.m_orderType = "MKT";
    if (actionIndex == 1)
    {
      order.m_action = "BUY";
    }
    else if (actionIndex == 2)
    {
      order.m_action = "SELL";
    }
    // int orderId = Math.abs(rand.nextInt());
    // int orderId = getNextOrderId();
    // System.out.println("order id: " + orderId);
    // order.m_orderId = orderId;
    int permId = Math.abs(rand.nextInt());
    System.out.println("new order perm id: " + permId);
    order.m_permId = permId;
    order.m_totalQuantity = numShares;
    order.m_outsideRth = true;
    order.m_tif = "GTC";
    order.m_lmtPrice = 0.0;
    order.m_auxPrice = 0.0;
    return order;
  }


  public Order getOrder(int actionIndex, int numShares, double limitPrice, String account, String timeForce, String orderType) throws InterruptedException, SocketException
  {
    Order order = new Order();
    // System.out.println(accountClientIdMap.size() + "================");
    // int clientId = accountClientIdMap.get(account).getClientId();
    int clientId = randomClientId();
    order.m_clientId = clientId;
    // order.m_orderType = "LMT";
    order.m_orderType = orderType;
    // limitPrice = (double) ((int)(limitPrice*100)) / 100;
    System.out.println("using calculated limit price: " + limitPrice);
    order.m_lmtPrice = limitPrice;
    order.m_overridePercentageConstraints = true;
    if (actionIndex == 1)
    {
      order.m_action = "BUY";
    }
    else if (actionIndex == 2)
    {
      order.m_action = "SELL";
    }
    int permId = Math.abs(rand.nextInt());
    System.out.println("new order perm id: " + permId);
    order.m_permId = permId;
    order.m_totalQuantity = numShares;
    order.m_outsideRth = true;
    order.m_tif = timeForce;
    order.m_account = account;
    return order;
  }


  /*
   * private int getNextOrderId() throws InterruptedException{
   * 
   * wrapper.setNextOrderId(0); do{ clientSocket.reqIds(1); Thread.sleep(500);
   * }while(wrapper.getNextOrderId() == 0);
   * 
   * return wrapper.getNextOrderId();
   * 
   * }
   */
  public int getNumShares(BrokerOrder order, Double price) throws InterruptedException
  {
    Float liquidation = getNetLiquidationValue();
    System.out.println("liquidation value: " + liquidation);
    Float cash = getCashBalance();
    System.out.println("cash value: " + cash);
    Float investment = (liquidation / 100f) * order.getPercentOfAccount();
    System.out.println("investment: " + investment);
    if (price == -1.0)
    {
      System.out.println("unable to obtain share price");
      return 0;
    }
    System.out.println("price: " + price);
    if (investment > cash - BrokerSettings.MIN_CASH_BALANCE)
    {
      System.out.println("not enough cash on hand for investment");
      return 0;
    }
    int numShares = (int) (investment / price);
    System.out.println("num shares: " + numShares);
    return numShares;
  }


  public void sellOrder(BrokerOrder sellOrder) throws InterruptedException, SocketException
  {
    System.out.println("starting sellOrder");
    // Double price = getContractPrice(sellOrder, TickType.BID);
    // int numShares = getNumShares(sellOrder, price);
    // 价格、数量 直接从传参部分取值-----待定
    Double price = sellOrder.getLimitPrice();
    int numShares = sellOrder.getTotalQuantity();
    if (numShares > 0)
    {
      System.out.println("preparing to sell " + numShares + " shares");
      Order order = getOrder(2, numShares, price, sellOrder.getAccount(), sellOrder.getTimeForce(), sellOrder.getOrderType());
      order.m_orderId = sellOrder.getOrderId();
      Contract contract = getContract(sellOrder);
      // 设置时间格式
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      Calendar calendar = Calendar.getInstance();
      sdf.setTimeZone(TimeZone.getTimeZone("America/New_York"));
      // 保存到库，先占orderId位
      BrokerOrderDto orderDto = new BrokerOrderDto();
      orderDto.setOrderId(sellOrder.getOrderId() + "");
      orderDto.setClientid(order.m_clientId + "");
      orderDto.setPermid(order.m_permId);
      orderDto.setSymbol(sellOrder.getSymbol());
      orderDto.setAccount(sellOrder.getAccount());
      orderDto.setTotalquantity(sellOrder.getTotalQuantity());
      orderDto.setSentTime(sdf.format(calendar.getTime()));
      orderDto.setLimitprice(sellOrder.getLimitPrice());
      orderDto.setTimeForce(sellOrder.getTimeForce());
      orderDto.setActionIndex("SELL");
      orderDto.setStatus("MyStatus");
      orderDto.setFilled(0);
      orderDto.setOrderType(sellOrder.getOrderType());
      orderDto.setUserId(sellOrder.getUserId());
      brokerOrderService.doCreate(orderDto);
      getEClientSocket().placeOrder(order.m_orderId, contract, order);
      sellOrder.setNumContracts(numShares);
      // 20160322 16:53:37
      sellOrder.setSentTime(sdf.format(calendar.getTime()));
      sellOrder.setOpeningPrice(price);
      // sellOrder.persist();
      System.out.println("placed sell order for " + numShares + " of " + sellOrder.getSymbol());
    }
    else
    {
      System.out.println("sell order not placed (0 shares requested)");
    }
  }


  public Double getPnl(String symbol) throws InterruptedException
  {
    long sleepTime = 0;
    System.out.println("waiting for P&L for " + symbol);
    while (portfolioPnl.get(symbol) == -1.0)
    {
      sleepTime += 1000;
      if (sleepTime > MAX_SLEEP_MILLIS)
      {
        System.out.println("timed out while waiting for P&L for symbol " + symbol);
        return null;
      }
      Thread.sleep(500);
    }
    Double pnl = portfolioPnl.get(symbol);
    System.out.println("got P&L for symbol " + symbol + ": " + pnl);
    return pnl;
  }


  @SuppressWarnings("static-access")
  public void setLastBalance(double lastBalance)
  {
    this.lastBalance = lastBalance;
  }


  public ConcurrentHashMap<String, Integer> getPortfolio()
  {
    return this.portfolio;
  }


  public ConcurrentHashMap<String, Double> getPortfolioPnl()
  {
    return portfolioPnl;
  }


  /**
   * 发送交易记录请求并接受记录到缓存。
   * 
   * @param account
   * @return
   * @throws SocketException
   *           2016年3月7日
   * @author changhai.wang
   * @throws InterruptedException
   */
  public List<BrokerOrder> reqOrder(String account) throws SocketException, InterruptedException
  {
    ExecutionFilter objFilter;
    EClientSocket objSocket;
    EWrapper objEwrapper;
    reqId = reqId + 1;
    objFilter = new ExecutionFilter();
    objFilter.m_clientId = 0;
    objSocket = getEClientSocket();
    // 发送请求只返回阶段成交详情，避免出现
    objSocket.reqExecutions(reqId, objFilter);
    objEwrapper = (EWrapper) objSocket.wrapper();
    // 等待ib推送1秒，之后要删掉
    Thread.sleep(300);
    return objEwrapper.getExecutionOrder(account);
  }


  /**
   * 发送持仓请求并接收记录存到缓存。
   * 
   * @param account
   * @return
   * @throws SocketException
   * @throws InterruptedException
   *           2016年3月4日
   * @author changhai.wang
   */
  @SuppressWarnings("unchecked")
  public List<PositionsInfo> reqPositions(String account) throws SocketException, InterruptedException
  {
    // 发送请求，并在2S后保存数据库
    // reqId = reqId + 1;
    // 直接从缓存中/库中取值
    // return null;
    // 清空缓存数据
    List<PositionsInfo> lstPosition = new ArrayList<PositionsInfo>();
    if (null != cacheManager.get(account + "-newPositions"))
    {
      lstPosition = (List<PositionsInfo>) cacheManager.get(account + "-newPositions");
    }
    if (CollectionUtils.isEmpty(lstPosition))
    {
      System.out.println("newPositions取值持仓为空--reqPositions");
      lstPosition = (List<PositionsInfo>) cacheManager.get(account + "-oldPositions");
    }
    // if (CollectionUtils.isEmpty(lstPosition)){
    // System.out.println("old取值持仓为空");
    // lstPosition = (List<PositionsInfo>) cacheManager.get(account +
    // "-newPositions");
    // }
    Date oldDate = null;
    Date now = new Date();
    boolean isSent = false;
    if (null != cacheManager.get(account + "-sentPositionsTime"))
    {
      oldDate = (Date) cacheManager.get(account + "-sentPositionsTime");
      if (now.getTime() - oldDate.getTime() > 5000)
      {
        isSent = true;
      }
    }
    else
    {
      isSent = true;
    }
    if (isSent)
    {
      // cacheManager.set(account + "-newPositions", 0, lstPositionNew);
      ExecutionFilter objFilter;
      EClientSocket objSocket;
      EWrapper objEwrapper;
      reqId = reqId + 1;
      objFilter = new ExecutionFilter();
      objFilter.m_clientId = 0;
      objSocket = getEClientSocket();
      System.out.println(reqId + "--------reqId---------reqPositions");
      cacheManager.set(account + "-sentPositionsTime", 0, new Date());
      objSocket.reqPositions();
      // Thread.sleep(5000);
      // objSocket.cancelPositions();
      objEwrapper = (EWrapper) objSocket.wrapper();
      ReqPositions reqP = new ReqPositions(account, objSocket, objEwrapper);
      Thread thread = new Thread(reqP);
      thread.start();
    }
    else
    {
      System.out.println("5s之内已经请求过持仓，暂不发送请求");
    }
    return lstPosition;
  }


  public MarketData getAccountValues(String account) throws SocketException, InterruptedException
  {
    // 主动请求
    ExecutionFilter objFilter;
    EClientSocket objSocket;
    // EWrapper objEwrapper;
    reqId = reqId + 1;
    objFilter = new ExecutionFilter();
    objFilter.m_clientId = 0;
    objSocket = getEClientSocket();
    objSocket.reqAccountUpdates(true, account);
    // objEwrapper = (EWrapper) objSocket.wrapper();
    // 至少等待ib推送400毫秒，不要删除
    Thread.sleep(400);
    objSocket.reqAccountUpdates(false, account);
    // 判断缓存是否存在
    MarketData objCacheMarket = null;
    if (null != cacheManager.get(account + "MarketData"))
    {
      objCacheMarket = (MarketData) cacheManager.get(account + "MarketData");
    }
    if (null == objCacheMarket)
    {
      // 判断数据库是否存在
      MarketData market = new MarketData();
      List<MarketData> lstMark = new ArrayList<MarketData>();
      market.setAccount(account);
      lstMark = accountCapitalService.getAccountCapitalList(market);
      if (!CollectionUtils.isEmpty(lstMark))
      {
        objCacheMarket = lstMark.get(0);
        cacheManager.set(account + "MarketData", 0, objCacheMarket);
      }
      else
      {
        objCacheMarket = (MarketData) cacheManager.get(account + "MarketData");
      }
    }
    return objCacheMarket;
  }


  /**
   * 获取账户可流动资金。
   * 
   * @param account
   * @return
   * @throws SocketException
   * @throws InterruptedException
   *           2016年3月10日
   * @author changhai.wang
   */
  public String getCashBalance(String account) throws SocketException, InterruptedException
  {
    ExecutionFilter objFilter;
    EClientSocket objSocket;
    EWrapper objEwrapper;
    reqId = reqId + 1;
    objFilter = new ExecutionFilter();
    objFilter.m_clientId = 0;
    objSocket = getEClientSocket();
    objSocket.reqAccountUpdates(true, account);
    objEwrapper = (EWrapper) objSocket.wrapper();
    // 等待ib推送1秒，之后要删掉
    Thread.sleep(300);
    return objEwrapper.getCashBalance(account);
  }


  public HmStockInfo getRealTime(String account, String symbol) throws SocketException, InterruptedException
  {
    ExecutionFilter objFilter;
    EClientSocket objSocket;
    // EWrapper objEwrapper;
    reqId = reqId + 1;
    objFilter = new ExecutionFilter();
    objFilter.m_clientId = 0;
    objSocket = getQueryEClientSocket(account);
    NewContract newContract = new NewContract();
    Contract contract = newContract.getContract();
    contract.m_currency = "USD";
    contract.m_exchange = "SMART";
    contract.m_includeExpired = false;
    contract.m_primaryExch = "ISLAND";
    contract.m_secType = "STK";
    contract.m_strike = 0.0;
    contract.m_symbol = symbol;
    tickerId = tickerId + 1;
    String genericTickList = "";
    boolean snapshot = false;
    List<TagValue> mktDataOptions = new ArrayList<TagValue>();
    objSocket.reqMktData(tickerId, contract, genericTickList, snapshot, mktDataOptions);
    // objEwrapper = (EWrapper) objSocket.wrapper();
    // 等待ib推送1秒，之后要删掉
    Thread.sleep(300);
    return getMktData(tickerId, symbol);
  }


  public HmStockInfo getMktData(int tickerId, String symbol)
  {
    // change = (last - close)
    HmStockInfo objHmStock;
    String last = (String) cacheManager.get("tickerId_last" + tickerId);
    String close = (String) cacheManager.get("tickerId_close" + tickerId);
    System.out.println("即时股价Ib" + symbol + "--" + tickerId + "---" + last + "---" + close);
    if (StringUtils.isEmpty(last))
    {
      last = "0.0";
      return null;
    }
    if (StringUtils.isEmpty(close))
    {
      close = "0.0";
      return null;
    }
    System.out.println("即时股价Ib" + symbol + "--" + tickerId + "---" + last + "---" + close);
    BigDecimal bigLast = new BigDecimal(last);
    BigDecimal bigClose = new BigDecimal(close);
    MathContext mc = new MathContext(2, RoundingMode.HALF_DOWN);
    BigDecimal change = bigLast.subtract(bigClose).setScale(2, BigDecimal.ROUND_HALF_DOWN);
    BigDecimal change_per;
    BigDecimal zero = new BigDecimal(0).setScale(2, BigDecimal.ROUND_HALF_DOWN);
    if (change.equals(zero))
    {
      change_per = new BigDecimal(0);
    }
    else
    {
      change_per = change.divide(bigClose, mc).multiply(new BigDecimal("100")).setScale(2, BigDecimal.ROUND_HALF_DOWN);
    }
    objHmStock = new HmStockInfo();
    objHmStock.setSymbol(symbol);
    objHmStock.setPrice(last);
    objHmStock.setChange(change + "");
    objHmStock.setChange_per(change_per + "");
    System.out.println("即时股价Ib" + objHmStock.getChange() + "-----" + objHmStock.getChange_per());
    return objHmStock;
  }


  public void destroy()
  {
    for (EClientSocket socket : csMap.values())
    {
      try
      {
        if (null != socket)
        {
          socket.eDisconnect();
        }
      }
      catch (Exception ex)
      {
        ex.printStackTrace();
      }
    }
    for (EClientSocket socket : csQueryMap.values())
    {
      try
      {
        if (null != socket)
        {
          socket.eDisconnect();
        }
      }
      catch (Exception ex)
      {
        ex.printStackTrace();
      }
    }
  }


  public void reqAccountSummary(String account) throws SocketException, InterruptedException
  {
    System.out.println("reqAccountSummary执行！！！");
    // 主动请求
    ExecutionFilter objFilter;
    EClientSocket objSocket;
    reqId = reqId + 1;
    objFilter = new ExecutionFilter();
    objFilter.m_clientId = 0;
    objSocket = getEClientSocket();
    objSocket
        .reqAccountSummary(
            reqId,
            "All",
            "AccountType,NetLiquidation,TotalCashValue,SettledCash,AccruedCash,BuyingPower,EquityWithLoanValue,PreviousEquityWithLoanValue,GrossPositionValue,RegTEquity,RegTMargin,SMA,InitMarginReq,MaintMarginReq,AvailableFunds,ExcessLiquidity,Cushion,FullInitMarginReq,FullMaintMarginReq,FullAvailableFunds,FullExcessLiquidity,LookAheadNextChange,LookAheadInitMarginReq,LookAheadMaintMarginReq,LookAheadAvailableFunds,LookAheadExcessLiquidity,HighestSeverity,DayTradesRemaining,Leverage");
  }
}
