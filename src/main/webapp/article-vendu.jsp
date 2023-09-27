<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Vendre un article</title>
	<!-- Bootstrap core CSS -->
  <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
  <!-- Bootswatch theme -->
  <link href="resources/css/lux.min.css" rel="stylesheet">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
</head>
<body>

	<nav class="navbar navbar-expand-lg navbar-dark bg-dark py-2">
	    <div class="container-fluid">
	        <a class="navbar-brand ml-3" href="#">
			    <img src="resources/images/logo_eni_encheres.png" alt="Logo ENI-Enchères" width="80" height="80" class="d-inline-block align-top">
			</a>

	        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
	            <span class="navbar-toggler-icon"></span>
	        </button>
	        <div class="collapse navbar-collapse" id="navbarNav">
	            <ul class="navbar-nav ml-auto">
	                <c:if test="${sessionScope.utilisateur == null }">
	                    <li class="nav-item">
	                        <a class="nav-link btn" href="connection">
	                        	<i class="fas fa-sign-in-alt"></i> Connexion
                        	</a>
	                    </li>
	                    <li class="nav-item">
	                        <a class="nav-link btn ml-2" href="inscription">
                        		<i class="fas fa-user-plus"></i> Inscription
                        	</a>
	                    </li>
	                </c:if>
	                <c:if test="${sessionScope.utilisateur !=null }">
	                    <li class="nav-item">
	                        <a class="nav-link btn" href="mon-profil">
	                        	<i class="fas fa-user"></i> Mon profil
                        	</a>
	                    </li>
	                    <li class="nav-item">
	                        <a class="nav-link btn ml-2" href="deconnection">
	                        	<i class="fas fa-sign-out-alt"></i> Deconnexion
                        	</a>
	                    </li>
	                </c:if>
	            </ul>
	        </div>
	    </div>
	</nav>

  <div class="container mt-5">
        <p class="text-muted">${message}</p>
    
        <h2 class="mb-4 text-center">Nouvelle mise en vente d'article</h2>
        
        <div class="row">
        	<div class="col-lg-6 offset-lg-3">
        	
        		<form action="article-vendu" method="POST">
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

  <!-- Bootstrap JS and jQuery -->
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>