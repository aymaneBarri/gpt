package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import dal.ProjetDao;
import dal.TacheDao;
import dal.UtilisateurDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.EtatTache;
import model.Projet;
import model.Tache;
import model.Utilisateur;

/**
 * Servlet implementation class DashboardServlet
 */
@WebServlet("/dashboard")
public class DashboardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public DashboardServlet() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Utilisateur currentUser = (Utilisateur) request.getSession().getAttribute("login");
		if (currentUser.isAdmin()) {
			UtilisateurDao utilisateurDao = new UtilisateurDao();
			ProjetDao projetDao = new ProjetDao();
			List<Utilisateur> listeUtilisateurNonAdmin = utilisateurDao.getNotAdmins();
			request.setAttribute("listeUtilisateurNonAdmin", listeUtilisateurNonAdmin);
			List<Projet> listeProjets = projetDao.getAll();
			request.setAttribute("listeProjets", listeProjets);
			request.getRequestDispatcher("Admin.jsp").forward(request, response);
		}
		else {
			response.getWriter().append("Served at: ").append(request.getContextPath());
			TacheDao tacheDao = new TacheDao();
			List<Tache> listeTachesEnAttente = new ArrayList<Tache>();
			List<Tache> listeTachesEnCours = new ArrayList<Tache>();
			List<Tache> listeTachesTermine = new ArrayList<Tache>();
			List<Tache> listeTaches = tacheDao.getTasksByUser(currentUser.getNomUtilisateur());
			for (Tache tache : listeTaches) {
				if (tache.getEtatTache() == EtatTache.EnAttente)
					listeTachesEnAttente.add(tache);
				else if (tache.getEtatTache() == EtatTache.EnCours)
					listeTachesEnCours.add(tache);
				else if (tache.getEtatTache() == EtatTache.Termine)
					listeTachesTermine.add(tache);
			}
			request.setAttribute("listeTachesEnAttente", listeTachesEnAttente);
			request.setAttribute("listeTachesEnCours", listeTachesEnCours);
			request.setAttribute("listeTachesTermine", listeTachesTermine);

			request.getRequestDispatcher("dashboard.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
