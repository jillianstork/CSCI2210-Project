/**
 * @author Jillian Stork
 * CSCI 2210 Project
 * Conference Management System
 * Registration Class
 */

public class Registration {
    
    private int registrationID;
    private String registrationDate;
    private String status;

    /**
     * Constructor method, initializes all Registration variables.
     * @param registrationID int
     * @param registrationDate String
     * @param status String
     */
    public Registration(int registrationID, String registrationDate, String status) {
        this.registrationID = registrationID;
        this.registrationDate = registrationDate;
        this.status = status;
    }

    /**
     * Updates status of registration to cancelled.
     */
    public void cancelRegistration() { 
        this.status = "Cancelled";
    }
    
    /**
     * Gets the status of the registration.
     * @return status String
     */
    public String getStatus() { 
        return status; 
    }
    
    /**
     * Sets the status of the registration.
     * @param status String
     */
    public void setStatus(String status) { 
        this.status = status; 
    }
    
    /**
     * Gets the id of the registration.
     * @return registrationID int
     */
    public int getRegistrationId() { 
        return registrationID; 
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
        return String.format("Registration[ID:%d] Date: %s | Status: %s",
                registrationID, registrationDate, status);
    }
}
