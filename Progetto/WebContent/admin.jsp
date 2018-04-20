<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Area rirvata agli Admin</title>
<link rel="icon" href="images/t.ico" />
<link rel="stylesheet" type="text/css" href="css/admin.css">
<link rel="stylesheet" type="text/css" href="css/metaADMIN.css">
</head>
<body>
	<section>
		<div id="label">
			<div id="top"><h2>Rimozione Utenti</h2></div>
			<div id= "middle">
				<form method="get" action="/Progetto/RimuoviUtente">
					<div id="top">
						<p>Insirisci e-mail dell'utente da eliminare:</p>
						<input type="text"  name="email" required autocomplete="on" autofocus>
					</div>
					<div id="bot">
						<div><input type="submit" value="Rimuovi"></input></div>
					</div>
				</form>	
			</div>
			<div id="bot"><form action="Logout" method="get"><input id="logout" title="Disconettiti" type="submit" value="Logout"></form></div>
		</div>
	</section>	
</body>
</html>

