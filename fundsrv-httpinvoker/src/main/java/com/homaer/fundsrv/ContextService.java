package com.homaer.fundsrv;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.homaer.fundsrv.ib.IbBroker;

public class ContextService implements InitializingBean, DisposableBean, ApplicationContextAware {

	protected ApplicationContext applicationContext;
	
	@Override
	public void destroy() {
		try {
			System.out.println("IbBroker destroy!");
			IbBroker broker = (IbBroker) this.applicationContext.getBean("ibBroker");
			broker.destroy();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}

}
