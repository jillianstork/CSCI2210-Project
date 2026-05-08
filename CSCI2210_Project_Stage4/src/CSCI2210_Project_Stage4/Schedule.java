package CSCI2210_Project_Stage4;

/**
 * This class represents a schedule.
 * @author Maya L. Garcia Schafer
 * Created on 04/09/2026
 */

public class Schedule {
    
    private static int nextID = 1;
    private final int scheduleId;
    private Room room;
    private Conference conference;
    private String date;
    private String startTime;
    private String endTime;

    /**
     * Constructor method to initialize all variables.
     * @param scheduleId int the schedule id
     * @param room Room a room
     * @param conference Conference a conference
     * @param date String the date
     * @param startTime String the start time for the session
     * @param endTime String the end time for the session
     */
    public Schedule(int scheduleId, Room room, Conference conference,
        String date, String startTime, String endTime) {
        this.scheduleId = scheduleId;
        this.room = room;
        this.conference = conference;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        if (scheduleId >= nextID) {
            nextID = scheduleId + 1;
        }
    }

    /**
     * Constructor method to initialize all variables.
     * @param room Room a room
     * @param conference Conference a conference
     * @param date String the date
     * @param startTime String the start time for the session
     * @param endTime String the end time for the session
     */
    public Schedule(Room room, Conference conference, String date, 
            String startTime, String endTime) {
        this.scheduleId = nextID++;
        this.room = room;
        this.conference = conference;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    /**
     * Gets the schedule id.
     * @return scheduleId int the schedule's id
     */
    public int getScheduleId() {
        return scheduleId;
    }

    /**
     * Gets the room.
     * @return room Room the room for the session
     */
    public Room getRoom() {
        return room;
    }

    /**
     * Sets the room.
     * @param room Room the room for the session
     */
    public void setRoom(Room room) {
        this.room = room;
    }

    /**
     * Gets the conference.
     * @return conference Conference the conference the
     * session is for
     */
    public Conference getConference() {
        return conference;
    }

    /**
     * Sets the conference.
     * @param conference Conference the conference the
     * session is for.
     */
    public void setConference(Conference conference) {
        this.conference = conference;
    }

    /**
     * Gets the date.
     * @return date String the date of the session
     */
    public String getDate() {
        return date;
    }

    /**
     * Sets the date.
     * @param date String the date of the session
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * Gets the session's start time.
     * @return startTime String the start time of the session
     */
    public String getStartTime() {
        return startTime;
    }
    
    /**
     * Sets the session's start time.
     * @param startTime String the session's start time
     */
    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    /**
     * Gets the session's end time.
     * @return endTime String when the session ends
     */
    public String getEndTime() {
        return endTime;
    }
    
    /**
     * Sets the session's end time.
     * @param endTime String time the session ends
     */
    public void setEndTime(String endTime){
        this.endTime = endTime;
    }

    /**
     * Overrides the toString method and returns a representation
     * of the schedule that has been formatted.
     * @return formatted schedule information
     */
    @Override
    public String toString() {
        return String.format("Schedule ID: %d | Conference: %s | Room: %s" +
        " | Date: %s | Time range: %s - %s", scheduleId, conference.getTitle(), 
        room.getName(), date, startTime, endTime);
    }
 
}