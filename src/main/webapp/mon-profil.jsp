<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Mon Profil</title>
</head>
<body>

<h1>Profil de ${utilisateur.getPseudo()}</h1>
<p>Nom : ${utilisateur.getNom()}<p>
<p>Prénom : ${utilisateur.getPrenom()}<p>
<p>Email : ${utilisateur.getEmail()}<p>
<p>Teléphone : ${utilisateur.getTelephone()}<p>
<p>Rue : ${utilisateur.getRue()}<p>
<p>Code postal : ${utilisateur.getCodePostal()}
<p>Ville : ${utilisateur.getVille()}<p>

<form action="mon-profil" method="post">
<button type="submit">Modifier</button>
</form>

</body>
</html>