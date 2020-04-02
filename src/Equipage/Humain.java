/******************************************************/
/*Auteur: Hendrick Samuel                             */
/*Groupe: 2203                                        */
/*Application: Inpres Harbour                         */
/*Date de creation: 25/03/2020                        */
/******************************************************/

package Equipage;

import HarbourGlobal.AUnIdentifiant;

public class Humain implements AUnIdentifiant{

    protected String _nom;
    protected String _prenom;
    protected String _dateNaissance;
    
    public Humain(String nom, String prenom, String datenaissance )
    {
        _nom = nom;
        _prenom = prenom;
        _dateNaissance = datenaissance;
    }
    
    @Override
    public String getIdentifiant() {
        String id;
        id = _nom + _prenom + _dateNaissance;
        return id;
    }
    
}
