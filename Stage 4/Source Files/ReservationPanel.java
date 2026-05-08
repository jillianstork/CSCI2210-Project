package CSCI2210_Project_Stage4;

/**
 * @author Jillian Stork
 * CSCI 2210 Project
 * Conference Management System
 * ReservationPanel Class
 * This is the class for the Reservation GUI
 */

import javax.swing.*;
import java.util.ArrayList;

public class ReservationPanel extends BasePanel {

    public ReservationPanel() {
        super(new String[]{"ID", "Room", "Start", "End", "Status"});
        refreshTable();
    }

    // pulls all reservations into the table
    @Override
    protected void refreshTable() {
        tableModel.setRowCount(0);

        for (Reservation r : ReservationManager.getAll()) {
            tableModel.addRow(new Object[]{
                r.getReservationId(),
                r.getRoom() != null ? r.getRoom().getName() : "?",
                r.getStartDateOrTime(),
                r.getEndDateOrTime(),
                r.getStatus()
            });
        }
    }

    // search by room name, status, or ID
    @Override
    protected void doSearch() {

        if (ReservationManager.getAll().isEmpty()) {
            JOptionPane.showMessageDialog(
                this,
                "There are no reservations to search for.",
                "No Reservations Found",
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
            "Search Reservations",
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
                "Please enter a reservation feature to search by.",
                "Invalid Search",
                JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        tableModel.setRowCount(0);

        for (Reservation r : ReservationManager.getAll()) {
            String room = r.getRoom() != null ? r.getRoom().getName().toLowerCase() : "";

            boolean matchesGeneral = room.contains(s)
                || r.getStatus().toLowerCase().contains(s);

            boolean matchesId = (id == null || id == r.getReservationId());

            if (matchesGeneral && matchesId) {
                tableModel.addRow(new Object[]{
                    r.getReservationId(),
                    r.getRoom() != null ? r.getRoom().getName() : "?",
                    r.getStartDateOrTime(),
                    r.getEndDateOrTime(),
                    r.getStatus()
                });
            }
        }

        if (tableModel.getRowCount() == 0) {
            JOptionPane.showMessageDialog(
                this,
                "No reservations matched your search.",
                "No Results",
                JOptionPane.INFORMATION_MESSAGE
            );
        }
    }

    // pick a room, set start/end times, and add the reservation
    @Override
    protected void doAdd() {
        ArrayList<Room> rooms = RoomManager.getAll();

        if (rooms.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Add a room first.");
            return;
        }

        JComboBox<String> roomBox = new JComboBox<>();
        for (Room room : rooms) {
            roomBox.addItem(room.getRoomId() + " - " + room.getName());
        }

        JTextField startF = new JTextField();
        JTextField endF = new JTextField();

        Object[] fields = {
            "Room:", roomBox,
            "Start:", startF,
            "End:", endF
        };

        if (JOptionPane.showConfirmDialog(this, fields,
                "Add Reservation", JOptionPane.OK_CANCEL_OPTION)
                == JOptionPane.OK_OPTION) {

            Room r = rooms.get(roomBox.getSelectedIndex());

            ReservationManager.addReservation(
                r,
                startF.getText().trim(),
                endF.getText().trim()
            );

            refreshTable();
        }
    }

    // only the status can be changed after the fact
    @Override
    protected void doEdit() {
        int row = getSelectedRow();

        if (row < 0) {
            JOptionPane.showMessageDialog(this, "Select a reservation.");
            return;
        }

        int id = (int) tableModel.getValueAt(row, 0);
        Reservation r = ReservationManager.getReservationByID(id);
        if (r == null) return;

        String[] options = {"Pending", "Confirmed", "Cancelled"};

        String choice = (String) JOptionPane.showInputDialog(
            this,
            "Update status:",
            "Edit Reservation",
            JOptionPane.QUESTION_MESSAGE,
            null,
            options,
            r.getStatus()
        );

        if (choice != null) {
            if (choice.equals("Confirmed")) r.confirm();
            else if (choice.equals("Cancelled")) r.cancel();

            refreshTable();
        }
    }

    @Override
    protected void doDelete() {
        int row = getSelectedRow();

        if (row < 0) {
            JOptionPane.showMessageDialog(this, "Select a reservation.");
            return;
        }

        int id = (int) tableModel.getValueAt(row, 0);

        if (JOptionPane.showConfirmDialog(this,
                "Delete reservation ID " + id + "?",
                "Confirm",
                JOptionPane.YES_NO_OPTION)
                == JOptionPane.YES_OPTION) {

            Reservation r = ReservationManager.getReservationByID(id);
            if (r != null) {
                ReservationManager.getAll().remove(r);
            }

            refreshTable();
        }
    }
}
