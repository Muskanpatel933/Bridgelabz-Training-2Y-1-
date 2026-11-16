package LinkedList.Basic;

public class FindMidd {
    public static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }


    public static Node head = null;
    public static Node tail = null;
    public static Node Middle(){
        if(head==null){
            return null;
        }
        Node slow=head;
        Node fast= head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
