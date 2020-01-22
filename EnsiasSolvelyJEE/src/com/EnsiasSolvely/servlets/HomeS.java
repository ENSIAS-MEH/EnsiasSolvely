package com.EnsiasSolvely.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.EnsiasSolvely.formulaires.EleveBEAN;
import com.EnsiasSolvely.formulaires.FormulaireAuthentification;


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
		
		
		int con = 0;
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
		String path = "/WEB-INF/Home.jsp";
		EleveBEAN eleve = new EleveBEAN();
		FormulaireAuthentification form = new FormulaireAuthentification();
		eleve = form.Authentification(request);
        HttpSession session = request.getSession();
        if ( form.getErreurs().isEmpty() ) {
            session.setAttribute("eleve",eleve);
    		request.setAttribute("eleve",eleve);
  
    		String comite = form.getComite(eleve.getId_comite());
    		request.setAttribute("comite", comite);
           
        } else {
            session.setAttribute( "eleve", null );   
        }
        request.setAttribute("form", form);		
		this.getServletContext().getRequestDispatcher(path).forward(request, response);

	}

}