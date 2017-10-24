package ClassiDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import Beans.LibroBeans;
import Connessione.DriveManagerConnectionPool;

public class LibroDao 
{

	public LibroDao() 
	{
		// TODO Auto-generated constructor stub
	}
	
	private static final String insert_sql=
			"insert into libro values(?,?,?,?,?,?)";
	
	public static void Insert (LibroBeans libro) throws Exception
	{
		Connection con = null;
		PreparedStatement pstmt = null;
		con = DriveManagerConnectionPool.getConnection();
		pstmt = con.prepareStatement(insert_sql);
		
		pstmt.setString(1, libro.getUsername());
		pstmt.setString(2, libro.getIsbn());
		pstmt.setString(3, libro.getTitolo());
		pstmt.setString(4, libro.getMateria());
		pstmt.setString(5, libro.getFacolta());
		pstmt.setString(6, libro.getUniversita());

		
		pstmt.executeUpdate();
		pstmt.close();
		con.close();
	}
	
	
	
 
	private static final String Select_libro_materie=
			"Select * FROM appunti WHERE (materia=?)  ";
	
	public static ArrayList <LibroBeans> Select_libro_materia(String materia) throws Exception
	{
		Connection con = null;
		PreparedStatement pstmt = null;
		con = DriveManagerConnectionPool.getConnection();
		ResultSet rs= null;
		ArrayList <LibroBeans> list=new ArrayList<LibroBeans>();
		pstmt = con.prepareStatement(Select_libro_materie);
		
		pstmt.setString(1,materia);
		
		rs=pstmt.executeQuery();
		
		while(rs.next())
		list.add( dammi_libro(rs));
		
		
		rs.close();
		pstmt.close();
		con.close();
		return(list);
			
	}
	
	private static final String Select_libri_fac=
			"Select * FROM appunti WHERE (facolta=?) ";
	
	public static ArrayList <LibroBeans> Select_libro_facolta(String facolta) throws Exception
	{
		Connection con = null;
		PreparedStatement pstmt = null;
		con = DriveManagerConnectionPool.getConnection();
		ResultSet rs= null;
		ArrayList <LibroBeans> list=new ArrayList<LibroBeans>();
		pstmt = con.prepareStatement(Select_libri_fac);
		
		pstmt.setString(1,facolta);
		
		rs=pstmt.executeQuery();
		
		while(rs.next())
		list.add( dammi_libro(rs));
		
		
		rs.close();
		pstmt.close();
		con.close();
		return(list);
			
	}
	
	private static final String Select_libro_titoli=
			"Select * FROM appunti WHERE (titolo=?) ";
	
	public static ArrayList <LibroBeans> Select_libro_titolo(String titolo) throws Exception
	{
		Connection con = null;
		PreparedStatement pstmt = null;
		con = DriveManagerConnectionPool.getConnection();
		ResultSet rs= null;
		ArrayList <LibroBeans> list=new ArrayList<LibroBeans>();
		pstmt = con.prepareStatement(Select_libro_titoli);
		
		pstmt.setString(1,titolo);
		
		rs=pstmt.executeQuery();
		
		while(rs.next())
		list.add( dammi_libro(rs));
		
		
		rs.close();
		pstmt.close();
		con.close();
		return(list);
			
	}
	
	private static final String Select_libri_uni=
			"Select * FROM libro WHERE (universita=?) ";
	
	public static ArrayList <LibroBeans> Select_libro_universita(String universita) throws Exception
	{
		Connection con = null;
		PreparedStatement pstmt = null;
		con = DriveManagerConnectionPool.getConnection();
		ResultSet rs= null;
		ArrayList <LibroBeans> list=new ArrayList<LibroBeans>();
		pstmt = con.prepareStatement(Select_libri_uni);
		
		pstmt.setString(1,universita);
		
		rs=pstmt.executeQuery();
		
		while(rs.next())
		list.add( dammi_libro(rs));
		
		
		rs.close();
		pstmt.close();
		con.close();
		return(list);
			
	}
	
	private static final String Select_libri=
			"Select * FROM libro WHERE (isbn=?) ";
	
	public static LibroBeans Select_libri_isbn(String id) throws Exception
	{
		Connection con = null;
		PreparedStatement pstmt = null;
		con = DriveManagerConnectionPool.getConnection();
		ResultSet rs= null;
		pstmt = con.prepareStatement(Select_libri);
		LibroBeans ris;
		
		pstmt.setString(1,id);
		
		rs=pstmt.executeQuery();
		
		ris= new LibroBeans(rs.getString("username"),rs.getString("isbn"), rs.getString("titolo"), rs.getString("materia"),rs.getString("facolta"), rs.getString("universita"),rs.getDouble("prezzo"));
		
		
		rs.close();
		pstmt.close();
		con.close();
		return(ris);
	}
	
	private static final String Update=
			"Update libro set universita=? where(isbn=?)";
	
	public static void Update_prezzo(String uni,LibroBeans x) throws Exception
	{
		Connection con = null;
		PreparedStatement pstmt = null;
		con = DriveManagerConnectionPool.getConnection();
		pstmt = con.prepareStatement(Update);
		
		pstmt.setString(1, uni);
		pstmt.setString(2, x.getIsbn());
		
		pstmt.executeUpdate();
		pstmt.close();
		con.close();
	}
			
	private static final String Select_libro_mat_fac_uni=
			"Select * FROM libro WHERE (materia=?) and (facolta=?) and (universita=?)";
	
	public static ArrayList <LibroBeans> Select_libro_mat_fac_uni(String materia,String facolta,String universita) throws Exception
	{
		Connection con = null;
		PreparedStatement pstmt = null;
		con = DriveManagerConnectionPool.getConnection();
		ResultSet rs= null;
		ArrayList <LibroBeans> list=new ArrayList<LibroBeans>();
		pstmt = con.prepareStatement(Select_libro_mat_fac_uni);
		
		pstmt.setString(1,materia);
		pstmt.setString(2, facolta);
		pstmt.setString(3,universita);
		rs=pstmt.executeQuery();
		
		while(rs.next())
		list.add( dammi_libro(rs));
		
		
		rs.close();
		pstmt.close();
		con.close();
		return(list);
			
	}
		
		private static LibroBeans dammi_libro(ResultSet rs) throws SQLException
		{
			LibroBeans risultato=new LibroBeans(rs.getString("username"),rs.getString("isbn"),rs.getString("titolo"),rs.getString("materia"),rs.getString ("facolta"),rs.getString("universita"),rs.getDouble("prezzo"));
			return(risultato);
		}

	}
	