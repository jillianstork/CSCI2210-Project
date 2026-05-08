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
    }

    //  LOAD ALL
    public static void loadAll() {
        loadRooms();
        loadSpeakers();
        loadAttendees();
    }

    
    // ROOMS
   

    private static void saveRooms() {
        try (PrintWriter pw = new PrintWriter("rooms.txt")) {

            for (Room r : RoomManager.getAll()) {
                pw.println(
                    r.getName() + "|" +
                    r.getCapacity() + "|" +
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
                String[] p = sc.nextLine().split(",");

                if (p.length < 4) continue;

                RoomManager.addRoom(
                    p[0],
                    Integer.parseInt(p[1]),
                    null,
                    Boolean.parseBoolean(p[2]),
                    Integer.parseInt(p[3])
                );
            }

        } catch (Exception e) {
            System.out.println("Error loading rooms:");
            e.printStackTrace();
        }
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
                String[] p = sc.nextLine().split(",");

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
                String[] p = sc.nextLine().split(",");

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
}