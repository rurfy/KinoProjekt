package GUI;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ControllerSitzplatzauswahl extends MainController implements Initializable{


	private final String STARTBILDSCHIRM = "StartBildschirm.fxml";
	private final String FILMINFO = "FilmInfo.fxml";
	
	@FXML
	private Button sitzPlatzZurueck;
	
	@FXML
	private Pane sitzplaetze;
	
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
	
	public void initData() {
		generiereSitzplaetze(10, 10);
	}
	
	public void generiereSitzplaetze(int reihe, int spalte) {
		Button[][] platz = new Button[reihe][spalte];
		Stage primaryStage = (Stage) sitzPlatzZurueck.getScene().getWindow();
		
		
		for(int i = 0; i<reihe; i++ ) {
			for(int j = 0; j<spalte; j++) {
			
				platz[i][j] = new Button();
				platz[i][j].setPrefSize(30,30);
				platz[i][j].setMinSize(30,30);
				platz[i][j].setMaxSize(30, 30);
				platz[i][j].setLayoutY(100+i*35);
				platz[i][j].setLayoutX(100+j*35);
				sitzplaetze.getChildren().add(platz[i][j]);
			}
			
		}
		primaryStage.show();
	}
	
}
