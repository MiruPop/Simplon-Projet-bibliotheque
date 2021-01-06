<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Adherents bibliotheque</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css"
	integrity="sha512-+4zCK9k+qNFUR5X+cKL9EIR+ZOhtIloNl9GIKS57V1MyNsYpYcUrUeQc9vNfzsWfV28IaLL3i96P9sdNyeRssA=="
	crossorigin="anonymous" />
</head>
<body>
	<nav class="navbar navbar-expand-md navbar-dark"
		style="background-color: slategray; padding: 0px">
		<div class="container-fluid">
			<span class="navbar-brand mb-0 h1"><img
				style="padding-left: 5px" width="90"
				src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQLfdQ2FWNXNPU3-rL1xHiff0q9x-JYoX2xzA&usqp=CAU"></span>
			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/liste"
					class="nav-link aria-current active">Gestion adhérents</a></li>
				<li style="padding-left: 25px"><a
					href="<%=request.getContextPath()%>/liste" class="nav-link">Gestion
						livres</a></li>
			</ul>
		</div>
	</nav>
	<br>
	<div class="container">
		<h3 class="text-center">Liste des adhérents</h3>
		<hr>
		<br>
		<table class="table table-bordered  table-hover table-responsive">
			<thead>
				<tr style="background-color: lightgrey">
					<th>Matricule</th>
					<th>Nom</th>
					<th>Prenom</th>
					<th>Date naissance</th>
					<th>Adresse</th>
					<th>Téléphone</th>
					<th>Categ. professionnelle</th>
					<th>Date d'inscription</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="adherent" items="${liste}">
					<tr>
						<td><c:out value="${adherent.matricule}" /></td>
						<td><c:out value="${adherent.nom}" /></td>
						<td><c:out value="${adherent.prenom}" /></td>
						<td><c:out value="${adherent.dateNaiss}" /></td>
						<td><c:out value="${adherent.adresse}" /></td>
						<td><c:out value="${adherent.telephone}" /></td>
						<td><c:out value="${adherent.categPro}" /></td>
						<td><c:out value="${adherent.dateAdhesion}" /></td>
						<td><a href="ficheAdherent?matricule=<c:out value='${adherent.matricule}' />">
								<i class="fas fa-pen-square text-success"></i></a> &nbsp;&nbsp;
							<a href="desinscrire?matricule=<c:out value='${adherent.matricule}' />">
								<i class="fas fa-trash-alt text-danger"></i></a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<div class="container text-left">
		<a href="<%=request.getContextPath()%>/ficheInscription"
			class="btn btn-success">Inscription adhérent</a>
	</div>

</body>
</html>