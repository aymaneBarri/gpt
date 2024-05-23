package controller;

import model.Admin;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;


import java.util.List;


public class AddAdmin  {
	
	public static void main( String[] args ) {
		

		Admin admin1 = new Admin("blabla","bla@gmail","123");
	       Configuration configuration = new Configuration().configure(); SessionFactory
		   sessionFactory = configuration.buildSessionFactory(); Session session =
		   sessionFactory.openSession(); Transaction transaction =
		   session.beginTransaction();
		 
		   session.persist(admin1);
		/*
		 * transaction.commit(); session.close(); sessionFactory.close();
		 */

		
		/*
		 * Admin admin11 = new Admin("ryugahidiky", "ryugahidiky@gmail.com","password");
		 * 
		 * // Load configuration and build session factory Configuration configuration1
		 * = new Configuration().configure(); SessionFactory sessionFactory1 =
		 * configuration1.buildSessionFactory();
		 * 
		 * // Open session and begin transaction Session session1 =
		 * sessionFactory1.openSession(); Transaction transaction1 =
		 * session1.beginTransaction();
		 * 
		 * // Save the admin instance to the database session1.save(admin11);
		 * System.out.println(admin11); // Commit the transaction and close the session
		 * transaction1.commit(); session1.close(); sessionFactory1.close();
		 */

				        System.out.println("Admin added successfully!");

	}
}