package Default;

import java.text.DecimalFormat;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.Locale;

import javafx.fxml.FXML;
import javafx.scene.layout.VBox;

public class Reservierung { // Speichert die wichtigsten Daten für die Reservierung
	@FXML
	private VBox comboContainer;
	
	private String info;
	private Filmstart film;
	private ArrayList<Kunde> kundenListe;

	public Reservierung(Filmstart film, ArrayList<Kunde> kundenListe) {
		this.film = film;
		this.kundenListe = kundenListe;
	}

	public void speicherReservierung() { // Fügt alle wichtigen Daten zu einem String zusammen

			String plaetze = "";
			String preis = "";
			DecimalFormat df = new DecimalFormat("#.00");
			double gesamtpreis = film.getPreis() * kundenListe.size();
			for (int i = 0; i < kundenListe.size(); i++) {
				plaetze = plaetze + "Reihe: " + ((int) kundenListe.get(i).getPlatz().getPlatzierung().getX() + 1)
						+ ", Platz: " + ((int) kundenListe.get(i).getPlatz().getPlatzierung().getY() + 1) + "\n";

				gesamtpreis = gesamtpreis - kundenListe.get(i).getErmaessigung() + kundenListe.get(i).getPlatz().getAufpreis();
				preis = preis +"Grundpreis:        "+df.format(film.getPreis())+" €\n";
				if(kundenListe.get(i).getPlatz().getAufpreis()!=0) {
					preis = preis + "Sitzplatzaufpreis: +"+df.format(kundenListe.get(i).getPlatz().getAufpreis())+" €\n";
				}
				if(kundenListe.get(i).getErmaessigung()!=0) {
					preis = preis +"Ermäßigung:        -"+df.format(kundenListe.get(i).getErmaessigung())+" €\n";
				}
			}
			preis= preis+"--------------------------\nGesamtpreis:       "+df.format(gesamtpreis);
			info = film.getTitel() + "\n"
					+ film.getDate().getDate().getDayOfWeek().getDisplayName(TextStyle.FULL_STANDALONE, Locale.GERMANY) + " "+ film.getDate().getDate()
					+ " " + film.getDate().getTime() + "\n" + "Saal " + film.getDate().getSaal().getSaalnummer() + "\n" + plaetze
					+ "\n" + preis + " €";
	}

	public String getReservierungsInformationen() {
		return info;
	}

}
