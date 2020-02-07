package com.EnsiasSolvely.servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.EnsiasSolvely.BeanForm.ProblemsBEAN;
import com.EnsiasSolvely.BeanForm.SettingsForm;
import com.EnsiasSolvely.DAO.ProblemsDAO;

/**
 * Servlet implementation class ArchiveS
 */
@WebServlet("/ArchiveS")
public class ArchiveS extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ArchiveS() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProblemsBEAN problems[] = new ProblemsBEAN[100];
		problems = ProblemsDAO.getFinalProblems();
		request.setAttribute("problems", problems);
		this.getServletContext().getRequestDispatcher("/WEB-INF/Archive.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		SettingsForm settings = new SettingsForm();
		SimpleDateFormat formatter2=new SimpleDateFormat("yyyy-MM-dd");  
		ProblemsBEAN problem = null;
		try {
			Date problemDate = formatter2.parse(settings.getValeurChamp(request, "date_demande"));
			problem =  new ProblemsBEAN(Integer.parseInt(settings.getValeurChamp(request,"id_probleme")), settings.getValeurChamp(request,"lieu"), settings.getValeurChamp(request,"description"), problemDate, settings.getValeurChamp(request,"statut"), settings.getValeurChamp(request,"nom"),
					settings.getValeurChamp(request,"prenom"), settings.getValeurChamp(request,"nom_comite"), settings.getValeurChamp(request,"libelle_type"), settings.getValeurChamp(request, "likes"));
			
		} catch (NumberFormatException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(settings.getValeurChamp(request, "statut").toString().contains("Solved")) {
			request.setAttribute("printable", problem);
		}*/
		doGet(request, response);
	}

}
