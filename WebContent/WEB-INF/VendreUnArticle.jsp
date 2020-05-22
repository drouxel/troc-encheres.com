<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@ include file="fragments/ImportBootstrap.jspf"%>
<link rel="stylesheet" type="text/css" href="vendor/css/VendreUnArticle.css">
<title>Vendre un article</title>
</head>
<%@ include file="fragments/EnTete.jspf"%>
<body>
	<c:if test="${!empty succes}">
		<div class="alert alert-success text-center" role="alert">
			<p>Votre article a été publié avec succès</p>
		</div>
	</c:if>
	<form name="ajouterUnArticle" id="ajouterUnArticle" method="POST" action="<%=request.getContextPath()%>/ServletVendreUnArticle">
	<div class="row">
		<div class="col-sm-4"></div>
		<div class=col-sm-2>
			<label for="categories">Catégories : </label>
		</div>
		<div class="col-sm-2">
			<select class="form-control col-sm-12" name="categorie">
				<c:forEach var="categorie" items ="${categories}">
					<option value="${categorie.noCategorie}">${categorie.libelle}</option>
				</c:forEach>	
			</select>
		</div>	
	</div>
	<div class="row">
		<div class="col-sm-4"></div>
		<div class="col-sm-2">
			<label>Article : </label>
		</div>
		<div class="col-sm-2">
			<input type="text" class="form-control" name="article" id="article" value="${vente.nomArticle}">
		</div>
		<div class="col-sm-4"></div>
	</div>
	<div class="row">
		<div class="col-sm-4"></div>
		<div class="col-sm-2">
			<label>Description : </label>
		</div>
		<div class="col-sm-2">
			<textarea name="description" class="form-control" id="description" value="${vente.description }"cols="40" rows="5"></textarea>
		</div>
		<div class="col-sm-4"></div>
	</div>	
	<div class="row">
		<div class="col-sm-4"></div>
		<div class="col-sm-2">
			<label>Photo de l'article</label>
		</div>
		<div class="col-sm-2">
				<input type="file" class="form-control-file btn btn-primary btn-lg" id="exampleFormControlFile1">
<!-- 			<button type="button" class="btn btn-primary btn-lg">UPLOADER</button>  -->
		</div>
		<div class="col-sm-4"></div>
	</div>	
	
	<div class="row">
		<div class="col-sm-4"></div>
		<div class="col-sm-2">
			<label>Mise à prix : </label>
		</div>
		<div class="col-sm-2">
			<input type="number" name="enchere" id="enchere" min="0">
		</div>
		<div class="col-sm-4"></div>
	</div>		
	<div class="row">
		<div class="col-sm-4"></div>
		<div class="col-sm-2">
			<label>Fin de l'enchère : </label>
		</div>
		<div class="col-sm-2">
			<input type="date" class="form-control" name="finEnchere" id="finEnchere">
		</div>
		<div class="col-sm-4"></div>
	</div>		
	<div class="row">
		<div class="col-sm-3"></div>
		<div class="col-sm-6">
			<fieldset class="border p-2" id="adresse">
				<legend class="w-auto">Retrait</legend>
				<div class="row">
					<div class="col-sm-5"><label>Rue : </label></div>
					<div class="col-sm-1"><input type="text"  name="rue" id="rue"></div>
				</div>
				<div class="row">
					<div class="col-sm-5"><label>Code postal : </label></div>
					<div class="col-sm-1"><input type="text"  name="codePostal" id="codePostal"></div>
				</div>			 
				<div class="row">
					<div class="col-sm-5"><label>Ville : </label></div>
					<div class="col-sm-1"><input type="text"  name="ville" id="ville"></div>
				</div>
			</fieldset>
		</div>
		<div class="col-sm-3"></div>
	</div>
		<div class="row">
			<div class="col-sm-3"></div>
			<c:if test="${empty succes}">
				<div class="col-sm-2">
					<input type="submit" class="btn btn-success btn-lg" value="publier" name="publier"/>
				</div>
				<div class="col-sm-2">
					<input type="submit" class="btn btn-success btn-lg" value="enregistrer" name="enregistrer"/>
				</div>
				<div class="col-sm-2">
			</c:if>
			<c:if test="${!empty succes}">
				<div class="col-sm-2">
					<a href="<%=request.getContextPath()%>/ServletVendreUnArticle">
						<button type="button" class="btn btn-primary btn-lg">Vendre un autre article</button>
					</a>
				</div>
				<div class="col-sm-2"></div>
			</c:if>
			<div class="col-sm-2">
				<a href="<%=request.getContextPath()%>/ServletListeEncheres">
					<button type="button" class="btn btn-primary btn-lg">Annuler</button>
				</a>
			</div>
		</div>
	</form>
</body>
</html>