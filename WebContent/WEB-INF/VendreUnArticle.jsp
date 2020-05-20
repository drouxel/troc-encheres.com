<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
	<h2>Nouvelle vente</h2>
	<form name="ajouterUnArticle" id="ajouterUnArticle" method="POST" action="/ServletVendreUnArticle">
	<div class="row">
		<div class="col-sm-4"></div>
		<div class="col-sm-2">
			<label>Article : </label>
		</div>
		<div class="col-sm-2">
			<input type="text" name="article" id="article">
		</div>
		<div class="col-sm-4"></div>
	</div>
	<div class="row">
		<div class="col-sm-4"></div>
		<div class="col-sm-2">
			<label>Description : </label>
		</div>
		<div class="col-sm-2">
			<textarea name="description" id="description" cols="40" rows="5"></textarea>
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
			<input type="date" name="finEnchere" id="finEnchere">
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
					<div class="col-sm-1"><input type="text" name="rue" id="rue"></div>
				</div>
				<div class="row">
					<div class="col-sm-5"><label>Code postal : </label></div>
					<div class="col-sm-1"><input type="text" name="codePostal" id="codePostal"></div>
				</div>			 
				<div class="row">
					<div class="col-sm-5"><label>Ville : </label></div>
					<div class="col-sm-1"><input type="text" name="ville" id="ville"></div>
				</div>
			</fieldset>
		</div>
		<div class="col-sm-3"></div>
	</div>
			<div class="row">
				<div class="col-sm-3"></div>
				<div class="col-sm-2">
					<button type="button" class="btn btn-danger btn-lg">Publier</button>
				</div>
				<div class="col-sm-2">
					<button type="button" class="btn btn-success btn-lg">Enregistrer</button>
				</div>
				<div class="col-sm-2">
					<button type="button" class="btn btn-primary btn-lg">Annuler</button>
				</div>
				<div class="col-sm-3"></div>
			</div>

	</form>
</body>
</html>