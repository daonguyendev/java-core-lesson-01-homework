package com.daonguyen;

import java.util.Scanner;

/**
 * PIManager = Personal Income Manager
 * Calculate personal income tax per year
 * Author: Dao Nguyen
 * Date: 21/07/2020
 * Version: 1.0
 */
public class PITaxManager {
    static final int TAXABLE_INCOME_LEVEL_1 = 0, TAXABLE_INCOME_LEVEL_2 = 60,
            TAXABLE_INCOME_LEVEL_3 = 120, TAXABLE_INCOME_LEVEL_4 = 216,
            TAXABLE_INCOME_LEVEL5 = 384, TAXABLE_INCOME_LEVEL_6 = 624,
            TAXABLE_INCOME_LEVEL_7 = 960;

    static final double TAX_RATE_FOR_INCOME_LEVEL_1 = 0.05, TAX_RATE_FOR_INCOME_LEVEL_2 = 0.1,
            TAX_RATE_FOR_INCOME_LEVEL_3 = 0.15, TAX_RATE_FOR_INCOME_LEVEL_4 = 0.2,
            TAX_RATE_FOR_INCOME_LEVEL_5 = 0.25, TAX_RATE_FOR_INCOME_LEVEL_6 = 0.3,
            TAX_RATE_FOR_INCOME_LEVEL_7 = 0.35;

    public static void main(String[] args) {
        // Input
        Scanner scanner = new Scanner(System.in);
        String fullName = "";
        float incomePerYear = 0, personalIncomeTax = 0;
        int dependentPerson = 0;

        System.out.print("Enter your full name: ");
        fullName = scanner.nextLine();
        System.out.print("Enter your income per year: ");
        incomePerYear = scanner.nextFloat();
        System.out.print("Enter your dependent person: ");
        dependentPerson = scanner.nextInt();

        // Handle
        personalIncomeTax = calculatePersonalIncomeTaxPerYear(incomePerYear, dependentPerson);

        // Output
        System.out.println("Personal income tax of " + fullName + " is: " + personalIncomeTax);
    }

    private static float calculatePersonalIncomeTaxPerYear(float incomePerYear,
                                                           int dependentPerson) {
        float personalIncomeTax = (float) (incomePerYear - 4 - (dependentPerson * 1.6));

        if (personalIncomeTax > TAXABLE_INCOME_LEVEL_1
                && personalIncomeTax <= TAXABLE_INCOME_LEVEL_2) {
            personalIncomeTax = (float) (personalIncomeTax - (personalIncomeTax * TAX_RATE_FOR_INCOME_LEVEL_1));
        } else if (personalIncomeTax > TAXABLE_INCOME_LEVEL_2
                && personalIncomeTax <= TAXABLE_INCOME_LEVEL_3) {
            personalIncomeTax = (float) (personalIncomeTax - (personalIncomeTax * TAX_RATE_FOR_INCOME_LEVEL_2));
        } else if (personalIncomeTax > TAXABLE_INCOME_LEVEL_3
                && personalIncomeTax <= TAXABLE_INCOME_LEVEL_4) {
            personalIncomeTax = (float) (personalIncomeTax - (personalIncomeTax * TAX_RATE_FOR_INCOME_LEVEL_3));
        } else if (personalIncomeTax > TAXABLE_INCOME_LEVEL_4
                && personalIncomeTax <= TAXABLE_INCOME_LEVEL5) {
            personalIncomeTax = (float) (personalIncomeTax - (personalIncomeTax * TAX_RATE_FOR_INCOME_LEVEL_4));
        } else if (personalIncomeTax > TAXABLE_INCOME_LEVEL5
                && personalIncomeTax <= TAXABLE_INCOME_LEVEL_6) {
            personalIncomeTax = (float) (personalIncomeTax - (personalIncomeTax * TAX_RATE_FOR_INCOME_LEVEL_5));
        } else if (personalIncomeTax > TAXABLE_INCOME_LEVEL_6
                && personalIncomeTax <= TAXABLE_INCOME_LEVEL_7) {
            personalIncomeTax = (float) (personalIncomeTax - (personalIncomeTax * TAX_RATE_FOR_INCOME_LEVEL_6));
        } else { // personalIncomeTax > 960
            personalIncomeTax = (float) (personalIncomeTax - (personalIncomeTax * TAX_RATE_FOR_INCOME_LEVEL_7));
        }

        return personalIncomeTax;
    }
}
