package com.technical.test.configurations;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class InterceptRequests extends OncePerRequestFilter {

	private static final Logger logger = LoggerFactory.getLogger(InterceptRequests.class);

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws ServletException, IOException {

		Long startTime = System.currentTimeMillis();

		chain.doFilter(request, response);
		MyRequestWrapper myRequestWrapper = new MyRequestWrapper((HttpServletRequest) request);
		String Requestbody = myRequestWrapper.getBody();
		myRequestWrapper = new MyRequestWrapper((HttpServletRequest) request);
		String Responsebody = myRequestWrapper.getBody();

		logger.info("Fonction called : {} and URI : {}", request.getMethod(), request.getRequestURI());
		logger.info("Input : {} and OutPut : {}", Requestbody, Responsebody);
		logger.info("Execution took {}ms", (System.currentTimeMillis() - startTime));

	}

}
