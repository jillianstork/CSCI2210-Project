import java.util.Scanner;

public class ConferenceSystemMenu {

    public static void menu(Scanner scanner) {
        int decision;
        do {
            System.out.println("Which menu would you like to open?");
            System.out.println("~~~~~~~~~~~");
            System.out.println("Main Menu");
            System.out.println("1. Conference");
            System.out.println("2. Registration");
            System.out.println("3. Reservation");
            System.out.println("4. Room");
            System.out.println("5. Venue");
            System.out.println("6. Attendee");
            System.out.println("7. Speaker");
            System.out.println("8. Organizer");
            System.out.println("9. Exit Menu");
            System.out.println("~~~~~~~~~~~");
            System.out.print("Please enter your choice (as a number): ");

            if (scanner.hasNextInt()) {
                decision = scanner.nextInt();
                scanner.nextLine();
                switch (decision) {
                    case 1:
                        ConferenceManager.conferenceMenu(scanner);
                        break;
                    case 2:
                        RegistrationManager.registrationMenu(scanner);
                        break;
                    case 3:
                        ReservationManager.reservationMenu(scanner);
                        break;
                    case 4:
                        RoomManager.roomMenu(scanner);
                        break;
                    case 5:
                        VenueManager.venueMenu(scanner);
                        break;
                    case 6:
                        AttendeeManager.attendeeMenu(scanner);
                        break;

                    case 7: 
                        SpeakerManager.speakerMenu(scanner);
                        break;
                    case 8:
                        OrganizerManager.organizerMenu(scanner);
                        break;
                    case 9:
                        System.out.println("Exiting the conference system menu. Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid input. Please try again.");
                        break;
                    
                }
            }
            else {
                System.out.println("Invalid input. Please try again.");
                scanner.nextLine();
                decision = 0;
            }
        } while (decision != 9);
    }
}
