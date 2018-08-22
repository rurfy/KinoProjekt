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

public class Controller { // MainController zur Kommunikation zwischen den SubControllern

	ArrayList<Film> filme = new ArrayList<Film>(); // Speichert die Filme
	ArrayList<Filmstart> film1 = new ArrayList<Filmstart>(); // Speichert einen Film mit Uhrzeiten
	ArrayList<Filmstart> film2 = new ArrayList<Filmstart>();
	ArrayList<Filmstart> film3 = new ArrayList<Filmstart>();
	ArrayList<Filmstart> film4 = new ArrayList<Filmstart>();
	ArrayList<Filmstart> film5 = new ArrayList<Filmstart>();

	@FXML
	private Controller1 tab1Controller; // Verknüpfter Controller für einen Bildschirm
	@FXML
	private Controller2 tab2Controller;
	@FXML
	private Controller3 tab3Controller;

	@FXML
	public void initialize() { // Start der Oberflächeninitialisierung

		System.out.println("App gestartet");
		
		filmeAbrufen("../filme.kos", filme); // Filme werden geladen
		
		for (int i = 0; i < 5; i++) {
			getStartzeiten(filme.get(i)); // Aktuelle Daten werden für alle Filme geladen
		}

		tab1Controller.init(this); // Controller werden initialisiert
		tab2Controller.init(this);
		tab3Controller.init(this);
		loadStartBildschirm(); // StartBildschirm wird geladen

	}

	void loadFilmInfo(Node n, Film film) { // Lädt den Bildschirm mit näheren Informationen zu einem Film
		tab1Controller.getStartBildschirmPane().setVisible(false);
		tab2Controller.getFilmInfoPane().setVisible(true);
		tab3Controller.getSitzplatzAuswahlPane().setVisible(false);
		Stage stage = (Stage) n.getScene().getWindow();
		stage.setWidth(tab2Controller.getFilmInfoPane().getWidth() + 20);
		stage.setHeight(tab2Controller.getFilmInfoPane().getHeight() + 40);
		tab2Controller.initData(film, getArrayList(film));
	}

	void loadStartBildschirm() { // Lädt beim Start den Startbildschirm (keine Node notwendig)
		tab1Controller.getStartBildschirmPane().setVisible(true);
		tab2Controller.getFilmInfoPane().setVisible(false);
		tab3Controller.getSitzplatzAuswahlPane().setVisible(false);
		tab1Controller.initData();
	}

	void loadStartBildschirm(Node n) { // Lädt den StartBildschirm von anderen Bildschirmen aus
		tab1Controller.getStartBildschirmPane().setVisible(true);
		tab2Controller.getFilmInfoPane().setVisible(false);
		tab3Controller.getSitzplatzAuswahlPane().setVisible(false);
		tab1Controller.initData();

		Stage stage = (Stage) n.getScene().getWindow();
		stage.setWidth(tab1Controller.getStartBildschirmPane().getWidth() + 20);
		stage.setHeight(tab1Controller.getStartBildschirmPane().getHeight() + 40);
	}

	void loadSitzplatzAuswahl(Node n, Filmstart film) { // Lädt die Sitzplatzauswahl von anderen Bildschirmen aus
		tab1Controller.getStartBildschirmPane().setVisible(false);
		tab2Controller.getFilmInfoPane().setVisible(false);
		tab3Controller.getSitzplatzAuswahlPane().setVisible(true);
		tab3Controller.initData(film);
		Stage stage = (Stage) n.getScene().getWindow();
		stage.setWidth(tab3Controller.getSitzplatzAuswahlPane().getWidth() + 20);
		stage.setHeight(tab3Controller.getSitzplatzAuswahlPane().getHeight() + 40);
	}

