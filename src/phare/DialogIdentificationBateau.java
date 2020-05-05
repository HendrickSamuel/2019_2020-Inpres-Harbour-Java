/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phare;

import HarbourGlobal.DialogResult;
import HarbourGlobal.MyLogger;
import java.awt.Image;
import java.util.StringTokenizer;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author benka
 */
public class DialogIdentificationBateau extends javax.swing.JDialog {

    //<editor-fold defaultstate="collapsed" desc="Variables">
    private DialogResult _result = DialogResult.untouched;
    private MyLogger _logger;
    
    private String _nomBateau;
    private String _longueur;
    private String _pavillon;
    private String _typeBateau;
    private String chaineDelimiteurs = "/";
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Constructeurs">
    /**
     * Creates new form DialogIdentificationBateau
     */
    public DialogIdentificationBateau(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    
    public DialogIdentificationBateau(java.awt.Frame parent, boolean modal, String bateauIdentifie) {
        this(parent, modal);
        
        //<editor-fold defaultstate="collapsed" desc="Init des variables">
        this._logger = new MyLogger();
        System.out.println(_logger.Now() + " IdentificationBateau bateauIdentifie recu : " + bateauIdentifie);
        StringTokenizer parser = new StringTokenizer(bateauIdentifie, chaineDelimiteurs);
        int i = 0;
        while (parser.hasMoreTokens()) {
            if(i == 0)
               this._typeBateau = parser.nextToken().trim();
            else
                this._pavillon = parser.nextToken().trim();
            i++;
        }
        System.out.println(_logger.Now() + " IdentificationBateau Type recu : " + _typeBateau);
        System.out.println(_logger.Now() + " IdentificationBateau Pavillon recu : " + _pavillon);
        this.typeBateauLabel.setText(_typeBateau);
        this.pavilionLabel.setText(_pavillon);
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc="Init image pavillon">
        try
        {
            ImageIcon icon = new ImageIcon(getClass().getResource("/Images/pavillons/pavillon"+ this.getPavillon() +".png"));
            Image scaleImage = icon.getImage().getScaledInstance(150, 100,Image.SCALE_SMOOTH);
            this.imgPavillonLabel.setIcon(new javax.swing.ImageIcon(scaleImage));
            //<editor-fold defaultstate="collapsed" desc="GUI print">
            System.out.println(_logger.Now() + " IdentificationBateau | création de l'image du pavillion");
            //</editor-fold>
        }
        catch (Exception e)
        {
            ImageIcon icon = new ImageIcon(getClass().getResource("/Images/pavillons/pavillonInconnu.png"));
            Image scaleImage = icon.getImage().getScaledInstance(150, 100,Image.SCALE_SMOOTH);
            this.imgPavillonLabel.setIcon(new javax.swing.ImageIcon(scaleImage));
            //<editor-fold defaultstate="collapsed" desc="GUI print">
            System.out.println(_logger.Now() + " IdentificationBateau | création de l'image du bateau au pavillon inconnu");
            //</editor-fold>
        }
        //</editor-fold>
    }
    //</editor-fold>
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        pavilionLabel = new javax.swing.JLabel();
        imgPavillonLabel = new javax.swing.JLabel();
        typeBateauLabel = new javax.swing.JLabel();
        btnOk = new javax.swing.JButton();
        btnAnnuler = new javax.swing.JButton();
        nomBateauTF = new javax.swing.JTextField();
        longueurTF = new javax.swing.JTextField();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Phare - Identification d'un bateau en demande d'entrée");

        jLabel2.setText("Type de bateau :");

        jLabel3.setText("Pavillion :");

        jLabel4.setText("Nom du bateau :");

        jLabel5.setText("Longueur :");

        pavilionLabel.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        pavilionLabel.setText("Pavillon");

        imgPavillonLabel.setText("imgPavillion");

        typeBateauLabel.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        typeBateauLabel.setText("Type bateau");

        btnOk.setText("OK");
        btnOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOkActionPerformed(evt);
            }
        });

        btnAnnuler.setText("Annuler");
        btnAnnuler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnnulerActionPerformed(evt);
            }
        });

        nomBateauTF.setToolTipText("nom du bateau");

        longueurTF.setToolTipText("taille <= 15");
        longueurTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                longueurTFActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(193, 193, 193)
                        .addComponent(typeBateauLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3))
                        .addGap(83, 83, 83)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(147, 147, 147)
                                .addComponent(pavilionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                                .addComponent(imgPavillonLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(nomBateauTF, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(longueurTF, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(46, 46, 46))
            .addGroup(layout.createSequentialGroup()
                .addGap(116, 116, 116)
                .addComponent(btnOk, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(141, 141, 141)
                .addComponent(btnAnnuler)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(typeBateauLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel2)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(pavilionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(imgPavillonLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(nomBateauTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(longueurTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 19, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAnnuler)
                    .addComponent(btnOk))
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //<editor-fold defaultstate="collapsed" desc="Event">
    private void btnOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkActionPerformed
        System.out.println(_logger.Now() + " IdentificationBateau | Dans btn OK");
        String nom = this.nomBateauTF.getText();
        String longueur = this.longueurTF.getText();
        System.out.println(_logger.Now() + " IdentificationBateau | nom : " + nom + " , Taille : " + nom.length());
        System.out.println(_logger.Now() + " IdentificationBateau | longueur : " + longueur + " , Taille : " + longueur.length());
        if(nom.length() > 0 && longueur.length() > 0)
        {
            _result = DialogResult.ok;
            this.setNomBateau(nom);
            this.setLongueur(longueur);
            this.setVisible(false);            
        }  
    }//GEN-LAST:event_btnOkActionPerformed

    private void btnAnnulerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnnulerActionPerformed
        System.out.println(_logger.Now() + " IdentificationBateau | Dans btn Annuler");
        _result = DialogResult.cancel;
        this.setVisible(false);
    }//GEN-LAST:event_btnAnnulerActionPerformed

    private void longueurTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_longueurTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_longueurTFActionPerformed
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Méthodes">
    //<editor-fold defaultstate="collapsed" desc="Getters">
    public DialogResult getResult() {
        return _result;    
    }
    public MyLogger getLogger() {
        return _logger;
    }
    public String getNom() {
        return _nomBateau;
    }

    public String getLongueur() {
        return _longueur;
    }

    public String getPavillon() {
        return _pavillon;
    }
    public String getTypeBateau() {    
        return _typeBateau;
    }
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Setters">
    public void setResult(DialogResult result) {
        this._result = result;
    }
    public void setLogger(MyLogger logger) {
        this._logger = logger;
    }

    public void setNomBateau(String nomBateau) {
        this._nomBateau = nomBateau;
    }

    public void setLongueur(String longueur) {
        this._longueur = longueur;
    }

    public void setPavillon(String pavillon) {
        this._pavillon = pavillon;
    }

    public void setTypeBateau(String typeBateau) {
        this._typeBateau = typeBateau;
    }
    //</editor-fold>
    
    //</editor-fold>
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
            java.util.logging.Logger.getLogger(DialogIdentificationBateau.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DialogIdentificationBateau.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DialogIdentificationBateau.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DialogIdentificationBateau.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DialogIdentificationBateau dialog = new DialogIdentificationBateau(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnAnnuler;
    private javax.swing.JButton btnOk;
    private javax.swing.JLabel imgPavillonLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField longueurTF;
    private javax.swing.JTextField nomBateauTF;
    private javax.swing.JLabel pavilionLabel;
    private javax.swing.JLabel typeBateauLabel;
    // End of variables declaration//GEN-END:variables
}
