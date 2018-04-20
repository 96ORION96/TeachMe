package beans;

public class AdminBeans {
	
	/**
	* @param mail mail dell'admin 
	* @param psw password scelta dall'admin
	* @param login booleano che controlla il login dell'admin
	*/
		
	public AdminBeans() {
		
	}
	
	public AdminBeans(String email, String psw) {
		
		this.email = email;
		this.psw = psw;
		login = false;
	}
	
	

	/**
	 * @return String La password scelta dall'admin
	 */
	public String getPsw() {
		return psw;
	}


	public void setPsw(String psw) {
		this.psw = psw;
	}

	
	

	
	


	/**
	 * @return String La password dell'admin
	 */
	public Boolean isLogin() {
		return login;
	}




	public void setLogin(Boolean login) {
		this.login = login;
	}



	/**
	 * @return String L'email dell'admin
	 */
	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}





	private Boolean login=false;
	private String email,psw;
}
