package Arrays.TimeComplexity;

import java.util.Scanner;

public class GDC {
    public static int GDC(int a, int b){
        int gdc=1;
        for(int i=1;i<=a && i<=b;i++){
            if(a%i==0 && b%i==0){
                gdc=i;
            }
        }
        return gdc;
    }

    static void main() {
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        int b=sc.nextInt();
        System.out.println(GDC(a, b));
    }
}
