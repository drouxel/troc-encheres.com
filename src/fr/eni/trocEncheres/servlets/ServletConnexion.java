package fr.eni.trocEncheres.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.trocEncheres.BusinessException;
import fr.eni.trocEncheres.bll.UtilisateurManager;
import fr.eni.trocEncheres.bo.Utilisateur;
@WebServlet("/ServletConnexion")
/**
 * Servlet implementation class ServletConnexion
 */

public class ServletConnexion extends HttpServlet {
	private static final long serialVersionUID = 1L;  
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String forgotPwd = request.getParameter("forgotPwd");
		if(forgotPwd!=null) {
			System.out.println("c'est balot");
			request.setAttribute("forgotPwd", forgotPwd);
		}
		request.getRequestDispatcher("/WEB-INF/Connexion.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("login");
		String motDePasse = request.getParameter("motDePasse");
		String rememberMe = request.getParameter("rememberMe");
		UtilisateurManager.getInstance();
		UtilisateurManager uMgr = UtilisateurManager.getInstance();
		HttpSession session = request.getSession();
		Utilisateur utilisateurCourant = null;
		try {
			utilisateurCourant = uMgr.connecterUtilisateur(login, motDePasse);
		} catch (BusinessException e) {
			e.printStackTrace();
		}
		System.out.println(utilisateurCourant.toString());
		session.setAttribute("utilisateurCourant",utilisateurCourant);
		
		doGet(request, response);
	}

}
