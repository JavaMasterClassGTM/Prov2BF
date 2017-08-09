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
			<table style="width: 100%" style="border:solid black 1px">
			<tr id="titres">
					<td>Identifiant</td>
					<td>Nom</td>
					<td>Prénom</td>
					<td>Email</td>
					<td>Adresse</td>
					<td>Code Postal</td>
					<td>Ville</td>
					<td>Comptes clients</td>
					<td>Modifier informations clients</td>
					<td>Effectuer un virement</td>


				</tr>
			
			<c:forEach items="${Liste}" var="l">
								<tr>
					<td>${l.idClient}</td>
					<td>${l.nom} </td>
					<td>${l.prenom}</td>
					<td>${l.email}</td>
					<td>${l.adresse}</td>
					<td>${l.codePostal}</td>
					<td>${l.ville}</td>
					<td/><form method="post" action="ControleurClient"><input type="HIDDEN" name="nom" value="${l.nom}"/><input type="submit" name="submit2" value="Rechercher"/></form></td>
					<td><form method="post" action="ControleurClient"><input type="HIDDEN" name="nom" value="${l.nom}"/><input type="submit" name="submit2" value="Validez"/></form></td>
					<td><form method="post" action="ControleurClient"><input type="HIDDEN" name="debiteur" value="${l.idcc}"/><input type="HIDDEN" name="crediteur" value="${l.idce}"/><input type="text" name="montant" placeholder="Montant"/><input type="submit" name="submit" value="Effectuer le virement"/></form></td>

				</tr>
				
				</c:forEach>
			</table>
			<br/>
			<center><a href="ReturnToOptions">Revenir au menu</a></center>

</body>
</html>