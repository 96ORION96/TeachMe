package classiDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.tomcat.dbcp.dbcp2.DriverManagerConnectionFactory;

import Connessione.DriveManagerConnectionPool;
import beans.LezioneBeans;

public class LezioneDao 
{

	public LezioneDao() 
	{
		// TODO Auto-generated constructor stub
	}
	
	private static final String insert_sql=
			"insert into lezione values(?,?,?,?,?,?,?)";
	
	public static void Insert (LezioneBeans lezione) throws Exception
	{
		Connection con = null;
		PreparedStatement pstmt = null;
		con = DriveManagerConnectionPool.getConnection();
		pstmt = con.prepareStatement(insert_sql);
		
		pstmt.setString(1, lezione.getId());
		pstmt.setString(2, lezione.getMateria());
		pstmt.setString(3, lezione.getFacolta());
		pstmt.setString(4, lezione.getUniverista());
		pstmt.setDouble(5, lezione.getPrezzo());
		pstmt.setString(6, lezione.getTitolo());
		pstmt.setString(7, lezione.getMail());

		pstmt.executeUpdate();
		pstmt.close();
		con.close();
	}
	
	private static final String Select_lezione=
			"Select * FROM lezione WHERE (id=?) ";
	
	public static ArrayList<LezioneBeans> Select_lezione_id(String id) throws Exception
	{
		Connection con = null;
		PreparedStatement pstmt = null;
		con = DriveManagerConnectionPool.getConnection();
		ResultSet rs= null;
		ArrayList<LezioneBeans> ris = new ArrayList<LezioneBeans>();
		pstmt = con.prepareStatement(Select_lezione);
		
		pstmt.setString(1,id);
		
		rs=pstmt.executeQuery();
		
		while(rs.next())
			ris.add( dammi_lezioni(rs));
			
		if(ris.isEmpty())	return null;
			
			rs.close();
			pstmt.close();
			con.close();
			return(ris);
			
	}
	
	private static final String Select_All_lezioni=
			"Select * FROM lezione ";
	
	public static ArrayList<LezioneBeans> Select_All_lezioni() throws Exception
	{
		Connection con = null;
		PreparedStatement pstmt = null;
		con = DriveManagerConnectionPool.getConnection();
		ResultSet rs= null;
		ArrayList<LezioneBeans> ris = new ArrayList<LezioneBeans>();
		pstmt = con.prepareStatement(Select_All_lezioni);
			
		rs=pstmt.executeQuery();
		
		while(rs.next())
			ris.add( dammi_lezioni(rs));
			
			
			rs.close();
			pstmt.close();
			con.close();
			return(ris);
			
	}
	
	private static final String Select_lezione_email=
			"Select * FROM lezione WHERE (email=?) ";
	
	public static ArrayList<LezioneBeans> Select_lezione_email(String email) throws Exception
	{
		Connection con = null;
		PreparedStatement pstmt = null;
		con = DriveManagerConnectionPool.getConnection();
		ResultSet rs= null;
		ArrayList<LezioneBeans> ris = new ArrayList<LezioneBeans>();
		pstmt = con.prepareStatement(Select_lezione_email);
		
		pstmt.setString(1,email);
		
		rs=pstmt.executeQuery();
		
		while(rs.next())
			ris.add( dammi_lezioni(rs));
			
			
			rs.close();
			pstmt.close();
			con.close();
			return(ris);
			
	}
	
	private static final String Select_lezione_universita=
			"Select * FROM lezione WHERE (universita=?) ";
	
	public static ArrayList <LezioneBeans> Select_lezione_universita(String universita) throws Exception
	{
		Connection con = null;
		PreparedStatement pstmt = null;
		con = DriveManagerConnectionPool.getConnection();
		ResultSet rs= null;
		ArrayList <LezioneBeans> list=new ArrayList<LezioneBeans>();
		pstmt = con.prepareStatement(Select_lezione_universita);
		
		pstmt.setString(1,universita);
		
		rs=pstmt.executeQuery();
		
		while(rs.next())
		list.add( dammi_lezioni(rs));
		
		if(list.isEmpty())	return null;
		
		rs.close();
		pstmt.close();
		con.close();
		return(list);
			
	}
	
