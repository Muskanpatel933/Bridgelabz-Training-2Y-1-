package leetcode;

import java.util.Arrays;
import java.util.Scanner;

public class Leetcode_88 {
    public static int[] MergerSortedArray(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < n; i++) {
            nums1[m + i] = nums2[i];

        }
        Arrays.sort(nums1);
        return nums1;
    }
    static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter A NUM");
        int a=sc.nextInt();
        int nums1[] = new int[a];
        int m=sc.nextInt();
        int b=sc.nextInt();
        int nums2[] = new int[b];
        int n=sc.nextInt();


        MergerSortedArray(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }
    }

