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
	private Reservierung res;
	
	// Elemente der Scene
	@FXML
	public AnchorPane ReservierungPane;
	@FXML
	private Label reservierung;
	@FXML
	private Button back;
	@FXML
	private Button end;
	
	void init(Controller controller) {// Initialisiert den Controller
		main = controller;
	}
	
	void initData(Filmstart film, ArrayList<Kunde>kundenListe) {// Initialisiert die Scene durch Übergabe der Daten
		this.film = film;
		res = new Reservierung(film, kundenListe);
		res.speicherReservierung();
		reservierung.setText(res.getReservierungsInformationen());
	}
	
	void zurSitzplatzAuswahl(ActionEvent e) { // Bei Auswahl wird die Sitzplatzauswahl aufgerufen
		main.loadSitzplatzAuswahl((Button) e.getSource(), film);
		main.removeAllItems();
	}
	
	@FXML
	private void speicherPDF(ActionEvent e) { // Speichert Rechnung als PDF an gewünschten Ort ab

		Alert alert = new Alert (AlertType.INFORMATION, "Sie können nun das Programm beenden. Bitte drücken Sie Ihre Reservierung aus und zeigen Sie diese an Kasse vor.");
		alert.showAndWait();
		back.setVisible(false);
		end.setVisible(true);
		
		FileChooser fc = new FileChooser();
		fc.setTitle("Wählen Sie Ihren Speicherort für Ihre Rechnung");
		fc.setInitialFileName("Rechnung");
		fc.getExtensionFilters().addAll(
				new FileChooser.ExtensionFilter("PDF","*.pdf" ));
		fc.setInitialDirectory(new File(System.getProperty("user.home")));
		File file = fc.showSaveDialog(ReservierungPane.getScene().getWindow());
		System.out.println(file.getAbsolutePath());
        if (file != null) {
            res.speichereInPDF(file);
            main.speichereAlleSitzplaetze();
        }
	}
	
	@FXML
	private void beenden(ActionEvent e) { // Schließt das Programm
		System.exit(0);
	}

}
