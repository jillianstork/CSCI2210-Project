import java.util.ArrayList;
import java.util.Scanner;

public class OrganizerManager {

    private static ArrayList<Organizer> organizers = new ArrayList<>();

    public static void addOrganizer(Scanner scanner) {
        int organizerID = organizers.size() + 1;

        System.out.println("Please enter the name of the organizer: ");
        String name = scanner.nextLine();

        System.out.println("Please enter the email of the organizer: ");
        String email = scanner.nextLine();

        System.out.println("Please enter the phone number of the organizer: ");
        String phone = scanner.nextLine();

        System.out.println("Please enter the address of the organizer: ");
        String address = scanner.nextLine();

        System.out.println("Please enter the  biography of the organizer: ");
        String biography = scanner.nextLine();

        System.out.println("Please enter the organization of the organizer: ");
        String organization = scanner.nextLine();

        System.out.println("Please enter the job title of the organizer: ");
        String job = scanner.nextLine();

        Organizer organizer = new Organizer(name, email, phone, address, biography,
            organization, job, organizerID);
        organizers.add(organizer);
        System.out.println("organizer with ID " + organizerID + " added successfully.");

    }

    public static void addOrganizer(Organizer organizer) {
        organizers.add(organizer);
    }

    public static void viewOrganizers() {
        if (organizers.isEmpty()) {
            System.out.println("No organizers found.");
            return;
        }
        else {
            System.out.println("--Organizers--");
            for (Organizer o : organizers) {
                System.out.println(o);
            }
        }
    }

    public static void updateOrganizer(Scanner scanner) {
        boolean updateSuccessful = false;

        System.out.println("Enter the ID of the organizer you wish to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Organizer selectedOrganizer = getOrganizerByID(id);

        if (selectedOrganizer == null) {
            System.out.println("There is no organizer with this ID.");
            return;
        }

        System.out.println("~~Organizer Update Options~~");
        System.out.println("1. Name");
        System.out.println("2. Email");
        System.out.println("3. Phone number");
        System.out.println("4. Address");
        System.out.println("5. Biography");
        System.out.println("6. Organization");
        System.out.println("7. Job title");
        System.out.println("Please enter the number by what you want to update: ");

        int decision = scanner.nextInt();
        scanner.nextLine();
        switch(decision) {
            case 1:
                System.out.println("Please enter the new name: ");
                String newName = scanner.nextLine();
                selectedOrganizer.setName(newName);;
                updateSuccessful = true;
                break;
            case 2: 
                System.out.println("Please enter the new email: ");
                String newEmail = scanner.nextLine();
                selectedOrganizer.setEmail(newEmail);
                updateSuccessful = true;
                break;
            case 3:
                System.out.println("Please enter the new phone number: ");
                String newPhone = scanner.nextLine();
                selectedOrganizer.setPhoneNumber(newPhone);
                updateSuccessful = true;
                break;
            case 4: 
                System.out.println("Please enter the new address: ");
                String newAddress = scanner.nextLine();
                selectedOrganizer.setAddress(newAddress);
                updateSuccessful = true;
                break;
            case 5: 
                System.out.println("Please enter the new biography: ");
                String newBio = scanner.nextLine();
                selectedOrganizer.setBiography(newBio);
                updateSuccessful = true;
                break;
            case 6:
                System.out.println("Please enter the new organization: ");
                String newOrg = scanner.nextLine();
                selectedOrganizer.setOrganization(newOrg);
                updateSuccessful = true;
                break;
            case 7:
                System.out.println("Please enter the new job title: ");
                String newTitle = scanner.nextLine();
                selectedOrganizer.setJobTitle(newTitle);
                updateSuccessful = true;
                break;
            default:
                System.out.println("Invalid input.");
                return;
        }
        if (updateSuccessful) {
            System.out.println("Organizer update successful.");
        }
    }

    public static void deleteOrganizer(Scanner scanner) {
        System.out.println("Please enter the ID of the organizer you wish to delete: ");
        int deletionID = scanner.nextInt();
        scanner.nextLine();

        Organizer organizerToDelete = getOrganizerByID(deletionID);
        if (organizerToDelete == null) {
            System.out.println("No such organizer found.");
            return;
        }
        else {
            organizers.remove(organizerToDelete);
            System.out.println("organizer with ID " + deletionID + 
                " deleted successfully.");
        }
    }

    public static Organizer getOrganizerByID(int id) {
        for (Organizer o : organizers) {
            if (o.getOrganizerId() == id) {
                return o;
            }
        }
        return null;
    }

    public static void organizerMenu(Scanner scanner) {
        int decision;

        do {
            System.out.println("~~~~~~~~~~~");
            System.out.println("Organizer Menu: ");
            System.out.println("1. Add an organizer");
            System.out.println("2. View all organizers");
            System.out.println("3. Update an organizer");
            System.out.println("4. Delete an organizer");
            System.out.println("5. Quit");
            System.out.println("~~~~~~~~~~~");
            System.out.print("Enter your choice: ");

            if (scanner.hasNextInt()) {
                decision = scanner.nextInt();
                scanner.nextLine();
                switch (decision) {
                    case 1:
                        addOrganizer(scanner);
                        break;
                    case 2:
                        viewOrganizers();
                        break;
                    case 3:
                        updateOrganizer(scanner);
                        break;
                    case 4:
                        deleteOrganizer(scanner);
                        break;
                    case 5:
                        System.out.println("Exiting conference menu.");
                        break;
                    default:
                        System.out.println("Invalid input. Please try again.");
                }
            }

            else {
                System.out.println("Invalid input. Please try again.");
                scanner.nextLine();
                decision = 0;
            }
            
        } while (decision != 5);
    }
}
