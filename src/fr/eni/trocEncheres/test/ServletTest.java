package fr.eni.trocEncheres.test;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.trocEncheres.BusinessException;
import fr.eni.trocEncheres.bo.Categorie;
import fr.eni.trocEncheres.bo.Retrait;
import fr.eni.trocEncheres.bo.Utilisateur;
import fr.eni.trocEncheres.dal.CategorieDAO;
import fr.eni.trocEncheres.dal.DAOFactory;
import fr.eni.trocEncheres.dal.RetraitDAO;
import fr.eni.trocEncheres.dal.UtilisateurDAO;

/**
 * Servlet implementation class ServletTest
 */
@WebServlet("/ServletTest")
public class ServletTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UtilisateurDAO user = DAOFactory.getUtilisateurDAO();
		try {
			System.out.println("test ajout");
			System.out.println("----------------------------------------------------");
			Utilisateur test =
					user.ajouterUtilisateur(new Utilisateur
							("kiki", "Labite", "kiki.labite@mail.ru", "0769753645", "place pigalle", "75000", "Paris", 
									"labiteaucul", 0, "Jean-Michel", false));
			System.out.println(test.toString());
			System.out.println("----------------------------------------------------");
			
//			System.out.println("test modification");
//			System.out.println("----------------------------------------------------");
//			test.setRue("rue saint michel");
//			test.setCodePostal("35000");
//			test.setVille("rennes");
//			user.modifierUtilisateur(test);
//			System.out.println(test.toString());
//			System.out.println("----------------------------------------------------");
//			
//			System.out.println("test gestion");
//			System.out.println("----------------------------------------------------");
//			test.setPseudo("retourneveste");
//			test.setNom("De Lamite");
//			test.setPrenom("Charles-Edouard");
//			test.setMail("cedelamite@gmail.com");
//			test.setMotDePasse("toutestclean");
//			test.setTelephone(null);
//			user.gererUtilisateur(test);
//			System.out.println(test.toString());
//			System.out.println("----------------------------------------------------");
//			
//			System.out.println("test suppression");
//			System.out.println("----------------------------------------------------");
//			user.supprimerUtilisateur(2);
//			
//			System.out.println("test login");
//			System.out.println("----------------------------------------------------");
//			System.out.println(user.getUtilisateur(7).toString());
			
//			
//			System.out.println("tests categories");
//			System.out.println("----------------------------------------------------");
//			Categorie info = new Categorie("Informatique");
//			Categorie brico = new Categorie("Bricolage");
//			Categorie mobilier = new Categorie("Mobilier");
//			Categorie sport = new Categorie("Sport");
//			Categorie electro = new Categorie("Electro-ménager");
//			
//			CategorieDAO cdao = DAOFactory.getCategorieDAO();
//			cdao.ajouterCategorie(mobilier);
//			cdao.ajouterCategorie(brico);
//			cdao.ajouterCategorie(sport);
//			cdao.ajouterCategorie(electro);
//			Categorie test2 = cdao.getCategorieById(2);
//			System.out.println(test2.getLibelle().toString());
//			List<Categorie> lcdao = cdao.getCategories();
//			for (Categorie categorie : lcdao) {
//				System.out.println(categorie.getLibelle().toString());
//			}
//			cdao.supprimerCategorie(3);
//			for (Categorie categorie : lcdao) {
//				System.out.println(categorie.getLibelle().toString());
//			}
			
			System.out.println("tests retraits");
			System.out.println("----------------------------------------------------");
			
			Retrait r = null;
			RetraitDAO rdao = DAOFactory.getRetraitDAO();
			r = rdao.getAdresseUtilisateur(test.getNoUtilisateur());
			
			System.out.println(r.toString());
			
			r.setNoVente(1);
			
			System.out.println("test ajout retrait");
			System.out.println("-----------------------------------------------------");
			
			rdao.ajouterRetrait(r);
			
			Retrait r2 = rdao.getRetrait(1);
			
			System.out.println("test récupération retrait");
			System.out.println("-----------------------------------------------------");
			System.out.println(r2.toString());
			
		} catch (BusinessException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
