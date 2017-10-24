<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@page import="Beans.UtenteBeans"%>
<jsp:useBean id="utente" class="Beans.UtenteBeans" scope="session"></jsp:useBean>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/user.css">
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
		
		<section>
			<div id="SX">
				<div id="dates">
					<div id="top">
						<div><h2>Dati Utente</h2></div>
					</div>
					<div id="bot">
						<div>Nome: <%=utente.getNome()%></div>
						<div>Cognome: <%=utente.getCognome()%></div>
						<div>Matricola: <%=utente.getMatricola()%></div>
						<div>Indirizzo: <%=utente.getIndirizzo()%></div>
						<div>Citta: <%=utente.getCitta()%></div>
						<div>Cap: <%=utente.getCap()%></div>
						<div>E-mail: <%=utente.getEmail()%></div>
						<div>Facolta: <%=utente.getFacolta()%></div>
						<div>Universita: <%=utente.getUniversita()%></div>
					</div>
				</div>
			</div>
			<div id="DX">
				<div id="adds">
					<div class="add"><div class="sx">Metti in vendita lezioni</div><div class="dx"><button>Aggiungi Lezione</button></div></div>
					<div class="add"><div class="sx">Metti in vendita libro</div><div class="dx"><button>Aggiungi Libro</button></div></div>
					<div class="add"><div class="sx">Metti in vendita appunti</div><div class="dx"><button>Aggiungi Appunti</button></div></div>
				</div>
			</div>
		</section>

		<footer>
			<h3>Copyright &copy; 2017 Dalton's Inc. tutti i diritti riservati </h3>
		</footer>
	</main>
</body>
</html>
