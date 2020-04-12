/******************************************************/
/*Auteur: Hendrick Samuel                             */
/*Groupe: 2203                                        */
/*Application: Inpres Harbour                         */
/*Date de creation: 25/03/2020                        */
/******************************************************/

package capitainerie;

import HarbourGlobal.DialogResult;
import utilisateurs.DialogLogin;

public class Capitainerie extends javax.swing.JFrame {
    
    private String _connectedUser;

    public Capitainerie() {
        initComponents();
        
        if(this.UserLogin() == true)
        {
            this.SetTitre(_connectedUser);
        }
        else
        {
            this.Close();
        }
    }
    
    private void Close()
    {
        this.dispose();
        System.exit(0);
    }
            
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ButtonStartServer = new javax.swing.JButton();
        CheckRequestPending = new javax.swing.JCheckBox();
        ButtonRead = new javax.swing.JButton();
        TextFieldPendingRequest = new javax.swing.JTextField();
        LabelAmaragePossible = new javax.swing.JLabel();
        ButtonChoose = new javax.swing.JButton();
        InputAmarrage = new javax.swing.JTextField();
        ButtonSendChoise = new javax.swing.JButton();
        InputChoice = new javax.swing.JTextField();
        ButtonSendConfirmation = new javax.swing.JButton();
        LabelBateauxEntree = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ListeBateauxEntree = new javax.swing.JList<>();
        ButtonBateauAmarre = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        MenuUser = new javax.swing.JMenu();
        MenuItemLogin = new javax.swing.JMenuItem();
        MenuItemLogout = new javax.swing.JMenuItem();
        MenuItemNouveau = new javax.swing.JMenuItem();
        MenuAmarrages = new javax.swing.JMenu();
        MenuItemPlaisance = new javax.swing.JMenuItem();
        MenuItemPeche = new javax.swing.JMenuItem();
        MenuBateaux = new javax.swing.JMenu();
        MenuItemListerBateaux = new javax.swing.JMenuItem();
        MenuItemRechercherBateau = new javax.swing.JMenuItem();
        MenuPersonnel = new javax.swing.JMenu();
        MenuItemEquipageBateau = new javax.swing.JMenuItem();
        MenuItemRechercheMarin = new javax.swing.JMenuItem();
        MenuAPropos = new javax.swing.JMenu();
        ButtonAbout = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        MenuItemFormatDate = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Capitainerie d'Inpres-Harbour");

        ButtonStartServer.setText("Démarrer le serveur");

        CheckRequestPending.setText("Requête en attente");

        ButtonRead.setText("Lire");

        TextFieldPendingRequest.setText("??");

        LabelAmaragePossible.setText("Amarrage possible:");

        ButtonChoose.setText("choisir");

        InputAmarrage.setText("??");

        ButtonSendChoise.setText("Envoyer choix");

        InputChoice.setText("???");

        ButtonSendConfirmation.setText("Envoyer confirmation");

        LabelBateauxEntree.setText("bateaux en entrée");
        LabelBateauxEntree.setToolTipText("");

        jScrollPane1.setViewportView(ListeBateauxEntree);

