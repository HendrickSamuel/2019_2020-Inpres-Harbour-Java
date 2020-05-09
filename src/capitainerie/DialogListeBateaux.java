/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capitainerie;

import Amarrages.Amarrage;
import Amarrages.Ponton;
import Amarrages.Quai;
import VehiculesMarins.Bateau;
import VehiculesMarins.BateauPlaisance;
import VehiculesMarins.MoyenDeTransportSurEau;
import static com.sun.xml.internal.fastinfoset.alphabet.BuiltInRestrictedAlphabets.table;
import java.awt.List;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Vector;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author hydro
 */
public class DialogListeBateaux extends javax.swing.JDialog {

    private ArrayList<String> test;
    
    public DialogListeBateaux(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    
    public DialogListeBateaux(java.awt.Frame parent, boolean modal, Vector<Amarrage> listeAmarrages) {
        this(parent, modal);
        InitListe(listeAmarrages);
    }
    
    private void InitListe(Vector<Amarrage> listeAmarrages)
    {
         Enumeration enu = listeAmarrages.elements();
        while(enu.hasMoreElements())
        {
            Amarrage am = (Amarrage)enu.nextElement();
            if(am instanceof Ponton)
                AjouterPonton((Ponton)am);
            else
            if(am instanceof Quai)
            AjouterQuai((Quai)am);
        }
        
        TableRowSorter<TableModel> sorter = new TableRowSorter<>(TableBateaux.getModel());
        TableBateaux.setRowSorter(sorter);
        
        ArrayList<RowSorter.SortKey> sortKeys = new ArrayList<>();

        sortKeys.add(new RowSorter.SortKey(0, SortOrder.ASCENDING)); // tri ordonné sur le nom du bateau (index 0) 
        
        sortKeys.add(new RowSorter.SortKey(1, SortOrder.ASCENDING)); // et tri ordonné sur le port d'attache du bateau (index 1)
        
        sorter.setSortKeys(sortKeys);
        sorter.sort();
    }
    
    private void AjouterPonton(Ponton ponton)
    {
        Vector ligne;
        
        DefaultTableModel dtm = (DefaultTableModel)this.TableBateaux.getModel();
        
        for(int y = 1; y <= 2; y++)
        {
            MoyenDeTransportSurEau[] mte = ponton.getListe(y);
            for(int i = 0; i < mte.length; i++)
            {
                Bateau bp = (Bateau)mte[i];
                if(bp != null)
                {
                    ligne = new Vector();
                    ligne.add(bp.getNom());
                    ligne.add(bp.getPortAttache()); // port attache
                    ligne.add(ponton.getIdentifiant()+y + "*" + (i+1));
                    
                    dtm.addRow(ligne);
                }

            }
        }
    }

    private void AjouterQuai(Quai quai)
    {
        Vector ligne;
        DefaultTableModel dtm = (DefaultTableModel)this.TableBateaux.getModel();
        
        MoyenDeTransportSurEau[] mte = quai.getListe();
        for(int i = 0; i < mte.length; i++)
        {
            Bateau bp = (Bateau)mte[i];
            if(bp != null)
            {
                ligne = new Vector();

                ligne.add(bp.getNom());
                ligne.add(bp.getPortAttache());
                ligne.add(quai.getIdentifiant() + "*"+(i+1));            
                
                dtm.addRow(ligne);
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        TableBateaux = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        TableBateaux.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nom du bateau", "Port d'attache", "Amarrage"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(TableBateaux);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 568, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 134, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(DialogListeBateaux.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DialogListeBateaux.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DialogListeBateaux.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DialogListeBateaux.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DialogListeBateaux dialog = new DialogListeBateaux(new javax.swing.JFrame(), true);
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
    private javax.swing.JTable TableBateaux;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}