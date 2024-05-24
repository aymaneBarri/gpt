package dal;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import jakarta.persistence.PersistenceContext;
import model.Projet;

public class ProjetDao {
	@PersistenceContext private Configuration configuration;
	@PersistenceContext private SessionFactory sessionFactory;
	@PersistenceContext private Session session;
	
	public ProjetDao() {
		// TODO Auto-generated constructor stub
		this.configuration = new Configuration().configure();
		this.sessionFactory = configuration.buildSessionFactory();
		this.session = sessionFactory.openSession();
	}
	
	public List<Projet> getAll(){
		return this.session.createQuery("FROM Projet", Projet.class).getResultList();
	}
	
	public List<Projet> getProjectsByUser(String nomUtilisateur){
//		this.session.createCriteria(Commentaire.class).createAlias("tache", "t").add(Restrictions.eq("t.id", idTache));
//		// Create CriteriaBuilder
//		CriteriaBuilder builder = session.getCriteriaBuilder();
//
//		// Create CriteriaQuery
//		CriteriaQuery<Commentaire> criteria = builder.createQuery(Commentaire.class);
		Query<Projet> query = this.session.createQuery("FROM Projet p WHERE p.chef.nomUtilisateur = :nomUtilisateur", Projet.class);
		query.setParameter("nomUtilisateur",nomUtilisateur);
		return query.getResultList();
	}
	
	public void insertProjet(Projet projet) {
		Transaction transaction = session.beginTransaction();
		session.persist(projet);
		transaction.commit();
//		session.close();
//		sessionFactory.close();
	}
	
	public void updateProjet(Projet projet) {
	    Transaction transaction = null;
	    try {
	        // Start a transaction
	        transaction = session.beginTransaction();

	        // Fetch the existing project from the database
	        Projet existingProjet = session.get(Projet.class, projet.getIdProjet());

	        if (existingProjet != null) {
	            // Update the existing project's details with the new values
	            existingProjet.setNomProjet(projet.getNomProjet());
	            existingProjet.setMembres(projet.getMembres());
	            existingProjet.setChef(projet.getChef());
	            existingProjet.setDateFin(projet.getDateFin());

	            // Persist the updated project object
	            session.update(existingProjet);

	            // Commit the transaction
	            transaction.commit();
	        } else {
	            System.out.println("Project with ID " + projet.getIdProjet() + " does not exist.");
	        }
	    } catch (Exception e) {
	        if (transaction != null) {
	            transaction.rollback();
	        }
	        e.printStackTrace();
	    } 
	}

}
