/**
 * @author Jillian Stork
 * CSCI 2210 Project
 * Conference Management System
 * Room Panel Class
 * This is the class for the room GUI
 */

import javax.swing.*;
import java.util.*;

public class RoomPanel extends BasePanel {

    public RoomPanel() {
        super(new String[]{"ID", "Name", "Capacity", "Venue", "Projector", "Computers"});
        refreshTable();
    }

    // ---------------- READ ----------------
    @Override
    protected void refreshTable() {
        tableModel.setRowCount(0);

        for (Room r : RoomManager.getAll()) {
            tableModel.addRow(new Object[]{
                r.getRoomId(),
                r.getName(),
                r.getCapacity(),
                r.getLocation() != null ? r.getLocation().getName() : "?",
                r.getHasProjector(),
                r.getNumberOfComputers()
            });
        }
    }

    // ---------------- SEARCH  ----------------
    @Override
    protected void doSearch(String q) {
        tableModel.setRowCount(0);

        for (Room r : RoomManager.getAll()) {
            String venue = r.getLocation() != null ? r.getLocation().getName().toLowerCase() : "";

            if (String.valueOf(r.getRoomId()).contains(q)
                || r.getName().toLowerCase().contains(q)
                || venue.contains(q)) {

                tableModel.addRow(new Object[]{
                    r.getRoomId(),
                    r.getName(),
                    r.getCapacity(),
                    r.getLocation() != null ? r.getLocation().getName() : "?",
                    r.getHasProjector(),
                    r.getNumberOfComputers()
                });
            }
        }
    }

    // ---------------- CREATE ----------------
    @Override
    protected void doAdd() {

        JTextField nameF = new JTextField();
        JTextField capacityF = new JTextField();
        JTextField computersF = new JTextField();
        JCheckBox projectorBox = new JCheckBox("Has Projector");

        JComboBox<String> venueBox = new JComboBox<>();
        ArrayList<Venue> venues = VenueManager.getAll();

        for (Venue v : venues) {
            venueBox.addItem(v.getVenueId() + " - " + v.getName());
        }

        Object[] fields = {
            "Name:", nameF,
            "Capacity:", capacityF,
            "Venue:", venueBox,
            "Projector:", projectorBox,
            "Computers:", computersF
        };

        int result = JOptionPane.showConfirmDialog(
            this,
            fields,
            "Add Room",
            JOptionPane.OK_CANCEL_OPTION
        );

        if (result == JOptionPane.OK_OPTION) {

            Venue v = venues.get(venueBox.getSelectedIndex());

            RoomManager.addRoom(
                nameF.getText().trim(),
                Integer.parseInt(capacityF.getText().trim()),
                v,
                projectorBox.isSelected(),
                Integer.parseInt(computersF.getText().trim())
            );


            refreshTable();
        }
    }

    // ---------------- UPDATE ----------------
    @Override
    protected void doEdit() {

        int row = getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "Select a room first.");
            return;
        }

        int id = (int) tableModel.getValueAt(row, 0);
        Room r = RoomManager.getRoomById(id);
        if (r == null) return;

        JTextField nameF = new JTextField(r.getName());
        JTextField capacityF = new JTextField(String.valueOf(r.getCapacity()));
        JTextField computersF = new JTextField(String.valueOf(r.getNumberOfComputers()));
        JCheckBox projectorBox = new JCheckBox("Has Projector", r.getHasProjector());

        Object[] fields = {
            "Name:", nameF,
            "Capacity:", capacityF,
            "Projector:", projectorBox,
            "Computers:", computersF
        };

        int result = JOptionPane.showConfirmDialog(
            this,
            fields,
            "Edit Room",
            JOptionPane.OK_CANCEL_OPTION
        );

        if (result == JOptionPane.OK_OPTION) {

            r.setName(nameF.getText().trim());
            r.setCapacity(Integer.parseInt(capacityF.getText().trim()));
            r.setNumberOfComputers(Integer.parseInt(computersF.getText().trim()));
            r.setHasProjector(projectorBox.isSelected());

            refreshTable();
        }
    }

    // ---------------- DELETE ----------------
    @Override
    protected void doDelete() {

        int row = getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "Select a room first.");
            return;
        }

        int id = (int) tableModel.getValueAt(row, 0);

        int confirm = JOptionPane.showConfirmDialog(
            this,
            "Delete room ID " + id + "?",
            "Confirm",
            JOptionPane.YES_NO_OPTION
        );

        if (confirm == JOptionPane.YES_OPTION) {

            Room r = RoomManager.getRoomById(id);
            if (r != null) {
                RoomManager.getAll().remove(r);
            }

            
            refreshTable();
        }
    }
}