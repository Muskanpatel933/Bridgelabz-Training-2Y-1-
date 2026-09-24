package leetcode;

import java.util.Scanner;

public class MaximumSumOfSubArray {
    public static int LeetCode_643(int[] arr , int k){
        int sum = 0;
        int max=0;
        for(int i=0;i<k;i++){
            sum =sum + arr[i];
        }
        max = sum;
        for(int i=1;i<=arr.length-k;i++){
            sum = sum - arr[i-1]+arr[i+k-1];
            max = Math.max(sum,max);
        }
        return sum;
    }

    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<arr.length;i++){
           arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();
    }





}
