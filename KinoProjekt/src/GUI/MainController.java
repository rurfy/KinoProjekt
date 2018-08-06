package GUI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Control;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public abstract class MainController implements Initializable{
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

	public abstract void zurSitzplatzAuswahl(ActionEvent e);
	
	public abstract void zurFilmInfo(ActionEvent e);
	
	public abstract void zumStartBildschirm(ActionEvent e);
	
	public abstract void zurFilmInfo(MouseEvent e);
	
	public void setNewScene(String fxml, Node c) {
		// TODO Auto-generated method stub
		Stage primaryStage = (Stage) c.getScene().getWindow();
		try {
			Parent root = FXMLLoader.load(getClass().getResource(fxml));
			root.getStylesheets().add(getClass().getResource("design.css").toExternalForm());
			primaryStage.setScene(new Scene(root));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	public void bilderAnzeigen (String fxml, Control c) {
		
	}
}
