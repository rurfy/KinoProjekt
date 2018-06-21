package Default;

import Platztypen.Sitzplatz;

public class Saal {
	private int saalnummer;
	private Filmstart[] start;
	private Sitzplatz[] platz;
	
	public Filmstart[] getStart() {
		return start;
	}
	public void setStart(Filmstart[] start) {
		this.start = start;
	}
	public Sitzplatz[] getPlatz() {
		return platz;
	}
	public void setPlatz(Sitzplatz[] platz) {
		this.platz = platz;
	}
	public int getSaalnummer() {
		return saalnummer;
	}
	public void setSaalnummer(int saalnummer) {
		this.saalnummer = saalnummer;
	}
	
	
	
}
