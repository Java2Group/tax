package tax;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 *
 * @author Abdulrahman Chalya
 */
public class GeneralDeductions extends Application {
    
    public Scene getScene(Stage currentStage, User user) {

	VBox welcomeArea = new VBox(10);
        welcomeArea.setAlignment(Pos.CENTER);
        welcomeArea.setPadding(new Insets(50, 20, 50, 20));

	Label welcomeText = new Label();
        welcomeText.setFont(new Font("Arial", 24));

	Label provinceText = new Label();
        provinceText.setFont(new Font("Arial", 24));

	welcomeText.setText("Welcome " + user.getFirstName() + " " + user.getLastName());
	provinceText.setText("Begin doing taxes for " + user.getRegion() + " residents");

	welcomeArea.getChildren().addAll(welcomeText, provinceText);


        Label label1 = new Label("General Deductions");
        label1.setFont(new Font("Arial", 24));
        TextField institution = new TextField();
        label1.setAlignment(Pos.CENTER_LEFT);
        label1.setPadding(new Insets(10, 20, 10, 20));

        Label label2 = new Label("Child care expenses");
        TextField childCareExpenses = new TextField("0");
        VBox vbox2 = new VBox(5, label2, childCareExpenses);
        vbox2.setAlignment(Pos.CENTER_LEFT);
        vbox2.setPadding(new Insets(10, 20, 10, 20));

        Label label3 = new Label("Medical expenses");
        TextField medicalExpenses = new TextField("0");
        VBox vbox3 = new VBox(5, label3, medicalExpenses);
        vbox3.setAlignment(Pos.CENTER_LEFT);
        vbox3.setPadding(new Insets(10, 20, 10, 20));

        Label label4 = new Label("Dental expenses");
        TextField dentalExpenses = new TextField("0");
        VBox vbox4 = new VBox(5, label4, dentalExpenses);
        vbox4.setAlignment(Pos.CENTER_LEFT);
        vbox4.setPadding(new Insets(10, 20, 10, 20));

        Label label5 = new Label("I certify that the information given on this return is correct, complete, and fully discloses my income.");
        CheckBox certify = new CheckBox();
        HBox hbox = new HBox(5, certify, label5);
        hbox.setAlignment(Pos.CENTER);
        hbox.setPadding(new Insets(10, 20, 10, 20));
        hbox.setAlignment(Pos.CENTER);

        // Create a GridPane to hold the VBox nodes
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(5);
        grid.setVgap(5);

        // Add the VBox nodes to the grid
        grid.add(label1, 0, 0);
        grid.add(vbox2, 0, 1);
        grid.add(vbox3, 0, 2);
        grid.add(vbox4, 0, 3);
        grid.add(hbox, 0, 4);

        // Create the calculate button
        Button nextButton = new Button("Next");
        nextButton.setOnAction(e -> {
		try {
			if ((Double.parseDouble(childCareExpenses.getText())) < 0 || (Double.parseDouble(medicalExpenses.getText())) < 0 || (Double.parseDouble(dentalExpenses.getText())) < 0) {
				Popup.error("Error", "Expenses cannot be negative.");
				return;
			}
		} catch (NumberFormatException exception) {
			Popup.error("Error", "All fields must contain numbers only.");
			return;
		}
		
		if (!certify.isSelected()) {
			Popup.error("Error", "You must click the checkbox.");
		} else {
			currentStage.setScene(new TaxForm().getScene(currentStage, user, childCareExpenses.getText(), medicalExpenses.getText(), dentalExpenses.getText()));
		}
        });

        Button backButton = new Button("Back");
        backButton.setOnAction(e -> { 
		currentStage.setScene(new Login().getScene(currentStage));
	});

        // Create an HBox to hold the buttons
        HBox buttonBox = new HBox(20);
	buttonBox.getChildren().addAll(backButton, nextButton);

        buttonBox.setAlignment(Pos.BOTTOM_CENTER);

        buttonBox.setPadding(
                new Insets(40, 20, 20, 20));

        // Create a Group to hold the GridPane and the HBox
        VBox root = new VBox();

        root.getChildren()
                .addAll(welcomeArea, grid, buttonBox);

        // Create the Scene and set it on the Stage
        Scene scene = new Scene(root, 1400, 600);

	currentStage.setTitle("General Deductions");

	return scene;
    }

    @Override
    public void start(Stage primaryStage) {
        User testingUser = new User();
	testingUser.setRegion("Ontario");
	testingUser.setFirstName("John");
	testingUser.setLastName("Smith");

        primaryStage.setScene(getScene(primaryStage, testingUser));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
