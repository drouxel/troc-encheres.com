package fr.eni.trocEncheres.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.trocEncheres.BusinessException;
import fr.eni.trocEncheres.bll.VenteManager;

/**
 * Servlet implementation class ServletDetailMaVente
 * @author Ludo
 */
@WebServlet("/ServletDetailMaVente")
public class ServletDetailMaVente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		VenteManager vMgr;
		try {
			vMgr = VenteManager.getInstance();
			int noVente = Integer.parseInt(request.getParameter("noVente"));
			if(noVente!=0) {
				request.setAttribute("vente", vMgr.getVenteById(noVente));
			}
		} catch (BusinessException e) {
			request.setAttribute("listeErreurs", e.getListeCodesErreur());
		}
		request.getRequestDispatcher("/WEB-INF/DetailMaVente.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
