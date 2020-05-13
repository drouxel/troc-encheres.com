<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@ include file="fragments/ImportBootstrap.jspf"%>
<link rel="stylesheet" type="text/css" href="vendor/css/CreationCompte.css">
<title>Éditer mon profil</title>
</head>
<%@ include file="fragments/EnTete.jspf"%>
<body>
<h2>Éditer mon profil</h2>
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
		
	<div class="row" id="container3">

			<div class="col-sm-1" id="container2"></div>
				<div class="col-sm-5">
					<button type="button" class="btn btn-danger btn-lg">Supprimer le compte</button> 
				</div>
				<div class="col-sm-3">
					<button type="button" class="btn btn-success btn-lg">Enregistrer</button>
				</div>
				<div class="col-sm-2">
					<button type="button" class="btn btn-primary btn-lg">Retour</button>
				</div>
			<div class="col-sm-1"></div>
		</div>
	</div>	
		

</form>
</body>
</html>