package Beans;

import java.util.ArrayList;

public class UtenteBeans {
	
	public UtenteBeans() {
		
	}
	
	public UtenteBeans(String username, String psw, int matricola,
			String nome, String cognome, String facolta, String universita, String email, String indirizzo,
			String citta, int cap) {
	
		this.login = false;
		this.errorLogin = false;
		this.errorCart = false;
		this.username = username;
		this.psw = psw;
		this.matricola = matricola;
		this.nome = nome;
		this.cognome = cognome;
		this.facolta = facolta;
		this.universita = universita;
		this.email = email;
		this.indirizzo = indirizzo;
		this.citta = citta;
		this.cap = cap;
		this.libri=null;
		this.appunti=null;
		this.lezioni=null;
		
	}





	

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPsw() {
		return psw;
	}
	public void setPsw(String psw) {
		this.psw = psw;
	}
	public int getMatricola() {
		return matricola;
	}
	public void setMatricola(int matricola) {
		this.matricola = matricola;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getFacolta() {
		return facolta;
	}
	public void setFacolta(String facolta) {
		this.facolta = facolta;
	}
	public String getUniversita() {
		return universita;
	}
	public void setUniversita(String universita) {
		this.universita = universita;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getIndirizzo() {
		return indirizzo;
	}
	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}
	public String getCitta() {
		return citta;
	}
	public void setCitta(String citta) {
		this.citta = citta;
	}
	public int getCap() {
		return cap;
	}
	public void setCap(int cap) {
		this.cap = cap;
	}

	public boolean isLogin() {
		return login;
	}
	public void setLogin(boolean login) {
		this.login = login;
	}
	public boolean isErrorLogin() {
		return errorLogin;
	}
	public void setErrorLogin(boolean errorLogin) {
		this.errorLogin = errorLogin;
	}
	public boolean isErrorCart() {
		return errorCart;
	}
	public void setErrorCart(boolean errorCart) {
		this.errorCart = errorCart;
	}

	public void addAppunti(AppuntiBeans ap) {
		this.appunti.add(ap);
	}

	public void addLezioni(LezioneBeans lez) {
		this.lezioni.add(lez);
	}
	
	public void addLibri(LibroBeans lib) {
		this.libri.add(lib);
	}


	public ArrayList<LibroBeans> getLibri() {
		return libri;
	}

	public void setLibri(ArrayList<LibroBeans> libri) {
		this.libri = libri;
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





	private boolean login=false,errorLogin=false,errorCart=false;
	private String username;
	private String psw;
	private int matricola;
	private String nome;
	private String cognome;
	private String facolta;
	private String universita;
	private String email;
	private String indirizzo;
	private String citta;
	private int cap;
	private ArrayList<LibroBeans>libri;
	private ArrayList<AppuntiBeans>appunti;
	private ArrayList<LezioneBeans>lezioni;
}
