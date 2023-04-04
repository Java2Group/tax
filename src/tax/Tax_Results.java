/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package tax;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author XeroS
 */
public class Tax_Results extends Application {

    @Override
    public void start(Stage primaryStage) {
        Label label1 = new Label("Balance Owing/Refund:");



        // Create a GridPane to hold the VBox nodes
        StackPane pane = new StackPane();
        pane.getChildren().add(label1);

        // Create the calculate button
        Button SaveToFile = new Button("Save to File");
        SaveToFile.setOnAction(e -> {
            // Create a formatted string with the result
            String result;
            if (true) {
                result = String.format("Tax Refund: $%.2f\nUnemployment Insurance Benefits: $%.2f");
            } else {
                result = String.format("Taxes Owed: $%.2f\nUnemployment Insurance Benefits: $%.2f");
            }

            // Create a new window to display the result
            Stage resultStage = new Stage();
            Label resultLabel = new Label(result);
            Group resultRoot = new Group(resultLabel);
            Scene resultScene = new Scene(resultRoot, 300, 150);
            resultStage.setScene(resultScene);
            resultStage.show();
        });

        // Create an HBox to hold the button
        HBox buttonBox = new HBox(SaveToFile);

        buttonBox.setAlignment(Pos.BOTTOM_CENTER);

        buttonBox.setPadding(
                new Insets(40, 20, 20, 20));

        // Create a Group to hold the GridPane and the HBox
        VBox root = new VBox();

        root.getChildren()
                .addAll(pane, buttonBox);

        // Create the Scene and set it on the Stage
        Scene scene = new Scene(root, 500, 400);

        primaryStage.setScene(scene);

        primaryStage.setTitle(
                "TaxSoftware");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
