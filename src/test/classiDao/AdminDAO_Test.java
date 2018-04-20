package test.classiDao;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.*;

import Connessione.DriveManagerConnectionPool;
import beans.AdminBeans;
import beans.UtenteBeans;
import classiDao.AdminDao;


/**
 * Classe di test per {@link AdminDao}
 * @author Marco
 *
 */

public class AdminDAO_Test {
	private static UtenteBeans utente = null;
	private static AdminBeans admin = null;
	private Connection con = null;
	private PreparedStatement pstmt = null;
	
	
	
	
	
	@Before
	public void setUp() throws Exception {
		
		// utente per il test
		utente = new UtenteBeans("0000",3906,"Marco","Moliterni","Informatica","unisa","prova@studenti.unisa.it","salerno");
		//admin per il test
		admin = new AdminBeans("admin@prova.it","0000");
		
		classiDao.AdminDao.Insert(admin);
		classiDao.UtenteDao.Insert(utente);
		
		
	}
	
	@Test
	public void TestUpdate() throws Exception {
		String newpass = "newpass";
		String oldpass = admin.getPsw();
		admin.setPsw(newpass);
		classiDao.AdminDao.Update(admin.getPsw(), admin);
		Assert.assertNotEquals(oldpass, admin.getEmail());
		
		
	}
	
	@Test
	public void TestDelete_Utente() throws Exception{
		classiDao.AdminDao.Delete_Utente(utente.getEmail());
		UtenteBeans nuovo = classiDao.UtenteDao.SelectUtente(utente.getEmail(), utente.getPsw());
		Assert.assertNull(nuovo);
		
	}
	
	
	@Test
	public void TestDelete_admin() throws Exception {
		AdminBeans nuovo = classiDao.AdminDao.SelectAdmin(admin.getEmail(), admin.getPsw());
		classiDao.AdminDao.Delete_Admin(admin.getEmail());
		Assert.assertNull(classiDao.AdminDao.SelectAdmin(nuovo.getEmail(), nuovo.getPsw()));
	}
	
	@Test
	public void TestSelectAdmin() throws Exception{
		AdminBeans nuovo = classiDao.AdminDao.SelectAdmin(admin.getEmail(), admin.getPsw());
		Assert.assertEquals(admin.getEmail(), nuovo.getEmail());
		Assert.assertEquals(admin.getPsw(), nuovo.getPsw());
		
		
	}
	
	

	@After
	public void tearDown() throws Exception {

		//cancello admin
		classiDao.AdminDao.Delete_Admin(admin.getEmail());
		
		//cancello utente
		classiDao.AdminDao.Delete_Utente(utente.getEmail());
		
	}
	
	
}
