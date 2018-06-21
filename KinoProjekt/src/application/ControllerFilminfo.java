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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class ControllerFilminfo implements Initializable{
	

	private final String STARTBILDSCHIRM = "StartBildschirm.fxml";
	private final String FILMINFO = "FilmInfo.fxml";
	private final String SITZPLATZAUSWAHL = "SitzplatzAuswahl.fxml";
	
	@FXML
	Button filmInfoZurueck;
	@FXML
	Label filmTitel1;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	@FXML
	public void backToStartbildschirm(ActionEvent e) {
		Stage primaryStage = (Stage) filmInfoZurueck.getScene().getWindow();
		try {
			Parent root = FXMLLoader.load(getClass().getResource(STARTBILDSCHIRM));
			root.getStylesheets().add(getClass().getResource("FilmInfo.css").toExternalForm());
			primaryStage.setScene(new Scene(root));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	@FXML
	public void zurSitzplatzAuswahl(ActionEvent e) {
		Stage primaryStage = (Stage) filmInfoZurueck.getScene().getWindow();
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
