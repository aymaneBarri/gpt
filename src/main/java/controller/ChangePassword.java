package controller;

import java.io.IOException;

import dal.AuthUser;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Utilisateur;

/**
 * Servlet implementation class ChangePassword
 */

@WebServlet("/changePassword")

public class ChangePassword extends HttpServlet {
	
	
	 
	AuthUser auth_user;
	    
		
	    @Override
	    public void init() throws ServletException {
	    	auth_user = new AuthUser();
	    }

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String identifiant = request.getParameter("identifiant");
		String password  = request.getParameter("password");
		String password_conf  = request.getParameter("password_conf");
		
		Utilisateur founded_user = auth_user.getUser(identifiant);
		
		if(password.equals(password_conf)) {
			auth_user.updateUser(founded_user.getNomUtilisateur(),founded_user.getEmail(),founded_user.getMotDePasse());
			response.sendRedirect("Login.jsp");
		}else {

			response.sendRedirect(request.getContextPath() + "/nouveauPassword.jsp?error=Password not Matches!");
		}
		
		
	}

}
