/******************************************************/
/*Auteur: Hendrick Samuel & Khamana Benedict          */
/*Groupe: 2203                                        */
/*Application: Inpres Harbour                         */
/*Date de creation: 25/03/2020                        */
/******************************************************/

package Amarrages;

import VehiculesMarins.*;
import java.util.Vector;

public class Quai extends Amarrage
{
    private MoyenDeTransportSurEau[] _liste;
    
    public Quai(int id, int capacite)
    {
        super(id, capacite);
        _liste = new MoyenDeTransportSurEau[capacite];
    }
    
    @Override
    public String getIdentifiant() {
        return "Q"+_idNumder;
    }
    
     @Override
    public String toString()
    {
        return getIdentifiant();
    }

    public MoyenDeTransportSurEau[] getListe()
    {
        return _liste;
    }

    public void setListe(MoyenDeTransportSurEau[] _liste)
    {
        this._liste = _liste;
    }
    
}
