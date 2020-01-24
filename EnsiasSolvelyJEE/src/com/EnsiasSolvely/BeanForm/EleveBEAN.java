package com.EnsiasSolvely.BeanForm;

public class EleveBEAN {
	
	private int numeleve;
	private String nom;
	private String prenom;
	private String email;
	private int telephone;
	private String chambre;
	private String login;
	private String motdepasse;
	private int id_comite;
	private String nom_comite;
	
	
	public EleveBEAN(int numeleve, String nom, String prenom, String email, int telephone, String chambre, String login,
			String motdepasse, int id_comite, String nom_comite) {
		super();
		this.numeleve = numeleve;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.telephone = telephone;
		this.chambre = chambre;
		this.login = login;
		this.motdepasse = motdepasse;
		this.id_comite = id_comite;
		this.nom_comite = nom_comite;
	}
	
	public int getNumeleve() {
		return numeleve;
	}
	public void setNumeleve(int numeleve) {
		this.numeleve = numeleve;
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
	public String getMotdepasse() {
		return motdepasse;
	}
	public void setMotdepasse(String motdepasse) {
		this.motdepasse = motdepasse;
	}
	public int getId_comite() {
		return id_comite;
	}
	public void setId_comite(int id_comite) {
		this.id_comite = id_comite;
	}

	public String getNom_comite() {
		return nom_comite;
	}

	public void setNom_comite(String nom_comite) {
		this.nom_comite = nom_comite;
	}
	
	
	
}
