
/**
 * @author Jillian Stork
 * CSCI 2210 Project
 * Conference Management System
 * Venue Panel Class
 * This is the class for the Venue GUI
 */

import javax.swing.*;

/**
 * GUI panel for managing Venue objects (CRUD + search).
 */
public class VenuePanel extends BasePanel {

    public VenuePanel() {
        super(new String[]{"ID", "Name"});
    }

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

    @Override
    protected void doSearch(String query) {
        tableModel.setRowCount(0);

        for (Venue v : VenueManager.getAll()) {
            if (String.valueOf(v.getVenueId()).contains(query)
                || v.getName().toLowerCase().contains(query)) {

                tableModel.addRow(new Object[]{
                    v.getVenueId(),
                    v.getName()
                });
            }
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

        if (res == JOptionPane.OK_OPTION && !nameF.getText().trim().isEmpty()) {
            VenueManager.addVenue(nameF.getText().trim());
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

            refreshTable();
        }
    }
}