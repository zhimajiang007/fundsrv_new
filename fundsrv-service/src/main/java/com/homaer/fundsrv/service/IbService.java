package com.homaer.fundsrv.service;

import java.net.SocketException;
import java.util.List;

import com.homaer.cif.module.finance.HmStockInfo;
import com.homaer.fundsrv.module.ib.AccountSummary;
import com.homaer.fundsrv.module.ib.BrokerOrder;
import com.homaer.fundsrv.module.ib.MarketData;
import com.homaer.fundsrv.module.ib.OrderStatus;
import com.homaer.fundsrv.module.ib.PortfolioInfo;
import com.homaer.fundsrv.module.ib.PositionsInfo;

public interface IbService {

	/**
	 * 订单交易
	 * 
	 * @param symbol
	 * 			证券代码
	 * @param secType
	 * 			证券类型
	 * @param expiry
	 * 			过期日。使用格式 YYYYMM
	 * @param exchange
	 * 			订单交易所
	 * @param currency
	 * 			交易币种
	 * @param action
	 * 			交易类型： 有效值是： BUY、 SELL、 SSHORT
	 * @param totalQuantity
	 * 			订单数量
	 * @param orderType
	 * 			确认定单类型，例如："LMT"
	 * @param lmtPrice
	 * 			这是用于限价单、止损限价单和相对定单的限价。所有其它情形指定位零。对没有限价的相对定单，也指定为零
	 * @param account
	 * 			如果为顾问，需要指定子账户（为单一管理的账户下达定单）
	 * @return
	 * 			orderId(订单id)
	 * @throws SocketException 
	 */
	public int OrderPlace(String userId, String symbol, String secType, String expiry, String exchange, String currency
			, int action, int totalQuantity, String orderType, double lmtPrice, String account, String timeForce) throws SocketException;
	
	/**
	 * 修改订单
	 * 
	 * @param orderId
	 * 			订单id
	 * @param totalQuantity
	 * 			股数
	 * @param lmtPrice
	 * 			价格
	 * @return
	 * @throws SocketException 
	 */
	public int changeOrder(String userId, int orderId, int totalQuantity, double lmtPrice) throws SocketException;
	
	/**
	 * 获取订单状态
	 * 
	 * @param orderId
	 * 			订单号(调用 placeOrder()中指定的定单代号)
	 * @param account
	 * 			账户名
	 * @return 订单状态信息
	 */
	public OrderStatus getOrderStatus(int orderId, String account);
	
	/**
	 * 取消订单
	 * 
	 * @param orderId
	 * 			订单号(调用 placeOrder()中指定的定单代号) 
	 * @param account
	 * 			账号
	 * @throws SocketException 
	 */
	public void cancelOrder(int orderId, String account) throws SocketException;
	
	/**
	 * 获取账户资金信息
	 * 
	 * @param account
	 * 			账户名
	 * @return	账户各值类型数据集合
	 */
	public MarketData getAccountValues(String account) throws SocketException, InterruptedException;
	
	/**
	 * 获取账户资金信息
	 * 
	 * @param account
	 * 			账户名
	 * @return	账户各值类型数据集合
	 */
	public void reqAccountSummary(String account) throws SocketException, InterruptedException;
	
	
	/**
	 * 获取账户可流动资金
	 * 
	 * @param account
	 * 			账户名
	 * @return	账户各值类型数据集合
	 */
	public String getCashBalance(String account) throws SocketException, InterruptedException;
	
	/**
	 * 获取账户组合信息
	 * 
	 * @param account
	 * 			账户名
	 * @return 账户组合信息数据集合
	 */
	public List<PortfolioInfo> getAccountPortfolios(String account);
	
	/**
	 * 获取账户摘要概述信息
	 * 
	 * @param account
	 * 			账户名
	 * @return 账户摘要信息数据集合
	 */
	public List<AccountSummary> getAccountSummary(String account);
	
	/**
	 * 查询成交记录请求。
	 * 
	 * @param account
	 * @return
	 * @throws SocketException
	 * 2016年3月3日
	 * @author changhai.wang
	 */
	public List<BrokerOrder> reqOrder(String account) throws SocketException, InterruptedException;
	
	/**
	 * 发送持仓请求并接收记录存到缓存。
	 * 
	 * @param account
	 * 2016年3月3日
	 * @author changhai.wang
	 * @return 
	 */
	public List<PositionsInfo> reqPositions(String account) throws SocketException, InterruptedException;
	/**
	 * 获取即时股价
	 * @param symbol
	 * @throws SocketException
	 * @throws InterruptedException
	 */
	public HmStockInfo getRealTime(String account, String symbol) throws SocketException, InterruptedException;

	/**
	 * 查询未完成委托交易记录。
	 * 
	 * @param account
	 * @throws SocketException 
	 */
	public void reqOpenOrders() throws SocketException;
	
}
