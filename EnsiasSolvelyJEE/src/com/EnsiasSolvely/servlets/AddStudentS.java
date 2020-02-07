package com.EnsiasSolvely.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.EnsiasSolvely.BeanForm.EleveBEAN;
import com.EnsiasSolvely.BeanForm.EleveForm;
import com.EnsiasSolvely.DAO.EleveDAO;
/**
 * Servlet implementation class AddStudentS
 */
@WebServlet("/AddStudentS")
public class AddStudentS extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddStudentS() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.getServletContext().getRequestDispatcher("/WEB-INF/AddStudent.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String path = "/WEB-INF/Students.jsp";
		EleveForm eleveForm = new EleveForm();
		boolean valide = eleveForm.Inscription(request);
		if(valide==false) {
			path ="/WEB-INF/AddStudent.jsp";
			request.setAttribute("form", eleveForm.settings);
		}
		EleveBEAN [] eleves = new EleveBEAN[100];
		eleves = EleveDAO.getEleves();
		request.setAttribute("eleves", eleves);
		request.setAttribute("eleveForm", eleveForm);
		this.getServletContext().getRequestDispatcher(path).forward(request, response);
	}

}
