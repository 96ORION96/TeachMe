package Beans;

public class AdminBeans {
		
	public AdminBeans(String username, String psw) {
		
		this.username = username;
		this.psw = psw;
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



	private String username,psw;
}
