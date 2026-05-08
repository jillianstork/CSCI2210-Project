/**
 * @author Jillian Stork
 * CSCI 2210 Project
 * Conference Management System
 * attendee Panel Class
 * This is the class for data persistence
 */

import java.io.*;
import java.util.*;

public class DataPersistence {

    // SAVE ALL 
    public static void saveAll() {
        saveRooms();
        saveSpeakers();
        saveAttendees();
        saveOrganizers();
        saveReservations();
        saveSchedules();
        saveVenues();
    }

    //  LOAD ALL
    public static void loadAll() {
        loadVenues();
        loadRooms();
        loadSpeakers();
        loadAttendees();
        loadOrganizers();
        loadReservations();
        loadSchedules(); 
    }

   
    // SPEAKERS
 

    private static void saveSpeakers() {
        try (PrintWriter pw = new PrintWriter("speakers.txt")) {

            for (Speaker s : SpeakerManager.getAll()) {
                pw.println(
                    s.getName() + "|" +
                    s.getEmail() + "|" +
                    s.getPhoneNumber() + "|" +
                    s.getAddress() + "|" +
                    s.getBiography() + "|" +
                    s.getOrganization() + "|" +
                    s.getJobTitle()
                );
            }

        } catch (Exception e) {
            System.out.println("Error saving speakers:");
            e.printStackTrace();
        }
    }

    private static void loadSpeakers() {
        File file = new File("speakers.txt");
        if (!file.exists()) return;

        try (Scanner sc = new Scanner(file)) {

            while (sc.hasNextLine()) {
                String[] p = sc.nextLine().split("\\|");

                if (p.length < 7) continue;

                SpeakerManager.addSpeaker(
                    p[0],
                    p[1],
                    p[2],
                    p[3],
                    p[4],
                    p[5],
                    p[6]
                );
            }

        } catch (Exception e) {
            System.out.println("Error loading speakers:");
            e.printStackTrace();
        }
    }

   
    // ATTENDEES
  

    private static void saveAttendees() {
        try (PrintWriter pw = new PrintWriter("attendees.txt")) {

            for (Attendee a : AttendeeManager.getAll()) {
                pw.println(
                    a.getName() + "|" +
                    a.getEmail() + "|" +
                    a.getPhoneNumber() + "|" +
                    a.getAddress() + "|" +
                    a.getBiography() + "|" +
                    a.getOrganization() + "|" +
                    a.getJobTitle()
                );
            }

        } catch (Exception e) {
            System.out.println("Error saving attendees:");
            e.printStackTrace();
        }
    }

    private static void loadAttendees() {
        File file = new File("attendees.txt");
        if (!file.exists()) return;

        try (Scanner sc = new Scanner(file)) {

            while (sc.hasNextLine()) {
                String[] p = sc.nextLine().split("\\|");

                if (p.length < 7) continue;

                AttendeeManager.addAttendee(
                    p[0],
                    p[1],
                    p[2],
                    p[3],
                    p[4],
                    p[5],
                    p[6]
                );
            }

        } catch (Exception e) {
            System.out.println("Error loading attendees:");
            e.printStackTrace();
        }
    }
    
    // ORGANIZERS
    private static void saveOrganizers() {
        try (PrintWriter pw = new PrintWriter("organizers.txt")) {

            for (Organizer o : OrganizerManager.getAll()) {
                pw.println(
                    o.getName() + "|" +
                    o.getEmail() + "|" +
                    o.getPhoneNumber() + "|" +
                    o.getAddress() + "|" +
                    o.getBiography() + "|" +
                    o.getOrganization() + "|" +
                    o.getJobTitle()
                );
            }

        } catch (Exception e) {
            System.out.println("Error saving organizers:");
            e.printStackTrace();
        }
    }

    private static void loadOrganizers() {
        File file = new File("organizers.txt");
        if (!file.exists()) return;

        try (Scanner sc = new Scanner(file)) {

            while (sc.hasNextLine()) {
                String[] p = sc.nextLine().split("\\|");

                if (p.length < 7) continue;

                OrganizerManager.addOrganizer(
                    p[0],
                    p[1],
                    p[2],
                    p[3],
                    p[4],
                    p[5],
                    p[6]
                );
            }

        } catch (Exception e) {
            System.out.println("Error loading organizers:");
            e.printStackTrace();
        }
    }
    
