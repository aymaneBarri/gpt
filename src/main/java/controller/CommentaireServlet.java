package controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import dal.CommentaireDao;
import dal.TacheDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Commentaire;
import model.Tache;

/**
 * Servlet implementation class CommentaireServlet
 */
@WebServlet("/commentaires/*")
public class CommentaireServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String idTache;
	private CommentaireDao commentaireDao;
	private TacheDao tacheDao;
	
	/**
	 * Default constructor.
	 */
	public CommentaireServlet() {
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
//		refreshComments(request);
//		System.out.println("doGet ");
		request.getRequestDispatcher("assets/components/commentairesBody.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
//		if (request.getRequestURI().equals(getServletContext().getContextPath() + "/commentaires/afficher")) {
//			showComments(request);
//		} 
////		else if (request.getRequestURI().equals(getServletContext().getContextPath() + "/commentaires/ajouter")) {
//			addComment(request);
//			refreshComments(request);
//
//			request.getRequestDispatcher("assets/components/commentairesBody.jsp").forward(request, response);
////		}

	}

	public void getComments(HttpServletRequest request) {
		commentaireDao = new CommentaireDao();
		List<Commentaire> listeCommentaires = new ArrayList<>();
		HttpSession session = request.getSession();
		System.out.println("request: " + request.getParameter("idTache") + " idTache: " + idTache);
		if (request.getParameter("idTache") != null)
			idTache = request.getParameter("idTache");
//		idTache = (String) session.getAttribute("idTache");
		System.out.println("just before request: " + request.getParameter("idTache") + " idTache: " + idTache);
		listeCommentaires = commentaireDao.getByTache(idTache);
		session.setAttribute("listeCommentaires", listeCommentaires);
	}
	
	public void refreshComments(HttpServletRequest request) {
		commentaireDao = new CommentaireDao();
		List<Commentaire> listeCommentaires = new ArrayList<>();
		HttpSession session = request.getSession();
		System.out.println("request: " + request.getParameter("idTache") + " idTache: " + idTache);
		System.out.println("just before request: " + request.getParameter("idTache") + " idTache: " + idTache);
		listeCommentaires = commentaireDao.getByTache(idTache);
		session.setAttribute("listeCommentaires", listeCommentaires);
	}
//	
	public void addComment(HttpServletRequest request) {
		commentaireDao = new CommentaireDao();
		tacheDao = new TacheDao();
		System.out.println(request.getParameter("idTache"));
		String texte = (String) request.getParameter("commentaire");
		String commentateur = (String) request.getParameter("commentateur");
		LocalDateTime dateCommentaire = LocalDateTime.now();
		Commentaire commentaire = new Commentaire();
		commentaire.setCommentaire(texte);
		commentaire.setCommentateur(commentateur);
		commentaire.setDateCommentaire(dateCommentaire);
		System.out.println(idTache);
		Tache tache = tacheDao.getById(idTache);
		commentaire.setTache(tache);
		commentaireDao.insertCommentaire(commentaire);
	}
}
