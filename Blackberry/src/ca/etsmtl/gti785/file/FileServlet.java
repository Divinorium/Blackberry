package ca.etsmtl.gti785.file;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class filesServerServlet
 */
public class FileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

		
		protected void doGet ( HttpServletRequest request, HttpServletResponse response ) throws ServletException , IOException {
		    response.setContentType("text/html");

		    PrintWriter out = response.getWriter();

		    out.println("<html><head></head><body>");
		    out.println("files");
		    out.println("</body></html>");
		}
}
