package Arrays.TimeComplexity;

import java.util.Scanner;

public class Reverse {
    public static int Reverse(int n){
        int q=n;
        int rev=0;
        int rem=0;
        while(n>0){
            rem=n%10;
            rev=rev*10+rem;
            n=n/10;
        }
        return rev;
    }

    static void main() {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        System.out.println(Reverse(n));
    }
}
