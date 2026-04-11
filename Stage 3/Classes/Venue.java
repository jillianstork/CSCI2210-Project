/**
 * Class description.
 * @author Maya L. Garcia Schafer
 * Created 04/07/2026
 */

public class Venue {
    
    private int venueId;
    private String name;
    private ArrayList<Room> rooms;

    /**
     * This constructor method initializes the variables
     * venueId, name, and rooms.
     * @param venueId int the id for the venue
     * @param name String the name of the venue
     */
    public Venue(int venueId, String name) {
        this.venueId = venueId;
        this.name = name;
        this.rooms = new ArrayList<Room>();
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
     * This method sets the venue id.
     * @param venueId int the venue's id
     */
    public void setVenueId(int venueId) {
        this.venueId = venueId;
    }

    /**
     * This method sets the venue name.
     * @param name String the name of the venue
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This method...
     * @param ...
     * @return ...
     */

}