    // VENUES
    private static void saveVenues() {
        try (PrintWriter pw = new PrintWriter("venues.txt")) {

            for (Venue v : VenueManager.getAll()) {
                pw.println(
                    v.getName()
                );
            }

        } catch (Exception e) {
            System.out.println("Error saving venues:");
            e.printStackTrace();
        }
    }

    private static void loadVenues() {
        File file = new File("venues.txt");
        if (!file.exists()) return;

        try (Scanner sc = new Scanner(file)) {

            while (sc.hasNextLine()) {
                String[] p = sc.nextLine().split("\\|");

                if (p.length < 1) continue;

                VenueManager.addVenue(
                    p[0]
                );
            }

        } catch (Exception e) {
            System.out.println("Error loading venues:");
            e.printStackTrace();
        }
    }
    
    // ROOMS
   

    private static void saveRooms() {
        try (PrintWriter pw = new PrintWriter("rooms.txt")) {

            for (Room r : RoomManager.getAll()) {
                pw.println(
                    r.getName() + "|" +
                    r.getCapacity() + "|" +
                    r.getLocation().getName() + "|" +
                    r.getHasProjector() + "|" +
                    r.getNumberOfComputers()
                );
            }

        } catch (Exception e) {
            System.out.println("Error saving rooms:");
            e.printStackTrace();
        }
    }

    private static void loadRooms() {
        File file = new File("rooms.txt");
        if (!file.exists()) return;

        try (Scanner sc = new Scanner(file)) {

            while (sc.hasNextLine()) {
                String[] p = sc.nextLine().split("\\|");

                if (p.length < 5) continue;

                RoomManager.addRoom(
                    p[0],
                    Integer.parseInt(p[1]),
                    null,
                    Boolean.parseBoolean(p[3]),
                    Integer.parseInt(p[4])
                );
            }

        } catch (Exception e) {
            System.out.println("Error loading rooms:");
            e.printStackTrace();
        }
    }
    
    // RESERVATIONS
    private static void saveReservations() {
        try (PrintWriter pw = new PrintWriter("reservations.txt")) {

            for (Reservation r : ReservationManager.getAll()) {
                pw.println(
                    r.getRoom().getName() + "|" +
                    r.getStartDateOrTime() + "|" +
                    r.getEndDateOrTime()
                );
            }

        } catch (Exception e) {
            System.out.println("Error saving reservations:");
            e.printStackTrace();
        }
    }

    private static void loadReservations() {
        File file = new File("reservations.txt");
        if (!file.exists()) return;

        try (Scanner sc = new Scanner(file)) {

            while (sc.hasNextLine()) {
                String[] p = sc.nextLine().split("\\|");

                if (p.length < 3) continue;

                ReservationManager.addReservation(
                    null,
                    p[1],
                    p[2]
                );
            }

        } catch (Exception e) {
            System.out.println("Error loading reservations:");
            e.printStackTrace();
        }
    }
    
    // SCHEDULES
    private static void saveSchedules() {
        try (PrintWriter pw = new PrintWriter("schedules.txt")) {

            for (Schedule s : ScheduleManager.getAll()) {
                pw.println(
                    s.getRoom().getName() + "|" +
                    s.getConference().getTitle() + "|" +
                    s.getDate() + "|" +
                    s.getStartTime() + "|" +
                    s.getEndTime()
                );
            }

        } catch (Exception e) {
            System.out.println("Error saving reservations:");
            e.printStackTrace();
        }
    }

    private static void loadSchedules() {
        File file = new File("schedules.txt");
        if (!file.exists()) return;

        try (Scanner sc = new Scanner(file)) {

            while (sc.hasNextLine()) {
                String[] p = sc.nextLine().split("\\|");

                if (p.length < 5) continue;

                ScheduleManager.addSchedule(
                    null,
                    null,
                    p[2],
                    p[3],
                    p[4]
                );
            }

        } catch (Exception e) {
            System.out.println("Error loading schedules:");
            e.printStackTrace();
        }
    }
}