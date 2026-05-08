package CSCI2210_Project_Stage4;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class manages speaker objects.
 * @author Maya L. Garcia Schafer
 * 04/11/2026
 */

public class SpeakerManager {

    private static ArrayList<Speaker> speakers = new ArrayList<>();

    /**
     * This method creates a speaker through user input
     * and adds it to the speakers ArrayList.
     * @param scanner Scanner
     */
    public static void addSpeaker(Scanner scanner) {

        System.out.println("Please enter the name of the speaker: ");
        String name = scanner.nextLine();

        System.out.println("Please enter the email of the speaker: ");
        String email = scanner.nextLine();

        System.out.println("Please enter the phone number of the speaker: ");
        String phone = scanner.nextLine();

        System.out.println("Please enter the address of the speaker: ");
        String address = scanner.nextLine();

        System.out.println("Please enter the  biography of the speaker: ");
        String biography = scanner.nextLine();

        System.out.println("Please enter the organization of the speaker: ");
        String organization = scanner.nextLine();

        System.out.println("Please enter the job title of the speaker: ");
        String job = scanner.nextLine();

        Speaker speaker = new Speaker(name, email, phone, address, biography,
            organization, job);
        speakers.add(speaker);
        System.out.println("Speaker with ID " + speaker.getSpeakerID() + 
            " added successfully.");

    }

    /**
     * This method directly adds a speaker to speakers ArrayList.
     * @param speaker Speaker the speaker
     */
    public static void addSpeaker(Speaker speaker) {
        speakers.add(speaker);
        System.out.println("Speaker with ID " + speaker.getSpeakerID() + 
            " added successfully.");
    }

    /**
     * This method adds a Speaker object to speakers ArrayList
     * using given parameters.
     * @param name String
     * @param email String
     * @param phone String
     * @param address String
     * @param biography String
     * @param organization String
     * @param job String
     */
    public static void addSpeaker(String name, String email, String phone,
            String address, String biography, String organization, String job) {
        Speaker speaker = new Speaker(name, email, phone, address, biography, 
            organization, job);
        speakers.add(speaker);
        System.out.println("Speaker with ID " + speaker.getSpeakerID() + 
            " added successfully.");
    }

    /**
     * This method displays the ArrayList rooms.
     */
    public static void viewSpeakers() {
        if (speakers.isEmpty()) {
            System.out.println("No speakers found.");
            return;
        }
        else {
            System.out.println("--Speakers--");
            for (Speaker s : speakers) {
                System.out.println(s);
            }
        }
    }

    /**
     * This method allows users to update a
     * Speaker's attributes.
     * @param scanner Scanner
     */
    public static void updateSpeaker(Scanner scanner) {
        boolean updateSuccessful = false;

        System.out.println("Enter the ID of the speaker you wish to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Speaker selectedSpeaker = getSpeakerByID(id);

        if (selectedSpeaker == null) {
            System.out.println("There is no speaker with this ID.");
            return;
        }

        System.out.println("~~Speaker Update Options~~");
        System.out.println("1. Name");
        System.out.println("2. Email");
        System.out.println("3. Phone number");
        System.out.println("4. Address");
        System.out.println("5. Biography");
        System.out.println("6. Organization");
        System.out.println("7. Job title");
        System.out.println("Please enter the number by what you want to update: ");

        int decision = scanner.nextInt();
        scanner.nextLine();
        switch(decision) {
            case 1:
                System.out.println("Please enter the new name: ");
                String newName = scanner.nextLine();
                selectedSpeaker.setName(newName);;
                updateSuccessful = true;
                break;
            case 2: 
                System.out.println("Please enter the new email: ");
                String newEmail = scanner.nextLine();
                selectedSpeaker.setEmail(newEmail);
                updateSuccessful = true;
                break;
            case 3:
                System.out.println("Please enter the new phone number: ");
                String newPhone = scanner.nextLine();
                selectedSpeaker.setPhoneNumber(newPhone);
                updateSuccessful = true;
                break;
            case 4: 
                System.out.println("Please enter the new address: ");
                String newAddress = scanner.nextLine();
                selectedSpeaker.setAddress(newAddress);
                updateSuccessful = true;
                break;
            case 5: 
                System.out.println("Please enter the new biography: ");
                String newBio = scanner.nextLine();
                selectedSpeaker.setBiography(newBio);
                updateSuccessful = true;
                break;
            case 6:
                System.out.println("Please enter the new organization: ");
                String newOrg = scanner.nextLine();
                selectedSpeaker.setOrganization(newOrg);
                updateSuccessful = true;
                break;
            case 7:
                System.out.println("Please enter the new job title: ");
                String newTitle = scanner.nextLine();
                selectedSpeaker.setJobTitle(newTitle);
                updateSuccessful = true;
                break;
            default:
                System.out.println("Invalid input.");
                return;
        }
        if (updateSuccessful) {
            System.out.println("Speaker update successful.");
        }
    }

    /**
     * This method deletes a speaker from speakers ArrayList.
     * @param scanner Scanner
     */
    public static void deleteSpeaker(Scanner scanner) {
        System.out.println("Please enter the ID of the speaker you wish to delete: ");
        int deletionID = scanner.nextInt();
        scanner.nextLine();

        Speaker speakerToDelete = getSpeakerByID(deletionID);
        if (speakerToDelete == null) {
            System.out.println("No such speaker found.");
            return;
        }
        else {
            speakers.remove(speakerToDelete);
            System.out.println("Speaker with ID " + deletionID + 
                " deleted successfully.");
        }
    }

    /**
     * Helper method that finds and returns a specific
     * Speaker from speakers ArrayList based on its ID.
     * @param id int the ID to search by
     * @return a Speaker a speaker
     */
    public static Speaker getSpeakerByID(int id) {
        for (Speaker a : speakers) {
            if (a.getSpeakerID() == id) {
                return a;
            }
        }
        return null;
    }
    
    public static ArrayList<Speaker> getAll() {
    return speakers;
}
}