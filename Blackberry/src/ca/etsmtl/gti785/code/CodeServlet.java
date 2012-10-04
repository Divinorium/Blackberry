package ca.etsmtl.gti785.code;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class filesServerServlet
 */
public class CodeServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	/**TODO
	 * 
	 * s'enregistrer auprès du master (AssociatorServlet) -->
	 * utiliser la méthode d'instanciation pour aller chercher la liste d'association Code/IP
	 * 
	 */
		
		protected void doGet ( HttpServletRequest request, HttpServletResponse response ) throws ServletException , IOException {
			response.setContentType("text/xml");
		    PrintWriter out = response.getWriter();
		    out.println("<?xml version=\"1.0\"?>");
			
			String strImg = request.getParameter("image");
			if (strImg != null && !strImg.isEmpty()) {
				//utilise helloMidlet je pense pour la remettre bien
				
				/**TODO
				 * utilise api pour avoir le code
				 */
				
				
				/**TODO
				 * check le code dnas la liste qu'on a 
				 */
				
				
				/**TODO
				 * 
				 * rebalance l'adresse IP dans le xml de la réponse 
				 * 
				 */
			   
			    out.println("<data><ip>"+"192.168.0.1   ......    image="+strImg+"</ip></data>");
			} else {
				 out.println("<data><ip>-1</ip></data>");
			}
			
		}


}
