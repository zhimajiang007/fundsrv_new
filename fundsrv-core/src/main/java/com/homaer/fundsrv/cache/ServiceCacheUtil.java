package com.homaer.fundsrv.cache;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.homaer.common.cache.CacheManager;
import com.homaer.common.tools.log.LoggerUtils;

@Service(value = "serviceCacheUtil")
public class ServiceCacheUtil {

	private CacheManager cacheManager;

	protected static final Logger LOGGER = LoggerFactory.getLogger(LoggerUtils.SERVICE_LOGGER);

	private static int HALF_DAY_TIME = 12 * 60 * 60;
	
	public Object get(String key) {
		return cacheManager.get(key);
	}

	public void save(String key, Object value) {
		cacheManager.set(key, HALF_DAY_TIME, value);
	}
}
