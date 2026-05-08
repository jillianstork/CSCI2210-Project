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

        // Search bar across the top
        JTextField searchField = new JTextField();
        JButton searchBtn = new JButton("Search");
        JButton clearBtn = new JButton("Clear");

        JPanel top = new JPanel(new BorderLayout());
        top.add(new JLabel("Search: "), BorderLayout.WEST);
        top.add(searchField, BorderLayout.CENTER);

        JPanel searchButtons = new JPanel();
        searchButtons.add(searchBtn);
        searchButtons.add(clearBtn);
        top.add(searchButtons, BorderLayout.EAST);

        add(top, BorderLayout.NORTH);

        // CRUD buttons across the bottom
        JButton addBtn = new JButton("Add");
        JButton editBtn = new JButton("Edit");
        JButton deleteBtn = new JButton("Delete");

        JPanel bottom = new JPanel();
        bottom.add(addBtn);
        bottom.add(editBtn);
        bottom.add(deleteBtn);
        add(bottom, BorderLayout.SOUTH);

        // Button actions
        searchBtn.addActionListener(e -> {
            doSearch(searchField.getText().trim().toLowerCase());
        });

        clearBtn.addActionListener(e -> {
            searchField.setText("");
            refreshTable();
        });

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

        // auto-load data
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