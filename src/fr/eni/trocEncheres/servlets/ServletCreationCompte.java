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
		UtilisateurManager uMgr = UtilisateurManager.getInstance();
		Utilisateur utilisateurCourant = (Utilisateur) session.getAttribute("utilisateurCourant");
		
		if(request.getParameter("supprimer")!=null) {
			try {
				uMgr.supprimerUtilisateur(utilisateurCourant.getNoUtilisateur());
				request.setAttribute("deconnexion", "deconnexion");
				request.getRequestDispatcher("/ServletConnexion").forward(request, response);
			} catch (BusinessException e) {
				e.printStackTrace();
				request.setAttribute("utilisateurAAfficher", utilisateurCourant);
				request.setAttribute("listeErreurs", e.getListeCodesErreur());
				request.getRequestDispatcher("/WEB-INF/CreationCompte.jsp").forward(request, response);
			}
		}else if(request.getParameter("envoyer")!=null) {
			Utilisateur u = new Utilisateur();
			u.setPseudo((String) request.getAttribute("pseudo"));
			u.setNom((String) request.getAttribute("nom"));
			u.setPrenom((String) request.getAttribute("prenom"));
			u.setMail((String) request.getAttribute("email"));
			u.setTelephone((String) request.getAttribute("telephone"));
			u.setRue((String) request.getAttribute("rue"));
			u.setCodePostal((String) request.getAttribute("codePostal"));
			u.setVille((String) request.getAttribute("ville"));
			if(request.getAttribute("motDePasse").equals(request.getAttribute("confirmation"))) {
				u.setPseudo((String) request.getAttribute("motDePasse"));
				try {
					uMgr.ajouterUtilisateur(u);
					request.setAttribute("login", u.getPseudo());
					request.setAttribute("motDePasse", u.getMotDePasse());
					request.getRequestDispatcher("/ServletConnexion").forward(request, response);
				} catch (BusinessException e) {
					e.printStackTrace();
					request.setAttribute("utilisateurAAfficher", u);
					request.setAttribute("listeErreurs", e.getListeCodesErreur());
					request.getRequestDispatcher("/WEB-INF/CreationCompte.jsp").forward(request, response);
				}
			}else {
				BusinessException bExc = new BusinessException("les mots de passe doivent correspondre");
				request.setAttribute("listeErreurs", bExc.getListeCodesErreur());
				request.setAttribute("utilisateurAAfficher", u);
				request.getRequestDispatcher("/WEB-INF/CreationCompte.jsp").forward(request, response);
			}
			
		}else {
			String numeroUtilisateurAAfficher = request.getParameter("noUtilisateurAAfficher");
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
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
