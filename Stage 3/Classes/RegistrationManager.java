import java.util.ArrayList;
import java.util.Scanner;


public class RegistrationManager {

    private static ArrayList<Registration> registrations = new ArrayList<>();
    private static int nextID = 1;

    public static void addRegistration(Scanner scanner) {
        int id = nextID++;

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

        Registration registration = new Registration(id, date, attendee, conference);
        registrations.add(registration);
        System.out.println("Registration with ID " + id + " added successfully.");
    }

    public static void addRegistration(Registration registration) {
        registrations.add(registration);
    }

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

    public static Registration getRegistrationById(int id) {
        for (Registration r : registrations) {
            if(r.getRegistrationId() == id) {
                return r;
            }
        }
        return null;
    }

    public static void registrationMenu(Scanner scanner) {
        int decision;
        do {
            System.out.println("~~~~~~~~~~~");
            System.out.println("Registration Menu: ");
            System.out.println("1. Add registration");
            System.out.println("2. View registrations");
            System.out.println("3. Confirm a registration");
            System.out.println("4. Cancel a registration");
            System.out.println("5. View status report for all registrations");
            System.out.println("6. Quit");
            System.out.println("~~~~~~~~~~~");
            System.out.print("Enter your choice: ");

            if (scanner.hasNextInt()) {
                decision = scanner.nextInt();
                scanner.nextLine();
                switch (decision) {
                    case 1:
                        addRegistration(scanner);
                        break;
                    case 2:
                        viewRegistrations();
                        break;
                    case 3:
                        confirmRegistration(scanner);
                        break;
                    case 4:
                        cancelRegistration(scanner);
                        break;
                    case 5:
                        showStatusReport();
                        break;
                    case 6:
                        System.out.println("Exiting registration menu.");
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
        } while (decision != 6);
    }
}
