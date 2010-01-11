package examples.servlets.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import examples.servlets.listeners.SelfAwareAttribute;

public class SessionCreatorFilter implements Filter{
	
	FilterConfig config;
	
	public void init(FilterConfig config){
		this.config = config;
	}
	
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException{
		HttpServletRequest request = (HttpServletRequest) req;
		HttpSession session = request.getSession(false);//get a new session if no one existed
		
		if(session==null){
			session = request.getSession();
			config.getServletContext().log("SF#Creating new session " + session.getId());
		}
		
		SelfAwareAttribute attribute = new SelfAwareAttribute("scope", "session");//this will call attribute added, and replaced
		session.setAttribute("session-attribute", attribute);
		
		chain.doFilter(req, resp);
	}
	
	public void destroy(){
		
	}
}
