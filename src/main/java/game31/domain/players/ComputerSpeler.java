package main.java.game31.domain.players;

public class ComputerSpeler extends Speler{

	public static int createComputerSpeler(String naam, int fiches) {
		ComputerSpeler computer = new ComputerSpeler(naam, fiches);
		int spelerId = computer.getId();
		return spelerId;
	}

	private ComputerSpeler(String naam, int fices)
	{
		super(naam,fices, false);
	}

}
