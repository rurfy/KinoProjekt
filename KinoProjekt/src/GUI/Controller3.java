package GUI;

import Default.AufrufListener;
import Default.Kunde;
import Platztypen.Komfort;
import Platztypen.Loge;
import Platztypen.Pakett;
import Platztypen.Sitzplatz;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Controller3 {

	private Controller main;

	@FXML
	public AnchorPane SitzplatzAuswahlPane;

	@FXML
	private Button sitzPlatzZurueck;
	@FXML
	private Pane sitzplaetze;
	@FXML private VBox comboContainer;

	public void init(Controller controller) {
		// TODO Auto-generated method stub
		main = controller;
	}

	public void zumStartBildschirm(ActionEvent e) {
		main.loadStartBildschirm((Button) e.getSource());
	}

	public void createNewComboBox(Kunde kunde) {
		comboContainer.getChildren().add(kunde.createNewComboBox());
	}
	
	
	
	public void generiereSitzplaetze(int reihe, int spalte) {
		Komfort komfortplatz = new Komfort();
		
		Loge logenplatz = new Loge();
		Pakett pakettplatz = new Pakett();
		pakettplatz.setAufrufListener(new AufrufListener() {
		    @Override
		    public void kundeErstellt() {
		        System.out.println("Date changed");
		    }
		});
		for (int i = 0; i < reihe; i++) {
			for (int j = 0; j < spalte; j++) {
				if (i < 4) {
					pakettplatz.erstelleSitzplatz(i, j, sitzplaetze);
				} else if (i >= 4 && i < 8) {
					logenplatz.erstelleSitzplatz(i, j, sitzplaetze);
				} else {
					komfortplatz.erstelleSitzplatz(i, j, sitzplaetze);
				}
			}

		}
	}
	
	
}
