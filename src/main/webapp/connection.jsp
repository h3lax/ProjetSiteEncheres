<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Page de connexion</title>
<!-- Bootstrap core CSS -->
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
<!-- Bootswatch theme -->
<link href="resources/css/lux.min.css" rel="stylesheet">
</head>
<body>

	<div class="container mt-5">
	    <div class="row justify-content-center">
	        <div class="col-md-6">
	            <h2 class="text-center mb-4">Connexion</h2>
	            <form action="connection" method="post" class="bg-light p-4 rounded">
	                <div class="form-group">
	                    <label for="id">Email ou Pseudo :</label>
	                    <input type="text" id="id" name="id" class="form-control">
	                </div>
	                <div class="form-group">
	                    <label for="mdp">Mot de passe :</label>
	                    <input type="password" id="mdp" name="mdp" class="form-control">
	                </div>
	                <div class="form-group">
	                    <input type="submit" value="Connexion" class="btn btn-primary btn-block">
	                </div>
	            </form>
	            <p class="text-danger text-center">${erreurID }</p>
	        </div>
	    </div>
	</div>

</body>
</html>
