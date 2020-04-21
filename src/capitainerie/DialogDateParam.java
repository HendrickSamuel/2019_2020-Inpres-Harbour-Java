/******************************************************/
/*Auteur: Hendrick Samuel & Khamana Benedict          */
/*Groupe: 2203                                        */
/*Application: Inpres Harbour                         */
/*Date de creation:13/04/2020                         */
/******************************************************/

package capitainerie;

import HarbourGlobal.DialogResult;
import java.text.DateFormat;
import java.util.Locale;
import javax.swing.DefaultComboBoxModel;

public class DialogDateParam extends javax.swing.JDialog {
    
    private DialogResult _result = DialogResult.untouched;
    
    private Locale _fuseauPays;
    private int _formatDate;
    private int _formatHeure;

    public DialogDateParam(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        InitCombos();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        ComboLocations = new javax.swing.JComboBox<>();
        ComboDate = new javax.swing.JComboBox<>();
        ComboHeure = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        ApplyButton = new javax.swing.JButton();
        Cancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Date options");

        ComboLocations.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "France", "Royaume-Uni", "Allemagne", "Italie", "U.S.A" }));

        ComboDate.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "date", "date", "date", "date", "date" }));

        ComboHeure.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "time", "time", "time", "time", "time" }));

        jLabel1.setText("Location: ");

        jLabel2.setText("Date format:");

        jLabel3.setText("Time format:");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel4.setText("Format Date");

        ApplyButton.setText("Appliquer");
        ApplyButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                ApplyButtonActionPerformed(evt);
            }
        });

        Cancel.setText("Annuler");
        Cancel.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                CancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ComboDate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ComboLocations, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ComboHeure, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(78, 78, 78))
            .addGroup(layout.createSequentialGroup()
                .addGap(142, 142, 142)
                .addComponent(ApplyButton)
                .addGap(95, 95, 95)
                .addComponent(Cancel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel4)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ComboLocations, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ComboDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(ComboHeure, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ApplyButton)
                    .addComponent(Cancel))
                .addGap(46, 46, 46))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ApplyButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_ApplyButtonActionPerformed
    {//GEN-HEADEREND:event_ApplyButtonActionPerformed
         switch(ComboLocations.getSelectedItem().toString())
        {
            case "France" :
                _fuseauPays = Locale.FRANCE;
                break;
            case "Royaume Uni" :
                _fuseauPays = Locale.UK;
                break;
            case "Allemagne" :
                _fuseauPays = Locale.GERMAN;
                break;
            case "Italie" :
                _fuseauPays = Locale.ITALY;
                break;
            case "U.S.A.":
                _fuseauPays = Locale.US;
                break;
        }

        switch(ComboDate.getSelectedItem().toString())
        {
            case "jj/mm/yy" :
                _formatDate = DateFormat.SHORT;
                break;
            case "jj mm yyyy":
                _formatDate = DateFormat.MEDIUM;
                break;
            case "jj mois yyyy" :
                _formatDate = DateFormat.LONG;
                break;
            case "jour jj mois yyyy" :
                _formatDate = DateFormat.FULL;
                break;
        }

        switch(ComboHeure.getSelectedItem().toString())
        {
            case "hh:mm" :
                _formatHeure = DateFormat.SHORT;
                break;
            case "hh:mm:ss" :
                _formatHeure = DateFormat.MEDIUM;
                break;
            case "hh:mm:ss fuseau" :
                _formatHeure = DateFormat.LONG;
                break;
            case "hh H mm fuseau" :
                _formatHeure = DateFormat.FULL;
                break;  
        }
        
        _result = DialogResult.ok;
        this.setVisible(false);
    }//GEN-LAST:event_ApplyButtonActionPerformed

    private void CancelActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_CancelActionPerformed
    {//GEN-HEADEREND:event_CancelActionPerformed
        _result = DialogResult.cancel;
        this.setVisible(false);
    }//GEN-LAST:event_CancelActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DialogDateParam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DialogDateParam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DialogDateParam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DialogDateParam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DialogDateParam dialog = new DialogDateParam(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ApplyButton;
    private javax.swing.JButton Cancel;
    private javax.swing.JComboBox<String> ComboDate;
    private javax.swing.JComboBox<String> ComboHeure;
    private javax.swing.JComboBox<String> ComboLocations;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables

    private void InitCombos()
    {
         DefaultComboBoxModel dcbmPays = (DefaultComboBoxModel) this.ComboLocations.getModel();
        dcbmPays.removeAllElements();
        dcbmPays.addElement("France");
        dcbmPays.addElement("Royaume Uni");
        dcbmPays.addElement("Allemagne");
        dcbmPays.addElement("Italie");
        dcbmPays.addElement("U.S.A.");
       
        //Construction de la comboBox FormatDate
        DefaultComboBoxModel dcbmDate = (DefaultComboBoxModel) this.ComboDate.getModel();
        dcbmDate.removeAllElements();
        dcbmDate.addElement("jj/mm/yy");
        dcbmDate.addElement("jj mm yyyy");
        dcbmDate.addElement("jj mois yyyy");
        dcbmDate.addElement("jour jj mois yyyy");
       
        //Construction de la comboBox FormatHeure
        DefaultComboBoxModel dcbmHeure = (DefaultComboBoxModel) this.ComboHeure.getModel();
        dcbmHeure.removeAllElements();
        dcbmHeure.addElement("hh:mm");
        dcbmHeure.addElement("hh:mm:ss");
        dcbmHeure.addElement("hh:mm:ss fuseau");
        dcbmHeure.addElement("hh H mm fuseau");
    }
    
    public DialogResult getResult()
    {
        return _result;
    }

    public
            Locale getFuseauPays()
    {
        return _fuseauPays;
    }

    public
            int getFormatDate()
    {
        return _formatDate;
    }

    public
            int getFormatHeure()
    {
        return _formatHeure;
    }
    
}
