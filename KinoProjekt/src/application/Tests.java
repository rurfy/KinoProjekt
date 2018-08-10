package application;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import Default.Film;
import Tage.Heute;
import Tage.Morgen;
import Tage.Uebermorgen;

public class Tests {

	public static void testen() {
		
		//Beim ersten Ausführen des Programmes
//				try {
//					File f = new File("filme.kos");
//					if (!f.exists()) {					//Nur wenn die Datei noch nicht erstellt wurde
//						f.createNewFile();
//						Film avatar = new Film(2.42, "Avatar - Aufbruch nach Pandorra", 12, "Action und Fantasy", "https://www.youtube.com/watch?v=EzETGqZN6dU", "../../../avatar_thumb.jpg", 10);
//						Film jurassic = new Film(2.10, "Jurassic World", 12, "Action und Science-Fiction", "https://www.youtube.com/watch?v=QvGzqDgkJQc", "../../../jurassic-world.jpg", 7.50);
//						Film fiftyShades = new Film(2.05, "Fifty Shades of Grey - Geheimes Verlangen", 16, "Liebesfilm und Drama", "https://www.youtube.com/watch?v=H1r_SFh8in0", "../../../fifty-shades-of-grey_thumb.jpg", 9);
//						Film nemo = new Film(1.40, "Findet Nemo", 0, "Animation und Kinder/Familie", "https://www.youtube.com/watch?v=9F-TxJt0HMA", "../../../findet-nemo_thumb.jpg", 8.50);
//						Film freunde = new Film(1.53, "Ziemlich beste Freunde", 6, "Komödie und Drama", "https://www.youtube.com/watch?v=MYqzxrqY98E", "../../../ziemlich-beste-freunde_thumb.jpg", 8);
//						
//						try {
//							FileOutputStream fs = new FileOutputStream("filme.kos");
//							ObjectOutputStream out = new ObjectOutputStream(fs);
//							out.writeObject(avatar);
//							out.writeObject(nemo);
//							out.writeObject(freunde);
//							out.writeObject(jurassic);
//							out.writeObject(fiftyShades);
//							out.close();
//						} catch (IOException e) {
//							System.out.println("Datei konnte nicht gefunden werden.");
//						}
//					}
//
//
//				} catch (IOException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
		
		//Testblock Lucas
//		Uebermorgen um = new Uebermorgen();
//		Morgen morgen = new Morgen();
//		Heute heute = new Heute();
//		String[] uhrzeit;
//		uhrzeit = morgen.getUhrzeit();
//		
//		for (int i = 0; i< um.getUhrzeit().length; i++) {
//			
//			System.out.println(uhrzeit[i]);
//		}
//		
//
	}
//	
//	public static void starten() {
//		//Testblock FIS
//		try {
//			FileInputStream fis = new FileInputStream("filme.kos");
//			ObjectInputStream in = new ObjectInputStream(fis);
//			Film film1 = (Film) in.readObject();
//			Film film2 = (Film) in.readObject();
//			in.close();
//			System.out.println(film1.getGenre());
//			System.out.println(film2.getGenre());
//		} 
//		catch (IOException e) {
//			// TODO: handle exception
//		}
//		catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//	}
}
