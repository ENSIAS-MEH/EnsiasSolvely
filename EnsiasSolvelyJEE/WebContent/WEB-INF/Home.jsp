<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>EnsiasSolvely | Home</title>
		<link rel="stylesheet" href="css/bootstrap.min.css">
		<link rel="stylesheet" href="css/Style_home_page.css">
	</head>
	<body>
		<%@ include file="header.jsp" %>
		<section id="main-image">
             <div class="wrapper">
                <h2>Do you have problems while living in ENSIAS?<br></h2>
                <h1><strong>You can declare now</strong></h1>
                <a href="#" class="button-1">From Here</a>
             </div>
        </section> 
        <section id="steps">
             <div class="wrapper">
                <ul>
                    <li id="step-1">
                        <h4>Having a problem?</h4>
                        <p>Do you have some problems while living in ENSIAS, such as WiFi, materiel, water or others ?</p>
                    </li>
                    <li id="step-2">
                        <h4>Declare</h4>
                        <p>You can declare your problem by choosing his type and writing a description.</p>
                    </li >
                    <li id="step-3">
                        <h4>Check status</h4>
                        <p>You can always check the status of problems all the long of the process until they become solved.</p>
                    </li>
                    <div class="clear"></div>
                </ul>
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