<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>EnsiasSolvely | Contact</title>
		<link rel="stylesheet" href="css/bootstrap.min.css">
		<link rel="stylesheet" href="css/Style_Contact.css">
	</head>
	<body>
			<%@ include file="header.jsp" %>
	
			<form id="contact" action="" method="post">
				<h3>Contactez Nous</h3>
				<fieldset>
					<input placeholder="Your name" type="text" tabindex="1" required
						autofocus>
				</fieldset>
				<fieldset>
					<input placeholder="Your Email Address" type="email" tabindex="2"
						required>
				</fieldset>
				<fieldset>
					<input placeholder="Your Phone Number (optional)" type="tel"
						tabindex="3">
				</fieldset>
				<fieldset>
					<textarea placeholder="Type your message here...." tabindex="5"
						required></textarea>
				</fieldset>
				<fieldset>
					<button name="submit" type="submit" id="contact-submit"
						data-submit="...Sending">Send</button>
				</fieldset>
			</form>
	
		<%@ include file="footer.jsp" %>
	</body>
</html>