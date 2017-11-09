package main.java.game31.domain.players;

import java.util.TreeMap;

import main.java.game31.domain.gamecontrol.Deelname;
import main.java.game31.domain.gamecontrol.Tafel;

public abstract class Speler {
	protected static TreeMap<Integer, Speler> spelersMap = new TreeMap<>();
	protected static Pot gedeeldePot = new Pot();
	protected int id;
	protected String naam;
	protected int fiches;
	protected boolean isHuman;
	protected Deelname deelname;
	protected Pot pot;
	protected Tafel tafel;
	
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
	
	protected Speler(String naam, int fiches, Tafel tafel, boolean isHuman)
	{
		this.id = geefNieuweSpelerId();
		this.naam = naam;
		this.fiches = fiches;
		this.isHuman = isHuman;
		this.tafel = tafel;
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
	
	public abstract void aanDeBeurt();
	public abstract void eersteKeerInRonde();


	public void setDeelname(Deelname dn) {
		this.deelname = dn;
	}
}
