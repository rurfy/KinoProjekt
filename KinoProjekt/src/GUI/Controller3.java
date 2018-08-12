package GUI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class Controller3 {

	private Controller main;
	
	@FXML public AnchorPane SitzplatzAuswahlPane;
	
	public void init(Controller controller) {
		// TODO Auto-generated method stub
		main = controller;
	}
	
	public void zumStartBildschirm(ActionEvent e) {
		main.loadStartBildschirm((Button) e.getSource());
	}
	
}
