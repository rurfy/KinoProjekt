package GUI;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.swing.plaf.synth.SynthSeparatorUI;

import Default.Film;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class ControllerStartbildschirm extends MainController implements Initializable {

	private final String FILMINFO = "FilmInfo.fxml";
	private final String SITZPLATZAUSWAHL = "SitzplatzAuswahl.fxml";

	public ArrayList<Film> filme = new ArrayList<Film>();

	@FXML
	private Button filmInfo;
	@FXML
	private Label filmTitel1;
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
	private Label dauer;
	@FXML
	private Label fsk;
	@FXML
	private Label titel;
	@FXML
	private Label genre;
	@FXML
	private ImageView bild;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

	public void test1(Pane p) {
		for (int i = 0; i < filme.size(); i++) {
			if (p.getId().equals(filme.get(i).getTitel())) {
				dauer.setText(Double.toString(filme.get(i).getDauer()));
				titel.setText(filme.get(i).getTitel());
				fsk.setText(Integer.toString(filme.get(i).getFsk()));
				bild.setImage(new Image(filme.get(i).getBildURL()));
				genre.setText(filme.get(i).getGenre());
				System.out.println(filme.get(i).getTitel());
			}
		}
	}

	public void init() {
		try {
			FileInputStream fis = new FileInputStream("filme.kos");
			ObjectInputStream in = new ObjectInputStream(fis);
			initialisiereFilm(fis, in, film1);
			initialisiereFilm(fis, in, film2);
			initialisiereFilm(fis, in, film3);
			initialisiereFilm(fis, in, film4);
			initialisiereFilm(fis, in, film5);
			in.close();
		} catch (IOException e) {
			// TODO: handle exception
		}

	}

	private void initialisiereFilm(FileInputStream fis, ObjectInputStream in, Pane p) throws EOFException {
		try {
			Film film = (Film) in.readObject();
			filme.add(film);
			// System.out.println(film.getTitel());
			for (Node node : p.getChildren()) {
				System.out.println(node instanceof Label);
				if (node instanceof Label) {
					p.setId(film.getTitel());
					System.out.println(p.getId());
					((Label) node).setText(film.getTitel());
//				} else if (node instanceof ImageView) {
//					((ImageView) node).setImage(new Image(film.getBildURL()));
				} else if(node instanceof HBox || node instanceof VBox) {
					System.out.println("die Methode wird nochmal ausgeführt");
					initialisiereFilm(fis, in, (Pane) node);
				}
			}
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@FXML
	public void zurFilmInfo(MouseEvent e) {
		init();
		Pane p = (Pane) e.getSource();
		setNewScene(FILMINFO, filmTitel1);
		test1(p);
	}

	@FXML
	public void zurSitzplatzAuswahl(ActionEvent e) {
		Button b = (Button) e.getSource();
		System.out.println(b.getText());
		setNewScene(SITZPLATZAUSWAHL, filmTitel1);
	}

	@Override
	public void back(ActionEvent e) {
		// TODO Auto-generated method stub
		init();
		Pane p = (Pane) e.getSource();
		setNewScene(FILMINFO, filmTitel1);
		
	}

	@Override
	public void zumStartBildschirm(ActionEvent e) {
		// TODO Auto-generated method stub

	}


}
