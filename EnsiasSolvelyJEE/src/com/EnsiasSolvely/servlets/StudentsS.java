package com.EnsiasSolvely.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.EnsiasSolvely.BeanForm.EleveBEAN;
import com.EnsiasSolvely.DAO.EleveDAO;

/**
 * Servlet implementation class StudentsS
 */
@WebServlet("/StudentsS")
public class StudentsS extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentsS() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int numEleve =0;
		if((String)request.getParameter("Student_number")!=null) {
			numEleve = Integer.parseInt((String) request.getParameter("Student_number"));
		}
		if(numEleve!=0) {
			doPost(request,response);
		}else {
			EleveBEAN [] eleves = new EleveBEAN[100];
			eleves = EleveDAO.getEleves();
			request.setAttribute("eleves", eleves);
			this.getServletContext().getRequestDispatcher("/WEB-INF/Students.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int numEleve=Integer.parseInt((String) request.getParameter("Student_number"));
		EleveBEAN [] eleves = new EleveBEAN[100];
		eleves[0] = EleveDAO.getEleveInformation(numEleve);
		request.setAttribute("eleves", eleves);
		this.getServletContext().getRequestDispatcher("/WEB-INF/Students.jsp").forward(request, response);
	}

}
