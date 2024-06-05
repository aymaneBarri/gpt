package dal;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import jakarta.persistence.Query;
import model.Utilisateur;

public class AuthUser {
	private Configuration configuration;
	private SessionFactory sessionFactory;
	private Session session;

	public AuthUser() {
		// TODO Auto-generated constructor stub
		this.configuration = new Configuration().configure();
		this.sessionFactory = configuration.buildSessionFactory();
	}

	public void register(Utilisateur user) {
		Transaction tx = null;
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			Utilisateur _user = new Utilisateur(user.getNomUtilisateur(), user.getEmail(), user.getMotDePasse(),
					user.isAdmin());
			session.persist(_user);
			tx.commit();
			session.close();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

	}

	public Utilisateur Login(String username, String password) {
		Transaction tx = null;
		Utilisateur user = null;

		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			user = (Utilisateur) session.get(Utilisateur.class, username);
			if (user != null) {
				if (user.getMotDePasse().equals(password)) {
					tx.commit();
				} else {
					tx.rollback();
					return null;
				}
			}
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

		return user;
	}

	public void updateUser(String username, String email, String password) {

		Transaction tx = null;
		session = sessionFactory.openSession();
		tx = session.beginTransaction();

		// Retrieve the user object from the database
		Utilisateur existingUser = (Utilisateur) session.get(Utilisateur.class, username);

		if (existingUser != null) {
			existingUser.setEmail(email);
			existingUser.setMotDePasse(password);
			session.persist(existingUser);
			tx.commit();
		} else {
			System.out.println("EMPTY");
		}
		session.close();

	}

	public Utilisateur getUser(String username) {
		Transaction tx = null;
		Utilisateur user = null;

		try {
			tx = session.beginTransaction();
			session = sessionFactory.openSession();
			user = (Utilisateur) session.get(Utilisateur.class, username);
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

		return user;
	}

}
