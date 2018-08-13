package GUI;

import Platztypen.Sitzplatz;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Controller3 {

	private Controller main;
	
	@FXML public AnchorPane SitzplatzAuswahlPane;
	
	@FXML private Button sitzPlatzZurueck;
	@FXML private Pane sitzplaetze;
	
	public void init(Controller controller) {
		// TODO Auto-generated method stub
		main = controller;
	}
	
	public void zumStartBildschirm(ActionEvent e) {
		main.loadStartBildschirm((Button) e.getSource());
	}
	
	public void generiereSitzplaetze(int reihe, int spalte) {
		Sitzplatz platz = new Sitzplatz();		
		for (int i = 0; i < reihe; i++) {
			for (int j = 0; j < spalte; j++) {
				platz.erstelleSitzplatz(i,j, sitzplaetze);
			}

		}
	}
}
