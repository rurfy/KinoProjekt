package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class Main extends Application {
	
	private final String STARTBILDSCHIRM = "StartBildschirm.fxml";
	
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource(STARTBILDSCHIRM));
			Scene startBildschirm = new Scene(root);
			startBildschirm.getStylesheets().add(getClass().getResource("FilmInfo.css").toExternalForm());
			primaryStage.setScene(startBildschirm);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
