package com.EnsiasSolvely.formulaires;

import java.sql.Date;

public class ProblemsBEAN {
	
	private int id_probleme;
	private String lieu;
	private String description;
	private Date date_demande;
	private String Statut;
	private String lastname;
	private String firstname; 
	private int id_type;
	//private String libelle_type;
	private String date;

	
	
	
	


	public ProblemsBEAN(int id_probleme, String lieu, String description, Date date_demande, String statut,
			String lastname, String firstname, int id_type) {
		super();
		this.id_probleme = id_probleme;
		this.lieu = lieu;
		this.description = description;
		this.date_demande = date_demande;
		Statut = statut;
		this.lastname = lastname;
		this.firstname = firstname;
		this.id_type = id_type;
	}



	public int getId_type() {
		return id_type;
	}



	public void setId_type(int id_type) {
		this.id_type = id_type;
	}



	public ProblemsBEAN() {
		super();
	}
	


	public String getLastname() {
		return lastname;
	}
	
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	public String getFirstname() {
		return firstname;
	}
	
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	public int getId_probleme() {
		return id_probleme;
	}
	
	public void setId_probleme(int id_probleme) {
		this.id_probleme = id_probleme;
	}

	public String getLieu() {
		return lieu;
	}

	public void setLieu(String lieu) {
		this.lieu = lieu;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDate_demande() {
		return date_demande;
	}

	public void setDate_demande(Date date_demande) {
		this.date_demande = date_demande;
	}

	public String getStatut() {
		return Statut;
	}

	public void setStatut(String statut) {
		Statut = statut;
	}
	

	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}
	
}
