<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Vendre un article</title>
</head>
<body>

	<header>
	 <a href="accueil.jsp" target="_self">
    <img class="Logo" src="images/logo_eni_encheres2.png" alt="Logo ENI Enchères">
    </a>
	<div class="Connexion">
	
	<a href="deconnection">Deconnection</a>
	<a href="mon-profil">Mon profil</a>
	</div>
	</header>

	<div>
		<p>${message}</p>
	
		<h2>Nouvelle mise en vente d'article</h2>
		 
	    <form action="ArticleVenduServlet" method="POST">
	        <div>
	            <label for="nomArticle">Nom de l'article :</label>
	            <input type="text" id="nomArticle" name="nomArticle" required>
	        </div>
	        <div>
	            <label for="description">Description :</label>
	            <textarea id="description" name="description" required></textarea>
	        </div>
	        <div>
	            <label for="dateDebut">Date de début des enchères :</label>
	            <input type="datetime-local" id="dateDebut" name="dateDebutEncheres" required>
	        </div>
	        <div>
	            <label for="dateFin">Date de fin des enchères :</label>
	            <input type="datetime-local" id="dateFin" name="dateFinEncheres" required>
	        </div>
	        <div>
	            <label for="prixInitial">Prix initial (en points) :</label>
	            <input type="number" id="prixInitial" name="prixInitial" required>
	        </div>
	        <div>
	            <label for="noCategorie">Catégorie :</label>
	            <select id="noCategorie" name="noCategorie">
	                <option value="1">Electronique</option>
	                <option value="2">Vêtements</option>
	                <option value="3">Maison & Jardin</option>
	                <option value="4">Livres & Musique</option>
	                <option value="5">Sport & Loisirs</option>
	            </select>
	        </div>
	        <div>
	            <input type="submit" value="Mettre en vente">
	        </div>
	    </form>
	</div>
	
</body>
</html>