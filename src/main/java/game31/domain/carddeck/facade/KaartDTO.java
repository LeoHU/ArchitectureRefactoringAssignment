package main.java.game31.domain.carddeck.facade;

public class KaartDTO {
	protected String symbool = "";
	protected String gifAdr = "";
	protected String getal = "";
	protected int waarde = 0;

	public KaartDTO(String symbool, String gifAdr, String getal, int waarde) {
		this.symbool = symbool;
		this.gifAdr = gifAdr;
		this.getal = getal;
		this.waarde = waarde;
	}

	public String getSymbool() {
		return symbool;
	}
	public String getGifAdr() {
		return gifAdr;
	}
	public String getGetal() {
		return getal;
	}
	public int getWaarde() {
		return waarde;
	}

	@Override
	public String toString() {
		return "KaartDTO [symbool=" + symbool + ", gifAdr=" + gifAdr
				+ ", getal=" + getal + ", waarde=" + waarde + "]";
	}
}
