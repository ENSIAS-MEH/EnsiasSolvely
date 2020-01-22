package com.EnsiasSolvely.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.EnsiasSolvely.formulaires.EleveBEAN;
import com.EnsiasSolvely.formulaires.database;

public class EleveDAO {
	

	// les attributs	
			private static Connection connexion;
			private static Statement statement;
			private static PreparedStatement preparedStatement;
			private static String requette;

			
		public static EleveBEAN getEleveInformation(int numEleve)  {
			
				requette = "SELECT * FROM Eleve e where e.numEleve = ?;";
				ResultSet resultat = null;
				EleveBEAN eleve = null;
				try {
						connexion = (new database()).con();
						preparedStatement = connexion.prepareStatement(requette);
						preparedStatement.setInt(1, numEleve);
						resultat = preparedStatement.executeQuery();
						while(resultat.next() ){
							eleve = new EleveBEAN(resultat.getInt("numeleve"), resultat.getString("nom"), resultat.getString("prenom"), resultat.getString("email"), resultat.getInt("telephone"), resultat.getString("chambre"), resultat.getString("login"),
									resultat.getString("motdepasse"), resultat.getInt("id_comite"));
						}
					
						preparedStatement.close();
						resultat.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
				return eleve;
			}
					public static void updateEleveInformation(int numEleve, int telephone, String email, String login, String motdepasse,String chambre)  {
			
							requette = "Update Eleve set email= ?,telephone=?,motdepasse=?,login=?,chambre=? where numEleve = ? ;";

							try {
					
								connexion = (new database()).con();
								preparedStatement = connexion.prepareStatement(requette);
								
								preparedStatement.setString(1,email);
								preparedStatement.setInt(2, telephone);
								preparedStatement.setString(3,motdepasse);
								preparedStatement.setString(4,login);
								preparedStatement.setString(5,chambre);
								preparedStatement.setInt(6,numEleve);
								/*execution de la requette*/
								preparedStatement.executeUpdate();
								preparedStatement.close();
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
					}
					}
