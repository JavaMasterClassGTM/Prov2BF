<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	


<!DOCTYPE html>
<html lang="fr">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Modifier les informations client</title>

<!-- Bootstrap core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="css/signin.css" rel="stylesheet">

</head>

<body>

	<div class="container">


		<form method="POST" action="ControleurClient">
			<table style="width: 40%">
				<tr>
					<th>Nom</th>
					<th>Prénom</th>
					<th>Email</th>
					<th>Adresse</th>
					<th>Code Postal</th>
					<th>Ville</th>

				</tr>
				<tr>
					<td><input type="text" name="nom" value="${Client.nom}"/></td>
					<td><input type="text" name="prenom" value="${Client.prenom}" /></td>
					<td><input type="text" name="email" value="${Client.email}"/></td>
					<td><input type="text" name="adresse" value="${Client.adresse}"/></td>
					<td><input type="text" name="codepostal" value="${Client.codePostal}"/></td>
					<td><input type="text" name="ville" value="${Client.ville}"/></td>
				</tr>
			</table>
			<br/>
			<input type="submit" name="submit" value="Valider"></input>
			<center><a href="ReturnToOptions">Revenir au menu</a></center>
		</form>
	</div>
</body>
</html>