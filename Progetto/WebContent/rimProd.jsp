<%@page import="beans.LezioneBeans"%>
<%@page import="beans.AppuntiBeans"%>
<%@page import="beans.LibroBeans"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="beans.UtenteBeans"%>
<jsp:useBean id="utente" class="beans.UtenteBeans" scope="session"></jsp:useBean>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/rimuoviProdotti.css">
<link rel="stylesheet" type="text/css" href="css/metaRIMUOVI.css">
<title>Teach Me</title>
<link rel="icon" href="images/t.ico" />
</head>
<body>
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
		<section>
			<div id="label">
			<%ArrayList<LibroBeans> libri= (ArrayList<LibroBeans>)request.getAttribute("libri"); %>
			<%if(!libri.isEmpty()){%>
				<%for(int i=0;i<libri.size();i++){ %>
					<h3>[LIBRO] Titolo: <%= libri.get(i).getTitolo() %>,  
			 		E-mail: <%= libri.get(i).getMail()%>,  
			 		Prezzo: <%= libri.get(i).getPrezzo() %>
					<button onclick="rimuovi('<%= libri.get(i).getId() %>','libro')">Rimuovi</button></h3>
				<%} 
			}%>
			
			<%ArrayList<AppuntiBeans> appunti= (ArrayList<AppuntiBeans>)request.getAttribute("appunti"); %>
			<%if(!appunti.isEmpty()){%>
				<%for(int j=0;j<appunti.size();j++){ %>
					<h3>[APPUNTI] Titolo: <%= appunti.get(j).getTitolo() %>,  
					E-mail: <%= appunti.get(j).getMail()%>,  
					Prezzo: <%= appunti.get(j).getPrezzo() %>
			    		<button onclick="rimuovi('<%= appunti.get(j).getId() %>','appunti')">Rimuovi</button></h3>
				<%} 
			}%>
			
			<%ArrayList<LezioneBeans> lezioni= (ArrayList<LezioneBeans>)request.getAttribute("lezioni"); %>
			<%if(!lezioni.isEmpty()){%>
				<%for(int k=0;k<lezioni.size();k++){ %>
					<h3>[LEZIONE] Titolo: <%= lezioni.get(k).getTitolo() %>,  
					E-mail: <%= lezioni.get(k).getMail()%>,  
					Prezzo: <%= lezioni.get(k).getPrezzo() %> 
			   		<button onclick="rimuovi('<%= lezioni.get(k).getId() %>','lezioni')">Rimuovi</button></h3>
				<%}
			}%>
			<%if(libri.isEmpty() && appunti.isEmpty() && lezioni.isEmpty()){%>
				<h3 style= "font-family: 'SanFranciscoR', sans-serif; font-size: 16pt;">Non hai prodotti in vendita</h3>
			<%}%>
			</div>
		</section>
		<%}else{%>
			<section id="sectionALT">
				<div id="labelALT"></div>
			</section>
		<%}%>
		<footer>
			<h3>Copyright &copy; 2017 Dalton's Inc. tutti i diritti riservati </h3>
		</footer>
</body>
</html>

<script>
function rimuovi(val,tipo){
	ajax = new XMLHttpRequest();
	ajax.open("get","http://localhost:8080/Progetto/RimuoviProdotto?id="+val+"&tipo="+tipo,true);
	
	ajax.setRequestHeader("connection","close");
	
	ajax.onreadystatechange = function() {
		if(ajax.readyState === 4) {
			  if(ajax.status == 200){
			  	//OK
				  location.reload();
			  }else{
			    alert("Operazione carrello fallita, errore numero " + ajax.status);
			  }
		 }
	}
	ajax.send(null);
	
}



</script>