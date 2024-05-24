package dal;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import jakarta.persistence.PersistenceContext;
import model.Commentaire;
import model.Tache;
import model.Utilisateur;

public class UtilisateurDao {
	@PersistenceContext private Configuration configuration;
	@PersistenceContext private SessionFactory sessionFactory;
	@PersistenceContext private Session session;
	
	public UtilisateurDao() {
		// TODO Auto-generated constructor stub
		this.configuration = new Configuration().configure();
		this.sessionFactory = configuration.buildSessionFactory();
		this.session = sessionFactory.openSession();
	}
	
	public List<Commentaire> getAll(){
		return this.session.createQuery("FROM Utilisateur", Commentaire.class).getResultList();
	}
	
	public Utilisateur getById(String nomUtilisateur) {
		return session.find(Utilisateur.class, nomUtilisateur);
	}
	
	public List<Utilisateur> getNotAdmins(){
//		this.session.createCriteria(Commentaire.class).createAlias("tache", "t").add(Restrictions.eq("t.id", idTache));
//		// Create CriteriaBuilder
//		CriteriaBuilder builder = session.getCriteriaBuilder();
//
//		// Create CriteriaQuery
//		CriteriaQuery<Commentaire> criteria = builder.createQuery(Commentaire.class);
		Query<Utilisateur> query = this.session.createQuery("FROM Utilisateur u WHERE u.isAdmin = false", Utilisateur.class);
		return query.getResultList();
	}
	
	public void insertCommentaire(Commentaire commentaire) {
		Transaction transaction = session.beginTransaction();
		session.persist(commentaire);
		transaction.commit();
//		session.close();
//		sessionFactory.close();
	}
}
