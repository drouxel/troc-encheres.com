<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@ include file="fragments/ImportBootstrap.jspf"%>
<link rel="stylesheet" type="text/css" href="vendor/css/CreationCompte.css">
<title>Créer un compte</title>
</head>
<%@ include file="fragments/EnTete.jspf"%>
<body>
	<h2>Créer un compte</h2>
	
	<form name="creationCompte" id="creationCompte" method="POST"
		action="/servletCreationCompte">
		<div id="container1">
			<div class="form-row">
				<div class="col">
					<input type="text" class="form-control" placeholder="Pseudo">
				</div>
				<div class="col">
					<input type="text" class="form-control" placeholder="Nom">
				</div>
			</div>
			<div class="form-row">
				<div class="col">
					<input type="text" class="form-control" placeholder="Prénom">
				</div>
				<div class="col">
					<input type="text" class="form-control" placeholder="E-mail">
				</div>
			</div>
			<div class="form-row">
				<div class="col">
					<input type="text" class="form-control" placeholder="Téléphone">
				</div>
				<div class="col">
					<input type="text" class="form-control" placeholder="Rue">
				</div>
			</div>
			<div class="form-row">
				<div class="col">
					<input type="text" class="form-control" placeholder="Code postal">
				</div>
				<div class="col">
					<input type="text" class="form-control" placeholder="Ville">
				</div>
			</div>
			<div class="form-row">
				<div class="col">
					<input type="text" class="form-control" placeholder="Mot de passe">
				</div>
				<div class="col">
					<input type="text" class="form-control" placeholder="Confirmation">
				</div>
			</div>
		<br>
		</div>
		<div class="col-sm 3">
			<div class="row" id="container2">
				<input type="submit" value="Créer"> 
				<input type="reset" value="Annuler">
			</div>
		</div>
	</form>
	
</body>
</html>