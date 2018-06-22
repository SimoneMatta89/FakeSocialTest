package myServlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.*;
import view.Vista;

/**
 * Servlet implementation class MyServlet
 */
@WebServlet("/MyServlet")
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String percorso = "C:\\Users\\mattas\\Desktop\\workspace\\FakeSocialTest\\WebContent\\templates";
		Social social = new Social(percorso);
		Vista vista= new Vista(percorso);
		String cmd = 
				request.getParameter("cmd")==null 	
				? 
				"" 										
				: 
				request.getParameter("cmd");	
		String resp="";
		switch(cmd) {
		case "":
			resp=vista.contenutoFile("index.html");
			cmd=request.getParameter("cmd");
			break;
		case "myprofile":
			resp=vista.scheda(social.persona(1));
//			cmd=request.getParameter("cmd");
			break;
		case "friends":
			resp=vista.scheda(social.amiciPersona(1));
//			cmd=request.getParameter("cmd");
		}
		response.getWriter().append(resp);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
