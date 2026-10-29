package Recursion;

public class PowerOfNum {
    public static int power(int p,int q){
    if(q==0) {
        return 1;
    }
    int small = power(p, q-1);
    return p * small;
    }

    static void main(String[] args) {
        System.out.println(power(5,2));

    }
}
