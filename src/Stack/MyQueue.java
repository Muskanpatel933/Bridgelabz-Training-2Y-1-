package Stack;


    import java.util.Stack;

    class MyQueue {
        private Stack<Integer> inStack;
        private Stack<Integer> outStack;

        public MyQueue() {
            inStack = new Stack<>();
            outStack = new Stack<>();
        }

        public void push(int x) {
            inStack.push(x);
        }

        public int pop() {
            shiftStacks();
            return outStack.pop();
        }

        public int peek() {
            shiftStacks();
            return outStack.peek();
        }

        public boolean empty() {
            return inStack.isEmpty() && outStack.isEmpty();
        }

        private void shiftStacks() {
            if (outStack.isEmpty()) {
                while (!inStack.isEmpty()) {
                    outStack.push(inStack.pop());
                }
            }
        }


            public static void main (String[]args){
                MyQueue q = new MyQueue();
                q.push(10);
                q.push(20);
                q.push(30);
                System.out.println(q.pop());
                System.out.println(q.peek());
                System.out.println(q.pop());
                System.out.println(q.empty());
            }

}
