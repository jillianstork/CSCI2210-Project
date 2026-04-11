// @Author Jillian Stork 
// CSCI 2210 Project
//Conference Management System 
// Attendee class 


package com.mycompany.conferenceapplication;

/**
* This class represents the attendee 
*/

public class Attendee extends Person {
    private String attendeeID;
    private String registrationType;

    public Attendee(String name, String email, String phoneNumber, String address,
                    String biography, String organization, String jobTitle,
                    String attendeeID, String registrationType) {
        super(name, email, phoneNumber, address, biography, organization, jobTitle);
        this.attendeeID = attendeeID;
        this.registrationType = registrationType;
    }

    public void registerConference() {
        System.out.println(name + " registered for a conference.");
    }

    public void cancelRegistration() {
        System.out.println(name + " cancelled their registration.");
    }

    public Schedule getSchedule() { return null; }
    public void setRegistrationType(String type) { this.registrationType = type; }
    public String getRegistrationType() { return registrationType; }
    public void setAttendeeID(String id) { this.attendeeID = id; }
    public String getAttendeeID() { return attendeeID; }

    @Override
    public String toString() {
        return String.format("[ATTENDEE] ID: %s | %s | RegType: %s",
                attendeeID, super.toString(), registrationType);
    }
}