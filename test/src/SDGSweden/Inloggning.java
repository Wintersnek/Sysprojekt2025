package SDGSweden;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
import oru.inf.InfDB;
import oru.inf.InfException;

public class Inloggning extends javax.swing.JFrame {
   
    
    private InfDB idb;
    private String aid;
    private Validering validering;

    /**
     * Creates new form MittFönster
     */
    public Inloggning(InfDB idb) {
        this.idb = idb;
        this.validering = new Validering(idb);
        initComponents();

        jBtLogin.addActionListener(evt -> {
            String epost = jTextEpost.getText().trim();
            String losenord = jTextLosenord.getText().trim();

            if (!Validering.textFaltHarVarde(jTextEpost) || !Validering.textFaltHarVarde(jTextLosenord)) {
                return;
            }

            try {
                String sqlAid = "SELECT aid FROM anstalld WHERE epost = '" + epost + "' AND losenord = '" + losenord + "'";
                String aid = idb.fetchSingle(sqlAid);
                
                if (aid != null){      
                String roll = validering.hamtaRoll(idb, aid);
                    
                    javax.swing.JOptionPane.showMessageDialog(null, "aid: " + aid + "roll: " + roll);
                    new Meny(idb, aid).setVisible(true);
                    this.setVisible(false);
                }
                else {
                    javax.swing.JOptionPane.showMessageDialog(null, "Fel e-post eller lösenord!");
                }

            } catch (InfException ex) {
                javax.swing.JOptionPane.showMessageDialog(this, "Fel vid databasanslutning:" + ex.getMessage());
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabelEpost = new javax.swing.JLabel();
        jLabelLosenord = new javax.swing.JLabel();
        jTextEpost = new javax.swing.JTextField();
        jTextLosenord = new javax.swing.JTextField();
        jBtLogin = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabelEpost.setText("E-Post:");

        jLabelLosenord.setText("Lösenord:");

        jBtLogin.setText("Logga In");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jBtLogin)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelLosenord)
                            .addComponent(jLabelEpost))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextEpost, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextLosenord, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(210, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(115, 115, 115)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelEpost)
                    .addComponent(jTextEpost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelLosenord)
                    .addComponent(jTextLosenord, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jBtLogin)
                .addContainerGap(172, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtLogin;
    private javax.swing.JLabel jLabelEpost;
    private javax.swing.JLabel jLabelLosenord;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextEpost;
    private javax.swing.JTextField jTextLosenord;
    // End of variables declaration//GEN-END:variables
}
