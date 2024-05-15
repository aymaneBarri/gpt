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
 * Servlet implementation class RegisterServlet
 */

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    AuthUser auth_user;
    public RegisterServlet() {
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public void init() throws ServletException {
    	auth_user = new AuthUser();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String identifiant = request.getParameter("identifiant");
		String password  = request.getParameter("password");
		String email  = request.getParameter("email");
		boolean isAdmin = false;
		
		HttpSession session = request.getSession();
		
		if(identifiant.equals("") || email.equals("") || password.equals("") ) {
			session.setAttribute("error", "Please Fill all the records");
	        response.sendRedirect("Register.jsp");
		}
		
		Utilisateur user = new Utilisateur(identifiant,email,password,isAdmin);
		auth_user.register(user);
		response.sendRedirect("Login.jsp");
		
	}

}
