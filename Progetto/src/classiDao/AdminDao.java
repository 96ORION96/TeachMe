package classiDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Connessione.DriveManagerConnectionPool;
import beans.AdminBeans;
import beans.UtenteBeans;

public class AdminDao 
{

	public AdminDao() 
	{
		// TODO Auto-generated constructor stub
	}
	
	private static final String insert_sql=
			"insert into admin values(?,?)";
	
	public static void Insert (AdminBeans admin) throws Exception
	{
		Connection con = null;
		PreparedStatement pstmt = null;
		con = DriveManagerConnectionPool.getConnection();
		pstmt = con.prepareStatement(insert_sql);
		
		pstmt.setString(1, admin.getEmail());
		pstmt.setString(2, admin.getPsw());
		
		
		pstmt.executeUpdate();
		pstmt.close();
		con.close();
	}
	
	
	private static final String Select_Admin=
			"Select * FROM admin WHERE ((email=?) and (psw=?))";

	
	public static AdminBeans SelectAdmin(String email,String psw) throws Exception
	{
		Connection con = null;
		PreparedStatement pstmt = null;
		con = DriveManagerConnectionPool.getConnection();
		ResultSet rs= null;
		AdminBeans risultato=null;
		pstmt = con.prepareStatement(Select_Admin);
		
		pstmt.setString(1,email);
		pstmt.setString(2,psw);
		
		rs=pstmt.executeQuery();
		
		while(rs.next())
	    risultato= new AdminBeans(email, psw);
		rs.close();
		pstmt.close();
		con.close();
		
		return risultato;
			
	}
	
	private static final String Update=
			"Update admin set psw=? where(email=?)";
	
	public static void Update(String passward,AdminBeans admin) throws Exception
	{
		Connection con = null;
		PreparedStatement pstmt = null;
		con = DriveManagerConnectionPool.getConnection();
		pstmt = con.prepareStatement(Update);
		
		pstmt.setString(1, passward);
		pstmt.setString(2, admin.getEmail());
		
		
		
		pstmt.executeUpdate();
		pstmt.close();
		con.close();
	}
	
	private static final String Delete_Utente=
			"Delete  FROM utente WHERE email=?";
	public static void Delete_Utente(String email) throws Exception
	{
		Connection con = null;
		PreparedStatement pstmt = null;
		con = DriveManagerConnectionPool.getConnection();
		pstmt = con.prepareStatement(Delete_Utente);
		
		
		pstmt.setString(1, email);
		
		
		
		pstmt.executeUpdate();
		pstmt.close();
		con.close();
	}
	
	private static final String Delete_Admin=
			"Delete  FROM admin WHERE email=?";
	
	public static void Delete_Admin(String email) throws Exception{
		Connection con = null;
		PreparedStatement pstmt = null;
		con = DriveManagerConnectionPool.getConnection();
		pstmt = con.prepareStatement(Delete_Admin);
		
		
		pstmt.setString(1, email);
		
		
		
		pstmt.executeUpdate();
		pstmt.close();
		con.close();
	}
	
}
