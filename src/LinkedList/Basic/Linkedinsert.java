package LinkedList.Basic;

public class Linkedinsert {
    public static class Node {
        int data;
        Node next;

        public Node(int data){

            this.data=data;
        }

    }
    static Node head;
    static Node tail;

    public static void insertAtEnd(int value){
        Node temp= new Node(value);
        if(head==null){
            head = temp;
            tail = temp;
        }else{
            tail.next =temp;
            tail = temp;
        }

    }
    public static void insertAtStart(int value){
        Node temp= new Node(value);
        if(head==null){
            head=temp;
            tail=temp;
        }else{
            head.next=temp;
            head = temp;
        }
    }
    public static void display(){
        Node temp=head;
        while(temp != null){
            System.out.println(temp.data+ " ->");
            temp = temp.next;
        }
    }
    public static int search(int value){
        Node temp = head;
        int index=0;
        while (temp != null){
            if(temp.data == value){
                return index;
            }
            temp=temp.next;
            index++;
        }
        return -1;


    }
}
