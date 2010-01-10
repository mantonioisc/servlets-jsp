package examples.servlets.filters;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

/**
 * A filter has init and destroy as a servlet and an analogous method to service method: doFilter <br/>
 * You can cast {@link ServletRequest} and {@link ServletResponse} instances to {@link HttpServletRequest}
 * and {@link HttpServletResponse} respectively to access HTTP methods <br/>
 * A Filter can also have init parameters like the servlet ones. <br/>
 * A Filter can stop the chain processing by not calling {@link FilterChain#doFilter(ServletRequest, ServletResponse)} <br/>
 * Also must be configured in web.xml <br/>
 * Also you can wrap the request and response objects to allow more functionality and pass those wrappers
 * objects in the {@link FilterChain}. You can use adapter classes to avoid implement all the interface
 * methods yourself. This wrappers classes delegates all the calls to the internal objects. But here I do
 * nothing interesting with it.
 */
public class LoggingFilter implements Filter{
	FilterConfig config = null;
	
	@SuppressWarnings("unchecked")
	public void init(FilterConfig config){
		this.config = config;
		config.getServletContext().log("Initializing filter: " + config.getFilterName());
		
		Enumeration parameterNames = config.getInitParameterNames();
		while(parameterNames.hasMoreElements()){
			String paramName = (String)parameterNames.nextElement();
			String paramValue = config.getInitParameter(paramName);
			config.getServletContext().log("FILTER INIT PARAM " + paramName + "=" + paramValue);
		}
	}
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException{
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse resp = (HttpServletResponse)response;
		config.getServletContext().log("LF#Request made for " + req.getRequestURL() +
				" with query string " + req.getQueryString());
		
		chain.doFilter(new HttpServletRequestWrapper(req), new HttpServletResponseWrapper(resp));
		
		config.getServletContext().log("LF#Response content type: " + resp.getContentType());
	}
	
	public void destroy(){
		config.getServletContext().log("Destroying filter: " + config.getFilterName());
	}
}
