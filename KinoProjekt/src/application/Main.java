package application;
	
import java.io.File;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;

public class Main extends Application {

	private final String DESIGN = "design.css";
	
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/GUI/" + "Rahmen.fxml"));	
			Scene startBildschirm = new Scene(root);
			startBildschirm.getStylesheets().add(getClass().getResource("/GUI/" + DESIGN).toExternalForm());
			primaryStage.setScene(startBildschirm);
			File file = new File("@../../../Logo_v3.PNG");
			primaryStage.getIcons().add(new Image(file.toURI().toString()));
			primaryStage.setTitle("KiTOS - Kino Ticket Offline Service");
			
			primaryStage.setX(50);
			primaryStage.setY(0);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		Tests.testen();
		//Tests.starten();
		launch(args);
	}
}
