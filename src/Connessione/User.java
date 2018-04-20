package Connessione;
import java.util.ArrayList;

import beans.AppuntiBeans;
import beans.LezioneBeans;
import beans.LibroBeans;
import beans.UtenteBeans;

public class User{
	
	private boolean login;
	private boolean errorLog;
	private ArrayList<LibroBeans>libri;
	private ArrayList<AppuntiBeans>appunti;
	private ArrayList<LezioneBeans>lezioni;
	private UtenteBeans utente;
	private boolean errorCart; 
	private boolean emptyCart;
	public User() {
		login=false;
		errorLog=false;
		libri=null;
		appunti=null;
		lezioni=null;
		utente=null;
		errorCart=false;
		emptyCart=false;
	}


	public boolean isLogin() {
		return login;
	}


	public void setLogin(boolean login) {
		this.login = login;
	}


	public boolean isErrorLog() {
		return errorLog;
	}


	public void setErrorLog(boolean error) {
		this.errorLog = error;
	}


	public ArrayList<LibroBeans> getLibri() {
		return libri;
	}


	public void setLibri(ArrayList<LibroBeans> libri) {
		this.libri = libri;
	}


	public UtenteBeans getUtente() {
		return utente;
	}


	public void setUtente(UtenteBeans utente) {
		this.utente = utente;
	}


	public boolean isErrorCart() {
		return errorCart;
	}


	public void setErrorCart(boolean errorCart) {
		this.errorCart = errorCart;
	}


	public boolean isEmptyCart() {
		return emptyCart;
	}


	public void setEmptyCart(boolean emptyCart) {
		this.emptyCart = emptyCart;
	}


	public ArrayList<AppuntiBeans> getAppunti() {
		return appunti;
	}


	public void setAppunti(ArrayList<AppuntiBeans> appunti) {
		this.appunti = appunti;
	}


	public ArrayList<LezioneBeans> getLezioni() {
		return lezioni;
	}


	public void setLezioni(ArrayList<LezioneBeans> lezioni) {
		this.lezioni = lezioni;
	}
	
	

}
