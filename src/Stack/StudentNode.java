package Stack;

import java.util.Scanner;

public class StudentNode {

        int rollNumber;
        String name;
        int age;
        String grade;
        StudentNode next;

        public StudentNode(int rollNumber, String name, int age, String grade) {
            this.rollNumber = rollNumber;
            this.name = name;
            this.age = age;
            this.grade = grade;
            this.next = null;
        }
    }

    class StudentLinkedList {
        private StudentNode head;


        public void addAtBeginning(int rollNumber, String name, int age, String grade) {
            StudentNode newNode = new StudentNode(rollNumber, name, age, grade);
            newNode.next = head;
            head = newNode;
            System.out.println("Student added at the beginning.");
        }


        public void addAtEnd(int rollNumber, String name, int age, String grade) {
            StudentNode newNode = new StudentNode(rollNumber, name, age, grade);
            if (head == null) {
                head = newNode;
                System.out.println("Student added as the first record.");
                return;
            }
            StudentNode temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
            System.out.println("Student added at the end.");
        }

        public void addAtPosition(int position, int rollNumber, String name, int age, String grade) {
            if (position < 1) {
                System.out.println("Invalid position! Position must be >= 1.");
                return;
            }
            if (position == 1) {
                addAtBeginning(rollNumber, name, age, grade);
                return;
            }

            StudentNode newNode = new StudentNode(rollNumber, name, age, grade);
            StudentNode temp = head;

            for (int i = 1; i < position - 1 && temp != null; i++) {
                temp = temp.next;
            }

            if (temp == null) {
                System.out.println("Position out of bounds!");
                return;
            }

            newNode.next = temp.next;
            temp.next = newNode;
            System.out.println("Student added at position " + position + ".");
        }

        public void deleteByRollNumber(int rollNumber) {
            if (head == null) {
                System.out.println("List is empty.");
                return;
            }

            if (head.rollNumber == rollNumber) {
                head = head.next;
                System.out.println("Student with Roll Number " + rollNumber + " deleted.");
                return;
            }

            StudentNode temp = head;
            while (temp.next != null && temp.next.rollNumber != rollNumber) {
                temp = temp.next;
            }

            if (temp.next == null) {
                System.out.println("Student with Roll Number " + rollNumber + " not found.");
            } else {
                temp.next = temp.next.next;
                System.out.println("Student with Roll Number " + rollNumber + " deleted.");
            }
        }


        public void searchByRollNumber(int rollNumber) {
            StudentNode temp = head;
            while (temp != null) {
                if (temp.rollNumber == rollNumber) {
                    System.out.println("Record Found -> Roll No: " + temp.rollNumber +
                            ", Name: " + temp.name +
                            ", Age: " + temp.age +
                            ", Grade: " + temp.grade);
                    return;
                }
                temp = temp.next;
            }
            System.out.println("Student with Roll Number " + rollNumber + " not found.");
        }


        public void displayAll() {
            if (head == null) {
                System.out.println("No student records found.");
                return;
            }
            System.out.println("\n--- Student Records ---");
            StudentNode temp = head;
            while (temp != null) {
                System.out.println("Roll No: " + temp.rollNumber +
                        " | Name: " + temp.name +
                        " | Age: " + temp.age +
                        " | Grade: " + temp.grade);
                temp = temp.next;
            }
            System.out.println("-----------------------");
        }
        public void updateGrade(int rollNumber, String newGrade) {
            StudentNode temp = head;
            while (temp != null) {
                if (temp.rollNumber == rollNumber) {
                    temp.grade = newGrade;
                    System.out.println("Grade updated for Roll Number " + rollNumber + ".");
                    return;
                }
                temp = temp.next;
            }
            System.out.println("Student with Roll Number " + rollNumber + " not found.");
        }


    public class Main {
        public static void main(String[] args) {
            StudentLinkedList list = new StudentLinkedList();
            Scanner sc = new Scanner(System.in);
            int choice;

            do {
                System.out.println("\n=== Student Record Management ===");
                System.out.println("1. Add Student at Beginning");
                System.out.println("2. Add Student at End");
                System.out.println("3. Add Student at Specific Position");
                System.out.println("4. Delete Student by Roll Number");
                System.out.println("5. Search Student by Roll Number");
                System.out.println("6. Display All Students");
                System.out.println("7. Update Student Grade");
                System.out.println("0. Exit");
                System.out.print("Enter your choice: ");
                choice = sc.nextInt();

                switch (choice) {
                    case 1:
                    case 2:
                    case 3:
                        int pos = 0;
                        if (choice == 3) {
                            System.out.print("Enter position: ");
                            pos = sc.nextInt();
                        }
                        System.out.print("Enter Roll Number: ");
                        int roll = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Enter Name: ");
                        String name = sc.nextLine();
                        System.out.print("Enter Age: ");
                        int age = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Enter Grade: ");
                        String grade = sc.nextLine();

                        if (choice == 1) list.addAtBeginning(roll, name, age, grade);
                        else if (choice == 2) list.addAtEnd(roll, name, age, grade);
                        else list.addAtPosition(pos, roll, name, age, grade);
                        break;

                    case 4:
                        System.out.print("Enter Roll Number to delete: ");
                        list.deleteByRollNumber(sc.nextInt());
                        break;

                    case 5:
                        System.out.print("Enter Roll Number to search: ");
                        list.searchByRollNumber(sc.nextInt());
                        break;

                    case 6:
                        list.displayAll();
                        break;

                    case 7:
                        System.out.print("Enter Roll Number to update grade: ");
                        int updateRoll = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Enter New Grade: ");
                        String newGrade = sc.nextLine();
                        list.updateGrade(updateRoll, newGrade);
                        break;

                    case 0:
                        System.out.println("Exiting...");
                        break;

                    default:
                        System.out.println("Invalid choice! Try again.");
                }
            } while (choice != 0);


        }
    }

    }
