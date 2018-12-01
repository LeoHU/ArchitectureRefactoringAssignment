package test.java.unit;

import static org.junit.Assert.assertSame;
import main.java.game31.domain.carddeck.KaartStapel;
import main.java.game31.domain.carddeck.facade.CardDeckServices;

import org.junit.Before;
import org.junit.Test;



public class KaartStapelTest {

	KaartStapel kaartStapel;
	CardDeckServices cardDeckServices;
	
	@Before
	public void prepareServices(){
		cardDeckServices = CardDeckServices.getInstance("Eenendertigen");
	}
	
	@Test 
	public void testAantalKaarten(){
		int aantalKaarten = cardDeckServices.getAlleKaarten().getKaarten().size();
		System.out.println(" Number of all cards: " + aantalKaarten);
		assertSame(aantalKaarten, 32);
	}
	
	@Test 
	public void testAantalGeschuddeKaarten(){
		int aantalKaarten = cardDeckServices.geefKaartenGeschud(2).getKaarten().size();
		//int aantalKaarten = kaartStapel.geefKaartenGeschud(2).size();
		System.out.println(" Number of shuffled cards: " + aantalKaarten);
		assertSame(aantalKaarten, 6);
	}
}
