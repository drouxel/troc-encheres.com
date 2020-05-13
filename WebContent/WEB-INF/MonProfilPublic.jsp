<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@ include file="fragments/ImportBootstrap.jspf"%>
<link rel="stylesheet" type="text/css" href="vendor/css/MonProfil.css">
<title>Profil de l'utilisateur</title>
</head>
<%@ include file="fragments/EnTete.jspf"%>
<body>
	<h2>Profil de trioDeLEtrange</h2>
	<div id="container1">
		<br>
		<label for="pseudo">Pseudo : </label>
		<br>
		<label for="adresse">Adresse : </label>
		<br>
		<label for="Tel">Tel : </label>
		<br>
	</div>
	<a href="">
		<input class="btn btn-primary" type="button" value="Retour">
	</a>
</body>
</html>