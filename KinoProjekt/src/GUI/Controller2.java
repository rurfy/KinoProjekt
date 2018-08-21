package GUI;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.DecimalFormat;
import java.util.ArrayList;

import Default.Film;
import Default.Filmstart;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class Controller2 {

	private Controller main;

	@FXML
	public AnchorPane FilmInfoPane;

	// Elemente der Scene
	@FXML
	private Label dauer;
	@FXML
	private Label fsk;
	@FXML
	private Label titel;
	@FXML
	private Label genre;
	@FXML
	private Label trailer;
	@FXML
	private Label grundpreis;
	@FXML
	private ImageView bild;
	@FXML
	Button uhrzeit1;
	@FXML
	Button uhrzeit2;
	@FXML
	Button uhrzeit3;
	@FXML
	Button uhrzeit4;
	@FXML
	Button uhrzeit5;
	@FXML
	Button uhrzeit6;
	@FXML
	Button uhrzeit7;
	@FXML
	Button uhrzeit8;
	@FXML
	Button uhrzeit9;

	private Film film;

	void init(Controller controller) { // Initialisiert den Controller

		main = controller;

	}

	void initData(Film film, ArrayList<Filmstart> filme) { // Lädt alle Daten in die Scene
		this.film = film;
		DecimalFormat df = new DecimalFormat("#.00");
		dauer.setText("Dauer: " + df.format(film.getDauer()) + " h");
		titel.setText("Titel: " + film.getTitel());
		fsk.setText("FSK: " + Integer.toString(film.getFsk()));
		File file = new File("@" + film.getBildURL());
		bild.setImage(new Image(file.toURI().toString()));
		genre.setText("Genre: " + film.getGenre());
		grundpreis.setText("Grundpreis: "+df.format(film.getPreis())+" €");
		trailer.getStyleClass().removeAll("label");
		trailer.getStyleClass().add("label2");
		trailer.setText(film.getTrailer());
		uhrzeit1.setText(filme.get(0).getDate().getTime() + " Uhr");
		uhrzeit1.setUserData(filme.get(0));
		uhrzeit2.setText(filme.get(1).getDate().getTime() + " Uhr");
		uhrzeit2.setUserData(filme.get(1));
		uhrzeit3.setText(filme.get(2).getDate().getTime() + " Uhr");
		uhrzeit3.setUserData(filme.get(2));
		uhrzeit4.setText(filme.get(3).getDate().getTime() + " Uhr");
		uhrzeit4.setUserData(filme.get(3));
		uhrzeit5.setText(filme.get(4).getDate().getTime() + " Uhr");
		uhrzeit5.setUserData(filme.get(4));
		uhrzeit6.setText(filme.get(5).getDate().getTime() + " Uhr");
		uhrzeit6.setUserData(filme.get(5));
		uhrzeit7.setText(filme.get(6).getDate().getTime() + " Uhr");
		uhrzeit7.setUserData(filme.get(6));
		uhrzeit8.setText(filme.get(7).getDate().getTime() + " Uhr");
		uhrzeit8.setUserData(filme.get(7));
		uhrzeit9.setText(filme.get(8).getDate().getTime() + " Uhr");
		uhrzeit9.setUserData(filme.get(8));
	}

	@FXML
	private void zurSitzplatzAuswahl(ActionEvent e) { // Bei Auswahl einer Uhrzeit zum nächsten Bildschirm weiterleiten
		Button b = (Button) e.getSource();
		main.loadSitzplatzAuswahl(b, (Filmstart) b.getUserData());
	}

	@FXML
	private void zumStartBildschirm(ActionEvent e) { // Bei Auswahl des "Zurück" Buttons zum vorherigen Bildschirm weiterleiten
		main.loadStartBildschirm((Button) e.getSource());
	}

	@FXML
	private void hyperlink(MouseEvent e) throws URISyntaxException { // Erzeugt aus dem TrailerString einen Hyperlink
		URI uri = new URI(film.getTrailer());
		if (e.getClickCount() > 0) {
			if (Desktop.isDesktopSupported()) {
				Desktop desktop = Desktop.getDesktop();
				try {
					desktop.browse(uri);
				} catch (IOException ex) {
					ex.printStackTrace();
				}
			}
		}
	}
}
