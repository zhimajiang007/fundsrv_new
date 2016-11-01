package com.homaer.fundsrv.biz.api;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.homaer.biz.framework.annotation.Api;
import com.homaer.biz.framework.api.ApiRequest;
import com.homaer.biz.framework.api.ApiResponse;
import com.homaer.biz.framework.api.ApiUtils;
import com.homaer.biz.framework.api.IApi;
import com.homaer.common.module.context.RuntimeContext;
import com.homaer.common.module.context.RuntimeContextHolder;
import com.homaer.common.tools.log.LoggerUtils;

public abstract class AbstractApi<M extends ApiResponse, N extends ApiRequest> implements IApi<M, N> {
	
	private static final Logger LOGGER = LoggerFactory
			.getLogger(LoggerUtils.API_LOGGER);

    @SuppressWarnings("unchecked")
    @Override
    public final M execute() {
        Class<?> clazz = getClass();
        Class<N> requestClass = (Class<N>) getRequestType(clazz);
        Api api = clazz.getAnnotation(Api.class);
        LoggerUtils.info(LOGGER, "open api execute:" + api.value() + ":" + Arrays.toString(api.version()));
        M m = execute(getRequestData(requestClass));
        return m;
    }
    
    /**
     * 
     * 获取泛型实际Class类型
     * @param clazz
     */
    private Type getRequestType(Class<?> clazz) {
        Type superClass = getGenericSuperclass(clazz);
        Type[] args = ((ParameterizedType) superClass).getActualTypeArguments();
        return args[args.length - 1];
    }
    

    /**
     * 获取定义了request泛型的类
     * 
     * @param clazz
     * @return
     */
    private Type getGenericSuperclass(Class<?> clazz) {
        Type superClass = clazz.getGenericSuperclass();
        if (superClass instanceof ParameterizedType) {
            Type[] types = ((ParameterizedType) superClass).getActualTypeArguments();
            if (types != null && types.length == 2) {
                return superClass;
            }
        }
        return getGenericSuperclass(clazz.getSuperclass());
    }
    
    /**
     * 获取请求数据
     * @param t 
     * @return
     * @throws IllegalAccessException 
     * @throws InstantiationException 
     */
    protected N getRequestData(Class<N> clazz) {
        RuntimeContext context = RuntimeContextHolder.currentRuntimeContext();
    	Map<String, Object> jsonMaps = context.getRequestJsonMaps();
        JSONObject requestJson = (JSONObject) JSON.toJSON(jsonMaps);
//        Session session = context.getSession();
        String sessionId = null;
        N t = ApiUtils.getRequestObject(clazz, requestJson);
        t.setSession(sessionId);
        return t;
    }
}
