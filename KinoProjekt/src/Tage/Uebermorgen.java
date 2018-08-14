package Tage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.SimpleTimeZone;
import java.util.TimeZone;

import Default.Film;

public class Uebermorgen extends Tage {

	public Uebermorgen(Uhrzeit uhrzeit1, Uhrzeit uhrzeit2, Uhrzeit uhrzeit3) {
		super(uhrzeit1, uhrzeit2, uhrzeit3);
		// TODO Auto-generated constructor stub
	}

//	private String[] uhrzeit = new String[3];
//	Film film = new Film(0, null, 0, null, null, null, 0);
//	private File f = new File("Tage/uebermorgen.txt");
//
//	@Override
//	public String[] getUhrzeit() {
//		try {
//			FileInputStream in = new FileInputStream(f);
//			int a = 0;
//			String vergleich = "";
//			while (a != -1) {
//				a = in.read();
//				vergleich = vergleich + (char) a;
//				if (a == 13) {
//					a = in.read();
////					System.out.println("test");
//					if (vergleich.regionMatches(0, film.getTitel(), 0, film.getTitel().length() - 1)) {
//						for (int i = 0; i <= 2; i++) {
//							a = in.read();
//							vergleich = "";
//							while (a != -1 && a != 13) {
//								vergleich = vergleich + (char) a;
//								a = in.read();
//							}
//							uhrzeit[i] = vergleich;
//						}
//					} else {
//						vergleich = "";
//					}
//				}
//
//			}
//			in.close();
//		} catch (IOException e) {
//			System.out.println("Datei \"Übermorgen\" nicht gefunden");
//		}
//
//		return uhrzeit;
//	}
//
//	@Override
//	public void setUhrzeit(String[] uhrzeit) {
//		// TODO Auto-generated method stub
//		uhrzeit = this.uhrzeit;
//	}
//
//	public void uhrzeitGenerieren() {
//		try {
////			Charset c = Charset.forName("US-ASCII");
//			String s="";
//			char enter = 13;
//			double[] a = { 0, 0, 0 };
//			double y=100;
//			File actPath = new File("Filme").getCanonicalFile();
//			FileWriter fw = new FileWriter("Tage/uebermorgen.txt");
//			PrintWriter writer = new PrintWriter(fw);
////			FileOutputStream out = new FileOutputStream("Tage/uebermorgen.txt");
//			File[] files = actPath.listFiles();
//			for (File x : files) {
//
//				while (a[0] < 9 || (a[0])-(int)(y/10)>0.5) {
//					y = ((int) ((Math.random() * 12) * 10));
//					a[0] = y / 10;
//				}
//				while (a[1] < a[0] + 2 ||  (a[1])-(int)(y/10)>0.5) {
//					y = ((int) ((Math.random() * 17) * 10));
//					a[1] = y / 10;
//				}
//				while (a[2] < a[1] + 2 ||  (a[2])-(int)(y/10)>0.5) {
//					y = (int) ((Math.random() * 21) * 10);
//					a[2] = y / 10;
//				}
//				s = s+film.titelVon(x) + "\n" + a[0] + "0\n" + a[1] + "0\n" + a[2] + "0\n";
//				a[0] = 0;
//				a[1] = 0;
//				a[2] = 0;
//			}
////			System.out.println(s.getBytes(c));
//			
////			byte[] b = new byte[s.length()];
////			for (int i = 0; i< b.length; i++) {
////				b[i] = (byte) s.charAt(i);
////				System.out.println(b[i]);
////			}
//			writer.println(s);
//			
//			writer.flush();
//			writer.close();
////			out.write(b);
////			out.close();
//		} catch (IOException e) {
//			System.out.println("Fehler!");
//		}
//	}
//
//	public void aktuellenTagPruefen() {
//		try {
//			File f = new File("Tage/datum.txt");
//			if (!f.exists()) {
//				f.createNewFile();
//			}
//			FileInputStream in = new FileInputStream(f);
//
//			String[] ids = TimeZone.getAvailableIDs(1 * 60 * 60 * 1000);
//			if (ids.length == 0) {
//				System.exit(0);
//			}
//
//			SimpleTimeZone pdt = new SimpleTimeZone(1 * 60 * 60 * 1000, ids[0]);
//
//			Calendar calendar = new GregorianCalendar(pdt);
//			Date trialTime = new Date();
//			calendar.setTime(trialTime);
//
//			int a = 0;
//			String s = "";
//			while (a != -1 && a != 13) {
//				a = in.read();
//				s = s + (char) a;
//			}
//			s = s.substring(0, s.length() - 1);
//			try {
//				a = Integer.parseInt(s);
//			} catch (NumberFormatException e) {
//
//			}
//			if (a != calendar.get(Calendar.DATE)) {
//				s = "" + calendar.get(Calendar.DATE);
//				Charset c = Charset.forName("US-ASCII");
//				try {
//					FileOutputStream out = new FileOutputStream(f);
//					byte[] b = s.getBytes(c);
//					out.write(b);
//					out.close();
//				} catch (IOException e) {
//					System.out.println("Datei nicht gefunden");
//				}
//				uhrzeitGenerieren();
//				;
//			} else {
//				System.out.println("Das Datum ist aktuell");
//			}
//
//			in.close();
//		} catch (IOException e) {
//			System.out.println("Datei \"Datum\" konnte nicht gefunden werden");
//		}
//	}
//
//	@Override
//	public Uhrzeit getUhrzeit1() {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
