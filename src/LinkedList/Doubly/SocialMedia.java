package LinkedList.Doubly;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



    public class SocialMediaFriendConnections {
        static class FriendNode {
            int friendId;
            FriendNode next;

            FriendNode(int friendId) {
                this.friendId = friendId;
            }
        }

        static class UserNode {
            int userId;
            String name;
            int age;
            FriendNode friendsHead;
            UserNode next;

            UserNode(int userId, String name, int age) {
                this.userId = userId;
                this.name = name;
                this.age = age;
            }

            boolean hasFriend(int friendId) {
                FriendNode curr = friendsHead;
                while (curr != null) {
                    if (curr.friendId == friendId) {
                        return true;
                    }
                    curr = curr.next;
                }
                return false;
            }

            void addFriend(int friendId) {
                if (friendId == this.userId || hasFriend(friendId)) {
                    return;
                }
                FriendNode node = new FriendNode(friendId);
                node.next = friendsHead;
                friendsHead = node;
            }

            boolean removeFriend(int friendId) {
                if (friendsHead == null) {
                    return false;
                }
                if (friendsHead.friendId == friendId) {
                    FriendNode temp = friendsHead;
                    friendsHead = friendsHead.next;
                    temp.next = null;
                    return true;
                }
                FriendNode curr = friendsHead;
                while (curr.next != null && curr.next.friendId != friendId) {
                    curr = curr.next;
                }
                if (curr.next == null) {
                    return false;
                }
                FriendNode target = curr.next;
                curr.next = target.next;
                target.next = null;
                return true;
            }

            int countFriends() {
                int count = 0;
                FriendNode curr = friendsHead;
                while (curr != null) {
                    count++;
                    curr = curr.next;
                }
                return count;
            }

            void displayFriends() {
                if (friendsHead == null) {
                    System.out.println("No friends.");
                    return;
                }
                FriendNode curr = friendsHead;
                while (curr != null) {
                    System.out.print(curr.friendId + (curr.next != null ? " -> " : ""));
                    curr = curr.next;
                }
                System.out.println();
            }
        }

        private UserNode head;

        public void addUser(int userId, String name, int age) {
            if (findUserById(userId) != null) {
                System.out.println("User ID already exists.");
                return;
            }
            UserNode newUser = new UserNode(userId, name, age);
            newUser.next = head;
            head = newUser;
        }

        private UserNode findUserById(int userId) {
            UserNode curr = head;
            while (curr != null) {
                if (curr.userId == userId) {
                    return curr;
                }
                curr = curr.next;
            }
            return null;
        }

        public boolean addFriendConnection(int userId1, int userId2) {
            UserNode u1 = findUserById(userId1);
            UserNode u2 = findUserById(userId2);
            if (u1 == null || u2 == null || userId1 == userId2) {
                return false;
            }
            u1.addFriend(userId2);
            u2.addFriend(userId1);
            return true;
        }

        public boolean removeFriendConnection(int userId1, int userId2) {
            UserNode u1 = findUserById(userId1);
            UserNode u2 = findUserById(userId2);
            if (u1 == null || u2 == null) {
                return false;
            }
            boolean r1 = u1.removeFriend(userId2);
            boolean r2 = u2.removeFriend(userId1);
            return r1 || r2;
        }

        public List<Integer> findMutualFriends(int userId1, int userId2) {
            List<Integer> mutual = new ArrayList<>();
            UserNode u1 = findUserById(userId1);
            UserNode u2 = findUserById(userId2);
            if (u1 == null || u2 == null) {
                return mutual;
            }
            FriendNode curr = u1.friendsHead;
            while (curr != null) {
                if (u2.hasFriend(curr.friendId)) {
                    mutual.add(curr.friendId);
                }
                curr = curr.next;
            }
            return mutual;
        }

        public void displayFriendsOfUser(int userId) {
            UserNode user = findUserById(userId);
            if (user == null) {
                System.out.println("User not found.");
                return;
            }
            System.out.print("Friends of " + user.name + " (" + user.userId + "): ");
            user.displayFriends();
        }

        public void searchUser(Integer userId, String name) {
            UserNode curr = head;
            boolean found = false;
            while (curr != null) {
                boolean idMatch = userId != null && curr.userId == userId;
                boolean nameMatch = name != null && curr.name.equalsIgnoreCase(name);
                if (idMatch || nameMatch) {
                    System.out.println("ID: " + curr.userId + " | Name: " + curr.name + " | Age: " + curr.age + " | Friends Count: " + curr.countFriends());
                    found = true;
                }
                curr = curr.next;
            }
            if (!found) {
                System.out.println("No matching user found.");
            }
        }

        public void displayFriendCountsForAllUsers() {
            if (head == null) {
                System.out.println("No users in system.");
                return;
            }
            UserNode curr = head;
            while (curr != null) {
                System.out.println("User: " + curr.name + " (ID: " + curr.userId + ") -> Friend Count: " + curr.countFriends());
                curr = curr.next;
            }
        }

        public static void main(String[] args) {
            SocialMediaFriendConnections network = new SocialMediaFriendConnections();
            Scanner sc = new Scanner(System.in);
            int choice;

            do {
                System.out.println("\n1. Add User\n2. Add Friend Connection\n3. Remove Friend Connection\n4. Find Mutual Friends\n5. Display Friends of a User\n6. Search User by ID\n7. Search User by Name\n8. Count Friends for Each User\n0. Exit");
                System.out.print("Enter choice: ");
                choice = sc.nextInt();

                switch (choice) {
                    case 1 -> {
                        System.out.print("User ID, Name, Age: ");
                        network.addUser(sc.nextInt(), sc.next(), sc.nextInt());
                    }
                    case 2 -> {
                        System.out.print("User ID 1 and User ID 2: ");
                        System.out.println(network.addFriendConnection(sc.nextInt(), sc.nextInt()) ? "Connected." : "Failed.");
                    }
                    case 3 -> {
                        System.out.print("User ID 1 and User ID 2: ");
                        System.out.println(network.removeFriendConnection(sc.nextInt(), sc.nextInt()) ? "Disconnected." : "Failed.");
                    }
                    case 4 -> {
                        System.out.print("User ID 1 and User ID 2: ");
                        System.out.println("Mutual Friends: " + network.findMutualFriends(sc.nextInt(), sc.nextInt()));
                    }
                    case 5 -> {
                        System.out.print("User ID: ");
                        network.displayFriendsOfUser(sc.nextInt());
                    }
                    case 6 -> {
                        System.out.print("User ID: ");
                        network.searchUser(sc.nextInt(), null);
                    }
                    case 7 -> {
                        System.out.print("Name: ");
                        network.searchUser(null, sc.next());
                    }
                    case 8 -> network.displayFriendCountsForAllUsers();
                    case 0 -> System.out.println("Exiting...");
                    default -> System.out.println("Invalid choice.");
                }
            } while (choice != 0);

    }
}
