package examples.servlets.listeners;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;

/**
 * IMPORTANT! If the application does not call removeAttribute() directly the
 * {@link attributeRemoved()} method is not called, even if the container 
 * disposes the object after servicing a request.
 * @author marco.delgado
 */
public class SampleServletRequestAttributeListener implements ServletRequestAttributeListener{
	public void attributeAdded(ServletRequestAttributeEvent event){
		event.getServletContext().log("Request attribute added: " + event.getName());
	}
	
	public void attributeReplaced(ServletRequestAttributeEvent event){
		event.getServletContext().log("Request attribute replaced: " + event.getName());
	}
	
	public void attributeRemoved(ServletRequestAttributeEvent event){
		event.getServletContext().log("Request attribute removed: " + event.getName());
	}
}
