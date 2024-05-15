package com.raven.form;

import com.raven.model.Model_Card;
import com.raven.model.Currency;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.ImageIcon;
import com.raven.component.Text_Field;
import javax.swing.JFrame;
import com.deu.utils.ApiServices;
import com.deu.utils.CSVFileHandler;
import static com.deu.utils.WalletReader.readCryptoWalletsFromCSV;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Form_Home extends javax.swing.JPanel {

    Text_Field frameText;

    public Form_Home() {

        initComponents();
        frameText = new Text_Field();
        ApiServices apiService = new ApiServices();
        card1.setData(new Model_Card(new ImageIcon("src/main/java/com.raven.icon/bitcoin.png"), "Bitcoin", "$" + apiService.getData("BTC"), "BTC", "0.25%"));
        card2.setData(new Model_Card(new ImageIcon("src/main/java/com.raven.icon/litecoin.png"), "Cardano", "$" + apiService.getData("BTC"), "ADA", "0.25%"));
        card3.setData(new Model_Card(new ImageIcon("src/main/java/com.raven.icon/eth2.png"), "Ethereum", "$" + apiService.getData("BTC"), "ETH", "0.25%"));
        card4.setData(new Model_Card(new ImageIcon("src/main/java/com.raven.icon/solona.png"), "Solana", "$" + apiService.getData("BTC"), "SOL", "-0.25%"));

        List<Currency> Currency = readCryptoWalletsFromCSV("src/main/java/Wallet.csv");
        for (Currency currency : Currency) {
            table.addRow(new Object[]{currency.getName(), currency.getAmount(), Double.toString(currency.getCurrentPrice()) + "$", Double.toString(currency.getTotalValue()) + "$"});

        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JLayeredPane();
        card1 = new com.raven.component.Card();
        card2 = new com.raven.component.Card();
        card3 = new com.raven.component.Card();
        card4 = new com.raven.component.Card();
        panelBorder1 = new com.team.portfoliotracker.PanelBorder();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new com.raven.swing.Table();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        panel.setBackground(new java.awt.Color(27, 32, 40));
        panel.setForeground(new java.awt.Color(49, 53, 63));

        card1.setForeground(new java.awt.Color(27, 32, 40));

        card2.setForeground(new java.awt.Color(27, 32, 40));

        card3.setForeground(new java.awt.Color(27, 32, 40));

        card4.setForeground(new java.awt.Color(27, 32, 40));

        panel.setLayer(card1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panel.setLayer(card2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panel.setLayer(card3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panel.setLayer(card4, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(card1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(card2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(card3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(card4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(card4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(card3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(card2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(card1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Kefa", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("My Wallet");

        jScrollPane1.setBorder(null);

        table.setBackground(new java.awt.Color(0, 0, 0));
        table.setForeground(new java.awt.Color(255, 255, 255));
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "My Cryptos", "Amount", "Price", "Total Value"
            }
        ));
        jScrollPane1.setViewportView(table);

        jButton1.setBackground(new java.awt.Color(24, 29, 51));
        jButton1.setForeground(new java.awt.Color(107, 127, 249));
        jButton1.setText("Add Currency");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(24, 29, 51));
        jButton2.setForeground(new java.awt.Color(107, 127, 249));
        jButton2.setText("Delete");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addGap(32, 32, 32)
                .addComponent(jButton2)
                .addContainerGap())
            .addComponent(jScrollPane1)
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

        frameText.setVisible(true);
        frameText.pack();
        frameText.setLocationRelativeTo(null);
        frameText.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        DefaultTableModel tblModel = (DefaultTableModel) table.getModel();

        if (table.getSelectedRowCount() == 1) {
            int a = JOptionPane.showConfirmDialog(this, "Are you sure?");
            if (a == JOptionPane.YES_OPTION) {
                int selectedRow = table.getSelectedRow();
                String currency = (String) tblModel.getValueAt(selectedRow, 0);

                tblModel.removeRow(selectedRow);

                try {
                    CSVFileHandler.removeCurrencyFromCSV("src/main/java/Wallet.csv", currency);
                } catch (IOException ex) {
                    Logger.getLogger(Form_Home.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            

        } else {
            if (table.getRowCount() == 0) {
                JOptionPane.showMessageDialog(this, "Table is empty.");
            } else {
                JOptionPane.showMessageDialog(this, "Please select a row.");
            }

        }

    }//GEN-LAST:event_jButton2ActionPerformed

    public static void AddRowToJTable(Object[] data) {
        table.addRow(data);
    }

    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
        g2.setColor(new Color(0xff31353F));
        super.paintComponent(grphcs);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.raven.component.Card card1;
    private com.raven.component.Card card2;
    private com.raven.component.Card card3;
    private com.raven.component.Card card4;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLayeredPane panel;
    private com.team.portfoliotracker.PanelBorder panelBorder1;
    private static com.raven.swing.Table table;
    // End of variables declaration//GEN-END:variables
}
