package com.homaer.fundsrv.module.exception;

import org.apache.commons.lang.StringUtils;

public enum HbErrorCodeEnum {
	USER_ISNOT_EXIST("USER_ISNOT_EXIST", "用户不存在,请确认用户信息!"),

	PASSWORD_IS_WRONG("PASSWORD_IS_WRONG", "用户名或密码错误，请重新输入!"),
	
	SESSION_ERROR("Session error!", "请重新登陆许氏账户!"),
	
	CONNECTION_TIMED_OUT("; nested exception is: \n\tjava.net.ConnectException: Connection timed out: connect", "网站维护中，请稍后重试！"),
	
	MARKET_IS_CLOSED("System is not ready for trading!", "已经闭市！"),
	
	;

	private String code;

	private String message;

	private HbErrorCodeEnum(String code, String message) {
		this.code = code;
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public static HbErrorCodeEnum valueOfByCode(String code) {
		HbErrorCodeEnum[] tests = HbErrorCodeEnum.values();
		for (HbErrorCodeEnum test : tests) {
			if (StringUtils.equals(test.code, code)) {
				return test;
			}
		}
		return null;
	}

	@Override
	public String toString() {
		return message;
	}
}
