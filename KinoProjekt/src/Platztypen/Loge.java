package Platztypen;

import java.io.Serializable;

public class Loge extends Sitzplatz implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int aufpreis = 2;

	public int getAufpreis() {
		return aufpreis;
	}

	public void setAufpreis(int aufpreis) {
		this.aufpreis = aufpreis;
	}

	@Override
	public void setPosition(int i, int j) {
		// TODO Auto-generated method stub
		setLayoutX(130 + j * 30);
		setLayoutY(107 + i *30);
	}
	
}
