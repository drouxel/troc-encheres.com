package fr.eni.trocEncheres.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.trocEncheres.BusinessException;
import fr.eni.trocEncheres.bll.CategorieManager;
import fr.eni.trocEncheres.bll.EnchereManager;
import fr.eni.trocEncheres.bo.Categorie;
import fr.eni.trocEncheres.bo.Enchere;

/**
 * Servlet implementation class ServletAccueilUtilisateur
 * @author damien
 */
@WebServlet("/ServletListeEncheres")
public class ServletListeEncheres extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CategorieManager cMgr;
		EnchereManager eMgr;
		try {
			cMgr = CategorieManager.getInstance();
			List<Categorie> categories = cMgr.getCategories();
			for (Categorie categorie : categories) {
			}
			request.setAttribute("categories", categories);
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			eMgr = EnchereManager.getInstance();
			List<Enchere> annonces = eMgr.getEncheres();
			request.setAttribute("annonces", annonces);
		} catch (BusinessException e) {
			List<String> listeErreurs = e.getListeCodesErreur();
			request.setAttribute("listeErreurs", listeErreurs);
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("/WEB-INF/ListeEncheres.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
