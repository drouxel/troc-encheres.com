<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@ include file="fragments/ImportBootstrap.jspf"%>
<title>Détails vente</title>
</head>
<%@ include file="fragments/EnTete.jspf"%>
<h2>Détail vente</h2>
<body>
	<%@ include file="fragments/ListeErreurs.jspf" %>
	<%@ include file="fragments/DetailsVente.jspf"%>
	<div class="row" id="container3">
		<div class="col-sm-4" id="container2"></div>
	<!-- 
			<button type="button" class="btn btn-danger btn-lg">Annuler
				la vente</button>
		</div>
 -->	
		<div class="col-sm-1"></div>
		<div class="col-sm-2">
			<a href="<%=request.getContextPath()%>">
				<button type="button" class="btn btn-primary btn-lg">Retour</button>
			</a>
		</div>
		<div class="col-sm-4"></div>
	</div>
</body>
</html>