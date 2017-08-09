<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="fr">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Authentification Conseiller</title>

    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css/signin.css" rel="stylesheet">
 
  </head>

  <body>

    <div class="container">


	<form action="ControleurLogin" method="POST">
		<h4>Cher conseiller, vos identifiant et/ou mot de passe sont
			erroné(s), veuillez réessayer</h4>
		
        <label for="inputLogin" class="sr-only">Identifiant</label>
        <input type="text" id="inputLogin" class="form-control" name="login" placeholder="Identifiant" required autofocus>
        
        <label for="inputPwd" class="sr-only">Mot de passe</label>
        <input type="password" id="inputPwd" class="form-control" name="pwd" placeholder="Mot de passe" required>
        
        <div class="checkbox">
          <label>
            <input type="checkbox" value="remember-me"> Remember me
          </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit" name="submit">Se connecter</button>
      </form>

    </div> <!-- /container -->

  </body>
</html>
