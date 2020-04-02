/******************************************************/
/*Auteur: Hendrick Samuel                             */
/*Groupe: 2203                                        */
/*Application: Inpres Harbour                         */
/*Date de creation: 25/03/2020                        */
/******************************************************/

package VehiculesMarins;

public abstract class MoyenDeTransportSurEau extends MoyenDeTransport
{
    public boolean isSubmersible;
    
    public MoyenDeTransportSurEau(boolean doesFloat, Energie energie)
    {
        super(energie);
        isSubmersible = doesFloat;
    }
}
