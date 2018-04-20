<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/signIn.css">
<link rel="stylesheet" type="text/css" href="css/metaSIGNIN.css">
<link rel="stylesheet" type="text/css" href="css/tool.css">
<script src="script/jquery.js"></script>
<link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/themes/smoothness/jquery-ui.css">
<script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>
<script type="text/javascript" src="script/signInScripts.js"></script>
<title>Registrati</title>
<link rel="icon" href="images/t.ico" />
</head>

<body>
	<%@ include file="nav.jsp"%>
	<section>
	<div id="label">
		<div id="top">
			<div>
				<h2>Registrazione</h2>
			</div>
		</div>

		<form action="/Progetto/Registrazione" method="get" onSubmit="return checkAll();">
			<div id="middle">
				<div>
					<div style="position: relative">
						<p>Indirizzo e-mail:</p>
						<span id="mailSpan" class="tooltiptext invisible">e-mail non accettabile</span>
						<input type="text" name="mail" class="tooltip"  onblur="checkMail($(this));">
					</div>
					
					<div style="position: relative">
						<p>Password:</p>
						<span id="pswSpan" class="tooltiptext invisible">Password non accettabile</span>
						 <input type="password" name="psw" class="tooltip"  onblur="checkPsw($(this));">
					</div>

					<div style="position: relative">
						<p>Conferma Password:</p>
						<span id="pswConfSpan" class="tooltiptext invisible">Le due password non coincidono</span>
						<input type="password" name="pswConf" class="tooltip" onblur="checkPswConf($(this));">
					</div>
				</div>
				<div>
					<div style="position: relative">
						<p>Nome:</p>
						<span id="nameSpan" class="tooltiptext invisible">Nome non accettabile</span>
						<input type="text" name="nome" class="tooltip"  onblur="checkNome($(this));">
					</div>

					<div style="position: relative">
						<p>Cognome:</p>
						<span id="surnameSpan" class="tooltiptext invisible">Cognome non accettabile</span>
						<input type="text" name="cognome" class="tooltip" onblur="checkSurname($(this));">
					</div>
					
					<p>Citt&agrave;:</p>
					<input type="text" name="citta" >
				</div>
				
				<div>			
					<p>Facolt&agrave;:</p>
					<input type="text" name="facolta" >
					
					<p>Universit&agrave;:</p>
					<input type="text" name="uni" onMouseOver="autocomplete($(this));">
					
					<div style="position: relative">
						<p>Matricola:</p>
						<span id="matSpan" class="tooltiptext invisible">Matricola non accettabile</span>
						<input type="text" name="matricola" class="tooltip"	 onblur="checkMat($(this));">
					</div>
				</div>
			
			</div>
			<div id="bot">
				<div>
					<input type="submit" value="Registrati"></input>
				</div>
			</div>

		</form>
	</div>
	</section>
	<%@ include file="footer.jsp"%>
</body>
</html>
