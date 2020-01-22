package com.EnsiasSolvely.formulaires;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class database {
	private ResultSet rs = null;
	private Connection con = null;
	private Statement prepared = null ;
	private PreparedStatement pp = null;
	
	public database() {
		super();
	}
	public Connection con() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ensiassolvely?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;  
	}
	public ResultSet CreateStat(String requette ) throws ClassNotFoundException {
		try {
			con();
			prepared = con.createStatement();
			rs = prepared.executeQuery(requette);
	}catch(SQLException e) {
		JOptionPane.showMessageDialog(null,e);
	}
		return rs;
		

}
	public PreparedStatement updateStat(String requette) throws ClassNotFoundException {
		try {
			con();
			pp = con.prepareStatement(requette);			
			pp.executeUpdate();
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
}
		return pp;
	}
	public void closestat() {
		try {
			prepared.close();
			rs.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void closeupdate() {
		try {
			pp.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

