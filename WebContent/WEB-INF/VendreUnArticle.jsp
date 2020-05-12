<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Vendre un articlee</title>
</head>
<header>
	<h1>TrocEncheres.org</h1>
</header>
<body>
<h2>Nouvelle vente</h2>
<form>
	<label>Article : </label>
		<input type="text" name="article" id="article">
	<label>Description : </label>
		<textarea name="description" id="description" cols="5" rows="5"></textarea> 
	<label>Photos de l'article</label>
	<label>Mise à prix : </label>
		<input type="number" name="enchere" id="enchere" min="100">
	<label>Fin de l'enchère : </label>
	<fieldset>
		<legend>Retrait</legend>
		<label>Rue : </label> 
			<input type="text" name="rue" id="rue">
		<label>Code postal : </label>
			<input type="text" name="codePostal" id="codePostal">
		<label>Ville : </label>
			<input type="text" name="ville" id="ville">	
	</fieldset>
		<input type="submit" value="Publier">
		<input type="button" value="Enregistrer">
		<input type="reset" value ="Annuler">
</form>
</body>
</html>