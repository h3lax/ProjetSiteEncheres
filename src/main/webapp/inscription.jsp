<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Inscription</title>
</head>
<body>
<header class="En-tête">
    <a href="accueil.jsp" target="_self">
    <img class="Logo" src="images/logo_eni_encheres2.png" alt="Logo ENI Enchères">
    </a>
    </header>
	<h1>Mon profil</h1>
		<form action="inscription" method="post">
			
			<div>
			<label for="pseudo">Pseudo* :</label><input type="text" id="pseudo" name="pseudo" pattern="[a-zA-Z0-9]{3,30}" required title="3 à 30 caractères alphanumériques uniquement">
			<label for="prenom">Prénom* : </label><input type="text" id="prenom" name="prenom" required maxlength="30">
			<label for="telephone">Téléphone :</label><input type="tel" id="telephone" name="telephone" maxlength="15">
			<label for="codePostal">Code Postal* :</label><input type="text" id="codePostal" name="codePostal" required maxlength="10">
			<label for="motDePasse">Mot de passe* :</label><input type="password" id="motDePasse" name="motDePasse" required maxlength="30">
			</div>
			
			<div>
			<label for="nom">Nom* :</label><input type="text" id="nom" name="nom" required maxlength="30">
			<label for="email">Email* :</label><input type="email" id="email" name="email" required maxlength="20">
			<label for="rue">Rue* :</label><input type="text" id="rue" name="rue" required maxlength="30">
			<label for="ville">Ville* :</label><input type="text" id="ville" name="ville" required maxlength="30">
			<label for="confirmation">Confirmation* :</label><input type="password" id="confirmation" name="confirmation" required maxlength="30">
			</div>
			<p> ${erreurFormulaire}${erreurEmail}${erreurPseudo}${erreurBD}<p>
			
			<button type="submit">Créer</button><a href="#">Annuler</a>
			
		
		
		</form>


</body>
</html>