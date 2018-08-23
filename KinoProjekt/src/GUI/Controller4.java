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
import javafx.stage.Stage;

public class Controller4 {
	
	private Filmstart film;
	private Controller main;
	private Reservierung res;
	
	// Elemente der Scene
	@FXML
	private AnchorPane ReservierungPane;

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
		Stage stage = (Stage) getReservierungPane().getScene().getWindow();
		stage.setWidth(getReservierungPane().getWidth() + 20);
		stage.setHeight(getReservierungPane().getWidth() + 40);
		this.film = film;
		res = new Reservierung(film, kundenListe);
		res.speicherReservierung();
		reservierung.setText(res.getReservierungsInformationen());
	}
	
	public void zurSitzplatzAuswahl(ActionEvent e) { // Bei Auswahl wird die Sitzplatzauswahl aufgerufen
		main.loadSitzplatzAuswahl(film);
		main.removeAllItems();
	}
	
	@FXML
	private void speicherPDF(ActionEvent e) { // Speichert Rechnung als PDF an gew�nschten Ort ab

		back.setVisible(false);
		end.setVisible(true);
		
		FileChooser fc = new FileChooser();
		fc.setTitle("W�hlen Sie Ihren Speicherort f�r Ihre Rechnung");
		fc.setInitialFileName("Rechnung");
		fc.getExtensionFilters().addAll(
				new FileChooser.ExtensionFilter("PDF","*.pdf" ));
		fc.setInitialDirectory(new File(System.getProperty("user.home")+"\\Documents"));
		File file = fc.showSaveDialog(ReservierungPane.getScene().getWindow());
		System.out.println(file.getAbsolutePath());
        if (file != null) {
            res.speichereInPDF(file);
            main.speichereAlleSitzplaetze();
        }
	}
	
	public void beenden() { // Schlie�t das Programm
		System.exit(0);
	}
	
	public AnchorPane getReservierungPane() {
		return ReservierungPane;
	}

	public void setReservierungPane(AnchorPane reservierungPane) {
		ReservierungPane = reservierungPane;
	}

}
