package examples.servlets.tags;

import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

/**
 * Same as LoopTag but with old fashion tag support
 */
public class OldLoopTag extends TagSupport{
	private List<String> values;
	private String var;
	
	public void setVal(List<String> values) {
		this.values = values;
	}
	public void setVar(String var) {
		this.var = var;
	}
	private int index = 0;
	
	/**
	 * Can only return EVAL_BODY_INCLUDE to include the body or SKIP_BODY to not
	 */
	@Override
	public int doStartTag() throws JspException{
		index = 0;//clean since this object may be reused
		pageContext.setAttribute(var, values.get(index));
		index++;
		return EVAL_BODY_INCLUDE;//evaluate the body since the tag can have a body
	}
	/**
	 * Can return EVAL_BODY_AGAIN to evaluate the body once more, since this method
	 * gets called after the body is sent to the output stream. and SKIP_BODY to
	 * stop the looping process but remember that the body was already evaluated once.
	 */
	@Override
	public int doAfterBody() throws JspException{
		if(index<values.size()){
			pageContext.setAttribute(var, values.get(index));
			index++;
			return EVAL_BODY_AGAIN;
		}else{
			return SKIP_BODY;//end of elements do not execute body again	
		}
	}
	/**
	 * Can return EVAL_PAGE to continue processing the rest of the page, or 
	 * SKIP_PAGE to stop the page, but the content already printed by the tag
	 * will be visible. This is the same as SkipPageException 
	 */
	@Override
	public int doEndTag() throws JspException{
		return EVAL_PAGE;//continue with the rest of the page
	}
}
