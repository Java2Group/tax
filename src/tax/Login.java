package tax;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
/**
 *
 * @author Brandon Yaeck
 */
public class Login {

	public Scene getScene(Stage currentStage) {
		Label emailLabel = new Label("Email Address");
		TextField emailField = new TextField();

		VBox emailBox = new VBox();
		emailBox.getChildren().addAll(emailLabel, emailField);
		emailBox.setPrefWidth(200);


		Label passwordLabel = new Label("Password");
		PasswordField passwordField = new PasswordField();

		VBox passwordBox = new VBox();
		passwordBox.getChildren().addAll(passwordLabel, passwordField);
		passwordBox.setPrefWidth(200);


		Button loginButton = new Button("Log In");

		loginButton.setOnAction(e -> {
			System.out.println(emailField.getText());
			System.out.println(passwordField.getText());
			//currentStage.setTitle("T4");
			//currentStage.setScene(new T4().getScene(currentStage));
		});

		Button registerLink = new Button("Don't have an account? Click here to register.");
		registerLink.setStyle("-fx-background-color: rgba(0,0,0,0); -fx-text-fill: rgba(0,0,0,100)");

		registerLink.setOnAction(e -> {
			currentStage.setScene(new Registration().getScene(currentStage));
		});
		registerLink.setOnMouseEntered(e -> {
			registerLink.setStyle("-fx-background-color: rgba(0,0,0,0); -fx-text-fill: rgba(0,0,255,100)");
			registerLink.setCursor(Cursor.HAND);
		});
		registerLink.setOnMouseExited(e -> {
			registerLink.setStyle("-fx-background-color: rgba(0,0,0,0); -fx-text-fill: rgba(0,0,0,100)");
		});


		VBox submitPanel = new VBox(10);
		submitPanel.setAlignment(Pos.CENTER);
		submitPanel.getChildren().addAll(loginButton, registerLink);


		VBox outerPanel = new VBox(20);
		outerPanel.setAlignment(Pos.CENTER);
		outerPanel.setFillWidth(false);
		outerPanel.setPadding(new Insets(20, 20, 20, 20));
		outerPanel.getChildren().addAll(emailBox, passwordBox, submitPanel);

		Scene scene = new Scene(outerPanel);

		currentStage.setTitle("Tax Login");
		return scene;
	}
}