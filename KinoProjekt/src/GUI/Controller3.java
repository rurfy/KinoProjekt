package GUI;

import java.awt.Point;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
	@FXML
	private ImageView saalBackground;

	private ArrayList<Kunde> kundenListe = new ArrayList<Kunde>();
	private Filmstart film;
	private File belegung;

	public void init(Controller controller) {
		main = controller;
		comboContainer.setFillWidth(true);
	}

	public void initData(Filmstart film) {

		sitzplaetze.getChildren().clear();
		this.film = film;
		filmName.setText(film.getTitel());
		uhrzeit.setText(film.getDate().getTime().toString());
		tag.setText(film.getDate().getTag());
		saal.setText("Saal " + film.getSaal().getSaalnummer());
		File file = new File("@" + film.getSaal().getBackgroundURL());
		saalBackground.setImage(new Image(file.toURI().toString()));
		sitzplaetze.getChildren().add(saalBackground);
		belegung = new File("belegung" + film.getTitel() + film.getDate().getTime() + film.getDate().getTag() + ".kos");
		generiereSitzplaetze(12, 22);
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
			}
		}
	};

	public void generiereSitzplaetze(int reihe, int spalte) {

		List<Point> belegtePlaetze = getBelegtePlaetze();
		for (int i = 0; i < reihe; i++) {
			for (int j = 0; j < spalte; j++) {
				if (i < film.getSaal().getReihenPakett()) {
					Parkett pakettplatz = new Parkett();
					if (!isBelegt(i, j, belegtePlaetze)) {
						pakettplatz.addEventHandler(ActionEvent.ACTION, buttonClick);
					} else {
						pakettplatz.getStyleClass().removeAll("onClick");
						pakettplatz.getStyleClass().add("clicked");
						pakettplatz.setBelegt(true);
					}
					pakettplatz.erstelleSitzplatz(i, j, sitzplaetze);
				} else if (i >= film.getSaal().getReihenPakett() && i < (film.getSaal().getReihenPakett() + film.getSaal().getReihenLoge())) {
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

	public List<Point> getBelegtePlaetze() {
		if (belegung.exists()) {
			try {
				FileInputStream fis = new FileInputStream(belegung);
				ObjectInputStream ois = new ObjectInputStream(fis);
				int size = ois.readInt();
				List<Point> list = new ArrayList<Point>();
				for (int i = 0; i < size; i++) {
					list.add((Point) ois.readObject());
				}
				ois.close();
				fis.close();
				return list;
			} catch (IOException | ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
		}
		return null;

	}

	public Boolean isBelegt(int zeile, int spalte, List<Point> list) {
		if (list != null) {
			for (int i = 0; i < list.size(); i++) {
				if ((int) list.get(i).getX() == zeile && (int) list.get(i).getY() == spalte) {
					return true;
				}
			}
		}
		return false;
	}

	public void speichereSitzplatzDaten() {
		FileOutputStream fos;
		if (!belegung.exists()) {
			try {
				belegung.createNewFile();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		try {
			fos = new FileOutputStream(belegung, true);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			List<Point> belegtePlaetze = getBelegtePlaetze();
			oos.writeInt(kundenListe.size());
			for (int i = 0; i < kundenListe.size(); i++) {
				oos.writeObject(kundenListe.get(i).getPlatz().getPlatzierung());
			}
			for (int i = 0; i < belegtePlaetze.size(); i++) {
				oos.writeObject(belegtePlaetze.get(i));
			}
			oos.close();
			fos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
				speichereSitzplatzDaten();
			}
		} else {
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
