<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="beans.UtenteBeans"%>
<jsp:useBean id="utente" class="beans.UtenteBeans" scope="session"></jsp:useBean>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset= UTF-8">
<title>Teach Me</title>
<link rel="icon" href="images/t.ico" />
<link rel="stylesheet" type="text/css" href="css/home.css">
<link rel="stylesheet" type="text/css" href="css/metaHOME.css">
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
						<%if(utente.isLogin()){ %>
							<div id="benvenuto">
							<div><h3>Benvenuto <%=utente.getNome() %> </h3></div>
							<div><form action="Logout" method="get"><input id="logout" title="Disconettiti" type="image" name="submit" src="images/home/logout.png"></form></div>
						</div> 
						<%}else{%>
						
							<%String control = (String) request.getAttribute("control"); %>
							
								<%if(control != null){ %>
									<script type="text/javascript">alert("password o/e email errata!")</script>	
								<%} %>
							<button onclick="loginMenu()">Accedi</button>
							<div id="button"><a href="areaUtente.jsp">Registrati</a></div>
								
						<%} %>	
					</div>

					<div id="bot">
						<a href="ComboBoxServlet"><button size="25">Ricerca</button></a>
					</div>
				
					<div id="login">
						<form action="/Progetto/Login" method="post">
							<div id="top">
								<p>Indirizzo e-mail:</p>
								<input type="text"  name="mail" required autocomplete="on" autofocus>
								<p>Password:</p>
								<input type="password" name="psw" maxlength="15" required>
							</div>
							<div id="bot"><input type="submit" value="Accedi"></input></div>
						</form>

					</div>
				</div>

			</div>
		</header>

		<nav id="nav" class="">
			<div id="SX">
				<div><h1 id="logo" class="logo">Teach Me</h1> </div>
			</div>
			<div id="DX">
				<div> <a href="home.jsp"> Home </a> </div>
				<div> <a href="areaUtente.jsp"> Utente </a>  </div>
				<div> <a href="preferiti.jsp"> Preferiti </a> </div>
			</div>
		</nav>

		<section>
			<div id="container">

				<img onclick="slide(false)" src="images/home/frecciaSX.png">
				<div id="slider">
					<div id="0" class="sliders">
						<a href="CercaProdottiL"><img alt="" src="images/home/tutors.jpg"></a>
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
						<a href="CercaProdottiLi"><img alt="" src="images/home/books.jpg"></a>
						<div class="label">
							<h2>
								Libri
							</h2>
							<p>
								Libri per ogni facolt&agrave;, venduti dagli alunni che hanno gi&agrave; superato l'esame, ad un
								prezzo ragionevole e mantenuti in ottime condizioni. 
							</p>
						</div>
					</div>

					<div id="2" class="sliders">
						<a href="CercaProdottiA"><img alt="" src="images/home/notes.jpg"></a>
						<div class="label">
							<h2>
								Appunti
							</h2>
							<p>
								Appunti presi da alunni preparati che hanno frequentato il corso e superato l'esame,
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
						<h2>Corsi</h2>
					</div>
					<br>
					<div class="bot">
						<h3>Prodotti in base ai tuoi corsi</h3>
						<p>
							Naviga tra i prodotti per trovare pi&ugrave; velocemente i contenuti che cerchi, grazie alla
							nostra ricerca intuitiva che ti permetter&agrave; di navigare tra tutti i prodotti relativi al tuo corso universitario e di trovare i
							contenuti in base alla materia che li richiede.
						</p>
						<div><a href="CercaProdottiCorsi">Naviga</a></div>
					</div>

				</div>

				<div class="column">
					<div class="top">
						<img src="images/home/facolta.jpg" >
						<h2>Facolt&agrave;</h2>
					</div>
					<br>
					<div class="bot">
						<h3>Prodotti in base alle facolt&agrave;</h3>
						<p>
							Naviga tra le facolt&agrave; per trovare pi&ugrave; velocemente i contenuti che cerchi, grazie alla
							nostra ricerca intuitiva che ti permetter&agrave; di navigare tra le principali facolt&agrave; universitarie e di trovare i
							contenuti in base alla facolt&agrave; che li richiede.
						</p>
						<div><a href="facolta.jsp">Naviga</a></div>
					</div>

				</div>

				<!--  
				<div class="column">
					<div class="top">
						<img src="images/home/universita.jpg" >
						<h2>Universit&agrave;</h2>
					</div>
					<br>
					<div class="bot">
						<h3>Prodotti in base alle univesit&agrave;</h3>
						<p>
							Naviga tra le universit&agrave; per trovare pi&ugrave; velocemente i contenuti che cerchi, grazie alla nostra
							ricerca intuitiva che ti permetter&agrave; di navigare tra tutte le universit&agrave; italiane e di trovare i contenuti in base
							all'universit&agrave; che li richiede.
						</p>
						<div><a href="universita.jsp">Naviga</a></div>
					</div>
				</div>
				--> 
			</aside>
		</section>

		<div id="help">
			<div id="padredimerda">
				<div id="SX">
					<div id="label">
						<img src="images/home/help.png">
					</div>
				</div>
				<div id="DX">
					<div id="label">
						<div id="sx">
							<h3>Supporto Tecnico</h3>
							<p>Visita la nostra pagina speciale che spiega il funzionamento della piattaforma e fornisce i contatti di assistenza.</p>
						</div>
						<div id="dx">
							<div><a href="aiuto.jsp">Naviga</a></div>
						</div>
					</div>
				</div>
			</div>
		</div>
			
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
