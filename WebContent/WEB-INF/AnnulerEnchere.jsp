<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@ include file="fragments/ImportBootstrap.jspf"%>
<link rel="stylesheet" type="text/css"
	href="vendor/css/AnnulerEnchere.css">
<title>Annuler l'enchère</title>
</head>
<%@ include file="fragments/EnTete.jspf"%>
<h2>Détail vente</h2>
<body>
	<img>
	<div class="row">
		<div class="col-sm-4"></div>
		<div class="col-sm-2">
			<label>PC Gamer pour travailler</label>
		</div>
		<div class="col-sm-2">info</div>
		<div class="col-sm-4"></div>
	</div>
	<div class="row">
		<div class="col-sm-4"></div>
		<div class="col-sm-2">
			<label>Description : </label>
		</div>
		<div class="col-sm-2">info</div>
		<div class="col-sm-4"></div>
	</div>
	<div class="row">
		<div class="col-sm-4"></div>
		<div class="col-sm-2">
			<label>Meilleure offre : </label>
		</div>
		<div class="col-sm-2">info</div>
		<div class="col-sm-4"></div>
	</div>
	<div class="row">
		<div class="col-sm-4"></div>
		<div class="col-sm-2">
			<label>Mise à prix : </label>
		</div>
		<div class="col-sm-2">info</div>
		<div class="col-sm-4"></div>
	</div>
	<div class="row">
		<div class="col-sm-4"></div>
		<div class="col-sm-2">
			<label>Fin de l'enchère : </label>
		</div>
		<div class="col-sm-2">info</div>
		<div class="col-sm-4"></div>
	</div>
	<div class="row">
		<div class="col-sm-4"></div>
		<div class="col-sm-2">
			<label>Retrait : </label>
		</div>
		<div class="col-sm-2">info</div>
		<div class="col-sm-4"></div>
	</div>
	<div class="row">
		<div class="col-sm-4"></div>
		<div class="col-sm-2">
			<label>Vendeur : </label>
		</div>
		<div class="col-sm-2">info</div>
		<div class="col-sm-4"></div>
	</div>
	<div class="row">
		<div class="col-sm-4"></div>
		<div class="col-sm-2">
			<label for="maProposition">Ma proposition : </label>
		</div>
		<div class="col-sm-2">
			<input type="number" class=".form-control" min="100"
				placeholder="100" id="maProposition">
		</div>
		<div class="col-sm-2">
			<button type="button" class="btn btn-primary" name="encherir"
				id="encherir">Enchérir</button>
		</div>
		<div class="col-sm-2"></div>
	</div>
	<br>
	<div class="row">
		<div class="col-sm-4"></div>
		<div class="col-sm-1">
			<button type="button" class="btn btn-danger" name="annulerEnchere" id="annulerEnchere">Annuler ma dernière enchère</button>
		</div>
		<div class="col-sm-3"></div>
		<div class="col-sm-1">
			<button type="button" class="btn btn-success" name="retour" id="retour">Retour</button>
		</div>
		<div class="col-sm-3"></div>
	</div>
	<br>

</body>
</html>