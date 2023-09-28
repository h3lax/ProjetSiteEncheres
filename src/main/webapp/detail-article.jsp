<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Détail de la vente</title>
</head>
<body>

<h1>Détail Vente</h1>
<h2>${article.getNomArticle() }</h2>
<p>Description : ${article.getDescription()}<p>
<p>Catégorie : ${article.getNoCategorie()}<p>
<p>Meilleure offre : ${article.getPrixVente()}<p>
<p>Mise à prix : ${article.getPrixInitial()}<p>
<p>Fin de l'enchère : ${article.getDateFinEncheres()}<p>
<p>Il manque le retrait dans l'article<p>
<p>Vendeur : ${vendeur.getPseudo()}<p>


<form action="detail-article" method="post">
<label for="prixEnchere">Montant de votre enchère: </label><input type="number" id="prixEnchere" name="prixEnchere">
<button>enchérir</button>
</form>

<p>${message}<p>

</body>
</html>