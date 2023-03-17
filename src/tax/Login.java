package tax;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
/**
 *
 * @author Brandon Yaeck
 */
public class Login extends Application {

    @Override
    public void start(Stage primaryStage) {

	Label emailLabel = new Label("Email Address");
	HBox emailLabelHbox = new HBox();
	emailLabelHbox.getChildren().add(emailLabel);

	TextField emailField = new TextField();

	Label passwordLabel = new Label("Password");
	HBox passwordLabelHbox = new HBox();
	passwordLabelHbox.getChildren().add(passwordLabel);

	PasswordField passwordField = new PasswordField();

	Button loginButton = new Button("Log In");

        loginButton.setOnAction(e -> {
		System.out.println(emailField.getText());
		System.out.println(passwordField.getText());
	});

	Button registerLink = new Button("Don't have an account? Click here to register.");
	registerLink.setStyle("-fx-background-color: rgba(0,0,0,0)");

        registerLink.setOnAction(e -> {
		System.out.println("Test2");
	});

	VBox vb = new VBox();
	vb.getChildren().addAll(emailLabelHbox, emailField, passwordLabelHbox, passwordField, loginButton, registerLink);
	vb.setAlignment(Pos.CENTER);

        Scene scene = new Scene(vb, 500, 400);

        primaryStage.setTitle("Tax Login");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
