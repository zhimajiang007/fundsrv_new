package com.homaer.fundsrv.module.ib;

import com.ib.client.Contract;

public class PortfolioInfo {

	/** 交易合约的描述 */ 
	private  Contract contract;
	
	/** 该整数表示合约头寸。 如果头寸为 0，表示头寸刚被平仓 */
	private int       position;
	
	/** 产品的单位价格 */
	private double    marketPrice;
	
	/** 产品的总市值 */
	private double    marketValue;
	
	/** 每股的平均成本的计算是用你头寸的数量除以你的成本 ( 执行价格＋佣金 )*/
	private double    averageCost;
	
	/** 你未平仓头寸的当前市值和平均成本或平均成本值的差 */
	private double    unrealizedPNL;
	
	/** 显示平仓头寸的利润，为你的建仓执行成本 ( 执行价格＋建仓佣金 ) 和平仓执行成本 ( 执行价格＋平仓头寸佣金 ) 的差*/
	private double    realizedPNL;
	
	/** 账户名称 */
	private String    accountName;

	public Contract getContract() {
		return contract;
	}

	public void setContract(Contract contract) {
		this.contract = contract;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public double getMarketPrice() {
		return marketPrice;
	}

	public void setMarketPrice(double marketPrice) {
		this.marketPrice = marketPrice;
	}

	public double getMarketValue() {
		return marketValue;
	}

	public void setMarketValue(double marketValue) {
		this.marketValue = marketValue;
	}

	public double getAverageCost() {
		return averageCost;
	}

	public void setAverageCost(double averageCost) {
		this.averageCost = averageCost;
	}

	public double getUnrealizedPNL() {
		return unrealizedPNL;
	}

	public void setUnrealizedPNL(double unrealizedPNL) {
		this.unrealizedPNL = unrealizedPNL;
	}

	public double getRealizedPNL() {
		return realizedPNL;
	}

	public void setRealizedPNL(double realizedPNL) {
		this.realizedPNL = realizedPNL;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	
}