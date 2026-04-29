/**
 * @author Jillian Stork
 * CSCI 2210 Project
 * Conference Management System
 * Base Panel Class
 * This class is the base for other panel classes 
 */


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public abstract class BasePanel extends JPanel {

    protected DefaultTableModel tableModel;
    protected JTable table;

    public BasePanel(String[] columns) {
        tableModel = new DefaultTableModel(columns, 0);
        table = new JTable(tableModel);

        setLayout(new BorderLayout());

        // Table
        add(new JScrollPane(table), BorderLayout.CENTER);

        // Buttons
        JButton addBtn = new JButton("Add");
        JButton editBtn = new JButton("Edit");
        JButton deleteBtn = new JButton("Delete");

        JPanel bottom = new JPanel();
        bottom.add(addBtn);
        bottom.add(editBtn);
        bottom.add(deleteBtn);

        add(bottom, BorderLayout.SOUTH);

        // Button actions
        addBtn.addActionListener(e -> {
            doAdd();
            refreshTable();
        });

        editBtn.addActionListener(e -> {
            doEdit();
            refreshTable();
        });

        deleteBtn.addActionListener(e -> {
            doDelete();
            refreshTable();
        });

        //auto-load data
        refreshTable();
    }

    protected abstract void refreshTable();
    protected abstract void doSearch(String q);
    protected abstract void doAdd();
    protected abstract void doEdit();
    protected abstract void doDelete();

    protected int getSelectedRow() {
        return table.getSelectedRow();
    }
}