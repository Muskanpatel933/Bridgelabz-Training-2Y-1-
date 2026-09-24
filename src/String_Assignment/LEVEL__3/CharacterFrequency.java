package String_Assignment.LEVEL__3;

import java.util.Scanner;

public class CharacterFrequency {


        public static String[][] findCharacterFrequency(String text) {
            int[] frequency = new int[256];

            for (int i = 0; i < text.length(); i++) {
                char ch = text.charAt(i);
                frequency[ch]++;
            }

            int uniqueCount = 0;
            for (int i = 0; i < text.length(); i++) {
                if (frequency[text.charAt(i)] > 0) {
                    uniqueCount++;
                    frequency[text.charAt(i)] = 0;
                }
            }

            for (int i = 0; i < text.length(); i++) {
                char ch = text.charAt(i);
                frequency[ch]++;
            }

            String[][] result = new String[uniqueCount][2];
            boolean[] visited = new boolean[256];
            int index = 0;

            for (int i = 0; i < text.length(); i++) {
                char ch = text.charAt(i);
                if (!visited[ch]) {
                    visited[ch] = true;
                    result[index][0] = String.valueOf(ch);
                    result[index][1] = String.valueOf(frequency[ch]);
                    index++;
                }
            }

            return result;
        }

        public static void main(String[] args) {
            Scanner input = new Scanner(System.in);

            System.out.print("Enter a string: ");
            String text = input.nextLine();

            String[][] freqData = findCharacterFrequency(text);

            System.out.println("\nCharacter Frequencies:");
            System.out.printf("%-12s %-10s\n", "Character", "Frequency");
            System.out.println("----------------------");
            for (int i = 0; i < freqData.length; i++) {
                System.out.printf("%-12s %-10s\n", freqData[i][0], freqData[i][1]);
            }


    }
}
