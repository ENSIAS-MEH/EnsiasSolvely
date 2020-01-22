package com.EnsiasSolvely.BeanForm;

import java.util.Date;

public class ProblemsBEAN {
	
	private int id_probleme;
	private String lieu;
	private String description;
	private Date date_demande;	
	private String statut;
	private String nom;
	private String prenom;
	private String nom_comite;
	private String libelle_type;
	
	
	
	public ProblemsBEAN(int id_probleme, String lieu, String description, Date date_demande, String statut, String nom,
			String prenom, String nom_comite, String libelle_type) {
		super();
		this.id_probleme = id_probleme;
		this.lieu = lieu;
		this.description = description;
		this.date_demande = date_demande;
		this.statut = statut;
		this.nom = nom;
		this.prenom = prenom;
		this.nom_comite = nom_comite;
		this.libelle_type = libelle_type;
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
		return statut;
	}
	public void setStatut(String statut) {
		this.statut = statut;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getNom_comite() {
		return nom_comite;
	}
	public void setNom_comite(String nom_comite) {
		this.nom_comite = nom_comite;
	}
	public String getLibelle_type() {
		return libelle_type;
	}
	public void setLibelle_type(String libelle_type) {
		this.libelle_type = libelle_type;
	}
	
	

}
