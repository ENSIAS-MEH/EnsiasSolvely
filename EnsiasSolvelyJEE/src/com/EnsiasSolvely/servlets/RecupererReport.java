package com.EnsiasSolvely.servlets;

import java.io.IOException;
import java.sql.DriverManager;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.EnsiasSolvely.DAO.ReportingDAO;
import com.mysql.jdbc.Connection;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

/**
 * Servlet implementation class RecupererReport
 */
@WebServlet("/RecupererReport")
public class RecupererReport extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RecupererReport() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int reporting = -1;
		String path=null;
		String imgPath= getServletContext().getRealPath("/images/ensias.png");;
		if(request.getParameter("reporting")!=null) {
			reporting = Integer.parseInt(request.getParameter("reporting"));
		}
		if(reporting!=-1) {
			switch(reporting) {
			case 1:
				path=getServletContext().getRealPath("/EtudiantListe.jrxml");
				break;
			
			case 2:
				path=getServletContext().getRealPath("/EtudiantQR.jrxml");
				break;
		
			case 3:
				path=getServletContext().getRealPath("/ProblemeListe.jrxml");
				break;
			case 4:
				path=getServletContext().getRealPath("/StatistiqueBatiment.jrxml");
				break;
			
			case 5:
				path=getServletContext().getRealPath("/StatistiqueComite.jrxml");
				break;
		
			case 6:
				path=getServletContext().getRealPath("/StatistiqueDivers.jrxml");
				break;
			case 7:
				path=getServletContext().getRealPath("/StatistiqueGlobale1.jrxml");
				break;
	
		}
		}
		   
		ReportingDAO.getReporting(reporting, path, imgPath,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	
	
		
	}