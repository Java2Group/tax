package tax;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Brandon Yaeck
 */
public class TermsOfService {

	public Scene getScene(Stage currentStage) {

		Label tos = new Label("Your information will not be used for anything because this is a school project.");

		VBox tosPanel = new VBox();
		tosPanel.setStyle("-fx-background-color: white;");
		tosPanel.setAlignment(Pos.CENTER);
		tosPanel.getChildren().add(tos);

		Scene scene = new Scene(tosPanel, 500, 500);

		currentStage.setTitle("Terms of Service");
		return scene;
	}
}
