package main.java.game31.domain.carddeck.gateway;

import java.util.Vector;

import main.java.game31.domain.carddeck.Kaart;
import main.java.game31.domain.carddeck.KaartStapel;

public class CardDeckServices {
	
	private static CardDeckServices instance;
	private	KaartStapel	ks = new KaartStapel("Eenendertigen");
	
	private CardDeckServices() {
	}

	public static CardDeckServices getInstance() {
		if (CardDeckServices.instance == null) {
			instance = new CardDeckServices();
		}
		return instance;
	}

	public KaartStapelDTO geefKaartenGeschud(int aantalDeelnemers) {
		Vector<Kaart> kaartGeschud = ks.geefKaartenGeschud(aantalDeelnemers);
		Vector<KaartDTO> kaarten  = new Vector<>();
		for (Kaart kaart : kaartGeschud) {
			KaartDTO kaartDTO = new KaartDTO(kaart.geefSymbool(), kaart.geefGifAdr(), kaart.geefGetal(),kaart.geefWaarde());
			kaarten.add(kaartDTO);
		}
		KaartStapelDTO kaartStapelDTO= new KaartStapelDTO(kaarten);
		return kaartStapelDTO;
	}

}
