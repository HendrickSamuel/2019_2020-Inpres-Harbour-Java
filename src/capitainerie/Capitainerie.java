/******************************************************/
/*Auteur: Hendrick Samuel & Khamana Benedict          */
/*Groupe: 2203                                        */
/*Application: Inpres Harbour                         */
/*Date de creation: 27/03/2020                        */
/******************************************************/

package capitainerie;

import Equipage.SailorWithoutIdentificationException;
import HarbourGlobal.DialogErreurModifiable;
import HarbourGlobal.DialogResult;
import HarbourGlobal.MyAppProperties;
import HarbourGlobal.PropertiesEnum;
import utilisateurs.DialogLogin;
import VehiculesMarins.*;
import java.awt.Image;
import java.text.DateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.Locale;
import javax.swing.AbstractButton;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import java.util.Timer;
import java.util.TimerTask;
import utilisateurs.NewPwdDialog;
import HarbourGlobal.GestionLocale;

public class Capitainerie extends javax.swing.JFrame {
    
    private CapitainerieBrain CB;
    
    private int _formatDate;
    private int _formatHeure;
    private Locale _fuseau;
    
    private int _selectedListIndex;
    
    private Timer timer;
    private DialogErreurModifiable _DialogErreur;
    
     /* ----------------------- CONSTRUCTEUR ----------------------*/
    public Capitainerie(){
        initComponents();
        
        CB = new CapitainerieBrain();
        
       
        if(this.UserLogin() == false)
        {
            this.Close();
        }
        else
        {
            SetButtons(true);
            _DialogErreur = new DialogErreurModifiable(this, true);
            
            MyAppProperties map = CB.getAppProperties();
            _fuseau = GestionLocale.stringToLocale(map.getPropertie(PropertiesEnum.Locale));
            
            _formatDate = Integer.parseInt(map.getPropertie(PropertiesEnum.FormatDate));
            _formatHeure = Integer.parseInt(map.getPropertie(PropertiesEnum.FormatHeure));
            
            InitListe();
            
            ImageIcon icon1 = new ImageIcon(getClass().getResource("/Images/bateauplaisance.jpg"));
            Image scaleImage1 = icon1.getImage().getScaledInstance(300, 200,Image.SCALE_DEFAULT);
            Image1.setIcon(new javax.swing.ImageIcon(scaleImage1));
            
            ImageIcon icon2 = new ImageIcon(getClass().getResource("/Images/bateaupeche.jpg"));
            Image scaleImage2 = icon2.getImage().getScaledInstance(300, 200,Image.SCALE_DEFAULT);
            Image2.setIcon(new javax.swing.ImageIcon(scaleImage2));
            
            timer = new Timer();
            TimerTask task = new TimerTask()
            {
                @Override
                public
                void run()
                {
                    ShowTime();
                }
            };
            timer.schedule(task,0, 1*1000);
        }
    } 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BoutonsLogin = new javax.swing.ButtonGroup();
        CheckRequestPending = new javax.swing.JCheckBox();
        ButtonRead = new javax.swing.JButton();
        TextFieldPendingRequest = new javax.swing.JTextField();
        LabelAmaragePossible = new javax.swing.JLabel();
        ButtonChoose = new javax.swing.JButton();
        TextFieldAmarrage = new javax.swing.JTextField();
        ButtonSendChoise = new javax.swing.JButton();
        TextFieldChoice = new javax.swing.JTextField();
        ButtonSendConfirmation = new javax.swing.JButton();
        LabelBateauxEntree = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ListeBateauxEntree = new javax.swing.JList<>();
        ButtonBateauAmarre = new javax.swing.JButton();
        Image1 = new javax.swing.JLabel();
        Image2 = new javax.swing.JLabel();
        LabelHeure = new javax.swing.JLabel();
        ButtonServeur = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
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
        setResizable(false);

        CheckRequestPending.setText("Requête en attente");

