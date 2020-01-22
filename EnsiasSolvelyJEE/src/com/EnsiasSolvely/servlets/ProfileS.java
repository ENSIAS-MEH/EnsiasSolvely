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
import com.EnsiasSolvely.DAO.EleveDAO;

/**
 * Servlet implementation class ProfileS
 */
@WebServlet("/ProfileS")
public class ProfileS extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfileS() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int numEleve=0;
		if(request.getParameter("numEleve")!=null) {
			numEleve= Integer.parseInt(request.getParameter("numEleve"));
		}
		
		/* Récupération de la session depuis la requête */
        HttpSession session = request.getSession();
        EleveBEAN  eleve = (EleveBEAN) session.getAttribute( "eleve");
		if(numEleve!=0) {
			eleve = EleveDAO.getEleveInformation(numEleve);
		}else {
			eleve =  EleveDAO.getEleveInformation(eleve.getNumeleve());
		}
		request.setAttribute("eleve", eleve);
		this.getServletContext().getRequestDispatcher("/WEB-INF/Profile.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		EleveForm eleveForm = new EleveForm();
		int numEleve=0;
		if(request.getParameter("numEleve")!=null) numEleve= Integer.parseInt(request.getParameter("numEleve"));
		if(numEleve!=0) {
			request.setAttribute("numEleve", numEleve);
		}
		eleveForm.Update(request);
		doGet(request, response);
	}

}
