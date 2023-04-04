package tax;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
/**
 *
 * @author Brandon Yaeck
 */
public class Login {

	public Scene getScene(Stage currentStage) {
		UserList userList = new UserList();
		userList.readFromFile();


		Label emailLabel = new Label("Email Address");
		TextField emailField = new TextField();
		Label emailError = new Label("");
		emailError.setStyle("-fx-text-fill: red;");

		VBox emailBox = new VBox();
		emailBox.getChildren().addAll(emailLabel, emailField, emailError);
		emailBox.setPrefWidth(200);


		Label passwordLabel = new Label("Password");
		PasswordField passwordField = new PasswordField();
		Label passwordError = new Label("");
		passwordError.setStyle("-fx-text-fill: red;");

		VBox passwordBox = new VBox();
		passwordBox.getChildren().addAll(passwordLabel, passwordField, passwordError);
		passwordBox.setPrefWidth(200);


		Button loginButton = new Button("Log In");

		loginButton.setOnAction(e -> {
			// check if input email found
			User matchedUser = userList.matchEmail(emailField.getText());
			if (matchedUser != null) {
				// reset email error text if email found
				emailError.setText("");
				emailField.setStyle("");

				// check if input password matches the one assigned to the email
				if (new PasswordHandler().passwordMatches(passwordField.getText(), matchedUser)) {
					currentStage.setScene(new TaxForm().getScene(currentStage));

					// reset password error text if password found (TEMPORARY)
					passwordError.setText("");
					passwordField.setStyle("");
					System.out.println("LOGIN SUCCESS");
				} else {
					passwordError.setText("Password incorrect");
					passwordField.setStyle("-fx-text-box-border: red; -fx-focus-color: red");
				}
			} else {
				emailError.setText("Email address not found");
				emailField.setStyle("-fx-text-box-border: red; -fx-focus-color: red");
			}
		});

		// enter key submits in email/password fields
		emailField.addEventHandler(KeyEvent.KEY_PRESSED, e -> {
			if (e.getCode() == KeyCode.ENTER) {
				loginButton.fire();
			}
		});
		passwordField.addEventHandler(KeyEvent.KEY_PRESSED, e -> {
			if (e.getCode() == KeyCode.ENTER) {
				loginButton.fire();
			}
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


		VBox outerPanel = new VBox(10);
		outerPanel.setAlignment(Pos.CENTER);
		outerPanel.setFillWidth(false);
		outerPanel.setPadding(new Insets(20, 20, 20, 20));
		outerPanel.getChildren().addAll(emailBox, passwordBox, submitPanel);

		Scene scene = new Scene(outerPanel);

		currentStage.setTitle("Tax Login");
		return scene;
	}
}