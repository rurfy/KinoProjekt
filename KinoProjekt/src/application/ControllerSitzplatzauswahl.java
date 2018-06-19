package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class ControllerSitzplatzauswahl implements Initializable{


	private final String STARTBILDSCHIRM = "StartBildschirm.fxml";
	private final String FILMINFO = "FilmInfo.fxml";
	private final String SITZPLATZAUSWAHL = "SitzplatzAuswahl.fxml";
	
	@FXML
	Button filmInfoZurueck;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}
