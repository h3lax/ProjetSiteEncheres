<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Site Vente aux Enchères ENI</title>
<link href="" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
<link rel="stylesheet" href="accueil.css">
</head>
<body>

    <header class="En-tête">
        <h2 class="NomSite">ENI-Enchères</h2>
        <div class="Connexion"><a href="inscription.jsp">S'inscrire - Se connecter</a></div>
    </header>

    <h2 class="NomPage">Liste des enchères</h2>
    <br>
    <div class="Recherche">
        <h4 class="Filtres">Filtres : </h4>
        <input id="searchbar" type="text"
        name="search" placeholder="Le nom de l'article contient">
        <br>
        <br>
        <form action="" method="post">
            <label for="liste">Catégorie : </label>
            <input type="text" list="listeChoix" name="liste" id="liste"
            placeholder="Toutes">
            <datalist id="listeChoix">
                <option>Toutes</option>
                <option>Ameublement</option>
                <option>Informatique</option>
                <option>Sport & Loisirs</option>
                <option>Vêtement</option>
            </datalist>
        </form>
    </div>
    <br>
    <br>
    <button class="Rechercher">Rechercher</button>
    <br>
    <br>
    <br>
    <br>
    <div class="Enchères">
       <fieldset class="Article1">
            <div class="ImgEtDescription">
                <img class="ImgArticle1" src="../webapp/IMG/pc_gamer.jpg" alt="pc Gamer">
                <div class="Description">
                    <h4 class="NomArticle">PC Gamer pour travailler</h4>
                    <br>
                    <p>Prix : 210 points</p>
                    <p>Fin de l'enchère : 10/08/2018</p>
                    <p>Vendeur : jojo44</p>
                </div>
            </div>
       </fieldset>
       <fieldset class="Article2">
            <div class="ImgEtDescription">
                <img class="ImgArticle2" src="../webapp/IMG/Rocket_Stove.webp" alt="Rocket stove">
                <div class="Description">
                    <h4 class="NomArticle">Rocket stove pour riz et pâtes</h4>
                    <br>
                    <p>Prix : 185 points</p>
                    <p>Fin de l'enchère : 09/10/2018</p>
                    <p>Vendeur : NineJea</p>
                </div>
            </div>
       </fieldset>
    </div>
</body>
</html>