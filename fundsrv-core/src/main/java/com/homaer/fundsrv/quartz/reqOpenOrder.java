package com.homaer.fundsrv.quartz;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.homaer.common.cache.CacheManager;
import com.homaer.common.tools.log.LoggerUtils;
import com.homaer.crm.hessian.service.CrmDataService;
import com.homaer.fundsrv.mail.MailSendService;
import com.homaer.fundsrv.module.ib.InitContants;
import com.homaer.fundsrv.module.ib.MarketData;
import com.homaer.fundsrv.service.AccountCapitalService;
import com.homaer.fundsrv.service.IbService;


public class reqOpenOrder
{
  @Autowired
  private CacheManager cacheManager;
  @Autowired
  private IbService ibService;
  @Resource
  private MailSendService mailSendService;
  @Autowired
  private CrmDataService crm;
  @Resource
  private AccountCapitalService accountCapitalService;
  public static final String TWS_CONNECT_FAIL_EMIAL = InitContants.TWS_CONNECT_FAIL_EMIAL;
  public static final String TWS_CONNECT_FAIL_CCEMIAL = InitContants.TWS_CONNECT_FAIL_CCEMIAL;
  protected static final Logger logger = LoggerFactory.getLogger(LoggerUtils.SERVICE_LOGGER);


  public void execute() throws SocketException, InterruptedException
  {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    Calendar calendar = Calendar.getInstance();
    logger.info("定时任务==" + sdf.format(calendar.getTime()));
    // 清空缓存中连接中断标识
    cacheManager.set("CONNECT_FAIL", 0, "0");
    String connectFailNum = "0";
    int failNum = 0;
    connectFailNum = (String) cacheManager.get("CONNECT_FAIL");
    // 获取账户集合
    MarketData objMarket = new MarketData();
    List<MarketData> lstMarket = new ArrayList<MarketData>();
    // objMarket.setNetLiquidationByCurrency("0");
    lstMarket = accountCapitalService.getAccountCapitalList(objMarket);
    Map<String, MarketData> marketMap = new HashMap<String, MarketData>();
    if (!CollectionUtils.isEmpty(lstMarket))
    {
      for (int i = 0; i < lstMarket.size(); i++)
      {
        marketMap.put(lstMarket.get(i).getAccount(), lstMarket.get(i));
      }
    }
    if (CollectionUtils.isNotEmpty(lstMarket))
    {
      System.out.println(lstMarket.size() + "请求账户个数----");
      ibService.reqPositions("");
      for (int i = 0; i < lstMarket.size(); i++)
      {
        if (StringUtils.isNotEmpty(lstMarket.get(i).getAccount()))
        {
          // System.out.println("请求账户----" + lstMarket.get(i).getAccount());
          // 循环请求账户资金
          @SuppressWarnings("unused")
          MarketData objUseMarket = new MarketData();
          objUseMarket = ibService.getAccountValues(lstMarket.get(i).getAccount());
          // if (null != objUseMarket &&
          // StringUtils.isNotEmpty(objUseMarket.getCashBalance()) &&
          // Integer.parseInt(objUseMarket.getCashBalance()) > 0) {
          // // 若返回可用资金，调用CRM接口更新t_broker_info账户状态，发短信
          // if (null != marketMap.get(objUseMarket.getAccount()) && null !=
          // marketMap.get(objUseMarket.getAccount()).getCashBalance() &&
          // Integer.parseInt(marketMap.get(objUseMarket.getAccount()).getCashBalance())
          // == 0) {
          // System.out.println("调用crm发短信");
          // crm.traderAccountBySMS(objUseMarket.getAccount());
          // }
          //
          // System.out.println("账户资金==fff=======" +
          // objUseMarket.getCashBalance());
          // }
          //
          // 循环请求账户持仓，并保存到库
        }
      }
    }
    else
    {
      System.out.println("获取要查询集合为空！！！！");
    }
    ibService.reqOpenOrders();
    Thread.sleep(3000);// 等待10秒
    if (null != cacheManager.get("CONNECT_FAIL"))
    {
      connectFailNum = (String) cacheManager.get("CONNECT_FAIL");
      failNum = Integer.parseInt(connectFailNum);
    }
    int reqTimes = 1;
    while (failNum > 0 && reqTimes < 10)
    {
      // ibService.reqOpenOrders();
      Thread.sleep(3000);// 等待10秒
      reqTimes = reqTimes + 1;
      System.out.println("连接请求次数===" + reqTimes);
    }
    if (null != cacheManager.get("CONNECT_FAIL"))
    {
      connectFailNum = (String) cacheManager.get("CONNECT_FAIL");
    }
    System.out.println("连接中断次数" + connectFailNum);
    if (Integer.parseInt(connectFailNum) > 5)
    {
      List<String> iplst = new ArrayList<String>();
      String ipNum = "";
      String time = sdf.format(calendar.getTime());
      @SuppressWarnings("rawtypes")
      Enumeration allNetInterfaces = NetworkInterface.getNetworkInterfaces();
      InetAddress ip = null;
      while (allNetInterfaces.hasMoreElements())
      {
        NetworkInterface netInterface = (NetworkInterface) allNetInterfaces.nextElement();
        @SuppressWarnings("rawtypes")
        Enumeration addresses = netInterface.getInetAddresses();
        while (addresses.hasMoreElements())
        {
          ip = (InetAddress) addresses.nextElement();
          if (ip != null && ip instanceof Inet4Address)
          {
            iplst.add(ip.getHostAddress());
          }
        }
      }
      if (null != iplst && iplst.size() > 0)
      {
        for (int i = 0; i < iplst.size(); i++)
        {
          if (!iplst.get(i).equalsIgnoreCase("127.0.0.1"))
          {
            ipNum = iplst.get(i);
          }
        }
      }
      String[] emailAdress = TWS_CONNECT_FAIL_CCEMIAL.split(",");
      if (TWS_CONNECT_FAIL_CCEMIAL.indexOf("test") < 0)
      {
        // 发送通知邮件
        mailSendService.sendConnectFailMail(ipNum, connectFailNum, time, TWS_CONNECT_FAIL_EMIAL, emailAdress, "yuyue@homaer.com", "重要-TWS连接中断");
      }
      else
      {
        mailSendService.sendConnectFailMail(ipNum, connectFailNum, time, TWS_CONNECT_FAIL_EMIAL, emailAdress, "yuyue@homaer.com", "重要-TWS连接中断");
      }
      // ------------------------------推送
    }
  }
}
