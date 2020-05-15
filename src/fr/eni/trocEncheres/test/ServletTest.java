package fr.eni.trocEncheres.test;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.trocEncheres.BusinessException;
import fr.eni.trocEncheres.bo.Enchere;
import fr.eni.trocEncheres.bo.Utilisateur;
import fr.eni.trocEncheres.bo.Vente;
import fr.eni.trocEncheres.dal.CategorieDAO;
import fr.eni.trocEncheres.dal.DAOFactory;
import fr.eni.trocEncheres.dal.EnchereDAO;
import fr.eni.trocEncheres.dal.RetraitDAO;
import fr.eni.trocEncheres.dal.UtilisateurDAO;
import fr.eni.trocEncheres.dal.VenteDAO;

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
//			System.out.println("test ajout");
//			System.out.println("----------------------------------------------------");
//			Utilisateur test =
//					user.ajouterUtilisateur(new Utilisateur
//							("kiki", "Labite", "kiki.labite@mail.ru", "0769753645", "place pigalle", "75000", "Paris", 
//									"labiteaucul", 0, "Jean-Michel", false));
//			System.out.println(test.toString());
//			System.out.println("----------------------------------------------------");
//			
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
			CategorieDAO cdao = DAOFactory.getCategorieDAO();
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
//			
//			System.out.println("tests retraits");
//			System.out.println("----------------------------------------------------");
//			
//			Retrait r = null;
			RetraitDAO rdao = DAOFactory.getRetraitDAO();
//			r = rdao.getAdresseUtilisateur(test.getNoUtilisateur());
//			
//			System.out.println(r.toString());
//			
//			r.setNoVente(1);
//			
//			System.out.println("test ajout retrait");
//			System.out.println("-----------------------------------------------------");
//			
//			rdao.ajouterRetrait(r);
//			
//			Retrait r2 = rdao.getRetrait(1);
//			
//			System.out.println("test récupération retrait");
//			System.out.println("-----------------------------------------------------");
//			System.out.println(r2.toString());

//			System.out.println("Test Ajout Vente");
//			System.out.println("------------------------------------------------------");
//			Utilisateur u = user.getUtilisateur(1);
//			Vente v = new Vente();
//			v.setNomArticle("pc bureautique");
//			v.setDescription("un truc pas terrible avec windows Vista");
//			v.setDateFinEnchere(LocalDate.of(2020, 06, 06));
//			v.setMiseAPrix(20);
//			v.setVendeur(u);
//			v.setCategorie(cdao.getCategorieById(1));
//			v.setRetrait(rdao.getAdresseUtilisateur(u.getNoUtilisateur()));
			VenteDAO vdao = DAOFactory.getVenteDAO();
//			Vente v2 = vdao.ajouterVente(v);
//			System.out.println(v.toString());
//			System.out.println("------------------------------------------------------");
			
//			System.out.println("Test Ventes by utilisateur");
//			System.out.println("------------------------------------------------------");
//			List<Vente> ventesByUser = vdao.getVentesUtilisateur(1);
//			for (Vente vente : ventesByUser) {
//				System.out.println(vente.toString());
//				System.out.println("------------------------------------------------------");
//			}
//			
//			System.out.println("------------------------------------------------------");
//			System.out.println("Test Ventes by nom");
//			System.out.println("------------------------------------------------------");
//			List<Vente> ventesByNom = vdao.getVentesByNom("bur");
//			for (Vente vente : ventesByNom) {
//				System.out.println(vente.toString());
//				System.out.println("------------------------------------------------------");
//			}
//			
//			System.out.println("------------------------------------------------------");
//			System.out.println("Test Ventes by categorie");
//			System.out.println("------------------------------------------------------");
//			List<Vente> ventesByCategorie = vdao.getVentesByCategorie(1);
//			for (Vente vente : ventesByCategorie) {
//				System.out.println(vente.toString());
//				System.out.println("------------------------------------------------------");
//			}
//			
//			System.out.println("------------------------------------------------------");
//			System.out.println("Test Vente");
//			System.out.println("------------------------------------------------------");
//			Vente v = vdao.getVente(2);
//			System.out.println(v.toString());
//			System.out.println("------------------------------------------------------");
//			
//			System.out.println("------------------------------------------------------");
//			System.out.println("Test Ventes ");
//			System.out.println("------------------------------------------------------");
//			List<Vente> ventes = vdao.getVentes();
//			for (Vente vente : ventes) {
//				System.out.println(vente.toString());
//				System.out.println("------------------------------------------------------");
//			}
//			
//			System.out.println("------------------------------------------------------");
//			System.out.println("Test Vente");
//			System.out.println("------------------------------------------------------");
//			Enchere e = new Enchere();
//			e.setDateEnchere(LocalDate.now());
//			e.setEncherisseur(user.getUtilisateur(2));
//			e.setVente(vdao.getVente(3));
//			e.setCredit(80);
//			EnchereDAO edao = DAOFactory.getEnchereDAO();
//			edao.ajouterEnchere(e);
//			System.out.println(e.toString());
//			System.out.println("--------------------------------------------------------");
//			System.out.println("mise à jour enchere");
//			System.out.println("--------------------------------------------------------");
//			
//			System.out.println("--------------------------------------------------------");
//			System.out.println("récupération liste Encheres");
//			System.out.println("--------------------------------------------------------");
//			List<Enchere> encheres = edao.getEncheres(3);
//			for (Enchere enchere : encheres) {
//				System.out.println(enchere.toString());
//				System.out.println("--------------------------------------------------------");
//			}
//			
//			System.out.println("--------------------------------------------------------");
//			System.out.println("Suppression enchere");
//			System.out.println("--------------------------------------------------------");
//			edao.supprimerEnchere(e);
//			encheres = edao.getEncheres(3);
//			System.out.println("il ne doit rien s'afficher entre ici...");
//			for (Enchere enchere : encheres) {
//				System.out.println(enchere.toString());
//				System.out.println("--------------------------------------------------------");
//			}
			
//			System.out.println("--------------------------------------------------------");
//			System.out.println("Suppression vente");
//			System.out.println("--------------------------------------------------------");
//			edao.supprimerEncheres(3);
//			for (Enchere enchere : encheres) {
//				System.out.println(enchere.toString());
//				System.out.println("--------------------------------------------------------");
//			}
			System.out.println("test getPseudos");
			List<String> pseudos = user.getPseudos();
			for (String string : pseudos) {
				System.out.println(string);
			}
			System.out.println("test getMails");
			List<String> mails = user.getMails();
			for (String string : mails) {
				System.out.println(string);
			}
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
