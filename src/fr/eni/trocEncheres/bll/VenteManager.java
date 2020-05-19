package fr.eni.trocEncheres.bll;

import fr.eni.trocEncheres.BusinessException;
import fr.eni.trocEncheres.bo.Vente;
import fr.eni.trocEncheres.dal.DAOFactory;
import fr.eni.trocEncheres.dal.VenteDAO;

/**
 * @author MATTHIEU
 *Ajouter une vente
 *@author Ludo -> gestion des exceptions
 */
public class VenteManager {
	
		//singleton
			private static VenteManager instance;
			
			public static VenteManager getInstance()throws BusinessException {
				if(instance == null) {
					instance = new VenteManager();
				}
				return instance;
			}
		
		//Attribut(s)
			VenteDAO daoVente = DAOFactory.getVenteDAO();
			
			/**
			 * Constructeur par defaut
			 */
			public VenteManager() {
				super();
			}
			
			/**
			 * Ajoute une vente en fonction des critères contenue dans 'verificationsVente'
			 * @param v
			 * @throws BusinessException
			 */
			public void ajouterVente(Vente v) throws BusinessException { //à changer par code d'erreurs
				Boolean isValide = true;
				verificationsVente(v);
				try {
					if (isValide) {
						// Ajoute la vente si 'isValide' est 'true'
						daoVente.ajouterVente(v);
					}else {
						throw new BusinessException("erreur");
					}
				} catch (BusinessException e) {
					throw new BusinessException("L'ajout de la vente à échouée");
				}
			}

			/**
			 * Verifie différents paramètres pour déterminer si une vente est valide.
			 * @param v
			 * @throws BusinessException
			 */
			private boolean verificationsVente(Vente v) throws BusinessException {
				boolean isValide = true;
				if (v == null) {
					isValide = false;
					throw new BusinessException("Vente null"); // à changer pour un code erreurs
				}if (v.getNomArticle().trim().length() == 0) {
					isValide = false;
					throw new BusinessException("Nom de l'article obligatoire"); // à changer pour un code erreurs
				}if (v.getNoVente() < 0 || v.getNoVente() == 0) {
					isValide = false;
					throw new BusinessException("No vente obligatoire"); // à changer pour un code erreur
				}if (v.getDescription().trim().length() == 0) {
					isValide = false;
					throw new BusinessException("Description obligatoire"); // à changer pour un code erreur
				} if (v.getMiseAPrix() < 0 || v.getMiseAPrix() == 0) {
					isValide = false;
					throw new BusinessException("Mise à prix suppérieur à 0 obligatoire"); // à changer pour un code erreur
				}if (v.getDateFinEnchere() == null) {
					isValide = false;
					throw new BusinessException("Date obligatoire"); // à changer pour un code erreur
				}
				return isValide;
			}
}




















