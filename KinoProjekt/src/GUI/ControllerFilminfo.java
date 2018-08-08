package GUI;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;

public class ControllerFilminfo extends MainController implements Initializable{
	

	private final String STARTBILDSCHIRM = "StartBildschirm.fxml";
	private final String SITZPLATZAUSWAHL = "SitzplatzAuswahl.fxml";
	
	@FXML
	private Button filmInfoZurueck;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	
	@FXML
	public void zurSitzplatzAuswahl(ActionEvent e) {
		setNewScene(SITZPLATZAUSWAHL, filmInfoZurueck);
	}

//	@Override
//	public void zurFilmInfo(ActionEvent e) {
//		// TODO Auto-generated method stub
//		
//	}

	@FXML
	public void zumStartBildschirm(ActionEvent e) {
		setNewScene(STARTBILDSCHIRM, filmInfoZurueck);
	}

	@Override
	public void zurFilmInfo(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
