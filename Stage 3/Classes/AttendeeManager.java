import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class manages Attendee objects.
 * @author Maya L. Garcia Schafer
 * 04/10/2026
 */

public class AttendeeManager {

    private static ArrayList<Attendee> attendees = new ArrayList<>();

    /**
     * This method adds an Attendee object to
     * attendees array through user input.
     * @param scanner Scanner
     */
    public static void addAttendee(Scanner scanner) {

        System.out.println("Please enter the name of the attendee: ");
        String name = scanner.nextLine();

        System.out.println("Please enter the email of the attendee: ");
        String email = scanner.nextLine();

        System.out.println("Please enter the phone number of the attendee: ");
        String phone = scanner.nextLine();

        System.out.println("Please enter the address of the attendee: ");
        String address = scanner.nextLine();

        System.out.println("Please enter the  biography of the attendee: ");
        String biography = scanner.nextLine();

        System.out.println("Please enter the organization of the attendee: ");
        String organization = scanner.nextLine();

        System.out.println("Please enter the job title of the attendee: ");
        String job = scanner.nextLine();

        Attendee attendee = new Attendee(name, email, phone, address, biography,
            organization, job);
        attendees.add(attendee);
        System.out.println("Attendee with ID " + attendee.getAttendeeID() 
                + " added successfully.");

    }

    /**
     * Adds Attendee objects directly to attendees ArrayList.
     * @param attendee Attendee an attendee object
     */
    public static void addAttendee(Attendee attendee) {
        attendees.add(attendee);
        System.out.println("Attendee with ID " + attendee.getAttendeeID() + 
            " added successfully.");
    }

    /**
     * This method adds a Attendee object to attendees ArrayList
     * using given parameters.
     * @param name String
     * @param email String
     * @param phone String
     * @param address String
     * @param biography String
     * @param organization String
     * @param job String
     */
    public static void addAttendee(String name, String email, String phone,
            String address, String biography, String organization, String job) {
        Attendee attendee = new Attendee(name, email, phone, address, biography, 
            organization, job);
        attendees.add(attendee);
        System.out.println("Attendee with ID " + attendee.getAttendeeID() + 
            " added successfully.");
    }

    /**
     * Displays the attendees stores in the attendees
     * ArrayList.
     */
    public static void viewAttendees() {
        if (attendees.isEmpty()) {
            System.out.println("No attendees found.");
            return;
        }
        else {
            System.out.println("--Attendees--");
            for (Attendee a : attendees) {
                System.out.println(a);
            }
        }
    }

    /**
     * Provides user with ability to select an
     * attribute of an Attendee that they would
     * like to update and change it.
     * @param scanner Scanner
     */
    public static void updateAttendee(Scanner scanner) {
        boolean updateSuccessful = false;

        System.out.println("Enter the ID of the attendee you wish to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Attendee selectedAttendee = getAttendeeByID(id);

        if (selectedAttendee == null) {
            System.out.println("There is no attendee with this ID.");
            return;
        }

        System.out.println("~~Attendee Update Options~~");
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
                selectedAttendee.setName(newName);;
                updateSuccessful = true;
                break;
            case 2: 
                System.out.println("Please enter the new email: ");
                String newEmail = scanner.nextLine();
                selectedAttendee.setEmail(newEmail);
                updateSuccessful = true;
                break;
            case 3:
                System.out.println("Please enter the new phone number: ");
                String newPhone = scanner.nextLine();
                selectedAttendee.setPhoneNumber(newPhone);
                updateSuccessful = true;
                break;
            case 4: 
                System.out.println("Please enter the new address: ");
                String newAddress = scanner.nextLine();
                selectedAttendee.setAddress(newAddress);
                updateSuccessful = true;
                break;
            case 5: 
                System.out.println("Please enter the new biography: ");
                String newBio = scanner.nextLine();
                selectedAttendee.setBiography(newBio);
                updateSuccessful = true;
                break;
            case 6:
                System.out.println("Please enter the new organization: ");
                String newOrg = scanner.nextLine();
                selectedAttendee.setOrganization(newOrg);
                updateSuccessful = true;
                break;
            case 7:
                System.out.println("Please enter the new job title: ");
                String newTitle = scanner.nextLine();
                selectedAttendee.setJobTitle(newTitle);
                updateSuccessful = true;
                break;
            default:
                System.out.println("Invalid input.");
                return;
        }
        if (updateSuccessful) {
            System.out.println("Attendee update successful.");
        }
    }

    /**
     * This method deletes an Attendee.
     * @param scanner Scanner
     */
    public static void deleteAttendee(Scanner scanner) {
        System.out.println("Please enter the ID of the attendee you wish to delete: ");
        int deletionID = scanner.nextInt();
        scanner.nextLine();

        Attendee attendeeToDelete = getAttendeeByID(deletionID);
        if (attendeeToDelete == null) {
            System.out.println("No such attendee found.");
            return;
        }
        else {
            attendees.remove(attendeeToDelete);
            System.out.println("Attendee with ID " + deletionID + 
                " deleted successfully.");
        }
    }

    /**
     * This is a helper method that allows for
     * a specific attendee to be selected from
     * the ArrayList by the Attendee's ID number.
     * @param id int the ID to search by
     * @return a Attendee the matching attendee
     */
    public static Attendee getAttendeeByID(int id) {
        for (Attendee a : attendees) {
            if (a.getAttendeeID() == id) {
                return a;
            }
        }
        return null;
    }
}