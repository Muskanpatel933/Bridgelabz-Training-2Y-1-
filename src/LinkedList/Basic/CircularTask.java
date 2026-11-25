package LinkedList.Basic;

import java.util.Scanner;

public class CircularTask {

        static class Node {
            int taskId;
            String taskName;
            int priority;
            String dueDate;
            Node next;

            Node(int taskId, String taskName, int priority, String dueDate) {
                this.taskId = taskId;
                this.taskName = taskName;
                this.priority = priority;
                this.dueDate = dueDate;
            }
        }

        private Node head;
        private Node tail;
        private Node current;

        public void addAtBeginning(int taskId, String taskName, int priority, String dueDate) {
            Node newNode = new Node(taskId, taskName, priority, dueDate);
            if (head == null) {
                head = tail = current = newNode;
                newNode.next = newNode;
                return;
            }
            newNode.next = head;
            head = newNode;
            tail.next = head;
        }

        public void addAtEnd(int taskId, String taskName, int priority, String dueDate) {
            Node newNode = new Node(taskId, taskName, priority, dueDate);
            if (head == null) {
                head = tail = current = newNode;
                newNode.next = newNode;
                return;
            }
            tail.next = newNode;
            tail = newNode;
            tail.next = head;
        }

        public void addAtPosition(int position, int taskId, String taskName, int priority, String dueDate) {
            if (position <= 1 || head == null) {
                addAtBeginning(taskId, taskName, priority, dueDate);
                return;
            }
            Node curr = head;
            int index = 1;
            while (index < position - 1 && curr.next != head) {
                curr = curr.next;
                index++;
            }
            if (curr == tail) {
                addAtEnd(taskId, taskName, priority, dueDate);
                return;
            }
            Node newNode = new Node(taskId, taskName, priority, dueDate);
            newNode.next = curr.next;
            curr.next = newNode;
        }

        public boolean removeByTaskId(int taskId) {
            if (head == null) {
                return false;
            }
            Node curr = head;
            Node prev = tail;
            do {
                if (curr.taskId == taskId) {
                    if (curr == head && curr == tail) {
                        head = tail = current = null;
                    } else {
                        prev.next = curr.next;
                        if (curr == head) {
                            head = curr.next;
                        }
                        if (curr == tail) {
                            tail = prev;
                        }
                        if (current == curr) {
                            current = curr.next;
                        }
                    }
                    curr.next = null;
                    return true;
                }
                prev = curr;
                curr = curr.next;
            } while (curr != head);
            return false;
        }

        public void viewCurrentAndMoveNext() {
            if (current == null) {
                System.out.println("No tasks scheduled.");
                return;
            }
            System.out.println("Current Task -> ID: " + current.taskId + " | Name: " + current.taskName + " | Priority: " + current.priority + " | Due: " + current.dueDate);
            current = current.next;
        }

        public void displayAll() {
            if (head == null) {
                System.out.println("No tasks scheduled.");
                return;
            }
            Node curr = head;
            do {
                System.out.println("ID: " + curr.taskId + " | Name: " + curr.taskName + " | Priority: " + curr.priority + " | Due: " + curr.dueDate);
                curr = curr.next;
            } while (curr != head);
        }

        public void searchByPriority(int priority) {
            if (head == null) {
                System.out.println("No tasks scheduled.");
                return;
            }
            Node curr = head;
            boolean found = false;
            do {
                if (curr.priority == priority) {
                    System.out.println("ID: " + curr.taskId + " | Name: " + curr.taskName + " | Due: " + curr.dueDate);
                    found = true;
                }
                curr = curr.next;
            } while (curr != head);
            if (!found) {
                System.out.println("No tasks with priority " + priority);
            }
        }

        public static void main(String[] args) {
            CircularTaskScheduler scheduler = new CircularTaskScheduler();
            Scanner sc = new Scanner(System.in);
            int choice;

            do {
                System.out.println("\n1. Add at Beginning\n2. Add at End\n3. Add at Position\n4. Remove by Task ID\n5. View Current & Next Task\n6. Display All Tasks\n7. Search by Priority\n0. Exit");
                System.out.print("Enter choice: ");
                choice = sc.nextInt();

                switch (choice) {
                    case 1 -> {
                        System.out.print("Task ID, Name, Priority, Due Date: ");
                        scheduler.addAtBeginning(sc.nextInt(), sc.next(), sc.nextInt(), sc.next());
                    }
                    case 2 -> {
                        System.out.print("Task ID, Name, Priority, Due Date: ");
                        scheduler.addAtEnd(sc.nextInt(), sc.next(), sc.nextInt(), sc.next());
                    }
                    case 3 -> {
                        System.out.print("Position, Task ID, Name, Priority, Due Date: ");
                        scheduler.addAtPosition(sc.nextInt(), sc.nextInt(), sc.next(), sc.nextInt(), sc.next());
                    }
                    case 4 -> {
                        System.out.print("Task ID to remove: ");
                        System.out.println(scheduler.removeByTaskId(sc.nextInt()) ? "Removed." : "Not found.");
                    }
                    case 5 -> scheduler.viewCurrentAndMoveNext();
                    case 6 -> scheduler.displayAll();
                    case 7 -> {
                        System.out.print("Priority to search: ");
                        scheduler.searchByPriority(sc.nextInt());
                    }
                    case 0 -> System.out.println("Exiting...");
                    default -> System.out.println("Invalid choice.");
                }
            } while (choice != 0);


    }
}
