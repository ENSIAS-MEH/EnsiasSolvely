package com.EnsiasSolvely.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.EnsiasSolvely.BeanForm.EleveBEAN;
import com.EnsiasSolvely.BeanForm.ProblemsBEAN;
import com.EnsiasSolvely.DAO.ProblemsDAO;

/**
 * Servlet implementation class StudentProblemsS
 */
@WebServlet("/StudentProblemsS")
public class StudentProblemsS extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentProblemsS() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
        EleveBEAN eleve = (EleveBEAN) session.getAttribute("eleve");
		ProblemsBEAN problems[] = new ProblemsBEAN[100];
		problems = ProblemsDAO.getActifProblems(eleve.getNumeleve());
		request.setAttribute("problems", problems);
		this.getServletContext().getRequestDispatcher("/WEB-INF/StudentProblems.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
