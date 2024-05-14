package com.raven.swing;

import com.raven.model.StatusType;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class Table extends JTable {

    public Table() {
        setOpaque(false); 
        setBackground(new Color(24, 28, 53));
        setShowHorizontalLines(true);
        setGridColor(Color.WHITE);
        setRowHeight(40);
        getTableHeader().setReorderingAllowed(false);
        getTableHeader().setDefaultRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable jtable, Object o, boolean bln, boolean bln1, int i, int i1) {
                TableHeader header = new TableHeader(o + "");
                header.setBackground(new Color(84, 84, 105)); // Header arka plan rengi
                header.setForeground(Color.WHITE); // Header metin rengi
                if (i1 == 4) {
                    header.setHorizontalAlignment(JLabel.CENTER);
                }
                return header;
            }
        });
        setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable jtable, Object o, boolean selected, boolean bln1, int i, int i1) {
                if (i1 != 4) {
                    Component com = super.getTableCellRendererComponent(jtable, o, selected, bln1, i, i1);
                    if (selected) {
                        com.setForeground(Color.WHITE);
                        com.setBackground(new Color(0, 120, 215)); // Seçili satır rengi
                    } else {
                        com.setForeground(Color.WHITE);
                        com.setBackground(new Color(24, 28, 53)); // Normal satır rengi
                    }
                    setBorder(noFocusBorder);
                    return com;
                } else {
                    StatusType type = (StatusType) o;
                    CellStatus cell = new CellStatus(type);
                    if (selected) {
                        cell.setBackground(new Color(0, 120, 215)); // Seçili satır rengi (StatusType sütunu)
                    } else {
                        cell.setBackground(new Color(24, 28, 53)); // Normal satır rengi (StatusType sütunu)
                    }
                    return cell;
                }
            }
        });
    }

    public void addRow(Object[] row) {
        DefaultTableModel model = (DefaultTableModel) getModel();
        model.addRow(row);
    }
}
