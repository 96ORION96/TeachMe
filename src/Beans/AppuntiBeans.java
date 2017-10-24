package Beans;

public class AppuntiBeans {
	
	public AppuntiBeans(String username, String materia, String facolta, String universita, String id,double prezzo) {
		super();
		this.username = username;
		this.materia = materia;
		this.facolta = facolta;
		this.universita = universita;
		this.id = id;
		this.prezzo=prezzo;
	}

	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
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



	public String getUniversita() {
		return universita;
	}



	public void setUniversita(String universita) {
		this.universita = universita;
	}



	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}

	

	public double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}



	private double prezzo;
	private String username,materia,facolta,universita,id;
}
