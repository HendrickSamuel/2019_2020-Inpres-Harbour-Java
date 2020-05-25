/******************************************************/
/*Auteur: Hendrick Samuel & Khamana Benedict          */
/*Groupe: 2203                                        */
/*Application: Inpres Harbour                         */
/*Date de creation: 25/03/2020                        */
/******************************************************/

package Equipage;

import HarbourGlobal.AUnIdentifiant;
import java.io.Serializable;

public class Marin extends Humain implements AUnIdentifiant, Serializable{
    
    private String _fonction;
    
    public Marin(String nom, String prenom, String datenaissance, String fonction) throws SailorWithoutIdentificationException
    {
        super(nom, prenom, datenaissance);
        if(nom.length() < 1 || prenom.length() < 1)
        {
            throw new SailorWithoutIdentificationException("pas de nom ou prenom");
        }
        _fonction = fonction;
    }
    
    public Marin(Marin old)
    {
        super(old.getNom(), old.getPrenom(), old.getDateNaissance());
        _fonction = old.getFonction();
    }

    public String getFonction() {
        return _fonction;
    }

    public void setFonction(String fonction) {
        _fonction = fonction;
    }
    
    @Override
    public String toString()
    {
        return getFonction() + " : " + getNom() + " " + getPrenom();
    }
    
    @Override
    public String getIdentifiant()
    {
        return getNom()+getPrenom()+getDateNaissance();
    }
}
