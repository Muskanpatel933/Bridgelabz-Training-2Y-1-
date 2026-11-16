package Stack;

import java.util.Stack;

public class StackBasics {
    public static void main(String[] args) {
        Stack<Integer> in  = new Stack<>();
        in.push(10);
        in.push(20);
        in.push(30);
        in.push(40);
        in.push(50);

        System.out.println("Stack - " +in);
        in.pop();

        System.out.println("The element which is removed is  -  "+in.pop());
        System.out.println("Returns the top item without removing it -  "+in.peek());

    }





    }

