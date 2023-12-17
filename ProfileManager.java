import java.util.List;
import java.util.Scanner;
import GraphPackage.UndirectedGraph;
import GraphPackage.Vertex;

public class ProfileManager {

    private UndirectedGraph<Profile> socialNetwork;
    private Profile currentUser;

    public ProfileManager() {
        this.socialNetwork = new UndirectedGraph<>();
        this.currentUser = null;
    }

    public void joinNetwork() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your name: ");
        String name = scanner.nextLine();

        System.out.println("Enter your status: ");
        String status = scanner.nextLine();

        Profile newProfile = new Profile(name, status);
        socialNetwork.addVertex(newProfile);

        if (currentUser == null) {
            currentUser = newProfile;
        }

        System.out.println("Joined the network successfully!");
    }

    public void modifyProfile() {
        if (currentUser == null) {
            System.out.println("You need to join the network first.");
            return;
        }

        Scanner scanner = new Scanner(System.in);

        System.out.println("Modify your status: ");
        String newStatus = scanner.nextLine();

        currentUser.setStatus(newStatus);

        System.out.println("Profile modified successfully!");
    }

    public void displayAllProfiles() {
        if (socialNetwork.isEmpty()) {
            System.out.println("No profiles available.");
            return;
        }

        System.out.println("All profiles:");
        List<Vertex<Profile>> vertices = socialNetwork.getVertices();
        for (Vertex<Profile> vertex : vertices) {
            Profile profile = vertex.getLabel();
            System.out.println(profile.getName());
        }
    }

    public void addFriend() {
        if (currentUser == null) {
            System.out.println("You need to join the network first.");
            return;
        }

        displayAllProfiles();
        addFriendFromList();
    }

    private void addFriendFromList() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the name of the profile to add as a friend (or type 'skip'): ");
        String friendName = scanner.nextLine();

        if (!friendName.equalsIgnoreCase("skip")) {
            Vertex<Profile> friendVertex = socialNetwork.getVertex(new Profile(friendName, ""));
            if (friendVertex != null) {
                currentUser.addFriend(friendVertex.getLabel());
                System.out.println("Friend added successfully!");
            } else {
                System.out.println("Profile not found. Please enter a valid profile name.");
            }
        }
    }

    public void viewFriendList() {
        if (currentUser == null) {
            System.out.println("You need to join the network first.");
            return;
        }

        System.out.println("Friend list for " + currentUser.getName() + ":");
        List<Profile> friends = currentUser.getFriendProfiles();
        for (Profile friend : friends) {
            System.out.println(friend.getName());
        }
    }

    public void deleteProfile() {
        if (currentUser == null) {
            System.out.println("You need to join the network first.");
            return;
        }

        socialNetwork.removeVertex(currentUser);

        System.out.println("Profile deleted successfully!");
    }

    public void addAnotherProfile() {
        if (currentUser == null) {
            System.out.println("You need to join the network first.");
            return;
        }

        joinNetwork();
    }

    public void switchCurrentUser() {
        displayAllProfiles();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the name of the profile to switch to: ");
        String newUserName = scanner.nextLine();

        Vertex<Profile> newUserVertex = socialNetwork.getVertex(new Profile(newUserName, ""));
        if (newUserVertex != null) {
            currentUser = newUserVertex.getLabel();
            System.out.println("Switched to user: " + currentUser.getName());
        } else {
            System.out.println("Profile not found. Please enter a valid profile name.");
        }
    }

    public void logout() {
        currentUser = null;
        System.out.println("Logged out successfully. End of program.");
    }

    public void runExperiment() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Join network");
            System.out.println("2. Modify profile");
            System.out.println("3. Display all profiles");
            System.out.println("4. Add a friend");
            System.out.println("5. View friend list");
            System.out.println("6. Delete a profile");
            System.out.println("7. Add another profile");
            System.out.println("8. Switch the current user");
            System.out.println("9. Logout (end program)");

            // Check if there's an integer available
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        joinNetwork();
                        break;
                    case 2:
                        modifyProfile();
                        break;
                    case 3:
                        displayAllProfiles();
                        break;
                    case 4:
                        addFriend();
                        break;
                    case 5:
                        viewFriendList();
                        break;
                    case 6:
                        deleteProfile();
                        break;
                    case 7:
                        addAnotherProfile();
                        break;
                    case 8:
                        switchCurrentUser();
                        break;
                    case 9:
                        logout();
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a number between 1 and 9.");
                }
            } else {
                // Consume the non-integer input to avoid an infinite loop
                scanner.next();
                System.out.println("Invalid input. Please enter a number between 1 and 9.");
            }

        } while (choice != 9);
    }
}
