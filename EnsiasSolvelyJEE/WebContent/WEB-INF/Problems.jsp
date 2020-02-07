<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>EnsiasSolevly | Problems</title>
		<link rel="stylesheet" href="css/bootstrap.min.css">
		<link rel="stylesheet" href="css/Style_Archive.css">
		<link rel="stylesheet" href="css/Style_Problems.css">
	</head>
	<body>
		<%@ include file="header.jsp" %>
		
		<nav>
			<a class="btn-1" id="problemsList" href="RecupererReport?reporting=3" style="width: 9%; height:28px;">Print</a>
			<section class="sec1">
				<h4 id="ko">List of problems</h4>
			</section>
			<section class="table-responsive" id="sec3">
					<form id="changeStatut" method="post" action="ProblemsS">
						<input type="number" name="id_problem" placeholder="Id problem" min="1" required/>
						<select name="statut_decision">
							<option value="Solved">Solved</option>
							<option value="Not Solved">Not Solved</option>
						</select>
						<input type="submit" id="apply" value="apply">
						<%-- <button type="submit" id="print" value="apply">Apply</button> --%>
					</form>
					<h6 id = "h6Text" style="display:none;">Pas de probleme</h6>
					<table class="table table-bordered" id="myTable" style="padding-bottom: 0;">
						<thead id="tableHeader" style="background-color:#C0C0C0;">
							<tr>
								<th scope="col">Id problem</th>
								<th scope="col">Place</th>
								<th scope="col">Date demande</th>
								<th scope="col"><a id="reorderType" onClick="reoderType()" href = "#" style="text-decoration: none; color:lightgreen;">type</a></th>
								<th scope="col">Last name</th>
								<th scope="col">First name</th>
								<th scope="col">Description</th>
								<th scope="col">Statut</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${problems}" var="item">
								<c:if test="${!empty item}">
									<form id="${item.id_probleme}" method="post" action="Problems">
			 							<tr>
				 							<td style="display:none;">
				 								<input name="id_probleme" value="${item.id_probleme}"/>
				 							</td>
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
				 							<td style= "width:10%;"><img id="${item.id_probleme}+1" onClick="myFunction(${item.id_probleme})" src="images/like_before.png">  ${item.likes}</td>
			 							</tr>
			 						</form>	
			 						<c:forEach items="${problemsLiked}" var="item2">
												<c:if test="${!empty item2}">
													<c:if test="${item.id_probleme == item2.id_probleme}">
														<script>
															var id = "${item.id_probleme}+1";
															var x = document.getElementById(id);
															x.src="images/like_after.png";
															x.style.pointerEvents = "none";
														</script>
													</c:if>
												</c:if>
									</c:forEach>
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
		<script>
			function myFunction(id){
				var x = document.getElementById(id);
				x.src="images/like_after.png";
			    x.style.pointerEvents = "none";
			    var formId = document.getElementById(id);
			    formId.submit();
			}
		</script>
		<script>
			var admin = '${eleve.id_comite}';
			if (admin != 1 && admin != 2) {
				document.getElementById("changeStatut").style.display = 'none';
				document.getElementById("problemsList").style.display = 'none';
			}
		</script>
		<script type="text/javascript">
			var vProblem = "${empty problems[0].id_probleme ? 0:1}";
			if(vProblem == 0){
				document.getElementById("tableHeader").style.display ='none';
				document.getElementById("h6Text").style.display ='block';
			}
		</script>
		<script>
			function reoderType(){
				var rdr = "${empty rdr?0:1}";
				if(rdr == 0){
					document.getElementById("reorderType").href = "Problems?rdr=1";
				}else{ 
					document.getElementById("reorderType").href = "Problems?rdr=0";
				}
			}
		</script>
		<script type="text/javascript">
			var rdr = "${empty rdr?0:1}";
			if(rdr == 1) document.getElementById("reorderType").text = "Urgent";
		</script>
</body>
</html>