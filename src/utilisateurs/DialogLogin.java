/******************************************************/
/*Auteur: Hendrick Samuel & Khamana Benedict          */
/*Groupe: 2203                                        */
/*Application: Inpres Harbour                         */
/*Date de creation: 25/03/2020                        */
/******************************************************/

package utilisateurs;

import HarbourGlobal.DialogResult;

public class DialogLogin extends javax.swing.JDialog {

    private DialogResult _result = DialogResult.untouched;
    private String _connectedUserName;
    
    public DialogLogin(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        ErrorLabel.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        PageTitle = new javax.swing.JLabel();
        UserLabel = new javax.swing.JLabel();
        PwdLabel = new javax.swing.JLabel();
        UserInput = new javax.swing.JTextField();
        PwdInput = new javax.swing.JTextField();
        OkButton = new javax.swing.JButton();
        CancelButton = new javax.swing.JButton();
        ErrorLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Login Capitainerie");

        PageTitle.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        PageTitle.setText("Bienvenue !");

        UserLabel.setText("Nom d'utilisateur: ");

        PwdLabel.setText("Mot de passe");

        OkButton.setText("Valider");
        OkButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                OkButtonActionPerformed(evt);
            }
        });

        CancelButton.setText("Annuler");
        CancelButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                CancelButtonActionPerformed(evt);
            }
        });

        ErrorLabel.setForeground(new java.awt.Color(255, 0, 51));
        ErrorLabel.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(ErrorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(UserLabel)
                            .addComponent(PwdLabel))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(UserInput)
                            .addComponent(PwdInput, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(97, 97, 97)
                            .addComponent(PageTitle))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGap(116, 116, 116)
                            .addComponent(OkButton)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(CancelButton))))
                .addContainerGap(105, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(PageTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(UserLabel)
                    .addComponent(UserInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PwdLabel)
                    .addComponent(PwdInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(ErrorLabel)
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(OkButton)
                    .addComponent(CancelButton))
                .addGap(46, 46, 46))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void OkButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OkButtonActionPerformed
        String user = UserInput.getText();
        String mdp = PwdInput.getText();
        ErrorLabel.setVisible(false);
        
        if(user.length() > 0 && mdp.length() > 0)
        {
            VerificateurMotDePasse vmdp = new VerificateurMotDePasse();
            if(vmdp.DoesUserExist(user))
            {
                try 
                {
                    vmdp.TryLogin(user, mdp);
                    setResult(DialogResult.ok);
                    this.setConnectedUserName(UserInput.getText());
                    this.setVisible(false);
                } 
                catch (LoginException ex) 
                {
                    DialogErreur dlg = new DialogErreur((java.awt.Frame)getParent(), true);
                    dlg.setVisible(true);
                }
            }
            else
            {
                ErrorLabel.setText(user+" n'existe pas");
                ErrorLabel.setVisible(true);
            }
        }
        else
        {
            ErrorLabel.setText("veillez à completer tous les champs");
            ErrorLabel.setVisible(true);
        }
    }//GEN-LAST:event_OkButtonActionPerformed

    private void CancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelButtonActionPerformed
        setResult(DialogResult.cancel);
            this.setVisible(false);
    }//GEN-LAST:event_CancelButtonActionPerformed

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
            java.util.logging.Logger.getLogger(DialogLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DialogLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DialogLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DialogLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DialogLogin dialog = new DialogLogin(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton CancelButton;
    private javax.swing.JLabel ErrorLabel;
    private javax.swing.JButton OkButton;
    private javax.swing.JLabel PageTitle;
    private javax.swing.JTextField PwdInput;
    private javax.swing.JLabel PwdLabel;
    private javax.swing.JTextField UserInput;
    private javax.swing.JLabel UserLabel;
    // End of variables declaration//GEN-END:variables

/* ------------------------ GETTERS -----------------------*/
    public DialogResult getResult() {
        return _result;
    }

    public String getConnectedUserName() {
        return _connectedUserName;
    }
/* ------------------------- SETTERS ----------------------*/
    public void setResult(DialogResult _result) {
        this._result = _result;
    }


    public void setConnectedUserName(String _connectedUserName) {
        this._connectedUserName = _connectedUserName;
    }
}
