/**
 * @author Jillian Stork
 * CSCI 2210 Project
 * Conference Management System
 * Schedule Panel Class
 * This is the class for the schedule GUI
 */
import javax.swing.*;
import java.util.*;

/**
 * GUI panel for managing Schedule objects (CRUD + search).
 */
public class SchedulePanel extends BasePanel {

    public SchedulePanel() {
        super(new String[]{"ID","Conference","Room","Date","Start","End"});
        refreshTable();
    }

    @Override
    protected void refreshTable() {
        tableModel.setRowCount(0);

        for (Schedule s : ScheduleManager.getAll()) {
            tableModel.addRow(new Object[]{
                s.getScheduleId(),
                s.getConference() != null ? s.getConference().getTitle() : "?",
                s.getRoom() != null ? s.getRoom().getName() : "?",
                s.getDate(),
                s.getStartTime(),
                s.getEndTime()
            });
        }

        // Optional but harmless:
        tableModel.fireTableDataChanged();
        revalidate();
        repaint();
    }

    @Override
    protected void doSearch(String q) {
        tableModel.setRowCount(0);

        for (Schedule s : ScheduleManager.getAll()) {

            String conf = s.getConference() != null
                    ? s.getConference().getTitle().toLowerCase()
                    : "";

            String room = s.getRoom() != null
                    ? s.getRoom().getName().toLowerCase()
                    : "";

            if (String.valueOf(s.getScheduleId()).contains(q)
                    || conf.contains(q)
                    || room.contains(q)
                    || s.getDate().toLowerCase().contains(q)) {

                tableModel.addRow(new Object[]{
                    s.getScheduleId(),
                    s.getConference() != null ? s.getConference().getTitle() : "?",
                    s.getRoom() != null ? s.getRoom().getName() : "?",
                    s.getDate(),
                    s.getStartTime(),
                    s.getEndTime()
                });
            }
        }
    }

    @Override
    protected void doAdd() {
        ArrayList<Room> rooms = RoomManager.getAll();
        ArrayList<Conference> conferences = ConferenceManager.getAll();

        if (rooms.isEmpty() || conferences.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Need rooms and conferences.");
            return;
        }

        JComboBox<String> roomBox = new JComboBox<>();
        for (Room r : rooms) {
            roomBox.addItem(r.getRoomId() + " - " + r.getName());
        }

        JComboBox<String> confBox = new JComboBox<>();
        for (Conference c : conferences) {
            confBox.addItem(c.getConferenceId() + " - " + c.getTitle());
        }

        JTextField dateF = new JTextField();
        JTextField startF = new JTextField();
        JTextField endF = new JTextField();

        Object[] fields = {
            "Conference:", confBox,
            "Room:", roomBox,
            "Date:", dateF,
            "Start Time:", startF,
            "End Time:", endF
        };

        if (JOptionPane.showConfirmDialog(
                this, fields,
                "Add Schedule",
                JOptionPane.OK_CANCEL_OPTION
        ) == JOptionPane.OK_OPTION) {

            Room room = rooms.get(roomBox.getSelectedIndex());
            Conference conf = conferences.get(confBox.getSelectedIndex());

            ScheduleManager.addSchedule(
                    room,
                    conf,
                    dateF.getText().trim(),
                    startF.getText().trim(),
                    endF.getText().trim()
            );

            refreshTable();
        }
    }

    @Override
    protected void doEdit() {
        int row = getSelectedRow();

        if (row < 0) {
            JOptionPane.showMessageDialog(this, "Select a schedule.");
            return;
        }

        int id = (int) tableModel.getValueAt(row, 0);
        Schedule s = ScheduleManager.getScheduleByID(id);

        if (s == null) return;

        JTextField dateF = new JTextField(s.getDate());
        JTextField startF = new JTextField(s.getStartTime());
        JTextField endF = new JTextField(s.getEndTime());

        Object[] fields = {
            "Date:", dateF,
            "Start Time:", startF,
            "End Time:", endF
        };

        if (JOptionPane.showConfirmDialog(
                this, fields,
                "Edit Schedule",
                JOptionPane.OK_CANCEL_OPTION
        ) == JOptionPane.OK_OPTION) {

            s.setDate(dateF.getText().trim());
            s.setStartTime(startF.getText().trim());
            s.setEndTime(endF.getText().trim());

            refreshTable();
        }
    }

    @Override
    protected void doDelete() {
        int row = getSelectedRow();

        if (row < 0) {
            JOptionPane.showMessageDialog(this, "Select a schedule.");
            return;
        }

        int id = (int) tableModel.getValueAt(row, 0);

        if (JOptionPane.showConfirmDialog(
                this,
                "Delete schedule ID " + id + "?",
                "Confirm",
                JOptionPane.YES_NO_OPTION
        ) == JOptionPane.YES_OPTION) {

            Schedule s = ScheduleManager.getScheduleByID(id);

            if (s != null) {
                ScheduleManager.getAll().remove(s);
            }

            refreshTable();
        }
    
        
    JButton quitButton = new JButton("Quit");

    quitButton.addActionListener(e -> {
    System.exit(0);
        });
    }
    
}