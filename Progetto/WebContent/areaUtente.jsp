<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<%@page import="beans.UtenteBeans"%>
<jsp:useBean id="utente" class="beans.UtenteBeans" scope="session"></jsp:useBean>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name= "viewport" content="width= device-width">
<link rel="stylesheet" type="text/css" href="css/user.css">
<link rel="stylesheet" type="text/css" href="css/metaUSER.css">
<title>Area Utente</title>
<link rel="icon" href="images/t.ico" />
</head>
<body>
<main>
		<header>
			<div id="header1">
				<h1>Area Utente</h1>
			</div>
			<div id="header2">
				<img src="images/user.png">
			</div>
		</header>
		
		<%@ include file="nav.jsp" %>
		
		<%if(utente.isLogin()){%>
		<%String errdouble = (String) request.getAttribute("double"); %>
							
								<%if(errdouble != null){ %>
									<script type="text/javascript">alert("Campo prezzo non valido")</script>	
								<%} %>
		
		<section>
			<div id="SX">
				<div id="label">
					<div id="TOP">
						<div><h2>Dati Utente</h2></div>
					</div>
					<div id="BOT">
						<div id="top">
							<div>Nome: <%=utente.getNome()%></div>
							<div>Cognome: <%=utente.getCognome()%></div>
							<div>Matricola: <%=utente.getMatricola()%></div>
							<div>Citta: <%=utente.getCitta()%></div>
							<div>E-mail: <%=utente.getEmail()%></div>
							<div>Facolta: <%=utente.getFacolta()%></div>
							<div>Universita: <%=utente.getUniversita()%></div>
						</div>
						<div id="bot"><form action="Logout" method="get"><input id="logout" title="Disconettiti" type="submit" value="Logout"></form></div>
					</div>
				</div>
			</div>
			<div id="DX">
				<div id="labels">
					<div class="label"><div class="sx">Metti in vendita lezioni</div><div class="dx"><a href="aggLez.jsp">Aggiungi Lezione</a></div></div>
					<div class="label"><div class="sx">Metti in vendita libri</div><div class="dx"><a href="aggLib.jsp">Aggiungi Libro</a></div></div>
					<div class="label"><div class="sx">Metti in vendita appunti</div><div class="dx"><a href="aggApp.jsp">Aggiungi Appunti</a></div></div>
					<div class="label"><div class="sx"><form method="get" action="/Progetto/CercaProdotti">Rimuovi prodotto</div><div class="dx"><input type="submit" value="Rimuovi Prodotti" ></form></div></div>
				</div>
			</div>
		</section>
		
		<%}else{%>
			<section id="sectionALT">
				<div id="labelALT">
					<div id="top"><h2>Non hai effettuato l'accesso</h2></div>
					<div id= "middle">
						<form method="get" action="/Progetto/Login">
							<div id="top">
								<p>Indirizzo e-mail:</p>
								<input type="text"  name="mail" required autocomplete="on" autofocus>
								<p>Password:</p>
								<input type="password" name="psw" maxlength="15" required>						
							</div>
							<div id="bot">
								<div><input type="submit" value="Accedi"></input></div>
							</div>
						</form>	
					</div>
					<div id="bot"><div id="button"><a href="registrazione.jsp">Registrati</a></div></form></div>
				</div>
			</section>
		<%}%>
					
		<footer>
			<h3>Copyright &copy; 2017 Dalton's Inc. tutti i diritti riservati </h3>
		</footer>
	</main>
</body>
</html>
