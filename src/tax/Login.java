package tax;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });


	Label emailLabel = new Label("Email Address");
	TextField emailField = new TextField();

	Label passwordLabel = new Label("Password");
	TextField passwordField = new TextField();

	Button loginButton = new Button("Log In");

        loginButton.setOnAction(e -> {
		
	});

	Text registerLink = new Text("Don't have an account? Click here to register.");

        StackPane root = new StackPane();
        root.getChildren().add(btn);
	VBox vb = new VBox();
	vb.getChildren().addAll(emailLabel, emailField, passwordLabel, passwordField, loginButton, registerLink);

        Scene scene = new Scene(vb, 300, 250);

        primaryStage.setTitle("Tax Login");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
