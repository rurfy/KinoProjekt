package application;
	
import javax.swing.plaf.synth.SynthSeparatorUI;

import Default.Film;
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
			Parent root = FXMLLoader.load(getClass().getResource("/GUI/" + STARTBILDSCHIRM));	
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
		Uebermorgen um = new Uebermorgen();
		Morgen morgen = new Morgen();
		Heute heute = new Heute();
		Film film = new Film();
		String[] uhrzeit;
		uhrzeit = morgen.getUhrzeit();
		
		for (int i = 0; i< um.getUhrzeit().length; i++) {
			
			System.out.println(uhrzeit[i]);
		}
		//launch(args);
	}
}
