package leetcode;

import java.util.ArrayList;
import java.util.Scanner;

public class LongestSubstring {
    public static int Leetcode_3(String s) {
        int start =0;
        int end=0;
        int max=0;

        ArrayList<Character> list = new ArrayList<>();

        while(end<s.length()){
            if(!list.contains(s.charAt(end))){
                list.add(s.charAt(end));
                end++;

                max = Math.max(max,list.size());
            }
            else{
            list.remove(Character.valueOf(s.charAt(start)));
            start++;
        }
    }
        return max;

}
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int result  = Leetcode_3(s);
    }
}
