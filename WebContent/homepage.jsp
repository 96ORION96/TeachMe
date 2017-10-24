<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="Beans.UtenteBeans"%>
<jsp:useBean id="utente" class="Beans.UtenteBeans" scope="session"></jsp:useBean>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset= UTF-8">
<title>Teach Me</title>
<link rel="icon" href="images/t.ico" />
<link rel="stylesheet" type="text/css" href="css/home.css">
	<script type="text/javascript" src="script/homeScripts.js"></script>
</head>
<body>
	<main>
		<header id="header">
			<div id="SX">
				<div>
					<h1>Teach Me</h1>
				</div>
			</div>
			<div id="DX">
				<div>
					<div id="top">
					<%if(!utente.isLogin()){%>
						<button onclick="loginMenu()">Accedi</button>
						<div id="button"><a href="signIn.jsp">Registrati</a></div>
						<%}else{ %>
						<div id="benvenuto">
							<div><h3>Benvenuto <%=utente.getNome() %> </h3></div>
							<div><form action="Logout" method="get"><input id="logout" title="Disconettiti" type="image" name="submit" src="images/home/logout.png"></form></div>
						</div> 
						<%} %>
					</div>

					<div id="bot">
						<a href="ricerca.jsp"><button size="25">Cerca</button></a>
					</div>
					
					<div id="login">
						<form action="/Progetto/Login" method="post">
								<p>Username:</p>
								<input type="text"  name="user" maxlength="15" required autocomplete="on" autofocus>
								<p>Password:</p>
								<input type="password" name="psw" maxlength="15" required>

								<div><input type="submit" value="Accedi"></input></div>
						</form>

						<a href="forgotPassword.jsp" target="_blank"> Password Dimenticata?</a>
					</div>
				</div>

			</div>
		</header>

		<nav id="nav" class="">
			<div id="SX">
				<div><h1 id="logo" class="logo">Teach Me</h1> </div>
			</div>
			<div id="DX">
				<div> <a href="homepage.jsp"> Home </a> </div>
				<div> <a href="user.jsp"> Utente </a>  </div>
				<div> <a href="favorite.jsp"> Preferiti </a> </div>
			</div>
		</nav>

		<section>
			<div id="container">

				<img onclick="slide(false)" src="images/home/frecciaSX.png">
				<div id="slider">
					<div id="0" class="sliders">
						<a><img alt="" src="images/home/tutors.jpg"></a>
						<div class="label">
							<h2>
								Lezioni con un Tutor
							</h2>
							<p>
								Lezioni di ripasso con alunni che hanno gi&agrave; frequentato il corso e superato l'esame,
								possono farti superare un esame pi&ugrave; facilmente.
							</p>
						</div>
					</div>

					<div id="1" class="sliders">
						<a><img alt="" src="images/home/books.jpg"></a>
						<div class="label">
							<h2>
								Libri
							</h2>
							<p>
								Libri per ogni facolt&agrave;, venduti dagli alunni che hanno gi&agrave; superato l'esame.
							</p>
						</div>
					</div>

					<div id="2" class="sliders">
						<a><img alt="" src="images/home/notes.jpg"></a>
						<div class="label">
							<h2>
								Appunti
							</h2>
							<p>
								Appunti presi da alunni che hanno frequentato il corso e superato l'esame,
								possono farti superare un esame pi&ugrave; facilmente.
							</p>
						</div>
					</div>
				</div>

				<img onclick= "slide(true)" src="images/home/frecciaDX.png">

				<div id=icons>
					<div id="a" class="icon"></div>
					<div id="b" class="icon"></div>
					<div id="c" class="icon"></div>
				</div>
			</div>

			<aside>
				<div class="column" >
					<div class="top">
						<img src="images/home/materie.jpg" >
						<h2>Materie</h2>
					</div>
					<br>
					<div class="bot">
						<h3>Le nostre materie</h3>
						<p>
							Naviga tra tutte le materie per trovare pi&ugrave; velocemente i contenuti che cerchi, grazie alla
							nostra ricerca intuitiva che ti permetter&agrave; di navigare tra tutte le materie universitarie e di trovare i
							contenuti in base alla materia che li richiede.
						</p>
						<div><a href="materie.jsp">Naviga</a></div>
					</div>

				</div>

				<div class="column">
					<div class="top">
						<img src="images/home/facolta.jpg" >
						<h2>Facolt&agrave;</h2>
					</div>
					<br>
					<div class="bot">
						<h3>Le nostre facolt&agrave;</h3>
						<p>
							Naviga tra tutte le facolt&agrave; per trovare pi&ugrave; velocemente i contenuti che cerchi, grazie alla
							nostra ricerca intuitiva che ti permetter&agrave; di navigare tra tutte le facolt&agrave; universitarie e di trovare i
							contenuti in base alla facolt&agrave; che li richiede.
						</p>
						<div><a href="facolta.jsp">Naviga</a></div>
					</div>

				</div>

				<div class="column">
					<div class="top">
						<img src="images/home/universita.jpg" >
						<h2>Universit&agrave;</h2>
					</div>
					<br>
					<div class="bot">
						<h3>Le nostre univesit&agrave;</h3>
						<p>
							Naviga tra tutte le universit&agrave; per trovare pi&ugrave; velocemente i contenuti che cerchi, grazie alla nostra
							ricerca intuitiva che ti permetter&agrave; di navigare tra tutte le universit&agrave; italiane e di trovare i contenuti in base
							all'universit&agrave; che li richiede.
						</p>
						<div><a href="universita.jsp">Naviga</a></div>
					</div>
				</div>
			</aside>
		</section>

		<footer>
			<div id="TOP">
				<div id="top">
					<img src="images/home/logo.svg">
				</div>
				<div id="bot">
					<p>
						Teach Me &egrave una piattaforma per alunni universitari, che permette la vendita/acquisto
						<br>
						di lezioni di tutorato, appunti e libri.
					</p>
				</div>
			</div>
			<div id="BOT">
				<h3>Copyright &copy; 2017 Dalton's Inc. tutti i diritti riservati</h3>
			</div>
		</footer>

	</main>
</body>
</html>
