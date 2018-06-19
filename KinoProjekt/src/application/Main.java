package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class Main extends Application {
	
	private final String STARTBILDSCHIRM = "StartBildschirm.fxml";
	private final String FILMINFO = "FilmInfo.fxml";
	private final String SITZPLATZAUSWAHL = "SitzplatzAuswahl.fxml";
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root1 = FXMLLoader.load(getClass().getResource(STARTBILDSCHIRM));
			Scene startBildschirm = new Scene(root1);
			Parent root2 = FXMLLoader.load(getClass().getResource(FILMINFO));
			Scene filmInfo = new Scene(root2);
			Parent root3 = FXMLLoader.load(getClass().getResource(SITZPLATZAUSWAHL));
			Scene sitzplatzAuswahl = new Scene(root3);
			startBildschirm.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(startBildschirm);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	//Kommentar
	public static void main(String[] args) {
		launch(args);
	}
}
