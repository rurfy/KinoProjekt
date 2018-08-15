package GUI;

import java.io.File;
import java.util.ArrayList;

import Default.Film;
import Default.Filmstart;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class Controller1 {

	private Controller main;

	@FXML
	public AnchorPane StartBildschirmPane;

	@FXML
	private Label filmTitel1heute;
	@FXML
	private Label filmTitel1morgen;
	@FXML
	private Label filmTitel1uebermorgen;
	@FXML
	private Label filmTitel2heute;
	@FXML
	private Label filmTitel2morgen;
	@FXML
	private Label filmTitel2uebermorgen;
	@FXML
	private Label filmTitel3heute;
	@FXML
	private Label filmTitel3morgen;
	@FXML
	private Label filmTitel3uebermorgen;
	@FXML
	private Label filmTitel4heute;
	@FXML
	private Label filmTitel4morgen;
	@FXML
	private Label filmTitel4uebermorgen;
	@FXML
	private Label filmTitel5heute;
	@FXML
	private Label filmTitel5morgen;
	@FXML
	private Label filmTitel5uebermorgen;

	@FXML
	private Pane film1;
	@FXML
	private Pane film2;
	@FXML
	private Pane film3;
	@FXML
	private Pane film4;
	@FXML
	private Pane film5;

	@FXML
	private Button film1heute1;
	@FXML
	private Button film1heute2;
	@FXML
	private Button film1heute3;
	@FXML
	private Button film2heute1;
	@FXML
	private Button film2heute2;
	@FXML
	private Button film2heute3;
	@FXML
	private Button film3heute1;
	@FXML
	private Button film3heute2;
	@FXML
	private Button film3heute3;
	@FXML
	private Button film4heute1;
	@FXML
	private Button film4heute2;
	@FXML
	private Button film4heute3;
	@FXML
	private Button film5heute1;
	@FXML
	private Button film5heute2;
	@FXML
	private Button film5heute3;
	@FXML
	private Button film1morgen1;
	@FXML
	private Button film1morgen2;
	@FXML
	private Button film1morgen3;
	@FXML
	private Button film2morgen1;
	@FXML
	private Button film2morgen2;
	@FXML
	private Button film2morgen3;
	@FXML
	private Button film3morgen1;
	@FXML
	private Button film3morgen2;
	@FXML
	private Button film3morgen3;
	@FXML
	private Button film4morgen1;
	@FXML
	private Button film4morgen2;
	@FXML
	private Button film4morgen3;
	@FXML
	private Button film5morgen1;
	@FXML
	private Button film5morgen2;
	@FXML
	private Button film5morgen3;
	@FXML
	private Button film1uebermorgen1;
	@FXML
	private Button film1uebermorgen2;
	@FXML
	private Button film1uebermorgen3;
	@FXML
	private Button film2uebermorgen1;
	@FXML
	private Button film2uebermorgen2;
	@FXML
	private Button film2uebermorgen3;
	@FXML
	private Button film3uebermorgen1;
	@FXML
	private Button film3uebermorgen2;
	@FXML
	private Button film3uebermorgen3;
	@FXML
	private Button film4uebermorgen1;
	@FXML
	private Button film4uebermorgen2;
	@FXML
	private Button film4uebermorgen3;
	@FXML
	private Button film5uebermorgen1;
	@FXML
	private Button film5uebermorgen2;
	@FXML
	private Button film5uebermorgen3;

	@FXML
	private ImageView image1heute;
	@FXML
	private ImageView image1morgen;
	@FXML
	private ImageView image1uebermorgen;
	@FXML
	private ImageView image2heute;
	@FXML
	private ImageView image2morgen;
	@FXML
	private ImageView image2uebermorgen;
	@FXML
	private ImageView image3heute;
	@FXML
	private ImageView image3morgen;
	@FXML
	private ImageView image3uebermorgen;
	@FXML
	private ImageView image4heute;
	@FXML
	private ImageView image4morgen;
	@FXML
	private ImageView image4uebermorgen;
	@FXML
	private ImageView image5heute;
	@FXML
	private ImageView image5morgen;
	@FXML
	private ImageView image5uebermorgen;

	public void init(Controller controller) {
		main = controller;

	}

	public void loadData() {
		Components film1Comp = new Components(image1heute, image1morgen, image1uebermorgen, filmTitel1heute, filmTitel1morgen, filmTitel1uebermorgen,
				film1heute1, film1heute2, film1heute3, film1morgen1, film1morgen2, film1morgen3, film1uebermorgen1, film1uebermorgen2,
				film1uebermorgen3);
		Components film2Comp = new Components(image2heute, image2morgen, image2uebermorgen, filmTitel2heute, filmTitel2morgen, filmTitel2uebermorgen,
				film2heute1, film2heute2, film2heute3, film2morgen1, film2morgen2, film2morgen3, film2uebermorgen1, film2uebermorgen2,
				film2uebermorgen3);
		Components film3Comp = new Components(image3heute, image3morgen, image3uebermorgen, filmTitel3heute, filmTitel3morgen, filmTitel3uebermorgen,
				film3heute1, film3heute2, film3heute3, film3morgen1, film3morgen2, film3morgen3, film3uebermorgen1, film3uebermorgen2,
				film3uebermorgen3);
		Components film4Comp = new Components(image4heute, image4morgen, image4uebermorgen, filmTitel4heute, filmTitel4morgen, filmTitel4uebermorgen,
				film4heute1, film4heute2, film4heute3, film4morgen1, film4morgen2, film4morgen3, film4uebermorgen1, film4uebermorgen2,
				film4uebermorgen3);
		Components film5Comp = new Components(image5heute, image5morgen, image5uebermorgen, filmTitel5heute, filmTitel5morgen, filmTitel5uebermorgen,
				film5heute1, film5heute2, film5heute3, film5morgen1, film5morgen2, film5morgen3, film5uebermorgen1, film5uebermorgen2,
				film5uebermorgen3);
		loadFilmData(film1Comp, 0);
		loadFilmData(film2Comp, 1);
		loadFilmData(film3Comp, 2);
		loadFilmData(film4Comp, 3);
		loadFilmData(film5Comp, 4);

	}

	public void loadFilmData(Components comp, int i) {
		Filmstart film = main.filme.get(i);
		File file = new File("@" + film.getBildURL());
		comp.imageheute.setImage(new Image(file.toURI().toString()));
		comp.imagemorgen.setImage(new Image(file.toURI().toString()));
		comp.imageuebermorgen.setImage(new Image(file.toURI().toString()));
		comp.titelheute.setText(film.getTitel());
		comp.titelmorgen.setText(film.getTitel());
		comp.titeluebermorgen.setText(film.getTitel());
		comp.heute1.setText(film.getHeute().getUhrzeit1().getUhrzeit() + " Uhr");
		comp.heute2.setText(film.getHeute().getUhrzeit2().getUhrzeit() + " Uhr");
		comp.heute3.setText(film.getHeute().getUhrzeit3().getUhrzeit() + " Uhr");
		comp.morgen1.setText(film.getMorgen().getUhrzeit1().getUhrzeit() + " Uhr");
		comp.morgen2.setText(film.getMorgen().getUhrzeit2().getUhrzeit() + " Uhr");
		comp.morgen3.setText(film.getMorgen().getUhrzeit3().getUhrzeit() + " Uhr");
		comp.uebermorgen1.setText(film.getUebermorgen().getUhrzeit1().getUhrzeit() + " Uhr");
		comp.uebermorgen2.setText(film.getUebermorgen().getUhrzeit2().getUhrzeit() + " Uhr");
		comp.uebermorgen3.setText(film.getUebermorgen().getUhrzeit3().getUhrzeit() + " Uhr");
	}

	@FXML
	public void zurFilmInfo(MouseEvent e) {

		for (int i = 0; i < main.filme.size(); i++) {
			if (getFilmID(e).equals(main.filme.get(i).getTitel())) {
				main.loadFilmInfo((Pane) e.getSource(), main.filme.get(i));
			}
		}
	}

	public String getFilmID(MouseEvent e) {
		Pane p = (Pane) e.getSource();
		switch (p.getId()) {
		case "film1":
			return filmTitel1heute.getText();
		case "film2":
			return filmTitel2heute.getText();
		case "film3":
			return filmTitel3heute.getText();
		case "film4":
			return filmTitel4heute.getText();
		case "film5":
			return filmTitel5heute.getText();

		default:
			return "Fehler";
		}
	}

	public void zurSitzplatzAuswahl(ActionEvent e) {
		main.loadSitzplatzAuswahl((Button) e.getSource());
	}

}

