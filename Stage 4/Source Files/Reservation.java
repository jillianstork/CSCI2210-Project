package CSCI2210_Project_Stage4;

/**
 * This class represents reservation objects.
 * @author Maya L. Garcia Schafer
 * Created 04/07/2026
 */

public class Reservation {
    
    private static int nextID = 1;
    private final int reservationId;
    private Room room;
    private String startDateOrTime;
    private String endDateOrTime;
    private String status;

    /**
     * Constructor method.
     * @param reservationId int
     * @param room Room
     * @param startDateOrTime String
     * @param endDateOrTime String
     */
    public Reservation(int reservationId, Room room, String startDateOrTime,
            String endDateOrTime) {
        this.reservationId = reservationId;
        this.room = room;
        this.startDateOrTime = startDateOrTime;
        this.endDateOrTime = endDateOrTime;
        this.status = "Pending";
        if (reservationId >= nextID) {
            nextID = reservationId + 1;
        }
    }

    /**
     * Constructor method.
     * @param room Room
     * @param startDateOrTime String
     * @param endDateOrTime String
     */
    public Reservation(Room room, String startDateOrTime,
            String endDateOrTime) {
        this.reservationId = nextID++;
        this.room = room;
        this.startDateOrTime = startDateOrTime;
        this.endDateOrTime = endDateOrTime;
        this.status = "Pending";
    }

    /**
     * Gets status of reservation.
     * @return status String
     */
    public String getStatus() {
        return status;
    }

    /**
     * Gets start date or time of reservation.
     * @return startDateOrTime String
     */
    public String getStartDateOrTime() {
        return startDateOrTime;
    }

    /**
     * Gets end date or time of reservation.
     * @return endDateOrTime String
     */
    public String getEndDateOrTime() {
        return endDateOrTime;
    }

    /**
     * Gets reservation id.
     * @return reservationId int
     */
    public int getReservationId() {
        return reservationId;
    }

    /**
     * Gets the room being reserved.
     * @return room Room
     */
    public Room getRoom() {
        return room;
    }

    /**
     * Set room for reservation.
     * @param room Room
     */
    public void setRoom(Room room) {
        this.room = room;
    }

    /**
     * Set start date or time for reservation.
     * @param startDateOrTime String
     */
    public void setStartDateOrTime(String startDateOrTime) {
        this.startDateOrTime = startDateOrTime;
    }

    /**
     * Sets the end date or time for reservation.
     * @param endDateOrTime String
     */
    public void setEndDateOrTime(String endDateOrTime) {
        this.endDateOrTime = endDateOrTime;
    }

    /**
     * This method confirms a reservation.
     */
    public void confirm() {
        this.status = "Confirmed";
    }

    /**
     * This method cancels a reservation.
     */
    public void cancel() {
        this.status = "Cancelled";

    }

    /**
     * Overrides the toString method and returns a representation
     * of the reservation that has been formatted.
     * @return formatted reservation information
     */
    @Override
    public String toString() {
        return String.format("Reservation ID: %d | Room: %s " +
                "| Start: %s | End: %s | Status: %s",
                reservationId, room.getName(), startDateOrTime,
                endDateOrTime, status);
    }

}