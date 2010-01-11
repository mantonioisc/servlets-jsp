package examples.servlets.listeners;

import examples.servlets.Attribute;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

/**
 * This attribute is called self aware since implements {@link HttpSessionBindingListener}
 * whose methods are called when this attribute is added to the session, then this attribute
 * class is aware that is used in a web application.<br/>
 * This listener is not added to the web.xml
 */
public class SelfAwareAttribute extends Attribute implements HttpSessionBindingListener{
	
	private static final long serialVersionUID = -7997149995662530220L;
	
	//callback methods
	public void valueBound(HttpSessionBindingEvent event){
		event.getSession().getServletContext().log("Self-aware attribute created " + event.getName());
	}
	
	public void valueUnbound(HttpSessionBindingEvent event){
		event.getSession().getServletContext().log("Self-aware attribute removed " + event.getName());
	}
	
	//constructors
	public SelfAwareAttribute() {
		super();
	}

	public SelfAwareAttribute(String name, String value) {
		super(name, value);
	}
	
}
