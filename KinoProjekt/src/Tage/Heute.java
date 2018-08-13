package Tage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import Default.Film;

public class Heute extends Tage {

	private String[] uhrzeit = new String[3];
	Film film = new Film(0, null, 0, null, null, null, 0);
	private File f = new File("Tage/heute.txt");

	@Override
	public String[] getUhrzeit() {
		try {
			if (!f.exists()) {
				f.createNewFile();
			}
			FileInputStream in = new FileInputStream(f);
			int a = 0;
			String vergleich = "";
			while (a != -1) {
				a = in.read();
				vergleich = vergleich + (char) a;
				if (a == 13) {
					a = in.read();
					if (vergleich.regionMatches(0, film.getTitel(), 0, film.getTitel().length() - 1)) {
						for (int i = 0; i <= 2; i++) {
							a = in.read();
							vergleich = "";
							while (a != -1 && a != 13) {
								vergleich = vergleich + (char) a;
								a = in.read();
							}
							uhrzeit[i] = vergleich;
						}
					} else {
						vergleich = "";
					}
				}

			}
			in.close();
		} catch (IOException e) {
			System.out.println("Datei \"Heute\" nicht gefunden");
		}

		return uhrzeit;
	}

	public void zeitenUebernehmen() {
		// TODO Auto-generated method stub
		try {
			if (!f.exists()) {
				f.createNewFile();
			}
			FileInputStream in = new FileInputStream("Tage/morgen.txt");
			FileOutputStream out = new FileOutputStream(f);
			int leser = 0;
			while ((leser = in.read()) != -1) {
				out.write(leser);
			}
			in.close();
			out.close();
		} catch (IOException e) {
			System.out.println("Fehler!");
		}
	}

	@Override
	public void setUhrzeit(String[] uhrzeit) {

	}

}
