/******************************************************/
/*Auteur: Hendrick Samuel                             */
/*Groupe: 2203                                        */
/*Application: Inpres Harbour                         */
/*Date de creation: 25/03/2020                        */
/******************************************************/
package Equipage;

import java.util.Vector;

public class Equipage {
    private Vector<Marin> _marins;
    private Marin _capitaine;
    private Marin _second;
    
    public Equipage() throws SailorWithoutIdentificationException
    {
        _marins = new Vector<Marin>();
        //_marins.add(new Marin("test","test","test","pd")); 
    }
    
    public Equipage(Marin capitaine, Marin second, Vector<Marin> equipage)
    {
        _capitaine = capitaine;
        _second = second;
        if(equipage != null)
            _marins = equipage;
        else
            _marins = new Vector<Marin>();
    }
    
    public void AjoutMarin(Marin marin)
    {
        _marins.add(marin);
    }

    public Vector<Marin> getMarins() {
        return _marins;
    }

    public void setMarins(Vector<Marin> marins) {
        _marins = marins;
    }

    
    
}
