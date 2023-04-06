package tax;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

/**
 *
 * @author Michael Sousa
 */
public class TaxController {

    //Validate the various textfields to ensure they aren't empty, negative, and contain the desired input
    public static boolean validateForm(TextField income, TextField taxDeducted, TextField cpp, TextField eiPremium, TextField rpp, TextField insurable, TextField union, TextField donations,
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
            return false;
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
            alert.setHeaderText("Invalid input format. All fields except Educational instituion, address, and name of program require number values");
            alert.showAndWait();
            return false;
        }

        if (!institution.getText().matches("[a-zA-Z]+")) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Institution must contain only letters");
            alert.showAndWait();
            return false;
        }

        if (!program.getText().matches("[a-zA-Z]+")) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Program must contain only letters");
            alert.showAndWait();
            return false;
        }

        if (Double.parseDouble(income.getText()) < 0 || Double.parseDouble(taxDeducted.getText()) < 0 || Double.parseDouble(cpp.getText()) < 0
                || Double.parseDouble(eiPremium.getText()) < 0 || Double.parseDouble(rpp.getText()) < 0 || Double.parseDouble(insurable.getText()) < 0
                || Double.parseDouble(union.getText()) < 0 || Double.parseDouble(donations.getText()) < 0 || Double.parseDouble(eligibleDividends.getText()) < 0
                || Double.parseDouble(otherDividends.getText()) < 0 || Double.parseDouble(eligibleCredit.getText()) < 0 || Double.parseDouble(interest.getText()) < 0
                || Double.parseDouble(eligibleTax.getText()) < 0 || Double.parseDouble(otherTax.getText()) < 0 || Double.parseDouble(otherCredit.getText()) < 0
                || Double.parseDouble(gains.getText()) < 0) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Negative values are not allowed");
            alert.showAndWait();
            return false;
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
        
        
        Calculate.calculateTax(totalIncome, taxDeductedValue, cppValue, eiPremiumValue, rppValue, insurableValue, unionValue, donationsValue, eligibleDividendsValue, otherDividendsValue,
                eligibleCreditValue, interestValue, eligibleTaxValue, otherTaxValue, otherCreditValue, gainsValue, studentNumValue, fullMonthsValue, partMonthsValue, tuitionValue);
        return true;
    }

    //Methods for clearing forms
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

    public static void clearT5(TextField eligibleDividends, TextField otherDividends, TextField eligibleCredit, TextField interest, TextField eligibleTax,
            TextField otherTax, TextField otherCredit, TextField gains) {
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
