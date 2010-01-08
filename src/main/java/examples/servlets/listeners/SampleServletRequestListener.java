package examples.servlets.listeners;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;

public class SampleServletRequestListener implements ServletRequestListener{
	public void requestInitialized(ServletRequestEvent event){
		HttpServletRequest request = (HttpServletRequest)event.getServletRequest();
		event.getServletContext().log("Request created for " + request.getRequestURI());
	}
	
	public void requestDestroyed(ServletRequestEvent event){
		HttpServletRequest request = (HttpServletRequest)event.getServletRequest();
		event.getServletContext().log("Request serviced for " + request.getRequestURI());
	}
}
