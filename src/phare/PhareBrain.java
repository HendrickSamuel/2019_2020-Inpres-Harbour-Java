/******************************************************/
/*Auteur: Hendrick Samuel & Khamana Benedict          */
/*Groupe: 2203                                        */
/*Application: Inpres Harbour                         */
/*Date de creation: 26/04/2020                        */
/******************************************************/
package phare;

import HarbourGlobal.MyLogger;
import java.util.Vector;
import network.NetworkBasicClient;
import VehiculesMarins.Bateau;
import VehiculesMarins.BateauPeche;
import VehiculesMarins.BateauPlaisance;

/**
 *
 * @author benka
 */
public class PhareBrain {
    //<editor-fold defaultstate="collapsed" desc="Variables">
    private NetworkBasicClient _nbc;


    private Vector<Bateau> _bateauxEnAttente;
    private Bateau _bateauIdentifie;
    private int PORT_SERVICE = 50000;
    private MyLogger _logger;
    //</editor-fold>


    
    
    //<editor-fold defaultstate="collapsed" desc="Constructeur">
    public PhareBrain()
    {
        //<editor-fold defaultstate="collapsed" desc="Init des variables">
        this.setBateauxEnAttente(new Vector<Bateau>());
        this.setLogger(new MyLogger());
        
        //</editor-fold>
    }
    //</editor-fold>
    
    
    
    //<editor-fold defaultstate="collapsed" desc="Méthodes">
    //<editor-fold defaultstate="collapsed" desc="Getters">
    public NetworkBasicClient getNbc() {
        return _nbc;
    }
    /*-----------------------------------------------------------*/
    public Vector<Bateau> getBateauxEnAttente() {
        return _bateauxEnAttente;
    }
    /*-----------------------------------------------------------*/
    public Bateau getBateauIdentifie() {
        return _bateauIdentifie;
    }
    /*-----------------------------------------------------------*/
    public MyLogger getLogger() {
        return _logger;
    }    
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Setters">
    public void setNbc(NetworkBasicClient nbc) {
        this._nbc = nbc;
    }
    /*-----------------------------------------------------------*/
    public void setBateauxEnAttente(Vector<Bateau> _bateauxEnAttente) {
        this._bateauxEnAttente = _bateauxEnAttente;
    }
    /*-----------------------------------------------------------*/
    public void setBateauIdentifie(Bateau _bateauIdentifie) {
        this._bateauIdentifie = _bateauIdentifie;
    }
    /*-----------------------------------------------------------*/
    public void setLogger(MyLogger _logger) {
        this._logger = _logger;
    }    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Publique">
    public boolean connexionServeur()
    {
        if(this._nbc == null)
        {
            this.setNbc(new NetworkBasicClient("localhost", PORT_SERVICE));
            return true;
        }
        return false;
    }
    /*-----------------------------------------------------------*/
    public boolean deconnexionServeur()
    {
        if(this._nbc != null)
        {
            this.getNbc().setEndSending();
            this._nbc = null;
            return true;
        }
        return false;
    }
    
    //</editor-fold>
    
    //</editor-fold>


}
