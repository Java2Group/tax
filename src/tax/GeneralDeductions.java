/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package tax;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 *
 * @author Abdulrahman Chalya
 */
public class GeneralDeductions extends Application {
    
    public Scene getScene(Stage currentStage) {
        UserList userList = new UserList();


        Label label1 = new Label("General Deductions");
        label1.setFont(new Font("Arial", 24));
        TextField institution = new TextField();
        label1.setAlignment(Pos.CENTER_LEFT);
        label1.setPadding(new Insets(10, 20, 10, 20));

        Label label2 = new Label("Child care expenses");
        TextField cpp = new TextField();
        VBox vbox2 = new VBox(5, label2, cpp);
        vbox2.setAlignment(Pos.CENTER_LEFT);
        vbox2.setPadding(new Insets(10, 20, 10, 20));

        Label label3 = new Label("Medical expenses");
        TextField eiPremium = new TextField();
        VBox vbox3 = new VBox(5, label3, eiPremium);
        vbox3.setAlignment(Pos.CENTER_LEFT);
        vbox3.setPadding(new Insets(10, 20, 10, 20));

        Label label4 = new Label("Dental expenses");
        TextField rpp = new TextField();
        VBox vbox4 = new VBox(5, label4, rpp);
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
		currentStage.setScene(new TaxForm().getScene(currentStage));
        });

        // Create an HBox to hold the button
        HBox buttonBox = new HBox(nextButton);

        buttonBox.setAlignment(Pos.BOTTOM_CENTER);

        buttonBox.setPadding(
                new Insets(40, 20, 20, 20));

        // Create a Group to hold the GridPane and the HBox
        VBox root = new VBox();

        root.getChildren()
                .addAll(grid, buttonBox);

        // Create the Scene and set it on the Stage
        Scene scene = new Scene(root, 1400, 600);

	currentStage.setTitle("General Deductions");

	return scene;
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setScene(getScene(primaryStage));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
