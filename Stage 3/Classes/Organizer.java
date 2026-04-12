/**
 * This class....
 * @author Maya L. Garcia Schafer
 * Created 04/07/2026
 */

public class Organizer extends Person {
    
    private int organizerId;

    /**
     * This constructor initializes the variables of this class.
     * @param name String
     * @param email String
     * @param phoneNumber String
     * @param address String
     * @param biography String
     * @param organization String
     * @param jobTitle String
     * @param organizerId int
     */
    public Organizer(String name, String email, String phoneNumber, String address, 
            String biography, String organization, String jobTitle, int organizerId) {
        super(name, email, phoneNumber, address, biography, organization, jobTitle);
        this.organizerId = organizerId;
    }

    /**
     * Gets the organizer id.
     * @return organizerId int the organizer id
     */
    public int getOrganizerId() {
        return organizerId;
    }

    /**
     * Sets the organizer id.
     * @param organizerId int the organizer id
     */
    public void setOrganizerId(int organizerId) {
        this.organizerId = organizerId;
    }

}
