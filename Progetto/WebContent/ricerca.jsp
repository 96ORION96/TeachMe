
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="java.awt.List"%>
<%@page import="beans.LibroBeans"%>
<%@page import="java.util.ArrayList"%>

<% ArrayList<String> corsi = (ArrayList<String>) request.getAttribute("corsi"); %>
<% ArrayList<String> facolta = (ArrayList<String>) request.getAttribute("facolta"); %>
<% ArrayList<String> universita = (ArrayList<String>) request.getAttribute("universita"); %>

<jsp:useBean id="utente" class="beans.UtenteBeans" scope="session"></jsp:useBean>
<html>
<head>
<script type="text/javascript" src="script/aggiungiPreferitiScript.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/ricerca.css">
<title>Teach Me</title>
<link rel="icon" href="images/t.ico" />
</head>
<body>
	<%@ include file="nav.jsp" %>

    <section>
		<div id="top">
			<form>
				<input type="radio" name="tipo" value="appunti" ><p>Appunti</p>
 		    		<input type="radio" name="tipo" value="lezioni"><p>Lezioni</p>
		    		<input type="radio" name="tipo" value="libri"checked><p>Libri</p>  
		    		
				<select name="universita">
  					<%for(String u: universita){%>
  						<option value="<%= u %>"><%= u %></option>
  					
  					<%} %>	
				</select>
				<select name="facolta">
  					<%for(String f: facolta){%>
  						<option value="<%= f %>"><%= f %></option>
  					
  					<%} %>	
				</select>
				<select name="corso">
  					<%for(String c: corsi){%>
  						<option value="<%= c  %>"><%= c %></option>
  					
  					<%} %>	
				</select>
				
				<%if(!utente.isLogin()){ %>
					<div><input type="button" value="Cerca" onclick="passaggioParamRicercaALT(this.form.elements)"/></div>
				<%}else{%>
					<div><input type="button" value="Cerca" onclick="passaggioParamRicerca(this.form.elements)"/></div>
				<%}%>

			</form>
		</div>

		<div id="bot">
			<div>
				<h3 id="res"></h3>	
			</div>
		</div>
    </section>
	<%@ include file="footer.jsp" %>
</body>
</html>


