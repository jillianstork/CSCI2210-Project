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

    public static void main(String[] args) {

        //Step 1: Create dummy data
        TestData.load();

        //Step 2: Start menu loop
        ConferenceSystemMenu.menu(scanner);

    }

}
