<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@ include file="fragments/ImportBootstrap.jspf"%>
<title>Accueil</title>
</head>
<%@ include file="fragments/EnTete.jspf"%>

<nav class="navbar fixed-top navbar-expand-sm navbar-light bg-light">
   <div class="navbar-nav navbar-right">
     <div class="nav-item">
		<a class="nav-link" href="<%=request.getContextPath()%>/servletVendreUnArticle">Vendre un article</a>
     </div>
     <div class="nav-item">
		<a class="nav-link" href="<%=request.getContextPath()%>/servletMonProfil">Mon profil</a>
     </div>
     <div class="nav-item">
		<a class="nav-link disabled" href="<%=request.getContextPath()%>/ServletDeconnexion">Déconnexion</a>
     </div>
   </div>
</nav>
<body>
	<div class="container-fluid">
		<form action="<%=request.getContextPath()%>/ServletListeEncheres" method="post">
			<div class="row">
				<div class="form-group col-sm-4">
					<h3 for="filtres">Filtres</h3>
					<div class="form-group offset-sm-1">
						<input type="checkbox" name="mesVentes" id="mesVentes" value="true">
						<label for="mesVentes">Mes ventes</label>
					</div>
					<div class="form-group offset-sm-1">
						<input type="checkbox" name="mesEncheres" id="mesEncheres" value="true">
						<label for="mesEncheres">Mes encheres en cours</label>
					</div>
					<div class="form-group offset-sm-1">
						<input type="checkbox" name="mesAcquisitions" id="mesAcquisitions" value="true">
						<label for="mesAcquisitions">Mes acquisitions</label>
					</div>
					<div class="form-group offset-sm-1">
						<input type="checkbox" name="autresEncheres" id="autresEncheres"value="true">
						<label for="autresEncheres">Autres encheres</label>
					</div>
				</div>
				<div class="form-group col-sm-8">
					<div class="form-group form-inline">
						<label class="col-sm-2" for="categories">Catégories : </label>
						<select class="form-control col-sm-6">
							<option value="toutes">Toutes</option>
							<c:forEach var="categorie" items ="${categories}">
								<option value="${categorie.libelle}">${categorie.libelle}</option>
							</c:forEach>	
						</select>
					</div>
					<div class="form-group">
						<input class="col-sm-8 form-control" type="search" id="recherche" name="recherche" placeholder="Le nom de l'article contient">
					</div>
				</div>
			</div>
			<div class="col-sm-5">
				<button class="btn btn-lg btn-block" type="submit">Rechercher</button>
			</div>
		</form>
	</div>
</body>

<div><p>Annulation enchère</p></div>
<div><p>Enchère en cours</p></div>
</body>

</html>