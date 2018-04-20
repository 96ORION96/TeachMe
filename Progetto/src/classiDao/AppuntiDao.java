package classiDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Connessione.DriveManagerConnectionPool;
import beans.AppuntiBeans;

public class AppuntiDao 
{

	public AppuntiDao() 
	{
		// TODO Auto-generated constructor stub
	}
	
	private static final String insert_sql=
			"insert into appunti values(?,?,?,?,?,?,?)";
	
	public static void Insert (AppuntiBeans appunti) throws Exception
	{
		Connection con = null;
		PreparedStatement pstmt = null;
		con = DriveManagerConnectionPool.getConnection();
		pstmt = con.prepareStatement(insert_sql);
		
		
		pstmt.setString(1, appunti.getMateria());
		pstmt.setString(2, appunti.getFacolta());
		pstmt.setString(3, appunti.getUniversita());
		pstmt.setString(4, appunti.getId());
		pstmt.setDouble(5, appunti.getPrezzo());
		pstmt.setString(6, appunti.getTitolo());
		pstmt.setString(7, appunti.getMail());;
		
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
	
	private static final String Select_All_appunti=
			"Select * FROM appunti";
	
	public static ArrayList <AppuntiBeans> Select_All_appunti() throws Exception
	{
		Connection con = null;
		PreparedStatement pstmt = null;
		con = DriveManagerConnectionPool.getConnection();
		ResultSet rs= null;
		ArrayList <AppuntiBeans> list=new ArrayList<AppuntiBeans>();
		pstmt = con.prepareStatement(Select_All_appunti);
		
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
			"Select * FROM appunti WHERE (universita=?) ";
	
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
	
	public static ArrayList<AppuntiBeans> Select_appunti_id(String id) throws Exception
	{
		Connection con = null;
		PreparedStatement pstmt = null;
		con = DriveManagerConnectionPool.getConnection();
		ResultSet rs= null;
		ArrayList<AppuntiBeans> ris = new ArrayList<AppuntiBeans>();
		pstmt = con.prepareStatement(Select_appunti);
		
		pstmt.setString(1,id);
		
		rs=pstmt.executeQuery();
		
		while(rs.next())
			ris.add( dammi_appunti(rs));
			
		if(ris.isEmpty()) return null;
			
			rs.close();
			pstmt.close();
			con.close();
			return(ris);
		
		
			
	}
	
	
	private static final String Select_appunti_email=
			"Select * FROM appunti WHERE (email=?) ";
	
	public static ArrayList<AppuntiBeans> Select_appunti_email(String email) throws Exception
	{
		Connection con = null;
		PreparedStatement pstmt = null;
		con = DriveManagerConnectionPool.getConnection();
		ResultSet rs= null;
		ArrayList<AppuntiBeans> ris = new ArrayList<AppuntiBeans>();
		pstmt = con.prepareStatement(Select_appunti_email);
		
		pstmt.setString(1,email);
		
		rs=pstmt.executeQuery();
		
		while(rs.next())
			ris.add( dammi_appunti(rs));
			
			
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
	
	private static final String Delete_appunti=
			"Delete from appunti WHERE id=?";
	
	public static void Delete_appunti(String id) throws Exception
	{
		Connection con = null;
		PreparedStatement pstmt = null;
		con = DriveManagerConnectionPool.getConnection();
		pstmt = con.prepareStatement(Delete_appunti);
		
		pstmt.setString(1, id);
		
		
		pstmt.executeUpdate();
		pstmt.close();
		con.close();
	}
	
	private static final String Delete_appunti_mail=
			"Delete from appunti WHERE id=?";
	
	public static void Delete_appunti_email(String email) throws Exception
	{
		Connection con = null;
		PreparedStatement pstmt = null;
		con = DriveManagerConnectionPool.getConnection();
		pstmt = con.prepareStatement(Delete_appunti_mail);
		
		pstmt.setString(1, email);
		
		
		pstmt.executeUpdate();
		pstmt.close();
		con.close();
	}
	
	private static AppuntiBeans dammi_appunti(ResultSet rs) throws SQLException
	{
		AppuntiBeans risultato=new AppuntiBeans(rs.getString("titolo"),rs.getString("materia"), rs.getString("facolta"), rs.getString("universita"), rs.getString("id"), rs.getDouble("prezzo"),rs.getString("email"));
		
		return(risultato);
	}

	
}

