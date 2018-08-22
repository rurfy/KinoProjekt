package Default;

import java.io.Serializable;

import Platztypen.Sitzplatz;

public class Saal implements Serializable{ // Speichert die Eckdaten eines Saals
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int saalnummer;
	private int reihenPakett, reihenLoge, reihenKomfort;
	private Filmstart[] start;
	private Sitzplatz[][] platz;
	private String backgroundURL;
	
	public Saal(int saalnummer, Sitzplatz[][] sitzplatze, int reihenPakett, int reihenLoge, int reihenKomfort, String background) {
		this.saalnummer = saalnummer;
		this.platz = sitzplatze;
		this.reihenKomfort = reihenKomfort;
		this.reihenLoge = reihenLoge;
		this.reihenPakett = reihenPakett;
		this.backgroundURL = background;
	}
	
	public String getBackgroundURL() {
		return backgroundURL;
	}

	public void setBackgroundURL(String backgroundURL) {
		this.backgroundURL = backgroundURL;
	}
	
	public int getReihenPakett() {
		return reihenPakett;
	}

	public void setReihenPakett(int reihenPakett) {
		this.reihenPakett = reihenPakett;
	}

	public int getReihenLoge() {
		return reihenLoge;
	}

	public void setReihenLoge(int reihenLoge) {
		this.reihenLoge = reihenLoge;
	}

	public int getReihenKomfort() {
		return reihenKomfort;
	}

	public void setReihenKomfort(int reihenKomfort) {
		this.reihenKomfort = reihenKomfort;
	}
	
	public Filmstart[] getStart() {
		return start;
	}
	public void setStart(Filmstart[] start) {
		this.start = start;
	}
	public Sitzplatz[][] getPlatz() {
		return platz;
	}
	public void setPlatz(Sitzplatz[][] platz) {
		this.platz = platz;
	}
	public int getSaalnummer() {
		return saalnummer;
	}
	public void setSaalnummer(int saalnummer) {
		this.saalnummer = saalnummer;
	}
	
	
	
}
