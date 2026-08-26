package Arrays.TimeComplexity;

import java.util.Scanner;

public class SumOfNaturalNum {
    public static int Sum(int n){
        int sum = 0;
        for(int i=0;i<=n;i++){
            sum+=i;
        }
        return sum;
    }

    static void main() {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        System.out.println(Sum(n));
    }


}
