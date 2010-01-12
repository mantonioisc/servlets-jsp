package examples.servlets.listeners;

import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import examples.servlets.Attribute;

public class SampleServletContextListener implements ServletContextListener {
	ArrayList<String> list = new ArrayList<String>(){{
		add("Castlevania Symphony of the Night");
		add("Metal Gear Solid Tactical Espionage Action");
		add("Silent Hill");
	}};
	
	public void contextInitialized(ServletContextEvent event){
		event.getServletContext().log("contextInitialized()");
		
		ServletContext context = event.getServletContext();
		context.setAttribute("context-attribute", new Attribute("scope", "application"));
		
		Enumeration parameterNames = context.getInitParameterNames();
		while(parameterNames.hasMoreElements()){
			String parameterName = (String)parameterNames.nextElement();
			String parameterValue = context.getInitParameter(parameterName);
			context.log("CONTEXT INIT PARAMETER " + parameterName + "=" + parameterValue);
		}
		
		context.setAttribute("list", list);//to use with loop tag
	}
	
	
	public void contextDestroyed(ServletContextEvent event){
		event.getServletContext().log("contextDestroyed()");
	}
}
