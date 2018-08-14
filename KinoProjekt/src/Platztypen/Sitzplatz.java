package Platztypen;

import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

public abstract class Sitzplatz extends Button{
	private boolean belegt;
	
	public boolean isBelegt() {
		return belegt;
	}
	public void setBelegt(boolean belegt) {
		this.belegt = belegt;
	}
	
	public abstract void erstelleSitzplatz(int i, int j, Pane sitzplaetze) ;
}
