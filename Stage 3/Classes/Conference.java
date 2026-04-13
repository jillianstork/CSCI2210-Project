/**
 * This class stores the different aspects of a conference,
 * including the conferenceId, its title, the start and end dates,
 * and the topic of the conference. It also provides getter and
 * setter methods for each of these variables.
 * @author Maya L. Garcia Schafer
 * Created 04/07/2026
 */

public class Conference {
    
    private int conferenceId;
    private String title;
    private String startDate;
    private String endDate;
    private String topic;

    /**
     * This constructor method initializes the conferenceId,
     * title, startDate, endDate, and topic variables of this
     * class.
     * @param conferenceId int the id for the conference
     * @param title String the title for the conference
     * @param startDate String the date the conference begins
     * @param endDate String the date the conference ends
     * @param topic String the topic of the conference
     */
    public Conference(int conferenceId, String title,
        String startDate, String endDate, String topic) {
        this.conferenceId = conferenceId;
        this.title = title;
        this.startDate = startDate;
        this.endDate = endDate;
        this.topic = topic;
    }

    /**
     * This method gets the conference id.
     * @return conferenceId int the id of the conference
     */
    public int getConferenceId() {
        return conferenceId;
    }

    /**
     * This method gets the title of the conference.
     * @return title String the title of the conference
     */
    public String getTitle() {
        return title;
    }

    /**
     * This method gets the start date of the conference.
     * @return startDate String the day the conference starts
     */
    public String getStartDate() {
        return startDate;
    }

    /**
     * This method gets the end date of the conference.
     * @return endDate String the day the conference ends
     */
    public String getEndDate() {
        return endDate;
    }

    /**
     * This method gets the topic of the conference.
     * @return topic String the topic of the conference
     */
    public String getTopic() {
        return topic;
    }

    /**
     * This method sets the conference's conferenceId.
     * @param conferenceId int the id of the conference
     */
    public void setConferenceId(int conferenceId) {
        this.conferenceId = conferenceId;
    }

    /**
     * This method sets the title of the conference.
     * @param title String the title of the conference
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * This method sets the start date of the conference.
     * @param startDate String the date the conference starts
     */
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    /**
     * This method sets the conference's end date.
     * @param endDate String the date the conference ends
     */
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    /**
     * This method sets the topic of the conference.
     * @param topic String the topic of the conference
     */
    public void setTopic(String topic) {
        this.topic = topic;
    }

    /**
     * Overrides the toString method and returns a representation
     * of the conference that has been formatted.
     * @return formatted conference information
     */
    @Override
    public String toString() {
        return String.format("Conference ID: %d | Title: %s | Topic: %s " +
            "| Start Date: %s | End Date: %s", conferenceId, title,
            topic, startDate, endDate);
    }
}
