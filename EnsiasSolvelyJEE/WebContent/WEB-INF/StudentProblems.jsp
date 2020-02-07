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
					<h6 id = "h6Text" style="display:none;">Pas de problèmes</h6>
					<table class="table table-bordered" id="myTable" style="padding-bottom: 0;">
						<thead id="tableHeader" style="background-color:#C0C0C0;">
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
		
		<script type="text/javascript">
			var erreur = "${form.erreurs['problemNotFound']}";
			if(erreur.length>0){
				alert(erreur);	
			}
		</script>
		
		<script type="text/javascript">
			var vProblem = "${empty problems[0].id_probleme ? 0:1}";
			if(vProblem == 0){
				document.getElementById("tableHeader").style.display ='none';
				document.getElementById("h6Text").style.display ='block';
			}
		</script>
		
</body>
</html>