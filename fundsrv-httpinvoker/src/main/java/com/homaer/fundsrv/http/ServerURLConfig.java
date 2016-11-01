package com.homaer.fundsrv.http;

public class ServerURLConfig {

	@SuppressWarnings("unused")
  private final static String YINTIAN_NOTIFY_URL = "";

	private final static String YINTIAN_HOST = "";

	private final static String YINTIAN_HTTP_SERVER_URL = YINTIAN_HOST
			+ "/yt-uni-service/sp/";

	public final static String YINTIAN_REGISTER_CUSTOMER_URL = YINTIAN_HTTP_SERVER_URL
			+ "registerCustomer";

	public final static String YINTIAN_UNREGISTER_CUSTOMER_URL = YINTIAN_HTTP_SERVER_URL
			+ "unregisterCustomer";

	public final static String YINTIAN_BIND_BANKCARD_URL = YINTIAN_HTTP_SERVER_URL
			+ "bindBankCard";

	public final static String YINTIAN_UNBIND_BANKCARD_URL = YINTIAN_HTTP_SERVER_URL
			+ "unbindBankCard";

	public final static String YINTIAN_TRANSFER_MONEY_URL = YINTIAN_HTTP_SERVER_URL
			+ "special/transferMoney";

	public final static String YINTIAN_WITHDRAW_MONEY_URL = YINTIAN_HTTP_SERVER_URL
			+ "special/withdrawMoney";

	public final static String YINTIAN_WITHDRAW_MONEY_BATCH_URL = YINTIAN_HTTP_SERVER_URL
			+ "withdrawMoneyBatch";

	public final static String YINTIAN_PAY_MONEY_URL = YINTIAN_HTTP_SERVER_URL
			+ "special/payMoney";

	public final static String YINTIAN_PAY_MONEY_BATCH_URL = YINTIAN_HTTP_SERVER_URL
			+ "special/payMoneyBatch";
}
