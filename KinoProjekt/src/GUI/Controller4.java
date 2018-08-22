package GUI;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
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
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;

public class Controller4 {
	
	private Filmstart film;
	private Controller main;
	private String info;
	
	@FXML
	public AnchorPane ReservierungPane;
	@FXML
	private Label reservierung;
	@FXML
	private Button back;
	@FXML
	private Button end;
	
	public void init(Controller controller) {
		main = controller;
	}
	
	public void initData(Filmstart film, ArrayList<Kunde>kundenListe) {
		this.film = film;
		Reservierung res = new Reservierung(film, kundenListe);
		res.speicherReservierung();
		info = res.getReservierungsInformationen();
		reservierung.setText(info);
	}
	
	public void zurSitzplatzAuswahl(ActionEvent e) {
		main.loadSitzplatzAuswahl((Button) e.getSource(), film);
	}
	
	public void speicherPDF() {
		System.out.println("Button funktioniert");
		Alert alert = new Alert (AlertType.INFORMATION, "Sie können nun das Programm beenden. Bitte drücken Sie Ihre Reservierung aus und zeigen Sie diese an Kasse vor.");
		alert.showAndWait();
		back.setVisible(false);
		end.setVisible(true);
		
		File f = new File("test.xml");
		if(!f.exists()) {
			try {
				f.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try {
			FileOutputStream fos = new FileOutputStream(f);
			fos.write(info.getBytes());
			fos.close();
			FileChooser fc = new FileChooser();
			fc.setTitle("Wählen Sie Ihren Speicherort für Ihre Rechnung");
			fc.setInitialFileName("Rechnung");
			fc.getExtensionFilters().addAll(
					new FileChooser.ExtensionFilter("PDF","*.pdf" ));
			File file = fc.showSaveDialog(ReservierungPane.getScene().getWindow());
			System.out.println(file.getAbsolutePath());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void beenden() {
		System.exit(0);
	}

}
