/******************************************************/
/*Auteur: Hendrick Samuel                             */
/*Groupe: 2203                                        */
/*Application: Inpres Harbour                         */
/*Date de creation: 25/03/2020                        */
/******************************************************/

package Amarrages;

import VehiculesMarins.*;
import java.util.Vector;

public class Ponton extends Amarrage
{
    MoyenDeTransportSurEau[][] _liste;
    
    public Ponton(int capacite)
    {
        super(capacite);
        _liste = new MoyenDeTransportSurEau[2][capacite]; 
    }
    
    @Override
    public String getIdentifiant() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    
    public MoyenDeTransportSurEau[] getListe(int cote)
    {
        if(cote == 1)
            return _liste[1];
        else
            return _liste[2];
    }
    
}
