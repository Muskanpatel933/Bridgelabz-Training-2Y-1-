package LinkedList.Doubly;

import java.util.Scanner;



    public class LibraryManagementSystem {
        static class Node {
            String title;
            String author;
            String genre;
            int bookId;
            String availabilityStatus;
            Node prev;
            Node next;

            Node(String title, String author, String genre, int bookId, String availabilityStatus) {
                this.title = title;
                this.author = author;
                this.genre = genre;
                this.bookId = bookId;
                this.availabilityStatus = availabilityStatus;
            }
        }

        private Node head;
        private Node tail;

        public void addAtBeginning(String title, String author, String genre, int bookId, String status) {
            Node newNode = new Node(title, author, genre, bookId, status);
            if (head == null) {
                head = tail = newNode;
                return;
            }
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }

        public void addAtEnd(String title, String author, String genre, int bookId, String status) {
            Node newNode = new Node(title, author, genre, bookId, status);
            if (tail == null) {
                head = tail = newNode;
                return;
            }
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }

        public void addAtPosition(int position, String title, String author, String genre, int bookId, String status) {
            if (position <= 1 || head == null) {
                addAtBeginning(title, author, genre, bookId, status);
                return;
            }
            Node curr = head;
            int index = 1;
            while (index < position - 1 && curr.next != null) {
                curr = curr.next;
                index++;
            }
            if (curr.next == null) {
                addAtEnd(title, author, genre, bookId, status);
                return;
            }
            Node newNode = new Node(title, author, genre, bookId, status);
            newNode.next = curr.next;
            newNode.prev = curr;
            curr.next.prev = newNode;
            curr.next = newNode;
        }

        public boolean removeByBookId(int bookId) {
            if (head == null) {
                return false;
            }
            Node curr = head;
            while (curr != null && curr.bookId != bookId) {
                curr = curr.next;
            }
            if (curr == null) {
                return false;
            }
            if (curr == head && curr == tail) {
                head = tail = null;
            } else if (curr == head) {
                head = head.next;
                head.prev = null;
            } else if (curr == tail) {
                tail = tail.prev;
                tail.next = null;
            } else {
                curr.prev.next = curr.next;
                curr.next.prev = curr.prev;
            }
            curr.prev = null;
            curr.next = null;
            return true;
        }

        public void searchByTitleOrAuthor(String query) {
            Node curr = head;
            boolean found = false;
            while (curr != null) {
                if (curr.title.equalsIgnoreCase(query) || curr.author.equalsIgnoreCase(query)) {
                    printBook(curr);
                    found = true;
                }
                curr = curr.next;
            }
            if (!found) {
                System.out.println("No matching books found.");
            }
        }

        public boolean updateAvailability(int bookId, String newStatus) {
            Node curr = head;
            while (curr != null) {
                if (curr.bookId == bookId) {
                    curr.availabilityStatus = newStatus;
                    return true;
                }
                curr = curr.next;
            }
            return false;
        }

        public void displayForward() {
            if (head == null) {
                System.out.println("Library is empty.");
                return;
            }
            Node curr = head;
            while (curr != null) {
                printBook(curr);
                curr = curr.next;
            }
        }

        public void displayReverse() {
            if (tail == null) {
                System.out.println("Library is empty.");
                return;
            }
            Node curr = tail;
            while (curr != null) {
                printBook(curr);
                curr = curr.prev;
            }
        }

        public int countBooks() {
            int count = 0;
            Node curr = head;
            while (curr != null) {
                count++;
                curr = curr.next;
            }
            return count;
        }

        private void printBook(Node b) {
            System.out.println("ID: " + b.bookId + " | Title: " + b.title + " | Author: " + b.author + " | Genre: " + b.genre + " | Status: " + b.availabilityStatus);
        }

        public static void main(String[] args) {
            LibraryManagementSystem lib = new LibraryManagementSystem();
            Scanner sc = new Scanner(System.in);
            int choice;

            do {
                System.out.println("\n1. Add at Beginning\n2. Add at End\n3. Add at Position\n4. Remove by Book ID\n5. Search by Title or Author\n6. Update Availability Status\n7. Display Forward\n8. Display Reverse\n9. Count Total Books\n0. Exit");
                System.out.print("Enter choice: ");
                choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {
                    case 1 -> {
                        System.out.print("Title, Author, Genre, Book ID, Status: ");
                        lib.addAtBeginning(sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextInt(), sc.next());
                    }
                    case 2 -> {
                        System.out.print("Title, Author, Genre, Book ID, Status: ");
                        lib.addAtEnd(sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextInt(), sc.next());
                    }
                    case 3 -> {
                        System.out.print("Position, Title, Author, Genre, Book ID, Status: ");
                        lib.addAtPosition(sc.nextInt(), sc.next(), sc.next(), sc.next(), sc.nextInt(), sc.next());
                    }
                    case 4 -> {
                        System.out.print("Book ID to remove: ");
                        System.out.println(lib.removeByBookId(sc.nextInt()) ? "Removed." : "Not found.");
                    }
                    case 5 -> {
                        System.out.print("Enter Title or Author: ");
                        lib.searchByTitleOrAuthor(sc.nextLine());
                    }
                    case 6 -> {
                        System.out.print("Book ID: ");
                        int id = sc.nextInt();
                        sc.nextLine();
                        System.out.print("New Status: ");
                        System.out.println(lib.updateAvailability(id, sc.nextLine()) ? "Updated." : "Not found.");
                    }
                    case 7 -> lib.displayForward();
                    case 8 -> lib.displayReverse();
                    case 9 -> System.out.println("Total Books: " + lib.countBooks());
                    case 0 -> System.out.println("Exiting...");
                    default -> System.out.println("Invalid choice.");
                }
            } while (choice != 0);


    }
}
