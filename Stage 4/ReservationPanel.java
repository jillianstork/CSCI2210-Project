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
    protected void doSearch() {
        
        if (ReservationManager.getAll().isEmpty()) {
            JOptionPane.showMessageDialog(
                this,
                "There are no reservations to search for.",
                "No Reservations in Catalog",
                JOptionPane.WARNING_MESSAGE   
            );
            return;
        }
        
        JTextField searchF = new JTextField();
        
        int res = JOptionPane.showConfirmDialog(
            this,
            new Object[] { "Searching for:", searchF},
            "Search Reservations",
            JOptionPane.OK_CANCEL_OPTION
        );
        
        if (res != JOptionPane.OK_OPTION) {
            return;
        }
        
        tableModel.setRowCount(0);
        
        String s = searchF.getText().trim().toLowerCase();
        
        if (s.isEmpty()) {
            JOptionPane.showMessageDialog(
                this,
                "Please enter a reservation feature to search by.",
                "Invalid Search",
                JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        for (Reservation r : ReservationManager.getAll()) {
            String room = r.getRoom() != null ? r.getRoom().getName().toLowerCase() : "";

            if (String.valueOf(r.getReservationId()).contains(s)
                    || room.contains(s)
                    || r.getStatus().toLowerCase().contains(s)) {

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