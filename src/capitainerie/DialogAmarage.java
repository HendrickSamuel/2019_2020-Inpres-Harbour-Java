/******************************************************/
/*Auteur: Hendrick Samuel & Khamana Benedict          */
/*Groupe: 2203                                        */
/*Application: Inpres Harbour                         */
/*Date de creation:13/04/2020                         */
/******************************************************/
package capitainerie;

import Equipage.Equipage;
import HarbourGlobal.DialogResult;
import HarbourGlobal.MyLogger;
import VehiculesMarins.*;
import java.awt.Image;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;


public class DialogAmarage extends javax.swing.JDialog {

    public
            Bateau getBateauEnCours()
    {
        return _bateauEnCours;
    }

    private DialogResult _result = DialogResult.untouched;
    private Bateau _bateauEnCours;
    private MyLogger _logger;
    
    public DialogAmarage(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    
    public DialogAmarage(Bateau bateau, String emplacement, java.awt.Frame parent, boolean modal) {
        this(parent, modal);
        
        _logger = new MyLogger();
        _bateauEnCours = bateau;
           
        //System.out.println(amarrage.getClass().getName()); // Amarrages.Ponton ou Amarrages.Quai
        
        InitCombobox(_bateauEnCours.getEquipage());        
        LabelEmplacement.setText(emplacement);
        LabelNomBateau.setText(bateau.getNom()); 
        
        this.setTitle("Gestion Amarrage: "+ bateau.getNom());
        
        try
        {
            ImageIcon icon = new ImageIcon(getClass().getResource("/Images/pavillons/pavillon"+getBateauEnCours().getPavillon()+".png"));
            Image scaleImage = icon.getImage().getScaledInstance(150, 100,Image.SCALE_DEFAULT);
            ImagePavillon.setIcon(new javax.swing.ImageIcon(scaleImage));
            //<editor-fold defaultstate="collapsed" desc="GUI print">
            System.out.println(_logger.Now() + " | création de l'image du bateau");
            //</editor-fold>
        }
        catch (Exception e)
        {
            ImageIcon icon = new ImageIcon(getClass().getResource("/Images/pavillons/pavillonInconnu.png"));
            Image scaleImage = icon.getImage().getScaledInstance(150, 100,Image.SCALE_DEFAULT);
            ImagePavillon.setIcon(new javax.swing.ImageIcon(scaleImage));
            //<editor-fold defaultstate="collapsed" desc="GUI print">
            System.out.println(_logger.Now() + " | création de l'image du bateau au pavillon inconnu");
            //</editor-fold>
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        ButtonEqupiage = new javax.swing.JButton();
        ComboBoxMarins = new javax.swing.JComboBox<>();
        InputTonnage = new javax.swing.JTextField();
        InputPortAttache = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        OkButton = new javax.swing.JButton();
        CancelButton = new javax.swing.JButton();
        LabelEmplacement = new javax.swing.JLabel();
        LabelNomBateau = new javax.swing.JLabel();
        ImagePavillon = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jLabel1.setText("Emplacement:");

        jLabel2.setText("Bateau:");

        jLabel3.setText("Pavillon:");

        jLabel4.setText("Port d'attache:");

        jLabel5.setText("Tonnage:");

        ButtonEqupiage.setText("Equipage");
        ButtonEqupiage.setToolTipText("");
        ButtonEqupiage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonEqupiageActionPerformed(evt);
            }
        });

        OkButton.setText("OK");
        OkButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OkButtonActionPerformed(evt);
            }
        });

        CancelButton.setText("Cancel");
        CancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelButtonActionPerformed(evt);
            }
        });

        LabelEmplacement.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        LabelEmplacement.setText("Emplacement du bateau");

        LabelNomBateau.setText("Nom du bateau");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ButtonEqupiage)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(InputTonnage, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ComboBoxMarins, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(InputPortAttache, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(68, 68, 68)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(LabelEmplacement, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(LabelNomBateau, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ImagePavillon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addComponent(OkButton)
                        .addGap(47, 47, 47)
                        .addComponent(CancelButton)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(LabelEmplacement))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(LabelNomBateau))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 99, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(ImagePavillon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(InputPortAttache, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(InputTonnage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ButtonEqupiage)
                    .addComponent(ComboBoxMarins, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(OkButton)
                    .addComponent(CancelButton))
                .addGap(47, 47, 47))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    /* ----------------------- EVENTS LISTENER ------------------------- */
    private void ButtonEqupiageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonEqupiageActionPerformed
        DialogEquipage de = new DialogEquipage(getBateauEnCours(),(java.awt.Frame)getParent(), true);
        de.setVisible(true);
        // recuperer equipage en cours
        if(de.getResult() == DialogResult.ok)
        {
            Equipage equip = de.getEquipageEnCours();
            getBateauEnCours().setEquipage(equip);
            
            InitCombobox(equip);
        }
    }//GEN-LAST:event_ButtonEqupiageActionPerformed

    private void OkButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OkButtonActionPerformed
        _result = DialogResult.ok;
        
        _bateauEnCours.setPortAttache(InputPortAttache.getText());
        _bateauEnCours.setTonnage(Integer.parseInt(InputTonnage.getText()));
        
        this.setVisible(false);
    }//GEN-LAST:event_OkButtonActionPerformed

    private void CancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelButtonActionPerformed
        _result = DialogResult.cancel;
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
            java.util.logging.Logger.getLogger(DialogAmarage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DialogAmarage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DialogAmarage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DialogAmarage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DialogAmarage dialog = new DialogAmarage(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton ButtonEqupiage;
    private javax.swing.JButton CancelButton;
    private javax.swing.JComboBox<String> ComboBoxMarins;
    private javax.swing.JLabel ImagePavillon;
    private javax.swing.JTextField InputPortAttache;
    private javax.swing.JTextField InputTonnage;
    private javax.swing.JLabel LabelEmplacement;
    private javax.swing.JLabel LabelNomBateau;
    private javax.swing.JButton OkButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables

    
    public DialogResult getResult() {
        return _result;
    }
    
    private void InitCombobox(Equipage equipage)
    {
        DefaultComboBoxModel dcbm = (DefaultComboBoxModel) this.ComboBoxMarins.getModel();
        dcbm.removeAllElements();
        
        if(equipage.getCapitaine() != null)
            dcbm.addElement(equipage.getCapitaine());

        if(equipage.getSecond() != null)
            dcbm.addElement(equipage.getSecond());

        equipage.getMarins().forEach(m -> dcbm.addElement(m));

        ComboBoxMarins.setModel(dcbm);
    }
}
