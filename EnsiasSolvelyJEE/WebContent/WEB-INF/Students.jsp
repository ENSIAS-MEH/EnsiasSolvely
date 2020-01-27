<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>EnsiasSolvely | Students</title>
		<link rel="stylesheet" href="css/bootstrap.min.css">
		<link rel="stylesheet" href="css/Style_Archive.css">
		<link rel="stylesheet" href="css/Style_Students.css">
	</head>
	<body>
		<%@ include file="header.jsp" %>
		
		<a id="addStudent" href="AddStudent" style="width: 9%; height:28px;">New student</a>
		<h4 style="text-align: center; padding-top: 20px; padding-bottom: 15px;">List of Students</h4>
		<nav>
			<section class="table-responsive" id="foncSec2">
				<form method="post" action="StudentsS">
						<input type="number" name="Student_number" placeholder="Student number" min="1" required/>
						<input type="submit" id="search" value="Search">
					</form>
				<div id="section-to-print">
					<table class="table table-bordered" id="myTable" style="">
						<thead style="background-color:#C0C0C0;">
							<tr>
								<th scope="col">Number</th>
								<th scope="col">Last name</th>
								<th scope="col">First name</th>
								<th scope="col">Email</th>
								<th scope="col">Phone</th>
								<th scope="col">Room</th>
								<th scope="col">Committe</th>
								<th scope="col">Login</th>
								<th scope="col">Password</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${eleves}" var="item">
								<c:if test="${!empty item }">
									<tr>
										<td>${item.numeleve}</td>
										<td>${item.nom}</td>
										<td>${item.prenom}</td>
										<td>${item.email}</td>
										<td>0${item.telephone}</td>
										<td>${item.chambre}</td>
										<td>${item.nom_comite}</td>
										<td>${item.login}</td>
										<td>${item.motdepasse}</td>
										<td>
											<a href="Profile?numEleve=${item.numeleve}" style="text-decoration:none;">Modify</a>
										</td>
									</tr>
								</c:if>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</section>
		</nav>
		
        <%@ include file="footer.jsp" %>
        
        <script>
			var count = document.getElementById("myTable").rows.length;
			if(count > 4) document.getElementById('footer').style["margin-top"] = "0";
			else if(count == 3) document.getElementById('footer').style["margin-top"] = "52px";
			else if(count == 4) document.getElementById('footer').style["margin-top"] = "8px";
			else if(count == 1) document.getElementById('footer').style["margin-top"] = "144px";
			else if(count == 2) document.getElementById('footer').style["margin-top"] = "104px";
			else document.getElementById('footer').style["margin-top"] = "90px";

		</script>
	</body>
</html>