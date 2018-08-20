package GUI;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;

import Default.Film;
import Default.Filmstart;
import Default.Saal;
import Platztypen.Sitzplatz;
import Tage.Datum;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Controller {

	public final String STARTBILDSCHIRM = "StartBildschirm.fxml";
	public final String FILMINFO = "FilmInfo.fxml";
	public final String SITZPLATZAUSWAHL = "SitzplatzAuswahl.fxml";

	public ArrayList<Film> filme = new ArrayList<Film>();
	public ArrayList<Filmstart> film1 = new ArrayList<Filmstart>();
	public ArrayList<Filmstart> film2 = new ArrayList<Filmstart>();
	public ArrayList<Filmstart> film3 = new ArrayList<Filmstart>();
	public ArrayList<Filmstart> film4 = new ArrayList<Filmstart>();
	public ArrayList<Filmstart> film5 = new ArrayList<Filmstart>();
	

	@FXML
	private Controller1 tab1Controller;
	@FXML
	private Controller2 tab2Controller;
	@FXML
	private Controller3 tab3Controller;

	@FXML
	AnchorPane test;
	
	Saal saal1 = new Saal(1, new Sitzplatz[12][22], 4, 4, 4);
	Saal saal2 = new Saal(2, new Sitzplatz[12][22], 6, 4, 2);

	@FXML
	public void initialize() {

		System.out.println("App gestartet");
		LocalDate lastStart = Datum.readDate();
		if (lastStart.isEqual(LocalDate.now())) {
			System.out.println("Alles Safe");
		}
		else {
			System.out.println("Daten ändern");
		}

		alleFilmdatenSpeichern();
		alleFilmdatenAbrufen();

		tab1Controller.init(this);
		tab2Controller.init(this);
		tab3Controller.init(this);
		loadStartBildschirm();
		
		Datum.writeDate(LocalDate.now());
	}
	
	public ArrayList<Filmstart> getArrayList(Film film) {
		for (int i = 0; i < filme.size(); i++) {
			if (filme.get(i).getTitel().equals(film1.get(0).getTitel())) {
				return film1;
			}
			else if (filme.get(i).getTitel().equals(film2.get(0).getTitel())) {
				return film2;
			}
			else if (filme.get(i).getTitel().equals(film3.get(0).getTitel())) {
				return film3;
			}
			else if (filme.get(i).getTitel().equals(film4.get(0).getTitel())) {
				return film4;
			}
			else if (filme.get(i).getTitel().equals(film5.get(0).getTitel())) {
				return film5;
			}
		}
		return null;
	}

	public void loadFilmInfo(Node n, Film film) {
		tab1Controller.StartBildschirmPane.setVisible(false);
		tab2Controller.FilmInfoPane.setVisible(true);
		tab3Controller.SitzplatzAuswahlPane.setVisible(false);
		Stage stage = (Stage) n.getScene().getWindow();
		stage.setWidth(tab2Controller.FilmInfoPane.getWidth() + 20);
		stage.setHeight(tab2Controller.FilmInfoPane.getHeight() + 40);
		tab2Controller.initData(film, getArrayList(film));
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

	public void loadSitzplatzAuswahl(Node n, Filmstart film) {
		tab1Controller.StartBildschirmPane.setVisible(false);
		tab2Controller.FilmInfoPane.setVisible(false);
		tab3Controller.SitzplatzAuswahlPane.setVisible(true);
		tab3Controller.initData(film);
		Stage stage = (Stage) n.getScene().getWindow();
		stage.setWidth(tab3Controller.SitzplatzAuswahlPane.getWidth() + 20);
		stage.setHeight(tab3Controller.SitzplatzAuswahlPane.getHeight() + 40);
	}
	
	public void alleFilmdatenSpeichern() {
		Film avatar = new Film(2.42, "Avatar - Aufbruch nach Pandorra", 12, "Action und Fantasy", "https://www.youtube.com/watch?v=EzETGqZN6dU", "../../../avatar_thumb.jpg", 10);
		Film jurassic = new Film(2.10, "Jurassic World", 12, "Action und Science-Fiction", "https://www.youtube.com/watch?v=QvGzqDgkJQc", "../../../jurassic-world.jpg", 7.50);
		Film shades = new Film(2.05, "Fifty Shades of Grey - Geheimes Verlangen", 16, "Liebesfilm und Drama", "https://www.youtube.com/watch?v=H1r_SFh8in0",
				"../../../fifty-shades-of-grey_thumb.jpg", 9);
		Film nemo = new Film(1.40, "Findet Nemo", 0, "Animation und Kinder/Familie", "https://www.youtube.com/watch?v=9F-TxJt0HMA", "../../../findet-nemo_thumb.jpg", 8.50);
		Film freunde = new Film(1.53, "Ziemlich beste Freunde", 6, "Komödie und Drama", "https://www.youtube.com/watch?v=MYqzxrqY98E", "../../../ziemlich-beste-freunde_thumb.jpg", 8);
		
		File f = new File("filme.kos");
		
		if (!f.exists()) {
			try {
				f.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
			FileOutputStream fs;
			
			try {
				fs = new FileOutputStream(f, true);
				ObjectOutputStream out = new ObjectOutputStream(fs);
				out.writeObject(avatar);
				out.writeObject(jurassic);
				out.writeObject(shades);
				out.writeObject(nemo);
				out.writeObject(freunde);
				out.close();
				fs.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		filmeMitZeitenSpeichern(avatar, "avatar.kos");
		filmeMitZeitenSpeichern(jurassic, "jurassic.kos");
		filmeMitZeitenSpeichern(shades, "shades.kos");
		filmeMitZeitenSpeichern(nemo, "nemo.kos");
		filmeMitZeitenSpeichern(freunde, "freunde.kos");
	}
	
	public void filmeMitZeitenSpeichern(Film film, String fileURL) {
		File f = new File(fileURL);
		
		Filmstart film1 = new Filmstart(film, new Datum("Heute", "13:00"), saal1);
		Filmstart film2 = new Filmstart(film, new Datum("Heute", "15:00"), saal2);
		Filmstart film3 = new Filmstart(film, new Datum("Heute", "17:00"), saal1);
		Filmstart film4 = new Filmstart(film, new Datum("Morgen", "14:00"), saal1);
		Filmstart film5 = new Filmstart(film, new Datum("Morgen", "16:00"), saal2);
		Filmstart film6 = new Filmstart(film, new Datum("Morgen", "18:00"), saal1);
		Filmstart film7 = new Filmstart(film, new Datum("Uebermorgen", "15:00"), saal1);
		Filmstart film8 = new Filmstart(film, new Datum("Uebermorgen", "17:00"), saal2);
		Filmstart film9 = new Filmstart(film, new Datum("Uebermorgen", "19:00"), saal1);
		
		if (!f.exists()) {
			try {
				f.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
			FileOutputStream fs;
			
			try {
				fs = new FileOutputStream(f, true);
				ObjectOutputStream out = new ObjectOutputStream(fs);
				out.writeObject(film1);
				out.writeObject(film2);
				out.writeObject(film3);
				out.writeObject(film4);
				out.writeObject(film5);
				out.writeObject(film6);
				out.writeObject(film7);
				out.writeObject(film8);
				out.writeObject(film9);
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void alleFilmdatenAbrufen() {
		filmeMitZeitenAbrufen("avatar.kos", film1);
		filmeMitZeitenAbrufen("jurassic.kos", film2);
		filmeMitZeitenAbrufen("nemo.kos", film3);
		filmeMitZeitenAbrufen("freunde.kos", film4);
		filmeMitZeitenAbrufen("shades.kos", film5);
		
		filmeOhneZeitenAbrufen("filme.kos", filme);
	}
	
	public void filmeOhneZeitenAbrufen(String fileURL, ArrayList<Film> list) {
		try {
			FileInputStream fis = new FileInputStream(new File(fileURL));
			ObjectInputStream in = new ObjectInputStream(fis);
			for (int i = 0; i < 5 ; i++) {
				Film film = (Film) in.readObject();
				list.add(film);
			}
			in.close();
			fis.close();
		} catch (IOException | ClassNotFoundException e1) {
			System.out.println("Datei nicht gefunden.");
			e1.printStackTrace();
		}
	}
	
	public void filmeMitZeitenAbrufen(String fileURL, ArrayList<Filmstart> list) {
		try {
			FileInputStream fis = new FileInputStream(new File(fileURL));
			ObjectInputStream in = new ObjectInputStream(fis);
			for (int i = 0; i < 9 ; i++) {
				Filmstart film = (Filmstart) in.readObject();
				list.add(film);
			}
			in.close();
			fis.close();
		} catch (IOException | ClassNotFoundException e1) {
			System.out.println("Datei nicht gefunden.");
			e1.printStackTrace();
		}
	}

}
