package Platztypen;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Sitzplatz {
	private boolean belegt;
	private String platzID;
//platzID wurde zu String geändert, aber in modell steht es als int drin !!!
	@FXML
	private Pane sitzplaetze;
	
	public boolean isBelegt() {
		return belegt;
	}

	public void setBelegt(boolean belegt) {
		this.belegt = belegt;
	}

	public String getPlatzID() {
		return platzID;
	}

	public void setPlatzID(String platzID) {
		this.platzID = platzID;
	}

	public void erstelleSitzplatz(int i, int j, Stage primaryStage) {
		Button platz = new Button();
		int abstand = 30;
		if (i >= 4 && i < 8) {
			abstand = abstand + 25;
		} else if (i >= 8) {
			abstand = abstand + 30;
		}
		platz.setPrefSize(25, 25);
		platz.setLayoutX(130 + j * 30);
		platz.setLayoutY(52 + i * 30);
		platz.setId("Reihe: "+i+", Platz: "+j);
		platz.getStyleClass().removeAll("button");
		platz.getStyleClass().add("onClick");
		platzID = platz.getId();
		platz.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent e) {
//				Button x = (Button) e.getSource();
				if(platz.getStyleClass().get(0)=="clicked") {
					platz.getStyleClass().removeAll("clicked");
					platz.getStyleClass().add("onClick");
					belegt=false;
				}else {
					platz.getStyleClass().removeAll("onClick");
					platz.getStyleClass().add("clicked");
					belegt=true;
				}
			}
		});
		sitzplaetze.getChildren().add(platz);
		primaryStage.show();
	}
	
}
