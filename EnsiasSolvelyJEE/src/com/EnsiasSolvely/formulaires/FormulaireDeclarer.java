package com.EnsiasSolvely.formulaires;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


public class FormulaireDeclarer {
	
	private ArrayList<String> errors = new ArrayList<String>();
	FormulaireSettings settings=new FormulaireSettings();
	
	public boolean SendDemande(HttpServletRequest request) throws ParseException {
		/* Récupération de la session depuis la requête */
        HttpSession session = request.getSession();
        EleveBEAN etudiant = (EleveBEAN) session.getAttribute("etudiant");
        String requette = "INSERT INTO probleme(lieu, description, date_demande, statut, id_comite, numEleve, id_type) values(?,?,?,?,?,?,?);";
        try {
			Connection connexion = (new database()).con();
			PreparedStatement statement = connexion.prepareStatement(requette);
			
			/*remplissage de la requette*/
			statement.setString(1,settings.getValeurChamp(request,"lieu"));
			statement.setString(2,settings.getValeurChamp(request,"description"));
			statement.setString(3, settings.getValeurChamp(request,"dateAujourdhui"));		
			statement.setString(4,"en attente");
			//System.out.println(request.getParameter("ID_TC"));
			if(Integer.parseInt(settings.getValeurChamp(request,"ID_TC"))==1 || Integer.parseInt(settings.getValeurChamp(request,"ID_TC"))==2 || Integer.parseInt(settings.getValeurChamp(request,"ID_TC"))==3){
				statement.setInt(5, 1);
			}
			else {
				statement.setInt(5, 2);
			}
			statement.setInt(6, Integer.parseInt(settings.getValeurChamp(request,"numEleve")));
			statement.setInt(7, Integer.parseInt(settings.getValeurChamp(request,"ID_TC")));

			statement.executeUpdate();			
			statement.close();
			connexion.close();
		} catch (SQLException  e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      
        return true;
	}
	
		
	
	
	
	}
