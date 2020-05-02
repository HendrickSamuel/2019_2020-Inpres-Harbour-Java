/******************************************************/
/*Auteur: Hendrick Samuel & Khamana Benedict          */
/*Groupe: 2203                                        */
/*Application: Inpres Harbour                         */
/*Date de creation: 27/03/2020                        */
/******************************************************/

package capitainerie;

import Amarrages.Ponton;
import Equipage.Equipage;
import Equipage.Marin;
import HarbourGlobal.DialogErreurModifiable;
import HarbourGlobal.DialogResult;
import utilisateurs.DialogLogin;
import VehiculesMarins.*;
import java.awt.Image;
import java.text.DateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractButton;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import java.util.Timer;
import java.util.TimerTask;
import utilisateurs.NewPwdDialog;

public class Capitainerie extends javax.swing.JFrame {
    
    private CapitainerieBrain CB;
    
    private int _formatDate;
    private int _formatHeure;
    private Locale _fuseau;
    
    
    private Timer timer;
    private DialogErreurModifiable _DialogErreur;
    
     /* ----------------------- CONSTRUCTEUR ----------------------*/
    public Capitainerie(){
        initComponents();
        
        CB = new CapitainerieBrain();
        
        //<editor-fold defaultstate="collapsed" desc="GUI print">

        System.out.println(CB.Now() + " | création du cerveau de l'application");
        //</editor-fold>
       
        if(this.UserLogin() == false)
        {
            this.Close();
        }
        else
        {
            SetButtons(true);
            _DialogErreur = new DialogErreurModifiable(this, true);
            _fuseau = Locale.FRANCE;
            _formatDate = 1;
            _formatHeure = 1;
            
            InitListe();
            
            ImageIcon icon1 = new ImageIcon(getClass().getResource("/Images/bateauplaisance.jpg"));
            Image scaleImage1 = icon1.getImage().getScaledInstance(300, 200,Image.SCALE_DEFAULT);
            Image1.setIcon(new javax.swing.ImageIcon(scaleImage1));
            
            ImageIcon icon2 = new ImageIcon(getClass().getResource("/Images/bateaupeche.jpg"));
            Image scaleImage2 = icon2.getImage().getScaledInstance(300, 200,Image.SCALE_DEFAULT);
            Image2.setIcon(new javax.swing.ImageIcon(scaleImage2));
            
            Ponton ponton = new Ponton(1,10);
            //<editor-fold defaultstate="collapsed" desc="GUI print">

            System.out.println(CB.Now() + " | création d'un ponton: " + ponton.getIdentifiant());
            //Ajout d'un ponton pour le test
            CB.ListeAmarrages.add(ponton);
            System.out.println(CB.Now() + " |ajout du ponton à la liste du cerveau");
            //</editor-fold>
            
            try{
                Bateau bateau = new Bateau("george", "ok", 10, 100, "Germanique", new Equipage(), true, Energie.essence);
                CB.setBateauEnCoursAmarrage(bateau);
                //<editor-fold defaultstate="collapsed" desc="GUI print">
                System.out.println(CB.Now() + " | création d'un bateau: " + bateau);
                bateau.Affiche();
                //</editor-fold>
            }
            catch(Exception exc)
            {
                 Logger.getLogger(Capitainerie.class.getName()).log(Level.SEVERE, null, exc);
            }
            
            
            /*timer = new Timer();
            TimerTask task = new TimerTask()
            {
                @Override
                public
                void run()
                {
                    ShowTime();
                }
            };
            timer.schedule(task,0, 1*1000);*/
            
        }
    }
            
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        BoutonsLogin = new javax.swing.ButtonGroup();
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
        Image1 = new javax.swing.JLabel();
        Image2 = new javax.swing.JLabel();
        LabelHeure = new javax.swing.JLabel();
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
        ButtonAide = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        MenuItemFormatDate = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        HeureVisibleChack = new javax.swing.JCheckBoxMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Capitainerie d'Inpres-Harbour");

        ButtonStartServer.setText("Démarrer le serveur");
        ButtonStartServer.setContentAreaFilled(false);

        CheckRequestPending.setText("Requête en attente");

        ButtonRead.setText("Lire");
        BoutonsLogin.add(ButtonRead);

