import java.util.Scanner;

/**
 * @author Jillian Stork
 * CSCI 2210 Project
 * Conference Management System
 * Main class -- coordinates activities
 * of the other classes.
 */
public class Main {

    private static Scanner scanner = new Scanner(System.in);

    /**
     * This is the main method.
     * @param args command-line arguments
     */
    public static void main(String[] args) {

        //Create dummy data
        TestData.load();
        
        //Start menu loop
        Menu.ConferenceSystemMenu(scanner);

    }

}
