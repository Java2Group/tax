/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tax;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author Michael Sousa
 */
public class TaxController {
       

    public static void validateT4(TextField income, TextField taxDeducted, TextField cpp, TextField eiPremium, TextField rpp, TextField insurable, TextField union, TextField donations) {

        // Validate the input fields
        if (income.getText().isEmpty() || taxDeducted.getText().isEmpty() || cpp.getText().isEmpty() || eiPremium.getText().isEmpty() || rpp.getText().isEmpty() || insurable.getText().isEmpty() || union.getText().isEmpty() || donations.getText().isEmpty()) {
            // Show an alert box if any field is empty
            Alert alert = new Alert(AlertType.ERROR, "All fields are required.");
            alert.showAndWait();
            return;
        }

        // Validate that the input fields contain double values
        try {
            Double.parseDouble(income.getText());
            Double.parseDouble(taxDeducted.getText());
            Double.parseDouble(cpp.getText());
            Double.parseDouble(eiPremium.getText());
            Double.parseDouble(rpp.getText());
            Double.parseDouble(insurable.getText());
            Double.parseDouble(union.getText());
            Double.parseDouble(donations.getText());
        } catch (NumberFormatException e) {
            // Show an alert box if any field does not contain a double value
            Alert alert = new Alert(AlertType.ERROR, "All fields must be filled with number values.");
            alert.showAndWait();
            return;
        }

        // Parse the values from the textfields
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

        // Calculate the taxes owed or tax refund
        double taxPayable = TaxController.calculateTaxPayableT4(netIncome) - incomeTaxDeducted;

        // Create a formatted string with the result
        String result;
        if (taxPayable < 0) {
            result = String.format("Tax Refund: $%.2f\nUnemployment Insurance Benefits: $%.2f", taxPayable * -1, eiBenefit);
        } else {
            result = String.format("Taxes Owed: $%.2f\nUnemployment Insurance Benefits: $%.2f", taxPayable, eiBenefit);
        }

        // Create a new window to display the result
        Stage resultStage = new Stage();
        Label resultLabel = new Label(result);
        Group resultRoot = new Group(resultLabel);
        Scene resultScene = new Scene(resultRoot, 300, 150);
        resultStage.setScene(resultScene);
        resultStage.show();
    }

// Method to calculate the taxes owed based on the net income from T4 slip
    public static double calculateTaxPayableT4(double netIncome) {
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
}
