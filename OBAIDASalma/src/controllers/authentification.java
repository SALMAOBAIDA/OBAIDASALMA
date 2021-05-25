package controllers;



import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Personne;
import models.Role;



@SuppressWarnings("serial")
@WebServlet("/authentification")
public class authentification extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		this.getServletContext().getRequestDispatcher("/authentification.jsp").include(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		PrintWriter out=response.getWriter();
		String login=request.getParameter("login");
		String password=request.getParameter("password");
	    Personne p=null;
		 try {
			 p=service.servicePersonne.Authentification(login, password);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		if(p==null) {
			response.sendRedirect("http://localhost:8080/OBAIDASalma/inscription.jsp");
			
		}else {
			HttpSession session=request.getSession();
			session.setAttribute("personne", p);
			if(p.getRole().equals(Role.ADMIN)) {
				response.sendRedirect("http://localhost:8080/OBAIDASalma/Admin.jsp");
			}else {
				response.sendRedirect("http://localhost:8080/OBAIDASalma/Etudiant.jsp");
			}
		}
	}

}