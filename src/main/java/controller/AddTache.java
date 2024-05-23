package controller;

import java.io.IOException;
import java.util.ArrayList;

import model.Admin;
import model.Projet;
import model.Utilisateur;
import model.Tache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/tache")
public class AddTache extends HttpServlet {
	private static final long serialVersionUID = 1L;
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nomTache = request.getParameter("nameT");
        String nomMembre = request.getParameter("nameUser");
        String priorite=request.getParameter("flexRadioDefault");
        
        Utilisateur user=new Utilisateur();
        user.setNomUtilisateur(nomMembre);
        Tache tache = new Tache(nomTache, user,priorite);

        
   
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        
       
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        
        session.save(tache);
        System.out.println(tache);
        // Commit the transaction and close the session
        transaction.commit();
        session.close();
        sessionFactory.close();
        request.getRequestDispatcher("chef.jsp").forward(request, response);
        }
    }
