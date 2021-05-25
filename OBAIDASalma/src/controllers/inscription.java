package controllers;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Personne;
import service.servicePersonne;


@SuppressWarnings("serial")
@WebServlet("/inscription")
public class inscription extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/inscription.jsp").include(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean res = false;
		Personne p = new Personne(request.getParameter("nom"), request.getParameter("prenom"), request.getParameter("login"), request.getParameter("password"), null);
		 try {
			res = service.servicePersonne.AjouterPersonne(p);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		if(res) {
	
			response.sendRedirect("http://localhost:8080/OBAIDASalma/authentification.jsp");
		}else {
			response.sendRedirect("http://localhost:8080/OBAIDASalma/inscription.jsp");
		}
	}

}