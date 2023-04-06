package tax;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 *
 * @author Brandon Yaeck
 */
public class Popup {
	public static void error(Exception exception, String alertTitle, String alertMessage) {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle(alertTitle);
		alert.setHeaderText("");

		alert.setContentText(alertMessage + exception.getMessage());
		alert.showAndWait();
	}
}