<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@ include file="fragments/ImportBootstrap.jspf"%>
<title>Détails de la vente</title>
</head>
<%@ include file="fragments/EnTete.jspf"%>
<body>
	<p>... a remporté l'enchère</p>
	<p>PC Gamer pour travailler</p>
	<br>
	<p>Description : </p>
	<br>
	<p>Meilleure offre : </p>
	<br>
	<p>Mise à prix : </p>
	<br>
	<p>Fin de l'enchère : </p>
	<br>
	<p>Retrait : </p>
	<br>
	<p>Vendeur : </p>
	<br>
	<input type="button" value="Retrait effectué" name="retraitEffectue" id="retraitEffectue">
	<input type="button" value="Contacter vendeur" name="contacterVendeur" id="contacterVendeur">
	<input type="button" value="Retour" name="retour" id="retour">
</body>
</html>