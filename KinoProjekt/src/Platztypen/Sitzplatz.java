package Platztypen;

import java.awt.Point;
import java.io.File;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

public abstract class Sitzplatz extends Button implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boolean belegt;
	private Point platzierung;
	//private int offset = 82;
	
	public Point getPlatzierung() {
		return platzierung;
	}
	public void setPlatzierung(Point platzierung) {
		this.platzierung = platzierung;
	}
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
		setPlatzierung(new Point(i,j));
		setId("Reihe: "+i+", Platz: "+j);
		getStyleClass().removeAll("button");
		getStyleClass().add("onClick");
		sitzplaetze.getChildren().add(this);
	}
	
	public void removeSitzplatz(Pane p) {
		p.getChildren().remove(this);
	}
	
	public void writePlatz(File f, ObjectOutputStream out) {
		try {
			out.writeObject(this);
		} catch (IOException e) {
			System.out.println("Datei konnte nicht gefunden werden.");
		}
	}
	
	public abstract void setPosition(int i, int j);
}
