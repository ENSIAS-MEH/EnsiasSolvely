package com.EnsiasSolvely.BeanForm;


import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public class SettingsForm {
	public Map<String, String> erreurs = new HashMap<String, String>();
	
	
	public void setErreur( String champ, String message ) {
        erreurs.put( champ, message );
    }
	/*getters erreur*/
	
	public Map<String, String> getErreurs() {
		return erreurs;
	}
	
	/*fonction pour stocker les entrees*/
	
	public String getValeurChamp( HttpServletRequest request, String nomChamp ) {
	        String valeur = request.getParameter( nomChamp );
	        if ( valeur == null) {
	            return null;
	        } else {
	            return valeur;
	        }
	 }
	



}
