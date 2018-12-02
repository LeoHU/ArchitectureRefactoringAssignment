package main.java.game31.domain.gamecontrol;

import java.util.*;

import main.java.game31.domain.carddeck.facade.KaartDTO;

public class Tafel
{
	private Vector<KaartDTO> kaarten;
	private KaartDTO selectedKaart;
	private int place;

	public Tafel()
	{
	}

	public void setKaarten(Vector<KaartDTO> kaarten)
	{
		this.kaarten = kaarten;
	}

	public void selecteerKaart(int index)
	{
		try {
			selectedKaart = kaarten.elementAt(index);
		}
		catch (NullPointerException e) { System.out.println("vector nog niet gevuld!"); }
	}

	public KaartDTO getSelected()
	{
		return selectedKaart;
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

	public Vector<KaartDTO> getKaarten()
	{
		return kaarten;
	}
	public void replaceAll(Vector<KaartDTO> kaarten)
	{
		this.kaarten = kaarten;
	}

}