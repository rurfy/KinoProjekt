package Default;

import Platztypen.Sitzplatz;

public class Kunde {
	private Sitzplatz[] platz;
	private int ermaessigung;
	
	public Sitzplatz[] getPlatz() {
		return platz;
	}
	public void setPlatz(Sitzplatz[] platz) {
		this.platz = platz;
	}
	public int getErmaessigung() {
		return ermaessigung;
	}
	public void setErmaessigung(int ermaessigung) {
		this.ermaessigung = ermaessigung;
	}
}
