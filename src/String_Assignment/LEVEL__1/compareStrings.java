package String_Assignment.LEVEL__1;

import java.util.Scanner;

public class compareStrings {

        public static boolean compareStrings(String str1, String str2) {
            if (str1.length() != str2.length()) {
                return false;
            }
            for (int i = 0; i < str1.length(); i++) {
                if (str1.charAt(i) != str2.charAt(i)) {
                    return false;
                }
            }
            return true;
        }

        public static void main(String[] args) {
            Scanner input = new Scanner(System.in);

            System.out.print("Enter first string: ");
            String str1 = input.next();
            System.out.print("Enter second string: ");
            String str2 = input.next();

            boolean customResult = compareStrings(str1, str2);
            boolean builtinResult = str1.equals(str2);

            System.out.println("Custom Comparison Result: " + customResult);
            System.out.println("Built-in equals() Result: " + builtinResult);

            if (customResult == builtinResult) {
                System.out.println("Both methods produced the same result.");
            } else {
                System.out.println("Results do not match.");
            }


    }
}
