package com.homaer.fundsrv.module.ib;

/**
 * 订单状态实体信息
 * 
 * @author zongyang
 *
 */
public class OrderStatus {

	/** 订单号(调用 placeOrder()中指定的定单代号) */
	private int orderId;
	
	/** *PendingSubmit - 表示你已经传递了定单，但还未接到来自定单目的地接收的确认信息。 注：这个定单状态不是由 TWS发送的，应该由 API设计人设置为当定单发送时发出。 *PendingCancel - 表示你已经发送了取消定单的请求，但还未收到来自定单目的地的取消确认。 此时，你的定单没有被确认取消。 在你的取消请求等待期间。你的定单仍有可能得到执行。注：这个定单状态不是由 TWS发送的，应该由 API设计人设置为当定单发送时发出   *PreSubmitted - 表示模拟定单类型已经被 IB系统接收，但还未被选中。定单被保持在 IB系统中直到选择条件被满足。 届时，定单将被发送到指定的定单目的地。 *Submitted - 表示你的定单已经被定单目的地接受，并处于工作中。  *Cancelled - 表示你定单的剩余部分已被 IB系统确认取消了。 这也会在 IB或目的地拒绝你的定单时发生。   *Filled - 表示定单已被全部执行    *Inactive - 表示定单已被系统接收 ( 模拟定单 ) 或交易所接收 ( 本地定单 ) ，但由于系统、交易所或其它原因，目前定单处于非工作状态*/
	private String status;
	
	/** 指定已被执行的股票数 */
	private int filled;
	
	/** 指定剩余部分的股票数 */
	private int remaining;
	
	/** 执行股票的平均价格。该参数仅在 filled参数值大于零时有效。 否则，价格参数将为零 */
	private double avgFillPrice;
	
	/** 用于确认定单的 TWS代号。 整个 TWS运行中保持不变 */
	private int permId;
	
	/** 母定单的定单代号，用于括号单和自动跟踪止损单 */
	private int parentId;
	
	/** 被执行股票的最后价格。 该参数仅在 filled参数值大于零时有效。 否则，价格参数将为零 */
	private double lastFillPrice; 
	
	/** 下达定单的客户代号 ( 或TWS) 。 注意， TWS定单的 clientId是固定的，其 orderId为 0以区别 API定单 */
	private int clientId;
	
	/** 这个区域被用于在 TWS寻求卖空股票时确认持有的定单。用于指示这个的值是 'locate' */
	private String whyHeld;

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getFilled() {
		return filled;
	}

	public void setFilled(int filled) {
		this.filled = filled;
	}

	public int getRemaining() {
		return remaining;
	}

	public void setRemaining(int remaining) {
		this.remaining = remaining;
	}

	public double getAvgFillPrice() {
		return avgFillPrice;
	}

	public void setAvgFillPrice(double avgFillPrice) {
		this.avgFillPrice = avgFillPrice;
	}

	public int getPermId() {
		return permId;
	}

	public void setPermId(int permId) {
		this.permId = permId;
	}

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public double getLastFillPrice() {
		return lastFillPrice;
	}

	public void setLastFillPrice(double lastFillPrice) {
		this.lastFillPrice = lastFillPrice;
	}

	public int getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	public String getWhyHeld() {
		return whyHeld;
	}

	public void setWhyHeld(String whyHeld) {
		this.whyHeld = whyHeld;
	}
}
