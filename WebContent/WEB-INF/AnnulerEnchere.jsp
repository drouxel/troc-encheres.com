<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@ include file="fragments/ImportBootstrap.jspf"%>
<link rel="stylesheet" type="text/css" href="vendor/css/AnnulerEnchere.css">
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
	<div class="form-row">
		<div class="col">
			<label for="maProposition">Ma proposition : </label>
		</div>
		<div class="col">
			<input type="number" class=".form-control" min="100" placeholder="100" id="maProposition">
		</div>
		<div class="col">
			<button type="button" class="btn btn-primary" name="encherir" id="encherir">Enchérir</button>
		</div>
	</div>
	<br>
	<div class="form-row">
		<div class="col">
			<button type="button" class="btn btn-danger" name="annulerEnchere" id="annulerEnchere">Annuler ma dernière enchère</button>
		</div>
		<div class="col">
			<button type="button" class="btn btn-success" name="retour" id="retour">Retour</button>
		</div>
	</div>
	<br>

</body>
</html>