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
		/* RÃ©cupÃ©ration de la session depuis la requÃªte */
		int id_type = Integer.parseInt(settings.getValeurChamp(request,"id_type"));
        HttpSession session = request.getSession();
        EleveBEAN eleve = (EleveBEAN) session.getAttribute("eleve");
        
        SimpleDateFormat formatter2 = new SimpleDateFormat("YYYY-MM-dd");
    	Date df=new SimpleDateFormat("yyyy-MM-dd",Locale.FRENCH).parse(settings.getValeurChamp(request,"date_demande"));

    	/*remplissage de la requette*/
		String lieu = settings.getValeurChamp(request,"lieu");
		String description = settings.getValeurChamp(request,"description");
		String date_demande = formatter2.format(df);		
		String statut = "en attente";
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
		
		/* Récupération de la session depuis la requête */
        HttpSession session = request.getSession();
        EleveBEAN  eleve = (EleveBEAN) session.getAttribute( "eleve");
        int numEleve = eleve.getNumeleve();
		ProblemsBEAN[] problems = new ProblemsBEAN[100];
		
		problems = ProblemsDAO.getEleveProblems(numEleve);
		
		return problems;
	}
	
	public void changeStatut(HttpServletRequest request){
		settings.erreurs.clear();
		
		//info recupérer de la JSP
		int id_problem = Integer.parseInt(settings.getValeurChamp(request,"id_problem"));
		String statut_decision = settings.getValeurChamp(request,"statut_decision");
		
		//statut dans la table
		String statut = ProblemsDAO.getStatut(id_problem);
		
		//traitement
		if(statut != null && statut.contains("Actif")) {
				ProblemsDAO.changeStatut(id_problem,statut_decision);
		}else {
			settings.setErreur("problemNotFound","problem not found");
		}
	}

}
