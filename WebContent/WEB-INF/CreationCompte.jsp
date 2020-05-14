<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@ include file="fragments/ImportBootstrap.jspf"%>
<link rel="stylesheet" type="text/css"
	href="vendor/css/CreationCompte.css">
<title>Créer un compte</title>
</head>
<%@ include file="fragments/EnTete.jspf"%>
<body>
	<h2>Créer un compte</h2>

<form name="creationCompte" id="creationCompte" method="POST" action="/servletCreationCompte">
	<div class="row">
		<div class="col-sm-3"></div>
		<div class="col-sm-6">
			<div>
				<%@ include file="fragments/profil.jspf"%>
				<br>
			</div>
		</div>
		<div class="col-sm-3"></div>
	</div>
	
	<div class="row" id="container3">
		<div class="col-sm-2" id="container2"></div>
				<div class="col">
					<button type="button" class="btn btn-primary btn-lg">Créer</button> 
				</div>
				<div class="col">
					<button type="button" class="btn btn-danger btn-lg">Annuler</button>
				</div>
			<div class="col-sm-2"></div>
	</div>	
		

</form>

</body>
</html>