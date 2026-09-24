package Array_Assignment.LEVEL_2;

import java.util.Scanner;

public class ReverseNumber {

        public static void main(String[] args) {
            Scanner input = new Scanner(System.in);

            System.out.print("Enter a number: ");
            int number = input.nextInt();

            if (number <= 0) {
                System.err.println("Invalid Number.");
                System.exit(0);
            }

            int temp = number;
            int count = 0;
            while (temp > 0) {
                count++;
                temp /= 10;
            }

            int[] digits = new int[count];
            temp = number;
            for (int i = 0; i < count; i++) {
                digits[i] = temp % 10;
                temp /= 10;
            }

            int[] reversed = new int[count];
            for (int i = 0; i < count; i++) {
                reversed[i] = digits[i];
            }

            System.out.print("Reversed Number Digits: ");
            for (int i = 0; i < reversed.length; i++) {
                System.out.print(reversed[i] + " ");
            }
            System.out.println();

    }
}
