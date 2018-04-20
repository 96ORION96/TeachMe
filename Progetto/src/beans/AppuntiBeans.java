package beans;

public class AppuntiBeans {
	
	
	/**
	* @param mail mail dell'utente che ha messo gli appunti in vendita
	* @param id condice distintivo degli appunti
	* @param titolo titolo scelto dall'utente per gli appunti
	* @param materia materia trattata dagli appunti
	* @param facolta facolta scelta dall'utente per gli appunti
	* @param universita universita scelta dall'utete per gli appunti
	* @param prezzo prezzo scelto dall'utente per gli appunti
	* @param facolta facolta scelta dall'utente per gli appunti
	*/
	
	public AppuntiBeans(String titolo, String materia, String facolta, String universita, String id,double prezzo,String email) {
		super();
		this.mail = email;
		this.materia = materia;
		this.facolta = facolta;
		this.universita = universita;
		this.id = id;
		this.prezzo=prezzo;
		this.titolo=titolo;
	}

	

	/**
	 * @return String Il titolo assegnato agli appunti
	 */
	public String getTitolo() {
		return titolo;
	}



	/**
	* Setta il titolo dato agli appunti
	* @param titolo
	*/
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}



	/**
	 * @return String La mail dell'utente possessore degli appunti
	 */
	public String getMail() {
		return mail;
	}



	/**
	* Setta l'email degli appunti
	* @param mail
	*/
	public void setMail(String email) {
		this.mail = email;
	}



	/**
	 * @return String La materia degli appunti
	 */
	public String getMateria() {
		return materia;
	}


	/**
	* Setta la materia degli appunti
	* @param materia
	*/
	public void setMateria(String materia) {
		this.materia = materia;
	}


	/**
	 * @return String La facolta dove l'utente intende vendere gli appunti
	 */
	public String getFacolta() {
		return facolta;
	}


	/**
	* Setta la facolta dove vendere gli appunti
	* @param facolta
	*/
	public void setFacolta(String facolta) {
		this.facolta = facolta;
	}

	
	/**
	 * @return String L'universita dove l'utente intende vendere gli appunti
	 */
	public String getUniversita() {
		return universita;
	}


	/**
	* Setta l’ universita dove vendere gli appunti
	* @param universita
	*/
	public void setUniversita(String universita) {
		this.universita = universita;
	}


	/**
	 * @return String Il codice identiificativo degli appunti
	 */
	public String getId() {
		return id;
	}


	/**
	* Setta l’ id degli appunti
	* @param id
	*/
	public void setId(String id) {
		this.id = id;
	}

	
	/**
	 * @return String Il prezzo scelto dall'utente per gli appunti
	 *  */
	public double getPrezzo() {
		return prezzo;
	}

	/**
	* Setta il prezzo degli appunti
	* @param prezzo
	*/
	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}



	private double prezzo;
	private String titolo,materia,facolta,universita,id,mail;
}
