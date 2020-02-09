<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>EnsiasSolvely | Declare</title>
		<link rel="stylesheet" href="css/bootstrap.min.css">
		<link rel="stylesheet" href="css/Style_Profile.css">
	</head>
	<body>
		<%@ include file="header.jsp" %>
		
		<nav>
			<section class="sec3">
				<h4>Declare a problem</h4>
			</section>
			<section class="sec4">
				<form class="table-responsive" method="post" action="DeclareS">
					<table class="table table-bordered">
						<thead>
							<tr>
								<th scope="row">Student number</th>
								<td><input value="${empty eleve?'':eleve.numeleve}" name="numEleve" readonly="readonly"><br></td>
							</tr>
							<tr>
								<th scope="row">Last name</th>
								<td><input value="${empty eleve?'':eleve.nom}" name="nom" readonly="readonly"><br></td>
							</tr>
							<tr>
								<th scope="row">First name</th>
								<td><input value="${empty eleve?'':eleve.prenom}" name="prenom" readonly="readonly"></input></td>
							</tr>
							<tr>
								<th scope="row">Place</th>
								<td><input name="lieu" required></input></td>
							</tr>
							<tr>
								<th scope="row">Type</th>
								<td><select name="id_type">
									<option value="1">Kitchen</option>
									<option value="2">Room</option>
									<option value="3">Sanitary Bloc</option>
									<option value="4">Urgent</option>
									<option value="5">Sport space</option>
									<option value="6">Buvette and others</option>
								</select></td>
							</tr>
							<tr>
								<th scope="row">Description</th>
								<td><input name="description" required></input></td>
							</tr>
							<tr>
								<th scope="row">Date demande</th>
								<td><input value="${empty todayDate?'':todayDate}" id="today" type="date" name="date_demande" readonly="readonly"></td>
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