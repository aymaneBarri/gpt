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
		this.session = sessionFactory.openSession();
	}
	
	public void register(Utilisateur user) {
		    Transaction tx = null;
		    
		    try {
		       tx = session.beginTransaction();
		       Utilisateur _user = new Utilisateur(user.getNomUtilisateur(),user.getEmail(),user.getMotDePasse(),user.isAdmin());
		       session.persist(_user); 
		       tx.commit();
		    } catch (HibernateException e) {
		       if (tx!=null) tx.rollback();
		       e.printStackTrace(); 
		    } finally {
		       session.close(); 
		    }
		
	}
	
	
	public Utilisateur Login(String username, String password) {
	    Transaction tx = null;
	    Utilisateur user = null;
	    
	    try {
	        tx = session.beginTransaction();
	        user = (Utilisateur) session.get(Utilisateur.class, username);
	        if(user != null) {
		        if(user.getMotDePasse().equals(password)) {
		        	tx.commit();
		        }else {
	        	tx.rollback();
	        	return null;
	        	}
	       }
	    } catch (HibernateException e) {
	        if (tx != null) tx.rollback();
	        e.printStackTrace();
	    } finally {
	        session.close();
	    }
	    
	    return user;
	}
}
