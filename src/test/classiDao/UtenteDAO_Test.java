package test.classiDao;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import org.junit.*;

import Connessione.DriveManagerConnectionPool;
import beans.AdminBeans;
import beans.UtenteBeans;

public class UtenteDAO_Test {
	
	public UtenteBeans utente;
	
	/**
	 * Classe di test per {@link UtenteDAO_Test}
	 * @author Marco
	 *
	 */
	
	@Before
	public void setUp() throws Exception {
		
		// utente per il test
		utente = new UtenteBeans("0000",3906,"Marco","Moliterni","Informatica","unisa","m.moli@studenti.unisa.it","salerno");
		
		classiDao.UtenteDao.Insert(utente);
		
		
	}
	

	
	@Test
	public void TestInsert() throws Exception{
		UtenteBeans nuovo = classiDao.UtenteDao.SelectUtente(utente.getEmail(), utente.getPsw());
		Assert.assertEquals(nuovo.getEmail(), utente.getEmail());
		Assert.assertEquals(nuovo.getPsw(), utente.getPsw());
		Assert.assertEquals(nuovo.getCitta(), utente.getCitta());
		Assert.assertEquals(nuovo.getNome(), utente.getNome());
		Assert.assertEquals(nuovo.getCognome(), utente.getCognome());
		Assert.assertEquals(nuovo.getUniversita(), utente.getUniversita());
		Assert.assertEquals(nuovo.getFacolta(), utente.getFacolta());
		
	}
	
	
	@Test
	public void TestUpdate() throws Exception {
		UtenteBeans nuovo = new UtenteBeans();
		nuovo = classiDao.UtenteDao.SelectUtente(utente.getEmail(), utente.getPsw());
		String oldpass = nuovo.getPsw();
		String newpass = "newpass";
		
		nuovo.setPsw(newpass);
		classiDao.UtenteDao.Update(nuovo.getPsw(), nuovo);
		Assert.assertNotEquals(nuovo.getPsw(), oldpass);
		classiDao.AdminDao.Delete_Utente(nuovo.getEmail());
		
		
		
	}
	
	
	@Test
	public void TestSelectUtente_mail() throws Exception{
		ArrayList<UtenteBeans> nuovo = new ArrayList<>();
		nuovo = classiDao.UtenteDao.SelectUtente_mail(utente.getEmail());
		Assert.assertEquals(utente.getEmail(), nuovo.get(0).getEmail());
		
	}
	
	
	@After
	public void tearDown() throws Exception {

		
		//cancello utente
		classiDao.AdminDao.Delete_Utente(utente.getEmail());
		utente = null;
	}
	
}
