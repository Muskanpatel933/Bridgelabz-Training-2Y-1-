package Recursion;

public class FibonacciNum {
    public static int Fib(int n){
        if(n==0 || n==1){
            return n;
        }
        int small1=Fib(n-1);
        int small2=Fib(n-2);

        return small1+small2;
    }
    public static void main(String[] args) {
        System.out.println(Fib(5));
    }
}
