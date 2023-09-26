<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Vendre un article</title>
</head>
<body>

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
	                <option value="1">Informatique</option>
	                <option value="2">Vêtement</option>
	                <option value="3">Ameublement</option>
	                <option value="4">Sport & Loisirs</option>
	            </select>
	        </div>
	        
        	<p><strong>Note :</strong> L'adresse de retrait utilisée sera votre adresse par défaut associée à votre compte.</p>

	        <div>
			    <label for="rue">Rue :</label>
			    <input type="text" id="rue" name="rue" value="${utilisateur.rue}" readonly>
			</div>
			<div>
			    <label for="codePostal">Code Postal :</label>
			    <input type="text" id="codePostal" name="codePostal" value="${utilisateur.codePostal}" readonly>
			</div>
			<div>
			    <label for="ville">Ville :</label>
			    <input type="text" id="ville" name="ville" value="${utilisateur.ville}" readonly>
			</div>
			
			 <div>
	            <input type="submit" value="Mettre en vente">
	        </div>	        
	    </form>
	</div>
	
</body>
</html>