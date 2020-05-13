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
	<form id="container4">
	  <div class="form-group">
		  <div id="container1">
		    <label for="exampleInputEmail1">Identifiant</label>
		    <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
		  </div>
	    <small id="emailHelp" class="form-text text-muted">Nous ne partagerons jamais vos coordonnées à quiconque.</small>
	  </div>
	  <div class="form-group" id="container2">
	    <label for="exampleInputPassword1">Mot de passe</label>
	    <input type="password" class="form-control" id="exampleInputPassword1">
	  </div>
	  	  <button type="submit" class="btn btn-primary">Connexion</button>
	  <div class="form-group form-check" id="container3">
	    <input type="checkbox" id="seSouvenirDeMoi">
	    <label class="form-check-label" for="seSouvenirDeMoi">Se souvenir de moi</label>
	    <p><a href="">Mot de passe oublié</a></p>
	  </div>

	</form>
	<br>
	<div class="col-sm 3" id="container5">
	<div class="row">
	<a href="/Projet_Troc_Encheres/servletCreationCompte"><input
		type="button" value="Créer un compte" id="creerUnCompte"></a>
		</div>
	</div>

</body>
</html>