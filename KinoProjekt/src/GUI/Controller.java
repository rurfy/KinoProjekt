package GUI;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import Default.Filmstart;
import Default.Saal;
import Platztypen.Sitzplatz;
import Tage.Heute;
import Tage.Morgen;
import Tage.Uebermorgen;
import Tage.Uhrzeit;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Controller {

	public final String STARTBILDSCHIRM = "StartBildschirm.fxml";
	public final String FILMINFO = "FilmInfo.fxml";
	public final String SITZPLATZAUSWAHL = "SitzplatzAuswahl.fxml";

	private File f = new File("filme.kos");

	public ArrayList<Filmstart> filme = new ArrayList<Filmstart>();

	@FXML
	private Controller1 tab1Controller;
	@FXML
	private Controller2 tab2Controller;
	@FXML
	private Controller3 tab3Controller;

	@FXML
	AnchorPane test;

	@FXML
	public void initialize() {

		System.out.println("App gestartet");

		safeFilme();

		initFilme();

		tab1Controller.init(this);
		tab2Controller.init(this);
		tab3Controller.init(this);
		loadStartBildschirm();

	}

	public void loadFilmInfo(Node n, Filmstart film) {
		tab1Controller.StartBildschirmPane.setVisible(false);
		tab2Controller.FilmInfoPane.setVisible(true);
		tab3Controller.SitzplatzAuswahlPane.setVisible(false);
		Stage stage = (Stage) n.getScene().getWindow();
		stage.setWidth(tab2Controller.FilmInfoPane.getWidth() + 20);
		stage.setHeight(tab2Controller.FilmInfoPane.getHeight() + 40);
		tab2Controller.initData(film);
	}

	public void loadStartBildschirm() {
		tab1Controller.StartBildschirmPane.setVisible(true);
		tab2Controller.FilmInfoPane.setVisible(false);
		tab3Controller.SitzplatzAuswahlPane.setVisible(false);
		tab1Controller.loadData();
	}

	public void loadStartBildschirm(Node n) {
		tab1Controller.StartBildschirmPane.setVisible(true);
		tab2Controller.FilmInfoPane.setVisible(false);
		tab3Controller.SitzplatzAuswahlPane.setVisible(false);
		tab1Controller.loadData();

		Stage stage = (Stage) n.getScene().getWindow();
		stage.setWidth(tab1Controller.StartBildschirmPane.getWidth() + 20);
		stage.setHeight(tab1Controller.StartBildschirmPane.getHeight() + 40);
	}

	public void loadSitzplatzAuswahl(Node n, Filmstart film, String uhrzeit, String tag) {
		tab1Controller.StartBildschirmPane.setVisible(false);
		tab2Controller.FilmInfoPane.setVisible(false);
		tab3Controller.SitzplatzAuswahlPane.setVisible(true);
		tab3Controller.initData(film, uhrzeit, tag);
		tab3Controller.generiereSitzplaetze(12, 22);
		Stage stage = (Stage) n.getScene().getWindow();
		stage.setWidth(tab3Controller.SitzplatzAuswahlPane.getWidth() + 20);
		stage.setHeight(tab3Controller.SitzplatzAuswahlPane.getHeight() + 40);
	}

	public void initFilme() {
		try {
			FileInputStream fis = new FileInputStream(f);
			ObjectInputStream in = new ObjectInputStream(fis);
			Filmstart film = (Filmstart) in.readObject();
			filme.add(film);
			Filmstart film1 = (Filmstart) in.readObject();
			filme.add(film1);
			Filmstart film2 = (Filmstart) in.readObject();
			filme.add(film2);
			Filmstart film3 = (Filmstart) in.readObject();
			filme.add(film3);
			Filmstart film4 = (Filmstart) in.readObject();
			filme.add(film4);
			in.close();
			fis.close();
		} catch (IOException | ClassNotFoundException e1) {

			e1.printStackTrace();
		}
	}
	
	public void safeFilme() {
		if (!f.exists()) {
			try {
				f.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
			FileOutputStream fs;
			
			Saal saal1 = new Saal(1, new Sitzplatz[12][22], 0, 0);
			Saal saal2 = new Saal(2, new Sitzplatz[12][22], 0, 0);
			
			Filmstart avatar = new Filmstart(2.42, "Avatar - Aufbruch nach Pandorra", 12, "Action und Fantasy", "https://www.youtube.com/watch?v=EzETGqZN6dU", "../../../avatar_thumb.jpg", 10, new Heute(
					new Uhrzeit("13.00", saal1), new Uhrzeit("15.00", saal2), new Uhrzeit("17.00", saal1)), new Morgen(new Uhrzeit("14.00", saal1), new Uhrzeit("16.00", saal2), new Uhrzeit("18.00",
							saal1)), new Uebermorgen(new Uhrzeit("15.00", saal1), new Uhrzeit("17.00", saal2), new Uhrzeit("19.00", saal1)));
			Filmstart jurassic = new Filmstart(2.10, "Jurassic World", 12, "Action und Science-Fiction", "https://www.youtube.com/watch?v=QvGzqDgkJQc", "../../../jurassic-world.jpg", 7.50, new Heute(
					new Uhrzeit("13.00", saal1), new Uhrzeit("15.00", saal2), new Uhrzeit("17.00", saal1)), new Morgen(new Uhrzeit("14.00", saal1), new Uhrzeit("16.00", saal2), new Uhrzeit("18.00",
							saal1)), new Uebermorgen(new Uhrzeit("15.00", saal1), new Uhrzeit("17.00", saal2), new Uhrzeit("19.00", saal1)));
			Filmstart fiftyShades = new Filmstart(2.05, "Fifty Shades of Grey - Geheimes Verlangen", 16, "Liebesfilm und Drama", "https://www.youtube.com/watch?v=H1r_SFh8in0",
					"../../../fifty-shades-of-grey_thumb.jpg", 9, new Heute(new Uhrzeit("13.00", saal1), new Uhrzeit("15.00", saal2), new Uhrzeit("17.00", saal1)), new Morgen(new Uhrzeit("14.00", saal1),
							new Uhrzeit("16.00", saal2), new Uhrzeit("18.00", saal1)), new Uebermorgen(new Uhrzeit("15.00", saal1), new Uhrzeit("17.00", saal2), new Uhrzeit("19.00", saal1)));
			Filmstart nemo = new Filmstart(1.40, "Findet Nemo", 0, "Animation und Kinder/Familie", "https://www.youtube.com/watch?v=9F-TxJt0HMA", "../../../findet-nemo_thumb.jpg", 8.50, new Heute(
					new Uhrzeit("13.00", saal1), new Uhrzeit("15.00", saal2), new Uhrzeit("17.00", saal1)), new Morgen(new Uhrzeit("14.00", saal1), new Uhrzeit("16.00", saal2), new Uhrzeit("18.00",
							saal1)), new Uebermorgen(new Uhrzeit("15.00", saal1), new Uhrzeit("17.00", saal2), new Uhrzeit("19.00", saal1)));
			Filmstart freunde = new Filmstart(1.53, "Ziemlich beste Freunde", 6, "Komödie und Drama", "https://www.youtube.com/watch?v=MYqzxrqY98E", "../../../ziemlich-beste-freunde_thumb.jpg", 8,
					new Heute(new Uhrzeit("13.00", saal1), new Uhrzeit("15.00", saal2), new Uhrzeit("17.00", saal1)), new Morgen(new Uhrzeit("14.00", saal1), new Uhrzeit("16.00", saal2), new Uhrzeit(
							"18.00", saal1)), new Uebermorgen(new Uhrzeit("15.00", saal1), new Uhrzeit("17.00", saal2), new Uhrzeit("19.00", saal1)));
			
			try {
				fs = new FileOutputStream(f, true);
				ObjectOutputStream out = new ObjectOutputStream(fs);
				avatar.writeFilm(f, out);
				jurassic.writeFilm(f, out);
				fiftyShades.writeFilm(f, out);
				nemo.writeFilm(f, out);
				freunde.writeFilm(f, out);
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
