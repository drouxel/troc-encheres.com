package fr.eni.trocEncheres.servlets;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.ParseInfo;

import fr.eni.trocEncheres.BusinessException;
import fr.eni.trocEncheres.bll.UtilisateurManager;
import fr.eni.trocEncheres.bll.VenteManager;
import fr.eni.trocEncheres.bo.Retrait;
import fr.eni.trocEncheres.bo.Utilisateur;
import fr.eni.trocEncheres.bo.Vente;


/**
 * Servlet implementation class ServletVendreUnArticle
 * @author Ludo servlet
 * @author Matthieu algo
 */
@WebServlet("/ServletVendreUnArticle")
public class ServletVendreUnArticle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String nomArcticle = null;
		String description = null;
		String miseAPrix = null;
		LocalDateTime dateFinEnchere = null;
		String rue = null;
		String codePostal = null;
		String ville = null; 
		
		if(request.getParameter("deconnexion")!=null) {
			session.removeAttribute("utilisateurCourant");
		}
		
		if (nomArcticle == null ||
			description == null ||
			miseAPrix == null ||
			dateFinEnchere == null ||
			rue == null ||
			codePostal == null ||
			ville == null) {
			nomArcticle = request.getParameter("article");
			description = request.getParameter("description");
			miseAPrix = request.getParameter("enchere");
//			dateFinEnchere = request.getParameter("finEnchere");
			rue = request.getParameter("rue");
			codePostal = request.getParameter("codePostal");
			ville = request.getParameter("ville");
		}
		
//		if (nomArcticle != null ||
//			description != null ||
//			miseAPrix != null ||
//			dateFinEnchere != null ||
//			rue != null ||
//			codePostal != null ||
//			ville != null){
//			VenteManager.getInstance();
//			VenteManager vMgr = VenteManager.getInstance();
//			Vente vente = null;
//			try {
//				vente = vMgr.
//			} catch (BusinessException e) {
//				e.printStackTrace();
//				request.getRequestDispatcher("/WEB-INF/VendreUnArticle.jsp").forward(request, response);
//			}
//		}
		
		if(request.getParameter("publier")!=null) {
			Vente v = new Vente();
			v.setNomArticle((String) request.getParameter("article"));
			v.setDescription((String) request.getParameter("description"));
			v.setMiseAPrix((Integer.parseInt(request.getParameter("enchere"))) );
			v.setDateFinEnchere((Date) request.getParameter("finEnchere"));
		}
		
		request.getRequestDispatcher("/WEB-INF/VendreUnArticle.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
				
		doGet(request, response);
	}

}

	
	






	