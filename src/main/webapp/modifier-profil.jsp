<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Modifier mon profil</title>
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
        <h1 class="mb-4">Mon profil</h1>
        <form action="modifier-profil" method="post" class="border p-4">
            <div class="form-row">
                <div class="form-group col-md-6">
                    <label for="pseudo">Pseudo :</label>
                    <input type="text" id="pseudo" name="pseudo" pattern="[a-zA-Z0-9]{3,30}" title="3 à 30 caractères alphanumériques uniquement" class="form-control">
                </div>
                <div class="form-group col-md-6">
                    <label for="nom">Nom :</label>
                    <input type="text" id="nom" name="nom" maxlength="30" value="${utilisateur.nom}" class="form-control">
                </div>
            </div>

            <div class="form-row">
                <div class="form-group col-md-6">
                    <label for="prenom">Prénom :</label>
                    <input type="text" id="prenom" name="prenom" maxlength="30" value="${utilisateur.prenom}" class="form-control">
                </div>
                <div class="form-group col-md-6">
                    <label for="email">Email :</label>
                    <input type="email" id="email" name="email" maxlength="20" value="${utilisateur.email}" class="form-control">
                </div>
            </div>

            <div class="form-row">
                <div class="form-group col-md-6">
                    <label for="telephone">Téléphone :</label>
                    <input type="tel" id="telephone" name="telephone" maxlength="15" value="${utilisateur.telephone}" class="form-control">
                </div>
                <div class="form-group col-md-6">
                    <label for="rue">Rue :</label>
                    <input type="text" id="rue" name="rue" maxlength="30" value="${utilisateur.rue}" class="form-control">
                </div>
            </div>

            <div class="form-row">
                <div class="form-group col-md-6">
                    <label for="codePostal">Code Postal :</label>
                    <input type="text" id="codePostal" name="codePostal" maxlength="10" value="${utilisateur.codePostal}" class="form-control">
                </div>
                <div class="form-group col-md-6">
                    <label for="ville">Ville :</label>
                    <input type="text" id="ville" name="ville" maxlength="30" value="${utilisateur.ville}" class="form-control">
                </div>
            </div>

            <div class="form-row">
                <div class="form-group col-md-6">
                    <label for="motDePasseActuel">Mot de passe actuel :</label>
                    <input type="password" id="motDePasseActuel" name="motDePasseActuel" maxlength="30" class="form-control">
                </div>
                <div class="form-group col-md-6">
                    <label for="nouveauMotDePasse">Nouveau mot de passe :</label>
                    <input type="password" id="nouveauMotDePasse" name="nouveauMotDePasse" maxlength="30" class="form-control">
                </div>
            </div>

            <div class="form-group">
                <label for="confirmation">Confirmation :</label>
                <input type="password" id="confirmation" name="confirmation" maxlength="30" class="form-control">
            </div>

            <p class="text-danger"> ${erreurIdentifiant}${erreurMdp}<p>
            
            <a href="accueil.jsp" class="btn btn-secondary">Annuler</a>
            <button type="submit" value="enregistrer" name="action" class="btn btn-primary">Enregistrer</button>
            <button type="submit" value="supprimer" name="action" class="btn btn-danger">Supprimer mon compte</button>
        </form>
    </div>

	<!-- Bootstrap JS and jQuery -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>