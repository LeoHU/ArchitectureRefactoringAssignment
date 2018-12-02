package main.java.game31.domain.carddeck.facade;

import java.util.Vector;

import main.java.game31.domain.carddeck.Kaart;
import main.java.game31.domain.carddeck.KaartStapel;
import main.java.game31.domain.gamecontrol.Spel;

public class CardDeckServices {
	
	private static CardDeckServices instance;
	private	static KaartStapel kaartStapel;
	
	private CardDeckServices(String spelNaam) {
		kaartStapel = new KaartStapel(spelNaam);
	}

	public static void createCardDeckServices (Spel spel) {
		String spelNaam = spel.getNaam();
		new CardDeckServices(spelNaam);
	}
	
	public static CardDeckServices getInstance() {
		if (CardDeckServices.instance == null) {
			instance = new CardDeckServices("Eenendertigen");
		}
		return instance;
	}

   public Vector<KaartDTO> getAlleKaarten() {
		Vector<Kaart> alleKaarten = kaartStapel.getAlleKaarten();
		Vector<KaartDTO> kaartenDTOs  = new Vector<>();
		for (Kaart kaart : alleKaarten) {
			KaartDTO kaartDTO = new KaartDTO(kaart.geefSymbool(), kaart.geefGifAdr(), kaart.geefGetal(),kaart.geefWaarde());
			kaartenDTOs.add(kaartDTO);
		}
		return kaartenDTOs;
	   }
	
	public Vector<KaartDTO> geefKaartenGeschud(int aantalDeelnemers) {
		Vector<Kaart> kaartGeschud = kaartStapel.geefKaartenGeschud(aantalDeelnemers);
		Vector<KaartDTO> kaartenDTOs  = new Vector<>();
		for (Kaart kaart : kaartGeschud) {
			KaartDTO kaartDTO = new KaartDTO(kaart.geefSymbool(), kaart.geefGifAdr(), kaart.geefGetal(),kaart.geefWaarde());
			kaartenDTOs.add(kaartDTO);
		}
		return kaartenDTOs;
	}

}
