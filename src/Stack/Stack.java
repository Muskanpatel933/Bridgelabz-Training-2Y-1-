package Stack;

public class Stack {
    int top;
    int arr[];

    public Stack(int size) {
        this.top = -1;
        this.arr = new int[size];
    }

    void push(int x) {
        if (top == arr.length - 1) {
            System.out.println("Stack full +");
            return;
        }
        top++;
        arr[top] = x;
    }

    public void display() {
        if (top == -1) {
            System.out.println("Stack empty");
            return;
        }
        for (int i = top; i >= 0; i--) {
            System.out.println(arr[i] + "");
        }
    }

    public void peek() {
        if (top == -1) {
            System.out.println("stack empty");
            return;
        }
        System.out.println("top element: " + arr[top]);
    }

    public void pop() {
        if (top == -1) {
            System.out.println("stack empty");
            return;
        }
        System.out.println("pop element " + arr[top]);
        top--;
    }
}
     class main{
        public static void main(String[] args){
            Stack st = new Stack(5);
            st.push(10);
            st.push(20);
            st.push(30);
            st.push(40);
            st.push(50);
            st.push(60);
            st.display();
           // st.peek();
            //st.pop();
            //st.display();
        }
    }


