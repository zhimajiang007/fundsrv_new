package com.homaer.fundsrv.mail;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.commons.lang.ArrayUtils;
import org.apache.velocity.app.VelocityEngine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.task.TaskExecutor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;
import org.springframework.ui.velocity.VelocityEngineUtils;

import com.homaer.common.tools.log.LoggerUtils;

@Service
public class MailSendService {

	@Autowired
	private JavaMailSender javaMailSender;

	@Autowired
	private TaskExecutor taskExecutor;

	@Autowired			   
	private VelocityEngine velocityEngine;
	
//	private VelocityEngine cacheManager = (VelocityEngine) SpringUtils.getBean("velocityEngine");


	protected static final Logger LOGGER = LoggerFactory.getLogger(LoggerUtils.SERVICE_LOGGER);

	/**
	 * 券商ib老用户绑定 邮件.
	 * 
	 * @author Bian Guanghua
	 * 
	 * @return
	 */
	public void sendConnectFailMail(String ipNum, String connectFailNum, String time, String to, String[] cc,
			String from, String toPic) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("ipNum", ipNum);
		model.put("connectFailNum", connectFailNum);
		model.put("time", time);

		String vmfile = "com/homaer/fundsrv/mail/vm/twsConnectFail.vm";
		this.sendMailByAsynchronousMode(model, toPic, vmfile, new String[] { to }, cc, from, null, false);
	}
	
	
	private void sendMailByAsynchronousMode(final Map<String, Object> model, final String toPic, final String vmfile,
			final String[] mailTo, final String[] ccTo, final String from, final String[] files, final boolean vip) {
		taskExecutor.execute(new Runnable() {
			public void run() {
				try {
					sendMailBySynchronizationMode(model, toPic, vmfile, mailTo, ccTo, from, files, vip);
				} catch (Exception e) {
					LoggerUtils.error(this.getClass(), LOGGER, e);
				}
			}
		});
	}

	private void sendMailBySynchronizationMode(final Map<String, Object> model, final String toPic,
			final String vmfile, final String[] mailTo, final String[] ccTo, final String from, final String[] files,
			final boolean vip) {
		MimeMessagePreparator preparator = new MimeMessagePreparator() {
			public void prepare(MimeMessage mimeMessage) throws Exception {
				MimeMessageHelper message = new MimeMessageHelper(mimeMessage, true, "GBK");

				message.setTo(mailTo);// 设置接收方的email地址
				if (ArrayUtils.isNotEmpty(ccTo)) {
					message.setCc(ccTo);
				}
				message.setSubject(toPic);// 设置邮件主题

				// 设置自定义发件人昵称
				String nick = "";
				try {
					nick = javax.mail.internet.MimeUtility.encodeText("荷马金融");
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
				message.setFrom(new InternetAddress(nick + " <" + from + ">"));

				// message.setFrom(from);// 设置发送方地址
				String text = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, vmfile, "GBK", model);

				message.setText(text, true);

				FileSystemResource file;// 添加附件
				if (ArrayUtils.isNotEmpty(files)) {
					for (String s : files) {
						file = new FileSystemResource(new File(s));// 读取附件
						message.addAttachment(s, file);// 向email中添加附件
					}
				}
			}
		};

		javaMailSender.send(preparator);// 发送邮件
	}
}
