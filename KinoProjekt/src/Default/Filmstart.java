package Default;

import java.io.Serializable;

import Tage.Datum;

public class Filmstart extends Film implements Serializable { // Speichert einen Film zu einer bestimmten Zeit, in einem bestimmten Saal

	private static final long serialVersionUID = 1L;

	private Datum date;
	
	public Filmstart(Film film, Datum date) {
		super(film.getDauer(), film.getTitel(), film.getFsk(), film.getGenre(), film.getTrailer(), film.getBildURL(), film.getPreis());
		this.date = date;
	}

	public Datum getDate() {
		return date;
	}

	public void setDate(Datum date) {
		this.date = date;
	}

}
