<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@ include file="fragments/ImportBootstrap.jspf"%>
<title>Détails de la vente</title>
</head>
<%@ include file="fragments/EnTete.jspf"%>
<body>
	<h2>... a remporté l'enchère</h2>
<%@ include file="fragments/DetailsVente.jspf"%>

			
			<div class="row" id="container3">
				<div class="col-sm-3"></div>
				<div class="col-sm-2">
					<button type="button" class="btn btn-danger btn-lg">Retrait effectué</button>
				</div>
				<div class="col-sm-2">
					<button type="button" class="btn btn-success btn-lg">Contacter...</button>
				</div>
				<div class="col-sm-2">
					<button type="button" class="btn btn-primary btn-lg">Retour</button>
				</div>
				<div class="col-sm-3"></div>
			</div>
</body>
</html>