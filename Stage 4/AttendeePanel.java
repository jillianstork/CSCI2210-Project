/**
 * @author Jillian Stork
 * CSCI 2210 Project
 * Conference Management System
 * attendee Panel Class
 * This is the class for the attendee GUI
 */

import javax.swing.*;

public class AttendeePanel extends BasePanel {

    public AttendeePanel() {
        super(new String[]{"ID","Name","Email","Phone","Org","Job"});
    }

    // READ
    @Override
    protected void refreshTable() {
        tableModel.setRowCount(0);

        for (Attendee a : AttendeeManager.getAll()) {
            tableModel.addRow(new Object[]{
                a.getAttendeeID(),
                a.getName(),
                a.getEmail(),
                a.getPhoneNumber(),
                a.getOrganization(),
                a.getJobTitle()
            });
        }
    }

    // SEARCH
    @Override
    protected void doSearch(String q) {
        tableModel.setRowCount(0);

        for (Attendee a : AttendeeManager.getAll()) {
            if (String.valueOf(a.getAttendeeID()).contains(q)
                || a.getName().toLowerCase().contains(q)
                || a.getEmail().toLowerCase().contains(q)
                || a.getOrganization().toLowerCase().contains(q)) {

                tableModel.addRow(new Object[]{
                    a.getAttendeeID(),
                    a.getName(),
                    a.getEmail(),
                    a.getPhoneNumber(),
                    a.getOrganization(),
                    a.getJobTitle()
                });
            }
        }
    }

    // CREATE (FIXED)
    @Override
    protected void doAdd() {

        PersonFormHelper form = new PersonFormHelper();

        int result = JOptionPane.showConfirmDialog(
            this,
            form.getFields(),
            "Add Attendee",
            JOptionPane.OK_CANCEL_OPTION
        );

        if (result == JOptionPane.OK_OPTION) {

            if (form.nameF.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Name is required.");
                return;
            }

            AttendeeManager.addAttendee(
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
            JOptionPane.showMessageDialog(this, "Select an attendee.");
            return;
        }

        int id = (int) tableModel.getValueAt(row, 0);
        Attendee a = AttendeeManager.getAttendeeByID(id);
        if (a == null) return;

        PersonFormHelper form = new PersonFormHelper(
            a.getName(), a.getEmail(), a.getPhoneNumber(),
            a.getAddress(), a.getBiography(),
            a.getOrganization(), a.getJobTitle()
        );

        int result = JOptionPane.showConfirmDialog(
            this,
            form.getFields(),
            "Edit Attendee",
            JOptionPane.OK_CANCEL_OPTION
        );

        if (result == JOptionPane.OK_OPTION) {

            a.setName(form.nameF.getText().trim());
            a.setEmail(form.emailF.getText().trim());
            a.setPhoneNumber(form.phoneF.getText().trim());
            a.setAddress(form.addressF.getText().trim());
            a.setBiography(form.bioF.getText().trim());
            a.setOrganization(form.orgF.getText().trim());
            a.setJobTitle(form.jobF.getText().trim());

            refreshTable();
        }
    }

    // DELETE
    @Override
    protected void doDelete() {

        int row = getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "Select an attendee.");
            return;
        }

        int id = (int) tableModel.getValueAt(row, 0);

        int confirm = JOptionPane.showConfirmDialog(
            this,
            "Delete attendee ID " + id + "?",
            "Confirm",
            JOptionPane.YES_NO_OPTION
        );

        if (confirm == JOptionPane.YES_OPTION) {
            Attendee a = AttendeeManager.getAttendeeByID(id);
            if (a != null) {
                AttendeeManager.getAll().remove(a);
            }
            refreshTable();
        }
    }
}