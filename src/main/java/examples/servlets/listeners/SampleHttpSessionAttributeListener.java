package examples.servlets.listeners;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

/**
 * The event type is not HttpSessionAttributeEvent like the other listeners naming
 * convention is {@link HttpSessionBindingEvent}
 */
public class SampleHttpSessionAttributeListener implements HttpSessionAttributeListener{
	
	public void attributeAdded(HttpSessionBindingEvent event){
		event.getSession().getServletContext().log("Session attribute added " + event.getName());
	}
	
	public void attributeReplaced(HttpSessionBindingEvent event){
		event.getSession().getServletContext().log("Session attribute replaced " + event.getName());
	}
	
	public void attributeRemoved(HttpSessionBindingEvent event){
		event.getSession().getServletContext().log("Session attribute removed " + event.getName());
	}
}
