package Recursion;

public class SumOfDigits {
    public static int sum(int n){
        if(n<10){
            return n;
        }
        int s1=n%10;
        int s2=sum(n/10);
        return s1+s2;

    }
    static void main(String[] args) {
        System.out.println(sum(12345));

    }
}
