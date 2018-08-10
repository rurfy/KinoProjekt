package GUI;

import java.io.File;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.ResourceBundle;

import Default.Film;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class ControllerFilminfo extends MainController implements Initializable{
	

	private final String STARTBILDSCHIRM = "StartBildschirm.fxml";
	private final String SITZPLATZAUSWAHL = "SitzplatzAuswahl.fxml";
	
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
	
	@FXML
	private Button filmInfoZurueck;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	
	@FXML
	public void zurSitzplatzAuswahl(ActionEvent e) {
		setNewScene(SITZPLATZAUSWAHL, filmInfoZurueck);
	}


//	@Override
//	public void zurFilmInfo(ActionEvent e) {
//		// TODO Auto-generated method stub
//		
//	}

	public void initData (String s, ArrayList<Film> filme) {
		for (int i = 0; i<filme.size(); i++) {
			if (s.equals(filme.get(i).getTitel())) {
				DecimalFormat df = new DecimalFormat("#.00");
				dauer.setText("Dauer: " + df.format(filme.get(i).getDauer()) + " h");
				titel.setText("Titel: " + filme.get(i).getTitel());
				fsk.setText("FSK: " + Integer.toString(filme.get(i).getFsk()));
				File file = new File("@" + filme.get(i).getBildURL());
				bild.setImage(new Image(file.toURI().toString()));
				genre.setText("Genre: " + filme.get(i).getGenre());
			}
		}
	}

	@FXML
	public void zumStartBildschirm(ActionEvent e) {
		setNewScene(STARTBILDSCHIRM, filmInfoZurueck);
	}

	@Override
	public void zurFilmInfo(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void setNewScene(String fxml, Node c) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void setStartController(FXMLLoader loader) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void setFilmInfoController(FXMLLoader loader) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void setSitzplatzController(FXMLLoader loader) {
		// TODO Auto-generated method stub
		
	}


//	@Override
//	public void setSitzplatzController(FXMLLoader loader) {
//		// TODO Auto-generated method stub
//		
//	}


}
