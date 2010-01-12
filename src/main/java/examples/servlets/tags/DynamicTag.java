package examples.servlets.tags;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.DynamicAttributes;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class DynamicTag extends SimpleTagSupport implements DynamicAttributes{
	Map<String, Object> attributes = new HashMap<String, Object>();
	
	public void setDynamicAttribute(String neverUsed, String name, Object value){
		attributes.put(name, value);
	}
	@Override
	public void doTag() throws JspException, IOException{
		JspWriter out = getJspContext().getOut();
		out.println("<table border='2px'>");
		for(String name : attributes.keySet()){
			out.print("<tr>");
			out.print("<td>"); out.print(name);out.print("</td>");
			out.print("<td>"); out.print(attributes.get(name));out.print("</td>");
			out.println("</tr>");
		}
		out.println("</table>");
	}
}
