
package tax;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
/**
 *
 * @author Brandon Yaeck
 */
public class Registration extends Application {

    @Override
    public void start(Stage primaryStage) {

	InputValidator validator = new InputValidator();


		Label firstNameLabel = new Label("First Name");

		TextField firstNameField = new TextField();
		firstNameField.setPromptText("");

	VBox firstNameBox = new VBox();
	firstNameBox.getChildren().addAll(firstNameLabel, firstNameField);



		Label lastNameLabel = new Label("Last Name");

		TextField lastNameField = new TextField();
		lastNameField.setPromptText("");

	VBox lastNameBox = new VBox();
	lastNameBox.getChildren().addAll(lastNameLabel, lastNameField);



		Label dobLabel = new Label("Date of Birth");
		TextField dobField = new TextField();
		dobField.setPromptText("yyyy-mm-dd");


		dobField.setTextFormatter(validator.isoDateFormatter);

		dobField.setOnKeyTyped(e -> {
			validator.validateDate(dobField);
		});

	VBox dobBox = new VBox();
	dobBox.getChildren().addAll(dobLabel, dobField);



		Label streetLabel = new Label("Street Address");

		TextField streetField = new TextField();
		streetField.setPromptText("");

	VBox streetBox = new VBox();
	streetBox.getChildren().addAll(streetLabel, streetField);

		Label cityLabel = new Label("City");

		TextField cityField = new TextField();
		cityField.setPromptText("");

	VBox cityBox = new VBox();
	cityBox.getChildren().addAll(cityLabel, cityField);


		Label regionLabel = new Label("Province");

		TextField regionField = new TextField();
		regionField.setPromptText("");

	VBox regionBox = new VBox();
	regionBox.getChildren().addAll(regionLabel, regionField);


		Label postLabel = new Label("Postal Code");

		TextField postField = new TextField();
		postField.setPromptText("");

	VBox postBox = new VBox();
	postBox.getChildren().addAll(postLabel, postField);

		Label phoneLabel = new Label("Phone Number");

		TextField phoneField = new TextField();
		phoneField.setPromptText("");

	VBox phoneBox = new VBox();
	phoneBox.getChildren().addAll(phoneLabel, phoneField);

		Label emailLabel = new Label("Email Address");

		TextField emailField = new TextField();
		emailField.setPromptText("");

	VBox emailBox = new VBox();
	emailBox.getChildren().addAll(emailLabel, emailField);

	    

		Label passwordLabel = new Label("Password");

		PasswordField passwordField = new PasswordField();
		passwordField.setPromptText("");

	VBox passwordBox = new VBox();
	passwordBox.getChildren().addAll(passwordLabel, passwordField);

		Label rePasswordLabel = new Label("Re-enter Password");

		PasswordField rePasswordField = new PasswordField();
		rePasswordField.setPromptText("");

	VBox rePasswordBox = new VBox();
	rePasswordBox.getChildren().addAll(rePasswordLabel, rePasswordField);

	// Input field grid
	GridPane inputArea = new GridPane();
	inputArea.setHgap(10);
	inputArea.setVgap(10);

	inputArea.add(firstNameBox, 0, 1);
	inputArea.add(lastNameBox, 1, 1);
	inputArea.add(dobBox, 0, 2);
	inputArea.add(streetBox, 0, 3);
	inputArea.add(cityBox, 0, 4);
	inputArea.add(regionBox, 1, 4);
	inputArea.add(postBox, 0, 5);
	inputArea.add(phoneBox, 0, 6);
	inputArea.add(emailBox, 0, 7);
	inputArea.add(passwordBox, 0, 8);
	inputArea.add(rePasswordBox, 0, 9);

	GridPane.setColumnSpan(streetBox, 2);


	CheckBox tosCheck = new CheckBox("I have read and agree to the ");

	Button tosLink = new Button("Terms of Service");
	tosLink.setStyle("-fx-background-color: rgba(0,0,0,0); -fx-text-fill: blue");
	tosLink.setPadding(new Insets(0, 0, 0, 0));

        tosLink.setOnAction(e -> {
		System.out.println("TOS IS NOTHING");
	});

	HBox tosArea = new HBox();
	tosArea.setAlignment(Pos.CENTER_LEFT);
	tosArea.getChildren().addAll(tosCheck, tosLink);
	
	Button registerButton = new Button("Register");

        registerButton.setOnAction(e -> {
		System.out.println("REGISTER");
	});

	
	VBox submitPanel = new VBox(10);
	submitPanel.getChildren().addAll(tosArea, registerButton);

	VBox alignPanel = new VBox(30);
	alignPanel.getChildren().addAll(inputArea, submitPanel);

	VBox outerPanel = new VBox();
	outerPanel.setAlignment(Pos.CENTER);
	outerPanel.setFillWidth(false);
	outerPanel.setPadding(new Insets(20, 20, 20, 20));
	outerPanel.getChildren().addAll(alignPanel);

        Scene scene = new Scene(outerPanel);

        primaryStage.setTitle("User Registration");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
