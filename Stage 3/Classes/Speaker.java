/**
 * @author Jillian Stork
 * CSCI 2210 Project
 * Conference Management System
 * Speaker Class
 * This class represents the speaker.
 */

public class Speaker extends Person {

    private int speakerID;

    /**
     * This constructor method initializes the variables of a
     * Speaker that are inherited from Person.
     * @param name String
     * @param email String
     * @param phoneNumber String
     * @param address String
     * @param biography String
     * @param organization String
     * @param jobTitle String
     * @param speakerID int
     */
    public Speaker(String name, String email, String phoneNumber, String address,
                String biography, String organization, String jobTitle,
                int speakerID) {
        super(name, email, phoneNumber, address, biography, organization, jobTitle);
        this.speakerID = speakerID;
    }

    /**
     * Sets the speaker's ID.
     * @param id String
     */
    public void setSpeakerID(int id) { 
        this.speakerID = id; 
    }

    /**
     * Gets the attendee's ID.
     * @return speakerID int
     */
    public int getSpeakerID() { 
        return speakerID; 
    }
 
    /**
     * Overrides the toString method and returns a representation
     * of the speaker that has been formatted.
     * @return formatted speaker information
     */
    @Override
    public String toString() {
        return String.format("[SPEAKER] ID: %d | %s", 
            speakerID, super.toString());
    }
}