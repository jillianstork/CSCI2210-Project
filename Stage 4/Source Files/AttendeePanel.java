package CSCI2210_Project_Stage4;

/**
 * @author Jillian Stork
 * CSCI 2210 Project
 * Conference Management System
 * AttendeePanel Class
 * This is the class for the attendee GUI
 */

import javax.swing.*;

public class AttendeePanel extends BasePanel {

    public AttendeePanel() {
        super(new String[]{"ID","Name","Email","Phone","Org","Job"});
    }

    //read
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
    protected void doSearch() {

        if (AttendeeManager.getAll().isEmpty()) {
            JOptionPane.showMessageDialog(
                this,
                "There are no attendees to search for.",
                "No Attendees in Catalog",
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
            "Search Attendees",
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
                "Please enter an attendee feature to search by.",
                "Invalid Search",
                JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        tableModel.setRowCount(0);

        for (Attendee x : AttendeeManager.getAll()) {
            boolean matchesGeneral = x.getName().toLowerCase().contains(s)
                || x.getEmail().toLowerCase().contains(s)
                || x.getOrganization().toLowerCase().contains(s);

            boolean matchesId = (id == null || x.getAttendeeID() == id);

            if (matchesGeneral && matchesId) {
                tableModel.addRow(new Object[]{
                    x.getAttendeeID(),
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
                "No attendees matched your search.",
                "No Results",
                JOptionPane.INFORMATION_MESSAGE
            );
        }
    }

    //create
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

            DataPersistence.saveAll();
            refreshTable();
        }
    }

    //update
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

            DataPersistence.saveAll();
            refreshTable();
        }
    }

    //delete
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
            DataPersistence.saveAll();
            refreshTable();
        }
    }
}
