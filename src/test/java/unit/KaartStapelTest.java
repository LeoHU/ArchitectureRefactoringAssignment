package test.java.unit;

import static org.junit.Assert.assertSame;
import main.java.game31.domain.carddeck.KaartStapel;
import main.java.game31.domain.carddeck.facade.CardDeckServices;
import main.java.game31.domain.gamecontrol.Spel;

import org.junit.Before;
import org.junit.Test;



public class KaartStapelTest {

	KaartStapel kaartStapel;
	CardDeckServices cardDeckServices;
	
	@Before
	public void prepareServices(){
		CardDeckServices.createCardDeckServices(new Spel());
		cardDeckServices = CardDeckServices.getInstance();
	}
	
	@Test 
	public void testAantalKaarten(){
		int aantalKaarten = cardDeckServices.getAlleKaarten().size();
		System.out.println(" Number of all cards: " + aantalKaarten);
		assertSame(aantalKaarten, 32);
	}
	
	@Test 
	public void testAantalGeschuddeKaarten(){
		int aantalKaarten = cardDeckServices.geefKaartenGeschud(2).size();
		//int aantalKaarten = kaartStapel.geefKaartenGeschud(2).size();
		System.out.println(" Number of shuffled cards: " + aantalKaarten);
		assertSame(aantalKaarten, 6);
	}
}
