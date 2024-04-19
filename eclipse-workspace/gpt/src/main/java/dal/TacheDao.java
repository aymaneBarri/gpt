package dal;

import java.util.List;
import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import model.EtatTache;
import model.Tache;

public class TacheDao {
	private Configuration configuration;
	private SessionFactory sessionFactory;
	private Session session;
	
	public TacheDao() {
		// TODO Auto-generated constructor stub
		this.configuration = new Configuration().configure();
		this.sessionFactory = configuration.buildSessionFactory();
		this.session = sessionFactory.openSession();
	}
	
	public List<Tache> getAll(){
		return this.session.createQuery("FROM Tache", Tache.class).getResultList();
	}
}
