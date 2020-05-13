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
<form name="container1" id="container1" method="POST" action="/A_MODIFIER">
<%@ include file="fragments/profil.jspf"%>
<div id="container2">
	<input class="btn btn-primary" type="submit" value="Supprimer mon compte">
	<input class="btn btn-primary" type="submit" value="Enregistrer">
	<input class="btn btn-primary" type="button" value="Retour">
</div>
</form>
</body>
</html>