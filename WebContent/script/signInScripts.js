
function checkUser(campo) {
    	var regex = new RegExp("^[a-zA-Z0-9]{6,12}$");
    	var input=campo.val();
    	if(regex.test(input)){
    		$("#userSpan").removeClass("visible");
        $("#userSpan").addClass("invisible");
    	}else {
    		  $("#userSpan").removeClass("invisible");
    		  $("#userSpan").addClass("visible");
    	 }
}

function checkPsw(campo) {
	var regex= new RegExp("^[a-zA-Z0-9\.-_]{1,6}$");
	var input=campo.val();
    if(regex.test(input)){
        $("#pswSpan").removeClass("visible");
        $("#pswSpan").addClass("invisible");
    }else {
    	  $("#pswSpan").removeClass("invisible");
    	  $("#pswSpan").addClass("visible");
     }
}

function checkPswConf(campo) {
	
	var pswConf= campo.val();
	var psw=$("[name='psw']").val()
	if(psw==pswConf) {
        $("#pswConfSpan").removeClass("visible");
        $("#pswConfSpan").addClass("invisible");
    }else {
    	  $("#pswConfSpan").removeClass("invisible");
    	  $("#pswConfSpan").addClass("visible");
     }
}

function checkMat(campo) {
	var regex=new RegExp("^[0-9]{11}$");
	var input=campo.val();
    if(regex.test(input)){
    	 $("#matSpan").removeClass("visible");
        $("#matSpan").addClass("invisible");
    }else{
        $("#matSpan").removeClass("invisible");
        $("#matSpan").addClass("visible");
     }
}

function checkNome(campo) {
	var regex = new RegExp("^[a-zA-Z]{1,20}$");
	var input=campo.val();
	if(regex.test(input)){
        $("#nameSpan").removeClass("visible");
        $("#nameSpan").addClass("invisible");
	}else {
		  $("#nameSpan").removeClass("invisible");
		  $("#nameSpan").addClass("visible");
	 }
}

function checkSurname(campo) {
	var regex = new RegExp("^[a-zA-Z\S]{1,30}$");
	var input=campo.val();
	if(regex.test(input)){
        $("#surnameSpan").removeClass("visible");
        $("#surnameSpan").addClass("invisible");
	}else {
		  $("#surnameSpan").removeClass("invisible");
		  $("#surnameSpan").addClass("visible");
	 }
}



function checkMail(campo) {
	var regex=new RegExp("^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$");
	var input=campo.val();
	
	if(regex.test(input)){
        $("#mailSpan").removeClass("visible");
        $("#mailSpan").addClass("invisible");
     }else {
        $("#mailSpan").removeClass("invisible");
        $("#mailSpan").addClass("visible");
     }
}

function checkAdress(campo) {
	var regex = new RegExp("^[a-zA-Z\S]{1,60}$");
	var input=campo.val();
	if(regex.test(input)){
        $("#adressSpan").removeClass("visible");
        $("#adressSpan").addClass("invisible");
	}else {
		  $("#adressSpan").removeClass("invisible");
		  $("#adressSpan").addClass("visible");
	 }
}


function checkCap(campo) {
	var regex=new RegExp("^[0-9]{5}$");
	var input=campo.val();
    if(regex.test(input)){
    	$("#capSpan").removeClass("visible");
        $("#capSpan").addClass("invisible");
    }else {
    	$("#capSpan").removeClass("invisible");
        $("#capSpan").addClass("visible");
     }


}


function checkAll() {
    checkUser($("[name='user']"));
    checkPsw($("[name='psw']"));
    checkPswConf($("[name='pswConf']"));
    checkMat($("[name='matricola']"));
    checkNome($("[name='nome']"));
    checkSurname($("[name='cognome']"));
    checkMail($("[name='mail']"));
    checkAdress($("[name='adress']"));
    checkCap($("[name='cap']"));
}



	function autocomplete(){
	var data = ["alessandro","antonio","asia","ada","auciello"];

	$("[name='cap']").autocomplete({
			source:data	//SOURCE è FISSO, DATA è IL NOME DELL'ARRAY DI STRINGHE DA DOVE SCEGLIERE LE PROLE DA SUGGERIRE
	});
}