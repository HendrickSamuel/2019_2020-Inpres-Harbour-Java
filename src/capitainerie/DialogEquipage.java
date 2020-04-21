/******************************************************/
/*Auteur: Hendrick Samuel & Khamana Benedict          */
/*Groupe: 2203                                        */
/*Application: Inpres Harbour                         */
/*Date de creation:13/04/2020                         */
/******************************************************/

package capitainerie;

import Equipage.*;
import HarbourGlobal.*;
import VehiculesMarins.Bateau;

import java.util.Enumeration;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;

public class DialogEquipage extends javax.swing.JDialog {

   private Equipage _equipageEnCours;
   private Equipage _equipageRecu;
   private Bateau _bateauEnCours;
   private MyLogger _logger;
   
   private DialogResult _result = DialogResult.untouched;
    
    public DialogEquipage(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
         _equipageEnCours = new Equipage();
        InitListe(_equipageEnCours); 
        
        LabelBateau.setText("none");
        this.setTitle("Gestion Equipage: none" );
        
        ErrorLabel.setVisible(true);
        _logger = new MyLogger();
        ErrorLabel.setText(_logger.Now() + " Application should not be used like this");
    }
    
    
    public DialogEquipage(Bateau bateau, java.awt.Frame parent, boolean modal )
    {
        super(parent, modal);
        initComponents();
        
        _logger = new MyLogger();
        _bateauEnCours = bateau;
        _equipageRecu = _bateauEnCours.getEquipage();
        _equipageEnCours = new Equipage(_equipageRecu);
        //<editor-fold defaultstate="collapsed" desc="GUI print">
            System.out.println(_logger.Now() + " | copie de l'equipage le temps de la modification ");
        //</editor-fold>
        InitListe(_equipageEnCours);    
        
        LabelBateau.setText(_bateauEnCours.getNom());
        this.setTitle("Gestion Equipage: " + _bateauEnCours.getNom());
        ErrorLabel.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        ButtonGroupGrade = new javax.swing.ButtonGroup();
        jLabel2 = new javax.swing.JLabel();
        ButtonAjoutEquipage = new javax.swing.JButton();
        InputNom = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        ButtonValider = new javax.swing.JButton();
        InputPrenom = new javax.swing.JTextField();
        ButtonAbandonner = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        ListeMarins = new javax.swing.JList<>();
        InputDateNaissance = new javax.swing.JTextField();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jRadioButton5 = new javax.swing.JRadioButton();
        LabelBateau = new javax.swing.JLabel();
        ButtonEmpty = new javax.swing.JButton();
        ErrorLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel2.setText("Nom:");

        ButtonAjoutEquipage.setText("Ajouter");
        ButtonAjoutEquipage.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                ButtonAjoutEquipageActionPerformed(evt);
            }
        });

        jLabel3.setText("Prénom:");

        ButtonValider.setText("Valider équipage");
        ButtonValider.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                ButtonValiderActionPerformed(evt);
            }
        });

        ButtonAbandonner.setText("Abandonner");
        ButtonAbandonner.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                ButtonAbandonnerActionPerformed(evt);
            }
        });

        jLabel4.setText("Date de naissance:");

        ListeMarins.setModel(new javax.swing.AbstractListModel<String>()
        {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(ListeMarins);

        ButtonGroupGrade.add(jRadioButton1);
        jRadioButton1.setText("Capitaine");

        ButtonGroupGrade.add(jRadioButton2);
        jRadioButton2.setText("Second");

        jLabel1.setText("Bateau:");

        ButtonGroupGrade.add(jRadioButton3);
        jRadioButton3.setSelected(true);
        jRadioButton3.setText("Passager");

        ButtonGroupGrade.add(jRadioButton4);
        jRadioButton4.setText("Bosco");

        ButtonGroupGrade.add(jRadioButton5);
        jRadioButton5.setText("Matelot");

        LabelBateau.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        LabelBateau.setText("Nom du bateau");

        ButtonEmpty.setText("Vider Equpiage");
        ButtonEmpty.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                ButtonEmptyActionPerformed(evt);
            }
        });

        ErrorLabel.setForeground(new java.awt.Color(255, 0, 0));
        ErrorLabel.setText("Attenetion, veuillez remplire les champs correctement");
        ErrorLabel.setFocusable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(InputDateNaissance))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
                        .addComponent(InputPrenom, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(84, 84, 84)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(InputNom, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
                            .addComponent(LabelBateau, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(155, 155, 155)
                        .addComponent(ButtonValider)
                        .addGap(109, 109, 109)
                        .addComponent(ButtonAbandonner))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(195, 195, 195)
                        .addComponent(ButtonAjoutEquipage)
                        .addGap(29, 29, 29)
                        .addComponent(ButtonEmpty))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jRadioButton4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jRadioButton5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jRadioButton3))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(jRadioButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jRadioButton2)
                                .addGap(140, 140, 140)
                                .addComponent(ErrorLabel)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(LabelBateau))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(InputNom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(InputPrenom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(InputDateNaissance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton2)
                    .addComponent(ErrorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton4)
                    .addComponent(jRadioButton5)
                    .addComponent(jRadioButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ButtonAjoutEquipage)
                    .addComponent(ButtonEmpty))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ButtonValider)
                    .addComponent(ButtonAbandonner))
                .addGap(43, 43, 43))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ButtonAjoutEquipageActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_ButtonAjoutEquipageActionPerformed
    {//GEN-HEADEREND:event_ButtonAjoutEquipageActionPerformed
       try
       {
            ErrorLabel.setVisible(false);
            Marin marin = new Marin(InputNom.getText(), InputPrenom.getText(), InputDateNaissance.getText(), getSelectedButtonText(ButtonGroupGrade));
            //<editor-fold defaultstate="collapsed" desc="GUI print">
            System.out.println(_logger.Now() + " | creation d'un marin: " + marin);
            //</editor-fold>
            if(getEquipageEnCours().AjoutMembre(marin) == true)
            {
                DefaultListModel lm = (DefaultListModel)ListeMarins.getModel();
                lm.addElement(marin);
            }
            else
            {
                ErrorLabel.setText("Cette fonction est déja prise ou ce marin existe déja");
                ErrorLabel.setVisible(true);
            }
       }
       catch (SailorWithoutIdentificationException ex)
       {
           ErrorLabel.setText("Nom ou préonm du marain manquant !");
           ErrorLabel.setVisible(true);
       }
    }//GEN-LAST:event_ButtonAjoutEquipageActionPerformed

    private void ButtonAbandonnerActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_ButtonAbandonnerActionPerformed
    {//GEN-HEADEREND:event_ButtonAbandonnerActionPerformed
        _result = DialogResult.cancel;
        this.setVisible(false);
    }//GEN-LAST:event_ButtonAbandonnerActionPerformed

    private void ButtonValiderActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_ButtonValiderActionPerformed
    {//GEN-HEADEREND:event_ButtonValiderActionPerformed
        _result = DialogResult.ok;
        this.setVisible(false);
    }//GEN-LAST:event_ButtonValiderActionPerformed

    private void ButtonEmptyActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_ButtonEmptyActionPerformed
    {//GEN-HEADEREND:event_ButtonEmptyActionPerformed
        _equipageEnCours.Clear();
        InitListe(_equipageEnCours);
    }//GEN-LAST:event_ButtonEmptyActionPerformed

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
            java.util.logging.Logger.getLogger(DialogEquipage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DialogEquipage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DialogEquipage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DialogEquipage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DialogEquipage dialog = new DialogEquipage(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton ButtonAbandonner;
    private javax.swing.JButton ButtonAjoutEquipage;
    private javax.swing.JButton ButtonEmpty;
    private javax.swing.ButtonGroup ButtonGroupGrade;
    private javax.swing.JButton ButtonValider;
    private javax.swing.JLabel ErrorLabel;
    private javax.swing.JTextField InputDateNaissance;
    private javax.swing.JTextField InputNom;
    private javax.swing.JTextField InputPrenom;
    private javax.swing.JLabel LabelBateau;
    private javax.swing.JList<String> ListeMarins;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables

    private String getSelectedButtonText(ButtonGroup buttonGroup) {
        for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();

            if (button.isSelected()) {
                return button.getText();
            }
        }
        return null;
    }
    
    private void InitListe(Equipage equip)
    {
         DefaultListModel dlm = new DefaultListModel();
              
        if(equip.getCapitaine() != null)
        {
            dlm.addElement(equip.getCapitaine());
        }
        if(equip.getSecond()!= null)
        {
            dlm.addElement(equip.getSecond());
        }
        equip.getMarins().forEach(m -> dlm.addElement(m));
        
        ListeMarins.setModel(dlm);
        
    }

    public Equipage getEquipageEnCours()
    {
        return _equipageEnCours;
    }
            
    public DialogResult getResult() {
        return _result;
    }
}
