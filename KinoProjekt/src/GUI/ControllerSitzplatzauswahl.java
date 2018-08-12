package GUI;

import java.net.URL;
import java.util.ResourceBundle;

import com.sun.prism.paint.Color;

import Platztypen.Sitzplatz;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ControllerSitzplatzauswahl extends MainController implements Initializable {

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
		// setNewScene(SITZPLATZAUSWAHL, filmInfoZurueck);
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
		generiereSitzplaetze(12, 22);
	}

	public void generiereSitzplaetze(int reihe, int spalte) {
		Sitzplatz platz = new Sitzplatz();
		Stage primaryStage = (Stage) sitzPlatzZurueck.getScene().getWindow();
//		int abstand = 30;			

		
		for (int i = 0; i < reihe; i++) {
			
//			if (i == 4) {
//				abstand = abstand + 25;
//			} else if (i == 8) {
//				abstand = abstand + 30;
//			}
			for (int j = 0; j < spalte; j++) {
				System.out.println(i+" "+j);
				platz.erstelleSitzplatz(i,j, primaryStage);
//				platz[i][j] = new Button();
//				platz[i][j].setPrefSize(25, 25);
//				platz[i][j].setMinSize(25, 25);
//				platz[i][j].setMaxSize(25, 25);

//				platz[i][j].setLayoutY(52 + i * 30 + abstand);
//				platz[i][j].setLayoutX(130 + j * 30);
//				platz[i][j].setId("Reihe: "+i+", Platz: "+j);
//				platz[i][j].getStyleClass().removeAll("button");
//				platz[i][j].getStyleClass().add("onClick");
//				platz[i][j].setOnAction(new EventHandler<ActionEvent>(){
//					
//					@Override
//					public void handle(ActionEvent e) {
//						Button x = (Button) e.getSource();
//						if(x.getStyleClass().get(0)=="clicked") {
//							x.getStyleClass().removeAll("clicked");
//							x.getStyleClass().add("onClick");
//						}else {
//							x.getStyleClass().removeAll("onClick");
//							x.getStyleClass().add("clicked");
//						}
//					}
//					
//				});
//				sitzplaetze.getChildren().add(platz[i][j]);
			}

		}
//		primaryStage.show();
	}

}
