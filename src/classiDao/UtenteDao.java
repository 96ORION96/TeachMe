package classiDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Connessione.DriveManagerConnectionPool;
import beans.LibroBeans;
import beans.UtenteBeans;

public class UtenteDao 
{

	public UtenteDao() 
	{
		// TODO Auto-generated constructor stub
	}
	
	private static final String insert_sql=
			"insert into utente values(?,?,?,?,?,?,?,?)";
	
	public static void Insert (UtenteBeans utente) throws Exception
	{
		Connection con = null;
		PreparedStatement pstmt = null;
		con = DriveManagerConnectionPool.getConnection();
		pstmt = con.prepareStatement(insert_sql);
		
		pstmt.setString(1, utente.getPsw());
		pstmt.setInt   (2, utente.getMatricola());
		pstmt.setString(3, utente.getNome());
		pstmt.setString(4, utente.getUniversita());
		pstmt.setString(5, utente.getCognome());
		pstmt.setString(6, utente.getFacolta());
		pstmt.setString(7, utente.getEmail());
		pstmt.setString(8,utente.getCitta());
		
		pstmt.executeUpdate();
		pstmt.close();
		con.close();
	}
	
	
	
	//importante per il login
	
			private static final String Select_Utente=
			"Select * FROM utente WHERE ((email=?) and (psw=?))";

	
	public static UtenteBeans SelectUtente(String email,String psw) throws Exception
	{
		Connection con = null;
		PreparedStatement pstmt = null;
		con = DriveManagerConnectionPool.getConnection();
		ResultSet rs= null;
		UtenteBeans risultato=null;
		pstmt = con.prepareStatement(Select_Utente);
		
		pstmt.setString(1,email);
		pstmt.setString(2,psw);
		
		rs=pstmt.executeQuery();
		
		while(rs.next())
	    risultato= new UtenteBeans(rs.getString("psw"), rs.getInt("matricola"), rs.getString("nome"), rs.getString("cognome"), rs.getString("facolta"), rs.getString("universita"), rs.getString("email"),  rs.getString("citta"));
		rs.close();
		pstmt.close();
		con.close();
		
		return risultato;
		
		
			
	}
	
	
	
	private static final String Select_Utente_mail=
			"Select * FROM utente WHERE email=?";

	
	public static ArrayList<UtenteBeans> SelectUtente_mail(String email) throws Exception
	{
		Connection con = null;
		PreparedStatement pstmt = null;
		con = DriveManagerConnectionPool.getConnection();
		ResultSet rs= null;
		ArrayList<UtenteBeans> list=new ArrayList<>();
		pstmt = con.prepareStatement(Select_Utente_mail);
		
		pstmt.setString(1,email);
		
		
		rs=pstmt.executeQuery();
		
		while(rs.next())
				list.add( dammi_utente(rs));		
		
		rs.close();
		pstmt.close();
		con.close();
		
		return list;
		
		
			
	}
	
	
	private static final String Update=
			"Update utente set psw=? where(email=?)";
	
	public static void Update(String passward,UtenteBeans utente) throws Exception
	{
		Connection con = null;
		PreparedStatement pstmt = null;
		con = DriveManagerConnectionPool.getConnection();
		pstmt = con.prepareStatement(Update);
		
		pstmt.setString(1, passward);
		pstmt.setString(2, utente.getEmail());
		
		
		
		pstmt.executeUpdate();
		pstmt.close();
		con.close();
	}
	
	
	private static UtenteBeans dammi_utente(ResultSet rs) throws SQLException
	{
		UtenteBeans risultato=new UtenteBeans(rs.getString("psw"), rs.getInt("matricola"),rs.getString("nome"), rs.getString("cognome"),rs.getString("facolta"),rs.getString("universita"),rs.getString("email"),rs.getString("citta"));
		return(risultato);
	}
	
	
	
}

