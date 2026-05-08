package CSCI2210_Project_Stage4;

import java.util.Scanner;

/**
 * This class creates the menus users
 * interact with in order to manage different
 * the classes and objects that comprise the
 * system.
 * @author Maya L. Garcia Schafer
 * 04/27/2026
 */

public class Menu {

    /**
     * Creates main menu for conference management system
     * that allows users to navigate to various submenus
     * from different classes.
     * @param scanner Scanner
     */
    public static void ConferenceSystemMenu(Scanner scanner) {
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
                        conferenceMenu(scanner);
                        break;
                    case 2:
                        registrationMenu(scanner);
                        break;
                    case 3:
                        reservationMenu(scanner);
                        break;
                    case 4:
                        roomMenu(scanner);
                        break;
                    case 5:
                        venueMenu(scanner);
                        break;
                    case 6:
                        attendeeMenu(scanner);
                        break;

                    case 7: 
                        speakerMenu(scanner);
                        break;
                    case 8:
                        organizerMenu(scanner);
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

    /**
     * Provides a menu for the user to interact with
     * in order to manage and view attendees.
     * @param scanner Scanner
     */
    public static void attendeeMenu(Scanner scanner) {
        int decision;

        do {
            System.out.println("~~~~~~~~~~~");
            System.out.println("Attendee Menu: ");
            System.out.println("1. Add an attendee");
            System.out.println("2. View all attendees");
            System.out.println("3. Update an attendee");
            System.out.println("4. Delete an attendee");
            System.out.println("5. Quit");
            System.out.println("~~~~~~~~~~~");
            System.out.print("Enter your choice: ");

            if (scanner.hasNextInt()) {
                decision = scanner.nextInt();
                scanner.nextLine();
                switch (decision) {
                    case 1:
                        AttendeeManager.addAttendee(scanner);
                        break;
                    case 2:
                        AttendeeManager.viewAttendees();
                        break;
                    case 3:
                        AttendeeManager.updateAttendee(scanner);
                        break;
                    case 4:
                        AttendeeManager.deleteAttendee(scanner);
                        break;
                    case 5:
                        System.out.println("Exiting attendee menu.");
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

    /**
     * Provides a menu for users to interact with in order
     * to create and manage Conference objects.
     * @param scanner
     */
    public static void conferenceMenu(Scanner scanner) {
        int decision;
        do {
            System.out.println("~~~~~~~~~~~");
            System.out.println("Conference Menu: ");
            System.out.println("1. Add a conference");
            System.out.println("2. View all conferences");
            System.out.println("3. Update a conference");
            System.out.println("4. Delete a conference");
            System.out.println("5. Quit");
            System.out.println("~~~~~~~~~~~");
            System.out.print("Enter your choice: ");

            if (scanner.hasNextInt()) {
                decision = scanner.nextInt();
                scanner.nextLine();
                switch (decision) {
                    case 1:
                        ConferenceManager.addConference(scanner);
                        break;
                    case 2:
                        ConferenceManager.showConferences();
                        break;
                    case 3:
                        ConferenceManager.updateConference(scanner);
                        break;
                    case 4:
                        ConferenceManager.deleteConference(scanner);
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

    /**
     * Provides user with a menu for carrying the actions
     * involved in creating and managing Organizer objects.
     * @param scanner Scanner
     */
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
                        OrganizerManager.addOrganizer(scanner);
                        break;
                    case 2:
                        OrganizerManager.viewOrganizers();
                        break;
                    case 3:
                        OrganizerManager.updateOrganizer(scanner);
                        break;
                    case 4:
                        OrganizerManager.deleteOrganizer(scanner);
                        break;
                    case 5:
                        System.out.println("Exiting attendee menu.");
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

    /**
     * Provides a menu of options for creating and managing
     * Registration objects.
     * @param scanner Scanner
     */
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
                        RegistrationManager.addRegistration(scanner);
                        break;
                    case 2:
                        RegistrationManager.viewRegistrations();
                        break;
                    case 3:
                        RegistrationManager.confirmRegistration(scanner);
                        break;
                    case 4:
                        RegistrationManager.cancelRegistration(scanner);
                        break;
                    case 5:
                        RegistrationManager.showStatusReport();
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

    /**
     * This method provides a menu for users to create and manage
     * Reservation objects.
     * @param scanner Scanner
     */
    public static void reservationMenu(Scanner scanner) {
        int decision;
        do {
            System.out.println("~~~~~~~~~~~");
            System.out.println("Reservation Menu: ");
            System.out.println("1. Add reservation");
            System.out.println("2. View reservations");
            System.out.println("3. Confirm a reservation");
            System.out.println("4. Cancel a reservation");
            System.out.println("5. View status report for all reservations");
            System.out.println("6. Quit");
            System.out.println("~~~~~~~~~~~");
            System.out.print("Enter your choice: ");

            if (scanner.hasNextInt()) {
                decision = scanner.nextInt();
                scanner.nextLine();
                switch (decision) {
                    case 1:
                        ReservationManager.addReservation(scanner);
                        break;
                    case 2:
                        ReservationManager.viewReservations();
                        break;
                    case 3:
                        ReservationManager.confirmReservation(scanner);
                        break;
                    case 4:
                        ReservationManager.cancelReservation(scanner);
                        break;
                    case 5:
                        ReservationManager.showStatusReport();
                        break;
                    case 6:
                        System.out.println("Exiting reservation menu.");
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

    /**
     * This method provides a menu the user can interact
     * with in order to create and manage Room objects.
     * @param scanner Scanner
     */
    public static void roomMenu(Scanner scanner) {
        int decision;
        do {
            System.out.println("~~~~~~~~~~~");
            System.out.println("Room Menu: ");
            System.out.println("1. Add a room");
            System.out.println("2. View all rooms");
            System.out.println("3. Update a room");
            System.out.println("4. Delete a room");
            System.out.println("5. Quit");
            System.out.println("~~~~~~~~~~~");
            System.out.print("Enter your choice: ");

            if (scanner.hasNextInt()) {
                decision = scanner.nextInt();
                scanner.nextLine();
                switch (decision) {
                    case 1:
                        RoomManager.addRoom(scanner);
                        break;
                    case 2:
                        RoomManager.viewRooms();
                        break;
                    case 3:
                        RoomManager.updateRoom(scanner);
                        break;
                    case 4:
                        RoomManager.deleteRoom(scanner);
                        break;
                    case 5:
                        System.out.println("Exiting room menu.");
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

    /**
     * Provides a menu for the user to interact with to
     * create and manage Schedule objects.
     * @param scanner Scanner
     */
    public static void scheduleMenu(Scanner scanner) {
        int decision;
        do {
            System.out.println("~~~~~~~~~~~");
            System.out.println("Schedule Menu: ");
            System.out.println("1. Add a schedule");
            System.out.println("2. View all schedules");
            System.out.println("3. Update a schedule");
            System.out.println("4. Delete a schedule");
            System.out.println("5. Quit");
            System.out.println("~~~~~~~~~~~");
            System.out.print("Enter your choice: ");

            if (scanner.hasNextInt()) {
                decision = scanner.nextInt();
                scanner.nextLine();
                switch (decision) {
                    case 1:
                        ScheduleManager.addSchedule(scanner);
                        break;
                    case 2:
                        ScheduleManager.viewSchedule();
                        break;
                    case 3:
                        ScheduleManager.editSchedule(scanner);
                        break;
                    case 4:
                        ScheduleManager.deleteSchedule(scanner);
                        break;
                    case 5:
                        System.out.println("Exiting schedule menu.");
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

    /**
     * This method provides a menu that users can interact
     * with in order to create and manage Speaker objects.
     * @param scanner Scanner
     */
    public static void speakerMenu(Scanner scanner) {
        int decision;

        do {
            System.out.println("~~~~~~~~~~~");
            System.out.println("Speaker Menu: ");
            System.out.println("1. Add a Speaker");
            System.out.println("2. View all Speakers");
            System.out.println("3. Update a Speaker");
            System.out.println("4. Delete a Speaker");
            System.out.println("5. Quit");
            System.out.println("~~~~~~~~~~~");
            System.out.print("Enter your choice: ");

            if (scanner.hasNextInt()) {
                decision = scanner.nextInt();
                scanner.nextLine();
                switch (decision) {
                    case 1:
                        SpeakerManager.addSpeaker(scanner);
                        break;
                    case 2:
                        SpeakerManager.viewSpeakers();
                        break;
                    case 3:
                        SpeakerManager.updateSpeaker(scanner);
                        break;
                    case 4:
                        SpeakerManager.deleteSpeaker(scanner);
                        break;
                    case 5:
                        System.out.println("Exiting speaker menu.");
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

    /**
     * Provides a menu for user to interact with in order to
     * create and manage Venue objects.
     * @param scanner Scanner
     */
    public static void venueMenu(Scanner scanner) {
        int decision;
        do {
            System.out.println("~~~~~~~~~~~");
            System.out.println("Venue Menu: ");
            System.out.println("1. Add a venue");
            System.out.println("2. View all venues");
            System.out.println("3. Update a venue's name");
            System.out.println("4. Delete a venue");
            System.out.println("5. Quit");
            System.out.println("~~~~~~~~~~~");
            System.out.print("Enter your choice: ");

            if (scanner.hasNextInt()) {
                decision = scanner.nextInt();
                scanner.nextLine();
                switch (decision) {
                    case 1:
                        VenueManager.addVenue(scanner);
                        break;
                    case 2:
                        VenueManager.viewVenues();
                        break;
                    case 3:
                        VenueManager.updateVenueName(scanner);
                        break;
                    case 4:
                        VenueManager.deleteVenue(scanner);
                        break;
                    case 5:
                        System.out.println("Exiting venue menu.");
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