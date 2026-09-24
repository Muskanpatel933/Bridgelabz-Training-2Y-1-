package Arrays.TimeComplexity;

import java.util.Scanner;

public class Power {
    public static double myPow(int n, int p) {
        double power = Math.pow(n, p);
        return power;
    }

    static void main() {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int p=sc.nextInt();
        System.out.println(myPow(n,p));
    }

}
