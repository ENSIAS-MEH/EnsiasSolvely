package com.EnsiasSolvely.servlets;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.EnsiasSolvely.DAO.ArchivageDAO;
import com.EnsiasSolvely.formulaires.ProblemsBEAN;




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
		// TODO Auto-generated method stub
		ProblemsBEAN donnees[] = new ProblemsBEAN[100];
		ArchivageDAO form = new ArchivageDAO();
		donnees = form.Archive();
		request.setAttribute("donnees", donnees);
		this.getServletContext().getRequestDispatcher("/WEB-INF/Archive.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		SimpleDateFormat formatter2=new SimpleDateFormat("yyyy-MM-dd");  
		ProblemsBEAN demandes = null;
		try {
			//[i] = new DonneeProbleme(resultat.getInt("id_probleme"), resultat.getString("lieu"), resultat.getDate("date_demande"), resultat.getInt("id_type"), resultat.getString("nom"), resultat.getString("prenom"), resultat.getString("description"), resultat.getString("statut"));

			demandes = new ProblemsBEAN(Integer.parseInt(getValeurChamp(request,"id_probleme")),getValeurChamp(request,"lieu"),formatter2.format(getValeurChamp(request,"date_demande")),Integer.parseInt(getValeurChamp(request,"type")),getValeurChamp(request,"LastName"),getValeurChamp(request,"FirstName"),getValeurChamp(request,"description"), getValeurChamp(request,"statut"));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(getValeurChamp(request, "statut").toString().contains("Validé")) {
			request.setAttribute("printable", demandes);
		}
		doGet(request, response);
	
	}
/*fonction pour stocker les entrees*/
	
	public static String getValeurChamp( HttpServletRequest request, String nomChamp ) {
	        String valeur = request.getParameter( nomChamp );
	        if ( valeur == null) {
	            return null;
	        } else {
	            return valeur;
	        }
	 }
	

}
