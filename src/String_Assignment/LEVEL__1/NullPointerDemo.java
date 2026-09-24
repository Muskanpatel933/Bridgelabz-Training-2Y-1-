package String_Assignment.LEVEL__1;

public class NullPointerDemo {
    public class NullPointerDemo {

        public static void generateException() {
            String text = null;
            text.length();
        }

        public static void handleException() {
            String text = null;
            try {
                text.length();
            } catch (NullPointerException e) {
                System.out.println("NullPointerException caught successfully.");
            }
        }

        public static void main(String[] args) {
            handleException();

            try {
                generateException();
            } catch (NullPointerException e) {
                System.out.println("Generated exception caught in main.");
            }
        }
    }
}
