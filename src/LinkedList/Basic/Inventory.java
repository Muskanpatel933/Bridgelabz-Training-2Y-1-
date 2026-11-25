package LinkedList.Basic;

import java.util.Scanner;


    public class InventoryManagementSystem {
        static class Node {
            String itemName;
            int itemId;
            int quantity;
            double price;           Node next;

            Node(String itemName, int itemId, int quantity, double price) {
                this.itemName = itemName;
                this.itemId = itemId;
                this.quantity = quantity;
                this.price = price;
            }
        }

        private Node head;

        public void addAtBeginning(String itemName, int itemId, int quantity, double price) {
            Node newNode = new Node(itemName, itemId, quantity, price);
            newNode.next = head;
            head = newNode;
        }

        public void addAtEnd(String itemName, int itemId, int quantity, double price) {
            Node newNode = new Node(itemName, itemId, quantity, price);
            if (head == null) {
                head = newNode;
                return;
            }
            Node curr = head;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = newNode;
        }

        public void addAtPosition(int position, String itemName, int itemId, int quantity, double price) {
            if (position <= 1 || head == null) {
                addAtBeginning(itemName, itemId, quantity, price);
                return;
            }
            Node curr = head;
            int index = 1;
            while (index < position - 1 && curr.next != null) {
                curr = curr.next;
                index++;
            }
            Node newNode = new Node(itemName, itemId, quantity, price);
            newNode.next = curr.next;
            curr.next = newNode;
        }

        public boolean removeById(int itemId) {
            if (head == null) {
                return false;
            }
            if (head.itemId == itemId) {
                Node temp = head;
                head = head.next;
                temp.next = null;
                return true;
            }
            Node curr = head;
            while (curr.next != null && curr.next.itemId != itemId) {
                curr = curr.next;
            }
            if (curr.next == null) {
                return false;
            }
            Node target = curr.next;
            curr.next = target.next;
            target.next = null;
            return true;
        }

        public boolean updateQuantity(int itemId, int newQuantity) {
            Node curr = head;
            while (curr != null) {
                if (curr.itemId == itemId) {
                    curr.quantity = newQuantity;
                    return true;
                }
                curr = curr.next;
            }
            return false;
        }

        public void searchByIdOrName(Integer itemId, String itemName) {
            Node curr = head;
            boolean found = false;
            while (curr != null) {
                boolean idMatch = itemId != null && curr.itemId == itemId;
                boolean nameMatch = itemName != null && curr.itemName.equalsIgnoreCase(itemName);
                if (idMatch || nameMatch) {
                    System.out.println("ID: " + curr.itemId + " | Name: " + curr.itemName + " | Qty: " + curr.quantity + " | Price: " + curr.price);
                    found = true;
                }
                curr = curr.next;
            }
            if (!found) {
                System.out.println("Item not found.");
            }
        }

        public double calculateTotalValue() {
            double total = 0.0;
            Node curr = head;
            while (curr != null) {
                total += curr.price * curr.quantity;
                curr = curr.next;
            }
            return total;
        }

        public void sortInventory(boolean byPrice, boolean ascending) {
            head = mergeSort(head, byPrice, ascending);
        }

        private Node mergeSort(Node node, boolean byPrice, boolean ascending) {
            if (node == null || node.next == null) {
                return node;
            }
            Node mid = getMiddle(node);
            Node rightHalf = mid.next;
            mid.next = null;

            Node left = mergeSort(node, byPrice, ascending);
            Node right = mergeSort(rightHalf, byPrice, ascending);

            return merge(left, right, byPrice, ascending);
        }

        private Node getMiddle(Node node) {
            Node slow = node;
            Node fast = node.next;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow;
        }

        private Node merge(Node a, Node b, boolean byPrice, boolean ascending) {
            Node dummy = new Node("", 0, 0, 0);
            Node tail = dummy;

            while (a != null && b != null) {
                int cmp;
                if (byPrice) {
                    cmp = Double.compare(a.price, b.price);
                } else {
                    cmp = a.itemName.compareToIgnoreCase(b.itemName);
                }
                boolean takeA = ascending ? (cmp <= 0) : (cmp >= 0);
                if (takeA) {
                    tail.next = a;
                    a = a.next;
                } else {
                    tail.next = b;
                    b = b.next;
                }
                tail = tail.next;
            }
            tail.next = (a != null) ? a : b;
            return dummy.next;
        }

        public void displayAll() {
            if (head == null) {
                System.out.println("Inventory is empty.");
                return;
            }
            Node curr = head;
            while (curr != null) {
                System.out.println("ID: " + curr.itemId + " | Name: " + curr.itemName + " | Qty: " + curr.quantity + " | Price: " + curr.price);
                curr = curr.next;
            }
        }

        public static void main(String[] args) {
            InventoryManagementSystem inv = new InventoryManagementSystem();
            Scanner sc = new Scanner(System.in);
            int choice;

            do {
                System.out.println("\n1. Add at Beginning\n2. Add at End\n3. Add at Position\n4. Remove by ID\n5. Update Quantity\n6. Search by ID\n7. Search by Name\n8. Total Inventory Value\n9. Sort Inventory\n10. Display All\n0. Exit");
                System.out.print("Enter choice: ");
                choice = sc.nextInt();

                switch (choice) {
                    case 1 -> {
                        System.out.print("Name, ID, Qty, Price: ");
                        inv.addAtBeginning(sc.next(), sc.nextInt(), sc.nextInt(), sc.nextDouble());
                    }
                    case 2 -> {
                        System.out.print("Name, ID, Qty, Price: ");
                        inv.addAtEnd(sc.next(), sc.nextInt(), sc.nextInt(), sc.nextDouble());
                    }
                    case 3 -> {
                        System.out.print("Position, Name, ID, Qty, Price: ");
                        inv.addAtPosition(sc.nextInt(), sc.next(), sc.nextInt(), sc.nextInt(), sc.nextDouble());
                    }
                    case 4 -> {
                        System.out.print("Item ID to remove: ");
                        System.out.println(inv.removeById(sc.nextInt()) ? "Removed." : "Not found.");
                    }
                    case 5 -> {
                        System.out.print("Item ID and New Qty: ");
                        System.out.println(inv.updateQuantity(sc.nextInt(), sc.nextInt()) ? "Updated." : "Not found.");
                    }
                    case 6 -> {
                        System.out.print("Item ID: ");
                        inv.searchByIdOrName(sc.nextInt(), null);
                    }
                    case 7 -> {
                        System.out.print("Item Name: ");
                        inv.searchByIdOrName(null, sc.next());
                    }
                    case 8 -> System.out.println("Total Inventory Value: " + inv.calculateTotalValue());
                    case 9 -> {
                        System.out.print("Sort by (1 for Name, 2 for Price): ");
                        boolean byPrice = sc.nextInt() == 2;
                        System.out.print("Order (1 for Asc, 2 for Desc): ");
                        boolean asc = sc.nextInt() == 1;
                        inv.sortInventory(byPrice, asc);
                        System.out.println("Sorted.");
                    }
                    case 10 -> inv.displayAll();
                    case 0 -> System.out.println("Exiting...");
                    default -> System.out.println("Invalid choice.");
                }
            } while (choice != 0);


    }
}
