package Array_Assignment.LEVEL_2;

import java.util.Scanner;

public class FriendStats {

        public static void main(String[] args) {
            Scanner input = new Scanner(System.in);
            String[] names = {"Amar", "Akbar", "Anthony"};
            int[] ages = new int[3];
            double[] heights = new double[3];

            for (int i = 0; i < 3; i++) {
                System.out.print("Enter age of " + names[i] + ": ");
                ages[i] = input.nextInt();
                System.out.print("Enter height of " + names[i] + ": ");
                heights[i] = input.nextDouble();

                if (ages[i] <= 0 || heights[i] <= 0) {
                    System.out.println("Invalid age or height. Please enter positive numbers.");
                    i--;
                }
            }

            int youngestIndex = 0;
            int tallestIndex = 0;

            for (int i = 1; i < 3; i++) {
                if (ages[i] < ages[youngestIndex]) {
                    youngestIndex = i;
                }
                if (heights[i] > heights[tallestIndex]) {
                    tallestIndex = i;
                }
            }

            System.out.println("\nYoungest Friend: " + names[youngestIndex] + " (Age: " + ages[youngestIndex] + ")");
            System.out.println("Tallest Friend: " + names[tallestIndex] + " (Height: " + heights[tallestIndex] + ")");


    }
}
