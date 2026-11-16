package LinkedList.Basic;



public class BasicLinkedList {
    public static Node head;
    public static Node tail;
    public static void insertAtEnd(int data) {
        Node temp = new Node(data);

        if (head == null) {
            head = temp;
            tail = temp;
        } else {
            tail.next = temp;
            tail = temp;
        }
    }
    public static void main(String[] args) {
        Node a = new Node(5);
        Node b = new Node(6);
        Node c = new Node(7);
        Node d = new Node(8);
        Node e = new Node(9);

        a.next =b;
        b.next =c;
        c.next =d;
        d.next =e;

        System.out.println("Trick 1");
        System.out.print(a.data +" ->");
        System.out.print(b.data +" ->");
        System.out.print(c.data +" ->");
        System.out.print(d.data +" ->");
        System.out.println(e.data +" ->");

        System.out.println("Trick 2");
        System.out.print(a.data +" ->");
        System.out.print(a.next.data +" ->");
        System.out.print(a.next.next.data +" ->");
        System.out.print(a.next.next.next.data +" ->");
        System.out.print(a.next.next.next.next.data +" ->");

        System.out.println(a.next);
        System.out.println(b.data);
    }
    public static void display(Node head) {
        while (head != null) {
            System.out.print(head.data + "->");

            head = head.next;
        }
    }
        public static void recursiveLinkedList(Node head){
            if(head==null){
                return;
            }
            System.out.println();
        }
    }

