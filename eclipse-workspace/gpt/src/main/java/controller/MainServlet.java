package controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Commentaire;
import model.EtatTache;
import model.Tache;
import model.Utilisateur;

/**
 * Servlet implementation class MainServlet
 */

@WebServlet("/main")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public MainServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
//		Insert
//		Utilisateur utilisateur = new Utilisateur("aymane2","barri1@gmail.com","1234");
//		Configuration configuration = new Configuration().configure();
////		configuration.addAnnotatedClass(Utilisateur.class);
////		ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
//		SessionFactory sessionFactory = configuration.buildSessionFactory();
//		Session session = sessionFactory.openSession();
//		Transaction transaction = session.beginTransaction();
//		session.persist(utilisateur);
//		transaction.commit();
//		session.close();
//		sessionFactory.close();
		
//		Select
//		Utilisateur utilisateur;
//		ArrayList<Utilisateur> utilisateurs = new ArrayList<Utilisateur>();
//		Configuration configuration = new Configuration().configure();
////		configuration.addAnnotatedClass(Utilisateur.class);
////		ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
//		SessionFactory sessionFactory = configuration.buildSessionFactory();
//		Session session = sessionFactory.openSession();
//		Transaction transaction = session.beginTransaction();
//		utilisateur = session.get(Utilisateur.class, "aymane");
//		transaction.commit();
//		session.close();
//		sessionFactory.close();
//		System.out.println(utilisateur);
		
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
//		ArrayList<Commentaire> commentaires = new ArrayList<>();
//		commentaires.add(commentaire1);
//		commentaires.add(commentaire2);
//		commentaires.add(commentaire3);
		Tache tache = new Tache();
		tache.setNomTache("tache1");
		tache.setDateCreation(LocalDateTime.now());
		tache.setDateEcheance(LocalDateTime.of(2024, 05, 06, 10, 30, 45));
		tache.setCommentaires(new ArrayList<>());
		tache.getCommentaires().add(commentaire1);
		tache.getCommentaires().add(commentaire2);
		tache.getCommentaires().add(commentaire3);
		tache.setEtatTache(EtatTache.EnAttente);
		commentaire1.setTache(tache);
		commentaire2.setTache(tache);
		commentaire3.setTache(tache);
//		Utilisateur utilisateur = new Utilisateur("aymane2","barri1@gmail.com","1234");
//		tache.setUtilisateur(utilisateur);
		Configuration configuration = new Configuration().configure();
//		configuration.addAnnotatedClass(Utilisateur.class);
//		ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.persist(tache);
		session.persist(commentaire1);
		session.persist(commentaire2);
		session.persist(commentaire3);
		transaction.commit();
		session.close();
		sessionFactory.close();
		
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
