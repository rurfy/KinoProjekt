package Default;

import Tage.Tage;

public class Filmstart extends Film{
	
	public Filmstart(double dauer, String titel, int fsk, String genre, String trailer, String bildURL, double preis) {
		super(dauer, titel, fsk, genre, trailer, bildURL, preis);
		// TODO Auto-generated constructor stub
	}

	private Tage tag;

	public Tage getTag() {
		return tag;
	}

	public void setTag(Tage tag) {
		this.tag = tag;
	}
	
}
