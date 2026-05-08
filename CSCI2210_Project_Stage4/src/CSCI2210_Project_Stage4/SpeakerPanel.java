package CSCI2210_Project_Stage4;

/**
 * @author Jillian Stork
 * CSCI 2210 Project
 * Conference Management System
 * Speaker Panel Class
 * This is the class for the speaker GUI
 */
import javax.swing.*;

public class SpeakerPanel extends BasePanel {

    public SpeakerPanel() {
        super(new String[]{"ID","Name","Email","Phone","Organization","Job Title"});
    }

    // READ
    @Override
    protected void refreshTable() {
        tableModel.setRowCount(0);

        for (Speaker s : SpeakerManager.getAll()) {
            tableModel.addRow(new Object[]{
                s.getSpeakerID(),
                s.getName(),
                s.getEmail(),
                s.getPhoneNumber(),
                s.getOrganization(),
                s.getJobTitle()
            });
        }
    }

    // SEARCH
    @Override
    protected void doSearch() {
        
        if(SpeakerManager.getAll().isEmpty()) {
            JOptionPane.showMessageDialog(
                this,
                "There are no speakers to search for.",
                "No Speakers in Catalog",
                JOptionPane.WARNING_MESSAGE
            );
            return;
        }
        
        JTextField generalSearchF = new JTextField();
        JTextField idSearchF = new JTextField();
        
        int res = JOptionPane.showConfirmDialog(
            this,
            new Object[] {
                "General Search:", generalSearchF,
                "Search by ID:", idSearchF
            },
            "Search Speakers",
            JOptionPane.OK_CANCEL_OPTION
        );
        
        if (res != JOptionPane.OK_OPTION) {
            return;
        }
        
        tableModel.setRowCount(0);
        
        String s = generalSearchF.getText().trim().toLowerCase();
        
        String idResult = idSearchF.getText().trim();
        Integer id = null;
        try {
            if (!idResult.isEmpty()) {
                id = Integer.valueOf(idResult);
            }
        }
        catch (NumberFormatException e) {
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
                "Please enter a speaker feature to search by.",
                "Invalid Search",
                JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        for (Speaker x : SpeakerManager.getAll()) {
            
            boolean matchesGeneral = x.getName().toLowerCase().contains(s)
                || x.getEmail().toLowerCase().contains(s)
                || x.getOrganization().toLowerCase().contains(s);
            
            boolean matchesId = (id == null || x.getSpeakerID() == id);
            
            if (matchesGeneral && matchesId) {
                tableModel.addRow(new Object[]{
                    x.getSpeakerID(),
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
                "No speakers matched your search.",
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
            "Add Speaker",
            JOptionPane.OK_CANCEL_OPTION
        );

        if (result == JOptionPane.OK_OPTION) {

            if (form.nameF.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Name required.");
                return;
            }

            SpeakerManager.addSpeaker(
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
            JOptionPane.showMessageDialog(this, "Select a speaker.");
            return;
        }

        int id = (int) tableModel.getValueAt(row, 0);
        Speaker s = SpeakerManager.getSpeakerByID(id);
        if (s == null) return;

        PersonFormHelper form = new PersonFormHelper(
            s.getName(), s.getEmail(), s.getPhoneNumber(),
            s.getAddress(), s.getBiography(),
            s.getOrganization(), s.getJobTitle()
        );

        int result = JOptionPane.showConfirmDialog(
            this,
            form.getFields(),
            "Edit Speaker",
            JOptionPane.OK_CANCEL_OPTION
        );

        if (result == JOptionPane.OK_OPTION) {

            s.setName(form.nameF.getText().trim());
            s.setEmail(form.emailF.getText().trim());
            s.setPhoneNumber(form.phoneF.getText().trim());
            s.setAddress(form.addressF.getText().trim());
            s.setBiography(form.bioF.getText().trim());
            s.setOrganization(form.orgF.getText().trim());
            s.setJobTitle(form.jobF.getText().trim());

            refreshTable();
        }
    }

    // DELETE
    @Override
    protected void doDelete() {

        int row = getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "Select a speaker.");
            return;
        }

        int id = (int) tableModel.getValueAt(row, 0);

        int confirm = JOptionPane.showConfirmDialog(
            this,
            "Delete speaker ID " + id + "?",
            "Confirm",
            JOptionPane.YES_NO_OPTION
        );

        if (confirm == JOptionPane.YES_OPTION) {
            Speaker s = SpeakerManager.getSpeakerByID(id);
            if (s != null) {
                SpeakerManager.getAll().remove(s);
            }
            refreshTable();
        }
    }
}