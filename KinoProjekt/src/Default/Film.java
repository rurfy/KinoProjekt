package Default;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.Serializable;

public class Film implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private double dauer;
	private String titel = "";
	private int fsk;
	private String genre = "";
	private String trailer = "";
	private String bildURL = "";
	private double preis;

	public Film() {
		try {
			String vergleich = "";
			File f = new File("Filme/findet_nemo.txt");
			FileInputStream in = new FileInputStream(f);
			int a = 0;
			int b = 0;
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

				if (vergleich.regionMatches(b - 7, "Dauer: ", 0, 7)) {
					vergleich = "";
					b = 0;
					String s = "";
					while (a != -1 && a != 13) {
						a = in.read();
						s = s + (char) a;
						dauer = Double.parseDouble(s);
					}
				}

				if (vergleich.regionMatches(b - 7, "Genre: ", 0, 7)) {
					vergleich = "";
					b = 0;
					a = in.read();
					while (a != -1 && a != 13) {
						genre = genre + (char) a;
						a = in.read();
					}
				}

				if (vergleich.regionMatches(b - 9, "Trailer: ", 0, 9)) {
					vergleich = "";
					b = 0;
					a = in.read();
					while (a != -1 && a != 13) {
						trailer = trailer + (char) a;
						a = in.read();
					}
				}

				if (vergleich.regionMatches(b - 9, "BildURL: ", 0, 9)) {
					vergleich = "";
					b = 0;
					a = in.read();
					while (a != -1 && a != 13) {
						bildURL = bildURL + (char) a;
						a = in.read();
					}
				}

				if (vergleich.regionMatches(b - 5, "FSK: ", 0, 5)) {
					vergleich = "";
					b = 0;
					String s = "";
					a = in.read();
					while (a != -1 && a != 13) {
						s = s + (char) a;
						fsk = Integer.parseInt(s);
						a = in.read();
					}
				}

				if (vergleich.regionMatches(b - 7, "Preis: ", 0, 7)) {
					vergleich = "";
					b = 0;
					String s = "";
					while (a != -1 && a != 13) {
						a = in.read();
						s = s + (char) a;
						preis = Double.parseDouble(s);
					}
				}
			}
			in.close();
		} catch (IOException e) {
			System.out.println("Datei konnte nicht gefunden werden.");
		}

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
