package tax;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Main class used to launch the JavaFX program using scenes returned from other classes.
 *
 * @author Brandon Yaeck
 */
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setScene(new Login().getScene(primaryStage));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
