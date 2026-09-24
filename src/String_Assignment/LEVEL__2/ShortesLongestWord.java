package String_Assignment.LEVEL__2;

import java.util.Scanner;

public class ShortesLongestWord {

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

        public static String[][] getWordsWithLengths(String text) {
            String[] words = customSplit(text);
            String[][] result = new String[words.length][2];

            for (int i = 0; i < words.length; i++) {
                result[i][0] = words[i];
                result[i][1] = String.valueOf(getLength(words[i]));
            }

            return result;
        }

        public static String[] findShortestAndLongest(String[][] wordData) {
            if (wordData.length == 0) {
                return new String[]{"", ""};
            }

            int shortestIndex = 0;
            int longestIndex = 0;

            for (int i = 1; i < wordData.length; i++) {
                int currentLen = Integer.parseInt(wordData[i][1]);
                int shortestLen = Integer.parseInt(wordData[shortestIndex][1]);
                int longestLen = Integer.parseInt(wordData[longestIndex][1]);

                if (currentLen < shortestLen) {
                    shortestIndex = i;
                }
                if (currentLen > longestLen) {
                    longestIndex = i;
                }
            }

            return new String[]{wordData[shortestIndex][0], wordData[longestIndex][0]};
        }

        public static void main(String[] args) {
            Scanner input = new Scanner(System.in);

            System.out.print("Enter a sentence: ");
            String text = input.nextLine();

            String[][] wordData = getWordsWithLengths(text);
            String[] extents = findShortestAndLongest(wordData);

            System.out.println("Shortest word: " + extents[0]);
            System.out.println("Longest word: " + extents[1]);


    }
}
