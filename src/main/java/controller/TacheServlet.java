package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import dal.TacheDao;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.EtatTache;
import model.Tache;

/**
 * Servlet implementation class TacheServlet
 */
@WebServlet("/taches")
public class TacheServlet extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TacheServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		TacheDao tacheDao = new TacheDao();
		List<Tache> listeTachesEnAttente = new ArrayList<>();
		List<Tache> listeTachesEnCours = new ArrayList<>();
		List<Tache> listeTachesTermine = new ArrayList<>();
		List<Tache> listeTaches = tacheDao.getAll();
		for (Tache tache : listeTaches) {
			if(tache.getEtatTache() == EtatTache.EnAttente)
				listeTachesEnAttente.add(tache);
			else if(tache.getEtatTache() == EtatTache.EnCours)
				listeTachesEnCours.add(tache);
			else if(tache.getEtatTache() == EtatTache.Termine)
				listeTachesTermine.add(tache);
		}
		request.setAttribute("listeTachesEnAttente", listeTachesEnAttente);
		request.setAttribute("listeTachesEnCours", listeTachesEnCours);
		request.setAttribute("listeTachesTermine", listeTachesTermine);
		
		request.getRequestDispatcher("assets/components/taches.jsp").forward(request, response);
		
//		response.sendRedirect("assets/components/taches.jsp");
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		TacheDao tacheDao = new TacheDao();
		System.out.println("hhhh "+request.getParameter("idTache"));
		tacheDao.updateTaskStatus(request.getParameter("idTache"), request.getParameter("etatTache"));
//		request.getRequestDispatcher("dashboard.jsp").forward(request, response);
	}

}
