package examples.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class DisplayPageServlet extends HttpServlet{

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String pageName = request.getParameter("page");
		pageName = "/" + pageName;
		
		//this time we can only use the servlet context method
		InputStream is = getServletContext().getResourceAsStream(pageName);
		BufferedReader reader = new BufferedReader(new InputStreamReader(is));
		StringWriter writer = new StringWriter();
		String line = reader.readLine();
		while(line!=null){
			writer.write(line);
			line = reader.readLine();
		}
		
		request.setAttribute("fileContent", writer.toString());
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("showCode.jsp");
		dispatcher.forward(request, response);
	}
}
