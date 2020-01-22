<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<link rel="stylesheet" href="css/headerstyle.css">
<%--<%

response.setHeader("Cache-Control","no-cache");
response.setHeader("Cache-Control","no-store");
response.setHeader("Pragma","no-cache");
response.setDateHeader ("Expires", 0);

  if(session.getAttribute("fonctionnaire")==null)
      response.sendRedirect("Accueil");

  %>--%> 
<header>
			<nav class="navbar navbar-expand-lg navbar-light bg-light ">
				<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbarNavAltMarkup">
					<div class="navbar-nav mr-auto" >
						<a class="nav-item nav-link active" href="Home" >Home</a>
						<a class="nav-item nav-link active" href="Declare" >Declare</a>
						<a class="nav-item nav-link active" href="Problems">Problems<span class="sr-only"></span></a>
						<a class="nav-item nav-link active" href="Students">Students<span class="sr-only"></span></a>
						<a class="nav-item nav-link active" href="Archive">Archive</a>
						<a class="nav-item nav-link active" href="AboutUs">About Us</a>
						<a class="nav-item nav-link active" href="Contact">Contact</a>
						<a class="nav-item nav-link active" href="#" onclick="document.getElementById('modal-wrapper').style.display='block'">Login</a>
						<a class="nav-item nav-link active" href="Profile">Profile<span class="sr-only"></span></a>
						<a class="nav-item nav-link active" href="#" style="float:left;">Deconnection</a>
					</div>
				</div>
			</nav>
</header>
<div id="modal-wrapper" class="modal">
 	<form class="modal-content animate" method="post" action="Home" >
         <div class="imgcontainer">
            <span onclick="document.getElementById('modal-wrapper').style.display='none'" class="close" title="Close PopUp">&times;</span>
            <h2 style="text-align:center">Login</h2>
        </div>
        <div class="container">
            <input type="text" placeholder="Enter Username" name="uname">
            <input type="password" placeholder="Enter Password" name="passwd">        
            <button id="button-login" type="submit">Login</button>
        </div>
    </form>
</div>

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
        
<%-- 
<script>
		var admin = '${fonctionnaire.code_grade}';
		if(admin > 2){
			document.getElementById("Demandes").style.display ='none';
			document.getElementById("Fonctionnaire").style.display ='none';
			document.getElementById("Feries").style.display ='none';
			document.getElementById("Archive").style.display ='none';
		}
</script>--%>