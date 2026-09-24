package leetcode;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ContainsDuplicateII {
    public static boolean leetcode219(int[] nums,int k){
        Set<Integer>  set = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if(set.contains(nums[i])) {
                return true;
            }
            if(i>k){
                set.remove(nums[i-k]);
            }
        }
        return false;
    }
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println("Enter a number");
        int[] nums = new int[n];
        for(int i=0;i<nums.length;i++){
            nums[i] = sc.nextInt();
        }
        System.out.println("Enter a number");
        int k = sc.nextInt();
        System.out.println(leetcode219(nums,k));

    }
}
