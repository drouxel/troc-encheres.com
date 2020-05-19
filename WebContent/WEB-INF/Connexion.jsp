<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!-- auteurs de la page : Damien et Ludovic -->
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
	<div class="container-fluid">
		<form action="<%=request.getContextPath()%>/ServletConnexion" method="post">
			<div class="row">
			<div class="col-sm-4"></div>
			    <div class="col-sm-2">
			        <label for="identifiant">Identifiant : </label>
			    </div>
			    <div class="col-sm-2">
			        <input type="text" class="form-control" placeholder="e-mail ou pseudo" id="identifiant" name="login" required>
			    </div>
			</div>
			<div class="row">
			<div class="col-sm-4"></div>
			    <div class="col-sm-2">
			        <label for="motDePasse">Mot de passe : </label>
			    </div>
			    <div class="col-sm-2">
			        <input type="password" class="form-control" placeholder="******" id="motDePasse" name="motDePasse" required>
			    </div>
			    <div class="col-sm-4"></div>
			</div>
			<div class="row">
				<div class="col-sm-4"></div>
			    <div class="col-sm-2">
			        <button type="submit" class="btn btn-primary">Connexion</button>
			    </div>
			    <div class="col-sm-2" id="choixConnexion">
			        <input type="checkbox" id="seSouvenirDeMoi" name="rememberMe" value="true">
			        <label for="seSouvenirDeMoi"> Se souvenir de moi</label>
			        <br>
			        <a href="<%=request.getContextPath()%>/ServletConnexion?forgotPwd=true">Mot de passe oublié</a>
			    </div>
			    <div class="col-sm-4"></div>
			</div>
		</form>
		<div class="row">
			<div class="col-sm-4"></div>
			<div class="col-sm-4">
				<a href="<%=request.getContextPath()%>/ServletCreationCompte" type="button" class="btn btn-primary" id="creerCompte">Créer un compte</a>
			</div>
			<div class="col-sm-4"></div>
		</div>
	</div>
</body>
</html>