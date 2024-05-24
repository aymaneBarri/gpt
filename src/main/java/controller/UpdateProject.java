package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import dal.ProjetDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Projet;
import model.Utilisateur;

/**
 * Servlet implementation class UpdateProject
 */

@WebServlet("/updateProject")
public class UpdateProject extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ProjetDao projetDao;
    @Override
    	public void init() throws ServletException {
    		projetDao = new ProjetDao();
    	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Get project details from request parameters
        int projectId = Integer.parseInt(request.getParameter("projectId"));
        String projectName = request.getParameter("projectName");
        // Assuming membres and chef are sent as comma-separated strings
        String membresString = request.getParameter("projectMembers");
        String[] membresArray = membresString.split(",");
        List<Utilisateur> membres = new ArrayList();
        
        for (String memberId : membresArray) {
            // Assuming Utilisateur objects have a constructor that takes memberId as parameter
        	Utilisateur user = new Utilisateur();
        	user.setNomUtilisateur(memberId);
            membres.add(user);
        }
        
        // Assuming chefId is sent as a request parameter
        String chefId = request.getParameter("projectLeader");
        // Assuming Utilisateur objects have a constructor that takes userId as parameter
        Utilisateur user_chef = new Utilisateur();
        user_chef.setNomUtilisateur(chefId);
        // Assuming dateFin is sent as a request parameter
        String dateFinString = request.getParameter("projectEndDate");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate dateFin = LocalDate.parse(dateFinString, formatter);
        LocalDateTime dateTimeFin = dateFin.atStartOfDay();

        
        // Create a new Projet object with updated details
        Projet projetToUpdate = new Projet();
        projetToUpdate.setIdProjet(projectId);
        projetToUpdate.setNomProjet(projectName);
        projetToUpdate.setMembres(membres);
        projetToUpdate.setChef(user_chef);
        projetToUpdate.setDateFin(dateTimeFin);
        
        // Update the project
        projetDao.updateProjet(projetToUpdate);

        // Redirect to a success page or send a response
        response.sendRedirect("mesProjets.jsp");

	}

}
