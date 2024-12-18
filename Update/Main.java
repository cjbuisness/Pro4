import java.util.Scanner;
/*
 * main class hosts the main menu, and is the entry class for the program
 * 
 */

public class Main {
    public static void main(String[] args) {
        ProfileManager profileManager = new ProfileManager();
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

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

	/* 
	* 9 menu options to choose from by entering 1-9
	*/

            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        profileManager.joinNetwork();
                        break;
                    case 2:
                        profileManager.modifyProfile();
                        break;
                    case 3:
                        profileManager.displayAllProfiles();
                        break;
                    case 4:
                        profileManager.addFriend();
                        break;
                    case 5:
                        profileManager.viewFriendList();
                        break;
                    case 6:
                        profileManager.deleteProfile();
                        break;
                    case 7:
                        profileManager.addAnotherProfile();
                        break;
                    case 8:
                        profileManager.switchCurrentUser();
                        break;
                    case 9:
                        profileManager.logout();
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a number between 1 and 9.");
                }
            } else {
                scanner.next();
                System.out.println("Invalid input. Please enter a number between 1 and 9.");
            }

        } while (choice != 9);

        scanner.close();
    }
}
