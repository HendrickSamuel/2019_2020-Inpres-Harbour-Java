/******************************************************/
/*Auteur: Hendrick Samuel                             */
/*Groupe: 2203                                        */
/*Application: Inpres Harbour                         */
/*Date de creation: 25/03/2020                        */
/******************************************************/

package Equipage;

import HarbourGlobal.AUnIdentifiant;

public class Humain implements AUnIdentifiant{

    private String _nom;
    private String _prenom;
    private String _dateNaissance;
    
    public Humain(String nom, String prenom, String datenaissance )
    {
        _nom = nom;
        _prenom = prenom;
        _dateNaissance = datenaissance;
    }
    
    @Override
    public String getIdentifiant() {
        String id;
        id = getNom() + getPrenom() + getDateNaissance();
        return id;
    }

    public String getNom() {
        return _nom;
    }

    public void setNom(String _nom) {
        this._nom = _nom;
    }

    public String getPrenom() {
        return _prenom;
    }

    public void setPrenom(String _prenom) {
        this._prenom = _prenom;
    }

    public String getDateNaissance() {
        return _dateNaissance;
    }

    public void setDateNaissance(String _dateNaissance) {
        this._dateNaissance = _dateNaissance;
    }
    
}
