/**
 * 
 */

function funCarr(elemento){
	
	ajax = new XMLHttpRequest();
	ajax.open("get","http://localhost:8080/Progetto/Carrello?id="+elemento,true);
	ajax.setRequestHeader("connection","close");
	
	ajax.onreadystatechange = function() {
		if(ajax.readyState === 4) {
			  if(ajax.status == 200){
			  	//OK
			  
			  }else{
			    alert("Operazione carrello fallita, errore numero " + ajax.status);
			  }
		 }
	}
	ajax.send(null);
}


function passaggioParamRicerca(valore){
	
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
		  if(ajax.status == 200){
		  	var lista = JSON.parse(ajax.responseText);
		  	document.getElementById("res").innerHTML="";
		  	for(var i=0;i<lista.length;i++){
		  		console.log(lista[i])
		  		document.getElementById("res").innerHTML+="Titolo: "+lista[i].titolo+"        , E-mail: "+lista[i].mail+"        , Prezzo: "+lista[i].prezzo;
		  		var btn = document.createElement('button');
	            document.getElementById("res").appendChild(btn);
	            var textbtn = document.createTextNode("Aggiungi ai preferiti");
	            btn.appendChild(textbtn);
	            btn.setAttribute('onclick', "funCarr('"+lista[i].id+"')");
	            document.getElementById("res").innerHTML+="<br/><br/>"
		  	}
		  }else
		    alert("Operazione ricerca fallita, errore numero " + ajax.status);
		  }
		}
	ajax.send(null);
	
}



function passaggioParamRicercaALT(valore){
	
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
		  if(ajax.status == 200){
		  	var lista = JSON.parse(ajax.responseText);
		  	document.getElementById("res").innerHTML="";
		  	for(var i=0;i<lista.length;i++){
		  		console.log(lista[i])
		  		document.getElementById("res").innerHTML+="Titolo: "+lista[i].titolo+"        , E-mail: "+lista[i].mail+"        , Prezzo: "+lista[i].prezzo
	            document.getElementById("res").innerHTML+="<br/><br/>"
		  	}
		  }else
		    alert("Operazione ricerca fallita, errore numero " + ajax.status);
		  }
		}
	ajax.send(null);
	
}