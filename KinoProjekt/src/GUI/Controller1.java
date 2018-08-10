package GUI;

import java.net.URL;
import java.util.ResourceBundle;

import Default.Film;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class Controller1 implements Initializable {

	private Controller main;
	
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
	
	public void init(Controller controller) {
		// TODO Auto-generated method stub
		main = controller;
	}
	
	@FXML
	public void zurFilmInfo(MouseEvent e) {
		System.out.println(main.filme.get(0).getTitel());
		for (int i = 0; i<main.filme.size(); i++) {
			if (getFilmID(e).equals(main.filme.get(i).getTitel())) {
				Film film = main.filme.get(i);
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
		
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}
