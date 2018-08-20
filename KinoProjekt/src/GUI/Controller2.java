package GUI;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class Controller2 {
	
	private Controller main;
	
	@FXML public AnchorPane FilmInfoPane;
	
	//Elemente der Scene
	@FXML private Label dauer;
	@FXML private Label fsk;
	@FXML private Label titel;
	@FXML private Label genre;
	@FXML private Label trailer;
	@FXML private Label grundpreis;
	@FXML private ImageView bild;
	@FXML Button uhrzeit1;
	@FXML Button uhrzeit2;
	@FXML Button uhrzeit3;
	@FXML Button uhrzeit4;
	@FXML Button uhrzeit5;
	@FXML Button uhrzeit6;
	@FXML Button uhrzeit7;
	@FXML Button uhrzeit8;
	@FXML Button uhrzeit9;
	
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
		trailer.getStyleClass().removeAll("label");
		trailer.getStyleClass().add("label2");
		trailer.setText(film.getTrailer());
		uhrzeit1.setText(film.getHeute().getUhrzeit1().getUhrzeit()+" Uhr");
		uhrzeit2.setText(film.getHeute().getUhrzeit2().getUhrzeit()+" Uhr");
		uhrzeit3.setText(film.getHeute().getUhrzeit3().getUhrzeit()+" Uhr");
		uhrzeit4.setText(film.getMorgen().getUhrzeit1().getUhrzeit()+" Uhr");
		uhrzeit5.setText(film.getMorgen().getUhrzeit2().getUhrzeit()+" Uhr");
		uhrzeit6.setText(film.getMorgen().getUhrzeit3().getUhrzeit()+" Uhr");
		uhrzeit7.setText(film.getUebermorgen().getUhrzeit1().getUhrzeit()+" Uhr");
		uhrzeit8.setText(film.getUebermorgen().getUhrzeit2().getUhrzeit()+" Uhr");
		uhrzeit9.setText(film.getUebermorgen().getUhrzeit3().getUhrzeit()+" Uhr");
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
	
	public void hyperlink(MouseEvent e) throws URISyntaxException {
		URI uri = new URI (film.getTrailer());
		if(e.getClickCount()>0) {
			if(Desktop.isDesktopSupported()) {
				Desktop desktop = Desktop.getDesktop();
				try {
					desktop.browse(uri);
				}catch (IOException ex) {
					ex.printStackTrace();
				}
			}
		}
	}
}
