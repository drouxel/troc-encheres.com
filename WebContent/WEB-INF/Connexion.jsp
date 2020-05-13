<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@ include file="fragments/ImportBootstrap.jspf"%>
<link rel="stylesheet" type="text/css" href="vendor/css/Connexion.css">
<title>Connexion</title>
</head>
<%@ include file="fragments/EnTete.jspf"%>
<body>
	<div class="form-row">
	    <div class="col">
	        <label for="identifiant">Identifiant : </label>
	    </div>
	    <div class="col">
	        <input type="text" class="form-control" placeholder="Identifiant" id="identifiant">
	    </div>
	</div>
	<div class="form-row">
	    <div class="col">
	        <label for="motDePasse">Mot de passe : </label>
	    </div>
	    <div class="col">
	        <input type="password" class="form-control" placeholder="******" id="motDePasse">
	    </div>
	</div>
	<div class="form-row">
	    <div class="col">
	        <button type="button" class="btn btn-primary">Connexion</button>
	    </div>
	    <div class="col" id="choixConnexion">
	        <input type="checkbox" id="seSouvenirDeMoi">
	        <label for="seSouvenirDeMoi"> Se souvenir de moi</label>
	        <br>
	        <a href="/Projet_Troc_Encheres/servletCreationCompte">Mot de passe oublié</a>
	    </div>
	</div>
</body>
</html>