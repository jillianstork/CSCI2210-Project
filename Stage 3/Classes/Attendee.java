/**
 * @author Jillian Stork
 * CSCI 2210 Project
 * Conference Management System
 * Attendee Class
 * This class represents the attendee.
 */

public class Attendee extends Person {
    
    private String attendeeID;

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
     * @param attendeeID String
     */
    public Attendee(String name, String email, String phoneNumber, String address,
                    String biography, String organization, String jobTitle,
                    String attendeeID) {
        super(name, email, phoneNumber, address, biography, organization, jobTitle);
        this.attendeeID = attendeeID;
    }

    /**
     * Sets the attendee's ID.
     * @param id String
     */
    public void setAttendeeID(String id) { 
        this.attendeeID = id; 
    }

    /**
     * Gets the attendee's ID.
     * @return attendeeID String
     */
    public String getAttendeeID() { 
        return attendeeID; 
    }

    /**
     * Overrides the toString method and returns a representation
     * of the attendee that has been formatted.
     * @return formatted attendee information
     */
    @Override
    public String toString() {
        return String.format("[ATTENDEE] ID: %s | %s",
                attendeeID, super.toString());
    }
}