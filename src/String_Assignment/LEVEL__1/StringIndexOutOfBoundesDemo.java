package String_Assignment.LEVEL__1;

import java.util.Scanner;

public class StringIndexOutOfBoundesDemo {


        public static void generateException(String text) {
            char ch = text.charAt(text.length() + 5);
        }

        public static void handleException(String text) {
            try {
                char ch = text.charAt(text.length() + 5);
            } catch (StringIndexOutOfBoundsException e) {
                System.out.println("StringIndexOutOfBoundsException caught successfully.");
            }
        }

        public static void main(String[] args) {
            Scanner input = new Scanner(System.in);

            System.out.print("Enter text: ");
            String text = input.next();

            handleException(text);

            try {
                generateException(text);
            } catch (StringIndexOutOfBoundsException e) {
                System.out.println("Generated exception caught in main.");
            }

    }
}
