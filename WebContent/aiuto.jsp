<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="beans.UtenteBeans"%>
<jsp:useBean id="utente" class="beans.UtenteBeans" scope="session"></jsp:useBean>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset= UTF-8">
<title>Supporto</title>
<link rel="icon" href="images/t.ico" />
<link rel="stylesheet" type="text/css" href="css/help.css">
</head>

<body>
	<%@ include file="nav.jsp"%>
	<section>
	<div id="label">
		<div>
				<h3>Descrizione della piattaforma</h3>
				<p>La piattaforma permette la compravendita di prodotti per universitari, può essere utilizzata senza effettuare l'accesso anche se
				molte azioni sono personalizzate in base ai dati inseriti dall'utente durante la registrazione</p>
				<p>Le immagine che scorrono (slider) al centro della pagina iniziale permettono di accedere con un click ai prodotti in base ai 
				dati inseriti durante la registrazione (es. se si clicca sull'immagine relativa alle lezioni verranno mostrate tutte le lezioni relative ai nostri dati).</p>
				<p>Le sezioni sottostanti, ovvero: "Prodotti in base ai tuoi corsi" e "Prodotti in base alle facoltà" permettono attraverso il click 
				del punsante "Naviga" di visualizzare rispettivamente i prodotti, in base alla facoltà inserita durante la registrazione e in base alla
				facoltà scelta tra quelle proposte dalla piattaforma.</p>
				<p>Le azioni di: registrazione, accesso, ricerca, aggiunta/rimozione dai preferiti e aggiunta/rimozione di prodotti in vendita risultano molto intuitive.
				Invogliamo comunque gli utenti a contattare il nostro addetto al supporto tecnico per eventuali problemi con la piattaforma o anche semplicemente per
				ricevere una mano nelle azioni di tutti i giorni, che possono risultare complesse soprattutto per le persone più anziane e meno esperte.</p>
				<br>
				<h3 style= "margin: 0;">Per supporto tecnico contattare: Carmine Valente</h3>
				<p>email: c.valente2@studenti.unisa.it</p>
				<p>cell: 3279083799</p>											
		</div>
	</div>
	</section>
	<%@ include file="footer.jsp"%>
</body>
</html>