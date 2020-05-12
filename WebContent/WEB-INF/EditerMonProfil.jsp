<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@ include file="fragments/ImportBootstrap.jspf"%>
<title>Éditer mon profil</title>
</head>
<%@ include file="fragments/EnTete.jspf"%>
<body>
<form name="editerMonProfil" id="editerMonProfil" method="POST" action="/A_MODIFIER">
	<label>Pseudo : </label>
		<input type="text" name="pseudo" id="pseudo">
	<br>
	<br>
	<label>Nom : </label>
		<input type="text" name="nom" id="nom">
	<br>
	<br>
	<label>Prï¿½nom : </label>
		<input type="text" name="prenom" id="prenom">
	<br>
	<br>
	<label>Email : </label>
		<input type="text" name="email" id="email">
	<br>
	<br>
	<label>Tï¿½lï¿½phone : </label>
		<input type="tel" name="telephone" id="telephone">
	<br>
	<br>
	<label>Rue : </label>
		<input type="text" name="rue" id="rue">
	<br>
	<br>
	<label>Code postal : </label>
		<input type="text" name="codePostal" id="codePostal">
	<br>
	<br>
	<label>Ville : </label>
		<input type="text" name="ville" id="ville">
	<br>
	<br>
	<label>Mot de passe : </label>
		<input type="text" name="motDePasse" id="motDePasse">
	<br>
	<br>
	<label>Confirmation : </label>
		<input type="text" name="confirmationMotDePasse" id="confirmationMotDePasse">
	<br>
	<br>
	<label for="credit">Crédit : </label><p>Insérer la valeur du crédit </p>
	<br>
	<br>
	<input type="submit" value="Enregistrer">
	<input type="button" value="Supprimer mon compte">
	<input type="button" value="Retour">
</form>
</body>
</html>