import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class manages room objects.
 * @author Maya L. Garcia Schafer
 * 04/11/2026
 */

public class RoomManager {

    private static ArrayList<Room> rooms = new ArrayList<>();

    /**
     * This method creates a room object through user input.
     * @param scanner Scanner
     */
    public static void addRoom(Scanner scanner) {
        
        System.out.println("Please enter a room name: ");
        String name = scanner.nextLine();
        
        System.out.println("Please enter the room's capacity (as a number): ");
        int capacity = scanner.nextInt();
        scanner.nextLine();

        VenueManager.viewVenues();
        System.out.println("Please input the ID of the venue where the" +
            " room is located.");
        int selectedID = scanner.nextInt();
        scanner.nextLine();
        Venue location = VenueManager.getVenueByID(selectedID);

        System.out.println("Please enter 'true' if room has a projector" +
            " or 'false' if the room does not have a projector: ");
        boolean projectorPresent = scanner.nextBoolean();
        scanner.nextLine();

        System.out.println("Please enter the number of computers in the room: ");
        int numberComputers = scanner.nextInt();

        Room room = new Room(name, capacity, location, projectorPresent, numberComputers);

        rooms.add(room);
        System.out.println("Room with ID " + room.getRoomId() + 
            " added successfully.");

    }

    /**
     * This method directly adds a room object to rooms ArrayList.
     * @param room Room a room
     */
    public static void addRoom(Room room) {
        rooms.add(room);
        System.out.println("Room with ID " + room.getRoomId() + 
            " added successfully.");
    }

    /**
     * Adds a Room object to rooms ArrayList using provided
     * parameters.
     * @param name String
     * @param capacity int
     * @param location Venue
     * @param projectorPresent boolean
     * @param numberComputers int
     */
    public static void addRoom(String name, int capacity, Venue location,
            boolean projectorPresent, int numberComputers) {
        Room room = new Room(name, capacity, location, projectorPresent, numberComputers);
        rooms.add(room);
        System.out.println("Room with ID " + room.getRoomId() + 
            " added successfully.");
    }
    

    /**
     * This method displays the ArrayList rooms.
     */
    public static void viewRooms() {
        if (rooms.isEmpty()) {
            System.out.println("No rooms available.");
            return;
        }
        else {
            System.out.println("--Rooms--");
            for (Room r : rooms) {
                System.out.println(r);
            }
        }
    }

    /**
     * This method allows the user to update an attribute
     * of a specific room.
     * @param scanner Scanner
     */
    public static void updateRoom(Scanner scanner) {
        
        boolean updateSuccessful = false;

        System.out.println("Enter the ID of the room you wish to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Room selectedRoom = getRoomById(id);

        if (selectedRoom == null) {
            System.out.println("There is no room with this ID.");
            return;
        }

        System.out.println("~~Room Update Options~~");
        System.out.println("1. Name");
        System.out.println("2. Capacity");
        System.out.println("3. Location");
        System.out.println("4. Projector availability");
        System.out.println("5. Number of computers");
        System.out.println("Please enter the number by what you want to update: ");
        
        int decision = scanner.nextInt();
        scanner.nextLine();
        switch(decision) {
            case 1:
                System.out.println("Please enter the new name for the room: ");
                String newRoomName = scanner.nextLine();
                selectedRoom.setName(newRoomName);
                updateSuccessful = true;
                break;
            case 2:
                System.out.println("Please enter the new number of people the room can hold: ");
                int newCapacity = scanner.nextInt();
                scanner.nextLine();
                selectedRoom.setCapacity(newCapacity);
                updateSuccessful = true;
                break;
            case 3:
                VenueManager.viewVenues();
                System.out.println("Please enter the ID for the room's new venue location: ");
                int newId = scanner.nextInt();
                scanner.nextLine();
                Venue newLocation = VenueManager.getVenueByID(newId);
                if (newLocation == null) {
                    System.out.println("Invalid venue ID. Location update unsuccessful.");
                    return;
                }
                selectedRoom.setLocation(newLocation);
                updateSuccessful = true;
                break;
            case 4:
                System.out.println("Please enter whether there is a projector (yes/no): ");
                String response = scanner.nextLine().toLowerCase();
                if (response.equals("yes")) {
                    selectedRoom.setHasProjector(true);
                }
                else if (response.equals("no")) {
                    selectedRoom.setHasProjector(false);
                }
                else {
                    System.out.println("Invalid input.");
                    return;
                }
                updateSuccessful = true;
                break;
            case 5:
                System.out.println("Please enter the new number of computers in the room: ");
                int newNumberComputers = scanner.nextInt();
                scanner.nextLine();
                selectedRoom.setNumberOfComputers(newNumberComputers);
                updateSuccessful = true;
                break;
            default:
                System.out.println("Invalid input.");
                return;
            }
        if (updateSuccessful) {
            System.out.println("Room update successful.");
        }    
    }

    /**
     * Deletes a room object from rooms ArrayList,
     * @param scanner Scanner
     */
    public static void deleteRoom(Scanner scanner) {
        System.out.println("Please enter the ID of the room you want to delete: ");
        int deletionId = scanner.nextInt();
        scanner.nextLine();

        Room roomToDelete = getRoomById(deletionId);
        if (roomToDelete == null) {
            System.out.println("No such room was found.");
            return;
        }
        else {
            rooms.remove(roomToDelete);
            System.out.println("Room with ID " + deletionId +
                " deleted successfully.");
        }
    }

    /**
     * Helper method to return a specific room from rooms
     * by its ID.
     * @param id int the ID to search by
     * @return r Room the corresponding room
     */
    public static Room getRoomById(int id) { 
        for (Room r : rooms) {
            if(r.getRoomId() == id) {
                return r;
            }
        }
        return null;
    }
    
    
public static Room getByName(String name) {
        for (Room r : getAll()) {
            if (r.getName().equals(name)) {
                return r;
            }
        }
        return null;
    }

    
    public static ArrayList<Room> getAll() {
        return rooms;
    }
}