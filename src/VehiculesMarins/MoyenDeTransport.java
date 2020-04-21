/******************************************************/
/*Auteur: Hendrick Samuel & Khamana Benedict          */
/*Groupe: 2203                                        */
/*Application: Inpres Harbour                         */
/*Date de creation: 25/03/2020                        */
/******************************************************/

package VehiculesMarins;

public abstract class MoyenDeTransport implements AvecHumains
{
    private Energie _energie;
    
    public MoyenDeTransport(Energie energie)
    {
        _energie = energie;
    }
    
    public MoyenDeTransport()
    {
        this(Energie.autre);
    }
}
