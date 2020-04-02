/******************************************************/
/*Auteur: Hendrick Samuel                             */
/*Groupe: 2203                                        */
/*Application: Inpres Harbour                         */
/*Date de creation: 25/03/2020                        */
/******************************************************/

package Amarrages;

import VehiculesMarins.*;
import java.util.Vector;

public class Quai extends Amarrage
{
    private Vector<MoyenDeTransportSurEau> _liste;
    
    public Quai(int capacite)
    {
        super(capacite);
        _liste = new Vector<MoyenDeTransportSurEau>();
    }
    
    @Override
    public String getIdentifiant() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
