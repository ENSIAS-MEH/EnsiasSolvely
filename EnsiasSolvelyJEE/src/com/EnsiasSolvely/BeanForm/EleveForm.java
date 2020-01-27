package com.EnsiasSolvely.BeanForm;

import javax.servlet.http.HttpServletRequest;

import com.EnsiasSolvely.DAO.EleveDAO;


public class EleveForm {
	
	public SettingsForm settings = new SettingsForm();
	
	
	public EleveBEAN Authentification(HttpServletRequest request) {
		EleveBEAN eleve = null;
		
		String login = settings.getValeurChamp(request,"login");
		String motdepasse = settings.getValeurChamp(request,"motdepasse");
			
		eleve = EleveDAO.getEleveInformation(login, motdepasse);
		
		if(eleve==null) {
			settings.setErreur("login","Mot de passe ou login incorrecte");
		}
		return eleve;
	}
	

	
	public void Update(HttpServletRequest request){
		settings.erreurs.clear();
		String email = settings.getValeurChamp(request,"email");
		int telephone = Integer.parseInt(settings.getValeurChamp(request,"telephone"));
		String motdepasse = settings.getValeurChamp(request,"motdepasse");
		String login = settings.getValeurChamp(request,"login");
		String chambre = settings.getValeurChamp(request,"chambre");
		int numEleve = Integer.parseInt(settings.getValeurChamp(request,"numEleve"));
		int id_comite = Integer.parseInt(settings.getValeurChamp(request,"id_comite"));
		
		EleveDAO.updateEleveInformation(numEleve, telephone, email, login, motdepasse,chambre,id_comite);
	}
	
	/*fonction inscription*/
	public  boolean Inscription(HttpServletRequest request) {
		settings.erreurs.clear();
		boolean valide = false;
		
		if(eleveExist(request)==true) {
			settings.setErreur("eleveExist", "Login already exist");
			return false;
		}
			
		
	
			/*remplissage de la requette*/
			//int numEleve = Integer.parseInt(settings.getValeurChamp(request,"numEleve"));
			String nom = settings.getValeurChamp(request,"nom");
			String prenom = settings.getValeurChamp(request,"prenom");
			int telephone = Integer.parseInt(settings.getValeurChamp(request,"telephone"));
			String email = settings.getValeurChamp(request,"email");
			String chambre = settings.getValeurChamp(request,"chambre");
			String login = settings.getValeurChamp(request,"login");
			String motdepasse = settings.getValeurChamp(request,"motdepasse");
			int id_comite = Integer.parseInt(settings.getValeurChamp(request,"id_comite")); 
			EleveDAO.insertEleve(nom,prenom,email,telephone,chambre,login,motdepasse,id_comite);
			return !valide;
	}
	
	/*Tester si l'utilisateur existe déja*/
	private boolean eleveExist(HttpServletRequest request) {
		boolean existe = true;
		/*remplissage de la requette*/
		String login = settings.getValeurChamp(request,"login");
		

		if(EleveDAO.countEleve(login)==0) {
			existe =false;
		}
		
		return existe;
	}
}