	private static final String Select_lezione_fac=
			"Select * FROM lezione WHERE (facolta=?) ";
	
	public static ArrayList <LezioneBeans> Select_lezione_facolta(String facolta) throws Exception
	{
		Connection con = null;
		PreparedStatement pstmt = null;
		con = DriveManagerConnectionPool.getConnection();
		ResultSet rs= null;
		ArrayList <LezioneBeans> list=new ArrayList<LezioneBeans>();
		pstmt = con.prepareStatement(Select_lezione_fac);
		
		pstmt.setString(1,facolta);
		
		rs=pstmt.executeQuery();
		
		while(rs.next())
		list.add( dammi_lezioni(rs));
		
		
		rs.close();
		pstmt.close();
		con.close();
		return(list);
			
	}
	
	private static final String Select_lezione_mat=
			"Select * FROM lezione WHERE (materia=?) ";
	
	public static ArrayList <LezioneBeans> Select_lezione_materia(String materia) throws Exception
	{
		Connection con = null;
		PreparedStatement pstmt = null;
		con = DriveManagerConnectionPool.getConnection();
		ResultSet rs= null;
		ArrayList <LezioneBeans> list=new ArrayList<LezioneBeans>();
		pstmt = con.prepareStatement(Select_lezione_mat);
		
		pstmt.setString(1,materia);
		
		rs=pstmt.executeQuery();
		
		while(rs.next())
		list.add( dammi_lezioni(rs));
		
		
		rs.close();
		pstmt.close();
		con.close();
		return(list);
			
	}
	
	
	private static final String Delete_lezione=
			"Delete from lezione WHERE id=?";
	public static void Delete_lezione(String id) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		con = DriveManagerConnectionPool.getConnection();
	
		pstmt = con.prepareStatement(Delete_lezione);
		pstmt.setString(1, id);
		pstmt.executeUpdate();
		pstmt.close();
		con.close();
		
		
	}
	
	
	private static final String Delete_lezione_mail=
			"Delete from lezione WHERE email=?";
	public static void Delete_lezione_mail(String email) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		con = DriveManagerConnectionPool.getConnection();
	
		pstmt = con.prepareStatement(Delete_lezione_mail);
		pstmt.setString(1, email);
		pstmt.executeUpdate();
		pstmt.close();
		con.close();
		
		
	}
	
	private static final String Select_lezione_mat_fac_uni=
			"Select * FROM lezione WHERE (materia=?) and (facolta=?) and (universita=?) ";
	
	public static ArrayList <LezioneBeans> Select_lezione_mat_fac_uni(String materia,String facolta,String universita) throws Exception
	{
		Connection con = null;
		PreparedStatement pstmt = null;
		con = DriveManagerConnectionPool.getConnection();
		ResultSet rs= null;
		ArrayList <LezioneBeans> list=new ArrayList<LezioneBeans>();
		pstmt = con.prepareStatement(Select_lezione_mat_fac_uni);
		
		pstmt.setString(1,materia);
		pstmt.setString(2,facolta);
		pstmt.setString(3,universita);
		
		rs=pstmt.executeQuery();
		
		while(rs.next())
		list.add( dammi_lezioni(rs));
		
		
		rs.close();
		pstmt.close();
		con.close();
		return(list);
			
	}
	private static LezioneBeans dammi_lezioni(ResultSet rs) throws SQLException
	{
		LezioneBeans risultato=new LezioneBeans(rs.getString("titolo"),rs.getString("id"),rs.getString("materia"),rs.getString("facolta"),rs.getString("universita"),rs.getString("email"),rs.getDouble("prezzo"));
		
		return(risultato);
	}

	
}

