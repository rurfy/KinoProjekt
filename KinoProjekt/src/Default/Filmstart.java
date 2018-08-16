package Default;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import Tage.Heute;
import Tage.Morgen;
import Tage.Tage;
import Tage.Uebermorgen;

public class Filmstart extends Film implements Serializable {

	private static final long serialVersionUID = 1L;

	private Heute heute;
	private Morgen morgen;
	private Uebermorgen uebermorgen;

	public Filmstart(double dauer, String titel, int fsk, String genre, String trailer, String bildURL, double preis, Heute heute, Morgen morgen, Uebermorgen uebermorgen) {
		super(dauer, titel, fsk, genre, trailer, bildURL, preis);
		this.heute = heute;
		this.morgen = morgen;
		this.uebermorgen = uebermorgen;
		// TODO Auto-generated constructor stub
	}

	public void writeFilm(File f, ObjectOutputStream out) {
		try {
			out.writeObject(this);
		} catch (IOException e) {
			System.out.println("Datei konnte nicht gefunden werden.");
		}
	}

	public Heute getHeute() {
		return heute;
	}

	public void setHeute(Heute heute) {
		this.heute = heute;
	}

	public Morgen getMorgen() {
		return morgen;
	}

	public void setMorgen(Morgen morgen) {
		this.morgen = morgen;
	}

	public Uebermorgen getUebermorgen() {
		return uebermorgen;
	}

	public void setUebermorgen(Uebermorgen uebermorgen) {
		this.uebermorgen = uebermorgen;
	}
}
