package String_Assignment.LEVEL__2;

import java.util.Scanner;

public class CustomSplit {


        public static int getLength(String text) {
            int count = 0;
            try {
                while (true) {
                    text.charAt(count);
                    count++;
                }
            } catch (IndexOutOfBoundsException e) {
                return count;
            }
        }

        public static String[] customSplit(String text) {
            int len = getLength(text);
            int wordCount = 0;
            boolean inWord = false;

            for (int i = 0; i < len; i++) {
                if (text.charAt(i) != ' ') {
                    if (!inWord) {
                        wordCount++;
                        inWord = true;
                    }
                } else {
                    inWord = false;
                }
            }

            String[] words = new String[wordCount];
            int index = 0;
            String currentWord = "";

            for (int i = 0; i < len; i++) {
                char ch = text.charAt(i);
                if (ch != ' ') {
                    currentWord += ch;
                } else {
                    if (!currentWord.equals("")) {
                        words[index] = currentWord;
                        index++;
                        currentWord = "";
                    }
                }
            }

            if (!currentWord.equals("")) {
                words[index] = currentWord;
            }

            return words;
        }

        public static boolean compareArrays(String[] arr1, String[] arr2) {
            if (arr1.length != arr2.length) {
                return false;
            }
            for (int i = 0; i < arr1.length; i++) {
                if (!arr1[i].equals(arr2[i])) {
                    return false;
                }
            }
            return true;
        }

        public static void main(String[] args) {
            Scanner input = new Scanner(System.in);

            System.out.print("Enter a sentence: ");
            String text = input.nextLine();

            String[] customWords = customSplit(text);
            String[] builtinWords = text.trim().split("\\s+");

            boolean isSame = compareArrays(customWords, builtinWords);

            System.out.println("Custom Split Output:");
            for (int i = 0; i < customWords.length; i++) {
                System.out.println((i + 1) + ". " + customWords[i]);
            }

            System.out.println("\nMatches built-in split(): " + isSame);


    }
}
