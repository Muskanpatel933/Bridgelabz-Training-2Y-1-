package LinkedList.Basic;

import java.util.Scanner;

public class StudentRecordMan {

        static class Node {
            int rollNumber;
            String name;
            int age;
            String grade;
            Node next;

            Node(int rollNumber, String name, int age, String grade) {
                this.rollNumber = rollNumber;
                this.name = name;
                this.age = age;
                this.grade = grade;
                this.next = null;
            }
        }

        private Node head;

        public void addAtBeginning(int rollNumber, String name, int age, String grade) {
            Node newNode = new Node(rollNumber, name, age, grade);
            newNode.next = head;
            head = newNode;
        }

        public void addAtEnd(int rollNumber, String name, int age, String grade) {
            Node newNode = new Node(rollNumber, name, age, grade);
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

        public void addAtPosition(int position, int rollNumber, String name, int age, String grade) {
            if (position <= 1 || head == null) {
                addAtBeginning(rollNumber, name, age, grade);
                return;
            }
            Node newNode = new Node(rollNumber, name, age, grade);
            Node curr = head;
            int index = 1;
            while (index < position - 1 && curr.next != null) {
                curr = curr.next;
                index++;
            }
            newNode.next = curr.next;
            curr.next = newNode;
        }

        public boolean deleteByRollNumber(int rollNumber) {
            if (head == null) {
                return false;
            }
            if (head.rollNumber == rollNumber) {
                Node temp = head;
                head = head.next;
                temp.next = null;
                return true;
            }
            Node curr = head;
            while (curr.next != null && curr.next.rollNumber != rollNumber) {
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

        public Node searchByRollNumber(int rollNumber) {
            Node curr = head;
            while (curr != null) {
                if (curr.rollNumber == rollNumber) {
                    return curr;
                }
                curr = curr.next;
            }
            return null;
        }

        public void displayAll() {
            if (head == null) {
                System.out.println("No student records found.");
                return;
            }
            Node curr = head;
            while (curr != null) {
                System.out.println("Roll No: " + curr.rollNumber + " | Name: " + curr.name + " | Age: " + curr.age + " | Grade: " + curr.grade);
                curr = curr.next;
            }
        }

        public boolean updateGrade(int rollNumber, String newGrade) {
            Node target = searchByRollNumber(rollNumber);
            if (target == null) {
                return false;
            }
            target.grade = newGrade;
            return true;
        }

        public static void main(String[] args) {
            StudentRecordMan system = new StudentRecordMan();
            Scanner sc = new Scanner(System.in);
            int choice;

            do {
                System.out.println("\n1. Add at Beginning\n2. Add at End\n3. Add at Position\n4. Delete by Roll Number\n5. Search by Roll Number\n6. Display All\n7. Update Grade\n0. Exit");
                System.out.print("Enter choice: ");
                choice = sc.nextInt();

                switch (choice) {
                    case 1 -> {
                        System.out.print("Roll No, Name, Age, Grade: ");
                        system.addAtBeginning(sc.nextInt(), sc.next(), sc.nextInt(), sc.next());
                    }
                    case 2 -> {
                        System.out.print("Roll No, Name, Age, Grade: ");
                        system.addAtEnd(sc.nextInt(), sc.next(), sc.nextInt(), sc.next());
                    }
                    case 3 -> {
                        System.out.print("Position, Roll No, Name, Age, Grade: ");
                        system.addAtPosition(sc.nextInt(), sc.nextInt(), sc.next(), sc.nextInt(), sc.next());
                    }
                    case 4 -> {
                        System.out.print("Roll No to delete: ");
                        System.out.println(system.deleteByRollNumber(sc.nextInt()) ? "Deleted." : "Not found.");
                    }
                    case 5 -> {
                        System.out.print("Roll No to search: ");
                        Node n = system.searchByRollNumber(sc.nextInt());
                        System.out.println(n != null ? ("Found: " + n.name + " (" + n.grade + ")") : "Not found.");
                    }
                    case 6 -> system.displayAll();
                    case 7 -> {
                        System.out.print("Roll No and New Grade: ");
                        System.out.println(system.updateGrade(sc.nextInt(), sc.next()) ? "Updated." : "Not found.");
                    }
                    case 0 -> System.out.println("Exiting...");
                    default -> System.out.println("Invalid choice.");
                }
            } while (choice != 0);


    }
}
