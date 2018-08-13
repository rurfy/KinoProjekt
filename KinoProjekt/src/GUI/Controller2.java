package GUI;

import java.io.File;
import java.text.DecimalFormat;

import Default.Film;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class Controller2 {
	
	private Controller main;
	
	@FXML public AnchorPane FilmInfoPane;
	//Elemente der Scene
	@FXML private Label dauer;
	@FXML private Label fsk;
	@FXML private Label titel;
	@FXML private Label genre;
	@FXML private ImageView bild;
	
	
	public void init(Controller controller) {
		
		main = controller;
		
	}
	
	public void getData(Film film) {
		System.out.println(film.getTitel());
		//Daten vom ausgewählten Film laden
		DecimalFormat df = new DecimalFormat("#.00");
		dauer.setText("Dauer: " + df.format(film.getDauer()) + " h");
		titel.setText("Titel: " + film.getTitel());
		fsk.setText("FSK: " + Integer.toString(film.getFsk()));
		File file = new File("@" + film.getBildURL());
		bild.setImage(new Image(file.toURI().toString()));
		genre.setText("Genre: " + film.getGenre());
	}
	
	public void zurSitzplatzAuswahl(ActionEvent e) {
		main.loadSitzplatzAuswahl((Button) e.getSource());
	}
	
	public void zumStartBildschirm(ActionEvent e) {
		main.loadStartBildschirm((Button) e.getSource());
	}
}
