/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package tax;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author XeroS
 */
public class T4 extends Application {

    @Override
    public void start(Stage primaryStage) {
        Label label1 = new Label("Employment Income");
        TextField income = new TextField();
        VBox vbox1 = new VBox(5, label1, income);
        vbox1.setAlignment(Pos.CENTER_LEFT);
        vbox1.setPadding(new Insets(10, 20, 10, 20));

        Label label2 = new Label("Employee's CPP contributions");
        TextField cpp = new TextField();
        VBox vbox2 = new VBox(5, label2, cpp);
        vbox2.setAlignment(Pos.CENTER_LEFT);
        vbox2.setPadding(new Insets(10, 20, 10, 20));

        Label label3 = new Label("Employee's EI premiums");
        TextField eiPremium = new TextField();
        VBox vbox3 = new VBox(5, label3, eiPremium);
        vbox3.setAlignment(Pos.CENTER_LEFT);
        vbox3.setPadding(new Insets(10, 20, 10, 20));

        Label label4 = new Label("RPP contributions");
        TextField rpp = new TextField();
        VBox vbox4 = new VBox(5, label4, rpp);
        vbox4.setAlignment(Pos.CENTER_LEFT);
        vbox4.setPadding(new Insets(10, 20, 10, 20));

        Label label5 = new Label("Income tax deducted");
        TextField taxDeducted = new TextField();
        VBox vbox5 = new VBox(5, label5, taxDeducted);
        vbox5.setAlignment(Pos.CENTER_LEFT);
        vbox5.setPadding(new Insets(10, 20, 10, 20));

        Label label6 = new Label("EI insurable earnings");
        TextField insurable = new TextField();
        VBox vbox6 = new VBox(5, label6, insurable);
        vbox6.setAlignment(Pos.CENTER_LEFT);
        vbox6.setPadding(new Insets(10, 20, 10, 20));

        Label label7 = new Label("Union dues");
        TextField union = new TextField();
        VBox vbox7 = new VBox(5, label7, union);
        vbox7.setAlignment(Pos.CENTER_LEFT);
        vbox7.setPadding(new Insets(10, 20, 10, 20));

        Label label8 = new Label("Charitable donations");
        TextField donations = new TextField();
        VBox vbox8 = new VBox(5, label8, donations);
        vbox8.setAlignment(Pos.CENTER_LEFT);
        vbox8.setPadding(new Insets(10, 20, 10, 20));

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
        grid.add(vbox8, 1, 3);

        // Create the calculate button
        Button calcButton = new Button("Calculate");
        calcButton.setOnAction(e -> {
            // Parse the values from the textfields
            if (income.getText().isEmpty()) {
                income.setText("0");
            }
            double employmentIncome = Double.parseDouble(income.getText());
            double incomeTaxDeducted = Double.parseDouble(taxDeducted.getText());
            double cppContributions = Double.parseDouble(cpp.getText());
            double eiPremiums = Double.parseDouble(eiPremium.getText());
            double rppContributions = Double.parseDouble(rpp.getText());
            double eiInsurableEarnings = Double.parseDouble(insurable.getText());
            double unionDues = Double.parseDouble(union.getText());
            double charitableDonations = Double.parseDouble(donations.getText());

            // Perform the calculation
            double totalDeductions = cppContributions + eiPremiums + rppContributions + unionDues + charitableDonations;
            double netIncome = employmentIncome - totalDeductions;
            double eiBenefit = 0.55 * eiInsurableEarnings;
            double totalBenefits = eiBenefit + netIncome;

            // Calculate the taxes owed or tax refund
            double taxCalculated = calculateTaxPayable(netIncome);
            double taxPayable = calculateTaxPayable(netIncome) - incomeTaxDeducted;
            double refund = calculateRefund(taxPayable, incomeTaxDeducted);

            // Create a formatted string with the result
            String result;
            if (refund > 0) {
                result = String.format("Tax Refund: $%.2f", refund);
            } else {
                result = String.format("Taxes Owed: $%.2f", taxPayable);
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
        HBox buttonBox = new HBox(calcButton);

        buttonBox.setAlignment(Pos.BOTTOM_CENTER);

        buttonBox.setPadding(
                new Insets(40, 20, 20, 20));

        // Create a Group to hold the GridPane and the HBox
        VBox root = new VBox();

        root.getChildren()
                .addAll(grid, buttonBox);

        // Create the Scene and set it on the Stage
        Scene scene = new Scene(root, 500, 400);

        primaryStage.setScene(scene);

        primaryStage.setTitle(
                "TaxSoftware");
        primaryStage.show();
    }

    // Method to calculate the taxes owed based on the net income
    private double calculateTaxPayable(double netIncome) {
        double taxPayable;

        if (netIncome <= 15000) {
            taxPayable = 0;
        } else if (netIncome <= 48730) {
            taxPayable = ((netIncome - 15000) * 0.15);
        } else if (netIncome <= 97440) {
            taxPayable = 7309.50 + ((netIncome - 48730 - 15000) * 0.205);
        } else if (netIncome <= 150000) {
            taxPayable = 17211.50 + ((netIncome - 97440 - 15000) * 0.26);
        } else if (netIncome <= 214368) {
            taxPayable = 31115.50 + ((netIncome - 150000 - 97440) * 0.29);
        } else {
            taxPayable = 49644.50 + ((netIncome - 214368 - 150000 - 97440) * 0.33);
        }

        return taxPayable;
    }

// Method to calculate the tax refund based on the taxes owed and income tax deducted
    // Method to calculate the tax refund based on the taxes owed and income tax deducted
    private double calculateRefund(double taxCalculated, double incomeTaxDeducted) {
        double refund;
        if(incomeTaxDeducted > taxCalculated){
             refund = (taxCalculated - incomeTaxDeducted) * (-1);
            
        }else{
            refund = 0;
        }
       return refund;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
