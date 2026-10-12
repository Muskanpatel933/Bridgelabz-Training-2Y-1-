package Recursion.BasicProgramming;

public class Demo1 {
    static void function1() {
        int x=1;
        function2();
        System.out.println(x);
        //return x;
    }

    static void function2() {
        int x=2;
        function3();
        System.out.println(x);
        //return x;
    }

    static void function3() {
        int x=3;
        System.out.println(x);
        //return x;
    }

    static void main(String[] args) {
        function1();
        //System.out.println(function1());{In return methods only one value return 

    }
}
