package examples.servlets;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Uses {@link ServletContext}.getResourceAsStream() to obtain a text file hidden
 * from direct access from user, and writes it to the output stream as binary data.<br/>
 * Also makes use of {@link HttpServletResponse}.setContentType() to set the 
 * mime type to text(I already know this is the default)
 * @author marco.delgado
 */
@SuppressWarnings("serial")
public class DownloadFileServlet extends HttpServlet{
	@Override
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		String file = getServletConfig().getInitParameter("file");
		String type = getServletConfig().getInitParameter("type");
		
		InputStream is = getServletContext().getResourceAsStream(file);
		//can also be placed somewhere in the classpath and using getClass().getResource("README.txt")
		OutputStream os = response.getOutputStream();
		
		response.setContentType(type);
		
		byte[] buff = new byte[1024];
		int read = -1;
		while((read = is.read(buff)) != -1){
			os.write(buff, 0, read);
		}
		os.flush();
	}
}
