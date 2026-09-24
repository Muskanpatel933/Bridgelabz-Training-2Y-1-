package leetcode;

import java.util.Scanner;

public class Leetcode_11 {
    public static int maxArea(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int max = 0;
        while (i < j) {
            int maxWater = Math.min(height[i], height[j]) * (j - i);
            if (height[i] <height[j] ) {
                i++;
            } else {
                j--;
            }
        }
        return max;


    }

    static void main() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter height");
        int n = sc.nextInt();

        int[] height = new int[n];
        System.out.println("Enter " + n + "elements");
        for (int k = 0; k < n; k++) {
            height[k] = sc.nextInt();
        }
        int result = maxArea(height);
        System.out.println("Max area" + result);

    }
}
