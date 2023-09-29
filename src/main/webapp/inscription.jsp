<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Inscription</title>
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
	    <div class="row justify-content-center">
	        <div class="col-md-8">
	            <h2 class="mb-4 text-center">Inscription</h2>
	            <form action="inscription" method="post" class="mb-4">
	
	                <div class="form-group">
	                    <label for="pseudo">Pseudo*</label>
	                    <input type="text" id="pseudo" name="pseudo" pattern="[a-zA-Z0-9]{3,30}" required title="3 à 30 caractères alphanumériques uniquement" class="form-control">
	                </div>
	
	                <div class="form-group">
	                    <label for="prenom">Prénom*</label>
	                    <input type="text" id="prenom" name="prenom" required maxlength="30" class="form-control" value="${prenomValue}">
	                </div>
	
	                <div class="form-group">
	                    <label for="telephone">Téléphone</label>
	                    <input type="tel" id="telephone" name="telephone" maxlength="15" class="form-control"value="${telephoneValue}">
	                </div>
	
	                <div class="form-group">
	                    <label for="codePostal">Code Postal*</label>
	                    <input type="text" id="codePostal" name="codePostal" required maxlength="10" class="form-control"value="${codePostalValue}">
	                </div>
	
	                <div class="form-group">
	                    <label for="nom">Nom*</label>
	                    <input type="text" id="nom" name="nom" required maxlength="30" class="form-control"value="${nomValue}">
	                </div>
	
	                <div class="form-group">
	                    <label for="email">Email*</label>
	                    <input type="email" id="email" name="email" required maxlength="20" class="form-control"value="${emailValue}">
	                </div>
	
	                <div class="form-group">
	                    <label for="rue">Rue*</label>
	                    <input type="text" id="rue" name="rue" required maxlength="30" class="form-control"value="${rueValue}">
	                </div>
	
	                <div class="form-group">
	                    <label for="ville">Ville*</label>
	                    <input type="text" id="ville" name="ville" required maxlength="30" class="form-control"value="${villeValue}">
	                </div>
	
	                <div class="form-group">
	                    <label for="motDePasse">Mot de passe*</label>
	                    <input type="password" id="motDePasse" name="motDePasse" required maxlength="30" class="form-control"value="${motDePasseValue}">
	                </div>
	
	                <div class="form-group">
	                    <label for="confirmation">Confirmation*</label>
	                    <input type="password" id="confirmation" name="confirmation" required maxlength="30" class="form-control"value="${confirmationValue}">
	                </div>
	
	                <div class="text-center">
	                    <button type="submit" class="btn btn-primary">Créer</button>
	                    <a href="accueil.jsp" class="btn btn-secondary">Annuler</a>
	                </div>
	
	            </form>
	            
	            <p class="text-danger text-center">
	                ${erreurFormulaire}${erreurEmail}${erreurPseudo}${erreurBD}
	            </p>
	        </div>
	    </div>
	</div>

	<!-- Bootstrap JS and jQuery -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