class Components {

	ImageView imageheute;
	ImageView imagemorgen;
	ImageView imageuebermorgen;
	Label titelheute;
	Label titelmorgen;
	Label titeluebermorgen;
	Button heute1;
	Button heute2;
	Button heute3;
	Button morgen1;
	Button morgen2;
	Button morgen3;
	Button uebermorgen1;
	Button uebermorgen2;
	Button uebermorgen3;

	public Components(ImageView imageheute, ImageView imagemorgen, ImageView imageuebermorgen, Label titelheute, Label titelmorgen,
			Label titeluebermorgen, Button heute1, Button heute2, Button heute3, Button morgen1, Button morgen2, Button morgen3, Button uebermorgen1,
			Button uebermorgen2, Button uebermorgen3) {
		this.imageheute = imageheute;
		this.imagemorgen = imagemorgen;
		this.imageuebermorgen = imageuebermorgen;
		this.titelheute = titelheute;
		this.titelmorgen = titelmorgen;
		this.titeluebermorgen = titeluebermorgen;
		this.heute1 = heute1;
		this.heute2 = heute2;
		this.heute3 = heute3;
		this.morgen1 = morgen1;
		this.morgen2 = morgen2;
		this.morgen3 = morgen3;
		this.uebermorgen1 = uebermorgen1;
		this.uebermorgen2 = uebermorgen2;
		this.uebermorgen3 = uebermorgen3;
	}
}
