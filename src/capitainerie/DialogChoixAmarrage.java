/******************************************************/
/*Auteur: Hendrick Samuel & Khamana Benedict          */
/*Groupe: 2203                                        */
/*Application: Inpres Harbour                         */
/*Date de creation: 08/05/2020                        */
/******************************************************/
package capitainerie;

import Amarrages.Amarrage;
import Amarrages.Ponton;
import Amarrages.Quai;
import HarbourGlobal.DialogResult;
import VehiculesMarins.Bateau;
import VehiculesMarins.BateauPlaisance;
import VehiculesMarins.MoyenDeTransportSurEau;
import java.util.Enumeration;       
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

public class DialogChoixAmarrage extends javax.swing.JDialog {
   
    private Vector<Amarrage> _amarrages;
    private String _type;
    
    private String _choixAmarrage;
    private String _choixEmplacement;
    
    private DialogResult _result = DialogResult.untouched;
    
    public DialogChoixAmarrage(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
   
    public DialogChoixAmarrage(java.awt.Frame parent, boolean modal, Vector<Amarrage> listeAmarrages,String typeBateau)
    {
        this(parent,modal);
        _amarrages = listeAmarrages;
        _type = typeBateau.toUpperCase();
        _type = _type.replaceAll("\\s+",""); // enleve les espaces
        
        InitTable();
        
        ButtonChoose.setEnabled(false); // disable le bouton pour eviter le choix d'un amarrage utilisé
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        TableAmarrages = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        SelectedEmplacement = new javax.swing.JLabel();
        ButtonChoose = new javax.swing.JButton();
        ButtonCancel = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Choix d'un amarrage");
        setResizable(false);

        TableAmarrages.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "???", "Emplacement", "Bateau", "port d'attache", "Date d'arrivée"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TableAmarrages.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableAmarragesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TableAmarrages);

        jLabel1.setText("Emplacement:");

        ButtonChoose.setText("Choisir");
        ButtonChoose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonChooseActionPerformed(evt);
            }
        });

        ButtonCancel.setText("Annuler");
        ButtonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonCancelActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Choix des amarrages");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ButtonChoose)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ButtonCancel))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(SelectedEmplacement, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(99, 99, 99))
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 698, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel2)
                .addGap(40, 40, 40)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(SelectedEmplacement))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ButtonChoose)
                    .addComponent(ButtonCancel))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TableAmarragesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableAmarragesMouseClicked
        int ligne = TableAmarrages.getSelectedRow();

        int indexEmplacement = (int)TableAmarrages.getValueAt(ligne,1);
        String nomBateau = (String)TableAmarrages.getValueAt(ligne,3);
        
        String amarrage = (String)TableAmarrages.getValueAt(ligne-(indexEmplacement-1),0);
        String local =  amarrage+"*"+indexEmplacement;
        
        _choixEmplacement = Integer.toString(indexEmplacement);
        _choixAmarrage = amarrage;

        SelectedEmplacement.setText(local);
        
        if(nomBateau.compareTo("") == 0)
            ButtonChoose.setEnabled(true);
        else
            ButtonChoose.setEnabled(false);
            
            
    }//GEN-LAST:event_TableAmarragesMouseClicked

    private void ButtonChooseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonChooseActionPerformed
        setResult(DialogResult.ok);
        this.setVisible(false);
    }//GEN-LAST:event_ButtonChooseActionPerformed

    private void ButtonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonCancelActionPerformed
        setResult(DialogResult.cancel);
        this.setVisible(false);
    }//GEN-LAST:event_ButtonCancelActionPerformed

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
            java.util.logging.Logger.getLogger(DialogChoixAmarrage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DialogChoixAmarrage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DialogChoixAmarrage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DialogChoixAmarrage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(() -> {
            DialogChoixAmarrage dialog = new DialogChoixAmarrage(new javax.swing.JFrame(), true);
            dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    System.exit(0);
                }
            });
            dialog.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonCancel;
    private javax.swing.JButton ButtonChoose;
    private javax.swing.JLabel SelectedEmplacement;
    private javax.swing.JTable TableAmarrages;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    private void InitTable()
    { 
        System.out.println("TYPE EST: " + _type);
        
        if(_type.compareTo("PLAISANCE") == 0)
            TableAmarrages.getColumnModel().getColumn(0).setHeaderValue("Ponton(s)");
        else if(_type.compareTo("PECHE") == 0)
            TableAmarrages.getColumnModel().getColumn(0).setHeaderValue("Quai(s)");
        
        Enumeration enu = _amarrages.elements();
        while(enu.hasMoreElements())
        {
            Amarrage am = (Amarrage)enu.nextElement();
            if(_type.compareTo("PLAISANCE") == 0 && am instanceof Ponton)
                AjouterPonton((Ponton)am);
            else
            if(_type.compareTo("PECHE") == 0 && am instanceof Quai)
                AjouterQuai((Quai)am);
        }
    }

    private void AjouterPonton(Ponton ponton)
    {
        Vector ligne;
        DefaultTableModel dtm = (DefaultTableModel)this.TableAmarrages.getModel();
        
        for(int y = 1; y <= 2; y++)
        {
            MoyenDeTransportSurEau[] mte = ponton.getListe(y);
            for(int i = 0; i < mte.length; i++)
            {
                Bateau bp = (Bateau)mte[i];
                ligne = new Vector();
                if(i == 0)
                    ligne.add(ponton.getIdentifiant()+y);
                else
                    ligne.add("");

                ligne.add(i+1);

                if(bp != null)
                {
                    ligne.add(bp.getNom());
                    ligne.add(bp.getPortAttache());
                    ligne.add(bp.GetDateArrivee());
                }
                else
                {
                    ligne.add("");
                    ligne.add("");
                    ligne.add("");
                }
                dtm.addRow(ligne);
            }
        }
    }

    private void AjouterQuai(Quai quai)
    {
        Vector ligne;
        DefaultTableModel dtm = (DefaultTableModel)this.TableAmarrages.getModel();
        
        MoyenDeTransportSurEau[] mte = quai.getListe();
        for(int i = 0; i < mte.length; i++)
        {
            Bateau bp = (Bateau)mte[i];
            ligne = new Vector();
            if(i == 0)
                ligne.add(quai.getIdentifiant());
            else
                ligne.add("");

            ligne.add(i+1);

            if(bp != null)
            {
                ligne.add(bp.getNom());
                ligne.add(bp.getPortAttache());
                ligne.add(bp.GetDateArrivee());
            }
            else
            {
                ligne.add("");
                ligne.add("");
                ligne.add("");
            }
            dtm.addRow(ligne);
        }
    }
    
    public DialogResult getResult() {
        return _result;
    }

    public void setResult(DialogResult result) {
        _result = result;
    }

    public String getChoixAmarrage() {
        return _choixAmarrage;
    }

    public String getChoixEmplacement() {
        return _choixEmplacement;
    }
}
