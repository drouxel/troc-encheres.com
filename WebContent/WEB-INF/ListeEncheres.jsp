<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!-- auteurs de la page : Damien et Ludovic --> 
<!DOCTYPE html>
<html>
	<head>
	<meta charset="ISO-8859-1">
	<%@ include file="fragments/ImportBootstrap.jspf"%>
	<title>Accueil</title>
	</head>
	<nav class="navbar fixed-top navbar-right navbar-expand-sm navbar-light bg-light">
		<c:if test="${empty sessionScope.utilisateurCourant}">
			<div class="navbar-nav ">
		     <div class="nav-item">
				<a class="nav-link" href="<%=request.getContextPath()%>/ServletConnexion">Connexion</a>
		     </div>
		   </div>
		</c:if>
		<c:if test="${!empty sessionScope.utilisateurCourant}">
		   <div class="navbar-nav navbar-right">
		     <div class="nav-item">
				<a class="nav-link" href="<%=request.getContextPath()%>/ServletVendreUnArticle">Vendre un article</a>
		     </div>
		     <div class="nav-item">
				<a class="nav-link" href="<%=request.getContextPath()%>/ServletCreationCompte?noUtilisateurAAfficher=${utilisateurCourant.noUtilisateur}">Mon profil</a>
		     </div>
		     <div class="nav-item">
				<a class="nav-link " href="<%=request.getContextPath()%>/ServletConnexion?deconnexion=oui">Déconnexion</a>
		     </div>
		   </div>
		</c:if>
	</nav>
	<body>
		<%@ include file="fragments/EnTete.jspf"%>
		<div class="container-fluid">
			<%@ include file="fragments/ListeErreurs.jspf" %>
			<form action="<%=request.getContextPath()%>/ServletListeEncheres" method="post">
				<div class="row">
					<div class="form-group col-sm-4">
						<h3 for="filtres">Filtres</h3>
						<div class="form-group offset-sm-1">
							<input type="checkbox" name="mesVentes" id="mesVentes" value="true">
							<label for="mesVentes">Mes ventes</label>
						</div>
						<div class="form-group offset-sm-1">
							<input type="checkbox" name="mesEncheres" id="mesEncheres" value="true">
							<label for="mesEncheres">Mes encheres en cours</label>
						</div>
						<div class="form-group offset-sm-1">
							<input type="checkbox" name="mesAcquisitions" id="mesAcquisitions" value="true">
							<label for="mesAcquisitions">Mes acquisitions</label>
						</div>
						<div class="form-group offset-sm-1">
							<input type="checkbox" name="autresEncheres" id="autresEncheres"value="true">
							<label for="autresEncheres">Autres encheres</label>
						</div>
					</div>
					<div class="form-group col-sm-8">
						<div class="form-group form-inline">
							<label class="col-sm-2" for="categories">Catégories : </label>
							<select class="form-control col-sm-6">
								<option value="toutes">Toutes</option>
								<c:forEach var="categorie" items ="${categories}">
									<option value="${categorie.libelle}">${categorie.libelle}</option>
								</c:forEach>	
							</select>
						</div>
						<div class="form-group">
							<input class="col-sm-8 form-control" type="search" id="recherche" name="recherche" placeholder="Le nom de l'article contient">
						</div>
					</div>
				</div>
				<div class="col-sm-5">
					<button class="btn btn-lg btn-block" type="submit">Rechercher</button>
				</div>
			</form>
			<c:forEach var="annonce" items="${annonces}">
				<div class="row">
					<div class="col-sm-5 offset-sm-1">
						<div class="card">
							<div class="row no-gutters">
								<div class="col-sm-4">
									<img src="" class="card-img" alt="${annonce.vente.nomArticle}">
								</div>
								<div class="col-sm-8">
									<div class="card-body">
										<h5 class="card-title">
											<a href="<%=request.getContextPath()%>/ServletDetailMaVente?noVente=${annonce.vente.noVente}">${annonce.vente.nomArticle}</a>
										</h5>
										<p class="card-text">Prix : ${annonce.vente.prixVente} points</p>
										<p class="card-text">Fin de l'enchere : 
											<fmt:formatDate value="${annonce.vente.dateFinEnchereAffichage}" dateStyle="short"/> 
										</p>
										<p class="card-text">Retrait : ${annonce.vente.retrait.rue}</p>
										<p class="card-text">			${annonce.vente.retrait.codePostal} ${annonce.vente.retrait.ville}</p>
										<p class="card-text">Vendeur : ${annonce.vente.vendeur.pseudo}</p>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</c:forEach>
			<div>
			</div>
		</div>
	</body>
</html>