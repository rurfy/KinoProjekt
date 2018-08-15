package Platztypen;

import Default.Kunde;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.Pane;

public class Komfort extends Sitzplatz{
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
	public void erstelleSitzplatz(int i, int j, Pane sitzplaetze) {
		Komfort platz = new Komfort();
		platz.setPrefSize(25, 25);
		platz.setMinSize(25, 25);
		platz.setMaxSize(25, 25);
		platz.setLayoutX(130 + j * 30);
		platz.setLayoutY(137 + i *30);
		platz.setId("Reihe: "+i+", Platz: "+j);
		platz.getStyleClass().removeAll("button");
		platz.getStyleClass().add("onClick");
		platz.setOnAction(new EventHandler<ActionEvent>() {
 			@Override
			public void handle(ActionEvent e) {
				// TODO Auto-generated method stub
				if(platz.isBelegt()) {
					platz.getStyleClass().removeAll("clicked");
					platz.getStyleClass().add("onClick");
					platz.setBelegt(false);
					Kunde kunde = new Kunde(platz, 0);
				} else {
					platz.getStyleClass().removeAll("onClick");
					platz.getStyleClass().add("clicked");
					platz.setBelegt(true);
					vermeideLuecken(platz,i,j);
				}
			
		}
 			
				
			});
		sitzplaetze.getChildren().add(platz);
		
	}
}
