package Beans;

public class LibroBeans {
	
	public LibroBeans() {
		this.username = null;
		this.isbn = null;
		this.titolo = null;
		this.materia = null;
		this.facolta = null;
		this.universita = null;
		this.prezzo=0;
	}
		
	public LibroBeans(String username, String isbn, String titolo, String materia, String facolta, String universita,double prezzo) {
		this.username = username;
		this.isbn = isbn;
		this.titolo = titolo;
		this.materia = materia;
		this.facolta = facolta;
		this.universita = universita;
		this.prezzo = prezzo;
	}
	
	

	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public String getIsbn() {
		return isbn;
	}



	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}



	public String getTitolo() {
		return titolo;
	}



	public void setTitolo(String titolo) {
		this.titolo = titolo;
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

	

	public double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}

	@Override
	public String toString() {
		return "isbn=" + isbn + ", titolo=" + titolo ;
	}


	private double prezzo;
	private String username,isbn,titolo,materia,facolta,universita;
}
