package com.homaer.fundsrv.controller;

import java.io.IOException;
import java.util.Locale;
import java.util.Map;
import java.util.zip.GZIPOutputStream;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alibaba.fastjson.JSONObject;
import com.homaer.biz.framework.api.ApiResponse;
import com.homaer.biz.framework.api.ApiService;
import com.homaer.biz.framework.api.ApiUtils;
import com.homaer.biz.framework.api.OsType;
import com.homaer.common.module.context.RuntimeContext;
import com.homaer.common.module.context.RuntimeContextHolder;
import com.homaer.common.tools.annotation.Chinese;
import com.homaer.common.tools.log.LoggerUtils;
import com.homaer.fundsrv.module.exception.UserErrorCodeEnum;

/**
 * 
 * @author homaer
 *
 */
@Controller
@RequestMapping(value = { "/mgw.do" })
public class WapController {

	private static final String CONTENT_TYPE = "Content-type";
	private static final String CONTENT_TYPE_JSON = "application/json;charset=UTF-8";
	private static final String ACCEPT_ENCODING = "Accept-Encoding";
	private static final String CONTENT_ENCODING = "Content-Encoding";
	private static final String GZIP = "gzip";

	private static final Logger LOGGER = LoggerFactory
			.getLogger(LoggerUtils.WEB_LOGGER);

	private static final Logger ERROR = LoggerFactory
			.getLogger(LoggerUtils.COMMON_LOGGER);

	private static final Logger DIGEST = LoggerFactory
			.getLogger(LoggerUtils.TIMER_LOGGER);

	@Autowired
	private ApiService fundApiService;
	
//	@Autowired
//	private ApiService cifApiService;

	@RequestMapping(method = { RequestMethod.GET, RequestMethod.POST })
	public void gateway(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		long start = System.currentTimeMillis();
		String dtype = null;
		String res = null;
		String acceptEncoding = null;
		ApiResponse apiResponse = new ApiResponse();
		String namespace = null;
		String busiType = null;
		String apiName = null;
		String apiVersion = null;
		String bizData = null;
		String session = null;
		String href = null;
		@SuppressWarnings("unused")
    String userAgent = null;
		@SuppressWarnings("unused")
    String digest = null;
		String userId = null;
		String osType = OsType.ALL;
		try {
			response.setCharacterEncoding("UTF-8");
			response.setHeader(CONTENT_TYPE, CONTENT_TYPE_JSON);

			acceptEncoding = request.getHeader(ACCEPT_ENCODING);

			@SuppressWarnings("unused")
      RuntimeContext context = RuntimeContextHolder
					.currentRuntimeContext();

			Map<?, ?> params = request.getParameterMap();

			if (null == params.get("dtype")) {

			} else {
				dtype = ((String[]) params.get("dtype"))[0];
			}

			namespace = ((String[]) params.get("namespace"))[0];
			busiType = ((String[]) params.get("busi_type"))[0];
			apiName = ((String[]) params.get("api_name"))[0];
			apiVersion = ((String[]) params.get("api_version"))[0];
			bizData = ((String[]) params.get("biz_data"))[0];
			session = ((String[]) params.get("session"))[0];
			userAgent = ((String[]) params.get("user_agent"))[0];
			digest = ((String[]) params.get("digest"))[0];

			if (params.get("href") != null
					&& ArrayUtils.isNotEmpty(((String[]) params.get("href")))) {
				href = ((String[]) params.get("href"))[0];
			}
			if (null != params.get("os_type")
					&& ArrayUtils
							.isNotEmpty(((String[]) params.get("os_type")))) {
				osType = ((String[]) params.get("os_type"))[0];
			}

			apiResponse.setNamespace(namespace);
			apiResponse.setApiName(apiName);
			apiResponse.setApiVersion(apiVersion);
			
			ApiResponse result = new ApiResponse();
			if (StringUtils.equalsIgnoreCase("customer", namespace)) {
//				api = this.cifApiService.getApi(busiType, apiName, apiVersion, osType);
				// result = this.cifApiService.execute(busiType, apiName, apiVersion, osType, bizData);
			} else if (StringUtils.equalsIgnoreCase("fundsrv", namespace)) {
//				api = this.fundSrvApiService.getApi(busiType, apiName, apiVersion, osType);
				result = this.fundApiService.execute(busiType, apiName, apiVersion, osType, bizData);
			}

//			if (api == null) {
//				String action = ApiUtils.getDefaultApiName(busiType, apiName);
//				LoggerUtils.error(LOGGER, "执行具体api时没有找到该api" + action + ","
//						+ apiVersion + "," + osType);
//			}
//			Map<String, Object> jsonMaps = new HashMap<String, Object>();
//			jsonMaps.putAll(JSONObject.parseObject(bizData));
//			userId = (String) jsonMaps.get("userId");
//			context.setRequestJsonMaps(jsonMaps);
//			ApiResponse result = api.execute();

			result.setNamespace(namespace);
			result.setApiName(apiName);
			result.setApiVersion(apiVersion);

			// BeanUtils.copyProperties(result, apiResponse);
			result.setSession(session);
			boolean isChinese = result.getClass().isAnnotationPresent(Chinese.class);
			JSONObject jsonResponse = ApiUtils.jsonFromObject(result,isChinese);
			res = jsonResponse.toJSONString();
			// res = JSON.toJSONString(result);

			// response.getWriter().write(res);
		} catch (Exception ex) {
			LoggerUtils.error(this.getClass(), ERROR, ex);
			apiResponse.setCode(ex.getMessage());
			apiResponse.setErrorMsg(ex.getMessage());
			if (StringUtils.isBlank(apiResponse.getCode())) {
				apiResponse.setCode(UserErrorCodeEnum.SYSTEM_ERROR.getCode());
				apiResponse.setErrorMsg(UserErrorCodeEnum.SYSTEM_ERROR
						.getMessage());
			}
			JSONObject jsonResponse = ApiUtils.jsonFromObject(apiResponse,apiResponse.getClass().isAnnotationPresent(Chinese.class));
			res = jsonResponse.toJSONString();
			// res = JSON.toJSONString(apiResponse);
		} finally {
			if (StringUtils.equalsIgnoreCase("jsonp", dtype)) {
				response.setHeader(CONTENT_TYPE,
						"application/x-javascript;charset=UTF-8");
				res = ("jsonpCallback(" + res + ")");
			} else {

			}

			if (null != acceptEncoding
					&& acceptEncoding.toLowerCase(Locale.getDefault())
							.contains(GZIP)) {
				response.setHeader(CONTENT_ENCODING, GZIP);
				ServletOutputStream os = response.getOutputStream();
				GZIPOutputStream gzipOs = new GZIPOutputStream(os);
				gzipOs.write(res.getBytes("UTF-8"));

				gzipOs.flush();
				gzipOs.close();
			} else {
				ServletOutputStream os = response.getOutputStream();
				os.write(res.getBytes("UTF-8"));
				os.flush();
				os.close();
			}

			LoggerUtils.info(DIGEST, osType + "_" + userId + "_" + href + "_"
					+ busiType + "/" + apiName + "/" + apiVersion + "_响应时间"
					+ (System.currentTimeMillis() - start) + "毫秒");
			LoggerUtils.info(LOGGER, "API请求数据:", bizData);
			LoggerUtils.info(LOGGER, "API请求结果:", res);
		}

	}
}
