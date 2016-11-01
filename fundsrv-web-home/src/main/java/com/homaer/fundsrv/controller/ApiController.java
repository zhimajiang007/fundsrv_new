package com.homaer.fundsrv.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.homaer.common.tools.log.LoggerUtils;


@Controller
@RequestMapping(value = { "/api.do" })
public class ApiController {
	@SuppressWarnings("unused")
  private static final Logger LOGGER = LoggerFactory
			.getLogger(LoggerUtils.WEB_LOGGER);

	@RequestMapping(method = { RequestMethod.GET, RequestMethod.POST })
	public void gateway(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		@SuppressWarnings("unused")
    long time1 = System.currentTimeMillis();
		@SuppressWarnings("unused")
    PrintWriter out = response.getWriter();
		
	}
}
