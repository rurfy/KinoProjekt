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
	
	public void erstelleSitzplatz(int i, int j, Pane sitzplaetze) {
		setPrefSize(25, 25);
		setMinSize(25, 25);
		setMaxSize(25, 25);
		setPosition(i, j);
		setId("Reihe: "+i+", Platz: "+j);
		getStyleClass().removeAll("button");
		getStyleClass().add("onClick");
		sitzplaetze.getChildren().add(this);
	}
	
	public abstract void setPosition(int i, int j);
}
