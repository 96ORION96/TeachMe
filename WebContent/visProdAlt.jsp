<%@page import="beans.LezioneBeans"%>
<%@page import="beans.AppuntiBeans"%>
<%@page import="beans.LibroBeans"%>
<%@page import="java.util.ArrayList"%>
<%@page import="beans.UtenteBeans"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:useBean id="utente" class="beans.UtenteBeans" scope="session"></jsp:useBean>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="script/aggiungiPreferitiScript.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/visualizzaProdotti.css">
<link rel="stylesheet" type="text/css" href="css/metaVISUALIZZA.css">
<title>Teach Me</title>
<link rel="icon" href="images/t.ico" />
</head>
<body>
	<%@ include file="nav.jsp" %>

    <section>
		<div id="label">	
				<%ArrayList<LibroBeans> libri= (ArrayList<LibroBeans>)request.getAttribute("libri"); %>
					<%if(!libri.isEmpty()){%>
						<%for(int i=0;i<libri.size();i++){ %>
							<h3>
								[LIBRO] Titolo: <%= libri.get(i).getTitolo() %>,  
					 			E-mail: <%= libri.get(i).getMail()%>,  
					 			Prezzo: <%= libri.get(i).getPrezzo() %> 
								<%if(utente.isLogin()){%>
									<button onclick="funCarr('<%= libri.get(i).getId() %>')">Aggiungi ai preferiti</button>
								<%}%>
							</h3>
						<%}
					}%>
					
					<%ArrayList<AppuntiBeans> appunti= (ArrayList<AppuntiBeans>)request.getAttribute("appunti"); %>
					<%if(!appunti.isEmpty()){%>
						<%for(int j=0;j<appunti.size();j++){ %>
							<h3>
								[APPUNTI] Titolo: <%= appunti.get(j).getTitolo() %>,  
								E-mail: <%= appunti.get(j).getMail()%>,  
								Prezzo: <%= appunti.get(j).getPrezzo() %>
								<%if(utente.isLogin()){%>
									<button onclick="funCarr('<%= appunti.get(j).getId() %>')">Aggiungi ai preferiti</button>
								<%}%>
							</h3>
						<%}
					}%>
					
					<%ArrayList<LezioneBeans> lezioni= (ArrayList<LezioneBeans>)request.getAttribute("lezioni"); %>
					<%if(!lezioni.isEmpty()){%>
						<%for(int k=0;k<lezioni.size();k++){ %>
							<h3>
								[LEZIONE] Titolo: <%= lezioni.get(k).getTitolo() %>,  
								E-mail: <%= lezioni.get(k).getMail()%>,  
								Prezzo: <%= lezioni.get(k).getPrezzo()%>
								<%if(utente.isLogin()){%>
									<button onclick="funCarr('<%= lezioni.get(k).getId() %>')">Aggiungi ai preferiti</button>
								<%}%>
							</h3>
						<%}
					}%>
					<%if(libri.isEmpty() && appunti.isEmpty() && lezioni.isEmpty()){%>
						<h3 style= "font-family: 'SanFranciscoR', sans-serif; font-size: 16pt;">Attualmente non vi sono prodotti per questa facolt&agrave</h3>
					<%}%>
				
		</div>
    </section>
    
	<%@ include file="footer.jsp" %>
</body>
</html>


