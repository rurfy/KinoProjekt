package GUI;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class ControllerStartbildschirm extends MainController implements Initializable{

	
	private final String FILMINFO = "FilmInfo.fxml";
	private final String SITZPLATZAUSWAHL = "SitzplatzAuswahl.fxml";
	
	@FXML
	private Label filmTitel1;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	@FXML
	public void zurFilmInfo(MouseEvent e) {
		setNewScene(FILMINFO, filmTitel1);
	}
	
	@FXML
	public void zurSitzplatzAuswahl(ActionEvent e) {
		setNewScene(SITZPLATZAUSWAHL, filmTitel1);
	}
	
	@Override
	public void zurFilmInfo(ActionEvent e) {
		// TODO Auto-generated method stub
		setNewScene(FILMINFO, filmTitel1);
		
	}
	
	@Override
	public void zumStartBildschirm(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}


}
