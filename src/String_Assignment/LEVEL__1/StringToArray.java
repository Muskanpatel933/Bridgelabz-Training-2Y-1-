package String_Assignment.LEVEL__1;

import java.util.Scanner;

public class StringToArray {



            public static char[] getCharacters(String text) {
            char[] chars = new char[text.length()];
            for (int i = 0; i < text.length(); i++) {
                chars[i] = text.charAt(i);
            }
            return chars;
        }

        public static boolean compareArrays(char[] arr1, char[] arr2) {
            if (arr1.length != arr2.length) {
                return false;
            }
            for (int i = 0; i < arr1.length; i++) {
                if (arr1[i] != arr2[i]) {
                    return false;
                }
            }
            return true;
        }

        public static void main(String[] args) {
            Scanner input = new Scanner(System.in);

            System.out.print("Enter text: ");
            String text = input.next();

            char[] customArray = getCharacters(text);
            char[] builtinArray = text.toCharArray();

            boolean isSame = compareArrays(customArray, builtinArray);

            System.out.println("Arrays are identical: " + isSame);


    }
}
