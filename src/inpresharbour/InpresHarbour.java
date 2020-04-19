/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inpresharbour;

import Equipage.Marin;
import VehiculesMarins.*;


public class InpresHarbour {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try 
        {
            BateauPeche _bateau = new BateauPeche();
            //_bateau.setEquipage(_bateau.getEquipage().AjoutMarin(new Marin("jean", "dupont", "rt", "dfg")));
            _bateau.Affiche();
        } catch (Exception e) 
        {
            System.out.println(e.getMessage());
        }
        
    }
    
}
