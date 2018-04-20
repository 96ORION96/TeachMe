
function checkMail(campo) {
	var regex=new RegExp("^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@studenti.unisa.it$");
	var input=campo.val();
	
	if(regex.test(input)){
        $("#mailSpan").removeClass("visible");
        $("#mailSpan").addClass("invisible");
        return true;
     }else {
        $("#mailSpan").removeClass("invisible");
        $("#mailSpan").addClass("visible");
        return false;
     }
	return false;
}

function checkPsw(campo) {
	var regex= new RegExp("^[a-zA-Z0-9\.-_]{1,10}$");
	var input=campo.val();
    if(regex.test(input)){
        $("#pswSpan").removeClass("visible");
        $("#pswSpan").addClass("invisible");
        return true;
    }else {
    	  $("#pswSpan").removeClass("invisible");
    	  $("#pswSpan").addClass("visible");
    	  return false;
     }
     return false;
}

function checkPswConf(campo) {
	var pswConf= campo.val();
	var psw=$("[name='psw']").val()
	if(psw==pswConf) {
        $("#pswConfSpan").removeClass("visible");
        $("#pswConfSpan").addClass("invisible");
        return true;
    }else {
    	  $("#pswConfSpan").removeClass("invisible");
    	  $("#pswConfSpan").addClass("visible");
    	  return false;
     }
	return false;
}

function checkMat(campo) {
	var regex=new RegExp("^[0-9]{4}$");
	var input=campo.val();
    if(regex.test(input)){
    	 $("#matSpan").removeClass("visible");
        $("#matSpan").addClass("invisible");
        return true;
    }else{
        $("#matSpan").removeClass("invisible");
        $("#matSpan").addClass("visible");
        return false;
     }
    return false;
}

function checkNome(campo) {
	var regex = new RegExp("^[a-zA-Z]{1,20}$");
	var input=campo.val();
	if(regex.test(input)){
        $("#nameSpan").removeClass("visible");
        $("#nameSpan").addClass("invisible");
        return true;
	}else {
		  $("#nameSpan").removeClass("invisible");
		  $("#nameSpan").addClass("visible");
		  return false;
	 }
	return false;
}

function checkSurname(campo) {
	var regex = new RegExp("^[a-zA-Z\S]{1,20}$");
	var input=campo.val();
	if(regex.test(input)){
        $("#surnameSpan").removeClass("visible");
        $("#surnameSpan").addClass("invisible");
        return true;
	}else {
		  $("#surnameSpan").removeClass("invisible");
		  $("#surnameSpan").addClass("visible");
		  return false;
	 }
	return false;
}


function checkAll() {
	
    if( checkPsw($("[name='psw']")) && checkPswConf($("[name='pswConf']")) && checkNome($("[name='nome']")) && checkSurname($("[name='cognome']")) && checkMail($("[name='mail']")) && checkMat($("[name='matricola']"))){
    	alert("registrazione avvenuta")	
    	return true;		
    }
    alert("registrazione non avvenuta")
    return false;
    
}
