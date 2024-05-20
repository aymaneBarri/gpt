package controller;

import java.io.IOException;

import dal.AuthUser;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Utilisateur;

/**
 * Servlet implementation class EditUserServlet
 */

@WebServlet("/edit")
public class EditUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

   
	AuthUser auth_user;
    
	
    @Override
    public void init() throws ServletException {
    	auth_user = new AuthUser();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		Utilisateur user = new Utilisateur(name,email,password,false);
		
		session.setAttribute("login", user);
		auth_user.updateUser(name,email,password);
		response.sendRedirect("dashboard");
	}

}
