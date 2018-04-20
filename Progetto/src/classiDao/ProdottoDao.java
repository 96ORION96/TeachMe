package classiDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Connessione.DriveManagerConnectionPool;

public class ProdottoDao {
	
	public ProdottoDao(){
		// TODO Auto-generated constructor stub
	}
	
	private static String getCorsi= "Select distinct t.materia FROM (Select materia FROM libro union Select materia FROM appunti union Select materia FROM lezione) t";
	private static String getFacolta= "Select distinct t.facolta FROM (Select facolta FROM libro union Select facolta FROM appunti union Select facolta FROM lezione) t";
	private static String getUniversita= "Select distinct t.universita FROM (Select universita FROM libro union Select universita FROM appunti union Select universita FROM lezione) t";
	
	public static ArrayList <String> getCorsi() throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		con = DriveManagerConnectionPool.getConnection();
		ResultSet rs = null;
		ArrayList <String> list = new ArrayList<String>();
		pstmt = con.prepareStatement(getCorsi);
		rs = pstmt.executeQuery();
		
		while(rs.next())
			list.add(rs.getString("materia"));
		
	    rs.close();
		pstmt.close();
		con.close();
		return(list);
	}
	
	public static ArrayList <String> getFacolta() throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		con = DriveManagerConnectionPool.getConnection();
		ResultSet rs = null;
		ArrayList <String> list = new ArrayList<String>();
		pstmt = con.prepareStatement(getFacolta);
		rs = pstmt.executeQuery();
		
		while(rs.next())
			list.add(rs.getString("facolta"));
		
	    rs.close();
		pstmt.close();
		con.close();
		return(list);
	}
	
	public static ArrayList <String> getUniversita() throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		con = DriveManagerConnectionPool.getConnection();
		ResultSet rs = null;
		ArrayList <String> list = new ArrayList<String>();
		pstmt = con.prepareStatement(getUniversita);
		rs = pstmt.executeQuery();
		
		while(rs.next())
			list.add(rs.getString("universita"));
		
	    rs.close();
		pstmt.close();
		con.close();
		return(list);
	}
	
	
}
