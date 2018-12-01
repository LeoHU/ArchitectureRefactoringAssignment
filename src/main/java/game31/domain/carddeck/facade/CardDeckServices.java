package main.java.game31.domain.carddeck.facade;

import java.util.Vector;

import main.java.game31.domain.carddeck.Kaart;
import main.java.game31.domain.carddeck.KaartStapel;

public class CardDeckServices {
	
	private static CardDeckServices instance;
	private	 KaartStapel ks;
	
	private CardDeckServices(String spelNaam) {
		ks = new KaartStapel(spelNaam);
	}

	public static CardDeckServices getInstance(String spelNaam) {
		if (CardDeckServices.instance == null) {
			instance = new CardDeckServices(spelNaam);
		}
		return instance;
	}

   public KaartStapelDTO getAlleKaarten() {
		Vector<Kaart> alleKaarten = ks.getAlleKaarten();
		Vector<KaartDTO> kaartenDTOs  = new Vector<>();
		for (Kaart kaart : alleKaarten) {
			KaartDTO kaartDTO = new KaartDTO(kaart.geefSymbool(), kaart.geefGifAdr(), kaart.geefGetal(),kaart.geefWaarde());
			kaartenDTOs.add(kaartDTO);
		}
		KaartStapelDTO kaartStapelDTO= new KaartStapelDTO(kaartenDTOs);
		return kaartStapelDTO;
	   }
	
	public KaartStapelDTO geefKaartenGeschud(int aantalDeelnemers) {
		Vector<Kaart> kaartGeschud = ks.geefKaartenGeschud(aantalDeelnemers);
		Vector<KaartDTO> kaartenDTOs  = new Vector<>();
		for (Kaart kaart : kaartGeschud) {
			KaartDTO kaartDTO = new KaartDTO(kaart.geefSymbool(), kaart.geefGifAdr(), kaart.geefGetal(),kaart.geefWaarde());
			kaartenDTOs.add(kaartDTO);
		}
		KaartStapelDTO kaartStapelDTO= new KaartStapelDTO(kaartenDTOs);
		return kaartStapelDTO;
	}

}
