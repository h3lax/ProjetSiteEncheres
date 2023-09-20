<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Page de connection</title>
</head>
<body>
		<form action="connection" method="post">
		<label for="id">Email ou Pseudo :</label>
		<input type="text" id="id" name="id"><br> 
		
		<label for="mdp">Mot de passe :</label>
		<input type="password" id="mdp" name="mdp"><br>
		
		<input type="submit" value="Connection">

		</form>
</body>
</html>