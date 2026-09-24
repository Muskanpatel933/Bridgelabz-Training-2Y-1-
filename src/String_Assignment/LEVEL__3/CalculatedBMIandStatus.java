package String_Assignment.LEVEL__3;

import java.util.Scanner;

public class CalculatedBMIandStatus {


        public static String calculateBMIAndStatus(double heightCm, double weightKg) {
            double heightM = heightCm / 100.0;
            double bmi = weightKg / (heightM * heightM);
            String status;

            if (bmi < 18.5) {
                status = "Underweight";
            } else if (bmi >= 18.5 && bmi < 24.9) {
                status = "Normal";
            } else if (bmi >= 25.0 && bmi < 29.9) {
                status = "Overweight";
            } else {
                status = "Obese";
            }

            return String.format("%.2f", bmi) + " (" + status + ")";
        }

        public static String[][] processBMIData(double[][] personData) {
            String[][] result = new String[personData.length][4];

            for (int i = 0; i < personData.length; i++) {
                double weight = personData[i][0];
                double height = personData[i][1];

                result[i][0] = String.valueOf(height);
                result[i][1] = String.valueOf(weight);

                double heightM = height / 100.0;
                double bmi = weight / (heightM * heightM);

                String status;
                if (bmi < 18.5) {
                    status = "Underweight";
                } else if (bmi >= 18.5 && bmi < 24.9) {
                    status = "Normal";
                } else if (bmi >= 25.0 && bmi < 29.9) {
                    status = "Overweight";
                } else {
                    status = "Obese";
                }

                result[i][2] = String.format("%.2f", bmi);
                result[i][3] = status;
            }

            return result;
        }

        public static void displayBMIResults(String[][] bmiData) {
            System.out.printf("\n%-10s %-12s %-12s %-10s %-12s\n", "Person", "Height(cm)", "Weight(kg)", "BMI", "Status");
            System.out.println("---------------------------------------------------------");

            for (int i = 0; i < bmiData.length; i++) {
                System.out.printf("%-10d %-12s %-12s %-10s %-12s\n",
                        (i + 1), bmiData[i][0], bmiData[i][1], bmiData[i][2], bmiData[i][3]);
            }
        }

        public static void main(String[] args) {
            Scanner input = new Scanner(System.in);
            double[][] personData = new double[10][2];

            System.out.println("Enter details for 10 members:");
            for (int i = 0; i < 10; i++) {
                System.out.println("Person " + (i + 1) + ":");
                System.out.print("Enter Weight (kg): ");
                double weight = input.nextDouble();
                System.out.print("Enter Height (cm): ");
                double height = input.nextDouble();

                if (weight <= 0 || height <= 0) {
                    System.out.println("Invalid input. Height and Weight must be positive values.");
                    i--;
                    continue;
                }

                personData[i][0] = weight;
                personData[i][1] = height;
            }

            String[][] bmiResults = processBMIData(personData);
            displayBMIResults(bmiResults);


    }
}
