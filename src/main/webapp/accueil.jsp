<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Site Vente aux Enchères ENI</title>
    <!-- Bootstrap core CSS -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <!-- Bootswatch theme -->
    <link href="resources/css/lux.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
    <!-- Lien css -->
    <link href="accueil.css" rel="stylesheet">
</head>
<body>

	<nav class="navbar navbar-expand-lg navbar-dark bg-dark py-2">
	    <div class="container-fluid">
	        <a class="navbar-brand ml-3" href="accueil">
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
                          <a class="nav-link btn ml-2" href="article-vendu">
                            <i class="fas fa-tags"></i> Mettre un article en vente
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
	
	<h2 class="text-center mt-4">Liste des enchères</h2>
	
	<div class="container">
	    <div class="mb-4">
	        <h4>Filtres :</h4>
	        <input id="searchbar" type="text" name="search" placeholder="Le nom de l'article contient" class="form-control mb-2">
	        <form action="" method="post" class="mb-2">
	            <label for="liste">Catégorie :</label>
	            <input type="text" list="listeChoix" name="liste" id="liste" placeholder="Toutes" class="form-control">
	            <datalist id="listeChoix">
	                <option>Toutes</option>
	                <option>Informatique</option>
	                <option>Vêtement</option>
	                <option>Ameublement</option>
	                <option>Sport & Loisirs</option>
	            </datalist>
	        </form>
	        <button class="btn btn-success">Rechercher</button>
	    </div>
	    
	    <div class="row">
	        <c:forEach items="${listeEncheres}" var="enchere" varStatus="loop">
			    <div class="col-md-6 mb-4 mt-4">
			        <a href="detail-article?noArticle=${enchere.noArticle}" class="card-link text-decoration-none">
			            <div class="card shadow border-0 hover-shadow">
			                <img src="path_to_image_or_placeholder.jpg" alt="" class="card-img-top">
			                <div class="card-body">
			                    <h4 class="card-title">${enchere.nomArticle}</h4>
			                    <p class="card-text"><strong>Prix :</strong> ${enchere.prixInitial} points</p>
			                    <p class="card-text">
								    <strong>Fin de l'enchère :</strong>
								    ${fn:substring(enchere.dateFinEncheres, 8, 10)}/
								    ${fn:substring(enchere.dateFinEncheres, 5, 7)}/
								    ${fn:substring(enchere.dateFinEncheres, 0, 4)}
								</p>
			                    <p class="card-text"><strong>Vendeur :</strong> ${pseudosVendeurs[loop.index]}</p>
			                </div>
			            </div>
			        </a>
			    </div>
			    
			    <c:if test="${loop.index % 2 == 1}">
			        </div><div class="row">
			    </c:if>
			</c:forEach>
	    </div>
	</div>

<!-- Bootstrap JS and jQuery -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</body>
</html>
