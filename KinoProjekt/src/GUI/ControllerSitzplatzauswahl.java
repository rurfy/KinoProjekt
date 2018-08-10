package GUI;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import Default.Film;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
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

	@Override
	public void setNewScene(String fxml, Node c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setStartController(FXMLLoader loader) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setFilmInfoController(FXMLLoader loader) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setSitzplatzController(FXMLLoader loader) {
		// TODO Auto-generated method stub
		
	}

//	@Override
	public void initData(String s, ArrayList<Film> filme) {
		// TODO Auto-generated method stub
		
	}
}
