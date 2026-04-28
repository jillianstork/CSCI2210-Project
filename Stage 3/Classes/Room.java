/**
 * This class represents physical rooms at a venue. It stores
 * the following variables related to the room: roomId, name,
 * capacity, location, whether it has a projector, and the number
 * of computers. Getter and setter methods are provided for each
 * variable except for location, which only has a a get method.
 * @author Maya L. Garcia Schafer
 * Created on 04/09/2026
 */

public class Room {
    
    private static int nextID = 1;
    private final int roomId;
    private String name;
    private int capacity;
    private Venue location;
    private boolean hasProjector;
    private int numberOfComputers;

    /**
     * Constructor method to initialize all private variables.
     * @param roomId int the room's id number
     * @param name String the name of the room
     * @param capacity int number of people room can hold
     * @param location Venue the venue of the room
     * @param hasProjector boolean true if room has projector,
     * false otherwise
     * @param numberOfComputers int the number of computers in room
     */
    public Room(int roomId, String name, int capacity,
        Venue location, boolean hasProjector, int numberOfComputers) {
        this.roomId = roomId;
        this.name = name;
        this.capacity = capacity;
        this.location = location;
        this.hasProjector = hasProjector;
        this.numberOfComputers = numberOfComputers;
        if (roomId >= nextID) {
            nextID = roomId + 1;
        }
    }

    /**
     * Constructor method to initialize all private variables.
     * @param name String the name of the room
     * @param capacity int number of people room can hold
     * @param location Venue the venue of the room
     * @param hasProjector boolean true if room has projector,
     * false otherwise
     * @param numberOfComputers int the number of computers in room
     */
    public Room(String name, int capacity, Venue location, 
            boolean hasProjector, int numberOfComputers) {
        this.roomId = nextID++;
        this.name = name;
        this.capacity = capacity;
        this.location = location;
        this.hasProjector = hasProjector;
        this.numberOfComputers = numberOfComputers;
    }

    /**
     * Gets the room id.
     * @return roomId int the room's id
     */
    public int getRoomId() {
        return roomId;
    }

    /**
     * Gets the name of the room.
     * @return name String the name of the room
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the room's capacity.
     * @return capacity int the room's capacity
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * Gets the venue (location) of the room.
     * @return location Venue the venue the room is in
     */
    public Venue getLocation() {
        return location;
    }

    /**
     * Returns whether or not the room has a projector.
     * @return hasProjector boolean true if the room has
     * a projector, false otherwise
     */
    public boolean getHasProjector() {
        return hasProjector;
    }

    /**
     * Gets the number of computers in the room.
     * @return numberOfComputers int the number of computers
     * in the room.
     */
    public int getNumberOfComputers() {
        return numberOfComputers;
    }

    /**
     * Sets the room name.
     * @param name String the name of the room
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the room's capacity.
     * @param capacity int the capacity of the room
     */
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    /**
     * Sets the room's location.
     * @param 
     */
    public void setLocation(Venue location) {
        this.location = location;
    }

    /**
     * Sets whether or not the room has a projector.
     * @param hasProjector boolean true if the room
     * has a projector, false otherwise
     */
    public void setHasProjector(boolean hasProjector) {
        this.hasProjector = hasProjector;
    }

    /**
     * Sets the number of computers in the room.
     * @param numberOfComputers int the number of
     * computers in the room
     */
    public void setNumberOfComputers(int numberOfComputers) {
        this.numberOfComputers = numberOfComputers;
    }

    /**
     * Overrides the toString method and returns a representation
     * of the room that has been formatted.
     * @return formatted room information
     */
    @Override
    public String toString() {
        return String.format("Room Name: %s | Room ID: %d | Room capacity: %d\n " +
            "Has projector: %b | Number of computers: %d", name, roomId, capacity, 
            hasProjector, numberOfComputers);
    }

}
