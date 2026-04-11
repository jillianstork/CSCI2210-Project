// @Author Jillian Stork 
// CSCI 2210 Project
//Conference Management System 
//Main class 

package com.mycompany.conferenceapplication;
import java.util.*;

/**
*This class coordinates activities of the other class 
* @author Jillian Stork
*/
public class Main {

    static Scanner scanner = new Scanner(System.in);

    // Creates dummy storage arrays 
    static ArrayList<Conference> conferences = new ArrayList<>();
    static ArrayList<Attendee> attendees = new ArrayList<>();
    static ArrayList<Speaker> speakers = new ArrayList<>();
    static ArrayList<Room> rooms = new ArrayList<>();

    public static void main(String[] args) {

        // Step 1: Create dummy data
        createDummyData();

        // Step 2: Start menu loop
        int choice;
        do {
            showMainMenu();
            choice =scanner.nextInt();
            scanner.nextLine(); // clear buffer

            switch (choice) {
                case 1 -> conferenceMenu();
                case 2 -> attendeeMenu();
                case 3 -> reportMenu();
                case 0 -> System.out.println("Exiting system...");
                default -> System.out.println("Invalid option.");
            }

        } while (choice != 0);
    }

    /*
    *This method shows the Main menu
    */
    public static void showMainMenu() {
        System.out.println("\n=== CONFERENCE MANAGEMENT SYSTEM ===");
        System.out.println("1) Manage Conferences");
        System.out.println("2) Manage Attendees");
        System.out.println("3) Reports");
        System.out.println("0) Exit");
        System.out.print("Choose option: ");
    }

    /*
    *This method shows the conference menu
    */
    public static void conferenceMenu() {
        System.out.println("\n--- Conference Menu ---");
        System.out.println("1) View Conferences");
        System.out.println("2) Add Conference");
        System.out.print("Choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1 -> {
                for (Conference c : conferences) {
                    System.out.println("Title: " + c.getTitle());
                }
            }

            case 2 -> {
                System.out.print("Enter title: ");
                String title = scanner.nextLine();

                Conference c = new Conference();
                c.setTitle(title);

                conferences.add(c);
                System.out.println("Conference added.");
            }
        }
    }
    
    /*
    *This method shows the attendee menu
    */
    public static void attendeeMenu() {
        System.out.println("\n--- Attendee Menu ---");
        System.out.println("1) View Current Attendees");
        System.out.println("2) Register Attendee");
        System.out.print("Choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1 -> {
                for (Attendee a : attendees) {
                    System.out.println(a.getName() + " - " + a.getAttendeeID());
                }
            }

            case 2 -> {
                System.out.print("Enter name: ");
                String name = scanner.nextLine();

                Attendee a = new Attendee(
                        name, "email@test.com", "123",
                        "address", "bio", "org",
                        "job", "A" + (attendees.size() + 1),
                        "Regular"
                );

                attendees.add(a);
                System.out.println("Attendee registered.");
            }
        }
    }

    /*
    *This method prints the report
    */
    public static void reportMenu() {
        System.out.println("\n--- REPORT ---" );
        System.out.println("Total Conferences: "  + conferences.size());
        System.out.println("Total Attendees: " + attendees.size());
        System.out.println("Total Speakers: " + speakers.size());
        System.out.println("Total Rooms: " + rooms.size());
    }

    /*
    *This method creates the dummy data 
    */
    public static void createDummyData() {

        // Create rooms
        Room r1 = new Room(1, "Room A", 50, "Building 1", true, (byte) 10);
        Room r2 = new Room(2, "Room B", 100, "Building 2", true, (byte) 20);
        rooms.add(r1);
        rooms.add(r2);

        // Create speakers
        Speaker s1 = new Speaker("John Doe", "john@email.com", "111",
                "address", "Expert in AI", "TechOrg", "Engineer", "Bio");
        speakers.add(s1);

        // Create attendees
        Attendee a1 = new Attendee("Alice", "alice@email.com", "222",
                "addr", "bio", "company", "dev", "A1", "VIP");
        attendees.add(a1);

        // Create conference
        Conference c1 = new Conference();
        c1.setTitle("Tech Conference 2026");
        c1.setTopic("AI and Future");

        conferences.add(c1);
    }
  }


