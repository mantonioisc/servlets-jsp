package examples.servlets.tags;

import java.io.IOException;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class RepeatTag extends SimpleTagSupport{
	private String word;
	private int times;
	
	public void setWord(String word) {
		this.word = word;
	}
	
	public void setTimes(int times) {
		this.times = times;
	}


	@Override
	public void doTag() throws JspException, IOException{
		JspWriter out = getJspContext().getOut();
		for(int i=0;i<times;i++){
			out.print(word);
		}
		out.println();
	}
}
