package SDGSweden;

import oru.inf.InfDB;
import oru.inf.InfException;
import java.util.HashMap;
import javax.swing.JOptionPane;

public class AnvandarInformation extends javax.swing.JFrame {
private String aid;
private InfDB idb;
private Validering validering;
    /**
     * Creates new form AI
     */
    public AnvandarInformation (InfDB idb, String aid) {
        initComponents();
        this.idb = idb; 
        this.aid = aid;
        this.validering = new Validering(idb);
        fetchAndDisplayUserInfo();
        initComponents();
    }
    
private void fetchAndDisplayUserInfo() {
    try {
            String sqlFraga = "SELECT fornamn, efternamn, adress, epost, telefon, anstallningsdatum, avdelning " + "FROM anstalld WHERE aid = '" + aid + "'";
        
        HashMap<String, String> user = idb.fetchRow(sqlFraga);
        
        if (user != null) {
            txtfornamn.setText(user.get("fornamn"));
            txtefternamn.setText(user.get("efternamn"));
            txtadress.setText(user.get("adress"));
            txtemail.setText(user.get("epost"));
            txttelefon.setText(user.get("telefon"));
            txtanstallningsdatum.setText(user.get("anstallningsdatum"));
            txtavdelning.setText(user.get("avdelning"));
            
            JOptionPane.showMessageDialog(null, user.get("anstallningsdatum"));
        }
        
    } catch (Exception e) {
        javax.swing.JOptionPane.showMessageDialog(this, "Fel vid hämtning av användardata.");
    }
}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        tillbaka = new javax.swing.JButton();
        spara = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtfornamn = new javax.swing.JTextField();
        txtefternamn = new javax.swing.JTextField();
        txtadress = new javax.swing.JTextField();
        txtemail = new javax.swing.JTextField();
        txttelefon = new javax.swing.JTextField();
        txtanstallningsdatum = new javax.swing.JTextField();
        txtavdelning = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("AnvändarInformation");

        tillbaka.setText("Tillbaka");
        tillbaka.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tillbakaActionPerformed(evt);
            }
        });

        spara.setText("Spara");
        spara.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sparaActionPerformed(evt);
            }
        });

        jLabel2.setText("Förnamn");

        jLabel3.setText("Efternamn");

        jLabel4.setText("Adress");

        jLabel5.setText("Email");

        jLabel6.setText("Telefon");

        jLabel7.setText("Anställningsdatum");

        jLabel8.setText("Avdelning");

        txtavdelning.setToolTipText("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(133, 133, 133)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                                    .addComponent(txtfornamn, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel5)
                                        .addComponent(jLabel6))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txttelefon, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                                        .addComponent(txtemail)
                                        .addComponent(txtadress))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(52, 52, 52)
                                .addComponent(txtefternamn, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8))
                                .addGap(32, 32, 32)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtavdelning, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                    .addComponent(txtanstallningsdatum))))))
                .addContainerGap(136, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(spara)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tillbaka)
                .addGap(14, 14, 14))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtfornamn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtefternamn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtadress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(txttelefon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtanstallningsdatum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtavdelning, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tillbaka)
                    .addComponent(spara))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void sparaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sparaActionPerformed
    try {
            
        if (!Validering.textFaltHarVarde(txtfornamn) || !Validering.textFaltHarVarde(txtefternamn) || !Validering.textFaltHarVarde(txtadress) || !Validering.textFaltHarVarde(txtemail) ||
                !Validering.textFaltHarVarde(txttelefon) || !Validering.textFaltHarVarde(txtanstallningsdatum) || !Validering.textFaltHarVarde(txtavdelning)) {
                return; 
            }  //FEL I VALIDERINGEN//
        
        String datumInput = txtanstallningsdatum.getText();
            if (!Validering.datumArGiltigt(datumInput)) {
                JOptionPane.showMessageDialog(null, "Felaktigt datumformat");
                return;
            }
            
            String sql = "UPDATE anstalld SET " +
            "fornamn = '" + txtfornamn.getText() + "', " +
            "efternamn = '" + txtefternamn.getText() + "', " +
            "adress = '" + txtadress.getText() + "', " +
            "epost = '" + txtemail.getText() + "', " +
            "telefon = '" + txttelefon.getText() + "', " +
            "anstallningsdatum = '" + txtanstallningsdatum.getText() + "', " +
            "avdelning = '" + txtavdelning.getText() + "' " +
            "WHERE aid = '" + aid + "'";
            
            idb.update(sql);
            
            javax.swing.JOptionPane.showMessageDialog(null, "Informationen har sparats!");

        } catch (InfException e){
            javax.swing.JOptionPane.showMessageDialog(null, "Fel vid uppdatering: " + e.getMessage());
        }   
                              

         // TODO add your handling code here:
    }//GEN-LAST:event_sparaActionPerformed

    private void tillbakaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tillbakaActionPerformed
      this.setVisible(false);
    }//GEN-LAST:event_tillbakaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JButton spara;
    private javax.swing.JButton tillbaka;
    private javax.swing.JTextField txtadress;
    private javax.swing.JTextField txtanstallningsdatum;
    private javax.swing.JTextField txtavdelning;
    private javax.swing.JTextField txtefternamn;
    private javax.swing.JTextField txtemail;
    private javax.swing.JTextField txtfornamn;
    private javax.swing.JTextField txttelefon;
    // End of variables declaration//GEN-END:variables
}
