/**
 * @author Maya L. Garcia Schafer
 * CSCI 2210 Project
 * Conference Management System
 * Organizer Panel Class
 * This is the class for the organizer GUI
 */
import javax.swing.*;

public class OrganizerPanel extends BasePanel {

    public OrganizerPanel() {
        super(new String[]{"ID","Name","Email","Phone","Organization","Job Title"});
    }

    // READ
    @Override
    protected void refreshTable() {
        tableModel.setRowCount(0);

        for (Organizer o : OrganizerManager.getAll()) {
            tableModel.addRow(new Object[]{
                o.getOrganizerId(),
                o.getName(),
                o.getEmail(),
                o.getPhoneNumber(),
                o.getOrganization(),
                o.getJobTitle()
            });
        }
    }

    // SEARCH
    @Override
    protected void doSearch() {
        
        if(OrganizerManager.getAll().isEmpty()) {
            JOptionPane.showMessageDialog(
                this,
                "There are no organizers to search for.",
                "No Organizers in Catalog",
                JOptionPane.WARNING_MESSAGE
            );
            return;
        }
        
        JTextField searchF = new JTextField();
        
        int res = JOptionPane.showConfirmDialog(
            this,
            new Object[] {"Searching for:", searchF},
            "Search Organizers",
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
                "Please enter an organizer feature to search by.",
                "Invalid Search",
                JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        for (Organizer x : OrganizerManager.getAll()) {
            if (String.valueOf(x.getOrganizerId()).contains(s)
                || x.getName().toLowerCase().contains(s)
                || x.getEmail().toLowerCase().contains(s)
                || x.getOrganization().toLowerCase().contains(s)) {

                tableModel.addRow(new Object[]{
                    x.getOrganizerId(),
                    x.getName(),
                    x.getEmail(),
                    x.getPhoneNumber(),
                    x.getOrganization(),
                    x.getJobTitle()
                });
            }
        }
        
        if (tableModel.getRowCount() == 0) {
            JOptionPane.showMessageDialog(
                this,
                "No organizers matched your search.",
                "No Results",
                JOptionPane.INFORMATION_MESSAGE
            );
        }
    }

    // CREATE
    @Override
    protected void doAdd() {

        PersonFormHelper form = new PersonFormHelper();

        int result = JOptionPane.showConfirmDialog(
            this,
            form.getFields(),
            "Add Organizer",
            JOptionPane.OK_CANCEL_OPTION
        );

        if (result == JOptionPane.OK_OPTION) {

            if (form.nameF.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Name required.");
                return;
            }

            OrganizerManager.addOrganizer(
                form.nameF.getText().trim(),
                form.emailF.getText().trim(),
                form.phoneF.getText().trim(),
                form.addressF.getText().trim(),
                form.bioF.getText().trim(),
                form.orgF.getText().trim(),
                form.jobF.getText().trim()
            );

            refreshTable();
        }
    }

    // UPDATE
    @Override
    protected void doEdit() {

        int row = getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "Select an organizer.");
            return;
        }

        int id = (int) tableModel.getValueAt(row, 0);
        Organizer o = OrganizerManager.getOrganizerByID(id);
        if (o == null) return;

        PersonFormHelper form = new PersonFormHelper(
            o.getName(), o.getEmail(), o.getPhoneNumber(),
            o.getAddress(), o.getBiography(),
            o.getOrganization(), o.getJobTitle()
        );

        int result = JOptionPane.showConfirmDialog(
            this,
            form.getFields(),
            "Edit Organizer",
            JOptionPane.OK_CANCEL_OPTION
        );

        if (result == JOptionPane.OK_OPTION) {

            o.setName(form.nameF.getText().trim());
            o.setEmail(form.emailF.getText().trim());
            o.setPhoneNumber(form.phoneF.getText().trim());
            o.setAddress(form.addressF.getText().trim());
            o.setBiography(form.bioF.getText().trim());
            o.setOrganization(form.orgF.getText().trim());
            o.setJobTitle(form.jobF.getText().trim());

            refreshTable();
        }
    }

    // DELETE
    @Override
    protected void doDelete() {

        int row = getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "Select an organizer.");
            return;
        }

        int id = (int) tableModel.getValueAt(row, 0);

        int confirm = JOptionPane.showConfirmDialog(
            this,
            "Delete organizer ID " + id + "?",
            "Confirm",
            JOptionPane.YES_NO_OPTION
        );

        if (confirm == JOptionPane.YES_OPTION) {
            Organizer o = OrganizerManager.getOrganizerByID(id);
            if (o != null) {
                OrganizerManager.getAll().remove(o);
            }
            refreshTable();
        }
    }
}