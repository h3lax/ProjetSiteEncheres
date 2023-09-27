<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Vendre un article</title>
	<!-- Bootstrap core CSS -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <!-- Bootswatch theme -->
    <link href="resources/css/lux.min.css" rel="stylesheet">
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

  <div class="container mt-5">
        <p class="text-muted">${message}</p>
    
        <h2 class="mb-4 text-center">Nouvelle mise en vente d'article</h2>
        
        <div class="row">
        	<div class="col-lg-6 offset-lg-3">
        	
        		<form action="vendre" method="POST">
		            <div class="form-group">
		                <label for="nomArticle">Nom de l'article :</label>
		                <input type="text" class="form-control" id="nomArticle" name="nomArticle" required>
		            </div>
		
		            <div class="form-group">
		                <label for="description">Description :</label>
		                <textarea class="form-control" id="description" name="description" required></textarea>
		            </div>
		
		            <div class="form-group">
		                <label for="dateDebut">Date de début des enchères :</label>
		                <input type="datetime-local" class="form-control" id="dateDebut" name="dateDebutEncheres" required>
		            </div>
		
		            <div class="form-group">
		                <label for="dateFin">Date de fin des enchères :</label>
		                <input type="datetime-local" class="form-control" id="dateFin" name="dateFinEncheres" required>
		            </div>
		
		            <div class="form-group">
		                <label for="prixInitial">Prix initial (en points) :</label>
		                <input type="number" class="form-control" id="prixInitial" name="prixInitial" required>
		            </div>
		
		            <div class="form-group">
		                <label for="noCategorie">Catégorie :</label>
		                <select class="form-control" id="noCategorie" name="noCategorie">
		                    <option value="1">Informatique</option>
		                    <option value="2">Vêtement</option>
		                    <option value="3">Ameublement</option>
		                    <option value="4">Sport & Loisirs</option>
		                </select>
		            </div>
		            
		            <p class="text-muted"><strong>Note :</strong> L'adresse de retrait utilisée sera votre adresse par défaut associée à votre compte.</p>
		
		            <div class="form-group">
		                <label for="rue">Rue :</label>
		                <input type="text" class="form-control" id="rue" name="rue" value="${utilisateur.rue}" readonly>
		            </div>
		
		            <div class="form-group">
		                <label for="codePostal">Code Postal :</label>
		                <input type="text" class="form-control" id="codePostal" name="codePostal" value="${utilisateur.codePostal}" readonly>
		            </div>
		
		            <div class="form-group">
		                <label for="ville">Ville :</label>
		                <input type="text" class="form-control" id="ville" name="ville" value="${utilisateur.ville}" readonly>
		            </div>
		            
		            <div class="form-group">
		                <button type="submit" class="btn btn-primary">Mettre en vente</button>
		            </div>    
		        </form>
		        
        	</div>
        </div>
    </div>

	
</body>
</html>