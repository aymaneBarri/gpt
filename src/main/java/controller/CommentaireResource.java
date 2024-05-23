package controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.glassfish.jersey.server.Uri;

import com.google.gson.Gson;

import dal.CommentaireDao;
import dal.TacheDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import model.Commentaire;
import model.Tache;

@Path("commentaires")
public class CommentaireResource {
	@Context
	private HttpServletRequest request;
	@Context
	private HttpServletResponse response;
	private CommentaireDao commentaireDao;
	private TacheDao tacheDao;

	@GET
	@Path("/hello")
	@Produces("text/plain")
	public String sayHello() {
		String resource = "<? xml version='1.0' ?>" + "<hello> Hi, This is is Hello from XML</hello>";
		return resource;
	}

	@GET
	@Path("afficher")
	@Produces(MediaType.APPLICATION_JSON)
	public String getComments(@Context HttpServletRequest request, @Context HttpServletResponse response)
			throws ServletException, IOException {
		commentaireDao = new CommentaireDao();
		List<Commentaire> listeCommentaires = new ArrayList<>();
		String idTache = request.getParameter("idTache");
		System.out.println("rest 31 getComments request.getParameter(\"idTache\"): " + request.getParameter("idTache")
				+ " " + idTache);
		listeCommentaires = commentaireDao.getByTache(idTache);
		HttpSession session = request.getSession();
		session.setAttribute("listeCommentaires", listeCommentaires);
		session.setAttribute("idTache", idTache);
		
		
		Gson gson = new Gson();
	    Commentaire commentaire1 = new Commentaire();
		commentaire1.setCommentaire("commentaire1");
		commentaire1.setCommentateur("commentateur1");
		commentaire1.setDateCommentaire(LocalDateTime.now());
		Commentaire commentaire2 = new Commentaire();
		commentaire1.setCommentaire("commentaire2");
		commentaire1.setCommentateur("commentateur2");
		commentaire1.setDateCommentaire(LocalDateTime.now());
		Commentaire commentaire3 = new Commentaire();
		commentaire1.setCommentaire("commentaire3");
		commentaire1.setCommentateur("commentateur3");
		commentaire1.setDateCommentaire(LocalDateTime.now());
	    listeCommentaires.add(commentaire1);
	    listeCommentaires.add(commentaire2);
	    listeCommentaires.add(commentaire3);
	    String jsonArray = gson.toJson(listeCommentaires);
	    System.out.println("listeCommentaires json: " + listeCommentaires + " " + jsonArray);
//	    Assert.assertEquals(expectedJsonArray, jsonArray);
		return jsonArray;
	}

	@POST
	@Path("ajouter")
	public void addComment(@QueryParam("idTache") String idTache, @FormParam("commentaire") String texte,
			@FormParam("commentateur") String commentateur) {
		commentaireDao = new CommentaireDao();
		tacheDao = new TacheDao();
		HttpSession session = request.getSession();
		idTache = (String) session.getAttribute("idTache");
		System.out.println("rest 44 addComment request.getParameter(\"idTache\"): " + request.getParameter("idTache")
				+ " " + idTache);
//		String texte = (String) request.getParameter("commentaire");
//		String commentateur = (String) request.getParameter("commentateur");
		LocalDateTime dateCommentaire = LocalDateTime.now();
		Commentaire commentaire = new Commentaire();
		commentaire.setCommentaire(texte);
		commentaire.setCommentateur(commentateur);
		commentaire.setDateCommentaire(dateCommentaire);
		Tache tache = tacheDao.getById(idTache);
		commentaire.setTache(tache);
		commentaireDao.insertCommentaire(commentaire);

		List<Commentaire> listeCommentaires = new ArrayList<>();
		listeCommentaires = commentaireDao.getByTache(idTache);
		session.setAttribute("listeCommentaires", listeCommentaires);
		session.setAttribute("idTache", idTache);

	}
}