        TextFieldPendingRequest.setText("??");

        LabelAmaragePossible.setText("Amarrage possible:");

        ButtonChoose.setText("choisir");
        BoutonsLogin.add(ButtonChoose);
        ButtonChoose.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                ButtonChooseActionPerformed(evt);
            }
        });

        InputAmarrage.setText("??");

        ButtonSendChoise.setText("Envoyer choix");
        BoutonsLogin.add(ButtonSendChoise);

        InputChoice.setText("???");

        ButtonSendConfirmation.setText("Envoyer confirmation");
        BoutonsLogin.add(ButtonSendConfirmation);

        LabelBateauxEntree.setText("bateaux en entrée");
        LabelBateauxEntree.setToolTipText("");

        ListeBateauxEntree.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(ListeBateauxEntree);

        ButtonBateauAmarre.setText("Bateau amarré");
        BoutonsLogin.add(ButtonBateauAmarre);
        ButtonBateauAmarre.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        ButtonBateauAmarre.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                ButtonBateauAmarreActionPerformed(evt);
            }
        });

        jButton2.setText("Arrêter le serveur");
        BoutonsLogin.add(jButton2);

        Image1.setBackground(new java.awt.Color(51, 204, 255));

        Image2.setBackground(new java.awt.Color(0, 255, 255));

        LabelHeure.setText("current time");

        MenuUser.setText("Utilisateurs");

        MenuItemLogin.setText("login");
        MenuItemLogin.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                MenuItemLoginActionPerformed(evt);
            }
        });
        MenuUser.add(MenuItemLogin);

        MenuItemLogout.setText("Logout");
        BoutonsLogin.add(MenuItemLogout);
        MenuItemLogout.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                MenuItemLogoutActionPerformed(evt);
            }
        });
        MenuUser.add(MenuItemLogout);

        MenuItemNouveau.setText("Nouveau");
        BoutonsLogin.add(MenuItemNouveau);
        MenuItemNouveau.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                MenuItemNouveauActionPerformed(evt);
            }
        });
        MenuUser.add(MenuItemNouveau);

        jMenuBar1.add(MenuUser);

        MenuAmarrages.setText("Amarrages");

        MenuItemPlaisance.setText("Plaisance");
        BoutonsLogin.add(MenuItemPlaisance);
        MenuAmarrages.add(MenuItemPlaisance);

        MenuItemPeche.setText("Pêche");
        BoutonsLogin.add(MenuItemPeche);
        MenuAmarrages.add(MenuItemPeche);

        jMenuBar1.add(MenuAmarrages);

        MenuBateaux.setText("Bateaux");

        MenuItemListerBateaux.setText("Liste complète");
        BoutonsLogin.add(MenuItemListerBateaux);
        MenuBateaux.add(MenuItemListerBateaux);

        MenuItemRechercherBateau.setText("Rechercher un bateau");
        BoutonsLogin.add(MenuItemRechercherBateau);
        MenuBateaux.add(MenuItemRechercherBateau);

        jMenuBar1.add(MenuBateaux);

        MenuPersonnel.setText("Personnel");

        MenuItemEquipageBateau.setText("Equipage d'un bateau");
        BoutonsLogin.add(MenuItemEquipageBateau);
        MenuPersonnel.add(MenuItemEquipageBateau);

        MenuItemRechercheMarin.setText("Rechercher un marin");
        BoutonsLogin.add(MenuItemRechercheMarin);
        MenuPersonnel.add(MenuItemRechercheMarin);

        jMenuBar1.add(MenuPersonnel);

        MenuAPropos.setText("A propos");

        ButtonAbout.setText("Auteur(s)");
        ButtonAbout.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                ButtonAboutActionPerformed(evt);
            }
        });
        MenuAPropos.add(ButtonAbout);

        ButtonAide.setText("Aide");
        ButtonAide.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                ButtonAideActionPerformed(evt);
            }
        });
        MenuAPropos.add(ButtonAide);

        jMenuBar1.add(MenuAPropos);

        jMenu1.setText("Paramètres");

        MenuItemFormatDate.setText("Format date");
        BoutonsLogin.add(MenuItemFormatDate);
        MenuItemFormatDate.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                MenuItemFormatDateActionPerformed(evt);
            }
        });
        jMenu1.add(MenuItemFormatDate);

        jMenuItem6.setText("Fichier log");
        BoutonsLogin.add(jMenuItem6);
        jMenu1.add(jMenuItem6);

        HeureVisibleChack.setSelected(true);
        HeureVisibleChack.setText("Affichage date-heure courante");
        HeureVisibleChack.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                HeureVisibleChackActionPerformed(evt);
            }
        });
        jMenu1.add(HeureVisibleChack);

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
                        .addComponent(CheckRequestPending)
                        .addGap(65, 65, 65)
                        .addComponent(ButtonRead)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TextFieldPendingRequest, javax.swing.GroupLayout.PREFERRED_SIZE, 586, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                        .addComponent(ButtonSendConfirmation)))
                .addContainerGap(134, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(ButtonStartServer)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(LabelHeure))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Image1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Image2, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(12, 12, 12)
                                        .addComponent(LabelBateauxEntree))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(ButtonBateauAmarre, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton2)))
                                .addGap(228, 228, 228))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 529, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(71, 71, 71))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ButtonStartServer)
                    .addComponent(LabelHeure))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 149, Short.MAX_VALUE)
                        .addComponent(LabelBateauxEntree)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(ButtonBateauAmarre)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addGap(30, 30, 30))
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
                        .addGap(39, 39, 39)
                        .addComponent(Image1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Image2, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    /* ----------------------- EVENTS LISTENERS ----------------------*/
    
    private void MenuItemNouveauActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_MenuItemNouveauActionPerformed
    {//GEN-HEADEREND:event_MenuItemNouveauActionPerformed
        NewPwdDialog dialog = new NewPwdDialog(this,true);
        dialog.setVisible(true);
    }//GEN-LAST:event_MenuItemNouveauActionPerformed

    private void ButtonAideActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_ButtonAideActionPerformed
    {//GEN-HEADEREND:event_ButtonAideActionPerformed
        HelpDialog hd = new HelpDialog(this, true);
        hd.setVisible(true);
    }//GEN-LAST:event_ButtonAideActionPerformed

    private void ButtonChooseActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_ButtonChooseActionPerformed
    {//GEN-HEADEREND:event_ButtonChooseActionPerformed
        //Ouvrira une fenetre dans la suite d'application pour choisir un quai ou un ponton
        CB.setAmarrageSelectionne(CB.ListeAmarrages.firstElement());
        CB.setCoteSelectionne(1);
        CB.setEmplacementSelectione(2);
        InputAmarrage.setText(CB.GetEmplacement());
    }//GEN-LAST:event_ButtonChooseActionPerformed

    private void HeureVisibleChackActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_HeureVisibleChackActionPerformed
    {//GEN-HEADEREND:event_HeureVisibleChackActionPerformed
        if(HeureVisibleChack.getState() == true)
        {
            LabelHeure.setVisible(true);
            
            /*TimerTask task = new TimerTask()
            {
                @Override
                public
                void run()
                {
                    ShowTime();
                }
            };
            timer.schedule(task,0, 1*1000);*/
        }
        else
        {
            LabelHeure.setVisible(false);
            //timer.cancel();
        }
    }//GEN-LAST:event_HeureVisibleChackActionPerformed
    
    private void ButtonBateauAmarreActionPerformed(java.awt.event.ActionEvent evt) {      
        if(CB.getBateauEnCoursAmarrage() != null && CB.IsAmarrageValide() == true)
        {
            try
            {
                Marin marin = new Marin("jean","thierry","0000","Capitaine");

                //<editor-fold defaultstate="collapsed" desc="GUI print">
                System.out.println(CB.Now() + " | création d'un marin: " + marin);
                //</editor-fold>

                CB.getBateauEnCoursAmarrage().getEquipage().AjoutMembre(marin);

                DialogAmarage am = new DialogAmarage(CB.getBateauEnCoursAmarrage(), CB.GetEmplacement() ,this, true);
                am.setVisible(true);
                // bloquant jusqu'au retour 
                
                if(am.getResult() == DialogResult.ok)
                {
                    AjouterBateau();
                }
                else
                {
                    // effacer le bateau ?? comme refus d'ammarage ? // Le bateau en cours d'amarrage
                }
            }
            catch (Exception ex)
            {
                Logger.getLogger(Capitainerie.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else
        {
            _DialogErreur.SetMessage("aucun bateau à amarrer ou amarrage non valide !");
            _DialogErreur.setVisible(true);
        }
    }

    private void ButtonAboutActionPerformed(java.awt.event.ActionEvent evt) {                                            
        DialogAbout dab = new DialogAbout(this, true);
        dab.setVisible(true);
    }

    private void MenuItemFormatDateActionPerformed(java.awt.event.ActionEvent evt) {                                                   
        DialogDateParam ddp = new DialogDateParam(this, true);
        ddp.setVisible(true);
        
        if(ddp.getResult() == DialogResult.ok)
        {
            _formatDate = ddp.getFormatDate();
            _formatHeure = ddp.getFormatHeure();
            _fuseau = ddp.getFuseauPays(); 
            ShowTime();
        }
    }
    
    private void ShowTime()
    {
        Date maintenant = new Date();
        LabelHeure.setText(DateFormat.getDateTimeInstance(_formatDate, _formatHeure, _fuseau).format(maintenant));
    }

    private void MenuItemLoginActionPerformed(java.awt.event.ActionEvent evt) {                                              
        if(!CB.isUserConnected())
        {
            UserLogin();
            SetButtons(true);
        }
    }

    private void MenuItemLogoutActionPerformed(java.awt.event.ActionEvent evt) {                                               
        CB.LogoutUser();
        SetButtons(false);
        this.SetTitre("offline");
    }

    /* -------------------------------------------------------------------------------------*/
    

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
    private javax.swing.ButtonGroup BoutonsLogin;
    private javax.swing.JMenuItem ButtonAbout;
    private javax.swing.JMenuItem ButtonAide;
    private javax.swing.JButton ButtonBateauAmarre;
    private javax.swing.JButton ButtonChoose;
    private javax.swing.JButton ButtonRead;
    private javax.swing.JButton ButtonSendChoise;
    private javax.swing.JButton ButtonSendConfirmation;
    private javax.swing.JButton ButtonStartServer;
    private javax.swing.JCheckBox CheckRequestPending;
    private javax.swing.JCheckBoxMenuItem HeureVisibleChack;
    private javax.swing.JLabel Image1;
    private javax.swing.JLabel Image2;
    private javax.swing.JTextField InputAmarrage;
    private javax.swing.JTextField InputChoice;
    private javax.swing.JLabel LabelAmaragePossible;
    private javax.swing.JLabel LabelBateauxEntree;
    private javax.swing.JLabel LabelHeure;
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
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
    
    
    /* ------------------------------- METHODES --------------------------*/
    private void Close()
    {
        this.dispose();
        System.exit(0);
    }
    
    private void SetTitre(String _connectedUser) {
        this.setTitle(_connectedUser + " | InpresHarbour");
    }
    
    private void SetButtons(boolean status)
    {
        Enumeration<AbstractButton> enumeration = BoutonsLogin.getElements();
        while (enumeration.hasMoreElements()) {
            enumeration.nextElement().setEnabled(status);
        }
    }
        
    public boolean UserLogin()
    {
         DialogLogin dlg = new DialogLogin(this, true);
        dlg.setVisible(true);
        
        if(dlg.getResult() == DialogResult.ok)
        {
            System.out.println("c'est ok");
            CB.RegisterUser(dlg.getConnectedUserName());
            this.SetTitre(CB.getConnectedUser());
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
    
    private void InitListe()
    {
        DefaultListModel dlm = new DefaultListModel();
            
        // verifier fichier et initialiser les bateaux deja la 
        
        ListeBateauxEntree.setModel(dlm); 
    }
    
    private  void AjouterBateau()
    {
        DefaultListModel dlm = (DefaultListModel)ListeBateauxEntree.getModel();
        dlm.addElement(CB.getBateauEnCoursAmarrage() + " --> " + CB.GetEmplacement());
        
        CB.AmarrerBateau(CB.getBateauEnCoursAmarrage());
    }
    
}
