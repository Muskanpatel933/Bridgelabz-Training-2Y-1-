package leetcode;

import java.util.Scanner;

public class Leetcode_26 {
            public static int RemoveDuplicates(int[] nums) {
            if (nums.length == 0) return 0;

            int k = 1;
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] != nums[k - 1]) {
                    nums[k] = nums[i];
                    k++;
                }
            }
            return k;
        }

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter size of array:");
            int n = sc.nextInt();
            int nums[] = new int[n];

            System.out.println("Enter elements:");
            for (int i = 0; i < nums.length; i++) {
                nums[i] = sc.nextInt();
            }

            int k = RemoveDuplicates(nums);
            System.out.println("Array after removing duplicates:");
            for (int i = 0; i < k; i++) {
                System.out.print(nums[i] + " ");
            }
        }
    }




