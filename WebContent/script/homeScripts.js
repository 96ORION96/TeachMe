//SRIPT HOMEPAGE



// SCRIPT LOGIN A COMPARSA

function loginMenu(){
	var login= document.getElementById("login");

	if(login.classList.contains("open")){
		login.classList.remove("open");
	}
	else{
		login.classList.add("open");
	}
}

// SCRIPT BLOCCO NAVBAR

window.onscroll= function(){ navLock() };

function navLock(){
	var logo= document.getElementById("logo");
	var headerHeight= document.getElementById("header").offsetHeight;
	var container= document.getElementById("container");

	if(document.body.scrollTop>headerHeight){
		document.getElementById("nav").classList.add("nav");
		logo.classList.remove("logo");
		container.style.marginTop= "55px";
		logo.style.transition= "all .1s";
	}
	else{
		document.getElementById("nav").classList.remove("nav");
		logo.classList.add("logo")
		container.style.marginTop= "0px";
		logo.style.transition= "all .2s ";
	}
}

// SCRIPT SLIDER

var first_pic;
var index;
var timer;
var timerForward;
var a;
var b;
var c;

window.onload= function() { 
	first_pic= document.getElementById("0");
	index= 0;
	changeColor(index);

	timerForward= function() {
		index++;
		if(index>2){
			index=0;
		}
		first_pic.style.zIndex = "-1";
		first_pic= document.getElementById(""+ index);
		first_pic.style.zIndex = "1";
		changeColor(index);

	}
	timer= setInterval(timerForward, 5000);
}

function slide(flag){
	changeColor(index);
	
	if(flag){
		index++;
		clearInterval(timer);
		timer= setInterval(timerForward, 5000);
	} else{
		index--;
		clearInterval(timer);
		timer= setInterval(timerForward, 5000);
	}
	if(index<0){
		index=2;
	}
	if(index>2){
		index=0;
	}

	first_pic.style.zIndex = "-1";
	first_pic= document.getElementById(""+ index);
	first_pic.style.zIndex = "1";
	changeColor(index);
}

function changeColor(index){
	a= document.getElementById("a");
	b= document.getElementById("b");
	c= document.getElementById("c");
	
	if(index==0){
		a.style.backgroundColor= "rgb(45, 156, 66)";
		a.style.width= "20px";
		a.style.height= "20px";
		b.style.backgroundColor= "rgb(241, 241, 241)";
		b.style.width= "15px";
		b.style.height= "15px";
		c.style.backgroundColor= "rgb(241, 241, 241)";
		c.style.width= "15px";
		c.style.height= "15px";
	}
	if(index==1){
		a.style.backgroundColor= "rgb(241, 241, 241)";
		a.style.width= "15px";
		a.style.height= "15px";
		b.style.backgroundColor= "rgb(45, 156, 66)";
		b.style.width= "20px";
		b.style.height= "20px";
		c.style.backgroundColor= "rgb(241, 241, 241)";
		c.style.width= "15px";
		c.style.height= "15px";
	}
	if(index==2){
		a.style.backgroundColor= "rgb(241, 241, 241)";
		a.style.width= "15px";
		a.style.height= "15px";
		b.style.backgroundColor= "rgb(241, 241, 241)";
		b.style.width= "15px";
		b.style.height= "15px";
		c.style.backgroundColor= "rgb(45, 156, 66)";
		c.style.width= "20px";
		c.style.height= "20px";
	}
	
}

