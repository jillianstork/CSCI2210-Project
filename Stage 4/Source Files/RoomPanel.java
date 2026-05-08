package CSCI2210_Project_Stage4;

/**
 * @author Jillian Stork
 * CSCI 2210 Project
 * Conference Management System
 * RoomPanel Class
 * This is the class for the Room GUI
 */

import javax.swing.*;
import java.util.ArrayList;

public class RoomPanel extends BasePanel {

    public RoomPanel() {
        super(new String[]{"ID", "Name", "Capacity", "Venue", "Projector", "Computers"});
        refreshTable();
    }

    // pulls all rooms into the table
    @Override
    protected void refreshTable()  {
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

    // search by room name, venue, or ID
    @Override
    protected void doSearch() {

        if (RoomManager.getAll().isEmpty()) {
            JOptionPane.showMessageDialog(
                this,
                "There are no rooms to search for.",
                "No Rooms Found",
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
            "Search Rooms",
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
                "Please enter a room feature to search by.",
                "Invalid Search",
                JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        tableModel.setRowCount(0);

        for (Room r : RoomManager.getAll()) {
            String venue = r.getLocation() != null ? r.getLocation().getName().toLowerCase() : "";

            boolean matchesGeneral = r.getName().toLowerCase().contains(s)
                || venue.contains(s);

            boolean matchesId = (id == null || r.getRoomId() == id);

            if (matchesGeneral && matchesId) {
                tableModel.addRow(new Object[]{
                    r.getRoomId() ,
                    r.getName(),
                    r.getCapacity(),
                    r.getLocation() != null ? r.getLocation().getName() : "?",
                    r.getHasProjector(),
                    r.getNumberOfComputers()
                });
            }
        }

        if (tableModel.getRowCount() == 0) {
            JOptionPane.showMessageDialog(
                this,
                "No rooms matched your search.",
                "No Results",
                JOptionPane.INFORMATION_MESSAGE
            );
        }
    }

    // pick a venue, set room details, and add the room
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

            DataPersistence.saveAll();
            refreshTable();
        }
    }

    // edit name, capacity, projector, and computer count
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

            DataPersistence.saveAll();
            refreshTable();
        }
    }

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

            DataPersistence.saveAll();
            refreshTable();
        }
    }
}