        ButtonBateauAmarre.setText("Bateau amarré");
        ButtonBateauAmarre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonBateauAmarreActionPerformed(evt);
            }
        });

        jButton2.setText("Arrêter le serveur");

        jLabel1.setText("Img1");

        jLabel2.setText("Img2");

        jLabel3.setText("current time");

        MenuUser.setText("Utilisateurs");

        MenuItemLogin.setText("login");
        MenuItemLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuItemLoginActionPerformed(evt);
            }
        });
        MenuUser.add(MenuItemLogin);

        MenuItemLogout.setText("Logout");
        MenuItemLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuItemLogoutActionPerformed(evt);
            }
        });
        MenuUser.add(MenuItemLogout);

        MenuItemNouveau.setText("Nouveau");
        MenuUser.add(MenuItemNouveau);

        jMenuBar1.add(MenuUser);

        MenuAmarrages.setText("Amarrages");

        MenuItemPlaisance.setText("Plaisance");
        MenuAmarrages.add(MenuItemPlaisance);

        MenuItemPeche.setText("Pêche");
        MenuAmarrages.add(MenuItemPeche);

        jMenuBar1.add(MenuAmarrages);

        MenuBateaux.setText("Bateaux");

        MenuItemListerBateaux.setText("Liste complète");
        MenuBateaux.add(MenuItemListerBateaux);

        MenuItemRechercherBateau.setText("Rechercher un bateau");
        MenuBateaux.add(MenuItemRechercherBateau);

        jMenuBar1.add(MenuBateaux);

        MenuPersonnel.setText("Personnel");

        MenuItemEquipageBateau.setText("Equipage d'un bateau");
        MenuPersonnel.add(MenuItemEquipageBateau);

        MenuItemRechercheMarin.setText("Rechercher un marin");
        MenuPersonnel.add(MenuItemRechercheMarin);

        jMenuBar1.add(MenuPersonnel);

        MenuAPropos.setText("A propos");

        ButtonAbout.setText("Auteur(s)");
        ButtonAbout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonAboutActionPerformed(evt);
            }
        });
        MenuAPropos.add(ButtonAbout);

        jMenuItem4.setText("Aide");
        MenuAPropos.add(jMenuItem4);

        jMenuBar1.add(MenuAPropos);

        jMenu1.setText("Paramètres");

        MenuItemFormatDate.setText("Format date");
        MenuItemFormatDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuItemFormatDateActionPerformed(evt);
            }
        });
        jMenu1.add(MenuItemFormatDate);

        jMenuItem6.setText("Fichier log");
        jMenu1.add(jMenuItem6);

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("Affichage date-heure courante");
        jMenu1.add(jCheckBoxMenuItem1);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(LabelAmaragePossible)
                        .addGap(18, 18, 18)
                        .addComponent(ButtonChoose)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(InputAmarrage, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(ButtonSendChoise)
                        .addGap(18, 18, 18)
                        .addComponent(InputChoice, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(ButtonSendConfirmation))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(CheckRequestPending)
                        .addGap(65, 65, 65)
                        .addComponent(ButtonRead)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TextFieldPendingRequest, javax.swing.GroupLayout.PREFERRED_SIZE, 586, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(134, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(ButtonStartServer)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 529, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(12, 12, 12)
                                        .addComponent(LabelBateauxEntree))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(ButtonBateauAmarre, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton2)))
                                .addGap(228, 228, 228)))))
                .addGap(71, 71, 71))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ButtonStartServer)
                    .addComponent(jLabel3))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CheckRequestPending)
                            .addComponent(ButtonRead)
                            .addComponent(TextFieldPendingRequest, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LabelAmaragePossible)
                            .addComponent(ButtonChoose)
                            .addComponent(InputAmarrage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ButtonSendChoise)
                            .addComponent(InputChoice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ButtonSendConfirmation))
                        .addGap(164, 164, 164)
                        .addComponent(jLabel1)
                        .addGap(71, 71, 71)
                        .addComponent(jLabel2)
                        .addContainerGap(140, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(LabelBateauxEntree)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ButtonBateauAmarre)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addGap(30, 30, 30))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ButtonBateauAmarreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonBateauAmarreActionPerformed
        CapitainerieBateauEntrant cpte = new CapitainerieBateauEntrant();
        cpte.setVisible(true);
    }//GEN-LAST:event_ButtonBateauAmarreActionPerformed

    private void ButtonAboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonAboutActionPerformed
        DialogAbout dab = new DialogAbout(this, true);
        dab.setVisible(true);
    }//GEN-LAST:event_ButtonAboutActionPerformed

    private void MenuItemFormatDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuItemFormatDateActionPerformed
        DialogDateParam ddp = new DialogDateParam(this, true);
        ddp.setVisible(true);
        // récupérer les formats etc pour appliquer à la date courante
    }//GEN-LAST:event_MenuItemFormatDateActionPerformed

    private void MenuItemLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuItemLoginActionPerformed
        if(IsUserConnected() )
            System.out.println("Utilisatuer deja connecté"); // error popup
        else
            UserLogin();
    }//GEN-LAST:event_MenuItemLoginActionPerformed

    private void MenuItemLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuItemLogoutActionPerformed
        this._connectedUser = "";
        this.SetTitre("offline");
    }//GEN-LAST:event_MenuItemLogoutActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(Capitainerie.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Capitainerie.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Capitainerie.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Capitainerie.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Capitainerie().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem ButtonAbout;
    private javax.swing.JButton ButtonBateauAmarre;
    private javax.swing.JButton ButtonChoose;
    private javax.swing.JButton ButtonRead;
    private javax.swing.JButton ButtonSendChoise;
    private javax.swing.JButton ButtonSendConfirmation;
    private javax.swing.JButton ButtonStartServer;
    private javax.swing.JCheckBox CheckRequestPending;
    private javax.swing.JTextField InputAmarrage;
    private javax.swing.JTextField InputChoice;
    private javax.swing.JLabel LabelAmaragePossible;
    private javax.swing.JLabel LabelBateauxEntree;
    private javax.swing.JList<String> ListeBateauxEntree;
    private javax.swing.JMenu MenuAPropos;
    private javax.swing.JMenu MenuAmarrages;
    private javax.swing.JMenu MenuBateaux;
    private javax.swing.JMenuItem MenuItemEquipageBateau;
    private javax.swing.JMenuItem MenuItemFormatDate;
    private javax.swing.JMenuItem MenuItemListerBateaux;
    private javax.swing.JMenuItem MenuItemLogin;
    private javax.swing.JMenuItem MenuItemLogout;
    private javax.swing.JMenuItem MenuItemNouveau;
    private javax.swing.JMenuItem MenuItemPeche;
    private javax.swing.JMenuItem MenuItemPlaisance;
    private javax.swing.JMenuItem MenuItemRechercheMarin;
    private javax.swing.JMenuItem MenuItemRechercherBateau;
    private javax.swing.JMenu MenuPersonnel;
    private javax.swing.JMenu MenuUser;
    private javax.swing.JTextField TextFieldPendingRequest;
    private javax.swing.JButton jButton2;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    private void SetTitre(String _connectedUser) {
        this.setTitle(_connectedUser + " | InpresHarbour");
    }
    
    private boolean IsUserConnected()
    {
        if(_connectedUser.compareTo("") != 0)
            return true;
        else
            return false;
    }
    
    public boolean UserLogin()
    {
         DialogLogin dlg = new DialogLogin(this, true);
        dlg.setVisible(true);
        
        if(dlg.getResult() == DialogResult.ok)
        {
            System.out.println("c'est ok");
            this._connectedUser = dlg.getConnectedUserName();
            this.SetTitre(_connectedUser);
            return true;
            
        }
        else if (dlg.getResult() == DialogResult.cancel)
        {
            System.out.println("c'est annulé");
            return false;
        }
        else if (dlg.getResult() == DialogResult.untouched)
        {
            System.out.println("c'est ferme sans y toucher");
            return false;
        }
        else
            return false;
    }
}
