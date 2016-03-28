
package twitter;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.twitter.poruke.TwitterPoruka;

public class TwitterPorukaTest {

	TwitterPoruka tw;

	@Before
	public void setUp() throws Exception {
		tw = new TwitterPoruka();

	}

	@After
	public void tearDown() throws Exception {
		tw = null;
	}

	@Test
	public void testSetKorisnikSveOk() {

		String korisnik = "Pera";

		tw.setKorisnik(korisnik);

		assertEquals(korisnik, tw.getKorisnik());

	}

	@Test(expected = java.lang.RuntimeException.class)
	public void testSetKorisnikNull() {

		tw.setKorisnik(null);
	}

	@Test(expected = java.lang.RuntimeException.class)
	public void testSetKorisniPrazanString() {

		tw.setKorisnik("");
	}

	@Test
	public void testSetPorukaSveOk() {

		tw.setPoruka("Sve je okej.");

		assertEquals("Sve je okej.", tw.getPoruka());
	}

	@Test(expected = java.lang.RuntimeException.class)
	public void testSetPorukaNull() {

		tw.setPoruka(null);
	}

	@Test (expected=java.lang.RuntimeException.class)
	public void testSetPorukaDuzina() {
		
		tw.setPoruka("JUnit is a unit testing framework for the Java programming language."
				+ " A unit test is a piece of code written by a developer that executes a"
				+ " specific functionality in the code to be tested. A unit test targets a"
				+ " small unit of code, e.g., a method or a class, and they ensure that code "
				+ "works as intended. JUnit has been important in the development of test-driven"
				+ " style of programming."
				+ "Javadoc is a documentation generator for generating API documentation in HTML"
				+ " format from Java source code. The HTML format is used to add the convenience"
				+ " of being able to hyperlink related documents together. The doc comments"
				+ " format used by Javadoc is the de facto industry standard for documenting"
				+ " Java classes.");
		
	}
	@Test
	public void testToString() {
		
		tw.setKorisnik("Pera");
		tw.setPoruka("Sve je okej.");
		String ok=tw.toString();
		assertEquals("KORISNIK:" + "Pera" + " PORUKA:" + "Sve je okej.", ok);
		
	}

}
