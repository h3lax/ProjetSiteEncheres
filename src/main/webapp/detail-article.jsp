<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Détail de la vente</title>
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
        <div class="jumbotron pt-4 pb-4">
            <h1 class="display-6">Détail Vente</h1>
            <h2 class="display-7">${article.getNomArticle() }</h2>
            <hr class="my-4">
            <p class="lead">Description : ${article.getDescription()}</p>
            <ul class="list-group mb-4">
                <li class="list-group-item"><strong>Catégorie:</strong> ${article.getNoCategorie()}</li>
                <li class="list-group-item"><strong>Meilleure offre:</strong> ${article.getPrixVente()}</li>
                <li class="list-group-item"><strong>Mise à prix:</strong> ${article.getPrixInitial()}</li>
                <li class="list-group-item"><strong>Fin de l'enchère:</strong> ${article.getDateFinEncheres()}</li>
                <li class="list-group-item"><strong>Vendeur:</strong> ${vendeur.getPseudo()}</li>
            </ul>
            <form action="detail-article" method="post">
			    <input type="hidden" name="noArticle" value="${article.getNoArticle()}">
			    <label for="prixEnchere">Montant de votre enchère: </label>
			    <input type="number" id="prixEnchere" name="prixEnchere">
			    <button class="btn btn-primary">enchérir</button>
			</form>
            
            <p class="text-danger">${message}</p>
        </div>
    </div>

    <!-- Bootstrap JS and jQuery -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>

</html>
