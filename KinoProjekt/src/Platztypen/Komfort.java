package Platztypen;

import java.io.Serializable;

import Default.Kunde;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.Pane;

public class Komfort extends Sitzplatz implements Serializable{
	private int aufpreis = 4;

	public int getAufpreis() {
		return aufpreis;
	}

	public void setAufpreis(int aufpreis) {
		this.aufpreis = aufpreis;
	}
	

	private void vermeideLuecken(Komfort platz, int i, int j) {
		// TODO Auto-generated method stub
	}

	@Override
	public void setPosition(int i, int j) {
		// TODO Auto-generated method stub
		setLayoutX(130 + j * 30);
		setLayoutY(137 + i *30);
	}
}
