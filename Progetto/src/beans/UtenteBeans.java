package beans;

import java.util.ArrayList;

public class UtenteBeans {

	/**
	 * @param mail mail dell'utente
	 * @param psw password scelta dall'utente per l'autenticazione
	 * @param matricola matricola data dall'universita dove l'utente è inscritto
	 * @param nome nome dell'utente
	 * @param cognome cognome dell'utente
	 * @param universita universita scelta dall'utete
	 * @param citta luogo di residenza o nascita scelto dall'utente
	 * @param login valore booleano per controllo sul login dell'utente
	 * @param errorLogin valore booleano per controllo errori sul login dell'utente
	 * @param errorCart valore booleano sul controllo errori sui preferiti
	 * @param appunti arrayList di appunti messi sul sito dall'utente
	 * @param libri arrayList di libri messi sul sito dall'utente
	 * @param lezioni arrayList di lezioni messi sul sito dall'utente
	 */

	public UtenteBeans() {

	}

	public UtenteBeans(String psw, int matricola, String nome, String cognome, String facolta, String universita,
			String email, String citta) {
		this.login = false;
		this.errorLogin = false;
		this.errorCart = false;
		this.psw = psw;
		this.matricola = matricola;
		this.nome = nome;
		this.cognome = cognome;
		this.facolta = facolta;
		this.universita = universita;
		this.email = email;
		this.citta = citta;
		appunti = new ArrayList<AppuntiBeans>();
		libri = new ArrayList<LibroBeans>();
		lezioni = new ArrayList<LezioneBeans>();

	}

	/**
	 * @return String La password dell'utente
	 */
	public String getPsw() {
		return psw;
	}

	/**
	* Setta la password dell'utente
	* @param psw
	*/
	public void setPsw(String psw) {
		this.psw = psw;
	}

	/**
	 * @return int La matricola dell'utente
	 */
	public int getMatricola() {
		return matricola;
	}

	/**
	* Setta la matricola dell'utente
	* @param matricola
	*/
	public void setMatricola(int matricola) {
		this.matricola = matricola;
	}

	/**
	 * @return String Il nome dell'utente
	 */
	public String getNome() {
		return nome;
	}

	/**
	* Setta il nome dell'utente
	* @param nome
	*/
	public void setNome(String nome) {
		this.nome = nome;
	}
	/**
	 * @return String Il cognome dell'utente
	 */
	public String getCognome() {
		return cognome;
	}

	/**
	* Setta il cognome dell'utente
	* @param cognome
	*/
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	/**
	 * @return String La facolta dell'utente
	 */
	public String getFacolta() {
		return facolta;
	}

	/**
	* Setta la facolta dell'utente
	* @param facolta
	*/
	public void setFacolta(String facolta) {
		this.facolta = facolta;
	}
	/**
	 * @return String L'universita dell'utente
	 */
	public String getUniversita() {
		return universita;
	}

	/**
	* Setta l'universita dell'utente
	* @param universita
	*/
	public void setUniversita(String universita) {
		this.universita = universita;
	}
	/**
	 * @return String L'email  dell'utente
	 */
	public String getEmail() {
		return email;
	}

	/**
	* Setta l’email dell'utente
	* @param email
	*/
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return String La citta dell'utente
	 */
	public String getCitta() {
		return citta;
	}

	/**
	* Setta la citta dell'utente
	* @param citta
	*/
	public void setCitta(String citta) {
		this.citta = citta;
	}
	/**
	 * @return boolean Contollo sul login dell'utente
	 */
	public boolean isLogin() {
		return login;
	}

	/**
	* Setta il login dell'utente
	* @param login
	*/
	public void setLogin(boolean login) {
		this.login = login;
	}

	/**
	 * @return boolean Controllo sulla login errata dell'utente
	 */
	public boolean isErrorLogin() {
		return errorLogin;
	}
	
	/**
	* Setta il booleano in caso di errore nell'inserimento del login
	* @param idOrdine
	*/
	public void setErrorLogin(boolean errorLogin) {
		this.errorLogin = errorLogin;
	}
	/**
	 * @return boolean Controllo sugli errori dell'aggiunta ai preferiti
	 */
	public boolean isErrorCart() {
		return errorCart;
	}
	
	/**
	* Setta il booleano in caso di errore dell'aggiunta ai preferiti
	* @param idOrdine
	*/
	public void setErrorCart(boolean errorCart) {
		this.errorCart = errorCart;
	}

	/**
	* Setta gli appunti dell'utente
	* @param appunti
	*/
	public void addAppunti(AppuntiBeans ap) {
		this.appunti.add(ap);
	}
	/**
	* Setta le lezioni dell'utente
	* @param lezioni
	*/
	public void addLezioni(LezioneBeans lez) {
		this.lezioni.add(lez);
	}
	/**
	* Setta i libri dell'utente
	* @param libri
	*/
	public void addLibri(LibroBeans lib) {
		this.libri.add(lib);
	}

	/**
	 * @return ArrayList Tutti i libri messi sul sito dall'utente
	 */
	public ArrayList<LibroBeans> getLibri() {
		return libri;
	}

	public void setLibri(ArrayList<LibroBeans> libri) {
		this.libri = libri;
	}
	/**
	 * @return ArrayList Tutti gli appunti messi sul sito dall'utente
	 */
	public ArrayList<AppuntiBeans> getAppunti() {
		return appunti;
	}

	public void setAppunti(ArrayList<AppuntiBeans> appunti) {
		this.appunti = appunti;
	}

	/**
	 * @return ArrayList Tutte le lezioni messe sul sito dall'utente
	 */
	public ArrayList<LezioneBeans> getLezioni() {
		return lezioni;
	}

	/**
	* Setta le lezioni dell'utente
	* @param lezioni
	*/
	public void setLezioni(ArrayList<LezioneBeans> lezioni) {
		this.lezioni = lezioni;
	}

	private boolean login = false, errorLogin = false, errorCart = false;
	private String psw;
	private int matricola;
	private String nome;
	private String cognome;
	private String facolta;
	private String universita;
	private String email;
	private String citta;
	private ArrayList<LibroBeans> libri;
	private ArrayList<AppuntiBeans> appunti;
	private ArrayList<LezioneBeans> lezioni;
}
