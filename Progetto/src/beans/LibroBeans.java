package beans;

public class LibroBeans {
	
	
	/**
	* @param mail mail dell'utente che ha messo in vendita il libro
	* @param id isbn del libro 
	* @param titolo titolo del libro 
	* @param materia materia trattata dal libro
	* @param facolta facolta scelta dall'utente per il libro
	* @param universita universita scelta dall'utete per il libro
	* @param prezzo prezzo scelto dall'utente per il libro
	* @param facolta facolta scelta dall'utente per il libro
	*/
	
	public LibroBeans() {
		this.mail=null;
		this.id = null;
		this.titolo = null;
		this.materia = null;
		this.facolta = null;
		this.universita = null;
		this.prezzo=0;
	}
		
	public LibroBeans(String mail, String id, String titolo, String materia, String facolta, String universita,double prezzo) {
		this.mail = mail;
		this.id = id;
		this.titolo = titolo;
		this.materia = materia;
		this.facolta = facolta;
		this.universita = universita;
		this.prezzo = prezzo;
	}
	
	
	/**
	 * @return String L'isbn del libro
	 */
	public String getId() {
		return id;
	}


	/**
	* Setta l’ isbn del libro
	* @param id
	*/
	public void setId(String id) {
		this.id = id;
	}


	/**
	 * @return String Il titolo del libro
	 */
	public String getTitolo() {
		return titolo;
	}


	/**
	* Setta il titolo del libro
	* @param titolo
	*/
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}


	/**
	 * @return String La materia del libro
	 */
	public String getMateria() {
		return materia;
	}


	/**
	* Setta la materia del libro
	* @param materia
	*/
	public void setMateria(String materia) {
		this.materia = materia;
	}


	/**
	 * @return String La facolta dove vendere il libro
	 */
	public String getFacolta() {
		return facolta;
	}


	/**
	* Setta la facolta dove vendere il libro
	* @param facolta
	*/
	public void setFacolta(String facolta) {
		this.facolta = facolta;
	}


	/**
	 * @return String L'univerista dove vendere il libro
	 */
	public String getUniversita() {
		return universita;
	}


	/**
	* Setta l'universita dove vendere il libro
	* @param universita
	*/
	public void setUniversita(String universita) {
		this.universita = universita;
	}

	
	/**
	 * @return Double Il prezzo del libro
	 */
	public double getPrezzo() {
		return prezzo;
	}
	
	/**
	* Setta il prezzo del libro
	* @param prezzo
	*/
	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}

	@Override
	public String toString() {
		return "id=" + id + ", titolo=" + titolo ;
	}

	
	/**
	 * @return String L'email dell'utente possessore del libro
	 */
	public String getMail() {
		return mail;
	}

	/**
	* Setta l'email del possessore del libro
	* @param mail
	*/
	public void setMail(String mail) {
		this.mail = mail;
	}



	private double prezzo;
	private String mail,id,titolo,materia,facolta,universita;
}
