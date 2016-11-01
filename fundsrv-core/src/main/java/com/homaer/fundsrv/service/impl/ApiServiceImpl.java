package com.homaer.fundsrv.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.homaer.biz.framework.api.ApiContextUtil;
import com.homaer.biz.framework.api.ApiRequest;
import com.homaer.biz.framework.api.ApiResponse;
import com.homaer.biz.framework.api.ApiService;
import com.homaer.biz.framework.api.ApiUtils;
import com.homaer.biz.framework.api.IApi;
import com.homaer.biz.framework.api.OsType;
import com.homaer.biz.framework.hessian.tools.HessianService;
import com.homaer.common.module.context.RuntimeContext;
import com.homaer.common.module.context.RuntimeContextHolder;
import com.homaer.common.tools.log.LoggerUtils;

@Service
@HessianService(value = "fundSrvApiService")
public class ApiServiceImpl implements ApiService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(LoggerUtils.SERVICE_LOGGER);

	@Autowired
	private ApiContextUtil apiContextUtil;

	/**
	 * API库
	 */
	private final Map<String, IApi<ApiResponse, ApiRequest>> apiMap = new HashMap<String, IApi<ApiResponse, ApiRequest>>();

	/**
	 * 版本库
	 */
	private final Map<String, Set<String>> versionMap = new HashMap<String, Set<String>>();

	private final Map<String, Set<String>> osTypeMap = new HashMap<String, Set<String>>();

	@PostConstruct
	private void init() {
		apiMap.putAll(apiContextUtil.getApiMap());
		versionMap.putAll(apiContextUtil.getVersionMap());
		osTypeMap.putAll(apiContextUtil.getOsTypeMap());
	}

	// @Override
	// public IApi<ApiResponse, ApiRequest> getApi(String action, String
	// version) {
	// String[] actionElements = action.split("/");
	// if (actionElements.length == 3) {
	// return getApi(actionElements[1], actionElements[2], version);
	// }
	// return null;
	// }

	@Override
	public IApi<ApiResponse, ApiRequest> getApi(String type, String method,
			String version, String osType) {
		String apiName = ApiUtils.getApiNameByType(type, method, version,
				osType);
		String _apiName = apiName;
		// 有版本定义则取对应版本
		if (this.apiMap.containsKey(apiName)) {
			return this.apiMap.get(apiName);
		} else {
			// 否则取最新版
			apiName = ApiUtils.getDefaultApiName(type, method);
			if (osTypeMap.containsKey(apiName)) {
				Set<String> osTypeSet = osTypeMap.get(apiName);
				if (!osTypeSet.contains(osType)) {
					if (StringUtils.equals(OsType.ANDROID, osType)
							|| StringUtils.equals(OsType.IOS, osType)) {
						if (osTypeSet.contains(OsType.APP)) {
							osType = OsType.APP;
						} else {
							osType = OsType.ALL;
						}
					} else {
						osType = OsType.ALL;
					}
				}
			} else {
				osType = OsType.ALL;
			}
			if (versionMap.containsKey(apiName)) {
				Set<String> versions = versionMap.get(apiName);
				List<String> sortedVersions = new ArrayList<String>(versions);
				Collections.sort(sortedVersions, new Comparator<String>() {
					/**
					 * @see java.util.Comparator#compare(java.lang.Object,
					 *      java.lang.Object)
					 */
					@Override
					public int compare(String o1, String o2) {
						return o2.compareTo(o1);
					}
				});
				for (String v : sortedVersions) {
					if (version.compareTo(v) >= 0) {
						apiName = ApiUtils.getApiNameByType(type, method, v,
								osType);
						IApi<ApiResponse, ApiRequest> api = this.apiMap.get(apiName);
						if(null != api) {
							this.apiMap.put(_apiName, api);
							return api;
						}
					}
				}
			}
			return null;
		}
	}
	
	public ApiResponse execute(String busiType, String apiName, String apiVersion, String osType, String bizData) {

		RuntimeContext context = RuntimeContextHolder.currentRuntimeContext();
		
		IApi<? extends ApiResponse, ? extends ApiRequest> api = this.getApi(busiType, apiName, apiVersion, osType);

		if (api == null) {
			String action = ApiUtils.getDefaultApiName(busiType, apiName);
			LoggerUtils.error(LOGGER, "执行具体api时没有找到该apitrtrtrtrtrtrtrt" + action + "," + apiVersion + "," + osType);
			throw new RuntimeException("执行具体api时没有找到该api" + action + "," + apiVersion + "," + osType);
		}

		Map<String, Object> jsonMaps = new HashMap<String, Object>();
		jsonMaps.putAll(JSONObject.parseObject(bizData));
		jsonMaps.put("osType", osType);
		context.setRequestJsonMaps(jsonMaps);
		ApiResponse result = api.execute();
		
		return result;

	}
	
	public ApiResponse execute(String busiType, String apiName, String apiVersion, String osType, JSONObject bizData) {

		RuntimeContext context = RuntimeContextHolder.currentRuntimeContext();
		
		IApi<? extends ApiResponse, ? extends ApiRequest> api = this.getApi(busiType, apiName, apiVersion, osType);

		if (api == null) {
			String action = ApiUtils.getDefaultApiName(busiType, apiName);
			LoggerUtils.error(LOGGER, "执行具体api时没有找到该apitrtrtrtrtrtrtrt" + action + "," + apiVersion + "," + osType);
			throw new RuntimeException("执行具体api时没有找到该api" + action + "," + apiVersion + "," + osType);
		}

		Map<String, Object> jsonMaps = new HashMap<String, Object>();
		jsonMaps.putAll(bizData);
		jsonMaps.put("osType", osType);
		context.setRequestJsonMaps(jsonMaps);
		ApiResponse result = api.execute();
		
		return result;

	}

	// @SuppressWarnings("unchecked")
	// @Override
	// public <T extends IApi<?, ?>> T getApi(Class<T> clazz) {
	// Api api = clazz.getAnnotation(Api.class);
	// String value = api.value();
	// String type = null;
	// String method = null;
	// String version = null;
	// if (value != null) {
	// String[] apiNames = value.split("/");
	// if (apiNames.length == 3) {
	// type = apiNames[1];
	// method = apiNames[2];
	// }
	// } else {
	// return null;
	// }
	// List<String> versions = Arrays.asList(api.version());
	// if (versions != null && !versions.isEmpty()) {
	// version = versions.get(0);
	// } else {
	// return null;
	// }
	// return (T) getApi(type, method, version);
	// }

	// @SuppressWarnings("unchecked")
	// @Override
	// public <T extends IApi<?, ?>> T getApiForVersion(Class<T> clazz,
	// String version) {
	// Api api = clazz.getAnnotation(Api.class);
	// String value = api.value();
	// String type = null;
	// String method = null;
	// if (value != null) {
	// String[] apiNames = value.split("/");
	// if (apiNames.length == 3) {
	// type = apiNames[1];
	// method = apiNames[2];
	// }
	// } else {
	// return null;
	// }
	// return (T) getApi(type, method, version);
	// }

}
