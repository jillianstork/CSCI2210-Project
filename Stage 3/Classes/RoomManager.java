import java.util.ArrayList;
import java.util.Scanner;


public class RoomManager {

    private static ArrayList<Room> rooms = new ArrayList<>();
    private static int nextID = 1;

    public static void addRoom(Scanner scanner) { //add checks
        
        int id = nextID++;
        
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

        Room room = new Room(id, name, capacity, location, projectorPresent,numberComputers);

        rooms.add(room);
        System.out.println("Room with ID " + id + " added successfully.");

    }

    public static void addRoom(Room room) {
        rooms.add(room);
    }

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

    public static Room getRoomById(int id) { 
        for (Room r : rooms) {
            if(r.getRoomId() == id) {
                return r;
            }
        }
        return null;
    }

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
                        addRoom(scanner);
                        break;
                    case 2:
                        viewRooms();
                        break;
                    case 3:
                        updateRoom(scanner);
                        break;
                    case 4:
                        deleteRoom(scanner);
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
}