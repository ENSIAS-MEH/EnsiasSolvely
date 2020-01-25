<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>EnsiasSolevly | Archive</title>
		<link rel="stylesheet" href="css/bootstrap.min.css">
		<link rel="stylesheet" href="css/Style_Archive.css">
		
	</head>
	<body>
		<%@ include file="header.jsp" %>
		
		<nav>
			<section class="table-responsive" id="sec6">
				<div id="section-to-print">
					<img  class="royaume" id="royaume" src="images/image_logo.png" style="display:none;">
					<section class="sec1">
						<h4>Problems of the year :  <label id="annee"></label></h4>
					</section>
					<table class="table table-bordered" id="myTable">
						<thead id="ok">
							<tr class="tete">
								<th scope="col">Id problem</th>
								<th scope="col">Place</th>
								<th scope="col">Date demande</th>
								<th scope="col">type</th>
								<th scope="col">Last name</th>
								<th scope="col">First name</th>
								<th scope="col">Description</th>
								<th scope="col">Committe</th>
								<th scope="col">Statut</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${problems}" var="item">
								<c:if test="${!empty item }">
								<form id="${item.id_probleme}" method="post" action="Archive">
									<tr>
										<td>
			 								<input name="id_probleme" value="${item.id_probleme}" >
			 							</td>
			 							<td>
			 								<input name="lieu" value="${item.lieu}" >
			 							</td>
			 							<td>
			 								<input name="date_demande" value="${item.date_demande}" >
			 							</td>
			 							<td>
			 								<input name="libelle_type" value="${item.libelle_type}" >
			 							</td>
			 							<td>
			 								<input name="nom" value="${item.nom}" >
			 							</td>
			 							<td>
			 								<input name="prenom" value="${item.prenom}" >
			 							</td>
			 							<td>
			 								<input name="description" value="${item.description}" >
			 							</td>
			 							<td>
			 								<input name="id_comite" value="${item.nom_comite}" >
			 							</td>
			 							<td>
			 								<input name="statut" value="${item.statut}" >
			 							</td>
									</tr>
								</form>
								</c:if>
							</c:forEach>
						</tbody>
					</table>
				</div>
				<button id ="print" class="button-3" type="submit">Print</button>

			</section>
		
		<%@ include file="footer.jsp" %>
	</body>
</html>