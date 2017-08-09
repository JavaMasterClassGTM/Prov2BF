<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
	
<!DOCTYPE html>
<html lang="fr">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Liste de mes clients</title>

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
		
		<h4>Comptes de ${Client.prenom} ${Client.nom}</h4>
		<h5>Compte Courant</h5>
			<table style="width: 100%" style="border: solid black 1px">
			<tr id="titres">

					<td>Solde</td>
					<td>Date d'ouverture</td>
					<td>Numéro de compte</td>

				</tr>
			
								<tr>

					<td>${cc.soldeCompte} euros</td>
					<td>${cc.dateOuverture} </td>
					<td>${cc.numeroCompte}</td>


				</tr>
				
			</table>
	<h5>Compte Epargne</h5>
	
						<table style="width: 100%" style="border: solid black 1px">
			<tr id="titres">


					<td>Solde</td>
					<td>Date d'ouverture</td>
					<td>Numéro de compte</td>


				</tr>

								<tr>
					<td>${ce.soldeCompte} euros</td>
					<td>${ce.dateOuverture}</td>
					<td>${ce.numeroCompte}</td>

				</tr>
				
			</table>
			<br/>
			<center><a href="ReturnToOptions">Revenir au menu</a></center>



</body>
</html>