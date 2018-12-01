package main.java.game31.domain.players;

import java.util.Calendar;

public class PlayersService {
	
	private static PlayersService instance;
	
	private PlayersService() {
	}
	
	public static PlayersService getInstance() {
		if (PlayersService.instance == null) {
			instance = new PlayersService();
		}
		return instance;
	}

	/**
	 * Creates a human speler and returns a spelerId
	 * @param naam
	 * @param geboorteDatum
	 * @param fiches
	 * @param tafel
	 * @return int
	 */
	public int createHumanSpeler(String naam, Calendar geboorteDatum, int fiches) {
		return HumanSpeler.createHumanSpeler(naam, geboorteDatum, fiches);
	}

	/**
	 * Creates a computerspeler and returns a spelerId
	 * @param naam
	 * @param fiches 
	 * @param tafel
	 * @param ks
	 * @param spel
	 * @return int
	 */
	public int createComputerSpeler(String naam, int fiches) {
		return ComputerSpeler.createComputerSpeler(naam, fiches);
	}
	
	/**
	 * Moves a fiche from the given speler to the pot, if a speler with the given spelerId was found.
	 * @param spelerId
	 */
	public void dumpFiche(int spelerId) {
		Speler speler = Speler.geefSpeler(spelerId);
		if (speler != null) {
			speler.dumpFiche();
		}
	}
	
	/**
	 * Provides a SpelerDTO with the details of a speler, if a speler with the given spelerId was found. 
	 * Else, a SpelerDTO is returned with name = "", fiches = 0, and isHuman = true.   
	 * @param spelerId
	 * @return SpelerDTO
	 */
	public SpelerDTO geefSpelerDetails(int spelerId) {
		SpelerDTO spelerDTO;
		Speler speler = Speler.geefSpeler(spelerId);
		if (speler != null) {
			spelerDTO = speler.geefDetails();
		} else {
			spelerDTO =  new SpelerDTO(spelerId, "", 0, true);
		}
		return spelerDTO;
	}
}
