package fr.eni.trocEncheres.servlets;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.trocEncheres.BusinessException;
import fr.eni.trocEncheres.bll.VenteManager;
import fr.eni.trocEncheres.bo.Retrait;
import fr.eni.trocEncheres.bo.Utilisateur;
import fr.eni.trocEncheres.bo.Vente;
import fr.eni.trocEncheres.dal.VenteDAO;


/**
 * Servlet implementation class ServletVendreUnArticle
 */
@WebServlet("/ServletVendreUnArticle")
public class ServletVendreUnArticle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/WEB-INF/VendreUnArticle.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Récupérer l'utilisateur en session qui est le vendeur
		HttpSession session = request.getSession();
		Utilisateur vendeur = (Utilisateur) session.getAttribute("utilisateur");
		
		// Récupération des données du formulaire
		String nomArticle = request.getParameter("article").trim();
		String description = request.getParameter("description").trim();
		String dateFinEncheresStr = request.getParameter("finEnchere");
		int noArticle;
		
		// Initialisation variables
		LocalDateTime dateFinEncheres = null;
		int prixInitial = 0;
		
		try {
			VenteManager artMger = new VenteManager();
			BusinessException be = new BusinessException();
			
		//Conversion pour la date
		try {
			DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
			dateFinEncheres = LocalDateTime.parse(dateFinEncheresStr, formatter);
		} catch (DateTimeParseException e) {
			e.printStackTrace();
			request.setAttribute("error", "Erreur de saisie dans les données Date de début et/ou fin enchère");
		}
		
		//Conversion pour les entiers
		try {
			prixInitial = Integer.parseInt(request.getParameter("prixInitial").trim());
		} catch (NumberFormatException e) {
			e.printStackTrace();
			request.setAttribute("error", "Erreur de saisie dans les données de type numérique");
		}
		
		// récupere les 3 champs de RETRAIT, puis construction des objets
			String rue = request.getParameter("rue").trim();
			String codePostal = request.getParameter("codePostal").trim();
			String ville = request.getParameter("ville").trim();
			Retrait retrait = new Retrait(rue, codePostal, ville);
			Vente art = new Vente(nomArticle, description, dateFinEncheres, prixInitial, vendeur);
		
		doGet(request, response);
	}

}

	
	
	