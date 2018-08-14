package Tage;

import java.io.Serializable;

public class Tage implements Serializable{
	
	//private String[] uhrzeiten = new String[3];
	private Uhrzeit uhrzeit1;
	private Uhrzeit uhrzeit2;
	private Uhrzeit uhrzeit3;
	
	public Tage(Uhrzeit uhrzeit1, Uhrzeit uhrzeit2, Uhrzeit uhrzeit3) {
		this.uhrzeit1 = uhrzeit1;
		this.uhrzeit2 = uhrzeit2;
		this.uhrzeit3 = uhrzeit3;
	}

	public Uhrzeit getUhrzeit1() {
		return uhrzeit1;
	}

	public void setUhrzeit1(Uhrzeit uhrzeit1) {
		this.uhrzeit1 = uhrzeit1;
	}

	public Uhrzeit getUhrzeit2() {
		return uhrzeit2;
	}

	public void setUhrzeit2(Uhrzeit uhrzeit2) {
		this.uhrzeit2 = uhrzeit2;
	}

	public Uhrzeit getUhrzeit3() {
		return uhrzeit3;
	}

	public void setUhrzeit3(Uhrzeit uhrzeit3) {
		this.uhrzeit3 = uhrzeit3;
	}
	
//	public abstract String[] getUhrzeit();

//	public abstract void setUhrzeit(String[] uhrzeit);
	
//	public abstract Uhrzeit getUhrzeit1();
	
}
