package com.EnsiasSolvely.formulaires;

public class EleveBEAN {
	
	private int numEleve;
	private String nom;
	private String prenom;
	private String email;
	private	int telephone;
	private String chambre;
	private String login;
	private String motdePasse;
	private int id_comite;
	
	
	public EleveBEAN(int numEleve, String nom, String prenom, String email, int telephone, String chambre,
			String login, String motdePasse, int id_comite) {
		super();
		this.numEleve = numEleve;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.telephone = telephone;
		this.chambre = chambre;
		this.login = login;
		this.motdePasse = motdePasse;
		this.id_comite = id_comite;
	}
	
	
	public EleveBEAN() {
		super();
	}


	public int getNumEleve() {
		return numEleve;
	}
	public void setNumEleve(int numEleve) {
		this.numEleve = numEleve;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getTelephone() {
		return telephone;
	}
	public void setTelephone(int telephone) {
		this.telephone = telephone;
	}
	public String getChambre() {
		return chambre;
	}
	public void setChambre(String chambre) {
		this.chambre = chambre;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getMotdePasse() {
		return motdePasse;
	}
	public void setMotdePasse(String motdePasse) {
		this.motdePasse = motdePasse;
	}
	public int getId_comite() {
		return id_comite;
	}
	public void setId_comite(int id_comite) {
		this.id_comite = id_comite;
	}
	

}
