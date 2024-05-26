package controller;

import java.io.IOException;
import java.time.LocalDateTime;
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
import model.PrioriteTache;
import model.Projet;
import model.Tache;
import model.Utilisateur;

/**
 * Servlet implementation class ChefServlet
 */
@WebServlet("/chef")
public class ChefServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public ChefServlet() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		UtilisateurDao utilisateurDao = new UtilisateurDao();
		ProjetDao projetDao = new ProjetDao();
		List<Utilisateur> listeUtilisateurNonAdmin = utilisateurDao.getNotAdmins();
		request.setAttribute("listeUtilisateurNonAdmin", listeUtilisateurNonAdmin);
		Utilisateur currentUser = (Utilisateur) request.getSession().getAttribute("login");
		List<Projet> listeProjets = projetDao.getProjectsByUser(currentUser.getNomUtilisateur());
		List<Double> listeProgres = new ArrayList<>();
		for (Projet p : listeProjets) {
			if (p.getTaches() == null || p.getTaches().isEmpty()) {
				listeProgres.add((double) 0);
			} else {
				int c = 0;
				for (Tache t : p.getTaches()) {
					if (t.getEtatTache() == EtatTache.Termine)
						c++;
				}
				listeProgres.add((double) (((double) c / p.getTaches().size()) * 100));
			}
		}
		request.setAttribute("listeProjets", listeProjets);
		request.setAttribute("listeProgres", listeProgres);
		request.getRequestDispatcher("Chef.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nomTache = request.getParameter("nomTache");
		String utilisateur = request.getParameter("utilisateur");
		PrioriteTache priorite;
		if (request.getParameter("prioriteTache").equals("h"))
			priorite = PrioriteTache.Haute;
		else if (request.getParameter("prioriteTache").equals("m"))
			priorite = PrioriteTache.Moyenne;
		else
			priorite = PrioriteTache.Faible;
		LocalDateTime dateCreation = LocalDateTime.now();
		LocalDateTime dateFin = LocalDateTime.parse(request.getParameter("dateFin"));

		UtilisateurDao utilisateurDao = new UtilisateurDao();
		Utilisateur user = utilisateurDao.getById(utilisateur);
		Tache tache = new Tache();
		tache.setNomTache(nomTache);
		tache.setUtilisateur(user);
		tache.setDateCreation(dateCreation);
		tache.setDateEcheance(dateFin);
		tache.setEtatTache(EtatTache.EnAttente);
		tache.setPrioriteTache(priorite);
		ProjetDao projetDao = new ProjetDao();
		Projet projet = projetDao.getById(request.getParameter("idProjet"));
//		if(!projet.getMembres().contains(user))
//			projet.getMembres().add(user);
		Boolean found = false;
		for (Utilisateur u : projet.getMembres()) {
			if (u.getNomUtilisateur().equals(user.getNomUtilisateur()))
				found = true;
		}
		if (!found)
			projet.getMembres().add(user);
		tache.setProjet(projet);
		tache.setCommentaires(null);
		TacheDao tacheDao = new TacheDao();
		projetDao.insertProjet(projet);
		tacheDao.insert(tache);
		doGet(request, response);
	}

}
