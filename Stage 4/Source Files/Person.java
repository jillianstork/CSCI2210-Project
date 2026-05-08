package CSCI2210_Project_Stage4;

/**
 * @author Jillian Stork
 * CSCI 2210 Project
 * Conference Management System
 * Person Class
 * This class represents the person.
 */

public class Person {
    
    private String name;
    private String email;
    private String phoneNumber;
    private String address;
    private String biography;
    private String organization;
    private String jobTitle;
 
    /**
     * This constructor method initializes all variables for a person.
     * @param name String
     * @param email String
     * @param phoneNumber String
     * @param address String
     * @param biography String
     * @param organization String
     * @param jobTitle String
     */
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
     * Sets the name of the person.
     * @param name String
     */
    public void setName(String name) { 
        this.name = name; 
    }

    /**
     * Sets the email of the person.
     * @param email String
     */
    public void setEmail(String email) { 
        this.email = email; 
    }
    
    /**
     * Sets the person's phone number.
     * @param phoneNumber String
     */
    public void setPhoneNumber(String phoneNumber) { 
        this.phoneNumber = phoneNumber; 
    }

    /**
     * Sets the person's address.
     * @param address String
     */
    public void setAddress(String address) { 
        this.address = address; 
    }
    
    /**
     * Sets the person's biography.
     * @param biography String
     */
    public void setBiography(String biography) { 
        this.biography = biography; 
    }

    /**
     * Sets the person's organization.
     * @param organization String
     */
    public void setOrganization(String organization) { 
        this.organization = organization; 
    }

    /**
     * Sets the person's job title.
     * @param jobTitle String
     */
    public void setJobTitle(String jobTitle) { 
        this.jobTitle = jobTitle; 
    }
    
    /**
     * Gets the person's name.
     * @return name String
     */
    public String getName() { 
        return name; 
    }

    /**
     * Gets the person's email.
     * @return email String
     */
    public String getEmail() { 
        return email; 
    }

    /**
     * Gets the person's phone number.
     * @return phoneNumber String
     */
    public String getPhoneNumber() { 
        return phoneNumber; 
    }

    /**
     * Gets the person's address.
     * @return address String
     */
    public String getAddress() { 
        return address; 
    }

    /**
     * Gets the person's biography.
     * @return biography String
     */
    public String getBiography() { 
        return biography; 
    }

    /**
     * Gets the person's organization.
     * @return organization String
     */
    public String getOrganization() { 
        return organization; 
    }

    /**
     * Gets the person's job title.
     * @return jobTitle String
     */
    public String getJobTitle() { 
        return jobTitle; 
    }

    /**
     * Overrides the toString method and returns a representation
     * of the person that has been formatted.
     * @return formatted person information
     */
    @Override
    public String toString() {
        return String.format("Name: %s | Email: %s | Phone: %s | Org: %s | Title: %s",
                name, email, phoneNumber, organization, jobTitle);
    }
}