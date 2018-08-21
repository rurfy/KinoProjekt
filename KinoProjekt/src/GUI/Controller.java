package GUI;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.Locale;

import Default.Film;
import Default.Filmstart;
import Default.Saal;
import Platztypen.Sitzplatz;
import Tage.Datum;

import javafx.fxml.FXML;
import javafx.scene.Node;
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

	Saal saal1 = new Saal(1, new Sitzplatz[12][22], 4, 4, 4, "../../../Saal1.jpg");
	Saal saal2 = new Saal(2, new Sitzplatz[12][22], 4, 4, 4, "../../../Saal1.jpg");
	Saal saal3 = new Saal(3, new Sitzplatz[12][22], 5, 5, 2, "../../../Saal2.jpg");
	Saal saal4 = new Saal(4, new Sitzplatz[12][22], 5, 5, 4, "../../../Saal2.jpg");

	@FXML
	public void initialize() {

		System.out.println("App gestartet");
		
		filmeAbrufen();

		for (int i = 0; i < 5; i++) {
			getStartzeiten(filme.get(i));
		}

		tab1Controller.init(this);
		tab2Controller.init(this);
		tab3Controller.init(this);
		loadStartBildschirm();

	}

	private void readCorrectDays(ArrayList<Datum> list, Film film, ArrayList<Filmstart> filme) {
		String heute = LocalDate.now().getDayOfWeek().getDisplayName(TextStyle.FULL_STANDALONE, Locale.GERMANY);
		switch (heute) {
		case "Montag":
			readSpecificDays(list, film, filme, 0);
			break;
		case "Dienstag":
			readSpecificDays(list, film, filme, 3);
			break;
		case "Mittwoch":
			readSpecificDays(list, film, filme, 6);
			break;
		case "Donnerstag":
			readSpecificDays(list, film, filme, 9);
			break;
		case "Freitag":
			readSpecificDays(list, film, filme, 12);
			break;
		case "Samstag":
			readSpecificDays(list, film, filme, 15);
			break;
		case "Sonntag":
			readSpecificDays(list, film, filme, 18);
			break;
		}
	}

	private void readSpecificDays(ArrayList<Datum> list, Film film, ArrayList<Filmstart> filme, int start) {
		for (int i = start; i < start + 3; i++) {
			Filmstart filmstart = new Filmstart(film, list.get(i), list.get(i).getSaal());
			filmstart.getDate().setTag("Heute");
			filmstart.getDate().setDate(LocalDate.now());
			filme.add(filmstart);
		}
		if (start < 18) {
			for (int i = start + 3; i < start + 6; i++) {
				Filmstart filmstart = new Filmstart(film, list.get(i), list.get(i).getSaal());
				filmstart.getDate().setTag("Morgen");
				filmstart.getDate().setDate(LocalDate.now().plusDays(1));
				filme.add(filmstart);
			}
		} else {
			for (int i = 3; i < 6; i++) {
				Filmstart filmstart = new Filmstart(film, list.get(i), list.get(i).getSaal());
				filmstart.getDate().setTag("Uebermorgen");
				filmstart.getDate().setDate(LocalDate.now().plusDays(2));
				filme.add(filmstart);
			}
		}
		if (start < 15) {
			for (int i = start + 6; i < start + 9; i++) {
				Filmstart filmstart = new Filmstart(film, list.get(i), list.get(i).getSaal());
				filmstart.getDate().setTag("Uebermorgen");
				filmstart.getDate().setDate(LocalDate.now().plusDays(2));
				filme.add(filmstart);
			}
		} else {
			for (int i = 0; i < 3; i++) {
				Filmstart filmstart = new Filmstart(film, list.get(i), list.get(i).getSaal());
				if (start < 18) {
					filmstart.getDate().setTag("Uebermorgen");
					filmstart.getDate().setDate(LocalDate.now().plusDays(2));
				} else {
					filmstart.getDate().setTag("Morgen");
					filmstart.getDate().setDate(LocalDate.now().plusDays(1));
				}
				filme.add(filmstart);
			}
		}

	}

	private void getStartzeiten(Film film) {
		switch (film.getTitel()) {
		case "Avatar - Aufbruch nach Pandorra":
			readCorrectDays(readStartzeiten("avatar-zeiten.kos"), film, film1);
			break;
		case "Jurassic World":
			readCorrectDays(readStartzeiten("jurassic-zeiten.kos"), film, film2);
			break;
		case "Fifty Shades of Grey - Geheimes Verlangen":
			readCorrectDays(readStartzeiten("shades-zeiten.kos"), film, film3);
			break;
		case "Findet Nemo":
			readCorrectDays(readStartzeiten("nemo-zeiten.kos"), film, film4);
			break;
		case "Ziemlich beste Freunde":
			readCorrectDays(readStartzeiten("freunde-zeiten.kos"), film, film5);
			break;
		}
	}

	private ArrayList<Datum> readStartzeiten(String fileURL) {
		File f = new File(fileURL);
		ArrayList<Datum> list = new ArrayList<Datum>();
		if (f.exists()) {
			try {
				FileInputStream fis = new FileInputStream(f);
				ObjectInputStream ois = new ObjectInputStream(fis);
				for (int i = 0; i < 21; i++) {
					list.add((Datum) ois.readObject());
				}
				ois.close();
				fis.close();
			} catch (IOException | ClassNotFoundException e) {
				// TODO: handle exception
			}
		}
		return list;
	}

	private void writeStartzeiten() {
		File f = new File("freunde-zeiten.kos");
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
				Datum m1 = new Datum("10:00", "Montag", saal2);
				out.writeObject(m1);
				Datum m2 = new Datum("13:00", "Montag", saal3);
				out.writeObject(m2);
				Datum m3 = new Datum("16:00", "Montag", saal4);
				out.writeObject(m3);

				Datum m4 = new Datum("10:00", "Dienstag", saal3);
				out.writeObject(m4);
				Datum m5 = new Datum("13:00", "Dienstag", saal4);
				out.writeObject(m5);
				Datum m6 = new Datum("16:00", "Dienstag", saal1);
				out.writeObject(m6);

				Datum m7 = new Datum("10:00", "Mittwoch", saal4);
				out.writeObject(m7);
				Datum m8 = new Datum("13:00", "Mittwoch", saal1);
				out.writeObject(m8);
				Datum m9 = new Datum("16:00", "Mittwoch", saal2);
				out.writeObject(m9);

				Datum m10 = new Datum("13:00", "Donnerstag", saal2);
				out.writeObject(m10);
				Datum m11 = new Datum("16:00", "Donnerstag", saal3);
				out.writeObject(m11);
				Datum m12 = new Datum("19:00", "Donnerstag", saal4);
				out.writeObject(m12);

				Datum m13 = new Datum("13:00", "Freitag", saal2);
				out.writeObject(m13);
				Datum m14 = new Datum("16:00", "Freitag", saal3);
				out.writeObject(m14);
				Datum m15 = new Datum("19:00", "Freitag", saal4);
				out.writeObject(m15);

				Datum m16 = new Datum("13:00", "Samstag", saal3);
				out.writeObject(m16);
				Datum m17 = new Datum("16:00", "Samstag", saal4);
				out.writeObject(m17);
				Datum m18 = new Datum("19:00", "Samstag", saal1);
				out.writeObject(m18);

				Datum m19 = new Datum("13:00", "Sonntag", saal4);
				out.writeObject(m19);
				Datum m20 = new Datum("16:00", "Sonntag", saal1);
				out.writeObject(m20);
				Datum m21 = new Datum("19:00", "Sonntag", saal2);
				out.writeObject(m21);
				out.close();
				fs.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	ArrayList<Filmstart> getArrayList(Film film) {
		for (int i = 0; i < filme.size(); i++) {
			if (filme.get(i).getTitel().equals(film1.get(0).getTitel())) {
				return film1;
			} else if (filme.get(i).getTitel().equals(film2.get(0).getTitel())) {
				return film2;
			} else if (filme.get(i).getTitel().equals(film3.get(0).getTitel())) {
				return film3;
			} else if (filme.get(i).getTitel().equals(film4.get(0).getTitel())) {
				return film4;
			} else if (filme.get(i).getTitel().equals(film5.get(0).getTitel())) {
				return film5;
			}
		}
		return null;
	}

	void loadFilmInfo(Node n, Film film) {
		tab1Controller.StartBildschirmPane.setVisible(false);
		tab2Controller.FilmInfoPane.setVisible(true);
		tab3Controller.SitzplatzAuswahlPane.setVisible(false);
		Stage stage = (Stage) n.getScene().getWindow();
		stage.setWidth(tab2Controller.FilmInfoPane.getWidth() + 20);
		stage.setHeight(tab2Controller.FilmInfoPane.getHeight() + 40);
		tab2Controller.initData(film, getArrayList(film));
	}

	void loadStartBildschirm() {
		tab1Controller.StartBildschirmPane.setVisible(true);
		tab2Controller.FilmInfoPane.setVisible(false);
		tab3Controller.SitzplatzAuswahlPane.setVisible(false);
		tab1Controller.initData();
	}

	void loadStartBildschirm(Node n) {
		tab1Controller.StartBildschirmPane.setVisible(true);
		tab2Controller.FilmInfoPane.setVisible(false);
		tab3Controller.SitzplatzAuswahlPane.setVisible(false);
		tab1Controller.initData();

		Stage stage = (Stage) n.getScene().getWindow();
		stage.setWidth(tab1Controller.StartBildschirmPane.getWidth() + 20);
		stage.setHeight(tab1Controller.StartBildschirmPane.getHeight() + 40);
	}

	void loadSitzplatzAuswahl(Node n, Filmstart film) {
		tab1Controller.StartBildschirmPane.setVisible(false);
		tab2Controller.FilmInfoPane.setVisible(false);
		tab3Controller.SitzplatzAuswahlPane.setVisible(true);
		tab3Controller.initData(film);
		Stage stage = (Stage) n.getScene().getWindow();
		stage.setWidth(tab3Controller.SitzplatzAuswahlPane.getWidth() + 20);
		stage.setHeight(tab3Controller.SitzplatzAuswahlPane.getHeight() + 40);
	}

	private void alleFilmdatenSpeichern() {
		Film avatar = new Film(2.42, "Avatar - Aufbruch nach Pandorra", 12, "Action und Fantasy", "https://www.youtube.com/watch?v=EzETGqZN6dU", "../../../avatar_thumb.jpg", 10);
		Film jurassic = new Film(2.10, "Jurassic World", 12, "Action und Science-Fiction", "https://www.youtube.com/watch?v=QvGzqDgkJQc", "../../../jurassic-world.jpg", 7.50);
		Film shades = new Film(2.05, "Fifty Shades of Grey - Geheimes Verlangen", 16, "Liebesfilm und Drama", "https://www.youtube.com/watch?v=H1r_SFh8in0", "../../../fifty-shades-of-grey_thumb.jpg",
				9);
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

		// filmeMitZeitenSpeichern(avatar, "avatar.kos");
		// filmeMitZeitenSpeichern(jurassic, "jurassic.kos");
		// filmeMitZeitenSpeichern(shades, "shades.kos");
		// filmeMitZeitenSpeichern(nemo, "nemo.kos");
		// filmeMitZeitenSpeichern(freunde, "freunde.kos");
	}

	private void filmeMitZeitenSpeichern(Film film, String fileURL) {
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

	private void filmeAbrufen() {
		// filmeMitZeitenAbrufen("avatar.kos", film1);
		// filmeMitZeitenAbrufen("jurassic.kos", film2);
		// filmeMitZeitenAbrufen("nemo.kos", film3);
		// filmeMitZeitenAbrufen("freunde.kos", film4);
		// filmeMitZeitenAbrufen("shades.kos", film5);

		filmeOhneZeitenAbrufen("filme.kos", filme);
	}

	private void filmeOhneZeitenAbrufen(String fileURL, ArrayList<Film> list) {
		try {
			FileInputStream fis = new FileInputStream(new File(fileURL));
			ObjectInputStream in = new ObjectInputStream(fis);
			for (int i = 0; i < 5; i++) {
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

	private void filmeMitZeitenAbrufen(String fileURL, ArrayList<Filmstart> list) {
		try {
			FileInputStream fis = new FileInputStream(new File(fileURL));
			ObjectInputStream in = new ObjectInputStream(fis);
			for (int i = 0; i < 9; i++) {
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
