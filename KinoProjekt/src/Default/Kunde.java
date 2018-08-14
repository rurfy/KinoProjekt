package Default;

import Platztypen.Sitzplatz;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;

public class Kunde {
	private Sitzplatz platz;
	private int rabatt;
	
	public Sitzplatz getPlatz() {
		return platz;
	}
	public void setPlatz(Sitzplatz platz) {
		this.platz = platz;
	}
	public int getErmaessigung() {
		return rabatt;
	}
	public void setErmaessigung(int ermaessigung) {
		this.rabatt = ermaessigung;
	}
	
	public ComboBox<String> createNewComboBox() {
 		ComboBox<String> box = new ComboBox<String>();
		box.getItems().addAll("Erwachsener", "Kind");
		box.setPromptText("Tarif wählen");
		box.setEditable(false);
		box.setMaxWidth(Double.MAX_VALUE);
 		box.setButtonCell(new ListCell<String>() {
 			@Override
			protected void updateItem(String item, boolean empty) {
				super.updateItem(item, empty);
				if (empty || item == null) {
					setStyle("-fx-text-fill: rgb(0,198,187)");
				} else {
					setStyle("-fx-text-fill: rgb(0,198,187)");
					setText(item.toString());
				}
			}
 		});
		return box;
	}
	
	public Kunde(Sitzplatz sitzplatz, int rabatt) {
		this.platz = sitzplatz;
		this.rabatt = rabatt;
	}
	
}
