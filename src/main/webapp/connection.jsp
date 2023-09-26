<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Page de connection</title>
</head>
<body>
<header class="En-tête">
    <a href="accueil.jsp" target="_self">
    <img class="Logo" src="images/logo_eni_encheres2.png" alt="Logo ENI Enchères">
    </a>
    </header>
		<form action="connection" method="post">
		<label for="id">Email ou Pseudo :</label>
		<input type="text" id="id" name="id"><br> 
		
		<label for="mdp">Mot de passe :</label>
		<input type="password" id="mdp" name="mdp"><br>
		
		<input type="submit" value="Connection">

		</form>
		<p>${erreurID }<p>
</body>
</html>