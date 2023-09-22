<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Page de suppression</title>
</head>
<body>
	<h1> Pour supprimer votre compte remplir les champs suivants: </h1>
	
	
	<form action="suppression" method="post">
        <label for="email">Email :</label>
        <input type="email" id="email" name="email" required><br><br>
        
        <label for="motDePasse">Mot de passe :</label>
        <input type="password" id="motDePasse" name="motDePasse" required><br><br>
        
        <input type="submit" value="Supprimer son compte">
        
        <c:if test="${not empty confirmationMessage}">
            <p>${confirmationMessage}</p>
        </c:if>
        
        
	 </form>
</body>
</html>