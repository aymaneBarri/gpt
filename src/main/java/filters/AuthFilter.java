package filters;

import java.io.IOException;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebFilter(urlPatterns={"/dashboard","/chef","/admin"})
public class AuthFilter implements Filter {
	
	public void init(FilterConfig filterConfig) throws ServletException {
        
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        HttpSession session = req.getSession(false);

        // Vérifier si l'utilisateur est connecté
        
        if (session != null && session.getAttribute("login") != null) {
            // Utilisateur connecté, continuer vers la ressource demandée
            chain.doFilter(request, response);
        } else {
            // Utilisateur non connecté, rediriger vers la page de login
            res.sendRedirect(req.getContextPath() + "/Login.jsp");
        }
    }

    public void destroy() {
        // Nettoyage si nécessaire
    }

    
  
}
