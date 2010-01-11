package examples.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * This servlet invalidates the session and redirects to the main page
 */
public class LogoutServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		HttpSession session = request.getSession(false);//don't create session
		if(session!=null){
			getServletContext().log("LO#Invalidating session for user " + request.getUserPrincipal());
			session.invalidate();
		}
		
		response.sendRedirect("/servlets-jsp/");
	}
}
