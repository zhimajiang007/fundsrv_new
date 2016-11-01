package com.homaer.fundsrv.biz.apidata.ib;

import java.util.List;

import com.homaer.biz.framework.api.ApiResponse;
import com.homaer.cif.module.finance.HmStockInfo;
import com.homaer.fundsrv.module.ib.AccountSummary;
import com.homaer.fundsrv.module.ib.AccountValue;
import com.homaer.fundsrv.module.ib.BrokerOrder;
import com.homaer.fundsrv.module.ib.FinanceInfo;
import com.homaer.fundsrv.module.ib.MarketData;
import com.homaer.fundsrv.module.ib.OrderStatus;
import com.homaer.fundsrv.module.ib.PortfolioInfo;
import com.homaer.fundsrv.module.ib.PositionsInfo;

public class IbResponse extends ApiResponse {

	private static final long serialVersionUID = -2291949272843585127L;
	
	/**
	 * 每笔交易费用大于1美元的情况，按照0.005美元／股 收取（IB是0.005美元／股）
	 */
	public static final String IB_COMMISSIONRATE = "0.005";
	/**
	 * 每笔交易最少收取1美元的交易费（IB是最低1美元）
	 */
	public static final String IB_COMMISSION_MIN = "1";

	private int orderId;

	private OrderStatus orderStatus;

	private List<AccountValue> accounValues;

	private List<PortfolioInfo> portfolios;

	private List<AccountSummary> accountSummarys;
		
	// 持仓记录集合
	private List<PositionsInfo> lstPositions;
	
	// 委托交易集合====已成交/未成交
	private List<BrokerOrder> lstOrder;
	
	List<BrokerOrder> lstSubOrder;	// 已提交交易
	
	List<BrokerOrder> lstFilOrder; // 已完成交易
	
	private String orderCount; // 交易记录数量
	
	private String usaTime; // 美国时间
	
	private String timeUsaState; // EDT：东部夏令时间 EST：东部标准时间
	// 美国从每年4月到11月初采用夏令时，这段时间其交易时间为北京时间晚21：30－次日凌晨4：00。 
	// 而在11月初到4月初，采用冬令时，则交易时间为北京时间晚22：30－次日凌晨5：00
	
	private String tradeTime;
	
	private String cashBalance; // 可用资金
	
	private String openingState;// 是否开盘
	
	private String pcTime;//PC显示资金更新时间，如周一~周五显示当前日期，周六周日显示周五日期
	
	private String commissionRate;// 每笔交易费用大于1.99美元的情况，按照0.01美元／股 收取（IB是0.005美元／股）
	
	private String commissionMin; // 每笔交易最少收取1美元的交易费 （IB是最低1美元）
	
	private Integer position; // 持仓数量
	
	private MarketData marketData;
	
	private HmStockInfo hmStockInfo;
	
	private List<MarketData> lstMarket;// 目前功能被marketData替代，先保留
	
	private List<HmStockInfo> lstStockInfo;
	
	private FinanceInfo financeInfo;
	
	public String getTradeTime() {
		return tradeTime;
	}

	public void setTradeTime(String tradeTime) {
		this.tradeTime = tradeTime;
	}

	public String getTimeUsaState() {
		return timeUsaState;
	}

	public void setTimeUsaState(String timeUsaState) {
		this.timeUsaState = timeUsaState;
	}

	public String getPcTime() {
		return pcTime;
	}

	public void setPcTime(String pcTime) {
		this.pcTime = pcTime;
	}

	public FinanceInfo getFinanceInfo() {
		return financeInfo;
	}

	public void setFinanceInfo(FinanceInfo financeInfo) {
		this.financeInfo = financeInfo;
	}

	public HmStockInfo getHmStockInfo() {
		return hmStockInfo;
	}

	public void setHmStockInfo(HmStockInfo hmStockInfo) {
		this.hmStockInfo = hmStockInfo;
	}

	public MarketData getMarketData() {
		return marketData;
	}

	public void setMarketData(MarketData marketData) {
		this.marketData = marketData;
	}

	public String getOrderCount() {
		return orderCount;
	}

	public void setOrderCount(String orderCount) {
		this.orderCount = orderCount;
	}

	public String getCommissionMin()
	{
		return commissionMin;
	}

	public void setCommissionMin(String commissionMin)
	{
		this.commissionMin = commissionMin;
	}

	public List<HmStockInfo> getLstStockInfo()
	{
		return lstStockInfo;
	}

	public void setLstStockInfo(List<HmStockInfo> lstStockInfo)
	{
		this.lstStockInfo = lstStockInfo;
	}

	public List<BrokerOrder> getLstSubOrder() {
		return lstSubOrder;
	}

	public void setLstSubOrder(List<BrokerOrder> lstSubOrder) {
		this.lstSubOrder = lstSubOrder;
	}

	public List<BrokerOrder> getLstFilOrder() {
		return lstFilOrder;
	}

	public void setLstFilOrder(List<BrokerOrder> lstFilOrder) {
		this.lstFilOrder = lstFilOrder;
	}

	public List<MarketData> getLstMarket()
	{
		return lstMarket;
	}

	public void setLstMarket(List<MarketData> lstMarket)
	{
		this.lstMarket = lstMarket;
	}

	public Integer getPosition()
	{
		return position;
	}

	public void setPosition(Integer position)
	{
		this.position = position;
	}

	public String getCommissionRate()
	{
		return commissionRate;
	}

	public void setCommissionRate(String commissionRate)
	{
		this.commissionRate = commissionRate;
	}

	public String getCashBalance()
	{
		return cashBalance;
	}

	public void setCashBalance(String cashBalance)
	{
		this.cashBalance = cashBalance;
	}

	public String getUsaTime()
	{
		return usaTime;
	}

	public void setUsaTime(String usaTime)
	{
		this.usaTime = usaTime;
	}

	public String getOpeningState()
	{
		return openingState;
	}

	public void setOpeningState(String openingState)
	{
		this.openingState = openingState;
	}

	public List<BrokerOrder> getLstOrder()
	{
		return lstOrder;
	}

	public void setLstOrder(List<BrokerOrder> lstOrder)
	{
		this.lstOrder = lstOrder;
	}

	public List<PositionsInfo> getLstPositions()
	{
		return lstPositions;
	}

	public void setLstPositions(List<PositionsInfo> lstPositions)
	{
		this.lstPositions = lstPositions;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

	public List<AccountValue> getAccounValues() {
		return accounValues;
	}

	public void setAccounValues(List<AccountValue> accounValues) {
		this.accounValues = accounValues;
	}

	public List<PortfolioInfo> getPortfolios() {
		return portfolios;
	}

	public void setPortfolios(List<PortfolioInfo> portfolios) {
		this.portfolios = portfolios;
	}

	public List<AccountSummary> getAccountSummarys() {
		return accountSummarys;
	}

	public void setAccountSummarys(List<AccountSummary> accountSummarys) {
		this.accountSummarys = accountSummarys;
	}

}