package LinkedList.Doubly;

import java.util.Scanner;

public class MovieManagement {

        static class Node {
            String title;
            String director;
            int year;
            double rating;
            Node prev;
            Node next;

            Node(String title, String director, int year, double rating) {
                this.title = title;
                this.director = director;
                this.year = year;
                this.rating = rating;
            }
        }

        private Node head;
        private Node tail;

        public void addAtBeginning(String title, String director, int year, double rating) {
            Node newNode = new Node(title, director, year, rating);
            if (head == null) {
                head = tail = newNode;
                return;
            }
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }

        public void addAtEnd(String title, String director, int year, double rating) {
            Node newNode = new Node(title, director, year, rating);
            if (tail == null) {
                head = tail = newNode;
                return;
            }
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }

        public void addAtPosition(int position, String title, String director, int year, double rating) {
            if (position <= 1 || head == null) {
                addAtBeginning(title, director, year, rating);
                return;
            }
            Node curr = head;
            int index = 1;
            while (index < position - 1 && curr.next != null) {
                curr = curr.next;
                index++;
            }
            if (curr.next == null) {
                addAtEnd(title, director, year, rating);
                return;
            }
            Node newNode = new Node(title, director, year, rating);
            newNode.next = curr.next;
            newNode.prev = curr;
            curr.next.prev = newNode;
            curr.next = newNode;
        }

        public boolean removeByTitle(String title) {
            if (head == null) {
                return false;
            }
            Node curr = head;
            while (curr != null && !curr.title.equalsIgnoreCase(title)) {
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

        public void searchByDirectorOrRating(String director, Double minRating) {
            if (head == null) {
                System.out.println("No movies in list.");
                return;
            }
            Node curr = head;
            boolean found = false;
            while (curr != null) {
                boolean matchesDirector = director != null && curr.director.equalsIgnoreCase(director);
                boolean matchesRating = minRating != null && curr.rating >= minRating;
                if (matchesDirector || matchesRating) {
                    printMovie(curr);
                    found = true;
                }
                curr = curr.next;
            }
            if (!found) {
                System.out.println("No matching movies found.");
            }
        }

        public void displayForward() {
            if (head == null) {
                System.out.println("No movies in list.");
                return;
            }
            Node curr = head;
            while (curr != null) {
                printMovie(curr);
                curr = curr.next;
            }
        }

        public void displayReverse() {
            if (tail == null) {
                System.out.println("No movies in list.");
                return;
            }
            Node curr = tail;
            while (curr != null) {
                printMovie(curr);
                curr = curr.prev;
            }
        }

        public boolean updateRating(String title, double newRating) {
            Node curr = head;
            while (curr != null) {
                if (curr.title.equalsIgnoreCase(title)) {
                    curr.rating = newRating;
                    return true;
                }
                curr = curr.next;
            }
            return false;
        }

        private void printMovie(Node m) {
            System.out.println("Title: " + m.title + " | Director: " + m.director + " | Year: " + m.year + " | Rating: " + m.rating);
        }

        public static void main(String[] args) {
            MovieManagement system = new MovieManagement();
            Scanner sc = new Scanner(System.in);
            int choice;

            do {
                System.out.println("\n1. Add at Beginning\n2. Add at End\n3. Add at Position\n4. Remove by Title\n5. Search by Director\n6. Search by Min Rating\n7. Display Forward\n8. Display Reverse\n9. Update Rating\n0. Exit");
                System.out.print("Enter choice: ");
                choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {
                    case 1 -> {
                        System.out.print("Title, Director, Year, Rating: ");
                        system.addAtBeginning(sc.nextLine(), sc.nextLine(), sc.nextInt(), sc.nextDouble());
                    }
                    case 2 -> {
                        System.out.print("Title, Director, Year, Rating: ");
                        system.addAtEnd(sc.nextLine(), sc.nextLine(), sc.nextInt(), sc.nextDouble());
                    }
                    case 3 -> {
                        System.out.print("Position, Title, Director, Year, Rating: ");
                        system.addAtPosition(sc.nextInt(), sc.next(), sc.next(), sc.nextInt(), sc.nextDouble());
                    }
                    case 4 -> {
                        System.out.print("Title to remove: ");
                        System.out.println(system.removeByTitle(sc.nextLine()) ? "Removed." : "Not found.");
                    }
                    case 5 -> {
                        System.out.print("Director: ");
                        system.searchByDirectorOrRating(sc.nextLine(), null);
                    }
                    case 6 -> {
                        System.out.print("Minimum Rating: ");
                        system.searchByDirectorOrRating(null, sc.nextDouble());
                    }
                    case 7 -> system.displayForward();
                    case 8 -> system.displayReverse();
                    case 9 -> {
                        System.out.print("Title: ");
                        String t = sc.nextLine();
                        System.out.print("New Rating: ");
                        System.out.println(system.updateRating(t, sc.nextDouble()) ? "Updated." : "Not found.");
                    }
                    case 0 -> System.out.println("Exiting...");
                    default -> System.out.println("Invalid choice.");
                }
            } while (choice != 0);


        }

}
