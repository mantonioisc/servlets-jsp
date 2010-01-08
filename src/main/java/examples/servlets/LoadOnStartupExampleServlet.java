package examples.servlets;

import javax.servlet.http.HttpServlet;

public class LoadOnStartupExampleServlet extends HttpServlet {
	@Override
	public void init(){
		getServletContext().log("This servlet was loaded on startup: " + getServletConfig().getServletName());
	}
}
