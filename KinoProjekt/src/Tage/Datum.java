package Tage;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

import Default.Saal;

public class Datum implements Serializable{ // Speichert Datum und Uhrzeit
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private LocalTime time;
	private LocalDate date;
	private String tag;
	private String wochenTag;
	private Saal saal;
	
	public Datum(String uhrzeit, String wochenTag, Saal saal) {
		this.time = LocalTime.parse(uhrzeit);
		this.saal = saal;
		this.wochenTag = wochenTag;
	}	
	
	public String getWochenTag() {
		return wochenTag;
	}

	public void setWochenTag(String wochenTag) {
		this.wochenTag = wochenTag;
	}

	public Saal getSaal() {
		return saal;
	}

	public void setSaal(Saal saal) {
		this.saal = saal;
	}
	
	public LocalTime getTime() {
		return time;
	}

	public void setTime(LocalTime time) {
		this.time = time;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}
	
}
