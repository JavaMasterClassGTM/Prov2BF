<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	


<!DOCTYPE html>
<html lang="fr">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Recherche client</title>

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


				</tr>
				<tr>
					<td><input type="text" name="nom"/></td>
				</tr>
			</table>
			<br/>
			<input type="submit" name="submit2" value="Validation"></input>

		</form>
	</div>
	
			<center><a href="ReturnToOptions">Revenir au menu</a></center>
</body>
</html>