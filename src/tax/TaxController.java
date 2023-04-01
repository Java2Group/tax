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

    public static void validateForm(TextField income, TextField taxDeducted, TextField cpp, TextField eiPremium, TextField rpp, TextField insurable, TextField union, TextField donations,
            TextField eligibleDividends, TextField otherDividends, TextField eligibleCredit, TextField interest, TextField eligibleTax, TextField otherTax, TextField otherCredit,
            TextField gains, TextField institution, TextField studentNum, TextField fullMonths, TextField program, TextField address, TextField tuition, TextField partMonths, CheckBox certify) {
        if (income.getText().isEmpty() || taxDeducted.getText().isEmpty() || cpp.getText().isEmpty() || eiPremium.getText().isEmpty() || rpp.getText().isEmpty()
                || insurable.getText().isEmpty() || union.getText().isEmpty() || donations.getText().isEmpty() || eligibleDividends.getText().isEmpty()
                || otherDividends.getText().isEmpty() || eligibleCredit.getText().isEmpty() || interest.getText().isEmpty() || eligibleTax.getText().isEmpty()
                || otherTax.getText().isEmpty() || otherCredit.getText().isEmpty() || gains.getText().isEmpty() || institution.getText().isEmpty() || studentNum.getText().isEmpty()
                || fullMonths.getText().isEmpty() || program.getText().isEmpty() || address.getText().isEmpty() || tuition.getText().isEmpty() || partMonths.getText().isEmpty() || certify.isSelected() == false) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Checkbox and all fields are required");
            alert.showAndWait();
            return;
        }

        try {
            Double.parseDouble(income.getText());
            Double.parseDouble(taxDeducted.getText());
            Double.parseDouble(cpp.getText());
            Double.parseDouble(eiPremium.getText());
            Double.parseDouble(rpp.getText());
            Double.parseDouble(insurable.getText());
            Double.parseDouble(union.getText());
            Double.parseDouble(donations.getText());
            Double.parseDouble(eligibleDividends.getText());
            Double.parseDouble(otherDividends.getText());
            Double.parseDouble(eligibleCredit.getText());
            Double.parseDouble(interest.getText());
            Double.parseDouble(eligibleTax.getText());
            Double.parseDouble(otherTax.getText());
            Double.parseDouble(otherCredit.getText());
            Double.parseDouble(gains.getText());
            Integer.parseInt(studentNum.getText());
            Integer.parseInt(fullMonths.getText());
            Integer.parseInt(partMonths.getText());
        } catch (NumberFormatException e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Invalid input format");
            alert.showAndWait();
            return;
        }

        if (!institution.getText().matches("[a-zA-Z]+")) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Institution must contain only letters");
            alert.showAndWait();
            return;
        }

        if (!program.getText().matches("[a-zA-Z]+")) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Program must contain only letters");
            alert.showAndWait();
            return;
        }

        // Parse input values
        double totalIncome = Double.parseDouble(income.getText());
        double taxDeductedValue = Double.parseDouble(taxDeducted.getText());
        double cppValue = Double.parseDouble(cpp.getText());
        double eiPremiumValue = Double.parseDouble(eiPremium.getText());
        double rppValue = Double.parseDouble(rpp.getText());
        double insurableValue = Double.parseDouble(insurable.getText());
        double unionValue = Double.parseDouble(union.getText());
        double donationsValue = Double.parseDouble(donations.getText());
        double eligibleDividendsValue = Double.parseDouble(eligibleDividends.getText());
        double otherDividendsValue = Double.parseDouble(otherDividends.getText());
        double eligibleCreditValue = Double.parseDouble(eligibleCredit.getText());
        double interestValue = Double.parseDouble(interest.getText());
        double eligibleTaxValue = Double.parseDouble(eligibleTax.getText());
        double otherTaxValue = Double.parseDouble(otherTax.getText());
        double otherCreditValue = Double.parseDouble(otherCredit.getText());
        double gainsValue = Double.parseDouble(gains.getText());
        int studentNumValue = Integer.parseInt(studentNum.getText());
        int fullMonthsValue = Integer.parseInt(fullMonths.getText());
        int partMonthsValue = Integer.parseInt(partMonths.getText());
        double tuitionValue = Double.parseDouble(tuition.getText());

        calculateTax(totalIncome, taxDeductedValue, cppValue, eiPremiumValue, rppValue, insurableValue, unionValue, donationsValue, eligibleDividendsValue, otherDividendsValue,
                eligibleCreditValue, interestValue, eligibleTaxValue, otherTaxValue, otherCreditValue, gainsValue, studentNumValue, fullMonthsValue, partMonthsValue, tuitionValue);

    }

    // Method to calculate the taxes owed based on the information provided from the form
    public static void calculateTax(double totalIncome, double taxDeductedValue, double cppValue, double eiPremiumValue, double rppValue, double insurableValue, double unionValue,
            double donationsValue, double eligibleDividendsValue, double otherDividendsValue, double eligibleCreditValue, double interestValue, double eligibleTaxValue,
            double otherTaxValue, double otherCreditValue, double gainsValue, int studentNumValue, int fullMonthsValue, int partMonthsValue, double tuitionValue) {

        // Calculate net income
        double finalIncome = totalIncome + gainsValue + interestValue + eligibleTaxValue + otherTaxValue;
        double netIncome = finalIncome - (cppValue + eiPremiumValue + rppValue + insurableValue + unionValue + donationsValue + eligibleDividendsValue + otherDividendsValue + eligibleCreditValue + otherCreditValue);
        double taxCredits = (tuitionValue * 0.15) + (eligibleCreditValue * 0.150198) + (otherCreditValue * 0.90301);
        // Calculate federal and provincial tax
        double totalTax;
        double federalTax;
        double provincialTax;
        double eiBenefit = 0.55 * insurableValue;

        if (netIncome <= 15000) {
            federalTax = 0.0;
            provincialTax = 0.0;
        } else if (netIncome <= 47630) {
            federalTax = (netIncome - 15000) * 0.15;
            provincialTax = (netIncome - 15000) * 0.0505;
        } else if (netIncome <= 95259) {
            federalTax = (netIncome - 47630) * 0.205 + 3559.50;
            provincialTax = (netIncome - 47630) * 0.0915 + 2397.37;
        } else if (netIncome <= 147667) {
            federalTax = (netIncome - 95259) * 0.26 + 8561.21;
            provincialTax = (netIncome - 95259) * 0.1116 + 4371.72;
        } else if (netIncome <= 210371) {
            federalTax = (netIncome - 147667) * 0.29 + 14694.31;
            provincialTax = (netIncome - 147667) * 0.1216 + 6163.23;
        } else {
            federalTax = (netIncome - 210371) * 0.33 + 31114.76;
            provincialTax = (netIncome - 210371) * 0.1316 + 8392.67;
        }
        
        totalTax = federalTax + provincialTax -taxDeductedValue;
        
        if(totalTax - taxCredits >= 0){
            totalTax = federalTax + provincialTax - taxDeductedValue - taxCredits;
            taxCredits = 0;
        }else{
            taxCredits = taxCredits - totalTax;
            totalTax = 0;
        }
        

        // Create a formatted string with the result
        String result;
        if (totalTax < 0) {
            result = String.format("Tax Refund: $%.2f\nUnemployment Insurance Benefits: $%.2f", totalTax * -1, eiBenefit);
        } else {
            result = String.format("Taxes Owed: $%.2f (Provincial: $%.2f  Federal: $%.2f)\nUnemployment Insurance Benefits: $%.2f\nTax Credits remaining for next year: $%.2f", totalTax, provincialTax, federalTax, eiBenefit, taxCredits);
        }

        // Create a new window to display the result
        Stage resultStage = new Stage();
        Label resultLabel = new Label(result);
        Group resultRoot = new Group(resultLabel);
        Scene resultScene = new Scene(resultRoot, 500, 150);
        resultStage.setScene(resultScene);
        resultStage.show();
    }

    public static void clearT4(TextField income, TextField taxDeducted, TextField cpp, TextField eiPremium, TextField rpp, TextField insurable, TextField union, TextField donations) {
        income.clear();
        taxDeducted.clear();
        cpp.clear();
        eiPremium.clear();
        rpp.clear();
        insurable.clear();
        union.clear();
        donations.clear();
    }

    public static void clearT5(TextField eligibleDividends, TextField otherDividends, TextField eligibleCredit, TextField interest, TextField eligibleTax, TextField otherTax, TextField otherCredit,
        TextField gains) {
        eligibleDividends.clear();
        otherDividends.clear();
        eligibleCredit.clear();
        interest.clear();
        eligibleTax.clear();
        otherTax.clear();
        otherCredit.clear();
        gains.clear();
    }

    public static void clearT2202(TextField institution, TextField studentNum, TextField fullMonths, TextField partMonths, TextField program, TextField address, TextField tuition) {
        institution.clear();
        studentNum.clear();
        fullMonths.clear();
        partMonths.clear();
        address.clear();
        program.clear();
        tuition.clear();
    }
}
