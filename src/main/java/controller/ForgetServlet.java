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
 * Servlet implementation class ForgetServlet
 */

@WebServlet("/forget")

public class ForgetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

   
	AuthUser auth_user;
    
	
    @Override
    public void init() throws ServletException {
    	auth_user = new AuthUser();
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String identifiant = request.getParameter("identifiant");
		
    	Utilisateur founded_user = auth_user.getUser(identifiant);
    	if(founded_user != null) {
    			response.sendRedirect(request.getContextPath() + "/nouveauPassword.jsp?user="+identifiant);
    		
		}else {
			response.sendRedirect(request.getContextPath() + "/Login.jsp?error=Not Found User!");
		}
		
	}

}
