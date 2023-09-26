<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Afficher Profil</title>
</head>
<body>
<header class="En-tête">
    <a href="accueil.jsp" target="_self">
    <img class="Logo" src="images/logo_eni_encheres2.png" alt="Logo ENI Enchères">
    </a>
    </header>

<h1>Profil de ${utilisateurConsulte.getPseudo()}</h1>
<p>Nom : ${utilisateurConsulte.getNom()}<p>
<p>Prénom : ${utilisateurConsulte.getPrenom()}<p>
<p>Email : ${utilisateurConsulte.getEmail()}<p>
<p>Teléphone : ${utilisateurConsulte.getTelephone()}<p>
<p>Rue : ${utilisateurConsulte.getRue()}<p>
<p>Code postal : ${utilisateurConsulte.getCodePostal()}
<p>Ville : ${utilisateurConsulte.getVille()}<p>


</body>
</html>