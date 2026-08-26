package Arrays.TimeComplexity;

import java.util.Scanner;

public class ArmstrongNumber {
    static int count(int n) {
        int count=0;
        while(n<0){
            count++;
            n=n/10;
        }
        return count;
    }
    public static boolean ArmstrongNumber(int n){
        int q=n;
        int rem=0;
        int sum =0;
        int d = count(n);
        while(n>0){
            rem = n%10;
            sum = (int)(sum + (Math.pow(rem,d)));
            n=n/10;
        }
        if(sum==q){
            return true;
        }
        else{
            return false;
        }
    }
    static void main(){
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        System.out.println(ArmstrongNumber(n));
    }
}
