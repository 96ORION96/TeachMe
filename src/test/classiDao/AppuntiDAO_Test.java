package test.classiDao;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import beans.AppuntiBeans;


/**
 * Classe di test per {@link AppuntiDAO_Test}
 * @author Francesco
 *
 */

public class AppuntiDAO_Test {
	
	private static AppuntiBeans appunti;
	
	@Before
	public void setUp() throws Exception {
		
		appunti = new AppuntiBeans("appuntiProva", "materiaProva", "facoltaProva", "uniProva", "idProva", 20, "m.moliterni@studenti.unisa.it");
		classiDao.AppuntiDao.Insert(appunti);
		
		
	}
	
	@Test
	public void TestInsert() throws Exception{
		ArrayList<AppuntiBeans> arrayNuovo = classiDao.AppuntiDao.Select_appunti_id(appunti.getId());
		AppuntiBeans nuova = arrayNuovo.get(0);
		Assert.assertEquals(nuova.getId(), appunti.getId());
		Assert.assertEquals(nuova.getMail(), appunti.getMail());
		Assert.assertEquals(nuova.getFacolta(), appunti.getFacolta());
		Assert.assertEquals(nuova.getMateria(), appunti.getMateria());
		Assert.assertEquals(nuova.getTitolo(),appunti.getTitolo());
		Assert.assertEquals(nuova.getUniversita(), appunti.getUniversita());

		
		
	}
	
	@Test
	public void TestSelect_appunti_mail() throws Exception{
		ArrayList<AppuntiBeans> nuovoArray = classiDao.AppuntiDao.Select_appunti_email(appunti.getMail());
		AppuntiBeans nuova = nuovoArray.get(0);
		 
		Assert.assertEquals(nuova.getMail(),appunti.getMail());
		
	}
	
	@Test
	public void TestSelect_appunti_universita() throws Exception{
		ArrayList<AppuntiBeans> nuovoArray = classiDao.AppuntiDao.Select_appunti_universita(appunti.getUniversita());
		AppuntiBeans nuova = nuovoArray.get(0);
		Assert.assertEquals(nuova.getUniversita(),appunti.getUniversita());
	}
	
	@Test
	public void TestSelect_appunti_id() throws Exception {
		
		ArrayList<AppuntiBeans> nuovoArray = classiDao.AppuntiDao.Select_appunti_id(appunti.getId());
		AppuntiBeans nuova = nuovoArray.get(0);
		Assert.assertEquals(nuova.getId(),appunti.getId());
		
	}
	
	@Test
	public void TestSelect_appunti_fac() throws Exception {
		
		ArrayList<AppuntiBeans> nuovoArray = classiDao.AppuntiDao.Select_appunti_id(appunti.getId());
		AppuntiBeans nuova = nuovoArray.get(0);
		Assert.assertEquals(nuova.getFacolta(),appunti.getFacolta());
		
	}
	
	@Test
	public void TestDelete_appunti() throws Exception{
		ArrayList<AppuntiBeans> nuovoArray = classiDao.AppuntiDao.Select_appunti_id(appunti.getId());
		AppuntiBeans nuova = nuovoArray.get(0);
		classiDao.AppuntiDao.Delete_appunti(appunti.getId());
		Assert.assertNull(classiDao.AppuntiDao.Select_appunti_id(appunti.getId()));
	}
	
	@After
	public void tearDown() throws Exception {

		classiDao.AppuntiDao.Delete_appunti(appunti.getId());
		
		
	}

}
