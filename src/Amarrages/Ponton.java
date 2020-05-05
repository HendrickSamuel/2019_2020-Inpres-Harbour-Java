/******************************************************/
/*Auteur: Hendrick Samuel & Khamana Benedict          */
/*Groupe: 2203                                        */
/*Application: Inpres Harbour                         */
/*Date de creation: 25/03/2020                        */
/******************************************************/

package Amarrages;

import VehiculesMarins.*;
import java.io.Serializable;

public class Ponton extends Amarrage
{
    MoyenDeTransportSurEau[][] _liste;
    
    public Ponton(int id, int capacite)
    {
        super(id, capacite);
        _liste = new MoyenDeTransportSurEau[2][capacite]; 
    }
    
    @Override
    public String getIdentifiant() {
        return "P"+ _idNumder;
    }
    
    public void Affiche()
    {
        System.out.println(getIdentifiant());
    }
    
    @Override
    public String toString()
    {
        return getIdentifiant();
    }
    
    public MoyenDeTransportSurEau[] getListe(int cote)
    {
        cote --;
        
        switch (cote)
        {
            case 0:
                return _liste[0];
            case 1:
                return _liste[1];
            default:
                return null;
        }
    }
    
}
