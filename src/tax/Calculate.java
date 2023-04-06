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

        if (netIncome <= 14398) {
            federalTax = 0.0;
            provincialTax = 0.0;
        } else if (netIncome <= 50197) {
            federalTax = (netIncome - 14398) * 0.15;
            provincialTax = (netIncome - 12298) * 0.0505;
        } else if (netIncome <= 100392) {
            federalTax = (netIncome - 50197) * 0.205 + 3819.76;
            provincialTax = (netIncome - 46226) * 0.0915 + 2079.61;
        } else if (netIncome <= 155625) {
            federalTax = (netIncome - 100392) * 0.26 + 8517.86;
            provincialTax = (netIncome - 92454) * 0.1116 + 4544.97;
        } else if (netIncome <= 221708) {
            federalTax = (netIncome - 155625) * 0.29 + 16060.09;
            provincialTax = (netIncome - 150000) * 0.1216 + 6447.36;
        } else {
            federalTax = (netIncome - 221708) * 0.33 + 29029.29;
            provincialTax = (netIncome - 220000) * 0.1316 + 10533.34;
        }

        totalTax = federalTax + provincialTax - taxDeductedValue;
        if (totalTax - taxCredits >= 0) {
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
