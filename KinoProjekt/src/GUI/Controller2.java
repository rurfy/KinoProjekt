package GUI;

import java.io.File;
import java.text.DecimalFormat;

import Default.Filmstart;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TabPane;
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
	
	private Filmstart film;
	
	
	public void init(Controller controller) {
		
		main = controller;
		
	}
	
	public void initData(Filmstart film) {
		//Daten vom ausgewählten Film laden
		this.film = film;
		DecimalFormat df = new DecimalFormat("#.00");
		dauer.setText("Dauer: " + df.format(film.getDauer()) + " h");
		titel.setText("Titel: " + film.getTitel());
		fsk.setText("FSK: " + Integer.toString(film.getFsk()));
		File file = new File("@" + film.getBildURL());
		bild.setImage(new Image(file.toURI().toString()));
		genre.setText("Genre: " + film.getGenre());
	}
	
	public String getTabID(ActionEvent e) {
			Node n = (Node) e.getSource();
			while (!(n instanceof TabPane)) {
				n = n.getParent();
			}
			TabPane tab = (TabPane) n;
			
			return tab.getSelectionModel().getSelectedItem().getText();
	}
	
	public void zurSitzplatzAuswahl(ActionEvent e) {
		Button b = (Button) e.getSource();
		main.loadSitzplatzAuswahl((Button) e.getSource(), film, b.getText(), getTabID(e));
	}
	
	public void zumStartBildschirm(ActionEvent e) {
		main.loadStartBildschirm((Button) e.getSource());
	}
}
