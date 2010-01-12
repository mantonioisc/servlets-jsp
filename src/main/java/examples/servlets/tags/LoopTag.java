package examples.servlets.tags;

import java.io.IOException;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 * My own version of &lt;c:forEach&gt;
 */
public class LoopTag extends SimpleTagSupport{
	private List<String> values;
	
	private String var;
	
	public void setValues(List<String> values) {
		this.values = values;
	}
	
	public void setVar(String var) {
		this.var = var;
	}
		
	@Override
	public void doTag() throws JspException, IOException{
		for(String value:values){
			getJspContext().setAttribute(var, value);
			getJspBody().invoke(null);
		}
	}
	
}
