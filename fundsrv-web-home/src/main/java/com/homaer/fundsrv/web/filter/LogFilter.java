package com.homaer.fundsrv.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.log4j.MDC;

public class LogFilter implements Filter {

    public void init(FilterConfig filterConfig) throws ServletException {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
                                                                                             throws IOException,
                                                                                             ServletException {
        String remoteAddr = request.getRemoteAddr();
        MDC.put("remoteAddr", remoteAddr);
        chain.doFilter(request, response);
        MDC.remove("remoteAddr");
    }

    public void destroy() {
    }

}
