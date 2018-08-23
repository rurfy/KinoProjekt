package Default;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.Locale;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

import javafx.fxml.FXML;
import javafx.scene.layout.VBox;

public class Reservierung { // Speichert die wichtigsten Daten für die Reservierung
	@FXML
	private VBox comboContainer;
	
	private String info;
	private Filmstart film;
	private ArrayList<Kunde> kundenListe;

	public Reservierung(Filmstart film, ArrayList<Kunde> kundenListe) {
		this.film = film;
		this.kundenListe = kundenListe;
	}

	public void speicherReservierung() { // Fügt alle wichtigen Daten zu einem String zusammen

			String plaetze = "";
			String preis = "";
			DecimalFormat df = new DecimalFormat("#.00");
			double gesamtpreis = film.getPreis() * kundenListe.size();
			for (int i = 0; i < kundenListe.size(); i++) {
				plaetze = plaetze + "Reihe: " + ((int) kundenListe.get(i).getPlatz().getPlatzierung().getX() + 1)
						+ ", Platz: " + ((int) kundenListe.get(i).getPlatz().getPlatzierung().getY() + 1) + "\n";

				gesamtpreis = gesamtpreis - kundenListe.get(i).getErmaessigung() + kundenListe.get(i).getPlatz().getAufpreis();
				preis = preis +"Grundpreis:        "+df.format(film.getPreis())+" €\n";
				if(kundenListe.get(i).getPlatz().getAufpreis()!=0) {
					preis = preis + "Sitzplatzaufpreis: +"+df.format(kundenListe.get(i).getPlatz().getAufpreis())+" €\n";
				}
				if(kundenListe.get(i).getErmaessigung()!=0) {
					preis = preis +"Ermäßigung:        -"+df.format(kundenListe.get(i).getErmaessigung())+" €\n";
				}
			}
			preis= preis+"--------------------------\nGesamtpreis:       "+df.format(gesamtpreis);
			info = film.getTitel() + "\n"
					+ film.getDate().getDate().getDayOfWeek().getDisplayName(TextStyle.FULL_STANDALONE, Locale.GERMANY) + " "+ film.getDate().getDate()
					+ " " + film.getDate().getTime() + "\n" + "Saal " + film.getDate().getSaal().getSaalnummer() + "\n" + plaetze
					+ "\n" + preis + " €";
	}

	public String getReservierungsInformationen() {
		return info;
	}
	
	public void speichereInPDF(File file) {
		PDPage myPage = new PDPage(PDRectangle.A4);
		PDDocument mainDocument = new PDDocument();
		PDImageXObject pdImage;
		PDPageContentStream contentStream;
		try {
			
			pdImage = PDImageXObject.createFromFile("@../../../Logos/Logo_v2.PNG", mainDocument);
			DecimalFormat df = new DecimalFormat("#.00");
			double gesamtpreis = film.getPreis() * kundenListe.size();

			contentStream = new PDPageContentStream(mainDocument, myPage, PDPageContentStream.AppendMode.APPEND , true);

			float scale = 0.5f;
			contentStream.drawImage(pdImage, 500, 700, pdImage.getWidth() * scale, pdImage.getHeight() * scale);
			contentStream.setFont(PDType1Font.HELVETICA_BOLD, 22);

			contentStream.beginText();
			contentStream.newLineAtOffset(50, 700);
			contentStream.showText("Reservierungsübersicht");
			contentStream.endText();
			
			contentStream.setFont(PDType1Font.HELVETICA_BOLD, 16);
			contentStream.beginText();
			contentStream.newLineAtOffset(50, 650);
			contentStream.showText("Reservierungscode:" + Integer.toString(info.hashCode()));
			contentStream.endText();

			contentStream.setFont(PDType1Font.HELVETICA_BOLD, 12);
			contentStream.beginText();
			contentStream.newLineAtOffset(50, 620);
			contentStream.showText(film.getTitel());
			contentStream.endText();

			contentStream.beginText();
			contentStream.newLineAtOffset(50, 600);
			contentStream.showText(film.getDate().getDate().getDayOfWeek().getDisplayName(TextStyle.FULL_STANDALONE, Locale.GERMANY) + " " + film.getDate().getDate() + " " + film.getDate().getTime());
			contentStream.endText();

			contentStream.beginText();
			contentStream.newLineAtOffset(50, 580);
			contentStream.showText("Saal " + film.getDate().getSaal().getSaalnummer());
			contentStream.endText();

			int x = 560;
			for (int i = 0; i < kundenListe.size(); i++) {
				contentStream.beginText();
				x = x - 20;
				contentStream.newLineAtOffset(50, x);
				contentStream.showText("Reihe: " + ((int) kundenListe.get(i).getPlatz().getPlatzierung().getX() + 1) + ", Platz: " + ((int) kundenListe.get(i).getPlatz().getPlatzierung().getY() + 1));
				contentStream.endText();
			}

			x -= 20;

			for (int i = 0; i < kundenListe.size(); i++) {
				x = x - 20;
				contentStream.beginText();
				contentStream.newLineAtOffset(50, x);
				gesamtpreis = gesamtpreis - kundenListe.get(i).getErmaessigung() + kundenListe.get(i).getPlatz().getAufpreis();
				contentStream.showText("Grundpreis:");
				contentStream.endText();
				contentStream.beginText();
				contentStream.newLineAtOffset(200, x);
				contentStream.showText(df.format(film.getPreis()) + " €");
				contentStream.endText();

				if (kundenListe.get(i).getPlatz().getAufpreis() != 0) {
					x -= 20;
					contentStream.beginText();
					contentStream.newLineAtOffset(50, x);
					contentStream.showText("Sitzplatzaufpreis:");
					contentStream.endText();
					contentStream.beginText();
					contentStream.newLineAtOffset(200, x);
					contentStream.showText("+" + df.format(kundenListe.get(i).getPlatz().getAufpreis()) + " €");
					contentStream.endText();
				}
				if (kundenListe.get(i).getErmaessigung() != 0) {
					x -= 20;
					contentStream.beginText();
					contentStream.newLineAtOffset(50, x);
					contentStream.showText("Ermäßigung:");
					contentStream.endText();
					contentStream.beginText();
					contentStream.newLineAtOffset(200, x);
					contentStream.showText("-" + df.format(kundenListe.get(i).getErmaessigung()) + " €");
					contentStream.endText();
				}
			}

			x -= 50;
			contentStream.setFont(PDType1Font.HELVETICA_BOLD, 16);
			contentStream.beginText();
			contentStream.newLineAtOffset(50, x);
			contentStream.showText("Gesamtpreis:");
			contentStream.endText();
			contentStream.beginText();
			contentStream.newLineAtOffset(300, x);
			contentStream.showText(df.format(gesamtpreis) + " €");
			contentStream.endText();

			contentStream.close();
			mainDocument.addPage(myPage);
			mainDocument.save(file.toString());
			mainDocument.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
