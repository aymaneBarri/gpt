package controller;

import java.io.IOException;
import java.util.ArrayList;

import model.Admin;
import model.Projet;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/project")
public class AddProject extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArrayList<Projet> projets = new ArrayList<>();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nomProjet = request.getParameter("nameP");
        String chefProjet = request.getParameter("namechaef");
        int nombreMax =  Integer.parseInt(request.getParameter("max"));

        Projet projet = new Projet(nombreMax,nomProjet, chefProjet);

        
        projets.add(projet);

        request.setAttribute("projets", projets);

   
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        
       
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        
        session.save(projet);
        System.out.println(projet);
        // Commit the transaction and close the session
        transaction.commit();
        session.close();
        sessionFactory.close();
        request.getRequestDispatcher("admin.jsp").forward(request, response);
        }
    }




