package com.homaer.fundsrv.module.exception;

import org.apache.commons.lang.StringUtils;

/**
 * 错误信息枚举定义
 * 
 * @author chenlong
 * 
 */
public enum UserErrorCodeEnum {

	USER_ISNOT_EXIST("USER_ISNOT_EXIST", "用户不存在,请确认用户信息!"),

	LOGONID_IS_REPEAT("LOGONID_IS_REPEAT", "存在重复的登录用户ID!"),

	LOGONID_IS_EXIST("LOGONID_IS_EXIST", "登录名已经存在,请更换登录名!"),

	CARD_IS_REPEAT("CARD_IS_REPEAT", "用户卡信息重复!"),

	LOGON_ERROR("LOGON_ERROR", "登录失败,请检查您输入的登录名和密码!"),

	USER_AUTH_INFO_ERROR("USER_AUTH_INFO_ERROR", "授权失败,用户信息不完整!"),

	USER_WRITE_INFO_ERROR("USER_WRITE_INFO_ERROR", "用户信息填写不完整，请填写完整!"),

	USER_PASSWORD_SAME_ERROR("USER_PASSWORD_SAME_ERROR", "两次输入的密码不能相同!"),

	SMS_IS_EXPIRED("SMS_IS_EXPIRED", "验证码已过期，请重新获取！"),

	SMS_IS_WRONG("SMS_IS_WRONG", "验证码错误，请重新输入！"),

	SMS_IS_ERROR("SMS_IS_ERROR", "验证码错误，请重新获取！"),

	SMS_INTERVAL_IS_ERROR("SMS_INTERVAL_IS_ERROR", "发送短信间隔未超过规定时间，请稍后点击！"),

	CELL_IS_REPEAT("CELL_IS_REPEAT", "该手机已经注册过，请更换手机！"),
	
	CELL_IS_EMPTY("CELL_IS_EMPTY", "手机号不能为空！"),

	CELL_IS_NOT_EXIST("CELL_IS_NOT_EXIST", "该手机号码不存在，请重新更换号码！"),

	FUND_IS_ZERO("FUND_IS_ZERO", "该资产项已经没有剩余！"),
	
	FUND_IS_LESS_THAN_REEDOM("FUND_IS_LESS_THAN_REEDOM", "该资产项剩余数量不足赎回数量！"),

	FUND_IS_NONE("FUND_IS_NONE", "该资产项不存在！"),

	USER_FUND_IS_NONE("USER_FUND_IS_NONE", "无该用户资产！"),

	USER_SAME_FUND_HAS_MORE("USER_SAME_FUND_HAS_MORE", "用户相同资产项存在多个！"),

	USERS_SAME_FUND_HAS_MORE("USERS_SAME_FUND_HAS_MORE", "用户相同资产项存在多个，请选择追加"),

	USERNAME_HAS_MORE_THAN_ONE("USERNAME_HAS_MORE_THAN_ONE", "该姓名存在多个!"),

	USERNAME_HAS_NONE("USERNAME_HAS_NONE", "不存在该姓名存的用户!"),

	USER_FUND_LESS_THAN_REQUEST("USER_FUND_LESS_THAN_REQUEST", "用户该资产的剩余数量少于请求数量!"),

	PAGE_NUM_IS_WRONG("PAGE_NUM_IS_WRONG", "请求页数有误！"),

	ACTCODE_IS_NOT_EXIST("ACTCODE_IS_NOT_EXIST", "此邀请码不存在!@"),

	ACTCODE_IS_USED("ACTCODE_IS_USED", "此邀请码已经使用过了!@"),

	FEEDBACK_CONTENT_IS_BLANK("FEEDBACK_CONTENT_IS_BLANK", "反馈内容不能为空!"),

	FEEDBACK_CONTACT_IS_BLANK("FEEDBACK_CONTACT_IS_BLANK", "反馈人联系方式不能为空!"),

	FEEDBACK_USERID_IS_BLANK("FEEDBACK_USERID_IS_BLANK", "请先登录，再反馈信息!"),

	FEEDBACK_ID_IS_BLANK("FEEDBACK_ID_IS_BLANK", "反馈信息id不能为空!"),

	VERIFY_PASSWORD_ERROR("VERIFY_PASSWORD_ERROR", "密码修改失败,请检查原密码!"),

	PRODUCT_GROUP_ID_ERROR("PRODUCT_GROUP_ID_ERROR", "自选id不存在!"),

	PRODUCT_GROUP_MUL_EXIST("PRODUCT_GROUP_MUL_EXIST", "该自选项目存在重复记录!"),

	PRODUCT_GROUP_EXIST("PRODUCT_GROUP_EXIST", "该自选项目已经存在!"),

	FUNDLOGID_IS_NOT_EXIST("FUNDLOGID_IS_NOT_EXIST", "用户操作id不存在!"),

	SYSTEM_ERROR("SYSTEM_ERROR", "系统异常,请稍后操作!"),

	FUNDID_AND_TYPE_ARE_NULL("FUNDID_AND_TYPE_ARE_NULL", "fundId和dateType不能都为空!"),
	
	MODIFY_INFORMATION_FAILURE("MODIFY_INFORMATION_FAILURE","修改信息失败,请稍后重试!"),
	
	USER_AUTH_ID_ERROR("USER_AUTH_ID_ERROR", "该账号已被绑定，如需解绑，请拨打屏幕下方电话!"),
	//FUNDID_AND_TYPE_ARE_NULL("FUNDID_AND_TYPE_ARE_NULL", "fundId和dateType不能都为空!"),
	;

	private String code;

	private String message;

	private UserErrorCodeEnum(String code, String message) {
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

	public static UserErrorCodeEnum valueOfByCode(String code) {
		UserErrorCodeEnum[] tests = UserErrorCodeEnum.values();
		for (UserErrorCodeEnum test : tests) {
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
