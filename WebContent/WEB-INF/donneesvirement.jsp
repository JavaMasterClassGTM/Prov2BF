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
			<table style="width: 60%" style="border: solid black 1px">
				<tr>
					<th>Numéro de compte à débiter:</th>
					<th>Numéro de compte à créditer:</th>
					<th>Montant du virement:</th>

				</tr>
				<tr>
					<td><input type="text" name="debiteur"/></td>
					<td><input type="text" name="crediteur"/></td>
					<td><input type="text" name="montant" /></td>
				</tr>
			</table>
			<br/>
			<input type="submit" name="submit" value="Effectuer le virement"></input>
			<center><a href="ReturnToOptions">Revenir au menu</a></center>
		</form>
	</div>
</body>
</html>