<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Mon Profil</title>
</head>
<header class="En-tête">
    <a href="accueil.jsp" target="_self">
    <img class="Logo" src="images/logo_eni_encheres2.png" alt="Logo ENI Enchères">
    </a>
    </header>
<body>

<h1>Profil de ${utilisateur.getPseudo()}</h1>
<p>Nom : ${utilisateur.getNom()}<p>
<p>Prénom : ${utilisateur.getPrenom()}<p>
<p>Email : ${utilisateur.getEmail()}<p>
<p>Teléphone : ${utilisateur.getTelephone()}<p>
<p>Rue : ${utilisateur.getRue()}<p>
<p>Code postal : ${utilisateur.getCodePostal()}
<p>Ville : ${utilisateur.getVille()}<p>
<p>Crédit : ${utilisateur.getCredit()} point(s)<p>

<form action="mon-profil" method="post">
<button type="submit">Modifier</button>
</form>

</body>
</html>