<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>EnsiasSolvely | New student</title>
		<link rel="stylesheet" href="css/bootstrap.min.css">
		<link rel="stylesheet" href="css/Style_AddStudent.css">
	</head>
	<body>
		<%@ include file="header.jsp" %>
		
		<nav>
			<section class="sec1">
				<h4>New student</h4>
			</section>
			<section class="sec2">
				<form method="post" action="">
					<div class=" ">
						<input type="text" class="form-control " id="inputNumber" name="number" placeholder="Student number" required>
					</div>
					<div class=" ">
						<input type="text" class="form-control " id="inputLastName" name="lastname" placeholder="Last name" required>
						<input type="text" class="form-control" id="inputFirstName" name="firstname" placeholder="First name" required>
					</div>
					<div class=" ">
						<input type="email" class="form-control" id="inputEmail" name="email" placeholder="Email" required>
						<input style="float: right;" pattern="[0-9]{9}" class="form-control" id="inputPhone" name="phone" placeholder="Phone" required>
					</div>
					<div class=" ">
						<input style="float: right;" class="form-control" id="inputRoom" name="room" placeholder="Room" required>
						<select id="inputCommittee" class="form-control" name="committee" required>
							<option value="" disabled selected hidden>Committee</option>
							<option value="1">Responsable RH</option>
							<option value="2">Manager</option>
							<option value="3">Employé</option>
						</select>	
					</div>
					<div class=" ">
						<input type="text" class="form-control" id="inputLogin" name="login" placeholder="Username" required>
						<input type="text" class="form-control" id="inputPassword" name="passwd" placeholder="Password" required>
					</div>
				<input type="submit" class="button-3" value="Add" style="float:Center;">
				</form>
			</section>
		</nav>
		
		<%@ include file="footer.jsp" %>
	</body>
</html>