<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>EnsiasSolvely | Contact</title>
		<link rel="stylesheet" href="css/bootstrap.min.css">
		<link rel="stylesheet" href="css/Style_home_page.css">
		<link rel="stylesheet" href="css/Style_Contact.css">
	</head>
	<body>
		<%@ include file="header.jsp" %>
		
		<h3>Contact Us</h3>
		<form>
			<div>
				<label for="name">Name</label>
            	<input type="text" id="name" placeholder="Your name" required>
			</div>
			<div>
				<label for="email">Email</label>
            	<input type="text" id="email" placeholder="Your email" required><br>
			</div>
			<div>
				 <label for="message">Message</label>
            	<input type="text" id="message" placeholder="Your message" required>
			</div>
            <input type="submit" value="Send" class="button-3">
         </form>
		
		<%@ include file="footer.jsp" %>
	</body>
</html>