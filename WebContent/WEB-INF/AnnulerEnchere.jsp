<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@ include file="fragments/ImportBootstrap.jspf"%>
<title>Encherir</title>
</head>
<%@ include file="fragments/EnTete.jspf"%>
<h2>Détail vente</h2>
<body>
	<img>
	<p>PC Gamer pour travailler</p>
	<p>Description :</p>
	<p>Meilleure offre :</p>
	<p>Mise à prix :</p>
	<p>Fin de l'enchère :</p>
	<p>Retrait :</p>
	<p>Vendeur :</p>
	<label for="maProposition">Ma proposition : </label>
	<br>
	<input type="button" value="Enchérir" name="encherir" id="encherir">
	<br>
	<input type="button" value="Annuler ma dernière enchère"
		name="annulerEnchere" id="annulerEnchere">
	<br>
	<input type="button" value="Retour" name="retour" id="retour">
	<br>

</body>
</html>