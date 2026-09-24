package Arrays.TimeComplexity;

import java.util.Scanner;

public class PalindromeNumber {
    public static boolean PalindromeNumber(int n){
        int rev=0;
        int rem=0;
        int q=n;
        while(n>0){
            rem=n%10;
            rev=rev*10+rem;
            n=n/10;
        }
        if(rev==q){
            return true;
        }
        else{
            return false;
        }
    }

    static void main() {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        System.out.println(PalindromeNumber(n));
    }
}
