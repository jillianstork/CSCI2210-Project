import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class manages reservation objects.
 * @author Maya L. Garcia Schafer
 * 04/11/2026
 */

public class ReservationManager {

    private static ArrayList<Reservation> reservations = new ArrayList<>();
    private static int nextID = 1;

    /**
     * Creates a reservation object through user input and
     * adds it to reservations ArrayList.
     * @param scanner Scanner
     */
    public static void addReservation(Scanner scanner) {
        int id = nextID++;

        System.out.println("Please enter the ID of the room you wish to reserve: ");
        int roomID = scanner.nextInt();
        scanner.nextLine();
        Room room = RoomManager.getRoomById(roomID);
        if (room == null) {
            System.out.println("Invalid room.");
            return;
        }

        System.out.println("Please enter the start date or time of reservation: ");
        String startDateOrTime = scanner.nextLine();

        System.out.println("Please enter the end date or time of reservation: ");
        String endDateOrTime = scanner.nextLine();

        Reservation reservation = new Reservation(id, room, startDateOrTime, endDateOrTime);
        reservations.add(reservation);
        System.out.println("Reservation with ID " + id + " added successfully.");
    }

    /**
     * Directly adds a Reservation to reservation ArrayList.
     * @param reservation Reservation a reservation
     */
    public static void addReservation(Reservation reservation) {
        reservations.add(reservation);
    }

    /**
     * Displays reservations ArrayList.
     */
    public static void viewReservations() {
        if (reservations.isEmpty()) {
            System.out.println("No reservations found.");
            return;
        }
        else {
            System.out.println("--Reservations--");
            for (Reservation r : reservations) {
                System.out.println(r);
            }
        }
    }

    /**
     * This method updates the status of a reservation
     * to reflect that it has been confirmed.
     * @param scanner Scanner
     */
    public static void confirmReservation(Scanner scanner) {
        System.out.println("Please enter the ID of the reservation you wish to confirm: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Reservation res = getReservationByID(id);
        if (res == null) {
            System.out.println("No such reservation found.");
            return;
        }
        res.confirm();
        System.out.println("Reservation confirmed.");
    }

    /**
     * This method updates the status of a reservation
     * to reflect that it has been cancelled.
     * @param scanner Scanner
     */
    public static void cancelReservation(Scanner scanner) {
        System.out.println("Please enter the ID of the reservation you wish to cancel: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Reservation res = getReservationByID(id);
        if (res == null) {
            System.out.println("No such reservation found.");
            return;
        }
        res.cancel();
        System.out.println("Reservation cancelled.");
    }

    /**
     * Displays all registrations in registrations ArrayList
     * as sorted by their status.
     */
    public static void showStatusReport() {
        System.out.println("~~~Reservation Status Report~~~");
        System.out.println("Confirmed reservations: ");
        for (Reservation r : reservations) {
            if (r.getStatus().equals("Confirmed")) {
                System.out.println(r);
            }
        }
        System.out.println("Pending reservations: ");
        for (Reservation r : reservations) {
            if (r.getStatus().equals("Pending")) {
                System.out.println(r);
            }
        }
        System.out.println("Cancelled reservations: ");
        for (Reservation r : reservations) {
            if (r.getStatus().equals("Cancelled")) {
                System.out.println(r);
            }
        }
    }

    /**
     * Helper method to find and return a Reservation by its
     * ID.
     * @param id int the ID to search by
     * @return r Reservation the correspond reservation
     */
    public static Reservation getReservationByID(int id) {
        for (Reservation r : reservations) {
            if(r.getReservationId() ==id) {
                return r;
            }
        }
        return null;
    }

    /**
     * This method provides a menu for users to create and manage
     * reservation objects.
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
                        addReservation(scanner);
                        break;
                    case 2:
                        viewReservations();
                        break;
                    case 3:
                        confirmReservation(scanner);
                        break;
                    case 4:
                        cancelReservation(scanner);
                        break;
                    case 5:
                        showStatusReport();
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
}
