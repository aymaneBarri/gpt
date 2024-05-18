package filters;

import java.io.IOException;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.*;

@WebFilter("/dashboard")
public class AuthFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        
    }

    @Override
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

    @Override
    public void destroy() {
        // Nettoyage si nécessaire
    }
}