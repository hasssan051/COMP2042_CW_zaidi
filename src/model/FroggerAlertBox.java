package model;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class FroggerAlertBox extends Alert{

	public FroggerAlertBox(AlertType alertType, String contentText, ButtonType[] buttons) {
		super(alertType, contentText, buttons);
		
	}

}
