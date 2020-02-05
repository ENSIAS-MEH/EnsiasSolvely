package com.EnsiasSolvely.BeanForm;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.EnsiasSolvely.DAO.ProblemsDAO;

public class ProblemsForm {
	
	public SettingsForm settings = new SettingsForm();
	
	public boolean SendProblem(HttpServletRequest request) throws ParseException{
		/* Récupération de la session depuis la requête */
		int id_type = Integer.parseInt(settings.getValeurChamp(request,"id_type"));
        HttpSession session = request.getSession();
        EleveBEAN eleve = (EleveBEAN) session.getAttribute("eleve");
        
        SimpleDateFormat formatter2 = new SimpleDateFormat("YYYY-MM-dd");
    	Date df=new SimpleDateFormat("yyyy-MM-dd",Locale.FRENCH).parse(settings.getValeurChamp(request,"date_demande"));

    	/*remplissage de la requette*/
		String lieu = settings.getValeurChamp(request,"lieu");
		String description = settings.getValeurChamp(request,"description");
		String date_demande = formatter2.format(df);		
		String statut = "Actif";
		int id_comite = 1;
		if(id_type>3) id_comite = 2;
		int numEleve = eleve.getNumeleve();
		
		ProblemsDAO.insertProblem(lieu, description, date_demande, statut, id_comite, numEleve, id_type);   
  
        return true;
	}


	/*
	 * This function fetch connected student's problems
	 */
	public static ProblemsBEAN[] userProblems(HttpServletRequest request)  {
		
		/* R飵p鲡tion de la session depuis la requ괥 */
        HttpSession session = request.getSession();
        EleveBEAN  eleve = (EleveBEAN) session.getAttribute( "eleve");
        int numEleve = eleve.getNumeleve();
		ProblemsBEAN[] problems = new ProblemsBEAN[100];
		
		problems = ProblemsDAO.getEleveProblems(numEleve);
		
		return problems;
	}
	
	public void changeStatut(HttpServletRequest request){
		settings.erreurs.clear();
		HttpSession session = request.getSession();
        EleveBEAN eleve = (EleveBEAN) session.getAttribute("eleve");
		//info recup鲥r de la JSP
		int id_problem = Integer.parseInt(settings.getValeurChamp(request,"id_problem"));
		String statut_decision = settings.getValeurChamp(request,"statut_decision");
		int id_comite = eleve.getId_comite();
		//statut dans la table
		String statut = ProblemsDAO.getStatut(id_problem);
		
		//traitement
		if(statut != null && statut.contains("Actif")) {
				ProblemsDAO.changeStatut(id_problem, statut_decision, id_comite);
		}else {
			settings.setErreur("problemNotFound","problem not found");
		}
	}
	
	public void incrementLikes(HttpServletRequest request) {
		settings.erreurs.clear();
		HttpSession session = request.getSession();
		int id_probleme = Integer.parseInt(settings.getValeurChamp(request, "id_probleme"));
		ProblemsDAO.incrementLikes(id_probleme);
	}
	
	public boolean checkLike(HttpServletRequest request) {
		settings.erreurs.clear();
		HttpSession session = request.getSession();
        EleveBEAN eleve = (EleveBEAN) session.getAttribute("eleve");
		int id_probleme = Integer.parseInt(settings.getValeurChamp(request, "id_probleme"));
		int numEleve = eleve.getNumeleve();
		return ProblemsDAO.isLiked(id_probleme, numEleve);
	}
	
	public void addLike(HttpServletRequest request) {
		settings.erreurs.clear();
		HttpSession session = request.getSession();
        EleveBEAN eleve = (EleveBEAN) session.getAttribute("eleve");
		int id_probleme = Integer.parseInt(settings.getValeurChamp(request, "id_probleme"));
		int numEleve = eleve.getNumeleve();
		ProblemsDAO.setLike(id_probleme, numEleve);
	}

}
