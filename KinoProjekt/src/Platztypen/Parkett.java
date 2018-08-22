package Platztypen;

import java.io.Serializable;

public class Parkett extends Sitzplatz implements Serializable { // Spezifische Ableitung von Sitzplatz
	/**
	* 
	*/
	private static final long serialVersionUID = 1L;
	private int aufpreis = 0;

	public int getAufpreis() {
		return aufpreis;
	}

	public void setAufpreis(int aufpreis) {
		this.aufpreis = aufpreis;
	}

	@Override
	void setPosition(int i, int j) { // Setzt die Positiog spezifisch für Parkett
		setLayoutX(130 + j * 30);
		setLayoutY(82 + i * 30);
	}
}