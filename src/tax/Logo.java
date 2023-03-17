
package tax;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
/**
 *
 * @author b
 */




import javafx.application.Application;
import javafx.stage.Stage;

public class Logo extends Application {
	public Logo() {
		System.out.println("Test constructor is invoked");
	}

	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) {
		System.out.println("start method is invoked");
	}

	public static void main(String[] args) {
		System.out.println("launch application");
		Application.launch(args);
	}
}