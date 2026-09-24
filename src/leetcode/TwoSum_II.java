package leetcode;

import java.util.Scanner;

public class TwoSum_II {
    public static int[] InputArray(int[] nums,int target){
        int start=0;
        int end=nums.length-1;
        while(start<end){
            int sum = nums[start]+nums[end];
            if(sum ==target) {
                return new int[]{start + 1, end + 1};
            } else if(sum<target){
                    start++;
                }else{
                    end--;
                }


            }
        return new int[]{};


    }

    static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter number");
        int n=sc.nextInt();
        int nums[] = new int[n];
        for(int i=0;i<nums.length;i++){
            nums[i] =sc.nextInt();
        }
        System.out.println("Enter a target");
        int target = sc.nextInt();
        int[] result = InputArray(nums, target);
        if (result.length > 0) {
            System.out.println("Indices: " + result[0] + ", " + result[1]);
        } else {
            System.out.println("No solution found.");
        }
    }
    }
