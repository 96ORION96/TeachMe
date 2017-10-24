<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="utente" class="Beans.UtenteBeans" scope="session"></jsp:useBean>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/favorite.css">
<title>Preferiti</title>
<link rel="icon" href="images/t.ico" />
</head>
<body>
<main>

	   <header>
			<div id="header1">
				<h1>Preferiti</h1>
			</div>
			<div id="header2">
				<img src="images/favorite.png">
			</div>
		</header>

		<%@ include file="nav.jsp" %>
		
		<section>
		
			<%if(!utente.isLogin()){%>
				<div><h3>Devi registrarti prima di procedere agli acquisti</h3></div>
			<%}else{ %>
				<div><h3>ciao <%=utente.getNome()%></h3></div>
				<%if(utente.getLibri()!=null){ %>
					<%for(int i=0;i<utente.getLibri().size();i++){ %>
					<%=utente.getLibri().get(i).toString() %>
				
				<%}
				}
				}%>
				
				
				
							
		</section>

		<footer>
			<h3>Copyright &copy; 2017 Dalton's Inc. tutti i diritti riservati </h3>
		</footer>
	</main>
</body>
</html>
