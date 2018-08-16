package GUI;

import java.util.ArrayList;

import Default.Kunde;
import Platztypen.Komfort;
import Platztypen.Loge;
import Platztypen.Pakett;
import Platztypen.Sitzplatz;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class Controller3 {

	private Controller main;

	@FXML
	public AnchorPane SitzplatzAuswahlPane;

	@FXML
	private Button sitzPlatzZurueck;
	@FXML
	private Pane sitzplaetze;
	@FXML
	private VBox comboContainer;
	@FXML
	private Label filmName;
	@FXML
	private Label saal;
	@FXML
	private Label uhrzeit;
	@FXML
	private Label tag;

	private ArrayList<Kunde> kundenListe = new ArrayList<Kunde>();

	public void init(Controller controller) {
		main = controller;
		comboContainer.setFillWidth(true);
	}

	public void zumStartBildschirm(ActionEvent e) {
		removeAllItems();
		main.loadStartBildschirm((Button) e.getSource());
	}

	EventHandler<ActionEvent> buttonClick = new EventHandler<ActionEvent>() {
		@Override
		public void handle(ActionEvent e) {
			Sitzplatz platz = (Sitzplatz) e.getSource();
			if (platz.isBelegt()) {
				platz.getStyleClass().removeAll("clicked");
				platz.getStyleClass().add("onClick");
				platz.setBelegt(false);
				for (int i = 0; i < kundenListe.size(); i++) {
					if ((kundenListe.get(i)).getComboBox().getId().equals(platz.getId())) {
						kundenListe.get(i).removeComboBox(comboContainer);
						kundenListe.remove(i);
					}
				}
			} else {
				platz.getStyleClass().removeAll("onClick");
				platz.getStyleClass().add("clicked");
				platz.setBelegt(true);
				Kunde kunde = new Kunde(platz, 0);
				kundenListe.add(kunde);
				comboContainer.getChildren().add(kunde.createNewComboBox(platz.getId()));
				// vermeideLuecken(platz,i,j);
			}
		}
	};

	public void generiereSitzplaetze(int reihe, int spalte) {

		for (int i = 0; i < reihe; i++) {
			for (int j = 0; j < spalte; j++) {
				if (i < 4) {
					Pakett pakettplatz = new Pakett();
					pakettplatz.addEventHandler(ActionEvent.ACTION, buttonClick);
					pakettplatz.erstelleSitzplatz(i, j, sitzplaetze);
				} else if (i >= 4 && i < 8) {
					Loge logenplatz = new Loge();
					logenplatz.addEventHandler(ActionEvent.ACTION, buttonClick);
					logenplatz.erstelleSitzplatz(i, j, sitzplaetze);
				} else {
					Komfort komfortplatz = new Komfort();
					komfortplatz.addEventHandler(ActionEvent.ACTION, buttonClick);
					komfortplatz.erstelleSitzplatz(i, j, sitzplaetze);
				}
			}

		}
	}

	public Boolean setComboBoxValues() {
		for (int i = 0; i < kundenListe.size(); i++) {
			if (kundenListe.get(i).getComboBox().getValue() != null) {
				switch (kundenListe.get(i).getComboBox().getValue()) {
				case "Erwachsener":
					kundenListe.get(i).setErmaessigung(0);
					break;
				case "Kind":
					kundenListe.get(i).setErmaessigung(2);
					break;
				}
				;
			} else {
				Alert alert = new Alert(AlertType.WARNING, "Bitte wählen Sie für alle Sitzplätze einen Tarif");
				alert.showAndWait();
				return false;
			}
		}
		return true;
	}

	public void zurReservierung(ActionEvent e) {
		
		if (!kundenListe.isEmpty()) {
			if (setComboBoxValues()) {
				System.out.println("Ich hab Spaß :)");
			} 
		}
		else {
			Alert alert = new Alert(AlertType.WARNING, "Sie haben keine Sitzplätze ausgewählt");
			alert.showAndWait();
		}
	}

	public void removeAllItems() {
		for (int i = kundenListe.size() - 1; i >= 0; i--) {
			kundenListe.get(i).getPlatz().getStyleClass().removeAll("clicked");
			kundenListe.get(i).getPlatz().getStyleClass().add("onClick");
			kundenListe.get(i).getPlatz().setBelegt(false);
			kundenListe.get(i).removeComboBox(comboContainer);
			kundenListe.remove(i);
		}
	}

	public void auswahlZurueck(ActionEvent e) {
		removeAllItems();
	}

}
