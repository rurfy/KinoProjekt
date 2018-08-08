package GUI;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class ControllerSitzplatzauswahl extends MainController implements Initializable{


	private final String STARTBILDSCHIRM = "StartBildschirm.fxml";
	private final String FILMINFO = "FilmInfo.fxml";
	
	@FXML
	private Button sitzPlatzZurueck;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

	@FXML
	public void zurSitzplatzAuswahl(ActionEvent e) {
		//setNewScene(SITZPLATZAUSWAHL, filmInfoZurueck);
	}

//	@Override
//	public void zurFilmInfo(ActionEvent e) {
//		// TODO Auto-generated method stub
//		setNewScene(FILMINFO, sitzPlatzZurueck);
//	}

	@Override
	public void zumStartBildschirm(ActionEvent e) {
		// TODO Auto-generated method stub
		setNewScene(STARTBILDSCHIRM, sitzPlatzZurueck);
	}

	@Override
	public void zurFilmInfo(MouseEvent e) {
		// TODO Auto-generated method stub
		setNewScene(FILMINFO, sitzPlatzZurueck);
	}
}
