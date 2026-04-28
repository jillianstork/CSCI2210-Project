/**
 * @author Jillian Stork
 * CSCI 2210 Project
 * Conference Management System
 * Attendee Class
 * This class represents the attendee.
 */

public class Attendee extends Person {
    
    private static int nextID = 1;
    private final int attendeeID;

    /**
     * Constructor method---this initializes all variables of an attendee,
     * including those inherited from Person.
     * @param name String
     * @param email String
     * @param phoneNumber String
     * @param address String
     * @param biography String
     * @param organization String
     * @param jobTitle String
     */
    public Attendee(String name, String email, String phoneNumber, String address,
                    String biography, String organization, String jobTitle) {
        super(name, email, phoneNumber, address, biography, organization, jobTitle);
        this.attendeeID = nextID++;
    }

    /**
     * Constructor method to initialize an attendee.
     * @param name String
     * @param email String
     * @param phoneNumber String
     * @param address String
     * @param biography String
     * @param organization String
     * @param jobTitle String
     * @param attendeeID int
     */
    public Attendee(String name, String email, String phoneNumber, String address,
                    String biography, String organization, String jobTitle,
                    int attendeeID) {
        super(name, email, phoneNumber, address, biography, organization, jobTitle);
        this.attendeeID = attendeeID;
        if (attendeeID >= nextID) {
            nextID = attendeeID + 1;
        }
    }

    /**
     * Gets the attendee's ID.
     * @return attendeeID int
     */
    public int getAttendeeID() { 
        return attendeeID; 
    }

    /**
     * Overrides the toString method and returns a representation
     * of the attendee that has been formatted.
     * @return formatted attendee information
     */
    @Override
    public String toString() {
        return String.format("[ATTENDEE] ID: %d | %s",
                attendeeID, super.toString());
    }
}