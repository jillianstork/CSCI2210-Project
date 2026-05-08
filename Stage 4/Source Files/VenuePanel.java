package CSCI2210_Project_Stage4;

/**
 * @author Jillian Stork
 * CSCI 2210 Project
 * Conference Management System
 * VenuePanel Class
 * This is the class for the Venue GUI
 */

import javax.swing.*;

public class VenuePanel extends BasePanel {

    public VenuePanel(){
        super(new String[]{"ID", "Name"});
    }

    // pulls all venues into the table
    @Override
    protected void refreshTable() {
        tableModel.setRowCount(0);

        for (Venue v : VenueManager.getAll()) {
            tableModel.addRow(new Object[]{
                v.getVenueId(),
                v.getName()
            });
        }
    }

    // search by venue name or ID
    @Override
    protected void doSearch() {

        if (VenueManager.getAll().isEmpty()) {
            JOptionPane.showMessageDialog(
                this,
                "There are no venues to search for.",
                "No Venues Found",
                JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        JTextField generalSearchF = new JTextField();
        JTextField idSearchF = new  JTextField();

        int res = JOptionPane.showConfirmDialog(
            this,
            new Object[]{
                "General Search:", generalSearchF,
                "Search by ID:", idSearchF
            },
            "Search Venues",
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
                "Please enter a venue feature to search by.",
                "Invalid Search",
                JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        tableModel.setRowCount(0);

        for (Venue v : VenueManager.getAll()) {
            boolean matchesGeneral = v.getName().toLowerCase().contains(s);
            boolean matchesId = (id == null || id == v.getVenueId());

            if (matchesGeneral && matchesId) {
                tableModel.addRow(new Object[]{
                    v.getVenueId(),
                    v.getName()
                });
            }
        }

        if (tableModel.getRowCount() == 0) {
            JOptionPane.showMessageDialog(
                this,
                "No venues matched your search.",
                "No Results",
                JOptionPane.INFORMATION_MESSAGE
            );
        }
    }

    @Override
    protected void doAdd() {
        JTextField nameF = new JTextField();

        int res = JOptionPane.showConfirmDialog(
            this,
            new Object[]{"Venue Name:", nameF},
            "Add Venue",
            JOptionPane.OK_CANCEL_OPTION
        );

        if  (res == JOptionPane.OK_OPTION && !nameF.getText().trim().isEmpty()) {
            VenueManager.addVenue(nameF.getText().trim());
            DataPersistence.saveAll();
            refreshTable();
        }
    }

    @Override
    protected void doEdit() {
        int row = getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "Select a venue first.");
            return;
        }

        int id = (int) tableModel.getValueAt(row, 0);
        Venue v = VenueManager.getVenueByID(id);
        if (v == null) return;

        JTextField nameF = new JTextField(v.getName());

        int res = JOptionPane.showConfirmDialog(
            this,
            new Object[]{"Venue Name:", nameF},
            "Edit Venue",
            JOptionPane.OK_CANCEL_OPTION
        );

        if (res == JOptionPane.OK_OPTION) {
            v.setName(nameF.getText().trim());
            DataPersistence.saveAll();
            refreshTable();
        }
    }

    @Override
    protected void doDelete() {
        int row = getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "Select a venue first.");
            return;
        }

        int id = (int) tableModel.getValueAt(row, 0);

        int confirm = JOptionPane.showConfirmDialog(
            this,
            "Delete venue ID " + id + "?",
            "Confirm",
            JOptionPane.YES_NO_OPTION
        );

        if (confirm == JOptionPane.YES_OPTION) {
            Venue v = VenueManager.getVenueByID(id);
            if (v != null) {
                VenueManager.getAll().remove(v);
            }
            DataPersistence.saveAll();
            refreshTable();
        }
    }
}
