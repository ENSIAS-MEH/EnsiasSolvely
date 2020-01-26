package com.EnsiasSolvely.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.EnsiasSolvely.BeanForm.ProblemsBEAN;

public class ProblemsDAO {
	
	/*
	 * Thoses are the attributes of Problems DAO	
	 */
	private static Connection connection;
	private static Statement statement;
	private static PreparedStatement preparedStatement;
	private static String requette;
			
	
			
		/*
		 * This function returns Actif problems
		 */
		public static ProblemsBEAN[] getActifProblems(int id_comite)  {
				String conditionComite = "1 and 6";
				if(id_comite==1) {
					conditionComite = "1 and 3";
				}else {
					conditionComite = "4 and 6";
				}
				requette = "SELECT * FROM Probleme p, Comite c, Eleve e, Type_Probleme t where p.numEleve = e.numEleve and c.id_comite = p.id_comite and p.id_type = t.id_type and p.statut= 'Actif' and p.id_type between "+conditionComite+" order by p.id_probleme DESC;";
				ResultSet resultat = null;
				ProblemsBEAN[] problems = new ProblemsBEAN[100];
				try {
						connection = ConnectionFactory.getConnection();
						statement = connection.createStatement();
						resultat = statement.executeQuery(requette);
						int nombreLigne = 0;
						while(resultat.next() ){
							problems[nombreLigne] = new ProblemsBEAN(resultat.getInt("id_probleme"), resultat.getString("lieu"), resultat.getString("description"), resultat.getDate("date_demande"), resultat.getString("statut"), resultat.getString("nom"),
									resultat.getString("prenom"), resultat.getString("nom_comite"), resultat.getString("libelle_type"));
							System.out.println(problems[nombreLigne].getDescription());
							nombreLigne++;
						}
					
						statement.close();
						resultat.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
				return problems;
			}
		/*
		 * This function returns closed problems
		 */
		public static ProblemsBEAN[] getFinalProblems()  {
			
			requette = "SELECT * FROM Probleme p, Comite c, Eleve e, Type_Probleme t where p.numEleve = e.numEleve and c.id_comite = p.id_comite and p.id_type = t.id_type and p.statut != 'Actif' order by p.id_probleme DESC;";
			ResultSet resultat = null;
			ProblemsBEAN[] problems = new ProblemsBEAN[100];
			try {
					connection = ConnectionFactory.getConnection();
					statement = connection.createStatement();
					resultat = statement.executeQuery(requette);
					int nombreLigne = 0;
					while(resultat.next() ){
						problems[nombreLigne] = new ProblemsBEAN(resultat.getInt("id_probleme"), resultat.getString("lieu"), resultat.getString("description"), resultat.getDate("date_demande"), resultat.getString("statut"), resultat.getString("nom"),
								resultat.getString("prenom"), resultat.getString("nom_comite"), resultat.getString("libelle_type"));
						nombreLigne++;
					}
				
					statement.close();
					resultat.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			return problems;
		}
		
		/*
		 * This function returns closed problems
		 */
		public static ProblemsBEAN[] getEleveProblems(int numEleve)  {
			
			requette = "SELECT * FROM Probleme p, Comite c, Eleve e, Type_Probleme t where p.numEleve = e.numEleve and c.id_comite = p.id_comite and p.id_type = t.id_type and e.numEleve = ? order by p.id_probleme DESC;";
			ResultSet resultat = null;
			ProblemsBEAN[] problems = new ProblemsBEAN[100];
			try {
					connection = ConnectionFactory.getConnection();
					preparedStatement = connection.prepareStatement(requette);
					preparedStatement.setInt(1, numEleve);
					resultat = preparedStatement.executeQuery();
					int nombreLigne = 0;
					while(resultat.next() ){
						problems[nombreLigne] = new ProblemsBEAN(resultat.getInt("id_probleme"), resultat.getString("lieu"), resultat.getString("description"), resultat.getDate("date_demande"), resultat.getString("statut"), resultat.getString("nom"),
								resultat.getString("prenom"), resultat.getString("nom_comite"), resultat.getString("libelle_type"));
						nombreLigne++;
					}
				
					statement.close();
					resultat.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			return problems;
		}

		/*
		 * This function returns statut of a specific problem
		 */
		public static String getStatut(int id_problem){
			String statut = null;
			ResultSet resultat = null;
			connection = ConnectionFactory.getConnection();
			requette = "SELECT statut FROM Probleme p where p.id_probleme = ?;";
			try {
				preparedStatement = connection.prepareStatement(requette);
				preparedStatement.setInt(1, id_problem);
				
				resultat = preparedStatement.executeQuery();
				
				while(resultat.next()) {
					statut = resultat.getString("statut");
				}
				preparedStatement.close();
				resultat.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return statut;
		}

		/*
		 * This function execute an update of the statut of a specific problem
		 */
		public static void changeStatut(int id_problem, String statut_decision){
			requette = "update Probleme set statut = ?   where id_probleme = ?;";

			try {
				connection = ConnectionFactory.getConnection();
				preparedStatement = connection.prepareStatement(requette);
				preparedStatement.setString(1, statut_decision);
				preparedStatement.setInt(2, id_problem);
				
				preparedStatement.executeUpdate();
				
				preparedStatement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		/*
		 * This function is clear
		 */
		public static void insertProblem(String lieu, String description, String date_demande, String statut,
				int id_comite, int numEleve, int id_type) {

	        requette = "INSERT INTO probleme(lieu, description, date_demande, statut, id_comite, numEleve, id_type) values(?,?,?,?,?,?,?);";

	        try {
				connection = ConnectionFactory.getConnection();
				preparedStatement = connection.prepareStatement(requette);
				preparedStatement.setString(1, lieu);
				preparedStatement.setString(2, description);
				preparedStatement.setString(3, date_demande);
				preparedStatement.setString(4, statut);
				preparedStatement.setInt(5, id_comite);
				preparedStatement.setInt(6, numEleve);
				preparedStatement.setInt(7, id_type);
				
				
				preparedStatement.executeUpdate();
				
				preparedStatement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}


}
