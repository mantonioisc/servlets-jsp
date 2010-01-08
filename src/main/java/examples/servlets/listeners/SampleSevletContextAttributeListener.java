package examples.servlets.listeners;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;

public class SampleSevletContextAttributeListener implements
		ServletContextAttributeListener {

	public void attributeAdded(ServletContextAttributeEvent event){
		event.getServletContext().log("Context attribute added: " + event.getName() + "=" + event.getValue());
	}
	
	public void attributeRemoved(ServletContextAttributeEvent event){
		event.getServletContext().log("Context attribute removed: " + event.getName() + "=" + event.getValue());
	}
	
	public void attributeReplaced(ServletContextAttributeEvent event){
		event.getServletContext().log("Context attribute replaced: " + event.getName() + "=" + event.getValue());
	}

}
