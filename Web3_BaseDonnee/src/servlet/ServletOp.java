package servlet;


import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.Facade;

/**
 * Servlet implementation class ServletOp
 */
@WebServlet("/ServletOp")
public class ServletOp extends HttpServlet {

	@EJB
	Facade facade;

	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletOp() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String op = request.getParameter("op");
		switch (op) {
		case "ajouterPersonne" :
			String nom = request.getParameter("nom");
			String prenom = request.getParameter("prenom");
			facade.ajoutPersonne(nom, prenom);
			request.getRequestDispatcher("index.html").forward(request, response);
			break;
		case "ajouterAdresse" :
			String rue = request.getParameter("rue");
			String ville = request.getParameter("ville");
			facade.ajoutAdresse(rue, ville);
			request.getRequestDispatcher("index.html").forward(request, response);
			break;
		case "creerLien" :
			int idPersonne = Integer.parseInt(request.getParameter("personne"));
			int idAdresse = Integer.parseInt(request.getParameter("adresse"));
			facade.associer(idPersonne, idAdresse);
			request.getRequestDispatcher("index.html").forward(request, response);
		default :
			response.getWriter().append("Selection non reconnue");
			break;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
