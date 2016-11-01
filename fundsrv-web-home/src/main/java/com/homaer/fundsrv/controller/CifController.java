package com.homaer.fundsrv.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.homaer.common.tools.log.LoggerUtils;

@Controller
public class CifController {

	/** 日志实例 */
	@SuppressWarnings("unused")
  private static final Logger LOGGER = LoggerFactory
			.getLogger(LoggerUtils.WEB_LOGGER);
	
	@RequestMapping(value = "/hello", produces = "text/plain;charset=UTF-8")  
    public @ResponseBody  
    String hello() {  
        return "你好！hello";  
    }
	
	@RequestMapping(value = "/say/{msg}", produces = "application/json;charset=UTF-8")  
    public @ResponseBody  
    String say(@PathVariable(value = "msg") String msg) {  
        return "{\"msg\":\"you say:'" + msg + "'\"}";  
    }
}
