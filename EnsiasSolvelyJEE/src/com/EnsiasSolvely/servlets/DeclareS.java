package com.EnsiasSolvely.servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.EnsiasSolvely.formulaires.EleveBEAN;
import com.EnsiasSolvely.formulaires.FormulaireAuthentification;
import com.EnsiasSolvely.formulaires.FormulaireDeclarer;


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
		// TODO Auto-generated method stub
		 HttpSession session = request.getSession();
		 EleveBEAN etudiant = (EleveBEAN) session.getAttribute("etudiant");
		 SimpleDateFormat formatter2 = new SimpleDateFormat("YYYY-MM-dd");
	     Date dateAujourdhui=new Date();
     	 String df2=formatter2.format(dateAujourdhui);
     	 request.setAttribute("dateAujourdhui", df2);
		 request.setAttribute("etudiant", etudiant);

		this.getServletContext().getRequestDispatcher("/WEB-INF/Declare.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		FormulaireDeclarer form=new FormulaireDeclarer();
		try {
			form.SendDemande(request);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		doGet(request, response);
	}

}
