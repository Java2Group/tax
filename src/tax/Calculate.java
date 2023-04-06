package tax;

/**
 *
 * @author Michael Sousa
 */
public class Calculate {

    private static String result;

    public static String getResult() {
        return result;
    }

    //Method for calculating taxes owed, tax credits, and refund
    public static void calculateTax(double totalIncome, double taxDeductedValue, double cppValue, double eiPremiumValue, double rppValue, double insurableValue, double unionValue,
            double donationsValue, double eligibleDividendsValue, double otherDividendsValue, double eligibleCreditValue, double interestValue, double eligibleTaxValue,
            double otherTaxValue, double otherCreditValue, double gainsValue, int studentNumValue, int fullMonthsValue, int partMonthsValue, double tuitionValue) {

        // Calculate net income
        double finalIncome = totalIncome + gainsValue + interestValue + eligibleTaxValue + otherTaxValue;
        double netIncome = finalIncome - (cppValue + eiPremiumValue + rppValue + insurableValue + unionValue + donationsValue);
        double taxCredits = (tuitionValue * 0.15) + (eligibleCreditValue * 0.150198) + (otherCreditValue * 0.090301);
        double refund;
        

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

        totalTax = federalTax + provincialTax - taxDeductedValue;
        if(totalTax - taxCredits >= 0){
            totalTax -= taxCredits;
        }
        // Create a formatted string with the result
        if (totalTax <= 0) {
            totalTax = federalTax + provincialTax;
            refund = Math.abs(totalTax - taxDeductedValue);
            

            result = String.format("Tax Refund: $%.2f\nUnemployment Insurance Benefits: $%.2f\nTax Credits remaining: $%.2f", refund, eiBenefit, taxCredits);
        } else {
            result = String.format("Taxes Owed: $%.2f (Provincial: $%.2f  Federal: $%.2f)\nUnemployment Insurance Benefits: $%.2f", totalTax, provincialTax, federalTax, eiBenefit);
        }
    }
}
