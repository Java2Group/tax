package tax;

import java.io.FileWriter;
import java.io.IOException;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author Michael Sousa
 */
public class Results extends Application {

    @Override
    public void start(Stage primaryStage) {
        Stage resultStage = new Stage();
        Button saveBtn = new Button("Save");
        HBox saveBox = new HBox(saveBtn);
        saveBox.setPadding(new Insets(40, 20, 20, 20));
        saveBox.setAlignment(Pos.CENTER);
        Label resultLabel = new Label(Calculate.getResult());
        if(resultLabel.getText().contains("Owed")){
            resultLabel.setTextFill(Color.RED);
        }else{
            resultLabel.setTextFill(Color.GREEN);
        }
        HBox resultBox = new HBox(resultLabel);
        resultBox.setPadding(new Insets(10,0,0,0));
        resultBox.setAlignment(Pos.CENTER);
        VBox resultRoot = new VBox(resultBox, saveBox);
        saveBtn.setOnAction(e -> {
            try {

                // Open a file named "tax_result.txt" in write mode
                FileWriter writer = new FileWriter("taxresult.txt");
                // Write the result string to the file
                writer.write(Calculate.getResult());
                // Close the file
                writer.close();
                System.out.println("Result saved to file: taxresult.txt");
            } catch (IOException exception) {
                // Show an error message if there was an error writing to the file
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Error saving result to file: " + exception.getMessage());
                alert.showAndWait();
            }
        });
        Scene resultScene = new Scene(resultRoot, 500, 200);
        resultStage.setScene(resultScene);
        resultStage.setTitle("Results");
        resultStage.initModality(Modality.WINDOW_MODAL);
        resultStage.show();
    }
}
