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
import javafx.stage.Stage;

/**
 *
 * @author Michael Sousa
 */
public class T2202 extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Label label1 = new Label("Name of educational institution");
        TextField institution = new TextField();
        VBox vbox1 = new VBox(5, label1, institution);
        vbox1.setAlignment(Pos.CENTER_LEFT);
        vbox1.setPadding(new Insets(10, 20, 10, 20));

        Label label2 = new Label("Student number");
        TextField studentNum = new TextField();
        VBox vbox2 = new VBox(5, label2, studentNum);
        vbox2.setAlignment(Pos.CENTER_LEFT);
        vbox2.setPadding(new Insets(10, 20, 10, 20));

        Label label3 = new Label("Number of months full-time");
        TextField fullMonths = new TextField();
        VBox vbox3 = new VBox(5, label3, fullMonths);
        vbox3.setAlignment(Pos.CENTER_LEFT);
        vbox3.setPadding(new Insets(10, 20, 10, 20));

        Label label4 = new Label("Name of program or course");
        TextField program = new TextField();
        VBox vbox4 = new VBox(5, label4, program);
        vbox4.setAlignment(Pos.CENTER_LEFT);
        vbox4.setPadding(new Insets(10, 20, 10, 20));

        Label label5 = new Label("Address of educational institution");
        TextField address = new TextField();
        VBox vbox5 = new VBox(5, label5, address);
        vbox5.setAlignment(Pos.CENTER_LEFT);
        vbox5.setPadding(new Insets(10, 20, 10, 20));

        Label label6 = new Label("Eligible tution fees");
        TextField tuition = new TextField();
        VBox vbox6 = new VBox(5, label6, tuition);
        vbox6.setAlignment(Pos.CENTER_LEFT);
        vbox6.setPadding(new Insets(10, 20, 10, 20));

        Label label7 = new Label("Number of months part-time");
        TextField partMonths = new TextField();
        VBox vbox7 = new VBox(5, label7, partMonths);
        vbox7.setAlignment(Pos.CENTER_LEFT);
        vbox7.setPadding(new Insets(10, 20, 10, 20));

        Label label8 = new Label("I certify that the information given on this return is correct and complete.");
        CheckBox certify = new CheckBox();
        HBox hbox = new HBox(5, certify,label8);
        hbox.setPadding(new Insets(10, 20, 10, 20));
        hbox.setAlignment(Pos.CENTER);

        // Create a GridPane to hold the VBox nodes
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(5);
        grid.setVgap(5);

        // Add the VBox nodes to the grid
        grid.add(vbox1, 0, 0);
        grid.add(vbox2, 0, 1);
        grid.add(vbox3, 0, 2);
        grid.add(vbox4, 0, 3);
        grid.add(vbox5, 1, 0);
        grid.add(vbox6, 1, 1);
        grid.add(vbox7, 1, 2);
        

        // Create the calculate button
        // Create the calculate button
        Button calcButton = new Button("Calculate");
        calcButton.setOnAction(e -> {
            TaxController.validateT2202(institution, studentNum, fullMonths, program, address, tuition, partMonths,  certify);
        });

        // Create an HBox to hold the button
        HBox buttonBox = new HBox(calcButton);

        buttonBox.setAlignment(Pos.BOTTOM_CENTER);

        buttonBox.setPadding(
                new Insets(40, 20, 20, 20));

        // Create a Group to hold the GridPane and the HBox
        VBox root = new VBox();

        root.getChildren()
                .addAll(grid, hbox,buttonBox);

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
