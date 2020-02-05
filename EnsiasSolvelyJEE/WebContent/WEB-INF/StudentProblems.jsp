<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>EnsiasSolevly | My problems</title>
		<link rel="stylesheet" href="css/bootstrap.min.css">
		<link rel="stylesheet" href="css/Style_Archive.css">
		<link rel="stylesheet" href="css/Style_Problems.css">
	</head>
	<body>
		<%@ include file="header.jsp" %>
		
		<nav>
			<section class="sec1">
				<h4 id="ko">My problems</h4>
			</section>
			<section class="table-responsive" id="sec3">
					<table class="table table-bordered" id="myTable" style="padding-bottom: 0;">
						<thead style="background-color:#C0C0C0;">
							<tr>
								<th scope="col">Id problem</th>
								<th scope="col">Place</th>
								<th scope="col">Date demande</th>
								<th scope="col">type</th>
								<th scope="col">Last name</th>
								<th scope="col">First name</th>
								<th scope="col">Description</th>
								<th scope="col">Statut</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${problems}" var="item">
								<c:if test="${!empty item}">
			 							<tr>
				 							<td name="id_probleme">
				 								${item.id_probleme}
				 							</td>
				 							<td>
				 								${item.lieu}
				 							</td>
				 							<td >
				 								${item.date_demande}
				 							</td>
				 							<td >
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
				 								${item.statut}
				 							</td>
			 							</tr>
			 							
		 						</c:if>
							</c:forEach>
						</tbody>
					</table>
				</section>
			</nav>
		
		<%@ include file="footer.jsp" %>
		

		
</body>
</html>