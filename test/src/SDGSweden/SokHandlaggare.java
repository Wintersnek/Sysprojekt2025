/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package SDGSweden;

import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.table.DefaultTableModel;
import oru.inf.InfDB;
import oru.inf.InfException;

/**
 *
 * @author lukas
 */
public class SokHandlaggare extends javax.swing.JFrame {
    
 private InfDB idb;
    private String aid;
    
    /**
     * Creates new form SokHandlaggare
     */
    public SokHandlaggare(InfDB idb, String aid) {
        this.idb = idb;
        this.aid = aid;
        initComponents();
    }
private void sokHandlaggare() {
        try {
       String sokterm = txtSok.getText(); // fritext från fält
        // Hämta avdelning som användaren tillhör
        String avdID = idb.fetchSingle("SELECT avdid FROM anstalld WHERE aid = '" + aid + "'");

        String fraga = "SELECT aid, fornamn, efternamn, epost FROM anstalld " +
            "WHERE avdid = '" + avdID + "' AND " +
            "(LOWER(fornamn) LIKE LOWER('%" + sokterm + "%') " +
            "OR LOWER(efternamn) LIKE LOWER('%" + sokterm + "%') " +
            "OR LOWER(epost) LIKE LOWER('%" + sokterm + "%'))";

        ArrayList<HashMap<String, String>> resultat = idb.fetchRows(fraga);

        DefaultTableModel modell = (DefaultTableModel) tblResultat.getModel();
        modell.setRowCount(0);

            if (resultat != null) {
                for (HashMap<String, String> rad : resultat) {
                    String id = rad.get("AID");
                    String fnamn = rad.get("FORNAMN");
                    String enamn = rad.get("EFTERNAMN");
                    String epost = rad.get("EPOST");

                    modell.addRow(new Object[]{id, fnamn, enamn, epost});
                }
            }

        } catch (InfException e) {
            System.err.println("Fel vid sökning: " + e.getMessage());
        }
    }

    // Lägg till anrop i din sökknapp med tex: btnSok.addActionListener(e -> sokHandlaggare());
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtSok = new javax.swing.JTextField();
        btnSok = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblResultat = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Sök handläggare:\t");

        txtSok.setText("jTextField1");
        txtSok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSokActionPerformed(evt);
            }
        });

        btnSok.setText("Sök");
        btnSok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSokActionPerformed(evt);
            }
        });

        tblResultat.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "AID", "Förnamn", "Efternamn  ", "E-post  "
            }
        ));
        jScrollPane1.setViewportView(tblResultat);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(156, 156, 156)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(23, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addComponent(txtSok, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSok)
                .addGap(92, 92, 92))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 127, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSok))
                        .addGap(63, 63, 63))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtSokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSokActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSokActionPerformed

    private void btnSokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSokActionPerformed
    sokHandlaggare();
    }//GEN-LAST:event_btnSokActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSok;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblResultat;
    private javax.swing.JTextField txtSok;
    // End of variables declaration//GEN-END:variables
}
