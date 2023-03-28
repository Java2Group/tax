package tax;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
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
	});


	Button registerLink = new Button("Don't have an account? Click here to register.");
	registerLink.setStyle("-fx-background-color: rgba(0,0,0,0)");

        registerLink.setOnAction(e -> {
		System.out.println("Go to registration");
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

        primaryStage.setTitle("Tax Login");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
