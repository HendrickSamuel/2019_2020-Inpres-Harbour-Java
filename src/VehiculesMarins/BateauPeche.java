/******************************************************/
/*Auteur: Hendrick Samuel                             */
/*Groupe: 2203                                        */
/*Application: Inpres Harbour                         */
/*Date de creation: 25/03/2020                        */
/******************************************************/

package VehiculesMarins;

import Equipage.Equipage;
import Equipage.SailorWithoutIdentificationException;

public class BateauPeche extends Bateau{
    
    private String _type;
    
    public BateauPeche(String nom, String portattache,int longueur ,int tonnage, String pavillon ,boolean doesFloat,Equipage equipage ,Energie energie, String type) throws SailorWithoutIdentificationException, ShipWithoutIdentificationException 
    {
        super(nom, portattache, longueur, tonnage, pavillon, equipage ,doesFloat, energie);
        _type = type;
    }

    public BateauPeche() throws SailorWithoutIdentificationException, ShipWithoutIdentificationException
    {
        super("Pas de nom", "0", 0, 0, "pas de pavillon", new Equipage(), false, Energie.autre);
        _type = "aucun";
    }
    
    @Override
    public void Affiche()
    {
        super.Affiche();
        System.out.println("-- Bateau de peche --");
        System.out.println("Type: "+getType());
        System.out.println("nbequip: " +getNombreHumains());
        
    }

    public String getType() {
        return _type;
    }

    public void setType(String _type) {
        this._type = _type;
    }
}
