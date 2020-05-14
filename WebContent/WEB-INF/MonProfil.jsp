<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@ include file="fragments/ImportBootstrap.jspf"%>
<link rel="stylesheet" type="text/css" href="vendor/css/MonProfil.css">
<title>Mon profil</title>
</head>
<%@ include file="fragments/EnTete.jspf"%>
<body>
	<h2>MonProfil</h2>

	<div class="row">
		<div class="col-sm-4"></div>
		<div class="col-sm-2">
			<label for="pseudo">Pseudo : </label>
		</div>
		<div class="col-sm-2">info</div>
		<div class="col-sm-4"></div>
	</div>

	<div class="row">
		<div class="col-sm-4"></div>
		<div class="col-sm-2">
			<label for="nom">Nom : </label>
		</div>
		<div class="col-sm-2">info</div>
		<div class="col-sm-4"></div>
	</div>

	<div class="row">
		<div class="col-sm-4"></div>
		<div class="col-sm-2">
			<label for="prenom">Prénom : </label>
		</div>
		<div class="col-sm-2">info</div>
		<div class="col-sm-4"></div>
	</div>

	<div class="row">
		<div class="col-sm-4"></div>
		<div class="col-sm-2">
			<label for="email">Email : </label>
		</div>
		<div class="col-sm-2">info</div>
		<div class="col-sm-4"></div>
	</div>

	<div class="row">
		<div class="col-sm-4"></div>
		<div class="col-sm-2">
			<label for="telephone">Téléphone : </label>
		</div>
		<div class="col-sm-2">info</div>
		<div class="col-sm-4"></div>
	</div>

	<div class="row">
		<div class="col-sm-4"></div>
		<div class="col-sm-2">
			<label for="rue">Rue : </label>
		</div>
		<div class="col-sm-2">info</div>
		<div class="col-sm-4"></div>
	</div>

	<div class="row">
		<div class="col-sm-4"></div>
		<div class="col-sm-2">
			<label for="codePostal">Code postal : </label>
		</div>
		<div class="col-sm-2">info</div>
		<div class="col-sm-4"></div>
	</div>

	<div class="row">
		<div class="col-sm-4"></div>
		<div class="col-sm-2">
			<label for="ville">Ville : </label>
		</div>
		<div class="col-sm-2">info</div>
		<div class="col-sm-4"></div>
	</div>

</body>
<footer>
	<div class="row" id="container3">
		<div class="col-sm-5" id="container2"></div>
				<div class="col-sm-2">
					<button type="button" class="btn btn-primary btn-lg">Retour</button> 
				</div>
			<div class="col-sm-5"></div>
	</div>	
</footer>
</html>