<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Inscription</title>
<!-- Bootstrap core CSS -->
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
<!-- Bootswatch theme -->
<link href="resources/css/lux.min.css" rel="stylesheet">
</head>
<body>

	<div class="container mt-5">
	    <div class="row justify-content-center">
	        <div class="col-md-8">
	            <h2 class="mb-4 text-center">Mon profil</h2>
	            <form action="inscription" method="post" class="mb-4">
	
	                <div class="form-group">
	                    <label for="pseudo">Pseudo*</label>
	                    <input type="text" id="pseudo" name="pseudo" pattern="[a-zA-Z0-9]{3,30}" required title="3 à 30 caractères alphanumériques uniquement" class="form-control">
	                </div>
	
	                <div class="form-group">
	                    <label for="prenom">Prénom*</label>
	                    <input type="text" id="prenom" name="prenom" required maxlength="30" class="form-control">
	                </div>
	
	                <div class="form-group">
	                    <label for="telephone">Téléphone</label>
	                    <input type="tel" id="telephone" name="telephone" maxlength="15" class="form-control">
	                </div>
	
	                <div class="form-group">
	                    <label for="codePostal">Code Postal*</label>
	                    <input type="text" id="codePostal" name="codePostal" required maxlength="10" class="form-control">
	                </div>
	
	                <div class="form-group">
	                    <label for="nom">Nom*</label>
	                    <input type="text" id="nom" name="nom" required maxlength="30" class="form-control">
	                </div>
	
	                <div class="form-group">
	                    <label for="email">Email*</label>
	                    <input type="email" id="email" name="email" required maxlength="20" class="form-control">
	                </div>
	
	                <div class="form-group">
	                    <label for="rue">Rue*</label>
	                    <input type="text" id="rue" name="rue" required maxlength="30" class="form-control">
	                </div>
	
	                <div class="form-group">
	                    <label for="ville">Ville*</label>
	                    <input type="text" id="ville" name="ville" required maxlength="30" class="form-control">
	                </div>
	
	                <div class="form-group">
	                    <label for="motDePasse">Mot de passe*</label>
	                    <input type="password" id="motDePasse" name="motDePasse" required maxlength="30" class="form-control">
	                </div>
	
	                <div class="form-group">
	                    <label for="confirmation">Confirmation*</label>
	                    <input type="password" id="confirmation" name="confirmation" required maxlength="30" class="form-control">
	                </div>
	
	                <div class="text-center">
	                    <button type="submit" class="btn btn-primary">Créer</button>
	                    <a href="#" class="btn btn-secondary">Annuler</a>
	                </div>
	
	            </form>
	            
	            <p class="text-danger text-center">
	                ${erreurFormulaire}${erreurEmail}${erreurPseudo}${erreurBD}
	            </p>
	        </div>
	    </div>
	</div>

</body>
</html>
