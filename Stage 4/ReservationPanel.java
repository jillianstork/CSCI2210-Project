/**
 * @author Jillian Stork
 * CSCI 2210 Project
 * Conference Management System
 * Reservation Panel Class
 * This is the class for the Reservation GUI
 */
import javax.swing.*;
import java.util.*;

/**
 * GUI panel for managing Reservation objects (CRUD + search).
 */
public class ReservationPanel extends BasePanel {

    public ReservationPanel() {
        super(new String[]{"ID","Room","Start","End","Status"});
        refreshTable();
    }

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

    @Override
    protected void doSearch(String q) {
        tableModel.setRowCount(0);

        for (Reservation r : ReservationManager.getAll()) {
            String room = r.getRoom() != null ? r.getRoom().getName().toLowerCase() : "";

            if (String.valueOf(r.getReservationId()).contains(q)
                    || room.contains(q)
                    || r.getStatus().toLowerCase().contains(q)) {

                tableModel.addRow(new Object[]{
                    r.getReservationId(),
                    r.getRoom() != null ? r.getRoom().getName() : "?",
                    r.getStartDateOrTime(),
                    r.getEndDateOrTime(),
                    r.getStatus()
                });
            }
        }
    }

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