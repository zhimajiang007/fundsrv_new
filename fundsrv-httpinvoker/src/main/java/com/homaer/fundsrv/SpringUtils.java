//package com.homaer.fundsrv;
//
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//
//public class SpringUtils {
//	private static String path = "classpath:applicationContext.xml";
//	private static ApplicationContext context;
//
//	static {
//		context = new ClassPathXmlApplicationContext(path);
//	}
//
//	public static Object getBean(String bean) {
//		Object object = null;
//		try {
//			object = context.getBean(bean);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return object;
//	}
//}
