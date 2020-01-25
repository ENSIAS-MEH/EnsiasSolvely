package com.EnsiasSolvely.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

import com.EnsiasSolvely.BeanForm.EleveBEAN;

public class EleveDAO {
	

	// les attributs	
			private static Connection connection;
			private static Statement statement;
			private static PreparedStatement preparedStatement;
			private static String requette;

			
		public static EleveBEAN getEleveInformation(int numEleve)  {
			
				requette = "SELECT * FROM Eleve e, comite c  where e.id_comite = c.id_comite and e.numEleve = ?;";
				ResultSet resultat = null;
				EleveBEAN eleve = null;
				try {
						connection = ConnectionFactory.getConnection();
						preparedStatement = connection.prepareStatement(requette);
						preparedStatement.setInt(1, numEleve);
						resultat = preparedStatement.executeQuery();
						while(resultat.next() ){
							eleve = new EleveBEAN(resultat.getInt("numeleve"), resultat.getString("nom"), resultat.getString("prenom"), resultat.getString("email"), resultat.getInt("telephone"), resultat.getString("chambre"), resultat.getString("login"),
									resultat.getString("motdepasse"), resultat.getInt("id_comite"),resultat.getString("nom_comite"));
						}
					
						preparedStatement.close();
						resultat.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
				return eleve;
			}
		public static EleveBEAN getEleveInformation(String login, String motdepasse)  {
			requette = "SELECT * FROM Eleve e, Comite c where e.id_comite = c.id_comite and e.login = ? and e.motdepasse= ?;";
			ResultSet resultat = null;
			EleveBEAN eleve = null;
			try {
					connection = ConnectionFactory.getConnection();
					preparedStatement = connection.prepareStatement(requette);
					preparedStatement.setString(1, login);
					preparedStatement.setString(2, motdepasse);
					resultat = preparedStatement.executeQuery();
					while(resultat.next() ){
						eleve = new EleveBEAN(resultat.getInt("numeleve"), resultat.getString("nom"), resultat.getString("prenom"), resultat.getString("email"), resultat.getInt("telephone"), resultat.getString("chambre"), resultat.getString("login"),
								resultat.getString("motdepasse"), resultat.getInt("id_comite"),resultat.getString("nom_comite"));
					}
				
					preparedStatement.close();
					resultat.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			return eleve;
		}
		
		/*
		 * This function returns closed problems
		 */
		public static EleveBEAN[] getEleves()  {
			
			requette = "SELECT * FROM Eleve e, Comite c where e.id_comite = c.id_comite and e.chambre != 'null' order by e.nom DESC;";
			ResultSet resultat = null;
			EleveBEAN[] eleves = new EleveBEAN[100];
			try {
					connection = ConnectionFactory.getConnection();
					statement = connection.createStatement();
					resultat = statement.executeQuery(requette);
					int nombreLigne = 0;
					while(resultat.next() ){
						eleves[nombreLigne] = new EleveBEAN(resultat.getInt("numeleve"), resultat.getString("nom"), resultat.getString("prenom"), resultat.getString("email"), resultat.getInt("telephone"), resultat.getString("chambre"), resultat.getString("login"),
								resultat.getString("motdepasse"), resultat.getInt("id_comite"),resultat.getString("nom_comite"));
						System.out.println(eleves[nombreLigne].getChambre());
						nombreLigne++;
					}
				
					statement.close();
					resultat.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			return eleves;
		}
		
		public static void updateEleveInformation(int numEleve, int telephone, String email, String login, String motdepasse,String chambre,int id_comite)  {
			
			requette = "Update Eleve set email= ?,telephone=?,motdepasse=?,login=?,chambre=?, id_comite = ? where numEleve = ? ;";

			try {
					connection = ConnectionFactory.getConnection();
					preparedStatement = connection.prepareStatement(requette);
					
					
					preparedStatement.setString(1,email);
					preparedStatement.setInt(2, telephone);
					preparedStatement.setString(3,motdepasse);
					preparedStatement.setString(4,login);
					preparedStatement.setString(5,chambre);
					preparedStatement.setInt(6,id_comite);
					preparedStatement.setInt(7,numEleve);
					/*execution de la requette*/
					preparedStatement.executeUpdate();
				
					preparedStatement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		public static void insertEleve(String nom, String prenom, String email,
				int telephone, String chambre, String login, String motdepasse,
				int id_comite) {
			
			requette = "INSERT INTO Eleve(nom,prenom,email,telephone,chambre,login,motdepasse,id_comite) values(?,?,?,?,?,?,?,?);";

	        try {
				connection = ConnectionFactory.getConnection();
				preparedStatement = connection.prepareStatement(requette);
				preparedStatement.setString(1, nom);
				preparedStatement.setString(2, prenom);
				preparedStatement.setString(3, email);
				preparedStatement.setInt(4, telephone);
				preparedStatement.setString(5, chambre);
				preparedStatement.setString(6, login);
				preparedStatement.setString(7, motdepasse);
				preparedStatement.setInt(8, id_comite);
				preparedStatement.executeUpdate();
				preparedStatement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
		/*
		 * This function check if a student already exists
		 */
		public static int countEleve(String login) {

			requette = "SELECT * FROM Eleve WHERE login =?;";
			ResultSet resultat = null;
			int i=0;
			try {
				connection = ConnectionFactory.getConnection();
				preparedStatement = connection.prepareStatement(requette);
				preparedStatement.setString(1, login);;
				
				resultat = preparedStatement.executeQuery();
				
				while(resultat.next()) {
					i++;
				}
				
				preparedStatement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return i;
		}
}
