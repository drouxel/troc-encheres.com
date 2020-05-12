<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Connexion</title>
</head>
<header>
	<h1>TrocEncheres.org</h1>
</header>
<body>
<form>
<label for="id">Identifiant</label>
<input type="text" name="id" placeholder="identifiant">
<br>
<br>
<label for="password">Mot de passe</label>
<input type="password" name="password" placeholder="******">
<br>
<br>
<input type="button" value="Connexion">
<input type="checkbox"><label for="seSouvenirDeMoi">Se souvenir de moi</label>
</form>
<p><a href="">Mot de passe oublié</a></p>
<br>
<a href="/Projet_Troc_Encheres/servletCreationCompte"><input type="button" value="Créer un compte"></a>

</body>
</html>