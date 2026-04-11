// @Author Jillian Stork 
// CSCI 2210 Project
//Conference Management System 

/**
* This class represents the Speaker 
*/
package com.mycompany.conferenceapplication;

public class Speaker extends Person {
    private Schedule schedule;
 
    public Speaker(String name, String email, String phoneNumber, String address,
                   String biography, String organization, String jobTitle) {
        super(name, email, phoneNumber, address, biography, organization, jobTitle);
    }
 
    public void setBiography() { /* use inherited setBiography(String) */ }
    public void getBiography() { /* use inherited getBiography() */ }
    public void setSchedule(Schedule schedule) { this.schedule = schedule; }
    public Schedule getSchedule() { return schedule; }
 
    @Override
    public String toString() {
        return "[SPEAKER] " + super.toString();
    }
}
 
