package tax;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * Results window that contains tax results and the option to save the results to a local text file.
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
        if (resultLabel.getText().contains("Owed")) {
            resultLabel.setTextFill(Color.RED);
        } else {
            resultLabel.setTextFill(Color.GREEN);
        }
        HBox resultBox = new HBox(resultLabel);
        resultBox.setPadding(new Insets(10, 0, 0, 0));
        resultBox.setAlignment(Pos.CENTER);
        VBox resultRoot = new VBox(resultBox, saveBox);
        
        //Creating a File chooser
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save");
        
        //Saving file with .txt extension to location specified by the user.
        saveBtn.setOnAction(e -> {
            FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Text Files (*.txt)", "*.txt");
            fileChooser.getExtensionFilters().add(extFilter);
            File file = fileChooser.showSaveDialog(resultStage);
            if (file != null) {
                try {
                    FileWriter writer = new FileWriter(file);
                    writer.write(Calculate.getResult()); 
                    writer.close();
                    resultLabel.setText("Results saved to file: " + file.getName());
                } catch (IOException exception) {
                    // Show an error message if there was an error writing to the file
		    Popup.error(exception, "Error", "Error saving result to file: ");
                }
            }
        });
        Scene resultScene = new Scene(resultRoot, 500, 200);
        resultStage.setScene(resultScene);
        resultStage.setTitle("Results");
        resultStage.initModality(Modality.APPLICATION_MODAL);
        resultStage.setResizable(false);
        resultStage.show();
    }
}
