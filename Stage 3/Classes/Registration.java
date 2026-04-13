/**
 * @author Jillian Stork
 * CSCI 2210 Project
 * Conference Management System
 * Registration Class
 */

public class Registration {
    
    private int registrationID;
    private Attendee attendee;
    private Conference conference;
    private String registrationDate;
    private String status;

    /**
     * Constructor method, initializes all Registration variables.
     * @param registrationID int
     * @param registrationDate String
     * @param status String
     * @param attendee Attendee
     * @param conference Conference
     */
    public Registration(int registrationID, String registrationDate,
        Attendee attendee, Conference conference) {
        this.registrationID = registrationID;
        this.registrationDate = registrationDate;
        this.status = "Pending";
        this.attendee = attendee;
        this.conference = conference;
    }

    /**
     * Gets the id of the registration.
     * @return registrationID int
     */
    public int getRegistrationId() { 
        return registrationID; 
    }
    
    /**
     * Gets the attendee associated the registration.
     * @return attendee Attendee
     */
    public Attendee getAttendee() {
        return attendee;
    }

    /**
     * Gets the conference associated with the registration.
     * @return conference Conference
     */
    public Conference getConference() {
        return conference;
    }

    /**
     * Gets the status of the registration.
     * @return status String
     */
    public String getStatus() { 
        return status; 
    }

    /**
     * Updates status of registration to cancelled.
     */
    public void cancel() { 
        this.status = "Cancelled";
    }

    /**
     * Updates status of registration to active.
     */
    public void confirm() {
        this.status = "Active";
    }

    
    /**
     * Sets the registration's id.
     * @param id int
     */
    public void setRegistrationId(int id) { 
        this.registrationID = id; 
    }
    
    /**
     * Gets the registration's date.
     * @return registrationDate String
     */
    public String getRegistrationDate() { 
        return registrationDate; 
    }
    
    /**
     * Sets the registration date.
     * @param date String
     */
    public void setRegistrationDate(String date) { 
        this.registrationDate = date; 
    }

    /**
     * Overrides the toString method and returns a representation
     * of the registration that has been formatted.
     * @return formatted registration information
     */
    @Override
    public String toString() {
        return String.format("Registration ID: %d | Date: %s | Status: %s " +
            "| Attendee: %s | Conference: %s",
            registrationID, registrationDate, status, attendee.getName(), conference.getTitle());
    }
}
