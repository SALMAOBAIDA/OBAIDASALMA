package service;

import java.sql.SQLException;
import java.util.ArrayList;

import dao.daoLivre;
import dao.daoPersonne;
import models.Livre;
import models.Personne;

public class serviceLivre {

public static ArrayList<Livre> listeLivres() throws ClassNotFoundException, SQLException {
		
		return daoLivre.listeLivres();
	}

public static boolean AjouterLivre(Livre l) throws ClassNotFoundException, SQLException {
	boolean exist = daoLivre.LivreExiste(l.getIsbn());
	if(exist) {
		return false;
	}else {
		int res = daoLivre.AjouterLivre(l);
		return res == 1;
	}
}
	
}
