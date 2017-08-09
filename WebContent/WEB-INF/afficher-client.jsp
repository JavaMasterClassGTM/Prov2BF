<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
	
<!DOCTYPE html>
<html lang="fr">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Afficher informations client</title>

<!-- Bootstrap core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="css/signin.css" rel="stylesheet">

</head>

<body>

<style = "css/text"> 

td {
border:solid black 1px;
margin: 0 auto;
text-align: center;
}

#titres{
font-weight: bold;
background-color: grey;
color: white;

}

</style>

	<div class="container">

		<form method="POST" action="ControleurClient">
		

			<table style="width: 100%" style="border: solid black 1px">
			<tr id="titres">

					<td>Identifiant</td>
					<td>Nom</td>
					<td>Prénom</td>
					<td>Email</td>
					<td>Adresse</td>
					<td>Code Postal</td>
					<td>Ville</td>
					
				</tr>
			
								<tr>

					<td>${Client.idClient}</td>
					<td>${Client.nom} </td>
					<td>${Client.prenom}</td>
					<td>${Client.email}</td>
					<td>${Client.adresse}</td>
					<td>${Client.codePostal}</td>
					<td>${Client.ville}</td>

</tr>
</table>

			<center><a href="ReturnToOptions">Revenir au menu</a></center>
</body>
</html>