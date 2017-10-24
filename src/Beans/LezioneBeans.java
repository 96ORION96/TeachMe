package Beans;

import java.sql.Date;
import java.util.GregorianCalendar;

public class LezioneBeans {
	
	
	
	public LezioneBeans(String id, String materia, String facolta, String univerista, String username,
			Date ora_inizio, Date ora_fine, Date giorno,double Prezzo) {
		
		this.id = id;
		this.materia = materia;
		this.facolta = facolta;
		this.univerista = univerista;
		this.username = username;
		this.ora_inizio = ora_inizio;
		this.ora_fine = ora_fine;
		this.giorno = giorno;
		this.prezzo= prezzo;
	}
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getMateria() {
		return materia;
	}
	public void setMateria(String materia) {
		this.materia = materia;
	}
	public String getFacolta() {
		return facolta;
	}
	public void setFacolta(String facolta) {
		this.facolta = facolta;
	}
	public String getUniverista() {
		return univerista;
	}
	public void setUniverista(String univerista) {
		this.univerista = univerista;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Date getOra_inizio() {
		return ora_inizio;
	}
	public void setOra_inizio(Date ora_inizio) {
		this.ora_inizio = ora_inizio;
	}
	public Date getOra_fine() {
		return ora_fine;
	}
	public void setOra_fine(Date ora_fine) {
		this.ora_fine = ora_fine;
	}
	public Date getGiorno() {
		return giorno;
	}
	public void setGiorno(Date giorno) {
		this.giorno = giorno;
	}

	
	
	public double getPrezzo() {
		return prezzo;
	}


	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}



	private double prezzo;
	private String id,materia,facolta,univerista,username;
	private Date ora_inizio,ora_fine,giorno;
}
