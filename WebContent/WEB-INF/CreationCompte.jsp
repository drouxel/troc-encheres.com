<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!-- auteurs de la page : Damien et Ludovic -->
<!DOCTYPE html>
<html>
	<head>
	<meta charset="ISO-8859-1">
	<%@ include file="fragments/ImportBootstrap.jspf"%>
	<link rel="stylesheet" type="text/css"
		href="vendor/css/CreationCompte.css">
	<title>Créer un compte</title>
	</head>
<%@ include file="fragments/EnTete.jspf"%>
	<body>
		<div class="container">
			<div class="col-sm-12 text-center">
				<c:if test="${!empty self}">
					<h2>Mon Profil</h2>
				</c:if>
				<c:if test="${!empty other}">
					<h2>${utilisateurAAfficher.pseudo}</h2>
				</c:if>
				<c:if test="${empty self && empty other }">
					<h2>Créer un compte</h2>
				</c:if>
			</div>
			<form action="<%=request.getContextPath()%>/servletCreationCompte"  method="POST" >
				<div class="row">
					<div class="form-row col-sm-6">
						<label for="pseudo">Pseudo : </label>
						<input type="text" class="form-control col offset-1" placeholder="" id="pseudo" name="pseudo" value="">
					</div>
					<div class="form-row col-sm-6">
						<label for="nom">Nom : </label>
						<input type="text" class="form-control col offset-1" placeholder="" id="nom" name="nom" value="">
					</div>
				</div>
				<div class="row">
					<div class="form-row col-sm-6">
						<label for="prenom">Prenom : </label>
						<input type="text" class="form-control col offset-1" placeholder="" id="prenom" name="prenom" value="">
					</div>
					<div class="form-row col-sm-6">
						<label for="email">E-mail : </label>
						<input type="text" class="form-control col offset-1" placeholder="" id="email" name="email" value="">
					</div>
				</div>
				<div class="row">
					<div class="form-row col-sm-6">
						<label for="telephone">Telephone : </label>
						<input type="text" class="form-control col offset-1" placeholder="" id="telephone" name="telephone" value="">
					</div>
					<div class="form-row col-sm-6">
						<label for="rue">Rue : </label>
						<input type="text" class="form-control col offset-1" placeholder="" id="rue" name="rue" value="">
					</div>
				</div>
				<div class="row">
					<div class="form-row col-sm-6">
						<label for="codePostal">Code Postal : </label>
						<input type="text" class="form-control col offset-1" placeholder="" id="codePostal" name="codePostal" value="">
					</div>
					<div class="form-row col-sm-6">
						<label for="ville">Ville : </label>
						<input type="text" class="form-control col offset-1" placeholder="" id="ville" name="ville" value="">
					</div>
				</div>
				<c:if test="${empty other}">
					<div class="row">
						<div class="form-row col-sm-6">
							<label for="motDePasse">Mot de passe : </label>
							<input type="password" class="form-control col offset-1" placeholder="" id="motDePasse" name="motDePasse" value="">
						</div>
						<div class="form-row col-sm-6">
							<label for="confirmation">Confirmation : </label>
							<input type="password" class="form-control col offset-1" placeholder="" id="confirmation" name="confirmation" value="">
						</div>
					</div>
				</c:if>
				<c:if test="${!empty self}">
					<div class ="row">
						<div class="form-row col-sm-6">
							<label for="credit">Credit : </label>
							<input type="text" class="form-control-plaintext col offset-1" placeholder="" id="credit" name="credit" value="">
						</div>
					</div>
				</c:if>
				<!-- boutons de choix -->
				<div class="row" id="container3">
					<div class="col-sm-3"></div>
					<c:if test="${empty other}">
						<div class="col-sm-2">
							<button type="submit" class="btn btn-primary btn-block btn-lg">Créer</button> 
						</div>
						<div class="col-sm-3">
							<c:if test="${!empty self }">
								<input type="submit" class="btn btn-danger btn-block btn-lg" name="supprimer" value="Supprimer mon compte">
							</c:if>
						</div>
					</c:if>
					<div class="col-sm-2">
						<a href="<%=request.getContextPath()%>/ServletListeEncheres">
							<button type="button" class="btn btn-danger btn-block btn-lg">Annuler</button>
						</a>
					</div>
				</div>	
			</form>
		</div>
	</body>
</html>