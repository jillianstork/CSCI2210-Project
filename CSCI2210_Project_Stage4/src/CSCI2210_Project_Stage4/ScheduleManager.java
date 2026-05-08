package CSCI2210_Project_Stage4;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class manages schedule objects.
 * @author Maya L. Garcia Schafer
 * 04/11/2026
 */

public class ScheduleManager {

    private static ArrayList<Schedule> schedules = new ArrayList<>();

    /**
     * This method creates a new schedule object through user input
     * and adds it to schedules ArrayList.
     * @param scanner Scanner
     */
    public static void addSchedule(Scanner scanner) {

        RoomManager.viewRooms();
        System.out.println("Enter the ID of the room where the session takes place: ");
        int selectedRoomID = scanner.nextInt();
        scanner.nextLine();
        Room room = RoomManager.getRoomById(selectedRoomID);

        ConferenceManager.showConferences();
        System.out.println("Enter the ID of the conference the session is for: ");
        int selectedConferenceID = scanner.nextInt();
        scanner.nextLine();
        Conference conference = ConferenceManager.getConferenceByID(selectedConferenceID);

        System.out.println("Please enter the date for the session: ");
        String date = scanner.nextLine();

        System.out.println("Please enter a start time: ");
        String startTime = scanner.nextLine();

        System.out.println("Please enter an end time: ");
        String endTime = scanner.nextLine();

        Schedule schedule = new Schedule(room, conference, date, startTime, endTime);

        schedules.add(schedule);
        System.out.println("Schedule with ID " + schedule.getScheduleId() + 
            " added successfully.");
        
    }

    /**
     * Directly adds a schedule object to schedules ArrayList.
     * @param schedule Schedule
     */
    public static void addSchedule(Schedule schedule) {
        schedules.add(schedule);
        System.out.println("Schedule with ID " + schedule.getScheduleId() + 
            " added successfully.");
    }

    /**
     * This class adds a Schedule object to schedules using
     * provided parameters.
     * @param room Room
     * @param conference Conference
     * @param date String the date
     * @param startTime String
     * @param endTime String
     */
    public static void addSchedule(Room room, Conference conference, String date,
            String startTime, String endTime) {
        if (room == null || conference == null) {
            System.out.println("Missing room or conference.");
            return;
        }
        Schedule schedule = new Schedule(room, conference, date, startTime, endTime);
        schedules.add(schedule);
        System.out.println("Schedule with ID " + schedule.getScheduleId() + 
            " added successfully.");
    }

    /**
     * Displays the ArrayList schedules.
     */
    public static void viewSchedule() {
        if (schedules.isEmpty()) {
            System.out.println("No schedules found.");
            return;
        }
        else {
            System.out.println("--Schedules--");
            for (Schedule s : schedules) {
                System.out.println(s);
            }
        }
    }

    /**
     * Allows user to edit a Schedule attribute.
     * @param scanner Scanner
     */
    public static void editSchedule(Scanner scanner) {
        boolean updateSuccessful = false;

        System.out.println("Enter the ID of the schedule you wish to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Schedule selectedSchedule = getScheduleByID(id);

        if (selectedSchedule == null) {
            System.out.println("There is no schedule with this ID.");
            return;
        }

        System.out.println("~~Schedule Update Options~~");
        System.out.println("1. Room");
        System.out.println("2. Date");
        System.out.println("3. Start time");
        System.out.println("4. End time");
        System.out.println("Please enter the number by what you want to update: ");
        
        int decision = scanner.nextInt();
        scanner.nextLine();
        
        switch(decision) {
            case 1:
                RoomManager.viewRooms();
                System.out.println("Please enter the ID for the new room: ");
                int newID = scanner.nextInt();
                scanner.nextLine();
                Room newRoom = RoomManager.getRoomById(newID);
                if (newRoom == null) {
                    System.out.println("Invalid room ID. Room update unsuccessful.");
                    return;
                }
                selectedSchedule.setRoom(newRoom);
                updateSuccessful = true;
                break;
            case 2:
                System.out.println("Please enter the new date: ");
                String newDate = scanner.nextLine();
                selectedSchedule.setDate(newDate);
                updateSuccessful = true;
                break;
            case 3:
                System.out.println("Please enter the new start time: ");
                String newStart = scanner.nextLine();
                selectedSchedule.setStartTime(newStart);
                updateSuccessful = true;
                break;
            case 4:
                System.out.println("Please enter the new end time: ");
                String newEnd = scanner.nextLine();
                selectedSchedule.setEndTime(newEnd);
                updateSuccessful = true;
                break;
            default:
                System.out.println("Invalid input.");
                return;
            }
        if (updateSuccessful) {
            System.out.println("Schedule update successful.");
        }    
    }

    /**
     * Deletes a Schedule from schedules ArrayList.
     * @param scanner Scanner
     */
    public static void deleteSchedule(Scanner scanner) {
        System.out.println("Please enter the ID of the schedule you wish to delete: ");
        int deletionID = scanner.nextInt();
        scanner.nextLine();

        Schedule scheduleToDelete = getScheduleByID(deletionID);
        if (scheduleToDelete == null) {
            System.out.println("No such schedule found.");
            return;
        }
        else {
            schedules.remove(scheduleToDelete);
            System.out.println("Schedule with ID " + deletionID +
                " deleted successfully.");
        }
    }

    /**
     * Helper method to find and return a specific Schedule from
     * schedules based on its ID.
     * @param id int the ID to search by
     * @return s Schedule the schedule corresponding to the ID
     */
    public static Schedule getScheduleByID(int id) {
        for (Schedule s : schedules) {
            if(s.getScheduleId() == id) {
                return s;
            }
        }
        return null;
    }
    
    public static ArrayList<Schedule> getAll() {
        return schedules;
    }
}