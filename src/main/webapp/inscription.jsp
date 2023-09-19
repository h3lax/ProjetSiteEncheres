<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Page Inscription</title>
</head>
<body>
	<h1>ENI-Enchères</h1>
	
	<h2>Mon profil</h2>
		<form action="inscription" method="post">
			
			<div>
			<label for="pseudo">Pseudo :</label><input type="text" id="pseudo" name="pseudo">
			<label for="prenom">Prénom : </label><input type="text" id="prenom" name="prenom">
			<label for="telephone">Téléphone :</label><input type="tel" id="telephone" name="telephone">
			<label for="codePostal">Code Postal :</label><input type="text" id="codePostal" name="codePostal">
			<label for="motDePasse">Mot de passe :</label><input type="password" id="motDePasse" name="motDePasse">
			</div>
			
			<div>
			<label for="nom">Nom :</label><input type="text" id="nom" name="nom">
			<label for="email">Email :</label><input type="email" id="email" name="email">
			<label for="rue">Rue :</label><input type="text" id="rue" name="rue">
			<label for="ville">Ville :</label><input type="text" id="ville" name="ville">
			<label for="confirmation">Confirmation :</label><input type="password" id="confirmation" name="confirmation">
			</div>
			<p> ${erreurConfirmation }<p>
			
			<button type="submit">Créer</button><a href="#">Annuler</a>
			
		
		
		</form>


</body>
</html>