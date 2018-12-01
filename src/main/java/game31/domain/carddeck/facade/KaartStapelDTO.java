package main.java.game31.domain.carddeck.facade;

import java.util.Vector;

public class KaartStapelDTO {
	private Vector<KaartDTO> kaartenDTOs  = new Vector<>();

	public KaartStapelDTO(Vector<KaartDTO> kaarten) {
		this.kaartenDTOs = kaarten;
	}

	public Vector<KaartDTO> getKaarten() {
		return kaartenDTOs;
	}

	@Override
	public String toString() {
		return "KaartStapelDTO [kaartenDTOs=" + kaartenDTOs + "]";
	}
}
