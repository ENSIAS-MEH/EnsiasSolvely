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
import com.EnsiasSolvely.BeanForm.ProblemsForm;
import com.EnsiasSolvely.BeanForm.SettingsForm;
import com.EnsiasSolvely.DAO.ProblemsDAO;

/**
 * Servlet implementation class ProblemsS
 */
@WebServlet("/ProblemsS")
public class ProblemsS extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProblemsS() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
        EleveBEAN eleve = (EleveBEAN) session.getAttribute("eleve");
		ProblemsBEAN[] problems = ProblemsDAO.getActifProblems(eleve.getId_comite());
		ProblemsBEAN[] problemsLiked = ProblemsDAO.getLikedProblems(eleve.getNumeleve());
		request.setAttribute("problems", problems);
		request.setAttribute("problemsLiked", problemsLiked);
		this.getServletContext().getRequestDispatcher("/WEB-INF/Problems.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProblemsForm problemsForm = new ProblemsForm();
		SettingsForm settings = new SettingsForm();
		if(settings.getValeurChamp(request, "id_problem")!=null) {
			problemsForm.changeStatut(request);
		}
		else {
			if(!problemsForm.checkLike(request)) {
				problemsForm.incrementLikes(request);
				problemsForm.addLike(request);
			}
		}
		if(!problemsForm.settings.getErreurs().isEmpty()) {
			request.setAttribute("form", problemsForm.settings);
		}
		doGet(request, response);
	}

}
