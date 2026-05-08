package CSCI2210_Project_Stage4;

/**
 * @author Jillian Stork
 * CSCI 2210 Project
 * Conference Management System
 * SchedulePanel Class
 * This is the class for the Schedule GUI
 */

import javax.swing.*;
import java.util.ArrayList;

public class SchedulePanel extends BasePanel {

    public SchedulePanel() {
        super(new String[]{"ID", "Conference", "Room", "Date", "Start", "End"});
        refreshTable();
    }

    // pulls all schedules into the table
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

        tableModel.fireTableDataChanged();
        revalidate();
        repaint();
    }

    // search by conference, room, date, or ID
    @Override
    protected void doSearch() {

        if (ScheduleManager.getAll().isEmpty()) {
            JOptionPane.showMessageDialog(
                this,
                "There are no schedules to search for.",
                "No Schedules Found",
                JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        JTextField generalSearchF = new JTextField();
        JTextField idSearchF = new JTextField();

        int res = JOptionPane.showConfirmDialog(
            this,
            new Object[]{
                "General Search:", generalSearchF,
                "Search by ID:", idSearchF
            },
            "Search Schedules",
            JOptionPane.OK_CANCEL_OPTION
        );

        if (res != JOptionPane.OK_OPTION) return;

        String s = generalSearchF.getText().trim().toLowerCase();
        String idResult = idSearchF.getText().trim();
        Integer id = null;

        try {
            if (!idResult.isEmpty()) {
                id = Integer.valueOf(idResult);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(
                this,
                "ID must be a number.",
                "Invalid ID",
                JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        if (s.isEmpty() && idResult.isEmpty()) {
            JOptionPane.showMessageDialog(
                this,
                "Please enter a schedule feature to search by.",
                "Invalid Search",
                JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        tableModel.setRowCount(0);

        for (Schedule x : ScheduleManager.getAll()) {
            String conf = x.getConference() != null ? x.getConference().getTitle().toLowerCase() : "";
            String room = x.getRoom() != null ? x.getRoom().getName().toLowerCase() : "";

            boolean matchesGeneral = conf.contains(s)
                || room.contains(s)
                || x.getDate().toLowerCase().contains(s);

            boolean matchesId = (id == null || x.getScheduleId() == id);

            if (matchesGeneral && matchesId) {
                tableModel.addRow(new Object[]{
                    x.getScheduleId(),
                    x.getConference() != null ? x.getConference().getTitle() : "?",
                    x.getRoom() != null ? x.getRoom().getName() : "?",
                    x.getDate(),
                    x.getStartTime(),
                    x.getEndTime()
                });
            }
        }

        if (tableModel.getRowCount() == 0) {
            JOptionPane.showMessageDialog(
                this,
                "No schedules matched your search.",
                "No Results",
                JOptionPane.INFORMATION_MESSAGE
            );
        }
    }

    // pick a conference and room, set the date and times
    @Override
    protected void doAdd() {
        ArrayList<Room> rooms = RoomManager.getAll();
        ArrayList<Conference> conferences = ConferenceManager.getAll();

        if (rooms.isEmpty() || conferences.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Need at least one room and one conference first.");
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
                JOptionPane.OK_CANCEL_OPTION)
                == JOptionPane.OK_OPTION) {

            Room room = rooms.get(roomBox.getSelectedIndex());
            Conference conf = conferences.get(confBox.getSelectedIndex());

            ScheduleManager.addSchedule(
                room,
                conf,
                dateF.getText().trim(),
                startF.getText().trim(),
                endF.getText().trim()
            );

            DataPersistence.saveAll();
            refreshTable();
        }
    }

    // edit the date and time window for an existing schedule
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
                JOptionPane.OK_CANCEL_OPTION)
                == JOptionPane.OK_OPTION) {

            s.setDate(dateF.getText().trim());
            s.setStartTime(startF.getText().trim());
            s.setEndTime(endF.getText().trim());

            DataPersistence.saveAll();
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
                JOptionPane.YES_NO_OPTION)
                == JOptionPane.YES_OPTION) {

            Schedule s = ScheduleManager.getScheduleByID(id);
            if (s != null) {
                ScheduleManager.getAll().remove(s);
            }

            DataPersistence.saveAll();
            refreshTable();
        }
    }
}
