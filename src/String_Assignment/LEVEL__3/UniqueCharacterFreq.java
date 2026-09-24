package String_Assignment.LEVEL__3;

import java.util.Scanner;

public class UniqueCharacterFreq {

        public static char[] uniqueCharacters(String text) {
            int len = text.length();
            char[] temp = new char[len];
            int uniqueCount = 0;

            for (int i = 0; i < len; i++) {
                char current = text.charAt(i);
                boolean isUnique = true;

                for (int j = 0; j < i; j++) {
                    if (text.charAt(j) == current) {
                        isUnique = false;
                        break;
                    }
                }

                if (isUnique) {
                    temp[uniqueCount] = current;
                    uniqueCount++;
                }
            }

            char[] uniqueChars = new char[uniqueCount];
            for (int i = 0; i < uniqueCount; i++) {
                uniqueChars[i] = temp[i];
            }

            return uniqueChars;
        }

        public static String[][] getCharacterFrequency(String text) {
            int[] frequency = new int[256];

            for (int i = 0; i < text.length(); i++) {
                char ch = text.charAt(i);
                frequency[ch]++;
            }

            char[] unique = uniqueCharacters(text);
            String[][] result = new String[unique.length][2];

            for (int i = 0; i < unique.length; i++) {
                char ch = unique[i];
                result[i][0] = String.valueOf(ch);
                result[i][1] = String.valueOf(frequency[ch]);
            }

            return result;
        }

        public static void main(String[] args) {
            Scanner input = new Scanner(System.in);

            System.out.print("Enter a string: ");
            String text = input.nextLine();

            String[][] result = getCharacterFrequency(text);

            System.out.println("\nCharacter Frequencies:");
            System.out.printf("%-12s %-10s\n", "Character", "Frequency");
            System.out.println("----------------------");
            for (int i = 0; i < result.length; i++) {
                System.out.printf("%-12s %-10s\n", result[i][0], result[i][1]);
            }

                }
}
