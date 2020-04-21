package inpresharbour;

import Equipage.Marin;
import VehiculesMarins.*;


public class InpresHarbour {

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
