<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>EnsiasSolvely | Profile</title>
		<link rel="stylesheet" href="css/bootstrap.min.css">
		<link rel="stylesheet" href="css/Style_Profile.css">
	</head>
	<body>
		<%@ include file="header.jsp" %>
		
		<nav>
			<section class="sec3">
				<h4>Informations</h4>
			</section>
			<section class="sec4">
				<form class="table-responsive" method="post" action="profile">
					<table class="table table-bordered">
						<thead>
							<tr>
								<th scope="row">Student number</th>
								<td><input name="student_number" readonly="readonly"><br></td>
							</tr>
							<tr>
								<th scope="row">Last name</th>
								<td><input name="last_name" readonly="readonly"><br></td>
							</tr>
							<tr>
								<th scope="row">First name</th>
								<td><input name="first_name" readonly="readonly"></input></td>
							</tr>
							<tr>
								<th scope="row">Email</th>
								<td><input name="email" readonly="readonly"></input></td>
							</tr>
							<tr>
								<th scope="row">Phone</th>
								<td><input name="phone" readonly="readonly"></input></td>
							</tr>
							<tr>
								<th scope="row">Room</th>
								<td><input name="room" readonly="readonly"></input></td>
							</tr>
							<tr>
								<th scope="row">Committe id</th>
								<td><input name="committe" id="login" readonly="readonly"></input></td>
							</tr>
							<tr>
								<th scope="row">Login</th>
								<td><input name="login" readonly="readonly"></input></td>
							</tr>
							<tr>
								<th scope="row">Password</th>
								<td>
									<div>
										<input type="password"  name="passwd" id="pass" style="float: left; width: 90%;" readonly="readonly"></input>
										<img id="PassAffich" onclick="myFunction()" src="images/eyeclose.png"></img>
									</div>	
								</td> 
							</tr>
						</thead>
					</table>
					<input type="submit" class="button-3" value="Apply">
				</form>
			</section>
		</nav>
		
		<%@ include file="footer.jsp" %>
		
		<script>
			function myFunction(){
				var x = document.getElementById("pass");
				var y = document.getElementById("PassAffich");
				if (x.type == "password") {
					x.type = "text";
					y.src = "images/eyeopen.png";
				} else {
					x.type = "password";
					y.src = "images/eyeclose.png";
				}
			}
		</script>
	</body>
</html>