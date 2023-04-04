/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tax;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author XeroS
 */
public class Results {

    public Scene getScene(Stage currentStage) {
        Button saveBtn = new Button("Save");
        Label resultLabel = new Label("result");
        VBox resultRoot = new VBox(resultLabel, saveBtn);
        saveBtn.setOnAction(e -> {
            
        });
        Scene resultScene = new Scene(resultRoot, 500, 150);
        return resultScene;
    }
}
