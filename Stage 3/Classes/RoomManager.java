import java.util.ArrayList;
import java.util.Scanner;


public class RoomManager {

    private ArrayList<Room> rooms;

    public void addRoom() {
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Please enter  the room ID as a number: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        
        System.out.println("Please enter a room name: ");
        String name = scanner.nextLine();
        
        System.out.println("Please enter maximum number of people" +
            " that the room can hold: ");
        int capacity = scanner.nextInt();
        scanner.nextLine();




    }

    public void viewRoom() {
        ...
    }

    public void updateRoom() {
        ...
    }

    public void deleteRoom() {
        ...
    }

    public void roomMenu() {
        ...
    }
}