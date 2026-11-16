package LinkedList.Doubly;

public class InsertFirst {
    public static class Node{
        int data;
        Node next;
        Node prev;

        public Node(int data){
            this.data  = data;
        }

        public static Node head;
        public static Node tail;

        public static void insertFirst(int data){
            Node newNode  = new Node(data);
            if(head == null){
                head = tail;
                tail = newNode;
                return;
            }
            newNode.next = head;
            head.prev = newNode;

            head = newNode;

        }



    }
}
