package main.java.game31.domain.carddeck.gateway;

import java.util.Vector;

public class KaartStapelDTO {
	   protected Vector<KaartDTO> kaarten  = new Vector<>();

	public KaartStapelDTO(Vector<KaartDTO> kaarten) {
		this.kaarten = kaarten;
	}

	public Vector<KaartDTO> getKaarten() {
		return kaarten;
	}

	@Override
	public String toString() {
		return "KaartStapelDTO [kaarten=" + kaarten + "]";
	}
}
