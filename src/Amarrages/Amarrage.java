/******************************************************/
/*Auteur: Hendrick Samuel                             */
/*Groupe: 2203                                        */
/*Application: Inpres Harbour                         */
/*Date de creation: 25/03/2020                        */
/******************************************************/

package Amarrages;

import HarbourGlobal.AUnIdentifiant;

public abstract class Amarrage implements AUnIdentifiant
{
    protected int _capacite;

    public Amarrage() 
    {
        _capacite = 0;
    }
    
    public Amarrage(int capacite)
    {
        _capacite = capacite;
    }
    
    public int getCapacite()
    {
        return _capacite;
    }
}
