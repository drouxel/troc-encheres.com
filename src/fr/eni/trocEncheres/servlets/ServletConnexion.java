package fr.eni.trocEncheres.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
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
 * @author damien
 */

public class ServletConnexion extends HttpServlet {
	private static final long serialVersionUID = 1L;  
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String login=null;
		String motDePasse=null;
		if(request.getParameter("deconnexion")!=null) {
			session.removeAttribute("utilisateurCourant");
		}
		Cookie[] cookies = request.getCookies();
		if(cookies != null) {
			for (Cookie cookie : cookies) {
				if(cookie.getName().equalsIgnoreCase("login")) {
					if(request.getParameter("deconnexion")!=null) {
						cookie.setMaxAge(0);
					}else {
						login = cookie.getValue();
					}
				}
				if(cookie.getName().equalsIgnoreCase("motDePasse")) {
					if(request.getParameter("deconnexion")!=null) {
						cookie.setMaxAge(0);
					}else {
						motDePasse = cookie.getValue();
					}
				}
			}
		}
		if(login==null||motDePasse==null) {
			login = request.getParameter("login");
			motDePasse = request.getParameter("motDePasse");
		}
		if(login==null||motDePasse==null) {
			login = (String)request.getAttribute("login");
			motDePasse = (String)request.getAttribute("motDePasse");
		}
		if(login!=null||motDePasse!=null) {
			UtilisateurManager.getInstance();
			UtilisateurManager uMgr = UtilisateurManager.getInstance();
			Utilisateur utilisateurCourant = null;
			try {
				utilisateurCourant = uMgr.connecterUtilisateur(login, motDePasse);
			} catch (BusinessException e) {
				e.printStackTrace();
				request.getRequestDispatcher("/WEB-INF/Connexion.jsp").forward(request, response);
			}
			session.setAttribute("utilisateurCourant",utilisateurCourant);
			String rememberMe = request.getParameter("rememberMe");
			if(rememberMe!=null) {
				Cookie cookieSaveLogin = new Cookie("login", login);
				Cookie cookieSavePwd = new Cookie("motDePasse", motDePasse);
				response.addCookie(cookieSaveLogin);
				response.addCookie(cookieSavePwd);
			}
			request.getRequestDispatcher("/ServletListeEncheres").forward(request, response);
		}else {
			String forgotPwd = request.getParameter("forgotPwd");
			if(forgotPwd!=null) {
				System.out.println("c'est balot");
				request.setAttribute("forgotPwd", forgotPwd);
			}
			request.getRequestDispatcher("/WEB-INF/Connexion.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
