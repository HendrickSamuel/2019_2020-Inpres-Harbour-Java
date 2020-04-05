/******************************************************/
/*Auteur: Hendrick Samuel                             */
/*Groupe: 2203                                        */
/*Application: Inpres Harbour                         */
/*Date de creation: 25/03/2020                        */
/******************************************************/

package Equipage;

public class Marin extends Humain{
    
    private String _fonction;
    
    public Marin(String nom, String prenom, String datenaissance, String fonction) throws SailorWithoutIdentificationException
    {
        super(nom, prenom, datenaissance);
        if(nom == null || prenom == null)
        {
            throw new SailorWithoutIdentificationException("pas de nom ou prenom");
        }
        _fonction = fonction;
    }

    public String getFonction() {
        return _fonction;
    }

    public void setFonction(String fonction) {
        _fonction = fonction;
    }
    
}
