package Platztypen;
 import java.io.Serializable;

import Default.Kunde;
import Default.Saal;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.Pane;


 public class Parkett extends Sitzplatz implements Serializable{
	
	 private int aufpreis=0;
 	public int getAufpreis() {
		return aufpreis;
	}
 	public void setAufpreis(int aufpreis) {
		this.aufpreis = aufpreis;
	}
	
	@Override
	public void setPosition(int i, int j) {
		// TODO Auto-generated method stub
		setLayoutX(130 + j * 30);
		setLayoutY(82 + i *30);
	}
}