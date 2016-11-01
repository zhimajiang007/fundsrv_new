package com.homaer.fundsrv.service.cache;

import static com.homaer.fundsrv.service.cache.ApplicationConstants.APP_SOURCE;
import static com.homaer.fundsrv.service.cache.ApplicationConstants.FIND_PASSWORD_TEMPLATE;
import static com.homaer.fundsrv.service.cache.ApplicationConstants.FRIENDLINKS;
import static com.homaer.fundsrv.service.cache.ApplicationConstants.INTRODUCTIONS;
import static com.homaer.fundsrv.service.cache.ApplicationConstants.QUESTIONS;
import static com.homaer.fundsrv.service.cache.ApplicationConstants.REGISTER_TEMPLATE;
import static com.homaer.fundsrv.service.cache.ApplicationConstants.SUBSCRIBER_NOT_YET_TEMPLATE;
import static com.homaer.fundsrv.service.cache.ApplicationConstants.SUBSCRIBER_TEMPLATE;
import static com.homaer.fundsrv.service.cache.ApplicationConstants.SYSTEM_SETTINGS;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.homaer.common.tools.log.LoggerUtils;

public class ApplicationUtils {

	private static final Logger UTILS_LOGGER = LoggerFactory
			.getLogger(LoggerUtils.UTILS_LOGGER);

	private static final Set<Integer> EMPTY_PIN_IDS = new HashSet<Integer>();

	/**
	 * 
	 * @param <T>
	 *            the type of result you want
	 * @param key
	 *            the key of the application attribute.
	 * @return the value corresponding the key
	 */
	public static <T> T get(String key) {
		// return (T)
		// ServletActionContext.getServletContext().getAttribute(key);
		return null;
	}

	public static void destroyCMS(ServletContext context) {
		context.removeAttribute(INTRODUCTIONS);
		context.removeAttribute(FRIENDLINKS);
		context.removeAttribute(QUESTIONS);
	}

	public static void destroyTemplates(ServletContext context) {
		context.removeAttribute(REGISTER_TEMPLATE);
		context.removeAttribute(FIND_PASSWORD_TEMPLATE);
		context.removeAttribute(SUBSCRIBER_TEMPLATE);
		context.removeAttribute(SUBSCRIBER_NOT_YET_TEMPLATE);
	}

	public static void destroySettings(ServletContext context) {
		context.removeAttribute(SYSTEM_SETTINGS);
	}

	@SuppressWarnings("unchecked")
	public static Map<String, String> getAppSource(ServletContext context) {
		return (Map<String, String>) context.getAttribute(APP_SOURCE);
	}

	public static synchronized Integer getAnEmptyPinId() {
		Iterator<Integer> idIterator = EMPTY_PIN_IDS.iterator();
		if (idIterator.hasNext()) {
			Integer id = idIterator.next();
			EMPTY_PIN_IDS.remove(id);
			return id;
		} else {
			return null;
		}
	}

	public static Set<Integer> getEmptyPinIds() {
		return EMPTY_PIN_IDS;
	}

	public static void updatePinIds(Integer id) {
		if (!EMPTY_PIN_IDS.contains(id)) {
			EMPTY_PIN_IDS.add(id);
			UTILS_LOGGER.info("add id:{} into the empty pin id set.", id);
			UTILS_LOGGER.info("now the empty pin id set is [{}].",
					EMPTY_PIN_IDS.toString());
		}
	}
}
