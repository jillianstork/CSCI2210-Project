import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class manages Organizer objects.
 * @author Maya L. Garcia Schafer
 * 04/11/2026
 */

public class OrganizerManager {

    private static ArrayList<Organizer> organizers = new ArrayList<>();

    /**
     * Creates a new Organizer through user input.
     * @param scanner Scanner
     */
    public static void addOrganizer(Scanner scanner) {

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
            organization, job);
        organizers.add(organizer);
        System.out.println("organizer with ID " + organizer.getOrganizerId() + 
            " added successfully.");

    }

    /**
     * Directly adds an Organizer object to organizers ArrayList.
     * @param organizer Organizer an organizer
     */
    public static void addOrganizer(Organizer organizer) {
        organizers.add(organizer);
        System.out.println("Organizer with ID " + organizer.getOrganizerId() + 
            " added successfully.");
    }

    /**
     * This method adds an Organizer object to organizers ArrayList
     * using given parameters.
     * @param name String
     * @param email String
     * @param phone String
     * @param address String
     * @param biography String
     * @param organization String
     * @param job String
     */
    public static void addOrganizer(String name, String email, String phone,
            String address, String biography, String organization, String job) {
        Organizer organizer = new Organizer(name, email, phone, address, biography, 
            organization, job);
        organizers.add(organizer);
        System.out.println("Organizer with ID " + organizer.getOrganizerId() + 
            " added successfully.");
    }

    /**
     * Displays the ArrayList of organizers.
     */
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

    /**
     * Allows user to update an attribute of a specific organizer.
     * @param scanner Scanner
     */
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

    /**
     * Deletes an Organizer from the ArrayList of organizers.
     * @param scanner Scanner
     */
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

    /**
     * Helper method to return an Organizer from 
     * organizers by using its ID.
     * @param id int the Organizer's ID
     * @return o Organizer the organizer with that ID
     */
    public static Organizer getOrganizerByID(int id) {
        for (Organizer o : organizers) {
            if (o.getOrganizerId() == id) {
                return o;
            }
        }
        return null;
    }
    public static ArrayList<Organizer> getAll() {
    return organizers;
}
}