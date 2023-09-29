<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Afficher Profil</title>
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

	<div class="container mt-5">
	    <h1 class="text-center mb-4">Profil de ${utilisateurConsulte.getPseudo()}</h1>
	    <div class="list-group">
	        <div class="list-group-item"><strong>Nom :</strong> ${utilisateurConsulte.getNom()}</div>
	        <div class="list-group-item"><strong>Prénom :</strong> ${utilisateurConsulte.getPrenom()}</div>
	        <div class="list-group-item"><strong>Email :</strong> ${utilisateurConsulte.getEmail()}</div>
	        <div class="list-group-item"><strong>Téléphone :</strong> ${utilisateurConsulte.getTelephone()}</div>
	        <div class="list-group-item"><strong>Rue :</strong> ${utilisateurConsulte.getRue()}</div>
	        <div class="list-group-item"><strong>Code postal :</strong> ${utilisateurConsulte.getCodePostal()}</div>
	        <div class="list-group-item"><strong>Ville :</strong> ${utilisateurConsulte.getVille()}</div>
	    </div>
	</div>

	<!-- Bootstrap JS and jQuery -->
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
