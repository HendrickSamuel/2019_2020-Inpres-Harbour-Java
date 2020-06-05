/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phare.beans;

public class ThreadRandomGenerator extends Thread {

    private UtilisateurNombre utilisateurThread;
    private int borneInferieure, borneSuperieure, multipleDeclenchement, tempsPause;
    private int nombreProduit;

    public ThreadRandomGenerator() {
        this(null, 1, 500, 2, 1);
    }

    public ThreadRandomGenerator(UtilisateurNombre un, int bi, int bs, int md, int tp) {
        utilisateurThread = un;
        borneInferieure = bi;
        borneSuperieure = bs;
        multipleDeclenchement = md;
        tempsPause = tp;
        nombreProduit = -1;
    }

    public void setUtilisateurNombre(UtilisateurNombre un) {
        utilisateurThread = un;
    }

    public void run() {
        Double dr;
        while (true) {
            dr = new Double(borneInferieure + Math.random() * (borneSuperieure - borneInferieure));

            nombreProduit = dr.intValue();
            System.out.println(utilisateurThread.getIdentifiant() + "> nombreProduit = " + nombreProduit);
            if (nombreProduit % multipleDeclenchement == 0) {
                System.out.println(utilisateurThread.getIdentifiant() + "> -------------- !!!!!!! " + nombreProduit + "!!!!");
                if (utilisateurThread != null)
                    utilisateurThread.traiteNombre(nombreProduit);
                else
                    System.out.println("Erreur de récepteur mal configuré");
            }
            try {
                Thread.sleep(tempsPause * 1000);
            } catch (InterruptedException e) {
                System.out.println("Erreur de thread interrompu : " + e.getMessage());
            }
        }
    }
}