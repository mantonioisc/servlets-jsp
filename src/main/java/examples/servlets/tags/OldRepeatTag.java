package examples.servlets.tags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class OldRepeatTag extends TagSupport{
	private String word;
	private int times;
	
	public void setWord(String word) {
		this.word = word;
	}
	public void setTimes(int times) {
		this.times = times;
	}
	
	@Override
	public int doStartTag() throws JspException{
		try{
			JspWriter out = pageContext.getOut();
			for(int i = 0;i<times;i++){
				out.print(word);
			}
			out.println();
		}catch(IOException e){
			throw new JspException(e);
		}
		return SKIP_BODY;//we can't return EVAL_BODY_INCLUDE since it's a body less tag
	}
	@Override
	public int doAfterBody() throws JspException{
		return SKIP_BODY;//no body here in this tag, so this will be not called
	}
	@Override
	public int doEndTag() throws JspException{
		return EVAL_PAGE;//we could also make the heavy work here
	}
}
