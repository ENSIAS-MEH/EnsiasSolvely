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
					<div class=" ">
						<input type="text" class="form-control " id="inputLastName" name="nom" placeholder="Last name" required>
						<input type="text" class="form-control" id="inputFirstName" name="prenom" placeholder="First name" required>
					</div>
					<div class=" ">
						<input type="email" class="form-control" id="inputEmail" name="email" placeholder="Email" required>
						<input  pattern="[0-9]{9}" class="form-control" id="inputPhone" name="telephone" placeholder="Phone" required>
	
					</div>
					<div class=" ">
						<input  class="form-control" id="inputRoom" name="chambre" placeholder="Room" required>
						<select id="inputCommittee" class="form-control" name="id_comite" required>
							<option value="" disabled selected hidden>Committee</option>
							<option value="1">Batiment</option>
							<option value="2">Divers</option>
							<option value="3">Student</option>
						</select>	
					</div>
					<div class=" ">
						<input type="text" class="form-control" id="inputLogin" name="login" placeholder="Username" required>
						<input type="text" class="form-control" id="inputPassword" name="motdepasse" placeholder="Password" required>
					</div>
				<input type="submit" class="button-3" value="Add" style="float:Center;">
				</form>
			</section>
		</nav>
		
		<%@ include file="footer.jsp" %>
		<script type="text/javascript">
			var erreur = "${form.erreurs['eleveExist']}";
			if(erreur.length>0){
				alert(erreur);	
			}
		</script>
	</body>
	
</html>