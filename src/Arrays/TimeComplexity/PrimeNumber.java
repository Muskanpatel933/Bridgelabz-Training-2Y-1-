package Arrays.TimeComplexity;

import java.util.Scanner;

public class PrimeNumber {
    public static boolean Prime(int n){
        boolean isPrime=true;
        if(n<=0){
            System.out.println("False");
        }
        for(int i=2;i<n;i++){
            if(n%i==0){
                isPrime=false;
            }
        }
        if(isPrime){
            return true;
        }
        else{
            return false;
        }
    }

    static void main() {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        System.out.println(Prime(n));
    }
}
