/******************************************************/
/*Auteur: Hendrick Samuel                             */
/*Groupe: 2203                                        */
/*Application: Inpres Harbour                         */
/*Date de creation: 25/03/2020                        */
/******************************************************/

package Amarrages;

import VehiculesMarins.MoyenDeTransportSurEau;
import java.util.Vector;

public class Ponton extends Amarrage
{
    Vector<MoyenDeTransportSurEau> _gauche;
    Vector<MoyenDeTransportSurEau> _droite;
    
    public Ponton(int capacite)
    {
        super(capacite);
        _gauche = new Vector<MoyenDeTransportSurEau>();
        _droite = new Vector<MoyenDeTransportSurEau>();
        
        
    }
    
    @Override
    public String getIdentifiant() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public Vector<MoyenDeTransportSurEau> getListe(int cote)
    {
        if(cote == 1)
            return _gauche;
        else
            return _droite;
    }
    
}
