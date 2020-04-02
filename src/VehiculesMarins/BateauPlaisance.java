/******************************************************/
/*Auteur: Hendrick Samuel                             */
/*Groupe: 2203                                        */
/*Application: Inpres Harbour                         */
/*Date de creation: 25/03/2020                        */
/******************************************************/

package VehiculesMarins;

import Equipage.Equipage;
import Equipage.SailorWithoutIdentificationException;

public class BateauPlaisance extends Bateau{
    
    private String _permisNecessaire;
    
    public BateauPlaisance(String nom, String portattache,int longueur ,int tonnage, String pavillon,Equipage equipage ,boolean doesFloat, Energie energie, String permis) throws SailorWithoutIdentificationException, ShipWithoutIdentificationException 
    {
        super(nom, portattache, longueur, tonnage, pavillon,equipage ,doesFloat, energie);
        _permisNecessaire = permis;
    }
    
    public BateauPlaisance() throws SailorWithoutIdentificationException, ShipWithoutIdentificationException
    {
        super("Pas de nom", "0", 0, 0, "pas de pavillon", null, false, Energie.autre);
        _permisNecessaire = "aucun";
    }
    
    @Override
    public void Affiche()
    {
        super.Affiche();
        System.out.println("-- Bateau de plaisance --");
        System.out.println("Permis: "+ _permisNecessaire);
    }
}
