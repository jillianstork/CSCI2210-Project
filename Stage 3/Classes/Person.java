// @Author Jillian Stork 
// CSCI 2210 Project
//Conference Management System 

/**
* This class represents the person 
*/
package com.mycompany.conferenceapplication;

public class Person {
    private String name;
    private String email;
    private String phoneNumber;
    private String address;
    private String biography;
    private String organization;
    private String jobTitle;
 
    public Person(String name, String email, String phoneNumber, String address,
                  String biography, String organization, String jobTitle) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.biography = biography;
        this.organization = organization;
        this.jobTitle = jobTitle;
    }
    /**
    * This methods set the information for the person instance 
    */
    public void setName(String name) { this.name = name; }
    public void setEmail(String email) { this.email = email; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
    public void setAddress(String address) { this.address = address; }
    public void setBiography(String biography) { this.biography = biography; }
    public void setOrganization(String organization) { this.organization = organization; }
    public void setJobTitle(String jobTitle) { this.jobTitle = jobTitle; }
    /**
    * These methods set the information for the person instance 
    */
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getPhoneNumber() { return phoneNumber; }
    public String getAddress() { return address; }
    public String getBiography() { return biography; }
    public String getOrganization() { return organization; }
    public String getJobTitle() { return jobTitle; }
 
    @Override
    public String toString() {
        return String.format("Name: %s | Email: %s | Phone: %s | Org: %s | Title: %s",
                name, email, phoneNumber, organization, jobTitle);
    }
}