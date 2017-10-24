package ClassiDao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import Beans.AdminBeans;
import Connessione.DriveManagerConnectionPool;

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
		
		pstmt.setString(1, admin.getUsername());
		pstmt.setString(2, admin.getPsw());
		
		
		pstmt.executeUpdate();
		pstmt.close();
		con.close();
	}
	
	
	
	private static final String Update=
			"Update admin set psw=? where(username=?)";
	
	public static void Update(String passward,AdminBeans admin) throws Exception
	{
		Connection con = null;
		PreparedStatement pstmt = null;
		con = DriveManagerConnectionPool.getConnection();
		pstmt = con.prepareStatement(Update);
		
		pstmt.setString(1, passward);
		pstmt.setString(2, admin.getUsername());
		
		
		
		pstmt.executeUpdate();
		pstmt.close();
		con.close();
	}
}