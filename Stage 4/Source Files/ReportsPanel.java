/**
 * @author Jillian Stork
 * CSCI 2210 Project
 * Conference Management System
 * Reports Panel Class
 * This is the class for the report GUI
 */

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class ReportsPanel extends JPanel {

    public ReportsPanel() {

        setLayout(new BorderLayout());

        JLabel title = new JLabel("Reports", JLabel.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 20));

        add(title, BorderLayout.NORTH);

        // Buttons panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(2, 1, 10, 10));

        JButton projectorReportBtn = new JButton("Rooms with Projectors");
        JButton speakerReportBtn = new JButton("Speakers by Organization");

        buttonPanel.add(projectorReportBtn);
        buttonPanel.add(speakerReportBtn);

        add(buttonPanel, BorderLayout.CENTER);

        // ================= REPORT 1 =================
        projectorReportBtn.addActionListener(e -> {
            StringBuilder sb = new StringBuilder();

            for (Room r : RoomManager.getAll()) {
                if (r.getHasProjector()) {
                    sb.append("ID: ").append(r.getRoomId())
                      .append(" | ").append(r.getName())
                      .append(" | Capacity: ").append(r.getCapacity())
                      .append("\n");
                }
            }

            JOptionPane.showMessageDialog(this,
                sb.length() == 0 ? "No rooms with projectors." : sb.toString(),
                "Rooms with Projectors",
                JOptionPane.INFORMATION_MESSAGE);
        });

        // ================= REPORT 2 =================
        speakerReportBtn.addActionListener(e -> {

            Map<String, ArrayList<Speaker>> map = new HashMap<>();

            for (Speaker s : SpeakerManager.getAll()) {
                map.putIfAbsent(s.getOrganization(), new ArrayList<>());
                map.get(s.getOrganization()).add(s);
            }

            StringBuilder sb = new StringBuilder();

            for (String org : map.keySet()) {
                sb.append("\nOrganization: ").append(org).append("\n");

                for (Speaker s : map.get(org)) {
                    sb.append(" - ")
                      .append(s.getName())
                      .append(" (")
                      .append(s.getJobTitle())
                      .append(")\n");
                }
            }

            JOptionPane.showMessageDialog(this,
                sb.length() == 0 ? "No speakers found." : sb.toString(),
                "Speakers by Organization",
                JOptionPane.INFORMATION_MESSAGE);
        });
    }
}
