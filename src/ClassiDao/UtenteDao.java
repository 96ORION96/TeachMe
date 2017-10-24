package ClassiDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Connessione.DriveManagerConnectionPool;
import Beans.UtenteBeans;

public class UtenteDao 
{

	public UtenteDao() 
	{
		// TODO Auto-generated constructor stub
	}
	
	private static final String insert_sql=
			"insert into utente values(?,?,?,?,?,?,?,?,?,?,?)";
	
	public static void Insert (UtenteBeans utente) throws Exception
	{
		Connection con = null;
		PreparedStatement pstmt = null;
		con = DriveManagerConnectionPool.getConnection();
		pstmt = con.prepareStatement(insert_sql);
		
		pstmt.setString(1, utente.getUsername());
		pstmt.setString(2, utente.getPsw());
		pstmt.setInt   (3, utente.getMatricola());
		pstmt.setString(4, utente.getNome());
		pstmt.setString(5, utente.getCognome());
		pstmt.setString(6, utente.getFacolta());
		pstmt.setString(7, utente.getUniversita());
		pstmt.setString(8, utente.getEmail());
		pstmt.setString(9, utente.getIndirizzo());
		pstmt.setString(10,utente.getCitta());
		pstmt.setInt   (11,utente.getCap());
		
		pstmt.executeUpdate();
		pstmt.close();
		con.close();
	}
	
	
	
	//importante per il login
	
			private static final String Select_Utente=
			"Select * FROM utente WHERE ((username=?) and (psw=?))";

	
	public static UtenteBeans SelectUtente(String username,String psw) throws Exception
	{
		Connection con = null;
		PreparedStatement pstmt = null;
		con = DriveManagerConnectionPool.getConnection();
		ResultSet rs= null;
		UtenteBeans risultato=null;
		pstmt = con.prepareStatement(Select_Utente);
		
		pstmt.setString(1,username);
		pstmt.setString(2,psw);
		
		rs=pstmt.executeQuery();
		
		while(rs.next())
	    risultato= new UtenteBeans(rs.getString("username"), rs.getString("psw"), rs.getInt("matricola"), rs.getString("nome"), rs.getString("cognome"), rs.getString("facolta"), rs.getString("universita"), rs.getString("email"), rs.getString("indirizzo"), rs.getString("citta"), rs.getInt("cap"));
		rs.close();
		pstmt.close();
		con.close();
		
		return risultato;
		
		
			
	}
	
	
	
	private static final String Update=
			"Update utente set psw=? where(username=?)";
	
	public static void Update(String passward,UtenteBeans utente) throws Exception
	{
		Connection con = null;
		PreparedStatement pstmt = null;
		con = DriveManagerConnectionPool.getConnection();
		pstmt = con.prepareStatement(Update);
		
		pstmt.setString(1, passward);
		pstmt.setString(2, utente.getUsername());
		
		
		
		pstmt.executeUpdate();
		pstmt.close();
		con.close();
	}
	
	
	
	
	
	
}

