package test.classiDao;


import java.util.ArrayList;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import beans.AppuntiBeans;
import beans.LezioneBeans;
import beans.LibroBeans;

/**
 * Classe di test per {@link ProdottoDAO_Test}
 * @author Carmine
 *
 */


public class ProdottoDAO_Test {
	
	private LibroBeans libro;
	private AppuntiBeans appunti;
	private LezioneBeans lezione;
	
	@Before
	public void setUp() throws Exception {
		
		libro = new LibroBeans("m.moliterni@studenti.unisa.it", "provaid", "provaTitolo", "MateriaLibroNuova", "LibroprovaFacolta", "LibroprovaUni",10);
		appunti= new AppuntiBeans("provatitolo", "MateriaAppuniNuova", "AppuntiprovaFacolta", "AppuntiprovaUni", "provaid", 10, "m.moliterni@studenti.unisa.it");
		lezione = new LezioneBeans("provatitolo","provaid" ,"MateriaLezioneNuova", "LezioneprovaFacolta", "LezioneprovaUni", "m.moliterni@studenti.unisa.it", 10);
		classiDao.AppuntiDao.Insert(appunti);
		classiDao.LezioneDao.Insert(lezione);
		classiDao.LibroDao.Insert(libro);
	}
	
	
	@Test
	public void TestGetCorsi() throws Exception{
		
		
		ArrayList<String> tuttiCorsi = classiDao.ProdottoDao.getCorsi();
		
		for(int i=0;i<tuttiCorsi.size();i++) {
			if(tuttiCorsi.get(i).equals(lezione.getMateria()))		Assert.assertEquals(tuttiCorsi.get(i), lezione.getMateria());
		}
		
		for(int i=0;i<tuttiCorsi.size();i++) {
			if(tuttiCorsi.get(i).equals(appunti.getMateria()))		Assert.assertEquals(tuttiCorsi.get(i), appunti.getMateria());
		}
		
		for(int i=0;i<tuttiCorsi.size();i++) {
			if(tuttiCorsi.get(i).equals(libro.getMateria()))		Assert.assertEquals(tuttiCorsi.get(i), libro.getMateria());
		}
		
	}
	
	@Test
	public void TestGetFacolta() throws Exception{
		
		ArrayList<String> tutteFacolta = classiDao.ProdottoDao.getFacolta();
		
		for(int i=0;i<tutteFacolta.size();i++) {
			if(tutteFacolta.get(i).equals(lezione.getFacolta()))		Assert.assertEquals(tutteFacolta.get(i), lezione.getFacolta());
		}
		
		for(int i=0;i<tutteFacolta.size();i++) {
			if(tutteFacolta.get(i).equals(appunti.getFacolta()))		Assert.assertEquals(tutteFacolta.get(i), appunti.getFacolta());
		}
		
		for(int i=0;i<tutteFacolta.size();i++) {
			if(tutteFacolta.get(i).equals(libro.getFacolta()))		Assert.assertEquals(tutteFacolta.get(i), libro.getFacolta());
		}
		
	}
	
	
	@Test
	public void TestGetUniversita() throws Exception{
		
		
		ArrayList<String> tutteUni = classiDao.ProdottoDao.getUniversita();
		
		for(int i=0;i<tutteUni.size();i++) {
			if(tutteUni.get(i).equals(lezione.getUniverista()))		Assert.assertEquals(tutteUni.get(i), lezione.getUniverista());
		}
		
		for(int i=0;i<tutteUni.size();i++) {
			if(tutteUni.get(i).equals(appunti.getUniversita()))		Assert.assertEquals(tutteUni.get(i), appunti.getUniversita());
		}
		
		for(int i=0;i<tutteUni.size();i++) {
			if(tutteUni.get(i).equals(libro.getUniversita()))		Assert.assertEquals(tutteUni.get(i), libro.getUniversita());
		}
		
		
	}
	
	
	@After
	public void tearDown() throws Exception {

		classiDao.AppuntiDao.Delete_appunti(appunti.getId());
		classiDao.LezioneDao.Delete_lezione(lezione.getId());
		classiDao.LibroDao.Delete_libro(libro.getId());
		
		
	}

}
