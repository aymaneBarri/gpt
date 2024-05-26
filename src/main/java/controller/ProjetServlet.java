package controller;

import java.io.IOException;
import java.util.List;

import dal.ProjetDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Projet;
import model.Utilisateur;
import jakarta.servlet.annotation.WebServlet;

/**
 * Servlet implementation class ProjetServlet
 */
@WebServlet("/projets")
public class ProjetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ProjetDao projetDao;
    @Override
    	public void init() throws ServletException {
    		projetDao = new ProjetDao();
    	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Utilisateur user = (Utilisateur) session.getAttribute("login");
		
		String username = user.getNomUtilisateur();
		List<Projet> projects = projetDao.getProjectsByUser(username);
		session.setAttribute("listeProjets", projects);
		response.sendRedirect("mesProjets.jsp");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
