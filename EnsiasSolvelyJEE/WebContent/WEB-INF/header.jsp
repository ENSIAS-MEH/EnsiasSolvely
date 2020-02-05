<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<link rel="stylesheet" href="css/headerstyle.css">



<header>
			<nav class="navbar navbar-expand-lg navbar-light bg-light ">
				<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbarNavAltMarkup" style="display: inline-grid;">
					<div class="navbar-nav mr-auto">
						<a class="nav-item nav-link active" id="Home" href="Home" >Home</a>
						<a class="nav-item nav-link active" id="Declare" href="Declare" >Declare</a>
						<a class="nav-item nav-link active" id="Problems" href="Problems">Problems<span class="sr-only"></span></a>
						<a class="nav-item nav-link active" id="Students" href="Students">Students<span class="sr-only"></span></a>
						<a class="nav-item nav-link active" id="Archive" href="Archive">Archive</a>
						<a class="nav-item nav-link active" id="StudentProblems" href="StudentProblems">My problems</a>
						<a class="nav-item nav-link active" id="Statistics" href="Statistics">Statistics</a>
						<a class="nav-item nav-link active" href="AboutUs">About Us</a>
						<a class="nav-item nav-link active" href="Contact">Contact</a>
						<a class="nav-item nav-link active" id="Login" href="#" onclick="document.getElementById('modal-wrapper').style.display='block'">Login</a>
						<a id="circle"></a>
						<a class="nav-item nav-link active" id="Profile" href="Profile">Profile<span class="sr-only"></span></a>
						<%-- <a class="nav-item nav-link active" id="Deconnection" href="Home?con=0" >Deconnection</a>--%>
						<a id="Deconnection" href="Home?con=0" style="right: 0;"><img id="imgLogout" src="images/logout.png"></a>
					</div>
				</div>
			</nav>
</header>
<div id="modal-wrapper" class="modal">
    <form method="post" action="HomeS" class="modal-content animate">
        <div class="imgcontainer">
            <span onclick="document.getElementById('modal-wrapper').style.display='none'" class="close" title="Close PopUp">&times;</span>
            <h2 style="text-align:center">Login</h2>
        </div>
        <div class="container">
            <input type="text" placeholder="Enter Username" name="login" style="margin: 10px auto;" required>
            <input type="password" placeholder="Enter Password" name="motdepasse" style="margin: 10px auto;" required>        
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
        
        <script>
		var eleve = '${empty eleve?0:1}';
		if(eleve==0){
			document.getElementById("Login").style.display ='block';
			document.getElementById("Declare").style.display ='none';
			document.getElementById("Profile").style.display ='none';
			document.getElementById("circle").style.display ='none';
			document.getElementById("Deconnection").style.display ='none';
			document.getElementById("Problems").style.display ='none';
			document.getElementById("Students").style.display ='none';
			document.getElementById("Archive").style.display ='none';
			document.getElementById("StudentProblems").style.display ='none';
			document.getElementById("Statistics").style.display = 'none';
		}
		if(eleve==1){
			document.getElementById("Login").style.display ='none';
			document.getElementById("Declare").style.display ='block';
			document.getElementById("circle").style.display ='block';
			var profile = document.getElementById("Profile");
			profile.style.display ='block';
			profile.innerHTML = '${eleve.nom}' + " " + '${eleve.prenom}';
			document.getElementById("Deconnection").style.display ='block';
			document.getElementById("Problems").style.display ='block';
			document.getElementById("Students").style.display ='block';
			document.getElementById("Archive").style.display ='block';
			document.getElementById("StudentProblems").style.display ='block';
			document.getElementById("Statistics").style.display = 'block';
		}
		</script>

<script>
		var admin = '${eleve.id_comite}';
		if(admin != 1 && admin != 2){
			document.getElementById("Students").style.display ='none';
			document.getElementById("Statistics").style.display = 'none';
			document.getElementById("circle").style.marginLeft = "80% !important";
		}
</script>
        