        ButtonRead.setText("Lire");
        BoutonsLogin.add(ButtonRead);
        ButtonRead.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonReadActionPerformed(evt);
            }
        });

        TextFieldPendingRequest.setEditable(false);
        TextFieldPendingRequest.setText("??");

        LabelAmaragePossible.setText("Amarrage possible:");

        ButtonChoose.setText("choisir");
        BoutonsLogin.add(ButtonChoose);
        ButtonChoose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonChooseActionPerformed(evt);
            }
        });

        TextFieldAmarrage.setEditable(false);
        TextFieldAmarrage.setText("??");

        ButtonSendChoise.setText("Envoyer choix");
        BoutonsLogin.add(ButtonSendChoise);
        ButtonSendChoise.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonSendChoiseActionPerformed(evt);
            }
        });

        TextFieldChoice.setEditable(false);
        TextFieldChoice.setText("???");

        ButtonSendConfirmation.setText("Envoyer confirmation");
        BoutonsLogin.add(ButtonSendConfirmation);
        ButtonSendConfirmation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonSendConfirmationActionPerformed(evt);
            }
        });

        LabelBateauxEntree.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        LabelBateauxEntree.setText("bateaux en entrée");
        LabelBateauxEntree.setToolTipText("");

        ListeBateauxEntree.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        ListeBateauxEntree.setToolTipText("liste des bateaux en attente de confirmation d'amarrage");
        ListeBateauxEntree.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ListeBateauxEntree.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ListeBateauxEntreeMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(ListeBateauxEntree);

        ButtonBateauAmarre.setText("Bateau amarré");
        ButtonBateauAmarre.setActionCommand("Confirmer amarrage");
        BoutonsLogin.add(ButtonBateauAmarre);
        ButtonBateauAmarre.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        ButtonBateauAmarre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonBateauAmarreActionPerformed(evt);
            }
        });

        Image1.setBackground(new java.awt.Color(51, 204, 255));

        Image2.setBackground(new java.awt.Color(0, 255, 255));

        LabelHeure.setText("current time");

        ButtonServeur.setText("Demarrer Serveur");
        ButtonServeur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonServeurActionPerformed(evt);
            }
        });

        jLabel1.setText("Bateau en cours d'amarrage:");

        jLabel2.setText("Bateau entree en rade:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Interaction avec le phare");

        jButton2.setText("Connection Serveur");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel4.setText("Départ bateaux");

        MenuUser.setText("Utilisateurs");

        MenuItemLogin.setText("login");
        MenuItemLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuItemLoginActionPerformed(evt);
            }
        });
        MenuUser.add(MenuItemLogin);

        MenuItemLogout.setText("Logout");
        BoutonsLogin.add(MenuItemLogout);
        MenuItemLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuItemLogoutActionPerformed(evt);
            }
        });
        MenuUser.add(MenuItemLogout);

        MenuItemNouveau.setText("Nouveau");
        BoutonsLogin.add(MenuItemNouveau);
        MenuItemNouveau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuItemNouveauActionPerformed(evt);
            }
        });
        MenuUser.add(MenuItemNouveau);

        jMenuBar1.add(MenuUser);

        MenuAmarrages.setText("Amarrages");

        MenuItemPlaisance.setText("Plaisance");
        BoutonsLogin.add(MenuItemPlaisance);
        MenuItemPlaisance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuItemPlaisanceActionPerformed(evt);
            }
        });
        MenuAmarrages.add(MenuItemPlaisance);

        MenuItemPeche.setText("Pêche");
        BoutonsLogin.add(MenuItemPeche);
        MenuItemPeche.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuItemPecheActionPerformed(evt);
            }
        });
        MenuAmarrages.add(MenuItemPeche);

        jMenuBar1.add(MenuAmarrages);

        MenuBateaux.setText("Bateaux");

        MenuItemListerBateaux.setText("Liste complète");
        BoutonsLogin.add(MenuItemListerBateaux);
        MenuItemListerBateaux.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuItemListerBateauxActionPerformed(evt);
            }
        });
        MenuBateaux.add(MenuItemListerBateaux);

        MenuItemRechercherBateau.setText("Rechercher un bateau");
        BoutonsLogin.add(MenuItemRechercherBateau);
        MenuItemRechercherBateau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuItemRechercherBateauActionPerformed(evt);
            }
        });
        MenuBateaux.add(MenuItemRechercherBateau);

        jMenuBar1.add(MenuBateaux);

        MenuPersonnel.setText("Personnel");

        MenuItemEquipageBateau.setText("Equipage d'un bateau");
        BoutonsLogin.add(MenuItemEquipageBateau);
        MenuItemEquipageBateau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuItemEquipageBateauActionPerformed(evt);
            }
        });
        MenuPersonnel.add(MenuItemEquipageBateau);

        MenuItemRechercheMarin.setText("Rechercher un marin");
        BoutonsLogin.add(MenuItemRechercheMarin);
        MenuItemRechercheMarin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuItemRechercheMarinActionPerformed(evt);
            }
        });
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

        ButtonAide.setText("Aide");
        ButtonAide.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonAideActionPerformed(evt);
            }
        });
        MenuAPropos.add(ButtonAide);

        jMenuBar1.add(MenuAPropos);

        jMenu1.setText("Paramètres");

        MenuItemFormatDate.setText("Format date");
        BoutonsLogin.add(MenuItemFormatDate);
        MenuItemFormatDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuItemFormatDateActionPerformed(evt);
            }
        });
        jMenu1.add(MenuItemFormatDate);

        jMenuItem6.setText("Fichier log");
        BoutonsLogin.add(jMenuItem6);
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem6);

        HeureVisibleChack.setSelected(true);
        HeureVisibleChack.setText("Affichage date-heure courante");
        HeureVisibleChack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(ButtonServeur)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(LabelHeure))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Image1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Image2, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 529, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(ButtonBateauAmarre, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(173, 173, 173))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(LabelBateauxEntree)
                                .addGap(200, 200, 200)))))
                .addGap(71, 71, 71))
            .addComponent(jSeparator1)
            .addComponent(jSeparator2)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LabelAmaragePossible)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(CheckRequestPending)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ButtonRead))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(428, 428, 428)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(jLabel1)
                                .addGap(36, 36, 36))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel2)
                                .addGap(74, 74, 74)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(TextFieldChoice, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(ButtonSendConfirmation))
                            .addComponent(TextFieldPendingRequest, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 586, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(ButtonChoose, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(TextFieldAmarrage, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(ButtonSendChoise)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jButton2))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(LabelHeure)
                        .addGap(9, 9, 9))
                    .addComponent(ButtonServeur, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(10, 10, 10)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CheckRequestPending)
                    .addComponent(ButtonRead)
                    .addComponent(jButton2))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TextFieldPendingRequest, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelAmaragePossible)
                    .addComponent(ButtonChoose)
                    .addComponent(TextFieldAmarrage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ButtonSendChoise))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ButtonSendConfirmation)
                    .addComponent(TextFieldChoice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Image1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Image2, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(LabelBateauxEntree)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ButtonBateauAmarre)))
                .addGap(18, 18, 18))
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
        
        String chaine = CB.getMessage(1);
        
        if(chaine.length() > 0 )
        {
            String[] split = chaine.split("/"); // [0]:etape | [1]: nom | [2]: type |[3]: taille 
        
            DialogChoixAmarrage dca = new DialogChoixAmarrage(this, true, CB.ListeAmarrages,split[2]); // recuperer le type aussi
            dca.setVisible(true);

            if(dca.getResult() == DialogResult.ok)
            {
                String choixAmarrage = dca.getChoixAmarrage();
                String choixEmplacement = dca.getChoixEmplacement();
                TextFieldAmarrage.setText(choixAmarrage+"*"+choixEmplacement);

                //todo: renvoyer le nom du bateau

                CB.SetMessage(2, 2+"/"+split[1] + "/" + choixAmarrage + "/" + choixEmplacement); // preparer pour l'envoi
            }
        }

        
    }//GEN-LAST:event_ButtonChooseActionPerformed

    private void HeureVisibleChackActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_HeureVisibleChackActionPerformed
    {//GEN-HEADEREND:event_HeureVisibleChackActionPerformed
        if(HeureVisibleChack.getState() == true)
        {
            LabelHeure.setVisible(true);
            
            TimerTask task = new TimerTask()
            {
                @Override
                public
                void run()
                {
                    ShowTime();
                }
            };
            timer.schedule(task,0, 1*1000);
        }
        else
        {
            LabelHeure.setVisible(false);
            timer.cancel();
        }
    }//GEN-LAST:event_HeureVisibleChackActionPerformed

    private void ButtonServeurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonServeurActionPerformed
       if(CB.IsServerOn() == false)
        {
            CB.DemarrerServeur(CheckRequestPending);
            ButtonServeur.setText("Arreter serveur");
        }
        else
        {
            CB.ArreterServeur();
            ButtonServeur.setText("Demarrer serveur");
        }
    }//GEN-LAST:event_ButtonServeurActionPerformed

    private void ButtonReadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonReadActionPerformed
        String msg = CB.ReadMessage();
        String[] vec;  
        switch(msg.substring(0, 1))
        {
            case "1":
                vec = CB.getMessage(1).split("/");
                TextFieldPendingRequest.setText(vec[1] + " / " +vec[4] +"m");
                break;
                
            case "3":
                vec = CB.getMessage(2).split("/");
                TextFieldChoice.setText(vec[1] + " <- " + vec[2] + "*" + vec[3]);
                break;    
        }
    }//GEN-LAST:event_ButtonReadActionPerformed

    private void ButtonSendChoiseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonSendChoiseActionPerformed
        CB.sendMessage(2); // etape 2
    }//GEN-LAST:event_ButtonSendChoiseActionPerformed

    private void ListeBateauxEntreeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ListeBateauxEntreeMouseClicked
        String msg = ListeBateauxEntree.getSelectedValue();
        if(msg == null)
            return;
        
        boolean res = CB.SelectBateauFromText(msg);
        _selectedListIndex = ListeBateauxEntree.getSelectedIndex();
        if(!res)
        {
            ((DefaultListModel) ListeBateauxEntree.getModel()).remove(_selectedListIndex);
        }
    }//GEN-LAST:event_ListeBateauxEntreeMouseClicked

    private void MenuItemPlaisanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuItemPlaisanceActionPerformed
        DialogListesAmarrages dla = new DialogListesAmarrages(this, true, CB.ListeAmarrages, "Plaisance");
        dla.setVisible(true);
    }//GEN-LAST:event_MenuItemPlaisanceActionPerformed

    private void MenuItemPecheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuItemPecheActionPerformed
        DialogListesAmarrages dla = new DialogListesAmarrages(this, true, CB.ListeAmarrages, "Peche");
        dla.setVisible(true);
    }//GEN-LAST:event_MenuItemPecheActionPerformed

    private void MenuItemListerBateauxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuItemListerBateauxActionPerformed
        DialogListeBateaux dlb = new DialogListeBateaux(this, true, CB.ListeAmarrages, false, true, CB.CanSendRequest());
        dlb.setVisible(true);
        if(dlb.getResult() == DialogResult.ok)
        {
            CB.SendDepart(dlb.getBateauDepart());
        }
    }//GEN-LAST:event_MenuItemListerBateauxActionPerformed

    private void MenuItemRechercherBateauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuItemRechercherBateauActionPerformed
        DialogListeBateaux dlb = new DialogListeBateaux(this, true, CB.ListeAmarrages, true, true, CB.CanSendRequest());
        dlb.setVisible(true);
        if(dlb.getResult() == DialogResult.ok)
        {
            CB.SendDepart(dlb.getBateauDepart());
        }
    }//GEN-LAST:event_MenuItemRechercherBateauActionPerformed

    private void ButtonSendConfirmationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonSendConfirmationActionPerformed
        CB.SetMessage(4, 4+"/OK"); // preparer l'envoi
        CB.sendMessage(4); // envoyer
        // faire des choses
        Bateau bat = CB.CreerBateauFromString(CB.getMessage(1).substring(2)); // retirer le 1/ et garder que test/Peche/CH/333  "nom/type/pavillon/longueur"
        String[] tmp = CB.getMessage(2).split("/");
        String amarrage = tmp[2]+"*"+tmp[3];
        
        boolean res = CB.AmarrerBateauToID(bat, amarrage);
        
        if(res)
        {
            AjouterBateauListe(bat, amarrage);
            TextFieldAmarrage.setText("??");
            TextFieldChoice.setText("??");
            TextFieldPendingRequest.setText("??");
        }
        
        CB.Save();
    }//GEN-LAST:event_ButtonSendConfirmationActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        DialogLogs dl = new DialogLogs(this, true, CB);
        dl.setVisible(true);
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        CB.ConnectClient();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void MenuItemEquipageBateauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuItemEquipageBateauActionPerformed
        DialogListeBateaux dlb = new DialogListeBateaux(this, true, CB.ListeAmarrages, true, false, CB.CanSendRequest());
        dlb.setVisible(true);
    }//GEN-LAST:event_MenuItemEquipageBateauActionPerformed

    private void MenuItemRechercheMarinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuItemRechercheMarinActionPerformed
        DialogRechercheMarin drm = new DialogRechercheMarin(this, true, CB.ListeAmarrages);
        drm.setVisible(true);
    }//GEN-LAST:event_MenuItemRechercheMarinActionPerformed
    
    private void ButtonBateauAmarreActionPerformed(java.awt.event.ActionEvent evt) {      
        if(CB.getBateauEnCoursAmarrage() != null && CB.IsAmarrageValide() == true)
        {
            CB.getLogger().Write("Capitainerie", "Ouverture de la fenetre d'amarrage pour le bateau: " + CB.getBateauEnCoursAmarrage() + "à l'emplacement: " + CB.GetEmplacement());
            DialogAmarage am = new DialogAmarage(CB.getBateauEnCoursAmarrage(), CB.GetEmplacement() ,this, true);
            am.setVisible(true);
            // bloquant jusqu'au retour 

            if(am.getResult() == DialogResult.ok && _selectedListIndex != -1) // si appui sur annuler ? 
            {
                CB.getLogger().Write("Capitainerie", "Validation de l'ammarage pour le bateau: " + CB.getBateauEnCoursAmarrage() + "à l'emplacement: " + CB.GetEmplacement());
                CB.getBateauEnCoursAmarrage().SetDateArrivee(new Date());
                String tmp = ((DefaultListModel) ListeBateauxEntree.getModel()).get(_selectedListIndex).toString();
                CB.RemoveList(tmp);
                ((DefaultListModel) ListeBateauxEntree.getModel()).remove(_selectedListIndex); // retirer de la liste 
                
                _selectedListIndex = -1;
                CB.setBateauEnCoursAmarrage(null);
                CB.Save();
            }
            else
            {
                CB.getLogger().Write("Capitainerie", "Annulation de l'ammarage pour le bateau: " + CB.getBateauEnCoursAmarrage() + "à l'emplacement: " + CB.GetEmplacement());
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
            MyAppProperties map = CB.getAppProperties();
            
            map.setPropertie(PropertiesEnum.Locale, GestionLocale.localeToString(ddp.getFuseauPays()));
            map.setPropertie(PropertiesEnum.FormatDate, Integer.toString(ddp.getFormatDate()));
            map.setPropertie(PropertiesEnum.FormatHeure, Integer.toString(ddp.getFormatHeure()));
            map.Save();
            
            _fuseau = GestionLocale.stringToLocale(map.getPropertie(PropertiesEnum.Locale));
            
            _formatDate = Integer.parseInt(map.getPropertie(PropertiesEnum.FormatDate));
            _formatHeure = Integer.parseInt(map.getPropertie(PropertiesEnum.FormatHeure));

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
            if (UserLogin());
                SetButtons(true);
        }
    }

    private void MenuItemLogoutActionPerformed(java.awt.event.ActionEvent evt) {
        CB.getLogger().Write("Capitainerie", "Le dernier utilisateur s'est déconnecté");
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
    private javax.swing.JButton ButtonServeur;
    private javax.swing.JCheckBox CheckRequestPending;
    private javax.swing.JCheckBoxMenuItem HeureVisibleChack;
    private javax.swing.JLabel Image1;
    private javax.swing.JLabel Image2;
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
    private javax.swing.JTextField TextFieldAmarrage;
    private javax.swing.JTextField TextFieldChoice;
    private javax.swing.JTextField TextFieldPendingRequest;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
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
        CB.getLogger().Write("Capitainerie", "Affichage de la fenetre de login");
        DialogLogin dlg = new DialogLogin(this, true);
        dlg.setVisible(true);
        
        if(null == dlg.getResult())
        {
            CB.getLogger().Write("Capitainerie", "Un cas imprévu s'est produit");
            return false;
        }
        else switch (dlg.getResult()) {
            case ok:
                CB.RegisterUser(dlg.getConnectedUserName());
                this.SetTitre(CB.getConnectedUser());
                CB.getLogger().Write("Capitainerie","( "+ CB.getConnectedUser() + " ) s'est connecté");
                return true;
            case cancel:
                CB.getLogger().Write("Capitainerie", "Annulation du login");
                return false;
            case untouched:
                CB.getLogger().Write("Capitainerie", "Annulation du login");
                return false;
            default:
                CB.getLogger().Write("Capitainerie", "Un cas imprévu s'est produit");
                return false;
        }
    }
    
    private void InitListe()
    {
        DefaultListModel dlm = new DefaultListModel();
            
        Enumeration enu = CB.ListeBateauxEntree.elements();
        while(enu.hasMoreElements())
        {
            dlm.addElement(enu.nextElement());
        }
        
        ListeBateauxEntree.setModel(dlm); 
    }
    
    private  void AjouterBateauListe(Bateau bateau, String emplacement)
    {
        DefaultListModel dlm = (DefaultListModel)ListeBateauxEntree.getModel();
        String newEntry = bateau + " -> " + emplacement;
        dlm.addElement(newEntry);
        CB.ListeBateauxEntree.add(newEntry);
    }
    
}
