/**
 * This class represents an organizer.
 * @author Maya L. Garcia Schafer
 * Created 04/07/2026
 */

public class Organizer extends Person {
    
    private static int nextID = 1;
    private final int organizerId;

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
        if (organizerId >= nextID) {
            nextID = organizerId + 1;
        }
    }

    /**
     * Constructor method---this initializes all variables of an organizer,
     * including those inherited from Person.
     * @param name String
     * @param email String
     * @param phoneNumber String
     * @param address String
     * @param biography String
     * @param organization String
     * @param jobTitle String
     */
    public Organizer(String name, String email, String phoneNumber, String address,
                    String biography, String organization, String jobTitle) {
        super(name, email, phoneNumber, address, biography, organization, jobTitle);
        this.organizerId = nextID++;
    }

    /**
     * Gets the organizer id.
     * @return organizerId int the organizer id
     */
    public int getOrganizerId() {
        return organizerId;
    }

    /**
     * Overrides the toString method and returns a representation
     * of the organizer that has been formatted.
     * @return formatted organizer information
     */
    @Override
    public String toString() {
        return String.format("Organizer ID: %d | %s",
                organizerId, super.toString());
    }

}