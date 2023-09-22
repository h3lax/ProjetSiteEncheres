<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modifier mon profil</title>
</head>
<body>
	<h1>Mon profil</h1>
		<form action="modifier-profil" method="post">
			
			<div>
			<label for="pseudo">Pseudo :</label><input type="text" id="pseudo" name="pseudo" pattern="[a-zA-Z0-9]{3,30}" title="3 à 30 caractères alphanumériques uniquement">
			<label for="prenom">Prénom : </label><input type="text" id="prenom" name="prenom" maxlength="30">
			<label for="telephone">Téléphone :</label><input type="tel" id="telephone" name="telephone" maxlength="15">
			<label for="codePostal">Code Postal :</label><input type="text" id="codePostal" name="codePostal" maxlength="10">
			<label for="motDePasseActuel">Mot de passe actuel :</label><input type="password" id="motDePasseActuel" name="motDePasseActuel" maxlength="30">
			<label for="nouveauMotDePasse">Nouveau mot de passe :</label><input type="password" id="nouveauMotDePasse" name="nouveauMotDePasse" maxlength="30">
			</div>
			
			<div>
			<label for="nom">Nom :</label><input type="text" id="nom" name="nom" maxlength="30">
			<label for="email">Email :</label><input type="email" id="email" name="email" maxlength="20">
			<label for="rue">Rue :</label><input type="text" id="rue" name="rue" maxlength="30">
			<label for="ville">Ville :</label><input type="text" id="ville" name="ville" maxlength="30">
			<label for="confirmation">Confirmation :</label><input type="password" id="confirmation" name="confirmation" maxlength="30">
			</div>
			<p> ${erreurIdentifiant}${erreurMdp}<p>
			
			<a href="#">Annuler</a><button type="submit" value="enregistrer" name="action">Enregistrer</button><button type="submit" value="supprimer" name="action">Supprimer mon compte</button>
			
		
		
		</form>



</body>
</html>