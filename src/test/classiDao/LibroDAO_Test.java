package test.classiDao;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import beans.LibroBeans;


/**
 * Classe di test per {@link LibroDAO_Test}
 * @author Alessandro
 *
 */

public class LibroDAO_Test {
	
	private static LibroBeans libro;
	
	@Before
	public void setUp() throws Exception {
		
		libro = new LibroBeans("m.moliterni@studenti.unisa.it","prova", "prova", "prova", "prova", "proava", 13);
		classiDao.LibroDao.Insert(libro);
		
		
	}
	
	@Test
	public void TestInsert() throws Exception{
		ArrayList<LibroBeans> arrayNuovo = classiDao.LibroDao.Select_libri_id(libro.getId());
		LibroBeans nuova = arrayNuovo.get(0);
		Assert.assertEquals(nuova.getId(), libro.getId());
		Assert.assertEquals(nuova.getMail(), libro.getMail());
		Assert.assertEquals(nuova.getFacolta(), libro.getFacolta());
		Assert.assertEquals(nuova.getMateria(), libro.getMateria());
		Assert.assertEquals(nuova.getTitolo(),libro.getTitolo());
		Assert.assertEquals(nuova.getUniversita(), libro.getUniversita());

		
		
	}
	
	@Test
	public void TestSelect_libro_mail() throws Exception{
		ArrayList<LibroBeans> nuovoArray = classiDao.LibroDao.Select_libri_email(libro.getMail());
		LibroBeans nuova = nuovoArray.get(0);
		 
		Assert.assertEquals(nuova.getMail(),libro.getMail());
		
	}
	
	@Test
	public void TestSelect_libro_universita() throws Exception{
		ArrayList<LibroBeans> nuovoArray = classiDao.LibroDao.Select_libro_universita(libro.getUniversita());
		LibroBeans nuova = nuovoArray.get(0);
		Assert.assertEquals(nuova.getUniversita(),libro.getUniversita());
	}
	
	@Test
	public void TestSelect_libro_id() throws Exception {
		
		ArrayList<LibroBeans> nuovoArray = classiDao.LibroDao.Select_libri_id(libro.getId());
		LibroBeans nuova = nuovoArray.get(0);
		Assert.assertEquals(nuova.getId(),libro.getId());
		
	}
	
	@Test
	public void TestSelect_libro_fac() throws Exception {
		
		ArrayList<LibroBeans> nuovoArray = classiDao.LibroDao.Select_libro_facolta(libro.getFacolta());
		LibroBeans nuova = nuovoArray.get(0);
		Assert.assertEquals(nuova.getFacolta(),libro.getFacolta());
		
	}
	
	@Test
	public void TestDelete_libro() throws Exception{
		ArrayList<LibroBeans> nuovoArray = classiDao.LibroDao.Select_libri_id(libro.getId());
		LibroBeans nuova = nuovoArray.get(0);
		classiDao.LibroDao.Delete_libro(libro.getId());
		Assert.assertNull(classiDao.LibroDao.Select_libri_id(libro.getId()));
	}
	
	@After
	public void tearDown() throws Exception {

		classiDao.LibroDao.Delete_libro(libro.getId());
		
		
	}

}

