/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tax;

/**
 *
 * @author XeroS
 */
public class Calculations {
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
