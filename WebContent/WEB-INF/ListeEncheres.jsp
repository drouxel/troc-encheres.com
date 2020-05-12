<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Accueil</title>
</head>
<header><h1>TrocEncheres.org</h1></header>
<p><a href="">Vendre un article</a></p>
<p><a href="/Projet_Troc_Encheres/servletMonProfil">Mon profil</a></p>
<p><a href="">Déconnexion</a></p>

<h2>Filtres : </h2>
<p>leTrioDeLEtrange est connecté !</p>
<form>
	<input type="search" id="recherche" name="recherche" placeholder="Recherche">
	<br>
	<br>
	<label for="categories">Catégories : </label>
	<select>
		<option>Jeux vidéos
		<option>Jeux de société
		<option>Jeux de construction
	</select>
	<br>
	<br>
	<input type="checkbox" value ="mesVentes">
		<label for="mesVentes">Mes ventes</label>
	<br>
	<br>
	<input type="checkbox" value ="mesEncheresEnCours">
		<label for="mesEncheresEnCours">Mes enchères en cours</label>
	<br>
	<br>
	<input type="checkbox" value ="mesAcquisitions">
		<label for="mesAcquisitions">Mes acquisitions</label>
	<br>
	<br>
	<input type="checkbox" value ="autresEncheres">
		<label for="autresEncheres">Mes autres enchères</label>
	<br>
	<br>
</form>

<div><p>Annulation enchère</p></div>
<div><p>Enchère en cours</p></div>
<body>

</body>
</html>