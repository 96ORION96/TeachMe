package beans;

import java.sql.Date;
import java.util.GregorianCalendar;

public class LezioneBeans {
	
	/**
	* @param mail mail dell'utente che offre la lezione
	* @param id codice distintivo della lezione 
	* @param titolo titolo scelto dall'utente per la lezione 
	* @param materia materia trattata dalla lezione
	* @param facolta facolta scelta dall'utente per la lezione
	* @param universita universita scelta dall'utete per chi deve usufluirne 
	* @param prezzo prezzo scelto dall'utente per la lezione
	* @param facolta facolta scelta dall'utente per la lezione 
	*/
	
	public LezioneBeans(String titolo,String id, String materia, String facolta, String univerista, String email,double prezzo) {
		this.titolo=titolo;
		this.id = id;
		this.materia = materia;
		this.facolta = facolta;
		this.univerista = univerista;
		this.prezzo= prezzo;
		this.mail=email;
	}
	
	/**
	 * @return String L'id della lezione 
	 */
	public String getId() {
		return id;
	}
	
	/**
	* Setta L'id della lezione 
	* @param id
	*/
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return String La materia della lezione
	 */
	public String getMateria() {
		return materia;
	}
	
	/**
	* Setta la materia trattata dalla lezione
	* @param materia
	*/
	public void setMateria(String materia) {
		this.materia = materia;
	}
	/**
	 * @return String La facolta della lezione
	 */
	public String getFacolta() {
		return facolta;
	}
	/**
	* Setta la facolta riguardante la lezione
	* @param facolta
	*/
	public void setFacolta(String facolta) {
		this.facolta = facolta;
	}
	/**
	 * @return String L'universita dove disputare la lezione
	 */
	public String getUniverista() {
		return univerista;
	}
	
	/**
	* Setta l'universita della lezione
	* @param idOrdine
	*/
	public void setUniverista(String univerista) {
		this.univerista = univerista;
	}

	/**
	 * @return double Il prezzo della lezione
	 */
	public double getPrezzo() {
		return prezzo;
	}

	/**
	* Setta l’ ID dell’ ordine
	* @param idOrdine
	*/
	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}

	
	/**
	 * @return String L'email dell'utente che intende disputare la lezione 
	 */
	public String getMail() {
		return mail;
	}


	/**
	* Setta l’email dell'utente che intende disputare la lezione
	* @param idOrdine
	*/
	public void setMail(String email) {
		this.mail = email;
	}

	

	/**
	 * @return String Il titolo assegnato alla lezione
	 */
	public String getTitolo() {
		return titolo;
	}


	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}




	private double prezzo;
	private String id,materia,facolta,univerista,mail,titolo;

}
