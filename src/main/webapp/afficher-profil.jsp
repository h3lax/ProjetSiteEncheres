<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Afficher Profil</title>
<!-- Bootstrap core CSS -->
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
<!-- Bootswatch theme -->
<link href="resources/css/lux.min.css" rel="stylesheet">
</head>
<body>

	<div class="container mt-5">
	    <h1 class="text-center mb-4">Profil de ${utilisateurConsulte.getPseudo()}</h1>
	    <div class="list-group">
	        <div class="list-group-item"><strong>Nom :</strong> ${utilisateurConsulte.getNom()}</div>
	        <div class="list-group-item"><strong>Prénom :</strong> ${utilisateurConsulte.getPrenom()}</div>
	        <div class="list-group-item"><strong>Email :</strong> ${utilisateurConsulte.getEmail()}</div>
	        <div class="list-group-item"><strong>Téléphone :</strong> ${utilisateurConsulte.getTelephone()}</div>
	        <div class="list-group-item"><strong>Rue :</strong> ${utilisateurConsulte.getRue()}</div>
	        <div class="list-group-item"><strong>Code postal :</strong> ${utilisateurConsulte.getCodePostal()}</div>
	        <div class="list-group-item"><strong>Ville :</strong> ${utilisateurConsulte.getVille()}</div>
	    </div>
	</div>

</body>
</html>
