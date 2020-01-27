package com.EnsiasSolvely.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.EnsiasSolvely.BeanForm.EleveBEAN;
import com.EnsiasSolvely.BeanForm.EleveForm;

/**
 * Servlet implementation class HomeS
 */
@WebServlet("/HomeS")
public class HomeS extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */

    public HomeS() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int con = -1;
		if(request.getParameter("con")!=null) {
			con = Integer.parseInt(request.getParameter("con"));
		}
		if(con==0) {
			HttpSession session = request.getSession();
			session.setAttribute("eleve", null);
		}
		this.getServletContext().getRequestDispatcher("/WEB-INF/Home.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String path = "/WEB-INF/Home.jsp";
		EleveBEAN eleve = null;
		EleveForm eleveForm = new EleveForm();
		eleve = eleveForm.Authentification(request);
		/* Récupération de la session depuis la requête */
        HttpSession session = request.getSession();
        /*si l'utilisateur saisi les champs correctement on l'ajoute a la session*/
        if ( eleveForm.settings.getErreurs().isEmpty() ) {
            session.setAttribute( "eleve", eleve );
    		request.setAttribute("eleve",eleve);
  
    		
            path = "/WEB-INF/Home.jsp";
        } else {
            session.setAttribute( "eleve", null );
            
        }
        request.setAttribute("form", eleveForm.settings);
		this.getServletContext().getRequestDispatcher(path).forward(request, response);
	}

}
