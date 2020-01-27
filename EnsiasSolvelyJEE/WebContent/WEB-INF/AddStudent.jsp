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
				<form method="post" action="AddStudentS">
					<div class="form-row">
					<div class="form-group col-md-6">
						<input type="text" class="form-control " id="inputLastName" name="nom" placeholder="Last name" required>
					</div>
					<div class="form-group col-md-6">
						<input type="text" class="form-control" id="inputFirstName" name="prenom" placeholder="First name" required>
					</div>
					<div class="form-group col-md-6">
						<input type="email" class="form-control" id="inputEmail" name="email" placeholder="Email" required>
					</div>
					<div class="form-group col-md-6">
						<input style="float: right;" pattern="[0-9]{9}" class="form-control" id="inputPhone" name="telephone" placeholder="Phone" required>
					</div>
					<div class="form-group col-md-6">
						<input style="float: right;" class="form-control" id="inputRoom" name="chambre" placeholder="Room" required>
					</div>
					<div class="form-group col-md-6">
						<select id="inputCommittee" class="form-control" name="id_comite" required>
							<option value="" disabled selected hidden>Committee</option>
							<option value="1">Batiment</option>
							<option value="2">Divers</option>
							<option value="3">Student</option>
						</select>	
					</div>
					<div class="form-group col-md-6">
						<input type="text" class="form-control" id="inputLogin" name="login" placeholder="Username" required>
					</div>
					<div class="form-group col-md-6">
						<input type="text" class="form-control" id="inputPassword" name="motdepasse" placeholder="Password" required>
					</div>
					</div>
				<input type="submit" class="button-3" value="Add" style="float:Center;">
				</form>
			</section>
		</nav>
		
		<%@ include file="footer.jsp" %>
	</body>
</html>