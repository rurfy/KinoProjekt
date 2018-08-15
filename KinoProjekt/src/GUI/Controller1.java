package GUI;

import java.io.File;
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
import javafx.scene.layout.Pane;

public class Controller1 {

	private Controller main;
	
	@FXML public AnchorPane StartBildschirmPane;
	
	@FXML private Label filmTitel1;
	@FXML private Label filmTitel2;
	@FXML private Label filmTitel3;
	@FXML private Label filmTitel4;
	@FXML private Label filmTitel5;
	@FXML private Pane film1;
	@FXML private Pane film2;
	@FXML private Pane film3;
	@FXML private Pane film4;
	@FXML private Pane film5;
	
	@FXML private Button film1heute1;	
	@FXML private Button film1heute2;	
	@FXML private Button film1heute3;	
	@FXML private Button film2heute1;	
	@FXML private Button film2heute2;	
	@FXML private Button film2heute3;	
	@FXML private Button film3heute1;	
	@FXML private Button film3heute2;	
	@FXML private Button film3heute3;	
	@FXML private Button film4heute1;	
	@FXML private Button film4heute2;	
	@FXML private Button film4heute3;	
	@FXML private Button film5heute1;	
	@FXML private Button film5heute2;	
	@FXML private Button film5heute3;	
	@FXML private Button film1morgen1;	
	@FXML private Button film1morgen2;	
	@FXML private Button film1morgen3;	
	@FXML private Button film2morgen1;	
	@FXML private Button film2morgen2;	
	@FXML private Button film2morgen3;	
	@FXML private Button film3morgen1;	
	@FXML private Button film3morgen2;	
	@FXML private Button film3morgen3;	
	@FXML private Button film4morgen1;	
	@FXML private Button film4morgen2;	
	@FXML private Button film4morgen3;	
	@FXML private Button film5morgen1;	
	@FXML private Button film5morgen2;	
	@FXML private Button film5morgen3;	
	@FXML private Button film1uebermorgen1;
	@FXML private Button film1uebermorgen2;
	@FXML private Button film1uebermorgen3;
	@FXML private Button film2uebermorgen1;
	@FXML private Button film2uebermorgen2;
	@FXML private Button film2uebermorgen3;
	@FXML private Button film3uebermorgen1;
	@FXML private Button film3uebermorgen2;
	@FXML private Button film3uebermorgen3;
	@FXML private Button film4uebermorgen1;
	@FXML private Button film4uebermorgen2;
	@FXML private Button film4uebermorgen3;
	@FXML private Button film5uebermorgen1;
	@FXML private Button film5uebermorgen2;
	@FXML private Button film5uebermorgen3;
	
	@FXML private ImageView image1;
	@FXML private ImageView image2;
	@FXML private ImageView image3;
	@FXML private ImageView image4;
	@FXML private ImageView image5;

	//private Filmstart filmA;
	
	public void init(Controller controller, Filmstart film1, Filmstart film2, Filmstart film3, Filmstart film4, Filmstart film5) {
		main = controller;
		//film1heute1.setText(film1.getHeute().getUhrzeit1().getUhrzeit());
	}
	
	public void loadData() {
		Filmstart film = main.filme.get(1);
		File file = new File("@" + film.getBildURL());
		image1.setImage(new Image(file.toURI().toString()));
		filmTitel1.setText(film.getTitel());
		film1heute1.setText(film.getHeute().getUhrzeit1().getUhrzeit() + " Uhr");
		film1heute2.setText(film.getHeute().getUhrzeit2().getUhrzeit() + " Uhr");
		film1heute3.setText(film.getHeute().getUhrzeit3().getUhrzeit() + " Uhr");
		film1morgen1.setText(film.getMorgen().getUhrzeit1().getUhrzeit() + " Uhr");
		film1morgen2.setText(film.getMorgen().getUhrzeit2().getUhrzeit() + " Uhr");
		film1morgen3.setText(film.getMorgen().getUhrzeit3().getUhrzeit() + " Uhr");
		film1uebermorgen1.setText(film.getUebermorgen().getUhrzeit1().getUhrzeit() + " Uhr");
		film1uebermorgen2.setText(film.getUebermorgen().getUhrzeit2().getUhrzeit() + " Uhr");
		film1uebermorgen3.setText(film.getUebermorgen().getUhrzeit3().getUhrzeit() + " Uhr");
		for (int i = 0; i < main.filme.size(); i++) {
			
		}
	}
	
	@FXML
	public void zurFilmInfo(MouseEvent e) {
		
		for (int i = 0; i<main.filme.size(); i++) {
			if (getFilmID(e).equals(main.filme.get(i).getTitel())) {
				Filmstart film = main.filme.get(i);
				System.out.println(film.getTitel());
				main.loadFilmInfo((Pane) e.getSource(), film);
			}
		}
	}
	
	public String getFilmID (MouseEvent e) {
		Pane p = (Pane) e.getSource();
		switch (p.getId()) {
		case "film1":
			return filmTitel1.getText();
		case "film2":
			return filmTitel2.getText();
		case "film3":
			return filmTitel3.getText();
		case "film4":
			return filmTitel4.getText();
		case "film5":
			return filmTitel5.getText();

		default:
			return "Fehler";
		}
	}
	
	public void zurSitzplatzAuswahl(ActionEvent e) {
		main.loadSitzplatzAuswahl((Button) e.getSource());
	}

}
