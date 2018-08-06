package Platztypen;

public abstract class Sitzplatz {
	private boolean belegt;
	private int platzID;
	
	public boolean isBelegt() {
		return belegt;
	}
	public void setBelegt(boolean belegt) {
		this.belegt = belegt;
	}
	public int getPlatzID() {
		return platzID;
	}
	public void setPlatzID(int platzID) {
		this.platzID = platzID;
	}
}
