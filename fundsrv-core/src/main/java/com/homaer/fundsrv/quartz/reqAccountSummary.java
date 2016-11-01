package com.homaer.fundsrv.quartz;

import java.net.SocketException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.homaer.common.tools.jpush.JPushTool;
import com.homaer.common.tools.log.LoggerUtils;
import com.homaer.fundsrv.service.IbService;

public class reqAccountSummary {

	@Autowired
	private IbService ibService;
	
	@Autowired
	private JPushTool pushTool;

	protected static final Logger logger = LoggerFactory.getLogger(LoggerUtils.SERVICE_LOGGER);

	public void execute() throws SocketException, InterruptedException {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Calendar calendar = Calendar.getInstance();
		logger.info("定时任务reqAccountSummary==" + sdf.format(calendar.getTime()));
		
		ibService.reqAccountSummary("");
	}

}
