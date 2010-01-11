package examples.servlets.listeners;

import javax.servlet.http.HttpSessionListener;
import javax.servlet.http.HttpSessionEvent;

/**
 * The startup callback methods is not <b>sessionInitialized</b> like the other listeners
 * naming convention, it's {@link HttpSessionListener#sessionCreated(HttpSessionEvent)}
 * 
 */
public class SampleHttpSessionListener implements HttpSessionListener{
	
	public void sessionCreated(HttpSessionEvent event){//it's not sessionCreated like the other listeners
		event.getSession().getServletContext().log("sessionCreated():" + event.getSession().getId());
	}
	
	public void sessionDestroyed(HttpSessionEvent event){
		event.getSession().getServletContext().log("sessionDestroyed():" +  event.getSession().getId());
	}
}
