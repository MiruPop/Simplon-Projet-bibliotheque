<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Fiche adherent</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>
	<nav class="navbar navbar-expand-md navbar-dark"
		style="background-color: slategray; padding: 0px">
		<div class="container-fluid">
		<span class="navbar-brand mb-0 h1"><img style="padding-left: 5px" width="90"
			src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQLfdQ2FWNXNPU3-rL1xHiff0q9x-JYoX2xzA&usqp=CAU"></span>
		<ul class="navbar-nav">
			<li><a
				href="<%=request.getContextPath()%>/liste" class="nav-link aria-current active">Gestion
					adhérents</a></li>
			<li style="padding-left: 25px"><a
				href="<%=request.getContextPath()%>/liste" class="nav-link">Gestion
					livres</a></li>
		</ul>
		</div>
	</nav>

	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${adherent != null}"><form action="modifier" method="post"></c:if>
				<c:if test="${adherent == null}"><form action="inscrire" method="post"></c:if>

				<caption>
					<h2>
						<c:if test="${adherent != null}">
            			Modifier informations adhérent</c:if>
						<c:if test="${adherent == null}">
            			Ajouter nouvel adhérent</c:if>
					</h2>
				</caption>

				<c:if test="${adherent != null}">
					<input type="hidden" name="matricule"
						value="<c:out value='${adherent.matricule}' />" />
				</c:if>

				<fieldset class="form-group">
					<label>Nom adhérent</label> <input type="text"
						value="<c:out value='${adherent.nom}' />" class="form-control"
						name="nom" required="required" placeholder="NOM">
				</fieldset>

				<fieldset class="form-group">
					<label>Prénom adhérent</label> <input type="text"
						value="<c:out value='${adherent.prenom}' />" class="form-control"
						name="prenom" placeholder="Prenom">
				</fieldset>

				<fieldset class="form-group">
					<label>Date de naissance</label> <input type="text"
						value="<c:out value='${adherent.dateNaiss}' />"
						class="form-control" name="dateNaiss" placeholder="AAAA-MM-JJ">
				</fieldset>
				<fieldset class="form-group">
					<label>Adresse</label> <input type="text"
						value="<c:out value='${adherent.adresse}' />" class="form-control"
						name="adresse" placeholder="ex: 1 boulevard Charonne, 75020 Paris">
				</fieldset>
				<fieldset class="form-group">
					<label>Téléphone</label> <input type="text"
						value="<c:out value='${adherent.telephone}' />"
						class="form-control" name="telephone">
				</fieldset>
				<fieldset class="form-group">
					<label>Catégorie professionnelle</label> <input type="text"
						value="<c:out value='${adherent.categPro}' />"
						class="form-control" name="categPro">
				</fieldset>
				<fieldset class="form-group">
					<label>Date d'inscription</label> <input type="text"
						value="<c:out value='${adherent.dateAdhesion}' />"
						class="form-control" name="dateAdhesion" placeholder="AAAA-MM-JJ">
				</fieldset>

				<button type="submit" class="btn btn-success">Sauvegarder</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>