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

/**
 * Servlet implementation class ServletCreationCompte
 * @author damien
 */
@WebServlet("/ServletCreationCompte")
public class ServletCreationCompte extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String numeroUtilisateurAAfficher = request.getParameter("noUtilisateurAAfficher");
		UtilisateurManager uMgr = UtilisateurManager.getInstance();
		Utilisateur utilisateurCourant = (Utilisateur) session.getAttribute("utilisateurCourant");
		Utilisateur utilisateurAAfficher = null;
		int noUtilisateurAAfficher = 0;
		try {
			if(numeroUtilisateurAAfficher != null) {
				noUtilisateurAAfficher = Integer.parseInt(numeroUtilisateurAAfficher);
				utilisateurAAfficher = uMgr.getUtilisateurById(noUtilisateurAAfficher);
			}
		} catch (BusinessException e) {
			request.setAttribute("listeErreurs", e.getListeCodesErreur()); 
			e.printStackTrace();
		}
		if(utilisateurCourant!=null) {
			if(utilisateurCourant.getNoUtilisateur()==noUtilisateurAAfficher) {
				request.setAttribute("self", "self");
			}else {
				request.setAttribute("readonly", "readonly");
				request.setAttribute("plaintext", "-plaintext");
				request.setAttribute("other", "other");
			}
		}
		request.setAttribute("utilisateurAAfficher", utilisateurAAfficher);
		request.getRequestDispatcher("/WEB-INF/CreationCompte.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
