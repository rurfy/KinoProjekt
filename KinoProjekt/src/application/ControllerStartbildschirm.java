package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class ControllerStartbildschirm implements Initializable{

	
	private final String STARTBILDSCHIRM = "StartBildschirm.fxml";
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
		Stage primaryStage = (Stage) filmTitel1.getScene().getWindow();
		try {
			Parent root = FXMLLoader.load(getClass().getResource(FILMINFO));
			root.getStylesheets().add(getClass().getResource("FilmInfo.css").toExternalForm());
			primaryStage.setScene(new Scene(root));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	@FXML
	public void zurSitzplatzAuswahl(ActionEvent e) {
		Stage primaryStage = (Stage) filmTitel1.getScene().getWindow();
		try {
			Parent root = FXMLLoader.load(getClass().getResource(SITZPLATZAUSWAHL));
			root.getStylesheets().add(getClass().getResource("FilmInfo.css").toExternalForm());
			primaryStage.setScene(new Scene(root));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

}
