/**
 * Class description.
 * @author Maya L. Garcia Schafer
 * Created 04/07/2026
 */

public class Reservation {
    
    private int reservationId;
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
     * Set reservation id.
     * @param reservationId int
     */
    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
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
     * This method checks for overlapping reservations.
     * @param other Reservation another reservation
     * @return true if reservations overlap, false otherwise
     */
    public boolean checkConflict(Reservation other) {
        if (!this.room.equals(other.room)) {
            return false;
        }

        if (this.status.equals("Cancelled") ||
                other.status.equals("Cancelled")) {
            return false;
        }

        boolean startsBeforeOtherEnds = this.startDateOrTime.compareTo(other.endDateOrTime) < 0;
        boolean endsAfterOtherStarts = this.endDateOrTime.compareTo(other.startDateOrTime) > 0;
        return startsBeforeOtherEnds && endsAfterOtherStarts;
    }
}
