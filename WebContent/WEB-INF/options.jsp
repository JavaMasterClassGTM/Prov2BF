<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>Outils métiers</title>

<!-- Bootstrap core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<link href="/css/ie10-viewport-bug-workaround.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="theme.css" rel="stylesheet">


</head>
<body>
	<center>
		<div class="jumbotron">
			<h3>Cliquez sur l'option de votre choix</h3>
		</div>
		<form method="POST" action="ControleurClient">
			<p>
				<button type="submit" class="btn btn-lg btn-primary"
					name="listeClients" value="1">Liste de mes clients</button>
				<button type="submit" class="btn btn-lg btn-success"
					name="modifClients" value="8">Modifier les informations
					d'un client</button>
				<button type="submit" class="btn btn-lg btn-info"
					name="listeComptes" value="3">Liste des comptes d'un
					client</button>
				<button type="submit" class="btn btn-lg btn-warning"
					name="effectuerVirement" value="4">Effectuer un virement</button>
				<button type="submit" class="btn btn-lg btn-active"
					name="afficherClient" value="6">
					Afficher client
				</button>
				<button type="submit" class="btn btn-lg btn-danger"
					name="seDeconnecter" value="5">Déconnexion</button>
		</form>
	</center>
</body>
</html>