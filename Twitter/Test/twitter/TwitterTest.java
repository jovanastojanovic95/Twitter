package twitter;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.twitter.Twitter;
import com.twitter.poruke.TwitterPoruka;

public class TwitterTest {
	
	Twitter t;

	@Before
	public void setUp() throws Exception {
		
		t=new Twitter();
		
	}

	@After
	public void tearDown() throws Exception {
		t=null;
	}

	@Test
	public void testVratiSvePorukeSveOk() {
		t.unesi("Jovana", "danas je lep dan.");
		assertEquals("Jovana", t.vratiSvePoruke().get(0).getKorisnik());
		assertEquals("danas je lep dan.", t.vratiSvePoruke().get(0).getPoruka());
	}

	@Test
	public void testUnesi() {
		t.unesi("Jovana", "danas je lep dan.");
		assertEquals("Jovana", t.vratiSvePoruke().getLast().getKorisnik());
		assertEquals("danas je lep dan.", t.vratiSvePoruke().getLast().getPoruka());
	}

	@Test
	public void testVratiPorukeSveOk() {
		
		t.unesi("Jovana","danas je lep dan." );
		t.unesi("Dusan","danas nije lep dan.");
		
		TwitterPoruka [] tp=new TwitterPoruka[2];
		
		for (int i = 0; i < tp.length; i++) {
			 	tp[i] = new TwitterPoruka();
		
		}
			 	tp[0].setKorisnik("Jovana");
			 	tp[0].setPoruka("danas je lep dan.");
			 	tp[1].setKorisnik("Dusan");
			 	tp[1].setPoruka("danas nije lep dan.");
			 	
			 	assertArrayEquals(tp, t.vratiPoruke(2, "danas"));
	

	}
	
	
	@Test(expected=java.lang.RuntimeException.class)
	public void testVratiPorukeTagNull(){
		
		t.vratiPoruke(3, null);
		
		
	}
	@Test(expected=java.lang.RuntimeException.class)
	public void testVratiPorukeTagPrazan(){
		
		t.vratiPoruke(3, "");
		
		
	}
	
}