	ArrayList<Filmstart> getArrayList(Film film) { // Gibt die korrespondierende ArrayList<Filmstart> des übergebenen Films zurück
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

	@SuppressWarnings("unused")
	private void alleFilmdatenSpeichern() { // Speichert manuell alle Filme in einer Datei ab
		Film avatar = new Film(2.42, "Avatar - Aufbruch nach Pandorra", 12, "Action und Fantasy", "https://www.youtube.com/watch?v=EzETGqZN6dU", "../../../Thumbnails/avatar_thumb.jpg", 10);
		Film jurassic = new Film(2.10, "Jurassic World", 12, "Action und Science-Fiction", "https://www.youtube.com/watch?v=QvGzqDgkJQc", "../../../Thumbnails/jurassic-world_thumb.jpg", 7.50);
		Film shades = new Film(2.05, "Fifty Shades of Grey - Geheimes Verlangen", 16, "Liebesfilm und Drama", "https://www.youtube.com/watch?v=H1r_SFh8in0", "../../../Thumbnails/fifty-shades-of-grey_thumb.jpg",
				9);
		Film nemo = new Film(1.40, "Findet Nemo", 0, "Animation und Kinder/Familie", "https://www.youtube.com/watch?v=9F-TxJt0HMA", "../../../Thumbnails/findet-nemo_thumb.jpg", 8.50);
		Film freunde = new Film(1.53, "Ziemlich beste Freunde", 6, "Komödie und Drama", "https://www.youtube.com/watch?v=MYqzxrqY98E", "../../../Thumbnails/ziemlich-beste-freunde_thumb.jpg", 8);

		File f = new File("filme.kos");

		if (!f.exists()) {
			try {
				f.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
			FileOutputStream fs;

			try {
				fs = new FileOutputStream(f);
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

	}

	private void filmeAbrufen(String fileURL, ArrayList<Film> list) { // Ruft alle Filme aus einer Datei ab
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

	private void readCorrectDays(ArrayList<Datum> list, Film film, ArrayList<Filmstart> filme) { // Der heutige Tag wird gesucht und ausgewählt
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

	private void readSpecificDays(ArrayList<Datum> list, Film film, ArrayList<Filmstart> filme, int start) { // Daten werden für den spezifischen Film und Tag geladen
		for (int i = start; i < start + 3; i++) {
			Filmstart filmstart = new Filmstart(film, list.get(i));
			filmstart.getDate().setTag("Heute");
			filmstart.getDate().setDate(LocalDate.now());
			filme.add(filmstart);
		}
		if (start < 18) {
			for (int i = start + 3; i < start + 6; i++) {
				Filmstart filmstart = new Filmstart(film, list.get(i));
				filmstart.getDate().setTag("Morgen");
				filmstart.getDate().setDate(LocalDate.now().plusDays(1));
				filme.add(filmstart);
			}
		} else {
			for (int i = 3; i < 6; i++) {
				Filmstart filmstart = new Filmstart(film, list.get(i));
				filmstart.getDate().setTag("Uebermorgen");
				filmstart.getDate().setDate(LocalDate.now().plusDays(2));
				filme.add(filmstart);
			}
		}
		if (start < 15) {
			for (int i = start + 6; i < start + 9; i++) {
				Filmstart filmstart = new Filmstart(film, list.get(i));
				filmstart.getDate().setTag("Uebermorgen");
				filmstart.getDate().setDate(LocalDate.now().plusDays(2));
				filme.add(filmstart);
			}
		} else {
			for (int i = 0; i < 3; i++) {
				Filmstart filmstart = new Filmstart(film, list.get(i));
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

	private void getStartzeiten(Film film) { // Für jeden Film werden seine Datensätze gesucht
		switch (film.getTitel()) {
		case "Avatar - Aufbruch nach Pandorra":
			readCorrectDays(readStartzeiten("../FilmZeiten/avatar-zeiten.kos"), film, film1);
			break;
		case "Jurassic World":
			readCorrectDays(readStartzeiten("../FilmZeiten/jurassic-zeiten.kos"), film, film2);
			break;
		case "Fifty Shades of Grey - Geheimes Verlangen":
			readCorrectDays(readStartzeiten("../FilmZeiten/shades-zeiten.kos"), film, film3);
			break;
		case "Findet Nemo":
			readCorrectDays(readStartzeiten("../FilmZeiten/nemo-zeiten.kos"), film, film4);
			break;
		case "Ziemlich beste Freunde":
			readCorrectDays(readStartzeiten("../FilmZeiten/freunde-zeiten.kos"), film, film5);
			break;
		}
	}

	private ArrayList<Datum> readStartzeiten(String fileURL) { // Daten für einen Film einlesen
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

	@SuppressWarnings("unused")
	private void writeStartzeiten() { // Funktion zur manuellen Verarbeitung der Uhrzeiten für einen Film (muss je
										// nach Film geändert werden)
		Saal saal1 = new Saal(1, new Sitzplatz[12][22], 4, 4, 4, "../../../Saal1.jpg");
		Saal saal2 = new Saal(2, new Sitzplatz[12][22], 4, 4, 4, "../../../Saal1.jpg");
		Saal saal3 = new Saal(3, new Sitzplatz[12][22], 5, 5, 2, "../../../Saal2.jpg");
		Saal saal4 = new Saal(4, new Sitzplatz[12][22], 5, 5, 4, "../../../Saal2.jpg");
		
		File f = new File("avatar-zeiten.kos");
		if (!f.exists()) {
			try {
				f.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
			FileOutputStream fs;

			try {
				fs = new FileOutputStream(f);
				ObjectOutputStream out = new ObjectOutputStream(fs);
				Datum m1 = new Datum("13:00", "Montag", saal1);
				out.writeObject(m1);
				Datum m2 = new Datum("16:00", "Montag", saal2);
				out.writeObject(m2);
				Datum m3 = new Datum("19:00", "Montag", saal3);
				out.writeObject(m3);

				Datum m4 = new Datum("10:00", "Dienstag", saal1);
				out.writeObject(m4);
				Datum m5 = new Datum("13:00", "Dienstag", saal2);
				out.writeObject(m5);
				Datum m6 = new Datum("16:00", "Dienstag", saal3);
				out.writeObject(m6);

				Datum m7 = new Datum("10:00", "Mittwoch", saal2);
				out.writeObject(m7);
				Datum m8 = new Datum("13:00", "Mittwoch", saal3);
				out.writeObject(m8);
				Datum m9 = new Datum("19:00", "Mittwoch", saal4);
				out.writeObject(m9);

				Datum m10 = new Datum("13:00", "Donnerstag", saal3);
				out.writeObject(m10);
				Datum m11 = new Datum("16:00", "Donnerstag", saal4);
				out.writeObject(m11);
				Datum m12 = new Datum("19:00", "Donnerstag", saal1);
				out.writeObject(m12);

				Datum m13 = new Datum("13:00", "Freitag", saal3);
				out.writeObject(m13);
				Datum m14 = new Datum("16:00", "Freitag", saal4);
				out.writeObject(m14);
				Datum m15 = new Datum("22:00", "Freitag", saal1);
				out.writeObject(m15);

				Datum m16 = new Datum("13:00", "Samstag", saal4);
				out.writeObject(m16);
				Datum m17 = new Datum("19:00", "Samstag", saal2);
				out.writeObject(m17);
				Datum m18 = new Datum("22:00", "Samstag", saal3);
				out.writeObject(m18);

				Datum m19 = new Datum("13:00", "Sonntag", saal1);
				out.writeObject(m19);
				Datum m20 = new Datum("16:00", "Sonntag", saal3);
				out.writeObject(m20);
				Datum m21 = new Datum("22:00", "Sonntag", saal3);
				out.writeObject(m21);
				out.close();
				fs.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
