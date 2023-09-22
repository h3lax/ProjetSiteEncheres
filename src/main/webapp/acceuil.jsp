<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Page d'acceuil</title>
</head>
<body>
	<h1>Bienvenue sur la page d'acceuil du site Eni Encheres</h1>

	<h1>Menu</h1>
	<c:if test="${sessionScope.utilisateur ==null }">
		<a href="connection">Connection</a>
	</c:if>
	<c:if test="${sessionScope.utilisateur !=null }">
		<a href="deconnection">Deconnection</a>
	</c:if>



	<h2>Pas encore inscrit ?</h2>
	<a href="inscription"> Par ici</a>
	
	<h3>Supprimer son compte</h3>
	<a href="suppression"> Par ici</a>


</body>
</html>