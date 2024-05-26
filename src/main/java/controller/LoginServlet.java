package controller;

import java.io.IOException;

import dal.AuthUser;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Utilisateur;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	AuthUser auth_user;

	@Override
	public void init() throws ServletException {
		auth_user = new AuthUser();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String identifiant = request.getParameter("identifiant");
		String password = request.getParameter("password");
		HttpSession session = request.getSession();

		Utilisateur loggedUser = auth_user.Login(identifiant, password);
		if (loggedUser != null) {
//    			if(loggedUser.isAdmin()) {
//    				session.setAttribute("login", loggedUser);
//    	        	response.sendRedirect("admin");
//    			}else {
//    				session.setAttribute("login", loggedUser);
//    	        	response.sendRedirect("dashboard");
//    	        	
//    			}
			session.setAttribute("login", loggedUser);
			response.sendRedirect("dashboard");

		} else {
			response.sendRedirect(request.getContextPath() + "/Login.jsp?error=Invalid username or password.");
		}

	}

}
