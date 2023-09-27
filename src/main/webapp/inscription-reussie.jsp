<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Inscription Réussie</title>
<!-- Bootstrap core CSS -->
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
<!-- Bootswatch theme -->
<link href="resources/css/lux.min.css" rel="stylesheet">
</head>
<body>

	<div class="container mt-5">
	    <div class="row justify-content-center">
	        <div class="col-md-8">
	            <div class="text-center">
	                <h2 class="mb-4">Bienvenue ${utilisateur.prenom}</h2>
	                <p class="mb-4">Votre Compte a été créé avec succès!</p>
	                <a href="connection" class="btn btn-primary mb-3">Connectez-vous</a>
	                <!-- retour pour tester mais devra être retiré -->
	                <div class="mt-5">
	                    <a href="inscription" class="btn btn-warning">RETOUR INSCRIPTION TESTS DEV</a>
	                </div>
	            </div>
	        </div>
	    </div>
	</div>

</body>
</html>
