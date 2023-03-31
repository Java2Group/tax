package tax;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author Michael Sousa
 */
public class TaxController {

    public static void validateT4(TextField income, TextField taxDeducted, TextField cpp, TextField eiPremium, TextField rpp, TextField insurable, TextField union, TextField donations, CheckBox certify) {

        // Validate the input fields
        if (income.getText().isEmpty() || taxDeducted.getText().isEmpty() || cpp.getText().isEmpty() || eiPremium.getText().isEmpty() || rpp.getText().isEmpty() || insurable.getText().isEmpty() || union.getText().isEmpty() || donations.getText().isEmpty() || certify.isSelected() == false) {
            // Show an alert box if any field is empty
            Alert alert = new Alert(AlertType.ERROR, "All fields and boxes are required.");
            alert.showAndWait();
            return;
        }

        // Validate that the input fields contain double values
        try {
            double parsedIncome = Double.parseDouble(income.getText());
            double parsedTaxDeducted = Double.parseDouble(taxDeducted.getText());
            double parsedCpp = Double.parseDouble(cpp.getText());
            double parsedEiPremium = Double.parseDouble(eiPremium.getText());
            double parsedRpp = Double.parseDouble(rpp.getText());
            double parsedInsurable = Double.parseDouble(insurable.getText());
            double parsedUnion = Double.parseDouble(union.getText());
            double parsedDonations = Double.parseDouble(donations.getText());
            if (parsedIncome < 0 || parsedTaxDeducted < 0 || parsedCpp < 0 || parsedEiPremium < 0 || parsedRpp < 0 || parsedInsurable < 0 || parsedUnion < 0 || parsedDonations < 0) {
                throw new NumberFormatException();
            }

        } catch (NumberFormatException e) {
            // Show an alert box if any field does not contain a postive double value
            Alert alert = new Alert(AlertType.ERROR, "All fields must be filled with positive number values.");
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

    public static void validateT5(TextField eligibleDividends, TextField otherDividends, TextField eligibleCredit, TextField interest, TextField eligibleTax, TextField otherTax, TextField otherCredit, TextField gains, CheckBox certify) {

        // Validate the input fields
        if (eligibleDividends.getText().isEmpty() || otherDividends.getText().isEmpty() || eligibleCredit.getText().isEmpty() || interest.getText().isEmpty() || eligibleTax.getText().isEmpty() || otherTax.getText().isEmpty() || otherCredit.getText().isEmpty() || gains.getText().isEmpty() || certify.isSelected() == false) {
            // Show an alert box if any field is empty
            Alert alert = new Alert(AlertType.ERROR, "All fields and boxes are required.");
            alert.showAndWait();
            return;
        }

        // Validate that the input fields contain double values
        try {
            double parsedEligibleDividends = Double.parseDouble(eligibleDividends.getText());
            double parsedOtherDividends = Double.parseDouble(otherDividends.getText());
            double parsedEligibleCredit = Double.parseDouble(eligibleCredit.getText());
            double parsedInterest = Double.parseDouble(interest.getText());
            double parsedEligibleTax = Double.parseDouble(eligibleTax.getText());
            double parsedOtherTax = Double.parseDouble(otherTax.getText());
            double parsedOtherCredit = Double.parseDouble(otherCredit.getText());
            double parsedGains = Double.parseDouble(gains.getText());
            if (parsedEligibleDividends < 0 || parsedOtherDividends < 0 || parsedEligibleCredit < 0 || parsedInterest < 0 || parsedEligibleTax < 0 || parsedOtherTax < 0 || parsedOtherCredit < 0 || parsedGains < 0) {
                throw new NumberFormatException();
            }

        } catch (NumberFormatException e) {
            // Show an alert box if any field does not contain a postive double value
            Alert alert = new Alert(AlertType.ERROR, "All fields must be filled with positive number values.");
            alert.showAndWait();
            return;
        }

        // Parse the values from the textfields
        double parsedEligibleDividends = Double.parseDouble(eligibleDividends.getText());
        double parsedOtherDividends = Double.parseDouble(otherDividends.getText());
        double parsedEligibleCredit = Double.parseDouble(eligibleCredit.getText());
        double parsedInterest = Double.parseDouble(interest.getText());
        double parsedEligibleTax = Double.parseDouble(eligibleTax.getText());
        double parsedOtherTax = Double.parseDouble(otherTax.getText());
        double parsedOtherCredit = Double.parseDouble(otherCredit.getText());
        double parsedGains = Double.parseDouble(gains.getText());

    }

    public static void validateT2202(TextField institution, TextField studentNum, TextField fullMonths, TextField program, TextField address, TextField tuition, TextField partMonths, CheckBox certify) {

        // Validate the input fields
        if (institution.getText().isEmpty() || studentNum.getText().isEmpty() || fullMonths.getText().isEmpty() || program.getText().isEmpty() || address.getText().isEmpty() || tuition.getText().isEmpty() || partMonths.getText().isEmpty() || certify.isSelected() == false) {
            // Show an alert box if any field is empty
            Alert alert = new Alert(AlertType.ERROR, "All fields and boxes are required.");
            alert.showAndWait();
            return;
        }

        // Validate that the input fields contain double values
        try {
            double parsedInstitution = Double.parseDouble(institution.getText());
            double parsedStudentNum = Double.parseDouble(studentNum.getText());
            double parsedFullMonths = Double.parseDouble(fullMonths.getText());
            double parsedProgram = Double.parseDouble(program.getText());
            double parsedAddress = Double.parseDouble(address.getText());
            double parsedTuition = Double.parseDouble(tuition.getText());
            double parsedPartMonths = Double.parseDouble(partMonths.getText());

            if (parsedInstitution < 0 || parsedStudentNum < 0 || parsedFullMonths < 0 || parsedProgram < 0 || parsedAddress < 0 || parsedTuition < 0 || parsedPartMonths < 0) {
                throw new NumberFormatException();
            }

        } catch (NumberFormatException e) {
            // Show an alert box if any field does not contain a postive double value
            Alert alert = new Alert(AlertType.ERROR, "All fields must be filled with positive number values.");
            alert.showAndWait();
            return;
        }

        // Parse the values from the textfields
        double parsedInstitution = Double.parseDouble(institution.getText());
        double parsedStudentNum = Double.parseDouble(studentNum.getText());
        double parsedFullMonths = Double.parseDouble(fullMonths.getText());
        double parsedProgram = Double.parseDouble(program.getText());
        double parsedAddress = Double.parseDouble(address.getText());
        double parsedTuition = Double.parseDouble(tuition.getText());
        double parsedPartMonths = Double.parseDouble(partMonths.getText());

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
