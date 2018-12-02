package main.java.game31.domain.gamecontrol;

import java.util.*;

import main.java.game31.domain.carddeck.facade.KaartDTO;
import main.java.game31.domain.players.Speler;
import main.java.game31.domain.players.facade.PlayersService;
import main.java.game31.domain.players.facade.SpelerDTO;

public class Deelname
{
	private int spelerId;
	private Vector<KaartDTO> kaarten;
	private int eindScore;	
	private int place;
	private KaartDTO selectedKaart;
	private ComputerDeelname computerDeelname;

	public Deelname(int spelerId, Tafel tafel, Spel spel)
	{
		this.spelerId = spelerId;
		Speler speler = Speler.geefSpeler(spelerId);
		speler.setDeelname(this);
		if (!speler.isHuman() == true) {
			computerDeelname = new ComputerDeelname(this, tafel, spel);
		}
	}

	public void setKaarten(Vector<KaartDTO> kaarten)
	{
		this.kaarten = kaarten;
	}

	public void eersteKeerInRonde() {
		SpelerDTO speler = PlayersService.getInstance().geefSpelerDetails(spelerId);
		if (!speler.isHumanSpeler() == true) {
			computerDeelname.eersteKeerInRonde();
		}
	}
	
	public void aanDeBeurt() {
		SpelerDTO speler = PlayersService.getInstance().geefSpelerDetails(spelerId);
		if (!speler.isHumanSpeler() == true) {
			computerDeelname.aanDeBeurt();
		}
	}
	
	public int geefEindScore()
	{
		eindScore = PlayersService.getInstance().geefSpelerDetails(spelerId).geefFiches();
		return eindScore;
	}

	public void replaceFor(KaartDTO k1, KaartDTO k2)
	{
		for (Iterator<KaartDTO> i = kaarten.iterator(); i.hasNext();) {
			KaartDTO k = i.next();
			if (k.equals(k1)) {
				place = kaarten.indexOf(k);
				kaarten.removeElementAt(place);
				kaarten.insertElementAt(k2, place);
				break;
			}
		}
	}

	public Vector<KaartDTO> getKaarten() {	
		if (kaarten == null) {
			return new Vector<KaartDTO>();
		} else {
			return kaarten;
		}
	}

	public int getSpeler()
	{
		return spelerId;
	}

	public void dumpFiche()
	{
		Speler.geefSpeler(spelerId).dumpFiche();
	}

	public KaartDTO getSelected()
	{
		return selectedKaart;
	}

	public void selecteerKaart(int index)
	{
		try {
			selectedKaart = kaarten.elementAt(index);
		}
		catch (NullPointerException e) { System.out.println("vector nog niet gevuld!"); }
	}

	public void replaceAll(Vector<KaartDTO> kaarten)
	{
		this.kaarten = kaarten;
	}
	
	public int getScore()
	{
		return eindScore;
	}
}
