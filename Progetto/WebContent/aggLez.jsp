<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 <%@page import="beans.UtenteBeans"%>
<jsp:useBean id="utente" class="beans.UtenteBeans" scope="session"></jsp:useBean>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/aggiungiProdotto.css">
<link rel="stylesheet" type="text/css" href="css/metaAGGIUNGI.css">
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
			<div id="label">
				<div id="top"><h2>Aggiungi una lezione in vendita</h2></div>
				<div id="bot">
					<form method="get" action="/Progetto/InsLezioni">
						<div id="sx">
							<p>Titolo:</p>
							<input type="text"  name="titolo" autofocus>
							<p>Materia:</p>
							<input type="text" name="mat" required>
							<p>Facolt&agrave:</p>
							<input type="text" name="fac" required>
							<p>Universit&agrave:</p>
							<input type="text" name="uni" required>
							<p>Prezzo:</p>
							<input type="text" name="prezzo" required>
						</div>
						<div id="dx"><div><input type="submit" value="Aggiungi"></input></div></div>
					</form>
				</div>	
			</div>
		</section>

		<footer>
			<h3>Copyright &copy; 2017 Dalton's Inc. tutti i diritti riservati </h3>
		</footer>
	</main>
</body>
</html>
