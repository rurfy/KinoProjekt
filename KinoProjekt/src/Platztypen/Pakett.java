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
	@Override
	public void setPosition(int i, int j) {
		// TODO Auto-generated method stub
		setLayoutX(130 + j * 30);
		setLayoutY(82 + i *30);
	}
}