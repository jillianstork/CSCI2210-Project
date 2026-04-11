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
    private int cost;
    private String status;

    /**
     * Constructor method.
     * @param
     * @param
     * @param
     * @param
     * @param
     * @param
     */
    public Reservation(int reservationId, Room room, String startDateOrTime,
        String endDateOrTime, int cost, String status) {
        this.reservationId = reservationId;
        this.room = room;
        this.startDateOrTime = startDateOrTime;
        this.endDateOrTime = endDateOrTime;
        this.cost = cost;
        this.status = status;
    }

    /**
     * This method confirms a reservation.
     * @param
     * @return
     */
    public ... confirmReservation(...) {
        ...
    }

    /**
     * This method cancels a reservation.
     * @param
     * @return
     */
    public void cancelReservation(...) {
        ...
    }

    /**
     * This method checks for overlapping reservations.
     * @param
     * @return
     */
    public ... checkReservationConflict(...) {
        ...
    }
}
