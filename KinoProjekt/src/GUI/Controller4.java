package GUI;

import java.io.File;
import java.util.ArrayList;

import Default.Filmstart;
import Default.Kunde;
import Default.Reservierung;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;

public class Controller4 {
	
	private Filmstart film;
	private Controller main;
	private String info;
	// Elemente der Scene
	@FXML
	public AnchorPane ReservierungPane;
	@FXML
	private Label reservierung;
	@FXML
	private Button back;
	@FXML
	private Button end;
	
	public void init(Controller controller) {// Initialisiert den Controller
		main = controller;
	}
	
	public void initData(Filmstart film, ArrayList<Kunde>kundenListe) {// Initialisiert die Scene durch �bergabe der Daten
		this.film = film;
		Reservierung res = new Reservierung(film, kundenListe);
		res.speicherReservierung();
		info = res.getReservierungsInformationen();
		reservierung.setText(info);
	}
	
	public void zurSitzplatzAuswahl(ActionEvent e) { // Bei Auswahl wird die Sitzplatzauswahl aufgerufen
		main.loadSitzplatzAuswahl((Button) e.getSource(), film);
	}
	
	public void speicherPDF() { // Speichert Rechnung als PDF an gew�nschten Ort ab

		Alert alert = new Alert (AlertType.INFORMATION, "Sie k�nnen nun das Programm beenden. Bitte dr�cken Sie Ihre Reservierung aus und zeigen Sie diese an Kasse vor.");
		alert.showAndWait();
		back.setVisible(false);
		end.setVisible(true);
		
		FileChooser fc = new FileChooser();
		fc.setTitle("W�hlen Sie Ihren Speicherort f�r Ihre Rechnung");
		fc.setInitialFileName("Rechnung");
		fc.getExtensionFilters().addAll(
				new FileChooser.ExtensionFilter("PDF","*.pdf" ));
		File file = fc.showSaveDialog(ReservierungPane.getScene().getWindow());
		System.out.println(file.getAbsolutePath());
	}
	
	public void beenden() { // Schlie�t das Programm
		System.exit(0);
	}

}
