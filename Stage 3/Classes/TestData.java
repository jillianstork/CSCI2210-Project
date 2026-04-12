public class TestData {

    public static void load() {

        Conference c1 = new Conference(2, "Psychology Research Conference", "01/01/2001",
            "01/02/2001", "Psychology");
        Conference c2 = new Conference(3, "Computer Science Research Conference", 
            "08/19/2023", "08/21/2023", "Computer Science");
        ConferenceManager.addConference(c1);
        ConferenceManager.addConference(c2);

        Venue v1 = new Venue(2, "Timeca Convention Center");
        Venue v2 = new Venue(3, "Lyre Convention Center");
        VenueManager.addVenue(v1);
        VenueManager.addVenue(v2);

        Room r1 = new Room(2, "Great Room", 200, v1, false, 7);
        Room r2 = new Room(3, "B143", 50, v2, true, 1);
        RoomManager.addRoom(r1);
        RoomManager.addRoom(r2);

        Reservation r3 = new Reservation(2, r1, "10:00am", "2:00pm");
        Reservation r4 = new Reservation(3, r2, "2:00pm", "4:00pm");
        ReservationManager.addReservation(r3);
        ReservationManager.addReservation(r4);

        Schedule s1 = new Schedule(2, r1, c1, "01/01/2001", "11:00am", "8:00pm");
        Schedule s2 = new Schedule(3, r2, c2, "08/21/2023", "9:00am", "6:00pm");
        ScheduleManager.addSchedule(s1);
        ScheduleManager.addSchedule(s2);

        Organizer o1 = new Organizer("Carissa V.",
                                    "v.carissa@gmail.com",
                                    "305-337-9300",
                                    "1234 E Numbers Rd, Numberlands, Colorado, USA",
                                    "",
                                    "Society for Psychological Advancement",
                                    "Event Organizer",
                                    2);
        Organizer o2 = new Organizer("Samuel B.",
                                    "b.samuel@gmail.com",
                                    "472-239-5265",
                                    "4321 S Numeric Lane, Numberville, Texas, USA",
                                    "",
                                    "Society for Technological Advancement",
                                    "Event Organizer",
                                    3);
        OrganizerManager.addOrganizer(o1);
        OrganizerManager.addOrganizer(o2);

        Attendee a1 = new Attendee("Jaime R.", 
                            "r.jaime@gmail.com", 
                            "484-924-8151", 
                            "3244 W University Way, Timeca, Washington, USA", 
                            "", 
                            "Random University", 
                            "Professor", 
                            2);
        Attendee a2 = new Attendee("Lucia P.",
                                    "p.lucia@gmail.com",
                                    "505-396-6820",
                                    "6840 N Woodlands Dr, Lyre, Georgia, USA",
                                    "",
                                    "Lyre State University",
                                    "Professor",
                                    3);
        AttendeeManager.addAttendee(a1);
        AttendeeManager.addAttendee(a2);


        Speaker s3 = new Speaker("Carla W.",
                                    "w.carla@gmail.com",
                                    "983-821-4206",
                                    "5677 N Road Rd, Town, USA",
                                    "",
                                    "Town State University",
                                    "Professor",
                                    2);
        Speaker s4 = new Speaker("Edwin S.",
                                    "s.edwin@gmail.com",
                                    "305-207-6941",
                                    "7655 W Lane Rd, City, USA",
                                    "",
                                    "City University",
                                    "Professor",
                                    3);
        SpeakerManager.addSpeaker(s3);
        SpeakerManager.addSpeaker(s4);

        Registration r5 = new Registration(2, "05/12/2000", a1, c1);
        Registration r6 = new Registration(3, "07/22/2023", a2, c2);
        RegistrationManager.addRegistration(r5);
        RegistrationManager.addRegistration(r6);

    }

}
