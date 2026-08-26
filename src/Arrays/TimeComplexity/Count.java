package Arrays.TimeComplexity;

import java.util.Scanner;

public class Count {
        public static int count(int n){
            int count = 0;
            while(n>0){
                count ++ ;
                n=n/10;
            }
            return count;
        }

        static void main() {
            Scanner sc = new Scanner(System.in);
            int n=sc.nextInt();
            System.out.println(count(n));
        }
    }

