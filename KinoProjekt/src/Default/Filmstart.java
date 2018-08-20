package Default;

import java.io.Serializable;

import Tage.Datum;

public class Filmstart extends Film implements Serializable {

	private static final long serialVersionUID = 1L;

	private Datum date;
	private Saal saal;
	
	public Filmstart(Film film, Datum date, Saal saal) {
		super(film.getDauer(), film.getTitel(), film.getFsk(), film.getGenre(), film.getTrailer(), film.getBildURL(), film.getPreis());
		this.date = date;
		this.saal = saal;
	}

	public Datum getDate() {
		return date;
	}

	public void setDate(Datum date) {
		this.date = date;
	}

	public Saal getSaal() {
		return saal;
	}

	public void setSaal(Saal saal) {
		this.saal = saal;
	}
}
