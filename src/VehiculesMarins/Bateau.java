/******************************************************/
/*Auteur: Hendrick Samuel                             */
/*Groupe: 2203                                        */
/*Application: Inpres Harbour                         */
/*Date de creation: 25/03/2020                        */
/******************************************************/

package VehiculesMarins;

import Equipage.*;
import HarbourGlobal.AUnIdentifiant;

public class Bateau extends MoyenDeTransportSurEau implements AUnIdentifiant{

/* ----------------------------------- VARIABLES ------------------------------------*/
    protected String _nom;
    protected String _portAttache;
    protected int _longueur;
    private int _tonnage;
    protected String _pavillon; // nationalité
    protected Equipage _equipage;

/* ----------------------------------- CONSTRUCTEURS ------------------------------------*/
    public Bateau(String nom, String portattache,int longueur ,int tonnage, String pavillon ,Equipage equipage,boolean doesFloat, Energie energie) throws SailorWithoutIdentificationException, ShipWithoutIdentificationException 
    {
        super(doesFloat, energie);
        if(nom.length() < 1 || portattache.length() <1)
            throw new ShipWithoutIdentificationException("pas de nom ou port d'attache ");
            
        _nom = nom;
        _portAttache = portattache;
        _longueur = longueur;
        setTonnage(tonnage);
        _pavillon = pavillon;
        _equipage = equipage;
    }
    
    public Bateau(String nom, String portattache,int longueur ,int tonnage, String pavillon) throws SailorWithoutIdentificationException, ShipWithoutIdentificationException
    {
        this(nom, portattache, longueur, tonnage, pavillon, new Equipage(), false, Energie.essence); // constructeur simplifié pour ajout de l'equipage par la suite
    }
    
/* ----------------------------------- METHODES ------------------------------------*/

    public void Affiche()
    {
        System.out.println("-----------Bateau-----------");
        System.out.println("Nom: " + _nom);
        System.out.println("Port attache: " + _portAttache);
        System.out.println("Longueur: " + _longueur);
        System.out.println("Tonnage: " + getTonnage());
        System.out.println("Pavillon: " + _pavillon);
        System.out.println("----------------------------");
        //System.out.println("Equipage: " + _equipage);  
    }
    
    @Override
    public String toString()
    {
        return getNom() + " -- indéfini -- " + getPavillon();
    }
    
/* ----------------------------------- GETTERS ------------------------------------*/
    @Override
    public String getIdentifiant()
    {
        String id;
        id = _nom + _portAttache;
        return id;
    }

    @Override
    public int getNombreHumains() 
    {
        return getEquipage().getMarins().size();
    }
    
    public Equipage getEquipage() 
    {
        return _equipage;
    }

    public int getTonnage() {
        return _tonnage;
    }
    
    public String getNom()
    {
        return _nom;
    }

    public String getPavillon()
    {
        return _pavillon;
    }
    /* ----------------------------------- SETTERS ------------------------------------*/
    public void setEquipage(Equipage _equipage) 
    {
        this._equipage = _equipage;
    }
    
    public void setTonnage(int _tonnage) {
        this._tonnage = _tonnage;
    }
    
}
