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