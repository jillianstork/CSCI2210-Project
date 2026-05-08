package CSCI2210_Project_Stage4;

/**
 * This class represents a venue.
 * @author Maya L. Garcia Schafer
 * Created 04/07/2026
 */

public class Venue {
    
    private final int venueId;
    private static int nextID = 1;
    private String name;

    /**
     * This constructor method initializes a venue object.
     * @param venueId int the id for the venue
     * @param name String the name of the venue
     */
    public Venue(int venueId, String name) {
        this.venueId = venueId;
        this.name = name;
        if (venueId >= nextID) {
            nextID = venueId + 1;
        }
    }

    /**
     * This constructor method initializes a venue object.
     * @param name String the name of the venue
     */
    public Venue(String name) {
        this.venueId = nextID++;
        this.name = name;
    }

    /**
     * This method gets the id of the venue.
     * @return venueId int the venue's id
     */
    public int getVenueId() {
        return venueId;
    }

    /**
     * This method gets the name of the venue.
     * @return name String the name of the venue
     */
    public String getName() {
        return name;
    }

    /**
     * This method sets the venue name.
     * @param name String the name of the venue
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Overrides the toString method and returns a representation
     * of the venue that has been formatted.
     * @return formatted venue information
     */
    @Override
    public String toString() {
        return String.format("Venue Name: %s | Venue ID: %d",
            name, venueId);
    }

}