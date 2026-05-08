package CSCI2210_Project_Stage4;

public class TestData {

    public static void load() {
        System.out.println("TEST DATA LOADING");

        Conference c1 = new Conference("Psychology Research Conference", "01/01/2001",
            "01/02/2001", "Psychology");
        Conference c2 = new Conference("Computer Science Research Conference", 
            "08/19/2023", "08/21/2023", "Computer Science");
        ConferenceManager.addConference(c1);
        ConferenceManager.addConference(c2);

        Venue v1 = new Venue("Timeca Convention Center");
        Venue v2 = new Venue("Lyre Convention Center");
        VenueManager.addVenue(v1);
        VenueManager.addVenue(v2);

        Room r1 = new Room("Great Room", 200, v1, false, 7);
        Room r2 = new Room("B143", 50, v2, true, 1);
        RoomManager.addRoom(r1);
        RoomManager.addRoom(r2);

        Reservation r3 = new Reservation(r1, "10:00am", "2:00pm");
        Reservation r4 = new Reservation(r2, "2:00pm", "4:00pm");
        ReservationManager.addReservation(r3);
        ReservationManager.addReservation(r4);

        Schedule s1 = new Schedule(r1, c1, "01/01/2001", "11:00am", "8:00pm");
        Schedule s2 = new Schedule(r2, c2, "08/21/2023", "9:00am", "6:00pm");
        ScheduleManager.addSchedule(s1);
        ScheduleManager.addSchedule(s2);

        Organizer o1 = new Organizer("Carissa V.",
                                    "v.carissa@gmail.com",
                                    "305-337-9300",
                                    "1234 E Numbers Rd, Numberlands, Colorado, USA",
                                    "",
                                    "Society for Psychological Advancement",
                                    "Event Organizer");
        Organizer o2 = new Organizer("Samuel B.",
                                    "b.samuel@gmail.com",
                                    "472-239-5265",
                                    "4321 S Numeric Lane, Numberville, Texas, USA",
                                    "",
                                    "Society for Technological Advancement",
                                    "Event Organizer");
        OrganizerManager.addOrganizer(o1);
        OrganizerManager.addOrganizer(o2);

        Attendee a1 = new Attendee("Jaime R.", 
                            "r.jaime@gmail.com", 
                            "484-924-8151", 
                            "3244 W University Way, Timeca, Washington, USA", 
                            "", 
                            "Random University", 
                            "Professor");
        Attendee a2 = new Attendee("Lucia P.",
                                    "p.lucia@gmail.com",
                                    "505-396-6820",
                                    "6840 N Woodlands Dr, Lyre, Georgia, USA",
                                    "",
                                    "Lyre State University",
                                    "Professor");
        AttendeeManager.addAttendee(a1);
        AttendeeManager.addAttendee(a2);


        Speaker s3 = new Speaker("Carla W.",
                                    "w.carla@gmail.com",
                                    "983-821-4206",
                                    "5677 N Road Rd, Town, USA",
                                    "",
                                    "Town State University",
                                    "Professor");
        Speaker s4 = new Speaker("Edwin S.",
                                    "s.edwin@gmail.com",
                                    "305-207-6941",
                                    "7655 W Lane Rd, City, USA",
                                    "",
                                    "City University",
                                    "Professor");
        SpeakerManager.addSpeaker(s3);
        SpeakerManager.addSpeaker(s4);

        Registration r5 = new Registration("05/12/2000", a1, c1);
        Registration r6 = new Registration("07/22/2023", a2, c2);
        RegistrationManager.addRegistration(r5);
        RegistrationManager.addRegistration(r6);

    }

}