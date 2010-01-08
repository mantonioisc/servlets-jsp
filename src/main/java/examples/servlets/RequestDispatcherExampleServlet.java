package examples.servlets;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;

/**
 * Logs more of the data obtained and only sets few attributes to the request
 * scope to be used by a JSP. Forwards the request to other jsp using {@link RequestDispatcher}<br/>
 * Samples of init() and destroy() override <br/>
 * Use of getServletContext() and getServletConfig()<br/>
 * Getting Headers, request parameters<br/>
 * Getting Cookies from the Request and adding cookies to the Response<br/>
 * Getting the servlet init parameters and logging them
 * @author marco.delgado
 */
@SuppressWarnings("serial")
public class RequestDispatcherExampleServlet extends HttpServlet {
	@Override
	public void init(){
		getServletContext().log("Initializing servlet: " + getServletConfig().getServletName());
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//Request attributes use
		Attribute attribute = new Attribute("scope", "request");
		request.setAttribute("request-attribute", attribute);
		
		//Init Parameters use
		ServletConfig config = getServletConfig();
		Enumeration parameterNames = config.getInitParameterNames();
		while(parameterNames.hasMoreElements()){
			String parameterName = (String)parameterNames.nextElement();
			String parameterValue = config.getInitParameter(parameterName);
			//create an attribute of the init parameter to be displayed in the JSP
			getServletContext().log("SERVLET INIT PARAM " + parameterName + "=" + parameterValue);
		}
		
		//Request parameters use
		Enumeration parameters = request.getParameterNames();
		while(parameters.hasMoreElements()){
			String parameterName = (String)parameters.nextElement();
			String parameterValue = request.getParameter(parameterName);
			getServletContext().log("REQUEST PARAMETER " + parameterName + "=" + parameterValue);
		}
		
		//Header use
		Enumeration headers = request.getHeaderNames();
		while(headers.hasMoreElements()){
			String headerName = (String)headers.nextElement();
			String headerValue = request.getHeader(headerName);
			getServletContext().log("HEADER " + headerName + "=" + headerValue);
		}
		
		//cookie use
		Cookie[] cookies = request.getCookies();
		for(Cookie cookie:cookies){
			getServletContext().log("COOKIE " + cookie.getName() + "=" +cookie.getValue());
		}
		
		//Adding cookie to the response
		Cookie cookie = new Cookie("MyCookie", "The cookie value");
		cookie.setMaxAge(30*60);//in seconds
		response.addCookie(cookie);
		
		
		RequestDispatcher rd = request.getRequestDispatcher("printAll.jsp");
		rd.forward(request, response);
	}
	
	@Override
	public void destroy(){
		getServletContext().log("Destroying servlet: " + getServletConfig().getServletName());
	}
}
