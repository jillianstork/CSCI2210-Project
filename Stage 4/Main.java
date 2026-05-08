/**
 * @author Jillian Stork
 * CSCI 2210 Project
 * Conference Management System
 * Main class -- coordinates activities
 * of the other classes.
 */

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        //TestData.load();
        DataPersistence.loadAll(); 
        DataPersistence.saveAll();

        SwingUtilities.invokeLater(() -> {

            JFrame home = new JFrame("Conference Management System");
            home.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            home.setSize(400, 400);
            home.setLocationRelativeTo(null);

            JPanel panel = new JPanel();
            panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

            JLabel title = new JLabel("MAIN MENU");
            title.setAlignmentX(JLabel.CENTER_ALIGNMENT);

            JButton reservationsBtn = new JButton("Reservations");
            JButton schedulesBtn = new JButton("Schedules");
            JButton venuesBtn = new JButton("Venues");
            JButton roomsBtn = new JButton("Rooms");
            JButton speakersBtn = new JButton("Speakers");
            JButton attendeesBtn = new JButton("Attendees");
            JButton organizersBtn = new JButton("Organizers");
            //JButton reportsBtn = new JButton("Reports");
            JButton exitBtn = new JButton("Exit");

            panel.add(Box.createVerticalStrut(20));
            panel.add(title);
            panel.add(Box.createVerticalStrut(20));

            panel.add(reservationsBtn);
            panel.add(schedulesBtn);
            panel.add(venuesBtn);
            panel.add(roomsBtn);
            panel.add(speakersBtn);
            panel.add(attendeesBtn);
            panel.add(organizersBtn);
            //panel.add(reportsBtn);

            panel.add(Box.createVerticalStrut(20));
            panel.add(exitBtn);

            home.setContentPane(panel);
            home.setVisible(true);

            // ---------------- OPEN WINDOWS ----------------

            reservationsBtn.addActionListener(e -> openWindow("Reservations", new ReservationPanel()));
            schedulesBtn.addActionListener(e -> openWindow("Schedules", new SchedulePanel()));
            venuesBtn.addActionListener(e -> openWindow("Venues", new VenuePanel()));
            roomsBtn.addActionListener(e -> openWindow("Rooms", new RoomPanel()));
            speakersBtn.addActionListener(e -> openWindow("Speakers", new SpeakerPanel()));
            attendeesBtn.addActionListener(e -> openWindow("Attendees", new AttendeePanel()));
            organizersBtn.addActionListener(e -> openWindow("Organizers", new OrganizerPanel()));
            //reportsBtn.addActionListener(e -> openWindow("Reports", new ReportsPanel()));
            
            exitBtn.addActionListener(e -> {
                    DataPersistence.saveAll();
                    System.exit(0);
            });
        });
    }    

    // helper method
    private static void openWindow(String title, JPanel panel) {

        JFrame frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(900, 600);
        frame.setLocationRelativeTo(null);

        // wrapper panel (so we can add a back button)
        JPanel wrapper = new JPanel();
        wrapper.setLayout(new java.awt.BorderLayout());

        JButton backBtn = new JButton("⬅ Back to Main Menu");

        backBtn.addActionListener(e -> frame.dispose());

        wrapper.add(backBtn, java.awt.BorderLayout.NORTH);
        wrapper.add(panel, java.awt.BorderLayout.CENTER);

        frame.setContentPane(wrapper);
        frame.setVisible(true);
    }
}

