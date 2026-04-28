import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class manages Registration objects.
 * @author Maya L. Garcia Schafer
 * 04/11/2026
 */

public class RegistrationManager {

    private static ArrayList<Registration> registrations = new ArrayList<>();

    /**
     * This method creates a new Registration through
     * user input.
     * @param scanner Scanner
     */
    public static void addRegistration(Scanner scanner) {

        System.out.println("Please enter the date of this registration: ");
        String date = scanner.nextLine();

        AttendeeManager.viewAttendees();
        System.out.println("Enter ID of attendee you wish to register: ");
        int attendeeId = scanner.nextInt();
        scanner.nextLine();
        Attendee attendee = AttendeeManager.getAttendeeByID(attendeeId);
        if (attendee == null) {
            System.out.println("Invalid attendee.");
            return;
        }

        ConferenceManager.showConferences();
        System.out.println("Enter ID of conference to which you wish " +
            " to register attendee: ");
        int conferenceId = scanner.nextInt();
        scanner.nextLine();
        Conference conference = ConferenceManager.getConferenceByID(conferenceId);
        if (conference == null) {
            System.out.println("Invalid conference.");
            return;
        }

        Registration registration = new Registration(date, attendee, conference);
        registrations.add(registration);
        System.out.println("Registration with ID " + registration.getRegistrationId() + 
            " added successfully.");
    }

    /**
     * This method directly adds a registration object to registrations ArrayList.
     * @param registration
     */
    public static void addRegistration(Registration registration) {
        registrations.add(registration);
        System.out.println("Registration with ID " + registration.getRegistrationId() +
            " added successfully.");
    }

    /**
     * 
     */
    public static void addRegistration(String date, Attendee attendee, 
            Conference conference) {
        Registration registration = new Registration(date, attendee, conference);
        registrations.add(registration);
        System.out.println("Registration with ID " + registration.getRegistrationId() + 
            " added successfully.");
    }

    /**
     * Displays the registrations ArrayList.
     */
    public static void viewRegistrations() {
        if (registrations.isEmpty()) {
            System.out.println("No registrations found.");
            return;
        }
        else {
            System.out.println("--Registrations--");
            for (Registration r : registrations) {
                System.out.println(r);
            }
        }
    }

    /**
     * This method updates the status of a registration to
     * reflect its status as having been cancelled.
     * @param scanner Scanner
     */
    public static void cancelRegistration(Scanner scanner) {
        System.out.println("Please enter the ID of the registration you wish to cancel: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        
        Registration reg = getRegistrationById(id);
        if (reg == null) {
            System.out.println("No such registration found.");
            return;
        }
        reg.cancel();
        System.out.println("Registration cancelled.");
    }

    /**
     * This method updates the status of a registration to
     * reflects its status as having been confirmed.
     * @param scanner Scanner
     */
    public static void confirmRegistration(Scanner scanner) {
        System.out.println("Please enter the ID of the registration you wish to confirm: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        
        Registration reg = getRegistrationById(id);
        if (reg == null) {
            System.out.println("No such registration found.");
            return;
        }
        reg.confirm();
        System.out.println("Registration confirmed.");
    }

    /**
     * Prints the array list of registrations as sorted and
     * formatted with respect to the status of the registration.
     */
    public static void showStatusReport() {
        System.out.println("~~~Registration Status Report~~~");
        System.out.println("Active registrations: ");
        for (Registration r : registrations) {
            if (r.getStatus().equals("Active")) {
                System.out.println(r);
            }
        }
        System.out.println("Pending registrations: ");
        for (Registration r : registrations) {
            if (r.getStatus().equals("Pending")) {
                System.out.println(r);
            }
        }
        System.out.println("Cancelled registrations: ");
        for (Registration r : registrations) {
            if (r.getStatus().equals("Cancelled")) {
                System.out.println(r);
            }
        }
    }

    /**
     * Helper method to return a specific object from
     * registrations using its ID.
     * @param id int the Registration's ID
     * @return r Registration the corresponding registration
     */
    public static Registration getRegistrationById(int id) {
        for (Registration r : registrations) {
            if(r.getRegistrationId() == id) {
                return r;
            }
        }
        return null;
    }

}
