package GUI;

import Default.AufrufListener;
import Default.Kunde;
import Platztypen.Komfort;
import Platztypen.Loge;
import Platztypen.Pakett;
import Platztypen.Sitzplatz;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
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
		main = controller;
		comboContainer.setFillWidth(true);
	}

	public void zumStartBildschirm(ActionEvent e) {
		main.loadStartBildschirm((Button) e.getSource());
	}

//	public void createNewComboBox(Kunde kunde) {
//		comboContainer.getChildren().add(kunde.createNewComboBox());
//	}
	
	EventHandler<ActionEvent> buttonClick = new EventHandler<ActionEvent>() {
		@Override
		public void handle(ActionEvent e) {
			Pakett platz = (Pakett) e.getSource();
			if(platz.isBelegt()) {
				platz.getStyleClass().removeAll("clicked");
				platz.getStyleClass().add("onClick");
				platz.setBelegt(false);
			} else {
				platz.getStyleClass().removeAll("onClick");
				platz.getStyleClass().add("clicked");
				platz.setBelegt(true);
				//System.out.println(platz.getId());
				Kunde kunde = new Kunde(platz, 0);
				comboContainer.getChildren().add(createNewComboBox());
				//vermeideLuecken(platz,i,j);
			}
		}
	};
	
	public ComboBox<String> createNewComboBox() {
 		ComboBox<String> box = new ComboBox<String>();
		box.getItems().addAll("Erwachsener", "Kind");
		box.setPromptText("Tarif wählen");
		box.setEditable(false);
		//box.setMinWidth(comboContainer.getWidth());
		box.setPrefWidth(265);
		box.setMaxWidth(Double.MAX_VALUE);
 		box.setButtonCell(new ListCell<String>() {
 			@Override
			protected void updateItem(String item, boolean empty) {
				super.updateItem(item, empty);
				if (empty || item == null) {
					setStyle("-fx-text-fill: rgb(0,198,187)");
				} else {
					setStyle("-fx-text-fill: rgb(0,198,187)");
					setText(item.toString());
				}
			}
 		});
		return box;
	}
	
	public void generiereSitzplaetze(int reihe, int spalte) {

		for (int i = 0; i < reihe; i++) {
			for (int j = 0; j < spalte; j++) {
				if (i < 4) {
					Pakett pakettplatz = new Pakett();
					pakettplatz.addEventHandler(ActionEvent.ACTION, buttonClick);
					pakettplatz.erstelleSitzplatz(i, j, sitzplaetze);
//					pakettplatz.setAufrufListener(new AufrufListener() {
//				    @Override
//				    public void kundeErstellt() {
//				        System.out.println("Date changed");
//				    }
//				});
				} else if (i >= 4 && i < 8) {
					Loge logenplatz = new Loge();
					logenplatz.erstelleSitzplatz(i, j, sitzplaetze);
				} else {
					Komfort komfortplatz = new Komfort();
					komfortplatz.erstelleSitzplatz(i, j, sitzplaetze);
				}
			}

		}
	}
	
	
}
