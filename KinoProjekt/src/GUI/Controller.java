package GUI;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import Default.Film;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Controller {

	public final String STARTBILDSCHIRM = "StartBildschirm.fxml";
	public final String FILMINFO = "FilmInfo.fxml";
	public final String SITZPLATZAUSWAHL = "SitzplatzAuswahl.fxml";

	public ArrayList<Film> filme = new ArrayList<Film>();

	@FXML private Controller1 tab1Controller; //= new Controller1();
	@FXML private Controller2 tab2Controller;
	@FXML private Controller3 tab3Controller;
	
	@FXML AnchorPane test;

	@FXML
	public void initialize() {

		System.out.println("App gestartet");
		File f = new File("filme.kos");
		if (!f.exists()) { // Nur wenn die Datei noch nicht erstellt wurde
			try {
				f.createNewFile();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			Film avatar = new Film(2.42, "Avatar - Aufbruch nach Pandorra", 12, "Action und Fantasy", "https://www.youtube.com/watch?v=EzETGqZN6dU", "../../../avatar_thumb.jpg", 10);
			Film jurassic = new Film(2.10, "Jurassic World", 12, "Action und Science-Fiction", "https://www.youtube.com/watch?v=QvGzqDgkJQc", "../../../jurassic-world.jpg", 7.50);
			Film fiftyShades = new Film(2.05, "Fifty Shades of Grey - Geheimes Verlangen", 16, "Liebesfilm und Drama", "https://www.youtube.com/watch?v=H1r_SFh8in0",
					"../../../fifty-shades-of-grey_thumb.jpg", 9);
			Film nemo = new Film(1.40, "Findet Nemo", 0, "Animation und Kinder/Familie", "https://www.youtube.com/watch?v=9F-TxJt0HMA", "../../../findet-nemo_thumb.jpg", 8.50);
			Film freunde = new Film(1.53, "Ziemlich beste Freunde", 6, "Komödie und Drama", "https://www.youtube.com/watch?v=MYqzxrqY98E", "../../../ziemlich-beste-freunde_thumb.jpg", 8);

			try {
				FileOutputStream fs = new FileOutputStream("filme.kos");
				ObjectOutputStream out = new ObjectOutputStream(fs);
				out.writeObject(avatar);
				out.writeObject(nemo);
				out.writeObject(freunde);
				out.writeObject(jurassic);
				out.writeObject(fiftyShades);
				out.close();
			} catch (IOException e) {
				System.out.println("Datei konnte nicht gefunden werden.");
			}
		}

		try {
			FileInputStream fis = new FileInputStream("filme.kos");
			ObjectInputStream in = new ObjectInputStream(fis);
			Film filmA = (Film) in.readObject();
			filme.add(filmA);
			Film filmB = (Film) in.readObject();
			filme.add(filmB);
			Film filmC = (Film) in.readObject();
			filme.add(filmC);
			Film filmD = (Film) in.readObject();
			filme.add(filmD);
			Film filmE = (Film) in.readObject();
			filme.add(filmE);
			System.out.println(filmE.getTitel());
			in.close();
		} catch (IOException | ClassNotFoundException e1) {

			// TODO: handle exception
		}

		tab1Controller.init(this);
		tab2Controller.FilmInfoPane.setVisible(false);
		tab3Controller.SitzplatzAuswahlPane.setVisible(false);
		tab2Controller.init(this);
		tab3Controller.init(this);
		
	}

	public void loadFilmInfo(Node n, Film film) {

		//setNewScene(FILMINFO, n);
		//tab2Controller.init(this);
		tab1Controller.StartBildschirmPane.setVisible(false);
		tab2Controller.FilmInfoPane.setVisible(true);
		tab3Controller.SitzplatzAuswahlPane.setVisible(false);
		Stage stage = (Stage) n.getScene().getWindow();
		stage.setWidth(tab2Controller.FilmInfoPane.getWidth() + 20);
		stage.setHeight(tab2Controller.FilmInfoPane.getHeight() + 40);
		tab2Controller.getData(film);
	}

	public void loadStartBildschirm(Node n) {
		tab1Controller.StartBildschirmPane.setVisible(true);
		tab2Controller.FilmInfoPane.setVisible(false);
		tab3Controller.SitzplatzAuswahlPane.setVisible(false);

		Stage stage = (Stage) n.getScene().getWindow();
		stage.setWidth(tab1Controller.StartBildschirmPane.getWidth() + 20);
		stage.setHeight(tab1Controller.StartBildschirmPane.getHeight() + 40);
	}
	
	public void loadSitzplatzAuswahl(Node n) {
		tab1Controller.StartBildschirmPane.setVisible(false);
		tab2Controller.FilmInfoPane.setVisible(false);
		tab3Controller.SitzplatzAuswahlPane.setVisible(true);

		tab3Controller.generiereSitzplaetze(12, 22);
		Stage stage = (Stage) n.getScene().getWindow();
		stage.setWidth(tab3Controller.SitzplatzAuswahlPane.getWidth() + 20);
		stage.setHeight(tab3Controller.SitzplatzAuswahlPane.getHeight() + 40);
	}
	public void setNewScene(String fxml, Node n) {

		Stage primaryStage = (Stage) n.getScene().getWindow();
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
			Parent root = loader.load();
			root.getStylesheets().add(getClass().getResource("design.css").toExternalForm());
			primaryStage.setScene(new Scene(root));

			primaryStage.show();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

	}

	
}
