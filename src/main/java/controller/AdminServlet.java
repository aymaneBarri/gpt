package controller;

import java.io.IOException;
import java.util.List;

import dal.ProjetDao;
import dal.UtilisateurDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Projet;
import model.Utilisateur;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("/admin")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public AdminServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		UtilisateurDao utilisateurDao = new UtilisateurDao();
		ProjetDao projetDao = new ProjetDao();
		List<Utilisateur> listeUtilisateurNonAdmin = utilisateurDao.getNotAdmins();
		request.setAttribute("listeUtilisateurNonAdmin", listeUtilisateurNonAdmin);
		List<Projet> listeProjets = projetDao.getAll();
		request.setAttribute("listeProjets", listeProjets);
		request.getRequestDispatcher("Admin.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nomProjet = request.getParameter("nomProjet");
        String chef = request.getParameter("chef");
        int nombreMax =  Integer.parseInt(request.getParameter("nbrMax"));
        UtilisateurDao utilisateurDao = new UtilisateurDao();
        Utilisateur chefProjet = utilisateurDao.getById(chef);
        
        Projet projet = new Projet(nombreMax, nomProjet, chefProjet, null);
        ProjetDao projetDao = new ProjetDao();
        projetDao.insertProjet(projet);
		doGet(request, response);
	}

}
