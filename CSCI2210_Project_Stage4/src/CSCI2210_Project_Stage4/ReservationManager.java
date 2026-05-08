package CSCI2210_Project_Stage4;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class manages reservation objects.
 * @author Maya L. Garcia Schafer
 * 04/11/2026
 */

public class ReservationManager {

    private static ArrayList<Reservation> reservations = new ArrayList<>();

    /**
     * Creates a reservation object through user input and
     * adds it to reservations ArrayList.
     * @param scanner Scanner
     */
    public static void addReservation(Scanner scanner) {

        RoomManager.viewRooms();
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

        Reservation reservation = new Reservation(room, startDateOrTime, endDateOrTime);
        reservations.add(reservation);
        System.out.println("Reservation with ID " + reservation.getReservationId() + 
            " added successfully.");
    }

    /**
     * Directly adds a Reservation to reservation ArrayList.
     * @param reservation Reservation a reservation
     */
    public static void addReservation(Reservation reservation) {
        reservations.add(reservation);
        System.out.println("Reservation with ID " + reservation.getReservationId() + 
            " added successfully.");
    }

    /**
     * Creates a reservation object with given parameters and adds
     * it to reservations ArrayList.
     * @param room Room a room
     * @param start String the start of the reservation
     * @param end String the end of the reservation
     */
    public static void addReservation(Room room, String start, String end) {
        Reservation reservation = new Reservation(room, start, end);
        reservations.add(reservation);
        System.out.println("Reservation with ID " + reservation.getReservationId() + 
            " added successfully.");
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
    //
    public static ArrayList<Reservation> getAll() {
    return reservations;

    }
    
}

