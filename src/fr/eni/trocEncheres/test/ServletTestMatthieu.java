package fr.eni.trocEncheres.test;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.trocEncheres.bll.CategorieManager;
import fr.eni.trocEncheres.bll.UtilisateurManager;
import fr.eni.trocEncheres.bo.Categorie;
import fr.eni.trocEncheres.bo.Utilisateur;
import fr.eni.trocEncheres.dal.CategorieDAO;
import fr.eni.trocEncheres.dal.DAOFactory;
import fr.eni.trocEncheres.dal.UtilisateurDAO;

/**
 * Servlet implementation class ServletTestMatthieu
 */
@WebServlet("/ServletTestMatthieu")
public class ServletTestMatthieu extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CategorieDAO catdao = DAOFactory.getCategorieDAO();
		try {
			
			System.out.println("_____________________");
			System.out.println("ajout de categorie");
			Categorie test = catdao.ajouterCategorie(new Categorie("meuble"));
			System.out.println(test.toString());
			System.out.println("_____________________");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
