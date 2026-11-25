package Stack;

public class MovieNode {

        String title, director;
        int year;
        double rating;
        MovieNode next, prev;

        MovieNode(String title, String director, int year, double rating) {
            this.title = title;
            this.director = director;
            this.year = year;
            this.rating = rating;
        }
    }

    class MovieDoublyLinkedList {
        private MovieNode head, tail;

        public void addAtBeginning(String title, String director, int year, double rating) {
            MovieNode n = new MovieNode(title, director, year, rating);
            if (head == null) head = tail = n;
            else { n.next = head; head.prev = n; head = n; }
        }

        public void addAtEnd(String title, String director, int year, double rating) {
            MovieNode n = new MovieNode(title, director, year, rating);
            if (tail == null) head = tail = n;
            else { tail.next = n; n.prev = tail; tail = n; }
        }

        public void addAtPosition(int pos, String title, String director, int year, double rating) {
            if (pos <= 1 || head == null) { addAtBeginning(title, director, year, rating); return; }
            MovieNode temp = head;
            for (int i = 1; i < pos - 1 && temp.next != null; i++) temp = temp.next;
            if (temp.next == null) { addAtEnd(title, director, year, rating); return; }
            MovieNode n = new MovieNode(title, director, year, rating);
            n.next = temp.next;
            n.prev = temp;
            temp.next.prev = n;
            temp.next = n;
        }

        public void removeByTitle(String title) {
            MovieNode temp = head;
            while (temp != null && !temp.title.equalsIgnoreCase(title)) temp = temp.next;
            if (temp == null) return;
            if (temp == head && temp == tail) head = tail = null;
            else if (temp == head) { head = head.next; head.prev = null; }
            else if (temp == tail) { tail = tail.prev; tail.next = null; }
            else { temp.prev.next = temp.next; temp.next.prev = temp.prev; }
        }

        public void searchByDirector(String director) {
            for (MovieNode temp = head; temp != null; temp = temp.next)
                if (temp.director.equalsIgnoreCase(director)) print(temp);
        }

        public void searchByRating(double rating) {
            for (MovieNode temp = head; temp != null; temp = temp.next)
                if (temp.rating == rating) print(temp);
        }

        public void displayForward() {
            for (MovieNode temp = head; temp != null; temp = temp.next) print(temp);
        }

        public void displayReverse() {
            for (MovieNode temp = tail; temp != null; temp = temp.prev) print(temp);
        }

        public void updateRating(String title, double newRating) {
            for (MovieNode temp = head; temp != null; temp = temp.next)
                if (temp.title.equalsIgnoreCase(title)) { temp.rating = newRating; return; }
        }

        private void print(MovieNode m) {
            System.out.println(m.title + " | " + m.director + " | " + m.year + " | " + m.rating);
        }


    public class Main {
        public static void main(String[] args) {
            MovieDoublyLinkedList list = new MovieDoublyLinkedList();
            list.addAtBeginning("Inception", "Nolan", 2010, 8.8);
            list.addAtEnd("Interstellar", "Nolan", 2014, 8.7);
            list.addAtPosition(2, "Dunkirk", "Nolan", 2017, 7.8);
            list.displayForward();
            list.displayReverse();
            list.updateRating("Dunkirk", 8.0);
            list.searchByDirector("Nolan");
            list.searchByRating(8.8);
            list.removeByTitle("Dunkirk");
            list.displayForward();
        }
    }
}
