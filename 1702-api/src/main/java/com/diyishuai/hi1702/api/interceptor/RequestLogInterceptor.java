package com.diyishuai.hi1702.api.interceptor;

import com.diyishuai.hi1702.api.util.RequestUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * RequestProcessingTimeInterceptor <br>
 * <br>
 * Logging the timings of handler method execution and total time taken in
 * processing the request<br>.
 *
 * @author Bruce<br>
 */

@Component
public class RequestLogInterceptor extends HandlerInterceptorAdapter {

	/** The logger. */
	final Logger logger = LoggerFactory.getLogger(RequestLogInterceptor.class);
	
	/** The start time label. */
	private final String START_TIME_LABEL = "Start Time: ";
	
	/** The end time label. */
	private final String END_TIME_LABEL = "End   Time: ";
	
	/** The start time var. */
	private final String START_TIME_VAR = "rpStartTime";
	
	/** The time taken label. */
	private final String TIME_TAKEN_LABEL = "Time Taken: ";

	/**
	 * 进入之前
	 * @param request
	 * @param response
	 * @param handler
	 * @return
	 * @throws Exception
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

		long startTime = System.currentTimeMillis();

		logRequestStart(request, startTime);
		request.setAttribute(START_TIME_VAR, startTime);

		return true;

	}

	/**
	 * postHandle
	 * @param request
	 * @param response
	 * @param handler
	 * @param modelAndView
	 * @throws Exception
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		logRequestEnd(request);
		populateResponseHeader(response);
	}
	
	/**
	 * Populate response header.
	 *
	 * @param response the response
	 */
	private void populateResponseHeader(HttpServletResponse response){
		response.setHeader("ABC", "DEF");
	}


	/**
	 * Log request start.
	 *
	 * @param request the request
	 * @param startTime the start time
	 */
	private void logRequestStart(HttpServletRequest request, long startTime) {
		String message = RequestUtil.getHttpClientInfo(request);
		logger.info(message + "\t " + START_TIME_LABEL + startTime);
	}

	/**
	 * Log request end.
	 *
	 * @param request the request
	 */
	private void logRequestEnd(HttpServletRequest request) {

		long endTime = System.currentTimeMillis();
		long startTime = (Long) request.getAttribute(START_TIME_VAR);

		String message = RequestUtil.getHttpClientInfo(request);
		logger.info(message + "\t " + END_TIME_LABEL + endTime + "\t" + TIME_TAKEN_LABEL + (System.currentTimeMillis() - startTime));

	}

}