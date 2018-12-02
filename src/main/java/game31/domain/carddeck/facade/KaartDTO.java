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

	public String geefSymbool() {
		return symbool;
	}
	public String geefGifAdr() {
		return gifAdr;
	}
	public String geefGetal() {
		return getal;
	}
	public int geefWaarde() {
		return waarde;
	}

	@Override
	public String toString() {
		return "KaartDTO [symbool=" + symbool + ", gifAdr=" + gifAdr
				+ ", getal=" + getal + ", waarde=" + waarde + "]";
	}
	
	public boolean equals(KaartDTO k) {
		boolean isEqual = false;
		if (k.geefSymbool().equals(geefSymbool()) || k.geefGetal().equals(geefGetal())) {
			isEqual = true;
		} 
		return isEqual;
	}
}
