package fr.eni.trocEncheres.servlets;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.ParseInfo;

import fr.eni.trocEncheres.BusinessException;
import fr.eni.trocEncheres.bll.CategorieManager;
import fr.eni.trocEncheres.bll.UtilisateurManager;
import fr.eni.trocEncheres.bll.VenteManager;
import fr.eni.trocEncheres.bo.Categorie;
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
		UtilisateurManager uMgr = UtilisateurManager.getInstance();
		Utilisateur utilisateurCourant = (Utilisateur) session.getAttribute("utilisateurCourant");
		
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
		

		
		if(request.getParameter("publier")!=null) {
			CategorieManager catmgr = CategorieManager.getInstance();
			Vente v = new Vente();
			Retrait r = new Retrait();
			VenteManager vMgr = new VenteManager();
			DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			LocalDate date = LocalDate.parse(request.getParameter("finEnchere"));
			v.setNomArticle(request.getParameter("article"));
			try {
				v.setCategorie(catmgr.getCategorieById(Integer.parseInt(request.getParameter("categorie"))));				
			} catch (BusinessException e) {
				request.setAttribute("listeErreurs", e.getListeCodesErreur());			}
			v.setDescription(request.getParameter("description"));
			v.setVendeur(utilisateurCourant);
			v.setMiseAPrix((Integer.parseInt(request.getParameter("enchere"))) );
			v.setDateFinEnchere(date);
			r.setRue(request.getParameter("rue"));
			r.setCodePostal(request.getParameter("codePostal"));
			r.setVille(request.getParameter("ville"));
			v.setRetrait(r);
			try {
				vMgr.ajouterVente(v);
				request.setAttribute("article", v.getNomArticle());
				request.setAttribute("description", v.getDescription());
				request.setAttribute("enchere", v.getMiseAPrix());
				request.setAttribute("finEnchere", v.getDateFinEnchere());
				request.setAttribute("rue", r.getRue());
				request.setAttribute("codePostal", r.getCodePostal());
				request.setAttribute("ville", r.getVille());
			} catch (BusinessException e) {
				e.printStackTrace();
			}
		}else {
			System.out.println("coucou");
		}
		CategorieManager cMgr;
		cMgr = CategorieManager.getInstance();
		List<Categorie> categories;
		try {
			categories = cMgr.getCategories();
			request.setAttribute("categories", categories);
		} catch (BusinessException e) {
			e.printStackTrace();
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

	
	






	