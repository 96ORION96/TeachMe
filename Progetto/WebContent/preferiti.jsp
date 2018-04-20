<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="utente" class="beans.UtenteBeans" scope="session"></jsp:useBean>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/favorite.css">
<link rel="stylesheet" type="text/css" href="css/metaFAVORITE.css">
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

		<%@ include file="nav.jsp"%>
		
		<section>
			<div id="label">
				<%if(!utente.isLogin()){%>
					<div><h3 style= "font-family: 'SanFranciscoR', sans-serif; font-size: 16pt;">Devi accedere per poter aggiungere elementi a questa sessione</h3></div>
				<%}%>
				
				
			
				<%if(utente.isLogin()){%>
					<%if(utente.getAppunti().isEmpty() && utente.getLezioni().isEmpty() && utente.getLibri().isEmpty()){%>
						<div><h3 style= "font-family: 'SanFranciscoR', sans-serif; font-size: 16pt;">Attualmente non hai aggiunto prodotti ai preferiti</h3></div>
					<%}%>	
					
					<%if(!utente.getAppunti().isEmpty() || !utente.getLezioni().isEmpty() || !utente.getLibri().isEmpty()){%>
						<div id="button"><button onclick="rimuovi()">Rimuovi tutto</button></div>
					<%}%>
					
					<%if(!utente.getAppunti().isEmpty()){ %>
						<%for(int i=0;i<utente.getAppunti().size();i++){ %>
							<h3>[APPUNTI] Titolo: <%=utente.getAppunti().get(i).getTitolo()%>,
							E-mail: <%=utente.getAppunti().get(i).getMail()%>,
							Prezzo: <%=utente.getAppunti().get(i).getPrezzo() %></h3>
						<%}
					}%>
					
					<%if(!utente.getLezioni().isEmpty()){ %>
						<%for(int j=0;j<utente.getLezioni().size();j++){ %>
							<h3>[LEZIONE] Titolo: <%=utente.getLezioni().get(j).getTitolo()%>,
							E-mail: <%=utente.getLezioni().get(j).getMail() %>,
							Prezzo: <%=utente.getLezioni().get(j).getPrezzo() %></h3>
						<%}
					}%>
							
					<%if(!utente.getLibri().isEmpty()){ %>
						<%for(int k=0;k<utente.getLibri().size();k++){ %>
					 		<h3>[LIBRO] Titolo: <%=utente.getLibri().get(k).getTitolo()%>,
							E-mail: <%=utente.getLibri().get(k).getMail() %>,
							Prezzo: <%=utente.getLibri().get(k).getPrezzo() %></h3>
						<%}
					}%>	
				<%}%>
			</div>												
		</section>

		<footer>
			<h3>Copyright &copy; 2017 Dalton's Inc. tutti i diritti riservati </h3>
		</footer>
	</main>
</body>
</html>

<script>
function rimuovi(){
	ajax = new XMLHttpRequest();
	ajax.open("get","http://localhost:8080/Progetto/RimuoviPreferiti?rimuovi=si");
	ajax.setRequestHeader("connection","close");
	
	ajax.onreadystatechange = function() {
		if(ajax.readyState === 4) {
			  if(ajax.status == 200){
			  location.reload();
			  }else{
			    alert("Operazione carrello fallita, errore numero " + ajax.status);
			  }
		 }
	}
	ajax.send(null);
}
</script>

