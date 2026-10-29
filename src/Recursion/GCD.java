package Recursion;

public class GCD {
    public static int gcd(int x,int y){
        if(y==0){
            return x;
        }
        return gcd(y,x%y);
    }
    public static int lcm(int x,int y){
        return (x*y)/ gcd(x ,y);
    }


    public static void main(String[] args){
        System.out.println(gcd(12,16) + " is GCD ");
        System.out.println(lcm(12,16) +" is LCM");

    }
}
