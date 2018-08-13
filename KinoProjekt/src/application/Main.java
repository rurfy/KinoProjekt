package application;
	
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.plaf.synth.SynthSeparatorUI;

import Default.Film;
import GUI.Controller;
import Tage.Heute;
import Tage.Morgen;
import Tage.Tage;
import Tage.Uebermorgen;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class Main extends Application {
	
	private final String STARTBILDSCHIRM = "StartBildschirm.fxml";
	private final String DESIGN = "design.css";
	
	@Override
	public void start(Stage primaryStage) {
		try {
			//Controller controller = new Controller();
			//controller.initialize();
			Parent root = FXMLLoader.load(getClass().getResource("/GUI/" + "Rahmen.fxml"));	
			Scene startBildschirm = new Scene(root);
			startBildschirm.getStylesheets().add(getClass().getResource("/GUI/" + DESIGN).toExternalForm());
			primaryStage.setScene(startBildschirm);
			
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
