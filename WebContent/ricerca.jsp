
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="Beans.LibroBeans"%>
<%@page import="java.util.ArrayList"%>
<jsp:useBean id="utente" class="Beans.UtenteBeans" scope="session"></jsp:useBean>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/ricerca.css">
<title>Teach Me</title>
<link rel="icon" href="images/t.ico" />
</head>
<body>
	<%@ include file="nav.jsp" %>

    <section>
		<div id="top">
			<div>
			<form >
		
 	 		<input type="radio" name="tipo" value="appunti" > appunti
 		    <input type="radio" name="tipo" value="lezioni"> lezioni
		    <input type="radio" name="tipo" value="libri"checked> libri  
			 
				<select name="universita">
  					<option value="unisa">Fisciano</option>
				</select>
				<select name="facolta">
  					<option value="informatica">Informatica</option>
					<option value="matematica">Matematica</option>
				</select>
				<select name="corso">
  					<option value="C">Programmazione C</option>
					<option value="algoritmi">Algoritmi</option>
					<option value="java">Java</option>
					<option value="analisi">Analisi</option>
					
					<input type="button" value="cerca" onclick="fun(this.form.elements)"/>
				</select>
			</form>
			</div>
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

<script>
function fun(valore){
	
	ajax= new XMLHttpRequest();
	
	if(valore[0].checked){
		ajax.open("get","http://localhost:8080/Progetto/Acquisti?corso="+valore["corso"].value+"&tipo="+valore[0].value+"&facolta="+valore["facolta"].value+"&universita="+valore["universita"].value,true);	
	}
	if(valore[1].checked){
		ajax.open("get","http://localhost:8080/Progetto/Acquisti?corso="+valore["corso"].value+"&tipo="+valore[1].value+"&facolta="+valore["facolta"].value+"&universita="+valore["universita"].value,true);	
	}
	if(valore[2].checked){
		ajax.open("get","http://localhost:8080/Progetto/Acquisti?corso="+valore["corso"].value+"&tipo="+valore[2].value+"&facolta="+valore["facolta"].value+"&universita="+valore["universita"].value,true);	
	}
	
	
	ajax.setRequestHeader("connection", "close");

	ajax.onreadystatechange = function() {
		  if(ajax.readyState === 4) {
		  if(ajax.status == 200)
		   document.getElementById("res").innerHTML=ajax.responseText;
		  else
		    alert("Operazione fallita, errore numero " + ajax.status);
		  }
		}
	ajax.send(null);
	
	function funCarr(ogg){
		alert("ciaoo")
	}
}
</script>
