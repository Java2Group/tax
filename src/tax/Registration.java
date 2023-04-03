
package tax;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
/**
 *
 * @author Brandon Yaeck
 */
public class Registration {

    public Scene getScene(Stage currentStage) {

	InputValidator validator = new InputValidator();


		Label firstNameLabel = new Label("First Name");

		TextField firstNameField = new TextField();
		firstNameField.setPromptText("");

		firstNameField.setTextFormatter(validator.firstNameFormatter);

		// clear empty field error styling if input
		firstNameField.setOnKeyTyped(e -> {
			firstNameField.setStyle("");
		});

	VBox firstNameBox = new VBox();
	firstNameBox.getChildren().addAll(firstNameLabel, firstNameField);



		Label lastNameLabel = new Label("Last Name");

		TextField lastNameField = new TextField();
		lastNameField.setPromptText("");

		lastNameField.setTextFormatter(validator.lastNameFormatter);

		// clear empty field error styling if input
		lastNameField.setOnKeyTyped(e -> {
			lastNameField.setStyle("");
		});

	VBox lastNameBox = new VBox();
	lastNameBox.getChildren().addAll(lastNameLabel, lastNameField);



		Label dobLabel = new Label("Date of Birth");
		TextField dobField = new TextField();
		dobField.setPromptText("yyyy-mm-dd");

		Label dobError = new Label();
		dobError.setStyle("-fx-text-fill: red;");

		VBox dobErrorBox = new VBox();
		dobErrorBox.getChildren().addAll(dobError);
		dobErrorBox.setStyle("-fx-padding: 0 0 5px 0;");
		dobErrorBox.setAlignment(Pos.BOTTOM_LEFT);

		dobField.setTextFormatter(validator.isoDateFormatter);

		dobField.setOnKeyTyped(e -> {
			validator.validateDate(dobField, dobError);
		});

	VBox dobBox = new VBox();
	dobBox.getChildren().addAll(dobLabel, dobField);



		Label streetLabel = new Label("Street Address");

		TextField streetField = new TextField();
		streetField.setPromptText("");

		streetField.setTextFormatter(validator.streetFormatter);

		// clear empty field error styling if input
		streetField.setOnKeyTyped(e -> {
			streetField.setStyle("");
		});

	VBox streetBox = new VBox();
	streetBox.getChildren().addAll(streetLabel, streetField);

		Label cityLabel = new Label("City");

		TextField cityField = new TextField();
		cityField.setPromptText("");

		cityField.setTextFormatter(validator.cityFormatter);

		// clear empty field error styling if input
		cityField.setOnKeyTyped(e -> {
			cityField.setStyle("");
		});

	VBox cityBox = new VBox();
	cityBox.getChildren().addAll(cityLabel, cityField);


		Label regionLabel = new Label("Province / Territory");

		ComboBox<String> regionField = new ComboBox<String>();
		regionField.setVisibleRowCount(InputValidator.regionList.length);
		regionField.getItems().addAll(InputValidator.regionList);
		regionField.setPromptText("Select");
		// changes size when clicking for some reason so enforcing a consistent size
		regionField.setMinWidth(200);
		regionField.setMaxWidth(200);

		// clear empty field error styling if input
		regionField.setOnAction(e -> {
			regionField.setStyle("");
		});

	VBox regionBox = new VBox();
	regionBox.getChildren().addAll(regionLabel, regionField);


		Label postLabel = new Label("Postal Code");

		TextField postField = new TextField();
		postField.setPromptText("A1A 1A1");

		Label postError = new Label();
		postError.setStyle("-fx-text-fill: red;");

		VBox postErrorBox = new VBox();
		postErrorBox.getChildren().addAll(postError);
		postErrorBox.setStyle("-fx-padding: 0 0 5px 0;");
		postErrorBox.setAlignment(Pos.BOTTOM_LEFT);

		postField.setTextFormatter(validator.postFormatter);

		// clear empty field error styling if input
		postField.setOnKeyTyped(e -> {
			postField.setStyle("");
			validator.validatePost(postField, postError);
		});

	VBox postBox = new VBox();
	postBox.getChildren().addAll(postLabel, postField);

		Label phoneLabel = new Label("Phone Number");

		TextField phoneField = new TextField();
		phoneField.setPromptText("");

		Label phoneError = new Label();
		phoneError.setStyle("-fx-text-fill: red;");

		VBox phoneErrorBox = new VBox();
		phoneErrorBox.getChildren().addAll(phoneError);
		phoneErrorBox.setStyle("-fx-padding: 0 0 5px 0;");
		phoneErrorBox.setAlignment(Pos.BOTTOM_LEFT);

		phoneField.setTextFormatter(validator.phoneFormatter);

		// clear empty field error styling if input
		phoneField.setOnKeyTyped(e -> {
			phoneField.setStyle("");
		});

	VBox phoneBox = new VBox();
	phoneBox.getChildren().addAll(phoneLabel, phoneField);

		Label emailLabel = new Label("Email Address");

		TextField emailField = new TextField();
		emailField.setPromptText("");

		Label emailError = new Label();
		emailError.setStyle("-fx-text-fill: red;");

		VBox emailErrorBox = new VBox();
		emailErrorBox.getChildren().addAll(emailError);
		emailErrorBox.setStyle("-fx-padding: 0 0 5px 0;");
		emailErrorBox.setAlignment(Pos.BOTTOM_LEFT);

		// clear empty field error styling if input
		emailField.setOnKeyTyped(e -> {
			emailField.setStyle("");
		});

	VBox emailBox = new VBox();
	emailBox.getChildren().addAll(emailLabel, emailField);

	    

		Label passwordLabel = new Label("Password");

		PasswordField passwordField = new PasswordField();
		passwordField.setPromptText("");

		Label passwordError = new Label();
		passwordError.setStyle("-fx-text-fill: red;");

		VBox passwordErrorBox = new VBox();
		passwordErrorBox.getChildren().addAll(passwordError);
		passwordErrorBox.setStyle("-fx-padding: 0 0 5px 0;");
		passwordErrorBox.setAlignment(Pos.BOTTOM_LEFT);

		passwordField.setTextFormatter(validator.passwordFormatter);

		// clear empty field error styling if input
		passwordField.setOnKeyTyped(e -> {
			passwordField.setStyle("");
		});

	VBox passwordBox = new VBox();
	passwordBox.getChildren().addAll(passwordLabel, passwordField);

		Label rePasswordLabel = new Label("Re-enter Password");

		PasswordField rePasswordField = new PasswordField();
		rePasswordField.setPromptText("");

		// clear empty field error styling if input
		rePasswordField.setOnKeyTyped(e -> {
			rePasswordField.setStyle("");
		});

	VBox rePasswordBox = new VBox();
	rePasswordBox.getChildren().addAll(rePasswordLabel, rePasswordField);

	// Input field grid
	GridPane inputArea = new GridPane();
	inputArea.setHgap(10);
	inputArea.setVgap(10);

	inputArea.add(firstNameBox, 0, 1);
	inputArea.add(lastNameBox, 1, 1);
	inputArea.add(dobBox, 0, 2);
	inputArea.add(dobErrorBox, 1, 2);
	inputArea.add(streetBox, 0, 3);
	inputArea.add(cityBox, 0, 4);
	inputArea.add(regionBox, 1, 4);
	inputArea.add(postBox, 0, 5);
	inputArea.add(postErrorBox, 1, 5);
	inputArea.add(phoneBox, 0, 6);
	inputArea.add(phoneErrorBox, 1, 6);
	inputArea.add(emailBox, 0, 7);
	inputArea.add(emailErrorBox, 1, 7);
	inputArea.add(passwordBox, 0, 8);
	inputArea.add(passwordErrorBox, 1, 8);
	inputArea.add(rePasswordBox, 0, 9);

	GridPane.setColumnSpan(streetBox, 2);
	// keep the 2 columns even width by making column1 50% and therefore column2 also 50%
	ColumnConstraints column1 = new ColumnConstraints();
	column1.setPercentWidth(50);
	inputArea.getColumnConstraints().add(column1);
	


	CheckBox tosCheck = new CheckBox("I have read and agree to the ");

	Button tosLink = new Button("Terms of Service");
	tosLink.setStyle("-fx-background-color: rgba(0,0,0,0); -fx-text-fill: blue");
	tosLink.setPadding(new Insets(0, 0, 0, 0));

        tosLink.setOnAction(e -> {
		Stage tosBox = new Stage();
		tosBox.setScene(new TermsOfService().getScene(tosBox));
		tosBox.show();
	});

	HBox tosArea = new HBox();
	tosArea.setAlignment(Pos.CENTER_LEFT);
	tosArea.getChildren().addAll(tosCheck, tosLink);
	
	Button registerButton = new Button("Register");
	//registerButton.setDisable(true);

	Label overallError = new Label();
	overallError.setStyle("-fx-text-fill: red;");

	HBox registerArea = new HBox(15);
	registerArea.setAlignment(Pos.CENTER_LEFT);
	registerArea.getChildren().addAll(registerButton, overallError);




	UserList userList = new UserList();
        registerButton.setOnAction(e -> {
		validator.validatePassword(passwordField, rePasswordField, passwordError);
		validator.validateEmail(emailField, emailError);
		validator.validatePhone(phoneField, phoneError);

		if (validator.allValid(overallError, tosCheck, dobField, dobError, postField, postError, regionField, firstNameField, lastNameField, streetField, cityField, emailField)) {
			userList.createUser(true, firstNameField.getText(), lastNameField.getText(), dobField.getText(), streetField.getText(), cityField.getText(), regionField.getValue(), postField.getText(), phoneField.getText(), emailField.getText(), passwordField.getText());
			currentStage.setScene(new Login().getScene(currentStage));
		}
	});


	
	VBox submitPanel = new VBox(10);
	submitPanel.getChildren().addAll(tosArea, registerArea);

	VBox alignPanel = new VBox(30);
	alignPanel.getChildren().addAll(inputArea, submitPanel);

	VBox outerPanel = new VBox();
	outerPanel.setAlignment(Pos.CENTER);
	outerPanel.setFillWidth(false);
	outerPanel.setPadding(new Insets(20, 20, 20, 20));
	outerPanel.getChildren().addAll(alignPanel);

        Scene scene = new Scene(outerPanel);

	currentStage.setTitle("User Registration");
	return scene;
    }
}
