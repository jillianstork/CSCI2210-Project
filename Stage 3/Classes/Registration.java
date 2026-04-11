// @Author Jillian Stork 
// CSCI 2210 Project
//Conference Management System 
//Registration Class 

package com.mycompany.conferenceapplication;

public class Registration {
    private int registrationID;
    private String registrationDate;
    private String status;

    public Registration(int registrationID, String registrationDate, String status) {
        this.registrationID = registrationID;
        this.registrationDate = registrationDate;
        this.status = status;
    }

    public String getPaymentStatus() { return"Pending"; }
    public void cancel() { this.status = "Cancelled"; System.out.println("Registration " + registrationID + " cancelled."); }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public void cancelRegistration() { cancel(); }
    public int getRegistrationId() { return registrationID; }
    public void setRegistrationId(int id) { this.registrationID = id; }
    public String getRegistrationDate() { return registrationDate; }
    public void setRegistrationDate(String date) { this.registrationDate = date; }

    @Override
    public String toString() {
        return String.format("Registration[ID:%d] Date: %s | Status: %s",
                registrationID, registrationDate, status);
    }
}