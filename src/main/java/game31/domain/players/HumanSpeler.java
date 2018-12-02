package main.java.game31.domain.players;

import java.util.*;

public class HumanSpeler extends Speler
{
	private Calendar gebDatum;

	public static int createHumanSpeler(String naam, Calendar geboorteDatum, int fiches) {
		HumanSpeler human = new HumanSpeler(naam, geboorteDatum, fiches);
		int spelerId = human.getId();
		return spelerId;
	}

	private HumanSpeler(String naam, Calendar gebDatum, int fiches)
	{
		super(naam, fiches, true);
		this.gebDatum = gebDatum;
	}

	public void aanDeBeurt()
	{
	}

	public void eersteKeerInRonde()
	{
	}
	
	public Calendar geefGeboorteDatum() {
		return gebDatum;
	}
}