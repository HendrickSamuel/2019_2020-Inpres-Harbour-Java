/******************************************************/
/*Auteur: Hendrick Samuel & Khamana Benedict          */
/*Groupe: 2203                                        */
/*Application: Inpres Harbour                         */
/*Date de creation: 25/03/2020                        */
/******************************************************/

package VehiculesMarins;

import java.io.Serializable;

public abstract class MoyenDeTransportSurEau extends MoyenDeTransport implements Serializable
{
    public boolean isSubmersible;
    
    public MoyenDeTransportSurEau(boolean doesFloat, Energie energie)
    {
        super(energie);
        isSubmersible = !doesFloat;
    }
}
