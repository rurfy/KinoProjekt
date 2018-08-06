package Default;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Film implements Serializable {
	/**
	 * 
	 */
	//private static final long serialVersionUID = 1L;

	private double dauer;
	private String titel = "";
	private int fsk;
	private String genre = "";
	private String trailer = "";
	private String bildURL = "";
	private double preis;

	public Film(double dauer, String titel, int fsk, String genre, String trailer, String bildURL, double preis) {
		this.dauer = dauer;
		this.titel = titel;
		this.fsk = fsk;
		this.genre = genre;
		this.trailer = trailer;
		this.bildURL = bildURL;
		this.preis = preis;
		

	}

	public double getDauer() {
		return dauer;
	}

	public void setDauer(double dauer) {
		this.dauer = dauer;
	}

	public String getTitel() {

		return titel;
	}

	public void setTitel(String titel) {
		this.titel = titel;
	}

	public int getFsk() {
		return fsk;
	}

	public void setFsk(int fsk) {
		this.fsk = fsk;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getTrailer() {
		return trailer;
	}

	public void setTrailer(String trailer) {
		this.trailer = trailer;
	}

	public String getBildURL() {
		return bildURL;
	}

	public void setBildURL(String bildURL) {
		this.bildURL = bildURL;
	}

	public double getPreis() {
		return preis;
	}

	public void setPreis(double preis) {
		this.preis = preis;
	}

	public String titelVon(File files) {
		try {
			FileInputStream in = new FileInputStream(files);
			int a = 0;
			int b = 0;
			titel = "";
			String vergleich = "";
			while (a != -1) {
				a = in.read();
				vergleich = vergleich + (char) a;
				b++;

				if (vergleich.regionMatches(b - 7, "Titel: ", 0, 7)) {
					vergleich = "";
					b = 0;
					a = in.read();
					while (a != -1 && a != 13) {
						titel = titel + (char) a;
						a = in.read();
					}
				}
			}
			in.close();
		} catch (IOException e) {
			System.out.println("Fehler!");
		}
		return titel;

	}

}
