package GUI;

import java.awt.Point;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import Default.Filmstart;
import Default.Kunde;
import Platztypen.Komfort;
import Platztypen.Loge;
import Platztypen.Parkett;
import Platztypen.Sitzplatz;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Controller3 {

	private Controller main;
	// Elemente der Scene
	@FXML
	private AnchorPane SitzplatzAuswahlPane;

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
	@FXML
	private ImageView saalBackground;

	private ArrayList<Kunde> kundenListe = new ArrayList<Kunde>();
	private Filmstart film;
	private File belegung;
	private List<Point> belegtePlaetze;

	void init(Controller controller) { // Initialisiert den Controller
		main = controller;
	}

	void initData(Filmstart film) { // Initialisiert die Scene durch Übergabe der Daten

		Stage stage = (Stage) getSitzplatzAuswahlPane().getScene().getWindow();
		stage.setWidth(getSitzplatzAuswahlPane().getWidth() + 20);
		stage.setHeight(getSitzplatzAuswahlPane().getHeight() + 40);
		sitzplaetze.getChildren().clear();
		this.film = film;
		filmName.setText(film.getTitel());
		uhrzeit.setText(film.getDate().getTime().toString());
		tag.setText(film.getDate().getTag());
		saal.setText("Saal " + film.getDate().getSaal().getSaalnummer());
		File file = new File("@" + film.getDate().getSaal().getBackgroundURL());
		saalBackground.setImage(new Image(file.toURI().toString()));
		sitzplaetze.getChildren().add(saalBackground);
		belegung = new File("../SitzplatzBelegungen/belegung" + film.getTitel() + film.getDate().getWochenTag() + film.getDate().getTime() + ".kos");
		belegtePlaetze = getBelegtePlaetze();
		generiereSitzplaetze(12, 22);
	}

	@FXML
	private void zumStartBildschirm(ActionEvent e) { // Bei Auswahl wird der StartBildschirm aufgerufen
		removeAllItems();
		main.loadStartBildschirm();
	}

	private EventHandler<ActionEvent> buttonClick = new EventHandler<ActionEvent>() { // Handlet die Auswahl eines Sitzplatzes
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
			}
		}
	};

	private void generiereSitzplaetze(int reihe, int spalte) { // Generiert alle Sitzplätze

		for (int i = 0; i < reihe; i++) {
			for (int j = 0; j < spalte; j++) {
				if (i < film.getDate().getSaal().getReihenPakett()) {
					Parkett pakettplatz = new Parkett();
					if (!isBelegt(i, j, belegtePlaetze)) {
						pakettplatz.addEventHandler(ActionEvent.ACTION, buttonClick);
					} else {
						pakettplatz.getStyleClass().removeAll("onClick");
						pakettplatz.getStyleClass().add("clicked");
						pakettplatz.setBelegt(true);
					}
					pakettplatz.erstelleSitzplatz(i, j, sitzplaetze);
				} else if (i >= film.getDate().getSaal().getReihenPakett() && i < (film.getDate().getSaal().getReihenPakett() + film.getDate().getSaal().getReihenLoge())) {
					Loge logenplatz = new Loge();
					if (!isBelegt(i, j, belegtePlaetze)) {
						logenplatz.addEventHandler(ActionEvent.ACTION, buttonClick);
					} else {
						logenplatz.getStyleClass().removeAll("onClick");
						logenplatz.getStyleClass().add("clicked");
						logenplatz.setBelegt(true);
					}
					logenplatz.erstelleSitzplatz(i, j, sitzplaetze);
				} else {
					Komfort komfortplatz = new Komfort();
					if (!isBelegt(i, j, belegtePlaetze)) {
						komfortplatz.addEventHandler(ActionEvent.ACTION, buttonClick);
					} else {
						komfortplatz.getStyleClass().removeAll("onClick");
						komfortplatz.getStyleClass().add("clicked");
						komfortplatz.setBelegt(true);
					}
					komfortplatz.erstelleSitzplatz(i, j, sitzplaetze);
				}
			}

		}

	}

	private List<Point> getBelegtePlaetze() { // Lädt alle bereits belegten Plätze in eine List
		if (belegung.exists()) {
			try {
				FileInputStream fis = new FileInputStream(belegung);
				ObjectInputStream ois = new ObjectInputStream(fis);
				LocalDate date = (LocalDate) ois.readObject();
				if (date.isBefore(LocalDate.now()) ) {
					belegung.delete();
					ois.close();
					fis.close();
					return null;
				}
				int size = ois.readInt();
				List<Point> list = new ArrayList<Point>();
				for (int i = 0; i < size; i++) {
					list.add((Point) ois.readObject());
				}
				ois.close();
				fis.close();
				return list;
			} catch (IOException | ClassNotFoundException e) {
				e.printStackTrace();
				return null;
			}
		}
		return null;

	}

	private Boolean isBelegt(int zeile, int spalte, List<Point> list) { // Überprüft ob ein Platz an einer Position belegt ist
		if (list != null) {
			for (int i = 0; i < list.size(); i++) {
				if ((int) list.get(i).getX() == zeile && (int) list.get(i).getY() == spalte) {
					return true;
				}
			}
		}
		return false;
	}

	void speichereSitzplatzDaten() { // Speichert die ausgewählten Plätze und bereits belegte ab
		FileOutputStream fos;
		if (!belegung.exists()) {
			try {
				belegung.createNewFile();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		try {
			fos = new FileOutputStream(belegung, false);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(film.getDate().getDate());
			if (belegtePlaetze != null) {
				int size = kundenListe.size() + belegtePlaetze.size();
				oos.writeInt(size);
				for (int i = 0; i < belegtePlaetze.size(); i++) {
					oos.writeObject(belegtePlaetze.get(i));
				}
			}
			else {
				oos.writeInt(kundenListe.size());
			}
			for (int i = 0; i < kundenListe.size(); i++) {
				oos.writeObject(kundenListe.get(i).getPlatz().getPlatzierung());
			}
			oos.close();
			fos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private Boolean setComboBoxValues() { // Passt die Werte der Kunden, je nach Auswahl in der ComboBox an
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

	@FXML
	private void zurReservierung(ActionEvent e) { // Bei Auswahl werden Sitzplätze gespeichert und die Reservierung wird
													// aufgerufen

		if (!kundenListe.isEmpty()) {
			if (setComboBoxValues()) {
				main.loadReservierung(film, kundenListe);
			}
		} else {
			Alert alert = new Alert(AlertType.WARNING, "Sie haben keine Sitzplätze ausgewählt");
			alert.showAndWait();
		}
	}

	void removeAllItems() { // Entfernt alle ausgewählten Elemente aus der Liste
		for (int i = kundenListe.size() - 1; i >= 0; i--) {
			kundenListe.get(i).getPlatz().getStyleClass().removeAll("clicked");
			kundenListe.get(i).getPlatz().getStyleClass().add("onClick");
			kundenListe.get(i).getPlatz().setBelegt(false);
			kundenListe.get(i).removeComboBox(comboContainer);
			kundenListe.remove(i);
		}
	}

	@FXML
	private void auswahlZurueck(ActionEvent e) { // Bei Auswahl wird removeAllItems() aufgerufen
		removeAllItems();
	}

	AnchorPane getSitzplatzAuswahlPane() {
		return SitzplatzAuswahlPane;
	}

	void setSitzplatzAuswahlPane(AnchorPane sitzplatzAuswahlPane) {
		SitzplatzAuswahlPane = sitzplatzAuswahlPane;
	}

}
