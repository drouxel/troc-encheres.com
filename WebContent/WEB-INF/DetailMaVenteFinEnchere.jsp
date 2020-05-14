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
	<p>... a remporté l'enchère</p>
<%@ include file="fragments/DetailsVente.jspf"%>

			
			<div class="row" id="container3">
				<div class="col-sm-3" id="container2"></div>
				<div class="col-sm-3">
					<button type="button" class="btn btn-danger btn-lg">Supprimer
						le compte</button>
				</div>
				<div class="col-sm-2">
					<button type="button" class="btn btn-success btn-lg">Enregistrer</button>
				</div>
				<div class="col-sm-1">
					<button type="button" class="btn btn-primary btn-lg">Retour</button>
				</div>
				<div class="col-sm-2"></div>
			</div>
</body>
</html>