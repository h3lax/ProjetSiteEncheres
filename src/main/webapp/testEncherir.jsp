<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Test Encherir</title>
</head>
<body>

<form action="encherir" method="post">

<label for="prixEnchere">Montant de votre enchère: </label><input type="number" id="prixEnchere" name="prixEnchere">
<button>enchérir</button>
</form>
<p>${message }<p>

</body>
</html>