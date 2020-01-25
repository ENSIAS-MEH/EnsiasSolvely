package com.EnsiasSolvely.servlets;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.EnsiasSolvely.BeanForm.EleveBEAN;
import com.EnsiasSolvely.BeanForm.ProblemsForm;
import com.EnsiasSolvely.DAO.ProblemsDAO;

/**
 * Servlet implementation class DeclareS
 */
@WebServlet("/DeclareS")
public class DeclareS extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeclareS() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		EleveBEAN eleve = (EleveBEAN) session.getAttribute("eleve");
		request.setAttribute("eleve", eleve);
		request.setAttribute("todayDate", ProblemsDAO.getDateAujourdhui());
		this.getServletContext().getRequestDispatcher("/WEB-INF/Declare.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		ProblemsForm problemsForm = new ProblemsForm();
		try {
			problemsForm.SendProblem(request);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.getServletContext().getRequestDispatcher("/WEB-INF/Declare.jsp").forward(request, response);
	}

}
