package com.EnsiasSolvely.DAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;


import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import com.EnsiasSolvely.BeanForm.ProblemsBEAN;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

public class ReportingDAO {
	

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
		public static void getReporting(int numReporting, String path,HttpServletResponse response)  {

				JasperReport report = null;
				JasperDesign design = null;
				   
				ProblemsBEAN[] problems = new ProblemsBEAN[100];
				try {
					design = JRXmlLoader.load(path);
					Map<String, Object> parameters = new HashMap<String,Object>();
				   	connection = ConnectionFactory.getConnection();
				    report = JasperCompileManager.compileReport(design);
				   	byte[] byteStream = JasperRunManager.runReportToPdf(report, parameters, connection);
				   	ServletOutputStream outStream=response.getOutputStream();
				   	response.setContentType("application/pdf");
				   	response.setContentLength(byteStream.length);
				   	outStream.write(byteStream, 0 , byteStream.length);
					
				} catch (JRException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			   	

			}
		
		
}
