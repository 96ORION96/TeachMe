package test.classiDao;

import java.util.ArrayList;



import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import beans.LezioneBeans;
import beans.UtenteBeans;


/**
 * Classe di test per {@link LezioneDAO_Test}
 * @author Carmine
 *
 */

public class LezioneDAO_Test {
	
	private static LezioneBeans lezione;
	
	@Before
	public void setUp() throws Exception {
		
		lezione = new LezioneBeans("lezioneProva", "idProva", "materiaProva", "facoltaProva", "universitaProva", "mailProva", 100);
		classiDao.LezioneDao.Insert(lezione);
		
		
	}
	
	@Test
	public void TestInsert() throws Exception{
		ArrayList<LezioneBeans> arrayNuovo = classiDao.LezioneDao.Select_lezione_id(lezione.getId());
		LezioneBeans nuova = arrayNuovo.get(0);
		Assert.assertEquals(nuova.getId(), lezione.getId());
		Assert.assertEquals(nuova.getMail(), lezione.getMail());
		Assert.assertEquals(nuova.getFacolta(), lezione.getFacolta());
		Assert.assertEquals(nuova.getMateria(), lezione.getMateria());
		Assert.assertEquals(nuova.getTitolo(),lezione.getTitolo());
		Assert.assertEquals(nuova.getUniverista(), lezione.getUniverista());

		
		
	}
	
	@Test
	public void TestSelect_lezione_mail() throws Exception{
		ArrayList<LezioneBeans> nuovoArray = classiDao.LezioneDao.Select_lezione_email(lezione.getMail());
		LezioneBeans nuova = nuovoArray.get(0);
		 
		Assert.assertEquals(nuova.getMail(),lezione.getMail());
		
	}
	
	@Test
	public void TestSelect_lezione_universita() throws Exception{
		ArrayList<LezioneBeans> nuovoArray = classiDao.LezioneDao.Select_lezione_universita(lezione.getUniverista());
		LezioneBeans nuova = nuovoArray.get(0);
		Assert.assertEquals(nuova.getUniverista(),lezione.getUniverista());
	}
	
	@Test
	public void TestSelect_lezione_id() throws Exception {
		
		ArrayList<LezioneBeans> nuovoArray = classiDao.LezioneDao.Select_lezione_id(lezione.getId());
		LezioneBeans nuova = nuovoArray.get(0);
		Assert.assertEquals(nuova.getId(),lezione.getId());
		
	}
	
	@Test
	public void TestSelect_lezione_fac() throws Exception {
		
		ArrayList<LezioneBeans> nuovoArray = classiDao.LezioneDao.Select_lezione_facolta(lezione.getFacolta());
		LezioneBeans nuova = nuovoArray.get(0);
		Assert.assertEquals(nuova.getFacolta(),lezione.getFacolta());
		
	}
	
	@Test
	public void TestDelete_lezione() throws Exception{
		ArrayList<LezioneBeans> nuovoArray = classiDao.LezioneDao.Select_lezione_id(lezione.getId());
		LezioneBeans nuova = nuovoArray.get(0);
		classiDao.LezioneDao.Delete_lezione(lezione.getId());
		Assert.assertNull(classiDao.LezioneDao.Select_lezione_id(lezione.getId()));
	}
	
	@After
	public void tearDown() throws Exception {

		classiDao.LezioneDao.Delete_lezione(lezione.getId());
		
		
	}

}
