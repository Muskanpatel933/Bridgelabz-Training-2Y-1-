package Array_Assignment.LEVEL_2;

import java.util.Scanner;

public class Employeebonus {

        public static void main(String[] args) {
            Scanner input = new Scanner(System.in);
            double[][] employeeData = new double[10][2];
            double[][] bonusData = new double[10][2];
            double totalOldSalary = 0.0;
            double totalNewSalary = 0.0;
            double totalBonus = 0.0;

            for (int i = 0; i < 10; i++) {
                System.out.println("Enter details for Employee " + (i + 1) + ":");
                System.out.print("Salary: ");
                double salary = input.nextDouble();
                System.out.print("Years of Service: ");
                double years = input.nextDouble();

                if (salary <= 0 || years < 0) {
                    System.out.println("Invalid input. Please enter positive values.");
                    i--;
                    continue;
                }

                employeeData[i][0] = salary;
                employeeData[i][1] = years;
            }

            for (int i = 0; i < 10; i++) {
                double salary = employeeData[i][0];
                double years = employeeData[i][1];
                double bonusRate = (years > 5) ? 0.05 : 0.02;

                double bonus = salary * bonusRate;
                double newSalary = salary + bonus;

                bonusData[i][0] = bonus;
                bonusData[i][1] = newSalary;

                totalOldSalary += salary;
                totalBonus += bonus;
                totalNewSalary += newSalary;
            }

            System.out.println("\nEmployee Details:");
            for (int i = 0; i < 10; i++) {
                System.out.println("Employee " + (i + 1) + " - Old Salary: " + employeeData[i][0] +
                        ", Bonus: " + bonusData[i][0] + ", New Salary: " + bonusData[i][1]);
            }

            System.out.println("\nTotal Old Salary: " + totalOldSalary);
            System.out.println("Total Bonus Payout: " + totalBonus);
            System.out.println("Total New Salary: " + totalNewSalary);


    }
}
