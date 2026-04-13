import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class manages venue objects.
 * @author Maya L. Garcia Schafer
 * 04/11/2026
 */

public class VenueManager {

    private static ArrayList<Venue> venues = new ArrayList<>();
    private static int nextID = 1;

    /**
     * This method creates a venue through user input and adds
     * it to venues ArrayList.
     * @param scanner Scanner
     */
    public static void addVenue(Scanner scanner) {
        
        int venueId = nextID++;

        System.out.println("Please enter a venue name: ");
        String name = scanner.nextLine();

        Venue venue = new Venue(venueId, name);

        venues.add(venue);
        System.out.println("Venue with ID " + venueId + "added successfully.");
    }

    /**
     * This method directly adds a Venue to venues ArrayList.
     * @param venue Venue
     */
    public static void addVenue(Venue venue) {
        venues.add(venue);
    }

    /**
     * This method displays the ArrayList of venues.
     */
    public static void viewVenues() {
        if (venues.isEmpty()) {
            System.out.println("No venues found.");
            return;
        }
        else {
            System.out.println("--Venues--");
            for (Venue v : venues) {
                System.out.println(v);
            }
        }
    }

    /**
     * Helper method to find and return a Venue from
     * venues using its ID.
     * @param id int the ID to search by
     * @return v Venue the corresponding venue
     */
    public static Venue getVenueByID(int id) {
        for (Venue v : venues) {
            if(v.getVenueId() == id) {
                return v;
            }
        }
        return null;
    }

    /**
     * Updates the name of a venue.
     * @param scanner Scanner
     */
    public static void updateVenueName(Scanner scanner) {

        System.out.println("Please enter the ID of the venue you wish to update: ");
        int venueId = scanner.nextInt();
        scanner.nextLine();

        Venue selectedVenue = getVenueByID(venueId);

        if (selectedVenue == null) {
            System.out.println("There is no venue with this ID.");
            return;
        }

        System.out.println("Please enter the new name for the venue: ");
        String newVenueName = scanner.nextLine();
        selectedVenue.setName(newVenueName);
        System.out.println("Venue name updated successfully.");
    }

    /**
     * Deletes a Venue object from venues ArrayList.
     * @param scanner Scanner
     */
    public static void deleteVenue(Scanner scanner) {
        System.out.println("Please enter the ID of the venue you wish to delete: ");
        int deletionId = scanner.nextInt();
        scanner.nextLine();

        Venue venueToDelete = getVenueByID(deletionId);
        if (venueToDelete == null) {
            System.out.println("No such venue was found.");
            return;
        }
        else {
            venues.remove(venueToDelete);
            System.out.println("Venue with ID " + deletionId +
                " deleted successfully.");
        }

    }

    /**
     * Provides a menu for user to interact with in order to
     * create and manage venue objects.
     * @param scanner Scanner
     */
    public static void venueMenu(Scanner scanner) {
        int decision;
        do {
            System.out.println("~~~~~~~~~~~");
            System.out.println("Venue Menu: ");
            System.out.println("1. Add a venue");
            System.out.println("2. View all venues");
            System.out.println("3. Update a venue's name");
            System.out.println("4. Delete a venue");
            System.out.println("5. Quit");
            System.out.println("~~~~~~~~~~~");
            System.out.print("Enter your choice: ");

            if (scanner.hasNextInt()) {
                decision = scanner.nextInt();
                scanner.nextLine();
                switch (decision) {
                    case 1:
                        addVenue(scanner);
                        break;
                    case 2:
                        viewVenues();
                        break;
                    case 3:
                        updateVenueName(scanner);
                        break;
                    case 4:
                        deleteVenue(scanner);
                        break;
                    case 5:
                        System.out.println("Exiting venue menu.");
                        break;
                    default:
                        System.out.println("Invalid input. Please try again.");
                }
            }

            else {
                System.out.println("Invalid input. Please try again.");
                scanner.nextLine();
                decision = 0;
            }
        } while (decision != 5);
    }
}
