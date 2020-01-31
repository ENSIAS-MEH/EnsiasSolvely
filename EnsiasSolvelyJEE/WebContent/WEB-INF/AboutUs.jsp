<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>EnsiasSolvely | About Us</title>
		<link rel="stylesheet" href="css/bootstrap.min.css">
		<link rel="stylesheet" href="css/Style_AboutUs.css">
	</head>
	<body>
		<%@ include file="header.jsp" %>
		
		<section id="main-image">
             <div class="wrapper">
                <h2>About Us</h2>
                <p>
                    ProSolvely is a website dedicated to engineering students of the National School of Computer Science and Systems Analysis.
                    It allows to declare the problems encountered in the student residence of ENSIAS.
                    Students can also see the progress of the solutions offered by the responsible committees.
                </p>
             </div>
        </section>

        <section id="contact">
             <div class="wrapper">
                 <h3>CONTACT US</h3>
                 <p>If you have some problems while navigating in our website, or if you have other issues,<br> you can contact us by entering your name, your email and send a description.</p>
                 <form>
                    <label for="name">Name</label>
                    <input type="text" id="name" placeholder="Your name" required>
                    <label for="email">Email</label>
                    <input type="text" id="email" placeholder="Your email" required><br>
                    <input type="submit" value="Go" class="button-3">
                 </form>
             </div>
        </section>
		
		<%@ include file="footer.jsp" %>
	</body>	
</html>