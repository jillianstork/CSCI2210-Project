import java.util.Scanner;
import java.util.ArrayList;

public class ConferenceManager {
    
    private static ArrayList<Conference> conferences = new ArrayList<>();

    public static void addConference(Scanner scanner) {
        int conferenceID = conferences.size() + 1;

        System.out.println("Please enter the conference title: ");
        String title = scanner.nextLine();

        System.out.println("Please enter the conference start date: ");
        String start = scanner.nextLine();

        System.out.println("Please enter the conference end date: ");
        String end = scanner.nextLine();

        System.out.println("Please enter the conference topic: ");
        String topic = scanner.nextLine();

        Conference conference = new Conference(conferenceID, title, start, end, topic);

        conferences.add(conference);
        System.out.println("Conference with ID " + conferenceID + 
            " added successfully.");
    }

    public static void showConferences() {
        if (conferences.isEmpty()) {
            System.out.println("No conferences found.");
            return;
        } 
        else {
            System.out.println("--Conferences--");
            for (Conference c : conferences) {
                System.out.println(c);
            }
        }
    }

    public static void updateConference(Scanner scanner) {
        boolean updateSuccessful = false;

        System.out.println("Enter the ID of the conference you wish to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Conference selectedConference = getConferenceByID(id); 

        if (selectedConference == null) {
            System.out.println("There is no conference with this ID.");
            return;
        }

        System.out.println("~~Conference Update Options~~");
        System.out.println("1. Title");
        System.out.println("2. Start Date");
        System.out.println("3. End Date");
        System.out.println("4. Topic");
        System.out.println("Please enter the number by what you want to update: ");
        
        int decision = scanner.nextInt();
        scanner.nextLine();
        switch(decision) {
            case 1:
                System.out.println("Please enter the new title for the conference: ");
                String newConferenceTitle = scanner.nextLine();
                selectedConference.setTitle(newConferenceTitle);
                updateSuccessful = true;
                break;
            case 2:
                System.out.println("Please enter the new start date: ");
                String newStart = scanner.nextLine();
                selectedConference.setStartDate(newStart);
                updateSuccessful = true;
                break;
            case 3:
                System.out.println("Please enter the new end date: ");
                String newEnd = scanner.nextLine();
                selectedConference.setEndDate(newEnd);
                updateSuccessful = true;
                break;
            case 4:
                System.out.println("Please enter the new topic: ");
                String newTopic = scanner.nextLine();
                selectedConference.setTopic(newTopic);
                updateSuccessful = true;
                break;
            default:
                System.out.println("Invalid input.");
                return;
            }
        if (updateSuccessful) {
            System.out.println("Conference update successful.");
        }    
    }

    public static void deleteConference(Scanner scanner) {
        System.out.println("Please enter the ID of the conference you wish to delete: ");
        int deletionID = scanner.nextInt();
        scanner.nextLine();

        Conference conferenceToDelete = getConferenceByID(deletionID);
        if (conferenceToDelete == null) {
            System.out.println("No such conference found.");
            return;
        }
        else {
            conferences.remove(conferenceToDelete);
            System.out.println("Conference with ID " + deletionID +
                " deleted successfully.");
        }
    }

    public static Conference getConferenceByID(int id) {
        for (Conference c : conferences) {
            if(c.getConferenceId() == id) {
                return c;
            }
        }
        return null;
    }

    public static void conferenceMenu(Scanner scanner) {
        int decision;
        do {
            System.out.println("~~~~~~~~~~~");
            System.out.println("Conference Menu: ");
            System.out.println("1. Add a conference");
            System.out.println("2. View all conferences");
            System.out.println("3. Update a conference");
            System.out.println("4. Delete a conference");
            System.out.println("5. Quit");
            System.out.println("~~~~~~~~~~~");
            System.out.print("Enter your choice: ");

            if (scanner.hasNextInt()) {
                decision = scanner.nextInt();
                scanner.nextLine();
                switch (decision) {
                    case 1:
                        addConference(scanner);
                        break;
                    case 2:
                        showConferences();
                        break;
                    case 3:
                        updateConference(scanner);
                        break;
                    case 4:
                        deleteConference(scanner);
                        break;
                    case 5:
                        System.out.println("Exiting conference menu.");
                        break;
                    default:
                        System.out.println("Invalid input. Please try again.");
                }
            }

            else {
                System.out.println("Invalid input. Please try again.");
                scanner.nextLine();
                decision = 0;
            }
            
        } while (decision != 5);
    }
}
