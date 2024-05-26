package controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Commentaire;
import model.EtatTache;
import model.PrioriteTache;
import model.Projet;
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
    @Override
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
		tache.setCommentaires(new ArrayList<Commentaire>());
		tache.getCommentaires().add(commentaire1);
		tache.getCommentaires().add(commentaire2);
		tache.getCommentaires().add(commentaire3);
		tache.setPrioriteTache(PrioriteTache.Haute);
		tache.setEtatTache(EtatTache.EnAttente);
		commentaire1.setTache(tache);
		commentaire2.setTache(tache);
		commentaire3.setTache(tache);
		Tache tache2 = new Tache();
		tache2.setNomTache("tache2");
		tache2.setDateCreation(LocalDateTime.now());
		tache2.setDateEcheance(LocalDateTime.of(2024, 05, 06, 10, 30, 45));
		tache2.setCommentaires(new ArrayList<Commentaire>());
		tache2.getCommentaires().add(commentaire1);
		tache2.getCommentaires().add(commentaire2);
		tache2.getCommentaires().add(commentaire3);
		tache2.setPrioriteTache(PrioriteTache.Haute);
		tache2.setEtatTache(EtatTache.EnAttente);
//		commentaire1.setTache(tache2);
//		commentaire2.setTache(tache2);
//		commentaire3.setTache(tache2);
		Tache tache3 = new Tache();
		tache3.setNomTache("tache3");
		tache3.setDateCreation(LocalDateTime.now());
		tache3.setDateEcheance(LocalDateTime.of(2024, 05, 06, 10, 30, 45));
		tache3.setCommentaires(new ArrayList<Commentaire>());
		tache3.getCommentaires().add(commentaire1);
		tache3.getCommentaires().add(commentaire2);
		tache3.getCommentaires().add(commentaire3);
		tache3.setPrioriteTache(PrioriteTache.Haute);
		tache3.setEtatTache(EtatTache.EnAttente);
		ArrayList<Tache> taches = new ArrayList<Tache>();
		taches.add(tache);
		taches.add(tache2);
		taches.add(tache3);
//		commentaire1.setTache(tache);
//		commentaire2.setTache(tache);
//		commentaire3.setTache(tache);
		
		Utilisateur u1 = new Utilisateur("u1", "email1", "u1", false);
		Utilisateur u2 = new Utilisateur("u2", "email2", "u2", false);
		Utilisateur u3 = new Utilisateur("u3", "email3", "u3", false);
		ArrayList<Utilisateur> users = new ArrayList<Utilisateur>();
		users.add(u1);
		users.add(u2);
		Projet projet1 = new Projet("projet1", 5, LocalDateTime.now(), LocalDateTime.of(2024, 05, 06, 10, 30, 45), u3, users, taches);
		
		tache.setProjet(projet1);
		tache2.setProjet(projet1);
		tache3.setProjet(projet1);
//		Utilisateur utilisateur = new Utilisateur("aymane2","barri1@gmail.com","1234");
//		tache.setUtilisateur(utilisateur);
		Configuration configuration = new Configuration().configure();
//		configuration.addAnnotatedClass(Utilisateur.class);
//		ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
//		session.persist(u1);
//		session.persist(u2);
//		session.persist(u3);
//		session.persist(projet1);
		
		session.persist(tache);
		session.persist(tache2);
		session.persist(tache3);
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
