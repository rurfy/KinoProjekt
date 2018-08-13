package Platztypen;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Sitzplatz {
	private boolean belegt;
	private int platzID;
	
	public boolean isBelegt() {
		return belegt;
	}
	public void setBelegt(boolean belegt) {
		this.belegt = belegt;
	}
	public int getPlatzID() {
		return platzID;
	}
	public void setPlatzID(int platzID) {
		this.platzID = platzID;
	}

	public void erstelleSitzplatz(int i, int j, Pane sitzplaetze) {
		Button platz = new Button();
		int abstand = 30;
		if (i >= 4 && i < 8) {
			abstand = abstand + 25;
		} else if (i >= 8) {
			abstand = abstand + 55;
		}
		platz.setPrefSize(25, 25);
		platz.setMaxSize(25, 25);
		platz.setMinSize(25, 25);
		platz.setLayoutX(130 + j * 30);
		platz.setLayoutY(52 + i * 30 + abstand);
		platz.setId("Reihe: " + i + ", Platz: " + j);
		platz.getStyleClass().removeAll("button");
		platz.getStyleClass().add("onClick");
//		platzID = platz.getId();
		//belegt[i][j]=false;
		platz.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent e) {
//				Button x = (Button) e.getSource();
				if (platz.getStyleClass().get(0) == "clicked") {
					platz.getStyleClass().removeAll("clicked");
					platz.getStyleClass().add("onClick");
					belegt = false;
				} else {
					platz.getStyleClass().removeAll("onClick");
					platz.getStyleClass().add("clicked");
					belegt = true;
					//vermeideLuecken(belegt, i, j);
				}
			}

//			private void vermeideLuecken(boolean[][] belegt, int i, int j) {
//				if (belegt[i][j] == true) {
//					if (j == 0 && belegt[i][j + 1] == false && belegt[i][j + 2]) {
//						System.out.println("LÜCKE!");
//					}
//					if (j == 1 && belegt[i][j + 1] == false && belegt[i][j + 2]) {
//						System.out.println("LÜCKE!");
//					}
//					if (j == 22 && belegt[i][j - 1] == false && belegt[i][j] == true) {
//						System.out.println("LÜCKE!");
//					}
//					if (j == 21 && belegt[i][j - 1] == false && belegt[i][j] == true) {
//						System.out.println("LÜCKE!");
//					}
//					if (j > 1 && j < 21 && ((belegt[i][j + 1] == false && belegt[i][j + 2] == true)
//							|| (belegt[i][j - 1] == false && belegt[i][j - 2] == true))) {
//						System.out.println("LÜCKE!");
//					}
//				}

//			}
		});
		sitzplaetze.getChildren().add(platz);
	}
}
