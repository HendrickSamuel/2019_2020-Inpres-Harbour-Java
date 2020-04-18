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
    
    public Equipage()
    {
        _marins = new Vector<Marin>();
    }
    
    public Equipage(Equipage old)
    {
        if(old.getCapitaine() != null)
            _capitaine = new Marin(old.getCapitaine());
        if(old.getSecond() != null)
            _second = new Marin(old.getSecond());
        
        _marins = new Vector<Marin>();
        
        old.getMarins().forEach(m -> AjoutMarin(m));
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
        _marins.add(marin); // verifier le rang 
    }

    public Vector<Marin> getMarins() {
        return _marins;
    }

    public void setMarins(Vector<Marin> marins) {
        _marins = marins;
    }

    public Marin getCapitaine()
    {
        return _capitaine;
    }

    public void setCapitaine(Marin capitaine)
    {
        this._capitaine = capitaine;
    }

    public Marin getSecond()
    {
        return _second;
    }

    public void setSecond(Marin second)
    {
        this._second = second;
    }
    
    public void Clear()
    {
        setCapitaine(null);
        setSecond(null);
        setMarins(new Vector<Marin>());
    }
    
    public boolean AjoutMembre(Marin marin)
    {   
        if(marin.getFonction().compareTo("Capitaine") == 0)
        {   
            if(getCapitaine() == null)
            {
                setCapitaine(marin);
                return true;
            }
            else
            {
                return false;
            }
        }
        else
        if (marin.getFonction().compareTo("Second") == 0)
        {
            if(getSecond() == null)
            {
                setSecond(marin);
                return true;
            }
            else
            {
                return false;
            }
        }
        else    
        {
            // verifier l'ID
            getMarins().add(marin);
            return true;
        }
    } 
}
