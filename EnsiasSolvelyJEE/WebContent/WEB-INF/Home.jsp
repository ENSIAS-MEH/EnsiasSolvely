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
		<section id="imageSlider0">
             <div class="wrapper">
                <h2>Do you have problems while living in ENSIAS?<br></h2>
                <h1><strong>You can declare now</strong></h1>
                <a href="#" id="ok1" class="button-1" onclick="FromHere()">From Here</a>
             </div>
        </section>
        <section id="imageSlider1" style="display: none;">
             <div class="wrapper">
                <h2>Do you have problems while living in ENSIAS?<br></h2>
                <h1><strong>You can declare now</strong></h1>
                <a href="#" id="ok2" class="button-1" onclick="FromHere()">From Here</a>
             </div>
        </section>
        <section id="imageSlider2" style="display: none;">
             <div class="wrapper">
                <h2>Do you have problems while living in ENSIAS?<br></h2>
                <h1><strong>You can declare now</strong></h1>
                <a href="#" id="ok3" class="button-1" onclick="FromHere()">From Here</a>
             </div>
        </section>
        <section id="imageSlider3" style="display: none;">
             <div class="wrapper">
                <h2>Do you have problems while living in ENSIAS?<br></h2>
                <h1><strong>You can declare now</strong></h1>
                <a href="#" id="ok4" class="button-1" onclick="FromHere()">From Here</a>
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

	<div id="modal-wrapper" class="modal">
		<form method="post" action="${empty action?'':action}" class="modal-content animate">
			<div class="imgcontainer">
				<span
					onclick="document.getElementById('modal-wrapper').style.display='none'"
					class="close" title="Close PopUp">&times;</span>
				<h2 style="text-align: center">Login</h2>
			</div>
			<div class="container">
				<input type="text" placeholder="Enter Username" name="login"
					style="margin: 10px auto;" required> <input type="password"
					placeholder="Enter Password" name="motdepasse"
					style="margin: 10px auto;" required>
				<button id="button-login" type="submit">Login</button>
			</div>
		</form>
	</div>

	<%@ include file="footer.jsp" %>
        
        <script type="text/javascript">
			var erreur = "${form.erreurs['login']}";
			if(erreur.length>0){
				alert(erreur);	
			}
		</script>	
		<script>
			var index = 0;
			changeImages();
			
			function changeImages(){
				index = index % 4;
				//pat = "images/" + index + ".jpg";
				//var path = "url("+ pat + ") no-repeat center;";
				for(var i = 0; i < 4; i++){
					var image = document.getElementById("imageSlider" + i);
					if(i == index) image.style.display = "block";
					else image.style.display = "none";
				}
				//console.log(pat);
				index++;
				setTimeout(changeImages, 5000); 
			}
		</script>
		
		<script>
            // If user clicks anywhere outside of the modal, Modal will close
            var modal = document.getElementById('modal-wrapper');
            window.onclick = function(event) {
                if (event.target == modal) {
                    modal.style.display = 'none';
                }
            }
            function loginPopup() {
                document.getElementById('modal-wrapper').style.display='block'
            }
        </script>
        <script type="text/javascript">
        	function FromHere(){
        	var action = "${empty action?'':action}";
        	if(action == "HomeS"){
        		document.getElementById('ok1').href = "#";
        		document.getElementById('ok2').href = "#";
        		document.getElementById('ok3').href = "#";
        		document.getElementById('ok4').href = "#";
            	document.getElementById('modal-wrapper').style.display='block';
        	}else{
        		document.getElementById('ok1').href = "Declare";
        		document.getElementById('ok2').href = "Declare";
        		document.getElementById('ok3').href = "Declare";
        		document.getElementById('ok4').href = "Declare";
        	}
        	}
        </script>
	
	</body>
</html>