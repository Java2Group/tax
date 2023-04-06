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
public class TaxForm extends Application {

    public Scene getScene(Stage currentStage, User user, String childCareExpenses, String medicalExpenses, String dentalExpenses) {
        Label label1 = new Label("Employment Income");
        TextField income = new TextField("0");
        VBox vbox1 = new VBox(5, label1, income);
        vbox1.setAlignment(Pos.CENTER_LEFT);
        vbox1.setPadding(new Insets(10, 20, 10, 20));

        Label label2 = new Label("Employee's CPP contributions");
        TextField cpp = new TextField("0");
        VBox vbox2 = new VBox(5, label2, cpp);
        vbox2.setAlignment(Pos.CENTER_LEFT);
        vbox2.setPadding(new Insets(10, 20, 10, 20));

        Label label3 = new Label("Employee's EI premiums");
        TextField eiPremium = new TextField("0");
        VBox vbox3 = new VBox(5, label3, eiPremium);
        vbox3.setAlignment(Pos.CENTER_LEFT);
        vbox3.setPadding(new Insets(10, 20, 10, 20));

        Label label4 = new Label("RPP contributions");
        TextField rpp = new TextField("0");
        VBox vbox4 = new VBox(5, label4, rpp);
        vbox4.setAlignment(Pos.CENTER_LEFT);
        vbox4.setPadding(new Insets(10, 20, 10, 20));

        Label label5 = new Label("Income tax deducted");
        TextField taxDeducted = new TextField("0");
        VBox vbox5 = new VBox(5, label5, taxDeducted);
        vbox5.setAlignment(Pos.CENTER_LEFT);
        vbox5.setPadding(new Insets(10, 20, 10, 20));

        Label label6 = new Label("EI insurable earnings");
        TextField insurable = new TextField("0");
        VBox vbox6 = new VBox(5, label6, insurable);
        vbox6.setAlignment(Pos.CENTER_LEFT);
        vbox6.setPadding(new Insets(10, 20, 10, 20));

        Label label7 = new Label("Union dues");
        TextField union = new TextField("0");
        VBox vbox7 = new VBox(5, label7, union);
        vbox7.setAlignment(Pos.CENTER_LEFT);
        vbox7.setPadding(new Insets(10, 20, 10, 20));

        Label label8 = new Label("Charitable donations");
        TextField donations = new TextField("0");
        VBox vbox8 = new VBox(5, label8, donations);
        vbox8.setAlignment(Pos.CENTER_LEFT);
        vbox8.setPadding(new Insets(10, 20, 10, 20));

        Label label9 = new Label("Actual eligible dividends");
        TextField eligibleDividends = new TextField("0");
        VBox vbox9 = new VBox(5, label9, eligibleDividends);
        vbox9.setAlignment(Pos.CENTER_LEFT);
        vbox9.setPadding(new Insets(10, 20, 10, 20));

        Label label10 = new Label("Actual dividends other than eligible");
        TextField otherDividends = new TextField("0");
        VBox vbox10 = new VBox(5, label10, otherDividends);
        vbox10.setAlignment(Pos.CENTER_LEFT);
        vbox10.setPadding(new Insets(10, 20, 10, 20));

        Label label11 = new Label("Tax credit for eligible dividends");
        TextField eligibleCredit = new TextField("0");
        VBox vbox11 = new VBox(5, label11, eligibleCredit);
        vbox11.setAlignment(Pos.CENTER_LEFT);
        vbox11.setPadding(new Insets(10, 20, 10, 20));

        Label label12 = new Label("Interest from Canadian sources");
        TextField interest = new TextField("0");
        VBox vbox12 = new VBox(5, label12, interest);
        vbox12.setAlignment(Pos.CENTER_LEFT);
        vbox12.setPadding(new Insets(10, 20, 10, 20));

        Label label13 = new Label("Taxable amount of eligible dividends");
        TextField eligibleTax = new TextField("0");
        VBox vbox13 = new VBox(5, label13, eligibleTax);
        vbox13.setAlignment(Pos.CENTER_LEFT);
        vbox13.setPadding(new Insets(10, 20, 10, 20));

        Label label14 = new Label("Taxable amount of dividends other than eligible");
        TextField otherTax = new TextField("0");
        VBox vbox14 = new VBox(5, label14, otherTax);
        vbox14.setAlignment(Pos.CENTER_LEFT);
        vbox14.setPadding(new Insets(10, 20, 10, 20));

        Label label15 = new Label("Tax credit for dividends other than eligible");
        TextField otherCredit = new TextField("0");
        VBox vbox15 = new VBox(5, label15, otherCredit);
        vbox15.setAlignment(Pos.CENTER_LEFT);
        vbox15.setPadding(new Insets(10, 20, 10, 20));

        Label label16 = new Label("Capital gains dividends");
        TextField gains = new TextField("0");
        VBox vbox16 = new VBox(5, label16, gains);
        vbox16.setAlignment(Pos.CENTER_LEFT);
        vbox16.setPadding(new Insets(10, 20, 10, 20));

        Label label17 = new Label("Name of educational institution");
        TextField institution = new TextField("NA");
        VBox vbox17 = new VBox(5, label17, institution);
        vbox17.setAlignment(Pos.CENTER_LEFT);
        vbox17.setPadding(new Insets(10, 20, 10, 20));

        Label label18 = new Label("Student number");
        TextField studentNum = new TextField("0");
        VBox vbox18 = new VBox(5, label18, studentNum);
        vbox18.setAlignment(Pos.CENTER_LEFT);
        vbox18.setPadding(new Insets(10, 20, 10, 20));

        Label label19 = new Label("Number of months full-time");
        TextField fullMonths = new TextField("0");
        VBox vbox19 = new VBox(5, label19, fullMonths);
        vbox19.setAlignment(Pos.CENTER_LEFT);
        vbox19.setPadding(new Insets(10, 20, 10, 20));

        Label label20 = new Label("Name of program or course");
        TextField program = new TextField("NA");
        VBox vbox20 = new VBox(5, label20, program);
        vbox20.setAlignment(Pos.CENTER_LEFT);
        vbox20.setPadding(new Insets(10, 20, 10, 20));

        Label label21 = new Label("Address of educational institution");
        TextField address = new TextField("NA");
        VBox vbox21 = new VBox(5, label21, address);
        vbox21.setAlignment(Pos.CENTER_LEFT);
        vbox21.setPadding(new Insets(10, 20, 10, 20));

        Label label22 = new Label("Eligible tution fees");
        TextField tuition = new TextField("0");
        VBox vbox22 = new VBox(5, label22, tuition);
        vbox22.setAlignment(Pos.CENTER_LEFT);
        vbox22.setPadding(new Insets(10, 20, 10, 20));

        Label label23 = new Label("Number of months part-time");
        TextField partMonths = new TextField("0");
        VBox vbox23 = new VBox(5, label23, partMonths);
        vbox23.setAlignment(Pos.CENTER_LEFT);
        vbox23.setPadding(new Insets(10, 20, 10, 20));

        Label label24 = new Label("I certify that the information given on this return is correct and complete.");
        CheckBox certify = new CheckBox();
        HBox hbox = new HBox(5, certify, label24);
        hbox.setAlignment(Pos.CENTER_LEFT);
        hbox.setPadding(new Insets(10, 20, 10, 20));
        hbox.setAlignment(Pos.CENTER);

        Button clearT4Btn = new Button("Clear T4");
        clearT4Btn.setOnAction(e -> {
            TaxController.clearT4(income, taxDeducted, cpp, eiPremium, rpp, insurable, union, donations);
        });

        HBox clearT4Box = new HBox(clearT4Btn);
        clearT4Box.setPadding(new Insets(40, 20, 20, 20));
        clearT4Box.setAlignment(Pos.CENTER);

        Button clearT5Btn = new Button("Clear T5");
        clearT5Btn.setOnAction(e -> {
            TaxController.clearT5(eligibleDividends, otherDividends, eligibleCredit, interest, eligibleTax, otherTax, otherCredit, gains);
        });

        HBox clearT5Box = new HBox(clearT5Btn);
        clearT5Box.setPadding(new Insets(40, 20, 20, 20));
        clearT5Box.setAlignment(Pos.CENTER);

        Button clearT2202Btn = new Button("Clear T2202");
        clearT2202Btn.setOnAction(e -> {
            TaxController.clearT2202(institution, studentNum, fullMonths, partMonths, program, address, tuition);
        });

        HBox clearT2202Box = new HBox(clearT2202Btn);
        clearT2202Box.setPadding(new Insets(40, 20, 20, 20));
        clearT2202Box.setAlignment(Pos.CENTER);

        // Create a GridPane to hold the T4 VBox nodes
        GridPane gridT4 = new GridPane();
        gridT4.setAlignment(Pos.CENTER_LEFT);
        gridT4.setHgap(5);
        gridT4.setVgap(5);

        // Add the VBox nodes to the grid
        gridT4.add(vbox1, 0, 0);
        gridT4.add(vbox2, 0, 1);
        gridT4.add(vbox3, 0, 2);
        gridT4.add(vbox4, 0, 3);
        gridT4.add(vbox5, 1, 0);
        gridT4.add(vbox6, 1, 1);
        gridT4.add(vbox7, 1, 2);
        gridT4.add(vbox8, 1, 3);

        Label T4label = new Label("T4");
        VBox T4vbox = new VBox(T4label, gridT4, clearT4Box);
        T4vbox.setAlignment(Pos.CENTER);

        // Create a GridPane to hold the T5 VBox nodes
        GridPane gridT5 = new GridPane();
        gridT5.setAlignment(Pos.CENTER);
        gridT5.setHgap(5);
        gridT5.setVgap(5);

        // Add the VBox nodes to the grid
        gridT5.add(vbox9, 0, 0);
        gridT5.add(vbox10, 0, 1);
        gridT5.add(vbox11, 0, 2);
        gridT5.add(vbox12, 0, 3);
        gridT5.add(vbox13, 1, 0);
        gridT5.add(vbox14, 1, 1);
        gridT5.add(vbox15, 1, 2);
        gridT5.add(vbox16, 1, 3);

        Label T5label = new Label("T5");
        VBox T5vbox = new VBox(T5label, gridT5, clearT5Box);
        T5vbox.setAlignment(Pos.CENTER);

        // Create a GridPane to hold the T2202 VBox nodes
        GridPane gridT2202 = new GridPane();
        gridT2202.setAlignment(Pos.CENTER_RIGHT);
        gridT2202.setHgap(5);
        gridT2202.setVgap(5);

        // Add the VBox nodes to the grid
        gridT2202.add(vbox17, 0, 0);
        gridT2202.add(vbox18, 0, 1);
        gridT2202.add(vbox19, 0, 2);
        gridT2202.add(vbox20, 0, 3);
        gridT2202.add(vbox21, 1, 0);
        gridT2202.add(vbox22, 1, 1);
        gridT2202.add(vbox23, 1, 2);

        Label T2202label = new Label("T2202");
        VBox T2202vbox = new VBox(T2202label, gridT2202, clearT2202Box);
        T2202vbox.setAlignment(Pos.CENTER);

        //Create HBox for the different VBoxes containing grids
        HBox gridHBox = new HBox(T4vbox, T5vbox, T2202vbox);
        gridHBox.setPadding(new Insets(10, 20, 10, 20));
        gridHBox.setAlignment(Pos.CENTER);

        // Set the styles for the grids to add a border
        gridT4.setStyle("-fx-border-color: black; -fx-border-width: 1px;");
        gridT5.setStyle("-fx-border-color: black; -fx-border-width: 1px;");
        gridT2202.setStyle("-fx-border-color: black; -fx-border-width: 1px;");

        // Create the calculate button
        Button calcButton = new Button("Calculate");
        calcButton.setOnAction(e -> {
            if (TaxController.validateForm(income, taxDeducted, cpp, eiPremium, rpp, insurable, union, donations,
                    eligibleDividends, otherDividends, eligibleCredit, interest, eligibleTax, otherTax, otherCredit,
                    gains, institution, studentNum, fullMonths, program, address, tuition, partMonths, childCareExpenses, medicalExpenses, dentalExpenses, certify, user.getRegion())) {
                Results result = new Results();
                result.start(currentStage);
            }
        });

        Button backButton = new Button("Back");
        backButton.setOnAction(e -> {
		currentStage.setScene(new GeneralDeductions().getScene(currentStage, user));
        });

        // Create an HBox to hold the buttons
        HBox buttonBox = new HBox(20);
	buttonBox.getChildren().addAll(backButton, calcButton);

        buttonBox.setAlignment(Pos.BOTTOM_CENTER);

        buttonBox.setPadding(
                new Insets(40, 20, 20, 20));

        // Create a Group to hold the GridPane and the HBox
        VBox root = new VBox();

        root.getChildren()
                .addAll(gridHBox, hbox, buttonBox);

        // Create the Scene and set it on the Stage
        Scene scene = new Scene(root, 1400, 600);

        currentStage.setTitle("Tax Input");
        return scene;
    }

    @Override
    public void start(Stage primaryStage) {
        User testingUser = new User();
	testingUser.setRegion("Ontario");
	testingUser.setFirstName("John");
	testingUser.setLastName("Smith");

        primaryStage.setScene(getScene(primaryStage, testingUser, "0", "0", "0"));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
