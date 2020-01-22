<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>EnsiasSolevly | Problemes</title>
		<link rel="stylesheet" href="css/bootstrap.min.css">
		<link rel="stylesheet" href="css/Style_Archive.css">
		<link rel="stylesheet" href="css/Style_Problems.css">
	</head>
	<body>
		<%@ include file="header.jsp" %>
		
		<nav>
			<section class="sec1">
				<h4 id="ko">Liste des problemes</h4>
			</section>
			<section class="table-responsive" id="sec3">
					<form method="post" action="">
						<input type="number" name="id_problem" placeholder="Id problem" min="1"/>
						<select class="statut_decision">
							<option value="Resolu">Resolu</option>
							<option value="NonResolu">Non Resolu</option>
						</select>
						<input type="submit" id="apply" value="apply">
						<%-- <button type="submit" id="print" value="apply">Apply</button> --%>
					</form>
					<table class="table table-bordered" id="myTable" style="padding-bottom: 0;">
						<thead style="background-color:#C0C0C0;">
							<tr>
								<th scope="col">Id probleme</th>
								<th scope="col">Lieu</th>
								<th scope="col">Date demande</th>
								<th scope="col">type</th>
								<th scope="col">Nom</th>
								<th scope="col">Prenom</th>
								<th scope="col">Description</th>
								<th scope="col">Statut</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${demandes}" var="item">
								<c:if test="${!empty item}">
			 							<tr>
			 							<td >
			 								${item.id_probleme}
			 							</td>
			 							<td>
			 								${item.lieu}
			 							</td>
			 							<td >
			 								${item.date_demande}
			 							</td>
			 							<td >
			 								${item.id_type}
			 							</td>
			 							<td>
			 								${item.lastname}
			 							</td>
			 							<td>
			 								${item.firstname}
			 							</td>
			 							<td>
			 								${item.description}
			 							</td>
			 							<td>
			 								${item.Statut}
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