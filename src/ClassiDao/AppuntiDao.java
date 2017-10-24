package ClassiDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import Beans.AppuntiBeans;
import Connessione.DriveManagerConnectionPool;

public class AppuntiDao 
{

	public AppuntiDao() 
	{
		// TODO Auto-generated constructor stub
	}
	
	private static final String insert_sql=
			"insert into apputi values(?,?,?,?,?,?)";
	
	public static void Insert (AppuntiBeans appunti) throws Exception
	{
		Connection con = null;
		PreparedStatement pstmt = null;
		con = DriveManagerConnectionPool.getConnection();
		pstmt = con.prepareStatement(insert_sql);
		
		pstmt.setString(1, appunti.getUsername());
		pstmt.setString(2, appunti.getMateria());
		pstmt.setString(3, appunti.getFacolta());
		pstmt.setString(4, appunti.getUniversita());
		pstmt.setString(5, appunti.getId());
		pstmt.setDouble(6, appunti.getPrezzo());
		pstmt.executeUpdate();
		pstmt.close();
		con.close();
	}
	
	
	
 
	private static final String Select_appunti_materie=
			"Select * FROM appunti WHERE (materia=?) ";
	
	public static ArrayList <AppuntiBeans> Select_appunti_materia(String materia) throws Exception
	{
		Connection con = null;
		PreparedStatement pstmt = null;
		con = DriveManagerConnectionPool.getConnection();
		ResultSet rs= null;
		ArrayList <AppuntiBeans> list=new ArrayList<AppuntiBeans>();
		pstmt = con.prepareStatement(Select_appunti_materie);
		
		pstmt.setString(1,materia);
		
		rs=pstmt.executeQuery();
		
		while(rs.next())
		list.add( dammi_appunti(rs));
		
		
		rs.close();
		pstmt.close();
		con.close();
		return(list);
			
	}
	
	private static final String Select_appunti_fac=
			"Select * FROM appunti WHERE (facolta=?) ";
	
	public static ArrayList <AppuntiBeans> Select_appunti_facolta(String facolta) throws Exception
	{
		Connection con = null;
		PreparedStatement pstmt = null;
		con = DriveManagerConnectionPool.getConnection();
		ResultSet rs= null;
		ArrayList <AppuntiBeans> list=new ArrayList<AppuntiBeans>();
		pstmt = con.prepareStatement(Select_appunti_fac);
		
		pstmt.setString(1,facolta);
		
		rs=pstmt.executeQuery();
		while(rs.next())
			list.add( dammi_appunti(rs));
		
		
		rs.close();
		pstmt.close();
		con.close();
		return(list);
			
	}
	
	private static final String Select_appunti_uni=
			"Select * FROM appunti WHERE (facolta=?) ";
	
	public static ArrayList <AppuntiBeans> Select_appunti_universita(String universita) throws Exception
	{
		Connection con = null;
		PreparedStatement pstmt = null;
		con = DriveManagerConnectionPool.getConnection();
		ResultSet rs= null;
		ArrayList <AppuntiBeans> list=new ArrayList<AppuntiBeans>();
		pstmt = con.prepareStatement(Select_appunti_uni);
		
		pstmt.setString(1,universita);
		
		rs=pstmt.executeQuery();
		
		while(rs.next())
		list.add( dammi_appunti(rs));
		
		
		rs.close();
		pstmt.close();
		con.close();
		return(list);
			
	}
	
	private static final String Select_appunti=
			"Select * FROM appunti WHERE (id=?) ";
	
	public static AppuntiBeans Select_appunti_id(String id) throws Exception
	{
		Connection con = null;
		PreparedStatement pstmt = null;
		con = DriveManagerConnectionPool.getConnection();
		ResultSet rs= null;
		AppuntiBeans ris;
		pstmt = con.prepareStatement(Select_appunti);
		
		pstmt.setString(1,id);
		
		rs=pstmt.executeQuery();
		
		ris = new AppuntiBeans(rs.getString("username"),rs.getString("materia"), rs.getString("facolta"), rs.getString("universita"), rs.getString("id"), rs.getDouble("prezzo"));
				
		
		
		rs.close();
		pstmt.close();
		con.close();
		return(ris);
			
	}
	
	
	private static final String Update=
			"Update appunti set universita=? where(id=?)";
	
	public static void Update_prezzo(String uni,AppuntiBeans x) throws Exception
	{
		Connection con = null;
		PreparedStatement pstmt = null;
		con = DriveManagerConnectionPool.getConnection();
		pstmt = con.prepareStatement(Update);
		
		pstmt.setString(1, uni);
		pstmt.setString(2, x.getId());
		
		pstmt.executeUpdate();
		pstmt.close();
		con.close();
	}
	
	
	private static final String Select_appunti_mat_fac_uni=
			"Select * FROM appunti WHERE (materia=?) and (facolta=?) and (universita=?) ";
	
	public static ArrayList <AppuntiBeans> Select_appunti_mat_fac_uni(String materia,String facolta,String universita) throws Exception
	{
		Connection con = null;
		PreparedStatement pstmt = null;
		con = DriveManagerConnectionPool.getConnection();
		ResultSet rs= null;
		ArrayList <AppuntiBeans> list=new ArrayList<AppuntiBeans>();
		pstmt = con.prepareStatement(Select_appunti_mat_fac_uni);
		
		pstmt.setString(1,materia);
		pstmt.setString(2,facolta);
		pstmt.setString(3,universita);
		rs=pstmt.executeQuery();
		
		while(rs.next())
		list.add( dammi_appunti(rs));
		
		
		rs.close();
		pstmt.close();
		con.close();
		return(list);
			
	}
	
	
	private static AppuntiBeans dammi_appunti(ResultSet rs) throws SQLException
	{
		AppuntiBeans risultato=new AppuntiBeans(rs.getString("username"),rs.getString("materia"),rs.getString("facolta"),rs.getString("universita"),rs.getString ("id"),rs.getDouble("prezzo"));
		return(risultato);
	}

	
}

