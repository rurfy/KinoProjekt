package Platztypen;
 import Default.AufrufListener;
import Default.Kunde;
import Default.Saal;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.Pane;


 public class Pakett extends Sitzplatz{
	private int aufpreis=0;
 	public int getAufpreis() {
		return aufpreis;
	}
 	public void setAufpreis(int aufpreis) {
		this.aufpreis = aufpreis;
	}
 	@Override
	public void erstelleSitzplatz(int i, int j, Pane sitzplaetze) {
		Pakett platz = new Pakett();
		platz.setPrefSize(25, 25);
		platz.setMinSize(25, 25);
		platz.setMaxSize(25, 25);
		platz.setLayoutX(130 + j * 30);
		platz.setLayoutY(82 + i *30);
		platz.setId("Reihe: "+i+", Platz: "+j);
		platz.getStyleClass().removeAll("button");
		platz.getStyleClass().add("onClick");
		//Saal saal1 = new Saal(platz,i,j);
		platz.setOnAction(new EventHandler<ActionEvent>() {
		
			@Override
			public void handle(ActionEvent e) {
				// TODO Auto-generated method stub
				if(platz.isBelegt()) {
					platz.getStyleClass().removeAll("clicked");
					platz.getStyleClass().add("onClick");
					platz.setBelegt(false);
					Kunde kunde = new Kunde(platz, 0);
					listener.kundeErstellt();
					kunde.createNewComboBox();
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
	
	private void vermeideLuecken(Pakett platz, int i, int j) {
		// TODO Auto-generated method stub				
		platz.setId("Reihe: "+i+", Platz: "+j+1);
		Saal saal1 = null;
		
		if (platz.isBelegt()==false) {
			platz.setId("Reihe: "+i+", Platz: "+j+(-1));
			if(platz.isBelegt()==true) {
				System.out.println("test");
			}
		}
 	}
	
	private AufrufListener listener = new AufrufListener();
	public void setAufrufListener(AufrufListener lis) {
	    listener = lis;
	}
}