package Tage;

import java.io.Serializable;

import Default.Saal;

public class Uhrzeit implements Serializable{

	String uhrzeit;
	Saal saal;
	
	public Uhrzeit(String uhrzeit, Saal saal) {
		this.saal = saal;
		this.uhrzeit = uhrzeit;
	}
	
	public String getUhrzeit() {
		return uhrzeit;
	}

	public void setUhrzeit(String uhrzeit) {
		this.uhrzeit = uhrzeit;
	}

	public Saal getSaal() {
		return saal;
	}

	public void setSaal(Saal saal) {
		this.saal = saal;
	}
	
}
