package Tage;

import java.awt.Point;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Datum implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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
	
	private LocalTime time;
	private LocalDate date;
	private String tag;
	
	public Datum(String tag, String uhrzeit) {
		
		switch (tag) {
		case "Heute":
			this.date = LocalDate.now();
			break;
		case "Morgen":
			this.date = LocalDate.now().plusDays(1);
			break;
		case "Uebermorgen":
			this.date = LocalDate.now().plusDays(2);
		default:
			break;
		}
		this.tag = tag;
		this.time = LocalTime.parse(uhrzeit);
	}
	
	public void compareDates(LocalDate date) {
		
		if (date.isEqual(LocalDate.now())) {
			this.date = LocalDate.now();
			this.tag = "Heute";
		}
		else if (date.isEqual(LocalDate.now().plusDays(1))) {
			this.date = LocalDate.now().plusDays(1);
			this.tag = "Morgen";
		}
		else if (date.isEqual(LocalDate.now().plusDays(2))) {
			this.date = LocalDate.now().plusDays(2);
			this.tag = "Uebermorgen";
		}
	}
	
	public static LocalDate readDate() {
		File f = new File("heute.kos");
		if (f.exists()) {
			try {
				FileInputStream fis = new FileInputStream(f);
				ObjectInputStream ois = new ObjectInputStream(fis);
				LocalDate date = (LocalDate) ois.readObject();
				ois.close();
				fis.close();
				return date;
			} catch (IOException | ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
		}
		return LocalDate.now();
	}
	
	public static void writeDate(LocalDate date) {
		File f = new File("heute.kos");
		FileOutputStream fos;
		if (!f.exists()) {
			try {
				f.createNewFile();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		try {
			fos = new FileOutputStream(f);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(date);
			oos.close();
			fos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
