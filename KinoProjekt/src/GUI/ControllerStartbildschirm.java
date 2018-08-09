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
import javafx.scene.control.Labeled;
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

	
	private String alarm = "";
	



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

	
//	public void test1 (String s) {
//		//System.out.println(p.getId());
//		for (int i = 0; i<filme.size(); i++) {
//			if (s.equals(filme.get(i).getTitel())) {
//				System.out.println(Double.toString(filme.get(i).getDauer()));
//				//dauer.setText(Double.toString(filme.get(i).getDauer()));
//				titel.setText("test");
//				fsk.setText(Integer.toString(filme.get(i).getFsk()));
//				bild.setImage(new Image(filme.get(i).getBildURL()));
//				genre.setText(filme.get(i).getGenre());
//				System.out.println("Erfolg");
//			}
//		}
//	}
	
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
			in.close();

			Pane p = (Pane) e.getSource();
			initFilmRec(p);
		} 
		catch (IOException | ClassNotFoundException e1) {

			// TODO: handle exception
		}

	}

	
	private void initFilmRec(Pane p) {
		for (Node node : p.getChildren()) {
			if (node instanceof Pane || node instanceof HBox || node instanceof VBox) {
				initFilmRec((Pane) node);

			}
			else if (node instanceof Label) {
		        alarm = ((Label) node).getText();
		    }
//		    else if (node instanceof ImageView) {
//				((ImageView) node).setImage(new Image(film.getBildURL()));
//				
//		    }
		}
	}

	@FXML
	public void zurFilmInfo(MouseEvent e) {

		inital(e);
		//Pane p = (Pane) e.getSource();

		setNewScene(FILMINFO, filmTitel1);
		//System.out.println(alarm);
//		test1(alarm);
	}

	@FXML
	public void zurSitzplatzAuswahl(ActionEvent e) {
		Button b = (Button) e.getSource();
		System.out.println(b.getText());
		setNewScene(SITZPLATZAUSWAHL, filmTitel1);
	}

	
//	@FXML
//	public void zurFilmInfo(ActionEvent e) {
//		 TODO Auto-generated method stub
//		init();
//		Pane p = (Pane) e.getSource();
//		setNewScene(FILMINFO, filmTitel1);
//		
//	}
	

	@Override
	public void zumStartBildschirm(ActionEvent e) {
		// TODO Auto-generated method stub

	}


}
