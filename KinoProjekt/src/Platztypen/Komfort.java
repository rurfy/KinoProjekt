package Platztypen;

import java.io.Serializable;

public class Komfort extends Sitzplatz implements Serializable { // Spezifische Ableitung von Sitzplatz
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int aufpreis = 4;

	public int getAufpreis() {
		return aufpreis;
	}

	public void setAufpreis(int aufpreis) {
		this.aufpreis = aufpreis;
	}

	@Override
	void setPosition(int i, int j) { // Setzt die Positiog spezifisch für Komfort
		setLayoutX(130 + j * 30);
		setLayoutY(137 + i * 30);
	}
}
