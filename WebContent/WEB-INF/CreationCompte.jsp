<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@ include file="fragments/ImportBootstrap.jspf"%>
<title>Créer un compte</title>
</head>
<%@ include file="fragments/EnTete.jspf"%>
<body>
<h2>Créer un compte</h2>
<form name="creationCompte" id="creationCompte" method="POST" action="/servletCreationCompte">
	<label>Pseudo : </label><input type="text" name="pseudo" id="pseudo">
	<br>
	<br>
	<label>Nom : </label><input type="text" name="nom" id="nom">
	<br>
	<br>
	<label>Prénom : </label><input type="text" name="prenom" id="prenom">
	<br>
	<br>
	<label>Email : </label><input type="text" name="email" id="email">
	<br>
	<br>
	<label>Téléphone : </label><input type="tel" name="telephone" id="telephone">
	<br>
	<br>
	<label>Rue : </label><input type="text" name="rue" id="rue">
	<br>
	<br>
	<label>Code postal : </label><input type="text" name="codePostal" id="codePostal">
	<br>
	<br>
	<label>Ville : </label><input type="text" name="ville" id="ville">
	<br>
	<br>
	<label>Mot de passe : </label><input type="text" name="motDePasse" id="motDePasse">
	<br>
	<br>
	<label>Confirmation : </label><input type="text" name="confirmationMotDePasse" id="confirmationMotDePasse">
	<br>
	<br>
	<input type="submit" value="Créer">
	<input type="reset" value="Annuler">
</form>
</body>
</html>