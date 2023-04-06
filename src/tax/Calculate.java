package tax;

/**
 *
 * @author Michael Sousa
 * @author Brandon Yaeck
 */
public class Calculate {

    private static String result;

    public static String getResult() {
        return result;
    }

    //Method for calculating taxes owed, tax credits, and refund
    public static void calculateTax(double totalIncome, double taxDeductedValue, double cppValue, double eiPremiumValue, double rppValue, double insurableValue, double unionValue,
            double donationsValue, double eligibleDividendsValue, double otherDividendsValue, double eligibleCreditValue, double interestValue, double eligibleTaxValue,
            double otherTaxValue, double otherCreditValue, double gainsValue, int studentNumValue, int fullMonthsValue, int partMonthsValue, double tuitionValue, String region) {

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


	//2022 bracket values

	// Federal
	final int FEDERAL_PERSONAL_AMOUNT = 14398;

	final double FEDERAL_1_RATE = 0.15;	
	final double FEDERAL_2_RATE = 0.205;	
	final double FEDERAL_3_RATE = 0.26;	
	final double FEDERAL_4_RATE = 0.29;	
	final double FEDERAL_5_RATE = 0.33;	

	final int FEDERAL_1_END = 50197;	
	final int FEDERAL_2_END = 100392;	
	final int FEDERAL_3_END = 155625;	
	final int FEDERAL_4_END = 221708;	

	if (netIncome <= FEDERAL_PERSONAL_AMOUNT) {
            federalTax = 0.0;
	} else if (netIncome <= FEDERAL_1_END) {
            federalTax = (netIncome - FEDERAL_PERSONAL_AMOUNT) * FEDERAL_1_RATE;
	} else if (netIncome <= FEDERAL_2_END) {
            federalTax = (netIncome - FEDERAL_1_END) * FEDERAL_2_RATE + ((FEDERAL_1_END - FEDERAL_PERSONAL_AMOUNT) * FEDERAL_1_RATE);
	} else if (netIncome <= FEDERAL_3_END) {
            federalTax = (netIncome - FEDERAL_2_END) * FEDERAL_3_RATE + ((FEDERAL_2_END - FEDERAL_1_END) * FEDERAL_2_RATE) + ((FEDERAL_1_END - FEDERAL_PERSONAL_AMOUNT) * FEDERAL_1_RATE);
	} else if (netIncome <= FEDERAL_4_END) {
            federalTax = (netIncome - FEDERAL_3_END) * FEDERAL_4_RATE + ((FEDERAL_3_END - FEDERAL_2_END) * FEDERAL_3_RATE) + ((FEDERAL_2_END - FEDERAL_1_END) * FEDERAL_2_RATE) + ((FEDERAL_1_END - FEDERAL_PERSONAL_AMOUNT) * FEDERAL_1_RATE);
	} else {
            federalTax = (netIncome - FEDERAL_4_END) * FEDERAL_5_RATE + ((FEDERAL_4_END - FEDERAL_3_END) * FEDERAL_4_RATE) + ((FEDERAL_3_END - FEDERAL_2_END) * FEDERAL_3_RATE) + ((FEDERAL_2_END - FEDERAL_1_END) * FEDERAL_2_RATE) + ((FEDERAL_1_END - FEDERAL_PERSONAL_AMOUNT) * FEDERAL_1_RATE);
	}


	switch (region) {
		case "Alberta":
			provincialTax = calculateAlberta(netIncome);
			break;
		case "British Columbia":
			provincialTax = calculateBritishColumbia(netIncome);
			break;
		case "Manitoba":
			provincialTax = calculateManitoba(netIncome);
			break;
		case "New Brunswick":
			provincialTax = calculateNewBrunswick(netIncome);
			break;
		case "Newfoundland and Labrador":
			provincialTax = calculateNewfoundland(netIncome);
			break;
		case "Northwest Territories":
			provincialTax = calculateNorthwestTerritories(netIncome);
			break;
		case "Nova Scotia":
			provincialTax = calculateNovaScotia(netIncome);
			break;
		case "Nunavut":
			provincialTax = calculateNunavut(netIncome);
			break;
		case "Ontario":
			provincialTax = calculateOntario(netIncome);
			break;
		case "Prince Edward Island":
			provincialTax = calculatePrinceEdwardIsland(netIncome);
			break;
		case "Quebec":
			provincialTax = calculateQuebec(netIncome);
			break;
		case "Saskatchewan":
			provincialTax = calculateSaskatchewan(netIncome);
			break;
		case "Yukon":
			provincialTax = calculateYukon(netIncome);
			break;
		default:
			provincialTax = 0.0;
			break;
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

	private static double calculateAlberta(double netIncome) {
		final int AB_PERSONAL_AMOUNT = 19369;

		final double AB_1_RATE = 0.10;	
		final double AB_2_RATE = 0.12;	
		final double AB_3_RATE = 0.13;	
		final double AB_4_RATE = 0.14;	
		final double AB_5_RATE = 0.15;	

		final int AB_1_END = 134238;	
		final int AB_2_END = 161086;	
		final int AB_3_END = 214781;	
		final int AB_4_END = 322171;	

		double provincialTax;

		if (netIncome <= AB_PERSONAL_AMOUNT) {
		    provincialTax = 0.0;
		} else if (netIncome <= AB_1_END) {
		    provincialTax = (netIncome - AB_PERSONAL_AMOUNT) * AB_1_RATE;
		} else if (netIncome <= AB_2_END) {
		    provincialTax = (netIncome - AB_1_END) * AB_2_RATE + ((AB_1_END - AB_PERSONAL_AMOUNT) * AB_1_RATE);
		} else if (netIncome <= AB_3_END) {
		    provincialTax = (netIncome - AB_2_END) * AB_3_RATE + ((AB_2_END - AB_1_END) * AB_2_RATE) + ((AB_1_END - AB_PERSONAL_AMOUNT) * AB_1_RATE);
		} else if (netIncome <= AB_4_END) {
		    provincialTax = (netIncome - AB_3_END) * AB_4_RATE + ((AB_3_END - AB_2_END) * AB_3_RATE) + ((AB_2_END - AB_1_END) * AB_2_RATE) + ((AB_1_END - AB_PERSONAL_AMOUNT) * AB_1_RATE);
		} else {
		    provincialTax = (netIncome - AB_4_END) * AB_5_RATE + ((AB_4_END - AB_3_END) * AB_4_RATE) + ((AB_3_END - AB_2_END) * AB_3_RATE) + ((AB_2_END - AB_1_END) * AB_2_RATE) + ((AB_1_END - AB_PERSONAL_AMOUNT) * AB_1_RATE);
		}

		return provincialTax;
	}
	private static double calculateBritishColumbia(double netIncome) {
		final int BC_PERSONAL_AMOUNT = 11302;

		final double BC_1_RATE = 0.0506;	
		final double BC_2_RATE = 0.077;	
		final double BC_3_RATE = 0.105;	
		final double BC_4_RATE = 0.1229;	
		final double BC_5_RATE = 0.147;	
		final double BC_6_RATE = 0.168;	
		final double BC_7_RATE = 0.205;	

		final int BC_1_END = 43070;	
		final int BC_2_END = 86141;	
		final int BC_3_END = 98901;	
		final int BC_4_END = 120094;	
		final int BC_5_END = 162832;	
		final int BC_6_END = 227091;	

		double provincialTax;

		if (netIncome <= BC_PERSONAL_AMOUNT) {
		    provincialTax = 0.0;
		} else if (netIncome <= BC_1_END) {
		    provincialTax = (netIncome - BC_PERSONAL_AMOUNT) * BC_1_RATE;
		} else if (netIncome <= BC_2_END) {
		    provincialTax = (netIncome - BC_1_END) * BC_2_RATE + ((BC_1_END - BC_PERSONAL_AMOUNT) * BC_1_RATE);
		} else if (netIncome <= BC_3_END) {
		    provincialTax = (netIncome - BC_2_END) * BC_3_RATE + ((BC_2_END - BC_1_END) * BC_2_RATE) + ((BC_1_END - BC_PERSONAL_AMOUNT) * BC_1_RATE);
		} else if (netIncome <= BC_4_END) {
		    provincialTax = (netIncome - BC_3_END) * BC_4_RATE + ((BC_3_END - BC_2_END) * BC_3_RATE) + ((BC_2_END - BC_1_END) * BC_2_RATE) + ((BC_1_END - BC_PERSONAL_AMOUNT) * BC_1_RATE);
		} else if (netIncome <= BC_5_END) {
		    provincialTax = (netIncome - BC_4_END) * BC_5_RATE + ((BC_4_END - BC_3_END) * BC_4_RATE) + ((BC_3_END - BC_2_END) * BC_3_RATE) + ((BC_2_END - BC_1_END) * BC_2_RATE) + ((BC_1_END - BC_PERSONAL_AMOUNT) * BC_1_RATE);
		} else if (netIncome <= BC_6_END) {
		    provincialTax = (netIncome - BC_5_END) * BC_6_RATE + ((BC_5_END - BC_4_END) * BC_5_RATE) + ((BC_4_END - BC_3_END) * BC_4_RATE) + ((BC_3_END - BC_2_END) * BC_3_RATE) + ((BC_2_END - BC_1_END) * BC_2_RATE) + ((BC_1_END - BC_PERSONAL_AMOUNT) * BC_1_RATE);
		} else {
		    provincialTax = (netIncome - BC_6_END) * BC_7_RATE + ((BC_6_END - BC_5_END) * BC_6_RATE) + ((BC_5_END - BC_4_END) * BC_5_RATE) + ((BC_4_END - BC_3_END) * BC_4_RATE) + ((BC_3_END - BC_2_END) * BC_3_RATE) + ((BC_2_END - BC_1_END) * BC_2_RATE) + ((BC_1_END - BC_PERSONAL_AMOUNT) * BC_1_RATE);
		}

		return provincialTax;
	}
	private static double calculateManitoba(double netIncome) {
		final int MB_PERSONAL_AMOUNT = 10145;

		final double MB_1_RATE = 0.108;	
		final double MB_2_RATE = 0.1275;	
		final double MB_3_RATE = 0.174;	

		final int MB_1_END = 34431;	
		final int MB_2_END = 74416;	

		double provincialTax;

		if (netIncome <= MB_PERSONAL_AMOUNT) {
		    provincialTax = 0.0;
		} else if (netIncome <= MB_1_END) {
		    provincialTax = (netIncome - MB_PERSONAL_AMOUNT) * MB_1_RATE;
		} else if (netIncome <= MB_2_END) {
		    provincialTax = (netIncome - MB_1_END) * MB_2_RATE + ((MB_1_END - MB_PERSONAL_AMOUNT) * MB_1_RATE);
		} else {
		    provincialTax = (netIncome - MB_2_END) * MB_3_RATE + ((MB_2_END - MB_1_END) * MB_2_RATE) + ((MB_1_END - MB_PERSONAL_AMOUNT) * MB_1_RATE);
		}

		return provincialTax;
	}
	private static double calculateNewBrunswick(double netIncome) {
		final int NB_PERSONAL_AMOUNT = 11720;

		final double NB_1_RATE = 0.094;	
		final double NB_2_RATE = 0.1482;	
		final double NB_3_RATE = 0.1652;	
		final double NB_4_RATE = 0.1784;	
		final double NB_5_RATE = 0.203;	

		final int NB_1_END = 44887;	
		final int NB_2_END = 89775;	
		final int NB_3_END = 145955;	
		final int NB_4_END = 166280;	

		double provincialTax;

		if (netIncome <= NB_PERSONAL_AMOUNT) {
		    provincialTax = 0.0;
		} else if (netIncome <= NB_1_END) {
		    provincialTax = (netIncome - NB_PERSONAL_AMOUNT) * NB_1_RATE;
		} else if (netIncome <= NB_2_END) {
		    provincialTax = (netIncome - NB_1_END) * NB_2_RATE + ((NB_1_END - NB_PERSONAL_AMOUNT) * NB_1_RATE);
		} else if (netIncome <= NB_3_END) {
		    provincialTax = (netIncome - NB_2_END) * NB_3_RATE + ((NB_2_END - NB_1_END) * NB_2_RATE) + ((NB_1_END - NB_PERSONAL_AMOUNT) * NB_1_RATE);
		} else if (netIncome <= NB_4_END) {
		    provincialTax = (netIncome - NB_3_END) * NB_4_RATE + ((NB_3_END - NB_2_END) * NB_3_RATE) + ((NB_2_END - NB_1_END) * NB_2_RATE) + ((NB_1_END - NB_PERSONAL_AMOUNT) * NB_1_RATE);
		} else {
		    provincialTax = (netIncome - NB_4_END) * NB_5_RATE + ((NB_4_END - NB_3_END) * NB_4_RATE) + ((NB_3_END - NB_2_END) * NB_3_RATE) + ((NB_2_END - NB_1_END) * NB_2_RATE) + ((NB_1_END - NB_PERSONAL_AMOUNT) * NB_1_RATE);
		}

		return provincialTax;
	}
	private static double calculateNewfoundland(double netIncome) {
		final int NL_PERSONAL_AMOUNT = 9803;

		final double NL_1_RATE = 0.087;	
		final double NL_2_RATE = 0.145;	
		final double NL_3_RATE = 0.158;	
		final double NL_4_RATE = 0.178;	
		final double NL_5_RATE = 0.198;	
		final double NL_6_RATE = 0.208;	
		final double NL_7_RATE = 0.213;	
		final double NL_8_RATE = 0.218;	

		final int NL_1_END = 39147;	
		final int NL_2_END = 78294;	
		final int NL_3_END = 139780;	
		final int NL_4_END = 195693;	
		final int NL_5_END = 250000;	
		final int NL_6_END = 500000;	
		final int NL_7_END = 1000000;	

		double provincialTax;

		if (netIncome <= NL_PERSONAL_AMOUNT) {
		    provincialTax = 0.0;
		} else if (netIncome <= NL_1_END) {
		    provincialTax = (netIncome - NL_PERSONAL_AMOUNT) * NL_1_RATE;
		} else if (netIncome <= NL_2_END) {
		    provincialTax = (netIncome - NL_1_END) * NL_2_RATE + ((NL_1_END - NL_PERSONAL_AMOUNT) * NL_1_RATE);
		} else if (netIncome <= NL_3_END) {
		    provincialTax = (netIncome - NL_2_END) * NL_3_RATE + ((NL_2_END - NL_1_END) * NL_2_RATE) + ((NL_1_END - NL_PERSONAL_AMOUNT) * NL_1_RATE);
		} else if (netIncome <= NL_4_END) {
		    provincialTax = (netIncome - NL_3_END) * NL_4_RATE + ((NL_3_END - NL_2_END) * NL_3_RATE) + ((NL_2_END - NL_1_END) * NL_2_RATE) + ((NL_1_END - NL_PERSONAL_AMOUNT) * NL_1_RATE);
		} else if (netIncome <= NL_5_END) {
		    provincialTax = (netIncome - NL_4_END) * NL_5_RATE + ((NL_4_END - NL_3_END) * NL_4_RATE) + ((NL_3_END - NL_2_END) * NL_3_RATE) + ((NL_2_END - NL_1_END) * NL_2_RATE) + ((NL_1_END - NL_PERSONAL_AMOUNT) * NL_1_RATE);
		} else if (netIncome <= NL_6_END) {
		    provincialTax = (netIncome - NL_5_END) * NL_6_RATE + ((NL_5_END - NL_4_END) * NL_5_RATE) + ((NL_4_END - NL_3_END) * NL_4_RATE) + ((NL_3_END - NL_2_END) * NL_3_RATE) + ((NL_2_END - NL_1_END) * NL_2_RATE) + ((NL_1_END - NL_PERSONAL_AMOUNT) * NL_1_RATE);
		} else if (netIncome <= NL_7_END) {
		    provincialTax = (netIncome - NL_6_END) * NL_7_RATE + ((NL_6_END - NL_5_END) * NL_6_RATE) + ((NL_5_END - NL_4_END) * NL_5_RATE) + ((NL_4_END - NL_3_END) * NL_4_RATE) + ((NL_3_END - NL_2_END) * NL_3_RATE) + ((NL_2_END - NL_1_END) * NL_2_RATE) + ((NL_1_END - NL_PERSONAL_AMOUNT) * NL_1_RATE);
		} else  {
		    provincialTax = (netIncome - NL_7_END) * NL_8_RATE + ((NL_7_END - NL_6_END) * NL_7_RATE) + ((NL_6_END - NL_5_END) * NL_6_RATE) + ((NL_5_END - NL_4_END) * NL_5_RATE) + ((NL_4_END - NL_3_END) * NL_4_RATE) + ((NL_3_END - NL_2_END) * NL_3_RATE) + ((NL_2_END - NL_1_END) * NL_2_RATE) + ((NL_1_END - NL_PERSONAL_AMOUNT) * NL_1_RATE);
		}

		return provincialTax;
	}
	private static double calculateNorthwestTerritories(double netIncome) {
		final int NT_PERSONAL_AMOUNT = 15609;

		final double NT_1_RATE = 0.059;	
		final double NT_2_RATE = 0.086;	
		final double NT_3_RATE = 0.122;	
		final double NT_4_RATE = 0.1405;	

		final int NT_1_END = 45462;	
		final int NT_2_END = 90927;	
		final int NT_3_END = 147826;	

		double provincialTax;

		if (netIncome <= NT_PERSONAL_AMOUNT) {
		    provincialTax = 0.0;
		} else if (netIncome <= NT_1_END) {
		    provincialTax = (netIncome - NT_PERSONAL_AMOUNT) * NT_1_RATE;
		} else if (netIncome <= NT_2_END) {
		    provincialTax = (netIncome - NT_1_END) * NT_2_RATE + ((NT_1_END - NT_PERSONAL_AMOUNT) * NT_1_RATE);
		} else if (netIncome <= NT_3_END) {
		    provincialTax = (netIncome - NT_2_END) * NT_3_RATE + ((NT_2_END - NT_1_END) * NT_2_RATE) + ((NT_1_END - NT_PERSONAL_AMOUNT) * NT_1_RATE);
		} else  {
		    provincialTax = (netIncome - NT_3_END) * NT_4_RATE + ((NT_3_END - NT_2_END) * NT_3_RATE) + ((NT_2_END - NT_1_END) * NT_2_RATE) + ((NT_1_END - NT_PERSONAL_AMOUNT) * NT_1_RATE);
		}

		return provincialTax;
	}
	private static double calculateNovaScotia(double netIncome) {
		// personal amount in Nova Scotia varies based on income
		int nsPersonalAmount;
		if (netIncome < 25000) {
			nsPersonalAmount = 11481;
		} else {
			nsPersonalAmount = 8481;
		}

		final double NS_1_RATE = 0.0879;	
		final double NS_2_RATE = 0.1495;	
		final double NS_3_RATE = 0.1667;	
		final double NS_4_RATE = 0.175;	
		final double NS_5_RATE = 0.21;	

		final int NS_1_END = 29590;	
		final int NS_2_END = 59180;	
		final int NS_3_END = 93000;	
		final int NS_4_END = 150000;	

		double provincialTax;

		if (netIncome <= nsPersonalAmount) {
		    provincialTax = 0.0;
		} else if (netIncome <= NS_1_END) {
		    provincialTax = (netIncome - nsPersonalAmount) * NS_1_RATE;
		} else if (netIncome <= NS_2_END) {
		    provincialTax = (netIncome - NS_1_END) * NS_2_RATE + ((NS_1_END - nsPersonalAmount) * NS_1_RATE);
		} else if (netIncome <= NS_3_END) {
		    provincialTax = (netIncome - NS_2_END) * NS_3_RATE + ((NS_2_END - NS_1_END) * NS_2_RATE) + ((NS_1_END - nsPersonalAmount) * NS_1_RATE);
		} else if (netIncome <= NS_4_END) {
		    provincialTax = (netIncome - NS_3_END) * NS_4_RATE + ((NS_3_END - NS_2_END) * NS_3_RATE) + ((NS_2_END - NS_1_END) * NS_2_RATE) + ((NS_1_END - nsPersonalAmount) * NS_1_RATE);
		} else {
		    provincialTax = (netIncome - NS_4_END) * NS_5_RATE + ((NS_4_END - NS_3_END) * NS_4_RATE) + ((NS_3_END - NS_2_END) * NS_3_RATE) + ((NS_2_END - NS_1_END) * NS_2_RATE) + ((NS_1_END - nsPersonalAmount) * NS_1_RATE);
		}

		return provincialTax;
	}
	private static double calculateNunavut(double netIncome) {
		final int NU_PERSONAL_AMOUNT = 16862;

		final double NU_1_RATE = 0.04;	
		final double NU_2_RATE = 0.07;	
		final double NU_3_RATE = 0.09;	
		final double NU_4_RATE = 0.115;	

		final int NU_1_END = 47862;	
		final int NU_2_END = 95724;	
		final int NU_3_END = 155625;	

		double provincialTax;

		if (netIncome <= NU_PERSONAL_AMOUNT) {
		    provincialTax = 0.0;
		} else if (netIncome <= NU_1_END) {
		    provincialTax = (netIncome - NU_PERSONAL_AMOUNT) * NU_1_RATE;
		} else if (netIncome <= NU_2_END) {
		    provincialTax = (netIncome - NU_1_END) * NU_2_RATE + ((NU_1_END - NU_PERSONAL_AMOUNT) * NU_1_RATE);
		} else if (netIncome <= NU_3_END) {
		    provincialTax = (netIncome - NU_2_END) * NU_3_RATE + ((NU_2_END - NU_1_END) * NU_2_RATE) + ((NU_1_END - NU_PERSONAL_AMOUNT) * NU_1_RATE);
		} else  {
		    provincialTax = (netIncome - NU_3_END) * NU_4_RATE + ((NU_3_END - NU_2_END) * NU_3_RATE) + ((NU_2_END - NU_1_END) * NU_2_RATE) + ((NU_1_END - NU_PERSONAL_AMOUNT) * NU_1_RATE);
		}

		return provincialTax;
	}
	private static double calculateOntario(double netIncome) {
		final int ON_PERSONAL_AMOUNT = 11141;

		final double ON_1_RATE = 0.0505;	
		final double ON_2_RATE = 0.0915;	
		final double ON_3_RATE = 0.1116;	
		final double ON_4_RATE = 0.1216;	
		final double ON_5_RATE = 0.1316;	

		final int ON_1_END = 46226;	
		final int ON_2_END = 92454;	
		final int ON_3_END = 150000;	
		final int ON_4_END = 220000;	

		double provincialTax;

		if (netIncome <= ON_PERSONAL_AMOUNT) {
		    provincialTax = 0.0;
		} else if (netIncome <= ON_1_END) {
		    provincialTax = (netIncome - ON_PERSONAL_AMOUNT) * ON_1_RATE;
		} else if (netIncome <= ON_2_END) {
		    provincialTax = (netIncome - ON_1_END) * ON_2_RATE + ((ON_1_END - ON_PERSONAL_AMOUNT) * ON_1_RATE);
		} else if (netIncome <= ON_3_END) {
		    provincialTax = (netIncome - ON_2_END) * ON_3_RATE + ((ON_2_END - ON_1_END) * ON_2_RATE) + ((ON_1_END - ON_PERSONAL_AMOUNT) * ON_1_RATE);
		} else if (netIncome <= ON_4_END) {
		    provincialTax = (netIncome - ON_3_END) * ON_4_RATE + ((ON_3_END - ON_2_END) * ON_3_RATE) + ((ON_2_END - ON_1_END) * ON_2_RATE) + ((ON_1_END - ON_PERSONAL_AMOUNT) * ON_1_RATE);
		} else {
		    provincialTax = (netIncome - ON_4_END) * ON_5_RATE + ((ON_4_END - ON_3_END) * ON_4_RATE) + ((ON_3_END - ON_2_END) * ON_3_RATE) + ((ON_2_END - ON_1_END) * ON_2_RATE) + ((ON_1_END - ON_PERSONAL_AMOUNT) * ON_1_RATE);
		}

		return provincialTax;
	}
	private static double calculatePrinceEdwardIsland(double netIncome) {
		final int PEI_PERSONAL_AMOUNT = 11250;

		final double PEI_1_RATE = 0.098;	
		final double PEI_2_RATE = 0.138;	
		final double PEI_3_RATE = 0.167;	

		final int PEI_1_END = 31984;	
		final int PEI_2_END = 63969;	

		double provincialTax;

		if (netIncome <= PEI_PERSONAL_AMOUNT) {
		    provincialTax = 0.0;
		} else if (netIncome <= PEI_1_END) {
		    provincialTax = (netIncome - PEI_PERSONAL_AMOUNT) * PEI_1_RATE;
		} else if (netIncome <= PEI_2_END) {
		    provincialTax = (netIncome - PEI_1_END) * PEI_2_RATE + ((PEI_1_END - PEI_PERSONAL_AMOUNT) * PEI_1_RATE);
		} else {
		    provincialTax = (netIncome - PEI_2_END) * PEI_3_RATE + ((PEI_2_END - PEI_1_END) * PEI_2_RATE) + ((PEI_1_END - PEI_PERSONAL_AMOUNT) * PEI_1_RATE);
		}

		return provincialTax;
	}

	private static double calculateQuebec(double netIncome) {
		final int QC_PERSONAL_AMOUNT = 16143;

		final double QC_1_RATE = 0.15;	
		final double QC_2_RATE = 0.20;	
		final double QC_3_RATE = 0.24;	
		final double QC_4_RATE = 0.2575;	

		final int QC_1_END = 46295;	
		final int QC_2_END = 92580;	
		final int QC_3_END = 112655;	

		double provincialTax;

		if (netIncome <= QC_PERSONAL_AMOUNT) {
		    provincialTax = 0.0;
		} else if (netIncome <= QC_1_END) {
		    provincialTax = (netIncome - QC_PERSONAL_AMOUNT) * QC_1_RATE;
		} else if (netIncome <= QC_2_END) {
		    provincialTax = (netIncome - QC_1_END) * QC_2_RATE + ((QC_1_END - QC_PERSONAL_AMOUNT) * QC_1_RATE);
		} else if (netIncome <= QC_3_END) {
		    provincialTax = (netIncome - QC_2_END) * QC_3_RATE + ((QC_2_END - QC_1_END) * QC_2_RATE) + ((QC_1_END - QC_PERSONAL_AMOUNT) * QC_1_RATE);
		} else  {
		    provincialTax = (netIncome - QC_3_END) * QC_4_RATE + ((QC_3_END - QC_2_END) * QC_3_RATE) + ((QC_2_END - QC_1_END) * QC_2_RATE) + ((QC_1_END - QC_PERSONAL_AMOUNT) * QC_1_RATE);
		}

		return provincialTax;
	}
	private static double calculateSaskatchewan(double netIncome) {
		final int SK_PERSONAL_AMOUNT = 16615;

		final double SK_1_RATE = 0.105;	
		final double SK_2_RATE = 0.125;	
		final double SK_3_RATE = 0.145;	

		final int SK_1_END = 46773;	
		final int SK_2_END = 133638;	

		double provincialTax;

		if (netIncome <= SK_PERSONAL_AMOUNT) {
		    provincialTax = 0.0;
		} else if (netIncome <= SK_1_END) {
		    provincialTax = (netIncome - SK_PERSONAL_AMOUNT) * SK_1_RATE;
		} else if (netIncome <= SK_2_END) {
		    provincialTax = (netIncome - SK_1_END) * SK_2_RATE + ((SK_1_END - SK_PERSONAL_AMOUNT) * SK_1_RATE);
		} else {
		    provincialTax = (netIncome - SK_2_END) * SK_3_RATE + ((SK_2_END - SK_1_END) * SK_2_RATE) + ((SK_1_END - SK_PERSONAL_AMOUNT) * SK_1_RATE);
		}

		return provincialTax;
	}
	private static double calculateYukon(double netIncome) {
		final int YT_PERSONAL_AMOUNT = 14398;

		final double YT_1_RATE = 0.064;	
		final double YT_2_RATE = 0.09;	
		final double YT_3_RATE = 0.109;	
		final double YT_4_RATE = 0.128;	
		final double YT_5_RATE = 0.15;	

		final int YT_1_END = 50197;	
		final int YT_2_END = 100392;	
		final int YT_3_END = 155625;	
		final int YT_4_END = 500000;	

		double provincialTax;

		if (netIncome <= YT_PERSONAL_AMOUNT) {
		    provincialTax = 0.0;
		} else if (netIncome <= YT_1_END) {
		    provincialTax = (netIncome - YT_PERSONAL_AMOUNT) * YT_1_RATE;
		} else if (netIncome <= YT_2_END) {
		    provincialTax = (netIncome - YT_1_END) * YT_2_RATE + ((YT_1_END - YT_PERSONAL_AMOUNT) * YT_1_RATE);
		} else if (netIncome <= YT_3_END) {
		    provincialTax = (netIncome - YT_2_END) * YT_3_RATE + ((YT_2_END - YT_1_END) * YT_2_RATE) + ((YT_1_END - YT_PERSONAL_AMOUNT) * YT_1_RATE);
		} else if (netIncome <= YT_4_END) {
		    provincialTax = (netIncome - YT_3_END) * YT_4_RATE + ((YT_3_END - YT_2_END) * YT_3_RATE) + ((YT_2_END - YT_1_END) * YT_2_RATE) + ((YT_1_END - YT_PERSONAL_AMOUNT) * YT_1_RATE);
		} else {
		    provincialTax = (netIncome - YT_4_END) * YT_5_RATE + ((YT_4_END - YT_3_END) * YT_4_RATE) + ((YT_3_END - YT_2_END) * YT_3_RATE) + ((YT_2_END - YT_1_END) * YT_2_RATE) + ((YT_1_END - YT_PERSONAL_AMOUNT) * YT_1_RATE);
		}

		return provincialTax;
	}
}
