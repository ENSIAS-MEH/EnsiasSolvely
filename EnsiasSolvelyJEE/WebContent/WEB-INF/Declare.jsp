<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>EnsiasSolvely | Declarer</title>
		<link rel="stylesheet" href="css/bootstrap.min.css">
		<link rel="stylesheet" href="css/Style_Profile.css">
	</head>
	<body>
		<%@ include file="header.jsp" %>
		
		<nav>
			<section class="sec3">
				<h4>Declarer un problème</h4>
			</section>
			<section class="sec4">
				<form class="table-responsive" method="post" action="">
					<table class="table table-bordered">
						<thead>
							<tr>
								<th scope="row">N° Etudiant</th>
								<td><input value="${empty eleve?'':eleve.numEleve}" name="numEleve" readonly="readonly"><br></td>
							</tr>
							<tr>
								<th scope="row">Nom</th>
								<td><input value="${empty eleve?'':eleve.nom}" name="lastName" readonly="readonly"><br></td>
							</tr>
							<tr>
								<th scope="row">Prenom</th>
								<td><input value="${empty eleve?'':eleve.prenom}" name="firstName" readonly="readonly"></input></td>
							</tr>
							<tr>
								<th scope="row">Place</th>
								<td><input type="text" name="lieu"></td>
							</tr>
							<tr>
								<th scope="row">Type</th>
								<td><select name="ID_TC" >
									<option> </option>
									<option value="1">CUISINE</option>
									<option value="2">CHAMBRE</option>
									<option value="3">BLOC SANITAIRE</option>
									<option value="4">URGENCE</option>
									<option value="5">ESPACE SPORTIF</option>
									<option value="6">BUVETTE ET AUTRES</option>
								</select></td>
							</tr>
							<tr>
								<th scope="row">Description</th>
								<td><input type="text" name="description"></td>
							</tr>
							<tr>
								<th scope="row">Date demande</th>
								<td><input value="${empty dateAujourdhui?'':dateAujourdhui}" name="dateAujourdhui" readonly="readonly"></input></td>
							</tr>
						</thead>
					</table>
					<input type="submit" class="button-3" value="Send">
				</form>
			</section>
		</nav>
		
		<%@ include file="footer.jsp" %>
	</body>
</html>