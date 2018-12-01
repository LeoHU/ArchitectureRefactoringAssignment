package main.java.game31.domain.players;

import java.util.TreeMap;

public abstract class Speler {
	protected static TreeMap<Integer, Speler> spelersMap = new TreeMap<>();
	protected static Pot gedeeldePot = new Pot();
	protected int id;
	protected String naam = "";
	protected int fiches = 0;
	protected boolean isHuman = true;
	protected Pot pot;
	
	private static int geefNieuweSpelerId() {
		int newId = 1;
		if (!spelersMap.isEmpty()) {		
			newId = newId + spelersMap.lastKey();
		}
		return newId;
	}

	public static Speler geefSpeler(int id) {
		return spelersMap.get(id);
	}
	
	protected Speler(String naam, int fiches, boolean isHuman)
	{
		this.id = geefNieuweSpelerId();
		this.naam = naam;
		this.fiches = fiches;
		this.isHuman = isHuman;
		this.pot = gedeeldePot;
		spelersMap.put(id, this);
	}

	protected int getId() {
		return id;
	}
	
	protected String geefNaam()
	{
		return naam;
	}

	public boolean isHuman() {
		return isHuman;
	}
	
	public void dumpFiche()
	{
		pot.donatieFiche();
		this.fiches--;
	}

	protected int geefFiches()
	{
		return fiches;
	}

	protected SpelerDTO geefDetails() {
		return new SpelerDTO(id, naam, fiches, isHuman);
	}
}
