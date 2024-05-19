package dal;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import model.Commentaire;

@Stateless
public class CommentaireDao {
	@PersistenceContext private Configuration configuration;
	@PersistenceContext private SessionFactory sessionFactory;
	@PersistenceContext private Session session;
	
	@Inject public CommentaireDao() {
		// TODO Auto-generated constructor stub
		this.configuration = new Configuration().configure();
		this.sessionFactory = configuration.buildSessionFactory();
		this.session = sessionFactory.openSession();
	}
	
	public List<Commentaire> getAll(){
		return this.session.createQuery("FROM Commentaire", Commentaire.class).getResultList();
	}
	
	public List<Commentaire> getByTache(String idTache){
//		this.session.createCriteria(Commentaire.class).createAlias("tache", "t").add(Restrictions.eq("t.id", idTache));
//		// Create CriteriaBuilder
//		CriteriaBuilder builder = session.getCriteriaBuilder();
//
//		// Create CriteriaQuery
//		CriteriaQuery<Commentaire> criteria = builder.createQuery(Commentaire.class);
		Query<Commentaire> query = this.session.createQuery("FROM Commentaire c WHERE c.tache.idTache = :idTache", Commentaire.class);
		query.setParameter("idTache",idTache);
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
