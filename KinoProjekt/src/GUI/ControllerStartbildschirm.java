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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ControllerStartbildschirm extends MainController implements Initializable {

	private final String FILMINFO = "FilmInfo.fxml";
	private final String SITZPLATZAUSWAHL = "SitzplatzAuswahl.fxml";

	public ArrayList<Film> filme = new ArrayList<Film>();

	private String clickedFilm = "";

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

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

	public void inital(MouseEvent e) {

		try {
			FileInputStream fis = new FileInputStream("filme.kos");
			ObjectInputStream in = new ObjectInputStream(fis);
			Film filmA = (Film) in.readObject();
			filme.add(filmA);
			Film filmB = (Film) in.readObject();
			filme.add(filmB);
			Film filmC = (Film) in.readObject();
			filme.add(filmC);
			Film filmD = (Film) in.readObject();
			filme.add(filmD);
			Film filmE = (Film) in.readObject();
			filme.add(filmE);
			System.out.println(filmE.getTitel());
			in.close();

			Pane p = (Pane) e.getSource();
			initFilmRec(p);
		} catch (IOException | ClassNotFoundException e1) {

			// TODO: handle exception
		}

	}

	private void initFilmRec(Pane p) {
		for (Node node : p.getChildren()) {
			if (node instanceof Label) {
				clickedFilm = ((Label) node).getText();
			} else if (node instanceof Parent) {
				initFilmRec((Pane) node);

			}

		}
	}

	@FXML
	public void zurFilmInfo(MouseEvent e) {
		inital(e);
		Pane p = (Pane) e.getSource();
		setNewScene(FILMINFO, p);
	}

	@FXML
	public void zurSitzplatzAuswahl(ActionEvent e) {
		Button b = (Button) e.getSource();
		setNewScene(SITZPLATZAUSWAHL, b);
	}

	// @FXML
	// public void zurFilmInfo(ActionEvent e) {
	// TODO Auto-generated method stub
	// init();
	// Pane p = (Pane) e.getSource();
	// setNewScene(FILMINFO, filmTitel1);
	//
	// }

	@Override
	public void zumStartBildschirm(ActionEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setStartController(FXMLLoader loader) {
		// TODO Auto-generated method stub
		ControllerFilminfo controller = loader.<ControllerFilminfo>getController();
		controller.initData(clickedFilm, filme);
	}

	@Override
	public void setFilmInfoController(FXMLLoader loader) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setSitzplatzController(FXMLLoader loader) {
		// TODO Auto-generated method stub
		ControllerSitzplatzauswahl controller = loader.<ControllerSitzplatzauswahl>getController();
		controller.initData(clickedFilm, filme);
	}

	// @Override
	// public void setSitzplatzController(FXMLLoader loader) {
	// // TODO Auto-generated method stub
	//
	// }
	//
	// @Override
	// public void initData() {
	// // TODO Auto-generated method stub
	//
	// }

}
