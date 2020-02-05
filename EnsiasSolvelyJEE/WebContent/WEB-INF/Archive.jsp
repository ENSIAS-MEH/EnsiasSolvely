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
		<a class="btn-1" id="StatisticsArchive" href="RecupererReport?reporting=7" style="width: 9%; height:28px;">Statistics</a>
		<nav>
			<section class="table-responsive" id="sec6">
				<div id="section-to-print">
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
									<tr>
										<td>
			 								${item.id_probleme}
			 							</td>
			 							<td>
			 								${item.lieu}
			 							</td>
			 							<td>
			 								${item.date_demande}
			 							</td>
			 							<td>
			 								${item.libelle_type}
			 							</td>
			 							<td>
			 								${item.nom}
			 							</td>
			 							<td>
			 								${item.prenom}
			 							</td>
			 							<td>
			 								${item.description}
			 							</td>
			 							<td>
			 								${item.nom_comite}
			 							</td>
			 							<td>
			 								${item.statut}
			 							</td>
									</tr>
								</c:if>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</section>
		
		<%@ include file="footer.jsp" %>
	</body>
</html>