package com.homaer.fundsrv.module.ib;

import java.io.IOException;
import java.util.Properties;

/**
 * 
    * @ClassName: InitContants
    * @Description: TODO(常用系统常量放在configuration.properties进行初始化)
    *
 */
public class InitContants {

	protected static Properties pro = new Properties();

	static {
		try {
			init("/configuration.properties");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	    * @Title: init
	    * @Description: TODO(这里用一句话描述这个方法的作用)
	    * @param @param propertyFileName    参数
	    * @return void    返回类型
	    * @throws
	 */
	public static void init(String propertyFileName) {
		try {
			pro.load(new InitContants().getClass().getResourceAsStream(
					propertyFileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	    * @Title: getProperty
	    * @Description: TODO(这里用一句话描述这个方法的作用)
	    * @param @param key
	    * @param @return    参数
	    * @return String    返回类型
	    * @throws
	 */
	public static String getProperty(String key) {
		return pro.getProperty(key);
	}

	// TWS配置
	public static final String TWS_HOST = getProperty("TWS_HOST");
	public static final Integer TWS_PORT = Integer.parseInt(getProperty("TWS_PORT"));
	public static final Integer TWS_CLIENTID = Integer.parseInt(getProperty("TWS_CLIENTID"));
	public static final Integer TWS_ORID = Integer.parseInt(getProperty("TWS_ORID"));
	
	// 股价查询TWS配置
	public static final String TWS_HOST_QUERY = getProperty("TWS_HOST_QUERY");
	public static final int TWS_HOST_REQID = Integer.parseInt(getProperty("TWS_HOST_REQID"));
	public static final int TWS_HOST_TICKERID = Integer.parseInt(getProperty("TWS_HOST_TICKERID"));
	// TWS连接中断通知邮箱
	public static final String TWS_CONNECT_FAIL_EMIAL = getProperty("TWS_CONNECT_FAIL_EMIAL");
	// TWS连接中断通知邮箱抄送地址
	public static final String TWS_CONNECT_FAIL_CCEMIAL = getProperty("TWS_CONNECT_FAIL_CCEMIAL");

	
	
	
// 	public static final Integer TWS_CLIENTID_QUERY = Integer.parseInt(getProperty("TWS_CLIENTID_QUERY"));


	
}
