package leetcode;

import java.util.Arrays;
import java.util.Scanner;

public class Leetcode_643 {
    static double MaximumAverageSubarray(int[] nums, int size) {
        int sum = 0;
        int maxSum = 0;
        for (int i = 0; i < size; i++) {
            sum = sum + nums[i];
        }
        maxSum = sum;
        for (int i = 1; i < nums.length; i++) {
            sum = sum - nums[i + 1] + nums[i + size - 1];
            maxSum = Math.max(sum, maxSum);
        }
        return (double) maxSum / size;
    }


        public static void main (String[]args){
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int nums[] = new int[n];
            for (int i = 0; i < nums.length; i++) {
                nums[i] =sc.nextInt();
                int size = sc.nextInt();

                double result = MaximumAverageSubarray(nums, size);
                System.out.println(Arrays.toString(nums));
            }
        }
    }

